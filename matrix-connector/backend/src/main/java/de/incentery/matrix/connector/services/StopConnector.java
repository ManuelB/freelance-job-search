package de.incentery.matrix.connector.services;

import java.util.logging.Logger;

import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DependsOn("Connector")
public class StopConnector {

	private static Logger log = Logger.getLogger(StopConnector.class.getName());

	@Inject
	Connector connector;

	@PreDestroy
	public void shutdown() {
		log.info("Stopping connector");
		connector.preStop();
	}

}
