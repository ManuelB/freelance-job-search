sap.ui.define([
	"incentergy/base/view/AbstractAppController"
], function (AbstractAppController) {
	"use strict";

	return AbstractAppController.extend("incentergy.scopevisiochatbot.view.App", {
		getEntityName : function() {
			return "oauthscopevisiotoken";
		}
	});
}, true);
