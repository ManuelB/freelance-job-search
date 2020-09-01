package de.incentery.matrix.connector.olingo;

public class JpaODataServiceFactory extends de.incentergy.base.olingo.JpaODataServiceFactory {
	public String getPersistenceUnitName() {
		return "matrixconnector";
	}
}