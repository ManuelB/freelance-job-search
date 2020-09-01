package de.incentery.matrix.connector.jms;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import de.incentery.matrix.connector.services.Connector;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/bot/response"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "") })
public class ResponseProcessor implements MessageListener {

	private static Logger log = Logger.getLogger(ResponseProcessor.class.getName());

	@Inject
	Connector connector;

	@Override
	public void onMessage(Message message) {
		try {
			connector.sendToRoom(message.getStringProperty("Identity"), message.getStringProperty("Room"),
					message.getBody(String.class));
		} catch (JMSException e) {
			log.log(Level.WARNING, "Could not process message", e);
		}

	}

}
