sap.ui.define([
	"incentergy/base/view/AbstractAppController",
	"sap/m/MessageBox"
], function (AbstractAppController, MessageBox) {
	"use strict";

	return AbstractAppController.extend("incentergy.scopevisiochatbot.view.App", {
		onInit : function() {
			let oOwnerComponent = this.getOwnerComponent();
			oOwnerComponent.getRouter().getRoute("import-sales-projects").attachMatched(function (oEvent) {
				fetch("/scopevisio-chatbot-backend/Scopevisio/projects", {
					"method": "POST",
					"body": JSON.stringify({
					   "page":0,
					   "pageSize":500,
					   "fields":[
					      "id",
					      "organisation",
					      "status",
					      "statusDisplay",
					      "status2",
					      "phase",
					      "name",
					      "category",
					      "createdTs",
					      "modifiedTs",
						  "description"
					   ],
					   "search":[
					      {
					         "field":"category",
					         "value":"Vertriebsprojekt",
					         "operator":"equals"
					      },
					      {
					        "field":"customBoolean1",
						 	"value": true,
						 	"operator": "equals"
					      }
					   ]
					}),
					"headers": {
						"Content-Type": "application/json",
						"Accept": "application/json",
						"Authorization": "Bearer "+sap.ui.getCore().getComponent("root-base").getJwtToken()
					}
				}).then(r => r.json()).then(projects => {
					Promise.all(
						projects.records.map(oProject => fetch("/scopevisio-chatbot-backend/Scopevisio/project/"+oProject.id+"/comments", {
							"method": "POST",
							"body": "{}",
							"headers": {
								"Content-Type": "application/json",
								"Accept": "application/json",
								"Authorization": "Bearer "+sap.ui.getCore().getComponent("root-base").getJwtToken()
							}
						}).then(o => o.json()).then(aComments => {
							oProject["comments"] = aComments["records"];
							return oProject;
						}))
					).then(aProjectsWithComments => {
						sap.ui.getCore().getEventBus().publish("incentergy.scopevisiochatbot", "import-sales-projects", {"records": aProjectsWithComments});
						MessageBox.information("Projects successfully loaded");
					})
				}).catch(e => {
					MessageBox.error("Error during loading of projects: "+e);
				});
			}.bind(this));
		},
		getEntityName : function() {
			return "oauthscopevisiotoken";
		}
	});
}, true);
