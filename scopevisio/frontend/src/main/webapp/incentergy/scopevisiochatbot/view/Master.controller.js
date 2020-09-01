sap.ui.define([
	"incentergy/base/view/AbstractMasterController"
], function (AbstractMasterController) {
	"use strict";

	return AbstractMasterController.extend("incentergy.scopevisiochatbot.view.Master", {
		getEntityName: function() {
			return "oauthscopevisiotoken";
		},
		getPackageName: function() {
			return "scopevisiochatbot";
		},
		getSortField: function() {
			return "Access_token";
		},
		onConnectScopeVisio: function() {
			const botIdentity = this.byId("matrixIdentity").getSelectedKey();
			window.__scopevisioOAuthCallback = (oAuthTokenId) => {
				 this.getView().getModel().read("/OAuthScopeVisioTokens('"+oAuthTokenId+"')", {
					"success": () => {
						this.getView().getModel().setProperty("/OAuthScopeVisioTokens('"+oAuthTokenId+"')/BotIdentity", botIdentity);
						this.getView().getModel().submitChanges();
					}
				});
				delete window.__scopevisioOAuthCallback;
				this.byId("createAndEditDialog").close();
			}
			const sJwtToken = sap.ui.getCore().getComponent("root-base").getJwtToken();
			window.open("/scopevisio-chatbot-backend/Services/OAuthScopeVisio?jwtToken="+sJwtToken, "OAuthPopup", "menubar=no,location=yes,resizable=yes,scrollbars=yes,status=yes");
		}
	});
}, true);
