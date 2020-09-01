package de.incentergy.scopevisio.jms;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.logging.LoggingFeature;

import de.incentergy.scopevisio.entities.OAuthScopeVisioToken;
import de.incentergy.scopevisio.model.Project;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/bot/request"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "") })
public class ProjectAnswerer implements MessageListener {

	private final static Logger log = Logger.getLogger(ProjectAnswerer.class.getName());
	private final static Pattern PROJECT_PATTERN = Pattern.compile("/project (\\d+) ?(.*)");

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
				Matcher m = PROJECT_PATTERN.matcher(text);
				if (m.matches()) {
					String projectId = m.group(1);
					String botIdentity = message.getStringProperty("Identity");
					String fields = m.group(2).isEmpty() ? "name" : m.group(2);
					OAuthScopeVisioToken o = em
							.createNamedQuery("OAuthScopeVisioToken.findByBotIdentity", OAuthScopeVisioToken.class)
							.setParameter("botIdentity", botIdentity).getSingleResult();
					Client client = ClientBuilder.newClient()
							.register(new LoggingFeature(Logger.getLogger(ProjectAnswerer.class.getName()), Level.INFO,
									LoggingFeature.Verbosity.PAYLOAD_TEXT, 8192));
					Project project = client.target("https://appload.scopevisio.com/rest").path("/project")
							.queryParam("fields", fields).path(projectId).request(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + o.getAccessToken())
							.get().readEntity(Project.class);

					String projectString = Arrays.asList(projectBeanInfo.getPropertyDescriptors()).stream()
							.filter(pd -> {
									return fields.contains(pd.getName());
								}).map(pd -> pd.getReadMethod()).map(read -> {
								try {
									return read.invoke(project);
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									log.log(Level.SEVERE, "Could not call method", e);
									return "";
								}
							}).map(ob -> ob == null ? "null" : ob.toString()).collect(Collectors.joining(", "));
					context.createProducer().setProperty("Identity", botIdentity)
							.setProperty("Room", message.getStringProperty("Room"))
							.send(message.getJMSReplyTo(), projectString);
				}
			} catch (JMSException e) {
				log.log(Level.SEVERE, "Can not get text from message", e);
			}

		}
	}

}
