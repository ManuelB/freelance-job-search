package de.incentery.matrix.connector.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.incentery.matrix.connector.entities.Identity;
import de.incentery.matrix.connector.ma1uta.SyncLoop;
import io.github.ma1uta.matrix.client.MatrixClient;
import io.github.ma1uta.matrix.client.StandaloneClient;
import io.github.ma1uta.matrix.client.model.auth.LoginResponse;
import io.github.ma1uta.matrix.client.model.sync.InviteState;
import io.github.ma1uta.matrix.client.model.sync.InvitedRoom;
import io.github.ma1uta.matrix.client.model.sync.JoinedRoom;
import io.github.ma1uta.matrix.client.sync.SyncParams;
import io.github.ma1uta.matrix.event.Event;
import io.github.ma1uta.matrix.event.RoomEncrypted;
import io.github.ma1uta.matrix.event.RoomEvent;
import io.github.ma1uta.matrix.event.RoomMember;
import io.github.ma1uta.matrix.event.RoomMessage;
import io.github.ma1uta.matrix.event.content.RoomMemberContent;
import io.github.ma1uta.matrix.event.message.Text;
import io.github.ma1uta.matrix.impl.exception.MatrixException;

@Singleton
@Startup
public class Connector {

	private static Logger log = Logger.getLogger(Connector.class.getName());

	@PersistenceContext
	EntityManager em;

	@Resource
	ManagedExecutorService managedExecutorService;

	@Inject
	private JMSContext context;

	@Resource(mappedName = "java:/jms/bot/request")
	Topic request;

	@Resource(mappedName = "java:/jms/bot/response")
	Topic response;

	Map<String, StandaloneClient> standaloneClients = new ConcurrentHashMap<>();
	boolean stop = false;

	ObjectMapper objectMapper = new ObjectMapper();

	@PostConstruct
	public void init() {
		em.createNamedQuery("Identity.findAll", Identity.class).getResultStream().map(Identity::getId)
				.forEach(this::connectIdentity);
	}

	public void preStop() {
		stop = true;
	}

	@PreDestroy
	public void shutdown() {
		standaloneClients.values().forEach(StandaloneClient::close);
	}

	@Asynchronous
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Future<?> connectIdentity(String identityId) {
		if (standaloneClients.containsKey(identityId)) {
			return null;
		}
		Identity identity = em.find(Identity.class, identityId);
		if (identity == null) {
			log.warning("Did not find identity: " + identityId);
			return null;
		}
		StandaloneClient mxClient = new StandaloneClient.Builder().domain(identity.getDomain()).build();
		standaloneClients.put(identity.toString(), mxClient);

		// login
		LoginResponse loginResponse = mxClient.auth().login(identity.getUsername(),
				identity.getPassword().toCharArray());

		log.info("Using: " + loginResponse.getAccessToken());

		SyncLoop syncLoop = new SyncLoop(mxClient.sync(), (syncResponse, syncParams) -> {
			// inbound listener to parse incoming events.
			UserTransaction ut = null;
			try {
				InitialContext ctx = new InitialContext();
				ut = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
				ut.begin();
				Identity loadedIdentity = em.find(Identity.class, identity.getId());

				syncParams.setFullState(false);

				if (syncResponse != null) {
					for (Entry<String, InvitedRoom> invitationEntry : syncResponse.getRooms().getInvite().entrySet()) {
						InvitedRoom invitation = invitationEntry.getValue();
						InviteState inviteState = invitation.getInviteState();
						String roomId = invitationEntry.getKey();
						loadedIdentity.addRoom(roomId);
						joinRoom(roomId, inviteState.getEvents(), mxClient);
					}

					for (Entry<String, JoinedRoom> roomWithMessages : syncResponse.getRooms().getJoin().entrySet()) {
						for (Event<?> event : roomWithMessages.getValue().getTimeline().getEvents()) {
							if (event instanceof RoomEncrypted) {
								RoomEncrypted roomEncrypted = (RoomEncrypted) event;
								log.info(roomEncrypted.getSender() + " " + roomEncrypted.getContent());
							} else if (event instanceof RoomMessage) {
								RoomMessage<?> roomMessage = (RoomMessage<?>) event;
								if (loadedIdentity.getProcessedRoomEvents().containsKey(roomMessage.getEventId())
										|| loadedIdentity.toString().equals(roomMessage.getSender())) {
									continue;
								} else {
									try {
										loadedIdentity.addProcessedRoomEvent(roomMessage.getEventId(),
												objectMapper.writeValueAsString(roomMessage));
									} catch (JsonProcessingException e) {
										log.log(Level.WARNING, "Could not generate JSON for room event.", e);
									}
									Object textObject = roomMessage.getContent();
									if (textObject instanceof Text) {
										Text text = (Text) textObject;
										/*
										 * try { mxClient.event().sendMessage(roomWithMessages.getKey(),
										 * text.getBody()); } catch (MatrixException me) {
										 * log.warning("Could not send message: " + me.getMessage()); }
										 */
										log.log(Level.FINE, "Sending jms text message for identity: {0} {1}",
												new Object[] { identity.toString(), text.getBody() });
										context.createProducer().setProperty("Identity", identity.toString())
												.setProperty("Room", roomWithMessages.getKey())
												.setProperty("Sender", roomMessage.getSender())
												.setProperty("EventId", roomMessage.getEventId())
												.setProperty("Type", roomMessage.getType())
												.setJMSReplyTo(response).send(request, text.getBody());
									}
								}

							}
						}
					}
				}
				ut.commit();
			} catch (Exception ex) {
				if (ut != null) {
					try {
						ut.rollback();
					} catch (IllegalStateException | SecurityException | SystemException e) {
						log.log(Level.SEVERE, "Could not rollback transaction", e);
					}
				}
				log.log(Level.SEVERE, "Could not process matrix.org events", ex);
			} finally {
				if (stop) {
					syncParams.setTerminate(true);
				}
			}
		});

		// Set initial parameters (Optional).
		SyncParams params = SyncParams.builder()
				/*
				 * .fullState(true) .nextBatch("s123") // set initial batch_token (optional)
				 * .fullState(true) // retrieve full state or not .filter("myFilter") // filter
				 * the received events (optional) .presence(null) // set presence "offline" or
				 * null (optional)
				 * 
				 * (recommended to set bigger than 0 // to avoid spam server)
				 */
				.timeout((long) (10 * 1000)) // set long-polling delay in milliseconds
				.build();

		syncLoop.setInit(params);
		return managedExecutorService.submit(syncLoop);
	}

	public boolean joinRoom(String roomId, List<Event> eventList, StandaloneClient mxClient) {
		log.fine("Start joining.");
		boolean joined = false;
		List<Event> inviteEvents = eventList.stream().peek(state -> {
			log.fine("Event type: " + state.getType());
		}).filter(state -> {
			if (state instanceof RoomMember) {
				RoomMember roomMember = (RoomMember) state;
				String membership = roomMember.getContent().getMembership();
				log.fine("Membership: " + membership);
				return RoomMemberContent.INVITE.equals(membership);
			}
			return false;
		}).collect(Collectors.toList());

		for (Event state : inviteEvents) {
			if (state instanceof RoomEvent) {
				log.fine("Join to room" + roomId);
				try {
					mxClient.room().joinByIdOrAlias(roomId, null, null);
				} catch (MatrixException ex) {
					log.warning("Could not join " + roomId);
				}

				log.fine("Finish joining");
				joined = true;
			}
		}
		return joined;
	}

	public void sendToRoom(String identity, String room, String message) {
		try {
			MatrixClient mxClient = standaloneClients.get(identity);
			mxClient.event().sendMessage(room, message);
		} catch (MatrixException me) {
			log.warning("Could not send message: " + me.getMessage());
		}
	}
}
