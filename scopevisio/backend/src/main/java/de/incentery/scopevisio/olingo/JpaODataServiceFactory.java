package de.incentery.scopevisio.olingo;

public class JpaODataServiceFactory extends de.incentergy.base.olingo.JpaODataServiceFactory {
	public String getPersistenceUnitName() {
		return "scopevisiochatbot";
	}
}