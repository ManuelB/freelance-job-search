package de.incentergy.scopevisio.proxy;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.glassfish.jersey.logging.LoggingFeature;

import de.incentergy.scopevisio.entities.OAuthScopeVisioToken;
import de.incentergy.scopevisio.jms.ProjectAnswerer;

@Stateless
@Path("/")
public class Proxy {

	@Context
	HttpHeaders httpHeaders;

	@PersistenceContext
	EntityManager em;

	@Inject
	JsonWebToken jsonWebToken;

	private Builder builder(List<PathSegment> pathSegments) {
		Client client = ClientBuilder.newClient()
				.register(new LoggingFeature(Logger.getLogger(ProjectAnswerer.class.getName()), Level.INFO,
						LoggingFeature.Verbosity.PAYLOAD_TEXT, 8192));

		OAuthScopeVisioToken o = em.createNamedQuery("OAuthScopeVisioToken.findByOwner", OAuthScopeVisioToken.class)
				.setParameter("owner", jsonWebToken.getSubject()).getSingleResult();

		return client.target("https://appload.scopevisio.com/rest/")
				.path(pathSegments.stream().map(ps -> ps.getPath()).collect(Collectors.joining("/")))
				.request(httpHeaders.getHeaderString("Accept"))
				.header("Authorization", "Bearer " + o.getAccessToken());
	}

	@GET
	@Path("/{pathSegments: .*}")
	public Response get(@Encoded @PathParam("pathSegments") final List<PathSegment> pathSegments) {
		return builder(pathSegments).get();
	}

	@POST
	@Path("/{pathSegments: .*}")
	public Response post(@Encoded @PathParam("pathSegments") final List<PathSegment> pathSegments, String body) {
		return builder(pathSegments).post(Entity.entity(body, httpHeaders.getHeaderString("Content-Type")));
	}

	@PUT
	@Path("/{pathSegments: .*}")
	public Response put(@Encoded @PathParam("pathSegments") final List<PathSegment> pathSegments, String body) {
		return builder(pathSegments).put(Entity.entity(body, httpHeaders.getHeaderString("Content-Type")));
	}

	@DELETE
	@Path("/{pathSegments: .*}")
	public Response delete(@Encoded @PathParam("pathSegments") final List<PathSegment> pathSegments) {
		return builder(pathSegments).delete();
	}
}
