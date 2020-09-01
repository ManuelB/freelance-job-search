package de.incentergy.scopevisio.jaxrs;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.jwt.principal.JWTAuthContextInfo;
import org.eclipse.microprofile.jwt.principal.JWTCallerPrincipal;
import org.eclipse.microprofile.jwt.principal.JWTCallerPrincipalFactory;
import org.eclipse.microprofile.jwt.principal.ParseException;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;

import de.incentergy.scopevisio.entities.OAuthScopeVisioToken;
import de.incentergy.scopevisio.scribe.ScopeVisioApi;

@Stateless
@Path("/OAuthScopeVisio")
public class OAuthScopeVisio {

	private static final Logger log = Logger.getLogger(OAuthScopeVisio.class.getName());
	
	@Context
	UriInfo uriInfo;

	OAuth20Service service = new ServiceBuilder("incentergy").apiSecret("c1341d33-8ae0-41d3-8a02-52447f76b596")
			.build(ScopeVisioApi.instance());

	@PersistenceContext
	EntityManager em;
	
	@Inject
    JWTAuthContextInfo authContextInfo;

	@GET
	public Response get(@QueryParam("jwtToken") String jwtToken) {

		Map<String, String> additionalParams = new HashMap<>();
		try {
			additionalParams.put("redirect_uri", uriInfo.getAbsolutePathBuilder()
					.path(OAuthScopeVisio.class.getDeclaredMethod("callback", String.class, String.class)).build().toString());
			return Response.temporaryRedirect(new URI(
					service.createAuthorizationUrlBuilder().additionalParams(additionalParams).state(jwtToken).build()))
					.build();
		} catch (NoSuchMethodException | SecurityException | URISyntaxException e) {
			return Response.serverError().entity(e).build();
		}
	}

	@GET
	@Path("/callback")
	public Response callback(@QueryParam("code") String code, @QueryParam("state") String jwtToken)
			throws IOException, InterruptedException, ExecutionException {

		OAuth2AccessToken accessToken = service.getAccessToken(code);
		
		OAuthScopeVisioToken oAuthScopeVisioToken = new OAuthScopeVisioToken(accessToken);
		
		JWTCallerPrincipalFactory factory = JWTCallerPrincipalFactory.instance();
        try {
			JsonWebToken jsonWebToken = factory.parse(jwtToken, authContextInfo);
			oAuthScopeVisioToken.setOwner(jsonWebToken.getSubject());
		} catch (ParseException e) {
			log.log(Level.WARNING, "Could not add owner to OAuthScopeVisioToken", e);
		}
		
		em.persist(oAuthScopeVisioToken);

		return Response.ok("<!doctype html>\n" + "<html lang=\"en-US\">\n" + "<title> OAuth2 Redirect</title>\n"
				+ "<body onload=\"run()\">\n" + "</body>\n" + "</html>\n" + "<script>\n" + "    'use strict';\n"
				+ "    function run () { debugger; window.opener.__scopevisioOAuthCallback(\"" + oAuthScopeVisioToken.getId()
				+ "\"); window.close(); }</script><body></html>", "text/html").build();
	}
}
