package de.incentery.matrix.connector.entities;

import javax.inject.Inject;
import javax.persistence.PostPersist;

import de.incentery.matrix.connector.services.Connector;

public class IdentityListener {
	
	@Inject
	Connector connector;
	
	@PostPersist
	public void connectIdentity(Identity identity) {
		connector.connectIdentity(identity.getId());
	}
}
