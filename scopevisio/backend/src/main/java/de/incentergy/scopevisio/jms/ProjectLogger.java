package de.incentergy.scopevisio.jms;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.logging.LoggingFeature;

import de.incentergy.scopevisio.entities.OAuthScopeVisioToken;
import de.incentergy.scopevisio.entities.Room2Project;
import de.incentergy.scopevisio.model.Project;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/bot/request"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "") })
public class ProjectLogger implements MessageListener {

	private final static Logger log = Logger.getLogger(ProjectLogger.class.getName());
	private final static Pattern SET_PROJECT_PATTERN = Pattern.compile("/setproject (\\d+)");

	@PersistenceContext
	EntityManager em;

	@Inject
	private JMSContext context;

	static BeanInfo projectBeanInfo;
	static {
		try {
			projectBeanInfo = Introspector.getBeanInfo(Project.class);
		} catch (IntrospectionException e) {
			log.log(Level.WARNING, "Could not get projectBeanInfo", e);
		}
	}

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			String text;
			try {
				text = ((TextMessage) message).getText();
				Matcher m = SET_PROJECT_PATTERN.matcher(text);
				String room = message.getStringProperty("Room");
				if (m.matches()) {
					Long projectId = Long.parseLong(m.group(1));
					String botIdentity = message.getStringProperty("Identity");
					OAuthScopeVisioToken o = em
							.createNamedQuery("OAuthScopeVisioToken.findByBotIdentity", OAuthScopeVisioToken.class)
							.setParameter("botIdentity", botIdentity).getSingleResult();
					String replyMessage;
					try {
						Room2Project room2project = em.createNamedQuery("Room2Project.findByroomId", Room2Project.class)
								.setParameter("roomId", room).getSingleResult();
						room2project.setProjectId(projectId);
						replyMessage = "Updated room to " + projectId;
					} catch (NoResultException nr) {
						o.addRoom2project(room, projectId);
						replyMessage = "Conntected room to " + projectId;
					}

					context.createProducer().setProperty("Identity", botIdentity)
							.setProperty("Room", message.getStringProperty("Room"))
							.send(message.getJMSReplyTo(), replyMessage);
				} else {
					try {
						String projectNote = message.getStringProperty("Room") + " "
								+ message.getStringProperty("Sender") + ": " + text;
						Room2Project room2project = em.createNamedQuery("Room2Project.findByroomId", Room2Project.class)
								.setParameter("roomId", room).getSingleResult();
						Client client = ClientBuilder.newClient()
								.register(new LoggingFeature(Logger.getLogger(ProjectAnswerer.class.getName()),
										Level.INFO, LoggingFeature.Verbosity.PAYLOAD_TEXT, 8192));
						client.target("https://appload.scopevisio.com/rest").path("/project")
								.path(room2project.getProjectId().toString()).path("/comment/new")
								.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
								.header("Authorization",
										"Bearer " + room2project.getoAuthScopeVisioToken().getAccessToken())
								.post(Entity.json("{\n" + "  \"category\": \"Notiz\",\n" + "  \"body\": \""
										+ projectNote.replace("\"", "\\\"") + "\"\n" + "}"));
					} catch (NoResultException nr) {
						log.log(Level.FINE, "Room not connected to a project", nr);
					}
				}
			} catch (JMSException e) {
				log.log(Level.SEVERE, "Can not get text from message", e);
			}

		}
	}

}
