package de.incentergy.bot.jms;

import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;

@JMSDestinationDefinitions({
	@JMSDestinationDefinition(name = "java:/jms/bot/request", interfaceName = "javax.jms.Topic", destinationName = "bot-request"),
	@JMSDestinationDefinition(name = "java:/jms/bot/response", interfaceName = "javax.jms.Topic", destinationName = "bot-response")
	})
public class Topics {

}
