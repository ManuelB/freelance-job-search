package de.incentergy.scopevisio.scribe;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.oauth2.clientauthentication.ClientAuthentication;
import com.github.scribejava.core.oauth2.clientauthentication.RequestBodyAuthenticationScheme;

public class ScopeVisioApi extends DefaultApi20 {

	private static class InstanceHolder {
		private static final ScopeVisioApi INSTANCE = new ScopeVisioApi();
	}

	public static ScopeVisioApi instance() {
		return InstanceHolder.INSTANCE;
	}

	@Override
	public String getAccessTokenEndpoint() {
		return "https://appload.scopevisio.com/rest/token";
	}

	@Override
	protected String getAuthorizationBaseUrl() {
		return "https://appload.scopevisio.com/static/authorize.html";
	}
	
	@Override
	public ClientAuthentication getClientAuthentication() {
		return RequestBodyAuthenticationScheme.instance();
	}
	
	

}
