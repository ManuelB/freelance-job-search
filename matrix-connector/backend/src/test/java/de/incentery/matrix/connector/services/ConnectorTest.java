package de.incentery.matrix.connector.services;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import de.incentery.matrix.connector.Data;

class ConnectorTest {

	@Test
	void testConnectIdentity() throws InterruptedException, ExecutionException {
		Connector connector = new Connector();

		connector.managedExecutorService = new MockedManagedExecutorService();

		connector.connectIdentity(Data.getConsultingNetworkBot().getId()).get();
		
	}

}
