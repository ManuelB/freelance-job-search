sap.ui.define([
	"incentergy/base/view/AbstractAppController"
], function (AbstractAppController) {
	"use strict";

	return AbstractAppController.extend("incentergy.matrixconnector.view.App", {
		getEntityName : function() {
			return "identity";
		}
	});
}, true);
