sap.ui.define([
	"incentergy/base/view/AbstractDetailController",
	"sap/ui/model/Context"
], function (AbstractDetailController, Context) {
	"use strict";

	return AbstractDetailController.extend("incentergy.matrixconnector.view.Detail", {
		getEntityName : function () {
			return "identity";
		},
		formatDate: function(sContent) {
			return new Date(JSON.parse(sContent).origin_server_ts);
		},
		formatSender: function(sContent) {
			return JSON.parse(sContent).sender;
		},
		formatText: function(sContent) {
			return JSON.parse(sContent).content.body;
		}
	});
}, true);
