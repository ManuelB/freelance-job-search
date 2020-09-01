sap.ui.define([
	"incentergy/base/view/AbstractMasterController"
], function (AbstractMasterController) {
	"use strict";

	return AbstractMasterController.extend("incentergy.matrixconnector.view.Master", {
		getEntityName: function() {
			return "identity";
		},
		getSortField: function() {
			return "Username";
		}
	});
}, true);
