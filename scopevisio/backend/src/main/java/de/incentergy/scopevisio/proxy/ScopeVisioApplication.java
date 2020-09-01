package de.incentergy.scopevisio.proxy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.jwt.jaxrs.JWTAuthFilter;

@ApplicationPath("/ScopeVisio")
public class ScopeVisioApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		// only allow authenticated requests with a Authorization Bearer JWT Token
		set.add(JWTAuthFilter.class);
		set.add(Proxy.class);
		return set;
	}
}
