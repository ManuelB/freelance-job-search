package de.incentery.matrix.connector.olingo;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.rest.app.AbstractODataApplication;
import org.eclipse.microprofile.jwt.jaxrs.JWTAuthFilter;

/**
 * Configures a JAX-RS endpoint base on an Olingo application.
 * 
 * This endpoint will create an OData interface for all entities
 * in this web application archive.
 * 
 * Further by adding JWTAuthFilter the system will only
 * allow requests with a valid JWT token.
 *
 * @author Manuel Blechschmidt <manuel.blechschmidt@incentergy.de>
 */
@ApplicationPath("Data.svc")
public class DataApplication extends AbstractODataApplication {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = super.getClasses();
		// only allow authenticated requests with a Authorization Bearer JWT Token
		set.add(JWTAuthFilter.class);
		return set;
	}

	@Override
	public Class<? extends ODataServiceFactory> getServiceFactoryClass() {
		return JpaODataServiceFactory.class;
	}
}