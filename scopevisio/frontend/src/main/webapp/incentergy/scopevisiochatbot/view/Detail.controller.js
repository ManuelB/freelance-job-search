sap.ui.define([
	"incentergy/base/view/AbstractDetailController"
], function (AbstractDetailController) {
	"use strict";

	return AbstractDetailController.extend("incentergy.scopevisiochatbot.view.Detail", {
		getEntityName : function () {
			return "oauthscopevisiotoken";
		}
	});
}, true);
