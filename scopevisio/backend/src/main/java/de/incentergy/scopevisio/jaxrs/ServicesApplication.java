package de.incentergy.scopevisio.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/Services")
public class ServicesApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		// only allow authenticated requests with a Authorization Bearer JWT Token
		set.add(OAuthScopeVisio.class);
		return set;
	}
}
