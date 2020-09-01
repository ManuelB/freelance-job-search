package de.incentergy.scopevisio.model;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "organisation", "parentId", "projectFileMigrated", "sales", "createdTs", "modifiedTs",
		"creatorUid", "creatorName", "modifierUid", "modifierName", "ownerName", "status", "statusDisplay", "type",
		"number", "closedByUid", "closedByName", "closedReason", "legacyNumber", "contactPerson", "contactPersonName",
		"name", "description", "language", "currency", "startTs", "endTs", "estimatedHours", "estimatedHoursMode",
		"billingNumber", "decisionTs", "billable", "timeRecordable", "timeRecordType", "hoursPerDay",
		"percentTasksDone", "percentInvoiced", "percentPaid", "taskCount", "taskOpenCount", "taskDoneCount",
		"opportunityCount", "opportunitySumNet", "opportunitySum", "opportunitySumWeighted", "opportunitySumWeighted2",
		"opportunitySumAsIfSoldWeighted", "opportunitySumAsIfSoldWeighted2", "opportunitySumRatio1",
		"opportunitySumRatio2", "opportunityLastModifiedTs", "opportunityDocumentNumbers", "offerCount", "offerSumNet",
		"offerSum", "offerSumWeighted", "offerSumWeighted2", "offerSumAsIfSoldWeighted", "offerSumAsIfSoldWeighted2",
		"offerSumRatio1", "offerSumRatio2", "offerLastModifiedTs", "offerDocumentNumbers", "opportunityMinDecisionDate",
		"opportunityMaxDecisionDate", "offerMinDecisionDate", "offerMaxDecisionDate", "combinedMinDecisionDate",
		"combinedMaxDecisionDate", "combinedCount", "combinedSumNet", "combinedSum", "combinedSumWeighted",
		"combinedSumWeighted2", "combinedSumAsIfSoldWeighted", "combinedSumAsIfSoldWeighted2", "combinedSumRatio1",
		"combinedSumRatio2", "orderCount", "orderSumNet", "orderSum", "orderOpenSumNet", "orderOpenSum",
		"orderLastModifiedTs", "orderDocumentNumbers", "invoiceCount", "invoicePostingCount", "invoiceSumNet",
		"invoiceSum", "invoiceOpenSum", "invoicePaidSum", "invoiceLastModifiedTs", "invoiceDocumentNumbers",
		"invoiceNextDueDate", "dispatchCount", "dispatchSumNet", "dispatchSum", "dispatchLastModifiedTs",
		"dispatchDocumentNumbers", "creditCount", "creditSumNet", "creditSum", "creditLastModifiedTs",
		"creditDocumentNumbers", "dimensionNumber1", "dimensionName1", "dimensionNumber2", "dimensionName2",
		"dimensionNumber3", "dimensionName3", "dimensionNumber4", "dimensionName4", "dimensionNumber5",
		"dimensionName5", "dimensionNumber6", "dimensionName6", "dimensionNumber7", "dimensionName7",
		"dimensionNumber8", "dimensionName8", "dimensionNumber9", "dimensionName9", "dimensionNumber10",
		"dimensionName10", "contactId", "contactName", "contactEmail", "contactSphere", "contactSphereDisplay",
		"fileIds", "centerdeviceId", "centerdeviceTenant", "centerdeviceTenantName", "lastCenterdeviceSync",
		"syncDisabled", "stopWatch", "thumb", "thumbLength", "type2", "category", "phase", "status2", "priority",
		"risk", "riskDescription", "workdaysDisplay", "workdays", "initiatorContactId", "initiatorContactName",
		"initiatorContactEmail", "contactIds", "customText1", "customBoolean1", "customAmount1", "customLong1",
		"customDate1", "customDateTime1", "customText2", "customBoolean2", "customAmount2", "customLong2",
		"customDate2", "customDateTime2", "customText3", "customBoolean3", "customAmount3", "customLong3",
		"customDate3", "customDateTime3", "customText4", "customBoolean4", "customAmount4", "customLong4",
		"customDate4", "customDateTime4", "customText5", "customBoolean5", "customAmount5", "customLong5",
		"customDate5", "customDateTime5", "customText6", "customBoolean6", "customAmount6", "customLong6",
		"customDate6", "customDateTime6", "customText7", "customBoolean7", "customAmount7", "customLong7",
		"customDate7", "customDateTime7", "customText8", "customBoolean8", "customAmount8", "customLong8",
		"customDate8", "customDateTime8", "customText9", "customBoolean9", "customAmount9", "customLong9",
		"customDate9", "customDateTime9", "customText10", "customBoolean10", "customAmount10", "customLong10",
		"customDate10", "customDateTime10", "customText11", "customBoolean11", "customAmount11", "customLong11",
		"customDate11", "customDateTime11", "customText12", "customBoolean12", "customAmount12", "customLong12",
		"customDate12", "customDateTime12", "customText13", "customBoolean13", "customAmount13", "customLong13",
		"customDate13", "customDateTime13", "customText14", "customBoolean14", "customAmount14", "customLong14",
		"customDate14", "customDateTime14", "customText15", "customBoolean15", "customAmount15", "customLong15",
		"customDate15", "customDateTime15", "customText16", "customBoolean16", "customAmount16", "customLong16",
		"customDate16", "customDateTime16", "customText17", "customBoolean17", "customAmount17", "customLong17",
		"customDate17", "customDateTime17", "customText18", "customBoolean18", "customAmount18", "customLong18",
		"customDate18", "customDateTime18", "customText19", "customBoolean19", "customAmount19", "customLong19",
		"customDate19", "customDateTime19", "customText20", "customBoolean20", "customAmount20", "customLong20",
		"customDate20", "customDateTime20", "customText21", "customBoolean21", "customAmount21", "customLong21",
		"customDate21", "customDateTime21", "customText22", "customBoolean22", "customAmount22", "customLong22",
		"customDate22", "customDateTime22", "customText23", "customBoolean23", "customAmount23", "customLong23",
		"customDate23", "customDateTime23", "customText24", "customBoolean24", "customAmount24", "customLong24",
		"customDate24", "customDateTime24", "customText25", "customBoolean25", "customAmount25", "customLong25",
		"customDate25", "customDateTime25", "customText26", "customBoolean26", "customAmount26", "customLong26",
		"customDate26", "customDateTime26", "customText27", "customBoolean27", "customAmount27", "customLong27",
		"customDate27", "customDateTime27", "customText28", "customBoolean28", "customAmount28", "customLong28",
		"customDate28", "customDateTime28", "customText29", "customBoolean29", "customAmount29", "customLong29",
		"customDate29", "customDateTime29", "customText30", "customBoolean30", "customAmount30", "customLong30",
		"customDate30", "customDateTime30", "replacementProductName", "contractObligation", "residualProductName",
		"competitionProductsName", "salesPotenzial", "salesUpgrade", "servicePartnerName", "competitiveStrength",
		"deliveryTermPriority", "deliveryTermCompleteDelivery", "deliveryTermIncoterm", "deliveryTermIncotermLocation",
		"dueDate", "reminderDate", "campaignPersonDisplay", "leadPersonId", "leadPersonDisplay",
		"leadLastSeenByLeadPerson", "leadClassification", "leadIdentification", "leadQualification",
		"leadQualificationRange", "leadBudget", "leadBudgetPoints", "leadAuthority", "leadAuthorityPoints", "leadNeed",
		"leadNeedPoints", "leadTime", "leadTimePoints", "leadSumPoints", "leadTransfer", "leadNotice", "leadBudgetSum",
		"partnerPersonDisplay", "partnerType", "partnerStatus", "partnerDateBegin", "partnerDateEnd",
		"partnerClassification", "partnerExperience", "salesPersonId", "salesPersonDisplay", "salesConsumerType",
		"salesKontaktType", "source", "salesChannel", "interestedLastSeenBySalesPerson", "salesInternalOrganisation",
		"salesNielsenRegion", "salesRegion", "salesRisk", "salesPriority", "salesBehavior", "salesPhase", "salesStatus",
		"salesActivity", "salesContractPersonName", "salesCampaignName", "salesReminderFrom", "salesReminderTo",
		"salesTemplate", "salesDescription", "segmentationAudience", "segmentationEducationalBackground",
		"segmentationIncomeGroup", "segmentationAttitude", "segmentationMotivation", "segmentationBuyingBehavior",
		"segmentationLifestyle", "segmentationCustomerBehavior", "sphereInterested", "sphereLead", "sphereCustomer",
		"sphereVendor", "sphereDebitor", "sphereKreditor", "sphereEmployee", "spherePartner", "sphereWorker",
		"statusLeadDisplay", "statusInterestedDisplay", "statusCustomerDisplay", "sphereOrganisationUser",
		"sphereImplementation", "sphereBilling", "interestedClassification", "interestedQualification",
		"interestedQualificationRange", "interestedBudget", "interestedBudgetSum", "interestedBudgetPoints",
		"interestedAuthority", "interestedAuthorityPoints", "interestedNeed", "interestedNeedPoints", "interestedTime",
		"interestedTimePoints", "interestedSumPoints", "interestedTransfer", "permissionDisplay", "ownerUid",
		"permissionType", "readPermissionProfiles", "readPermissionUids", "writePermissionProfiles",
		"writePermissionUids", "centerdeviceCollectionName", "centerdeviceCollectionId", "mail", "entryTypeDisplay",
		"entryType", "childId" })
public class Project {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("organisation")
	private Long organisation;
	@JsonProperty("parentId")
	private Object parentId;
	@JsonProperty("projectFileMigrated")
	private Object projectFileMigrated;
	@JsonProperty("sales")
	private Object sales;
	@JsonProperty("createdTs")
	private Long createdTs;
	@JsonProperty("modifiedTs")
	private Long modifiedTs;
	@JsonProperty("creatorUid")
	private String creatorUid;
	@JsonProperty("creatorName")
	private String creatorName;
	@JsonProperty("modifierUid")
	private String modifierUid;
	@JsonProperty("modifierName")
	private String modifierName;
	@JsonProperty("ownerName")
	private String ownerName;
	@JsonProperty("status")
	private Long status;
	@JsonProperty("statusDisplay")
	private String statusDisplay;
	@JsonProperty("type")
	private String type;
	@JsonProperty("number")
	private String number;
	@JsonProperty("closedByUid")
	private Object closedByUid;
	@JsonProperty("closedByName")
	private Object closedByName;
	@JsonProperty("closedReason")
	private Object closedReason;
	@JsonProperty("legacyNumber")
	private Object legacyNumber;
	@JsonProperty("contactPerson")
	private Object contactPerson;
	@JsonProperty("contactPersonName")
	private Object contactPersonName;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("language")
	private String language;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("startTs")
	private Long startTs;
	@JsonProperty("endTs")
	private Long endTs;
	@JsonProperty("estimatedHours")
	private Long estimatedHours;
	@JsonProperty("estimatedHoursMode")
	private Long estimatedHoursMode;
	@JsonProperty("billingNumber")
	private Object billingNumber;
	@JsonProperty("decisionTs")
	private Object decisionTs;
	@JsonProperty("billable")
	private String billable;
	@JsonProperty("timeRecordable")
	private String timeRecordable;
	@JsonProperty("timeRecordType")
	private String timeRecordType;
	@JsonProperty("hoursPerDay")
	private Object hoursPerDay;
	@JsonProperty("percentTasksDone")
	private Long percentTasksDone;
	@JsonProperty("percentInvoiced")
	private Long percentInvoiced;
	@JsonProperty("percentPaid")
	private Double percentPaid;
	@JsonProperty("taskCount")
	private Long taskCount;
	@JsonProperty("taskOpenCount")
	private Long taskOpenCount;
	@JsonProperty("taskDoneCount")
	private Long taskDoneCount;
	@JsonProperty("opportunityCount")
	private Object opportunityCount;
	@JsonProperty("opportunitySumNet")
	private Object opportunitySumNet;
	@JsonProperty("opportunitySum")
	private Object opportunitySum;
	@JsonProperty("opportunitySumWeighted")
	private Object opportunitySumWeighted;
	@JsonProperty("opportunitySumWeighted2")
	private Object opportunitySumWeighted2;
	@JsonProperty("opportunitySumAsIfSoldWeighted")
	private Object opportunitySumAsIfSoldWeighted;
	@JsonProperty("opportunitySumAsIfSoldWeighted2")
	private Object opportunitySumAsIfSoldWeighted2;
	@JsonProperty("opportunitySumRatio1")
	private Long opportunitySumRatio1;
	@JsonProperty("opportunitySumRatio2")
	private Long opportunitySumRatio2;
	@JsonProperty("opportunityLastModifiedTs")
	private Object opportunityLastModifiedTs;
	@JsonProperty("opportunityDocumentNumbers")
	private String opportunityDocumentNumbers;
	@JsonProperty("offerCount")
	private Object offerCount;
	@JsonProperty("offerSumNet")
	private Object offerSumNet;
	@JsonProperty("offerSum")
	private Object offerSum;
	@JsonProperty("offerSumWeighted")
	private Object offerSumWeighted;
	@JsonProperty("offerSumWeighted2")
	private Object offerSumWeighted2;
	@JsonProperty("offerSumAsIfSoldWeighted")
	private Object offerSumAsIfSoldWeighted;
	@JsonProperty("offerSumAsIfSoldWeighted2")
	private Object offerSumAsIfSoldWeighted2;
	@JsonProperty("offerSumRatio1")
	private Long offerSumRatio1;
	@JsonProperty("offerSumRatio2")
	private Long offerSumRatio2;
	@JsonProperty("offerLastModifiedTs")
	private Object offerLastModifiedTs;
	@JsonProperty("offerDocumentNumbers")
	private String offerDocumentNumbers;
	@JsonProperty("opportunityMinDecisionDate")
	private Object opportunityMinDecisionDate;
	@JsonProperty("opportunityMaxDecisionDate")
	private Object opportunityMaxDecisionDate;
	@JsonProperty("offerMinDecisionDate")
	private Object offerMinDecisionDate;
	@JsonProperty("offerMaxDecisionDate")
	private Object offerMaxDecisionDate;
	@JsonProperty("combinedMinDecisionDate")
	private Object combinedMinDecisionDate;
	@JsonProperty("combinedMaxDecisionDate")
	private Object combinedMaxDecisionDate;
	@JsonProperty("combinedCount")
	private Long combinedCount;
	@JsonProperty("combinedSumNet")
	private Long combinedSumNet;
	@JsonProperty("combinedSum")
	private Long combinedSum;
	@JsonProperty("combinedSumWeighted")
	private Long combinedSumWeighted;
	@JsonProperty("combinedSumWeighted2")
	private Long combinedSumWeighted2;
	@JsonProperty("combinedSumAsIfSoldWeighted")
	private Long combinedSumAsIfSoldWeighted;
	@JsonProperty("combinedSumAsIfSoldWeighted2")
	private Long combinedSumAsIfSoldWeighted2;
	@JsonProperty("combinedSumRatio1")
	private Long combinedSumRatio1;
	@JsonProperty("combinedSumRatio2")
	private Long combinedSumRatio2;
	@JsonProperty("orderCount")
	private Object orderCount;
	@JsonProperty("orderSumNet")
	private Object orderSumNet;
	@JsonProperty("orderSum")
	private Object orderSum;
	@JsonProperty("orderOpenSumNet")
	private Double orderOpenSumNet;
	@JsonProperty("orderOpenSum")
	private Double orderOpenSum;
	@JsonProperty("orderLastModifiedTs")
	private Object orderLastModifiedTs;
	@JsonProperty("orderDocumentNumbers")
	private String orderDocumentNumbers;
	@JsonProperty("invoiceCount")
	private Long invoiceCount;
	@JsonProperty("invoicePostingCount")
	private Long invoicePostingCount;
	@JsonProperty("invoiceSumNet")
	private Double invoiceSumNet;
	@JsonProperty("invoiceSum")
	private Double invoiceSum;
	@JsonProperty("invoiceOpenSum")
	private Long invoiceOpenSum;
	@JsonProperty("invoicePaidSum")
	private Double invoicePaidSum;
	@JsonProperty("invoiceLastModifiedTs")
	private Long invoiceLastModifiedTs;
	@JsonProperty("invoiceDocumentNumbers")
	private String invoiceDocumentNumbers;
	@JsonProperty("invoiceNextDueDate")
	private Object invoiceNextDueDate;
	@JsonProperty("dispatchCount")
	private Object dispatchCount;
	@JsonProperty("dispatchSumNet")
	private Object dispatchSumNet;
	@JsonProperty("dispatchSum")
	private Object dispatchSum;
	@JsonProperty("dispatchLastModifiedTs")
	private Object dispatchLastModifiedTs;
	@JsonProperty("dispatchDocumentNumbers")
	private String dispatchDocumentNumbers;
	@JsonProperty("creditCount")
	private Long creditCount;
	@JsonProperty("creditSumNet")
	private Double creditSumNet;
	@JsonProperty("creditSum")
	private Double creditSum;
	@JsonProperty("creditLastModifiedTs")
	private Long creditLastModifiedTs;
	@JsonProperty("creditDocumentNumbers")
	private String creditDocumentNumbers;
	@JsonProperty("dimensionNumber1")
	private Object dimensionNumber1;
	@JsonProperty("dimensionName1")
	private Object dimensionName1;
	@JsonProperty("dimensionNumber2")
	private Object dimensionNumber2;
	@JsonProperty("dimensionName2")
	private Object dimensionName2;
	@JsonProperty("dimensionNumber3")
	private Long dimensionNumber3;
	@JsonProperty("dimensionName3")
	private String dimensionName3;
	@JsonProperty("dimensionNumber4")
	private Object dimensionNumber4;
	@JsonProperty("dimensionName4")
	private Object dimensionName4;
	@JsonProperty("dimensionNumber5")
	private Object dimensionNumber5;
	@JsonProperty("dimensionName5")
	private Object dimensionName5;
	@JsonProperty("dimensionNumber6")
	private Object dimensionNumber6;
	@JsonProperty("dimensionName6")
	private Object dimensionName6;
	@JsonProperty("dimensionNumber7")
	private Object dimensionNumber7;
	@JsonProperty("dimensionName7")
	private Object dimensionName7;
	@JsonProperty("dimensionNumber8")
	private Object dimensionNumber8;
	@JsonProperty("dimensionName8")
	private Object dimensionName8;
	@JsonProperty("dimensionNumber9")
	private Object dimensionNumber9;
	@JsonProperty("dimensionName9")
	private Object dimensionName9;
	@JsonProperty("dimensionNumber10")
	private Object dimensionNumber10;
	@JsonProperty("dimensionName10")
	private Object dimensionName10;
	@JsonProperty("contactId")
	private Long contactId;
	@JsonProperty("contactName")
	private String contactName;
	@JsonProperty("contactEmail")
	private Object contactEmail;
	@JsonProperty("contactSphere")
	private String contactSphere;
	@JsonProperty("contactSphereDisplay")
	private String contactSphereDisplay;
	@JsonProperty("fileIds")
	private Object fileIds;
	@JsonProperty("centerdeviceId")
	private Object centerdeviceId;
	@JsonProperty("centerdeviceTenant")
	private Object centerdeviceTenant;
	@JsonProperty("centerdeviceTenantName")
	private Object centerdeviceTenantName;
	@JsonProperty("lastCenterdeviceSync")
	private Object lastCenterdeviceSync;
	@JsonProperty("syncDisabled")
	private Object syncDisabled;
	@JsonProperty("stopWatch")
	private Object stopWatch;
	@JsonProperty("thumb")
	private Object thumb;
	@JsonProperty("thumbLength")
	private Object thumbLength;
	@JsonProperty("type2")
	private String type2;
	@JsonProperty("category")
	private String category;
	@JsonProperty("phase")
	private String phase;
	@JsonProperty("status2")
	private String status2;
	@JsonProperty("priority")
	private String priority;
	@JsonProperty("risk")
	private String risk;
	@JsonProperty("riskDescription")
	private Object riskDescription;
	@JsonProperty("workdaysDisplay")
	private String workdaysDisplay;
	@JsonProperty("workdays")
	private Long workdays;
	@JsonProperty("initiatorContactId")
	private Long initiatorContactId;
	@JsonProperty("initiatorContactName")
	private String initiatorContactName;
	@JsonProperty("initiatorContactEmail")
	private Object initiatorContactEmail;
	@JsonProperty("contactIds")
	private Object contactIds;
	@JsonProperty("customText1")
	private Object customText1;
	@JsonProperty("customBoolean1")
	private Object customBoolean1;
	@JsonProperty("customAmount1")
	private Object customAmount1;
	@JsonProperty("customLong1")
	private Object customLong1;
	@JsonProperty("customDate1")
	private Object customDate1;
	@JsonProperty("customDateTime1")
	private Object customDateTime1;
	@JsonProperty("customText2")
	private Object customText2;
	@JsonProperty("customBoolean2")
	private Object customBoolean2;
	@JsonProperty("customAmount2")
	private Object customAmount2;
	@JsonProperty("customLong2")
	private Object customLong2;
	@JsonProperty("customDate2")
	private Object customDate2;
	@JsonProperty("customDateTime2")
	private Object customDateTime2;
	@JsonProperty("customText3")
	private Object customText3;
	@JsonProperty("customBoolean3")
	private Object customBoolean3;
	@JsonProperty("customAmount3")
	private Object customAmount3;
	@JsonProperty("customLong3")
	private Object customLong3;
	@JsonProperty("customDate3")
	private Object customDate3;
	@JsonProperty("customDateTime3")
	private Object customDateTime3;
	@JsonProperty("customText4")
	private Object customText4;
	@JsonProperty("customBoolean4")
	private Object customBoolean4;
	@JsonProperty("customAmount4")
	private Object customAmount4;
	@JsonProperty("customLong4")
	private Object customLong4;
	@JsonProperty("customDate4")
	private Object customDate4;
	@JsonProperty("customDateTime4")
	private Object customDateTime4;
	@JsonProperty("customText5")
	private Object customText5;
	@JsonProperty("customBoolean5")
	private Object customBoolean5;
	@JsonProperty("customAmount5")
	private Object customAmount5;
	@JsonProperty("customLong5")
	private Object customLong5;
	@JsonProperty("customDate5")
	private Object customDate5;
	@JsonProperty("customDateTime5")
	private Object customDateTime5;
	@JsonProperty("customText6")
	private Object customText6;
	@JsonProperty("customBoolean6")
	private Object customBoolean6;
	@JsonProperty("customAmount6")
	private Object customAmount6;
	@JsonProperty("customLong6")
	private Object customLong6;
	@JsonProperty("customDate6")
	private Object customDate6;
	@JsonProperty("customDateTime6")
	private Object customDateTime6;
	@JsonProperty("customText7")
	private Object customText7;
	@JsonProperty("customBoolean7")
	private Object customBoolean7;
	@JsonProperty("customAmount7")
	private Object customAmount7;
	@JsonProperty("customLong7")
	private Object customLong7;
	@JsonProperty("customDate7")
	private Object customDate7;
	@JsonProperty("customDateTime7")
	private Object customDateTime7;
	@JsonProperty("customText8")
	private Object customText8;
	@JsonProperty("customBoolean8")
	private Object customBoolean8;
	@JsonProperty("customAmount8")
	private Object customAmount8;
	@JsonProperty("customLong8")
	private Object customLong8;
	@JsonProperty("customDate8")
	private Object customDate8;
	@JsonProperty("customDateTime8")
	private Object customDateTime8;
	@JsonProperty("customText9")
	private Object customText9;
	@JsonProperty("customBoolean9")
	private Object customBoolean9;
	@JsonProperty("customAmount9")
	private Object customAmount9;
	@JsonProperty("customLong9")
	private Object customLong9;
	@JsonProperty("customDate9")
	private Object customDate9;
	@JsonProperty("customDateTime9")
	private Object customDateTime9;
	@JsonProperty("customText10")
	private Object customText10;
	@JsonProperty("customBoolean10")
	private Object customBoolean10;
	@JsonProperty("customAmount10")
	private Object customAmount10;
	@JsonProperty("customLong10")
	private Object customLong10;
	@JsonProperty("customDate10")
	private Object customDate10;
	@JsonProperty("customDateTime10")
	private Object customDateTime10;
	@JsonProperty("customText11")
	private Object customText11;
	@JsonProperty("customBoolean11")
	private Object customBoolean11;
	@JsonProperty("customAmount11")
	private Object customAmount11;
	@JsonProperty("customLong11")
	private Object customLong11;
	@JsonProperty("customDate11")
	private Object customDate11;
	@JsonProperty("customDateTime11")
	private Object customDateTime11;
	@JsonProperty("customText12")
	private Object customText12;
	@JsonProperty("customBoolean12")
	private Object customBoolean12;
	@JsonProperty("customAmount12")
	private Object customAmount12;
	@JsonProperty("customLong12")
	private Object customLong12;
	@JsonProperty("customDate12")
	private Object customDate12;
	@JsonProperty("customDateTime12")
	private Object customDateTime12;
	@JsonProperty("customText13")
	private Object customText13;
	@JsonProperty("customBoolean13")
	private Object customBoolean13;
	@JsonProperty("customAmount13")
	private Object customAmount13;
	@JsonProperty("customLong13")
	private Object customLong13;
	@JsonProperty("customDate13")
	private Object customDate13;
	@JsonProperty("customDateTime13")
	private Object customDateTime13;
	@JsonProperty("customText14")
	private Object customText14;
	@JsonProperty("customBoolean14")
	private Object customBoolean14;
	@JsonProperty("customAmount14")
	private Object customAmount14;
	@JsonProperty("customLong14")
	private Object customLong14;
	@JsonProperty("customDate14")
	private Object customDate14;
	@JsonProperty("customDateTime14")
	private Object customDateTime14;
	@JsonProperty("customText15")
	private Object customText15;
	@JsonProperty("customBoolean15")
	private Object customBoolean15;
	@JsonProperty("customAmount15")
	private Object customAmount15;
	@JsonProperty("customLong15")
	private Object customLong15;
	@JsonProperty("customDate15")
	private Object customDate15;
	@JsonProperty("customDateTime15")
	private Object customDateTime15;
	@JsonProperty("customText16")
	private Object customText16;
	@JsonProperty("customBoolean16")
	private Object customBoolean16;
	@JsonProperty("customAmount16")
	private Object customAmount16;
	@JsonProperty("customLong16")
	private Object customLong16;
	@JsonProperty("customDate16")
	private Object customDate16;
	@JsonProperty("customDateTime16")
	private Object customDateTime16;
	@JsonProperty("customText17")
	private Object customText17;
	@JsonProperty("customBoolean17")
	private Object customBoolean17;
	@JsonProperty("customAmount17")
	private Object customAmount17;
	@JsonProperty("customLong17")
	private Object customLong17;
	@JsonProperty("customDate17")
	private Object customDate17;
	@JsonProperty("customDateTime17")
	private Object customDateTime17;
	@JsonProperty("customText18")
	private Object customText18;
	@JsonProperty("customBoolean18")
	private Object customBoolean18;
	@JsonProperty("customAmount18")
	private Object customAmount18;
	@JsonProperty("customLong18")
	private Object customLong18;
	@JsonProperty("customDate18")
	private Object customDate18;
	@JsonProperty("customDateTime18")
	private Object customDateTime18;
	@JsonProperty("customText19")
	private Object customText19;
	@JsonProperty("customBoolean19")
	private Object customBoolean19;
	@JsonProperty("customAmount19")
	private Object customAmount19;
	@JsonProperty("customLong19")
	private Object customLong19;
	@JsonProperty("customDate19")
	private Object customDate19;
	@JsonProperty("customDateTime19")
	private Object customDateTime19;
	@JsonProperty("customText20")
	private Object customText20;
	@JsonProperty("customBoolean20")
	private Object customBoolean20;
	@JsonProperty("customAmount20")
	private Object customAmount20;
	@JsonProperty("customLong20")
	private Object customLong20;
	@JsonProperty("customDate20")
	private Object customDate20;
	@JsonProperty("customDateTime20")
	private Object customDateTime20;
	@JsonProperty("customText21")
	private Object customText21;
	@JsonProperty("customBoolean21")
	private Object customBoolean21;
	@JsonProperty("customAmount21")
	private Object customAmount21;
	@JsonProperty("customLong21")
	private Object customLong21;
	@JsonProperty("customDate21")
	private Object customDate21;
	@JsonProperty("customDateTime21")
	private Object customDateTime21;
	@JsonProperty("customText22")
	private Object customText22;
	@JsonProperty("customBoolean22")
	private Object customBoolean22;
	@JsonProperty("customAmount22")
	private Object customAmount22;
	@JsonProperty("customLong22")
	private Object customLong22;
	@JsonProperty("customDate22")
	private Object customDate22;
	@JsonProperty("customDateTime22")
	private Object customDateTime22;
	@JsonProperty("customText23")
	private Object customText23;
	@JsonProperty("customBoolean23")
	private Object customBoolean23;
	@JsonProperty("customAmount23")
	private Object customAmount23;
	@JsonProperty("customLong23")
	private Object customLong23;
	@JsonProperty("customDate23")
	private Object customDate23;
	@JsonProperty("customDateTime23")
	private Object customDateTime23;
	@JsonProperty("customText24")
	private Object customText24;
	@JsonProperty("customBoolean24")
	private Object customBoolean24;
	@JsonProperty("customAmount24")
	private Object customAmount24;
	@JsonProperty("customLong24")
	private Object customLong24;
	@JsonProperty("customDate24")
	private Object customDate24;
	@JsonProperty("customDateTime24")
	private Object customDateTime24;
	@JsonProperty("customText25")
	private Object customText25;
	@JsonProperty("customBoolean25")
	private Object customBoolean25;
	@JsonProperty("customAmount25")
	private Object customAmount25;
	@JsonProperty("customLong25")
	private Object customLong25;
	@JsonProperty("customDate25")
	private Object customDate25;
	@JsonProperty("customDateTime25")
	private Object customDateTime25;
	@JsonProperty("customText26")
	private Object customText26;
	@JsonProperty("customBoolean26")
	private Object customBoolean26;
	@JsonProperty("customAmount26")
	private Object customAmount26;
	@JsonProperty("customLong26")
	private Object customLong26;
	@JsonProperty("customDate26")
	private Object customDate26;
	@JsonProperty("customDateTime26")
	private Object customDateTime26;
	@JsonProperty("customText27")
	private Object customText27;
	@JsonProperty("customBoolean27")
	private Object customBoolean27;
	@JsonProperty("customAmount27")
	private Object customAmount27;
	@JsonProperty("customLong27")
	private Object customLong27;
	@JsonProperty("customDate27")
	private Object customDate27;
	@JsonProperty("customDateTime27")
	private Object customDateTime27;
	@JsonProperty("customText28")
	private Object customText28;
	@JsonProperty("customBoolean28")
	private Object customBoolean28;
	@JsonProperty("customAmount28")
	private Object customAmount28;
	@JsonProperty("customLong28")
	private Object customLong28;
	@JsonProperty("customDate28")
	private Object customDate28;
	@JsonProperty("customDateTime28")
	private Object customDateTime28;
	@JsonProperty("customText29")
	private Object customText29;
	@JsonProperty("customBoolean29")
	private Object customBoolean29;
	@JsonProperty("customAmount29")
	private Object customAmount29;
	@JsonProperty("customLong29")
	private Object customLong29;
	@JsonProperty("customDate29")
	private Object customDate29;
	@JsonProperty("customDateTime29")
	private Object customDateTime29;
	@JsonProperty("customText30")
	private Object customText30;
	@JsonProperty("customBoolean30")
	private Object customBoolean30;
	@JsonProperty("customAmount30")
	private Object customAmount30;
	@JsonProperty("customLong30")
	private Object customLong30;
	@JsonProperty("customDate30")
	private Object customDate30;
	@JsonProperty("customDateTime30")
	private Object customDateTime30;
	@JsonProperty("replacementProductName")
	private Object replacementProductName;
	@JsonProperty("contractObligation")
	private Object contractObligation;
	@JsonProperty("residualProductName")
	private Object residualProductName;
	@JsonProperty("competitionProductsName")
	private Object competitionProductsName;
	@JsonProperty("salesPotenzial")
	private Object salesPotenzial;
	@JsonProperty("salesUpgrade")
	private Object salesUpgrade;
	@JsonProperty("servicePartnerName")
	private Object servicePartnerName;
	@JsonProperty("competitiveStrength")
	private Object competitiveStrength;
	@JsonProperty("deliveryTermPriority")
	private Object deliveryTermPriority;
	@JsonProperty("deliveryTermCompleteDelivery")
	private Object deliveryTermCompleteDelivery;
	@JsonProperty("deliveryTermIncoterm")
	private Object deliveryTermIncoterm;
	@JsonProperty("deliveryTermIncotermLocation")
	private Object deliveryTermIncotermLocation;
	@JsonProperty("dueDate")
	private Object dueDate;
	@JsonProperty("reminderDate")
	private Object reminderDate;
	@JsonProperty("campaignPersonDisplay")
	private Object campaignPersonDisplay;
	@JsonProperty("leadPersonId")
	private Object leadPersonId;
	@JsonProperty("leadPersonDisplay")
	private Object leadPersonDisplay;
	@JsonProperty("leadLastSeenByLeadPerson")
	private Object leadLastSeenByLeadPerson;
	@JsonProperty("leadClassification")
	private Object leadClassification;
	@JsonProperty("leadIdentification")
	private Object leadIdentification;
	@JsonProperty("leadQualification")
	private Object leadQualification;
	@JsonProperty("leadQualificationRange")
	private Object leadQualificationRange;
	@JsonProperty("leadBudget")
	private Object leadBudget;
	@JsonProperty("leadBudgetPoints")
	private Object leadBudgetPoints;
	@JsonProperty("leadAuthority")
	private Object leadAuthority;
	@JsonProperty("leadAuthorityPoints")
	private Object leadAuthorityPoints;
	@JsonProperty("leadNeed")
	private Object leadNeed;
	@JsonProperty("leadNeedPoints")
	private Object leadNeedPoints;
	@JsonProperty("leadTime")
	private Object leadTime;
	@JsonProperty("leadTimePoints")
	private Object leadTimePoints;
	@JsonProperty("leadSumPoints")
	private Object leadSumPoints;
	@JsonProperty("leadTransfer")
	private Object leadTransfer;
	@JsonProperty("leadNotice")
	private Object leadNotice;
	@JsonProperty("leadBudgetSum")
	private Object leadBudgetSum;
	@JsonProperty("partnerPersonDisplay")
	private Object partnerPersonDisplay;
	@JsonProperty("partnerType")
	private Object partnerType;
	@JsonProperty("partnerStatus")
	private Object partnerStatus;
	@JsonProperty("partnerDateBegin")
	private Object partnerDateBegin;
	@JsonProperty("partnerDateEnd")
	private Object partnerDateEnd;
	@JsonProperty("partnerClassification")
	private Object partnerClassification;
	@JsonProperty("partnerExperience")
	private Object partnerExperience;
	@JsonProperty("salesPersonId")
	private Object salesPersonId;
	@JsonProperty("salesPersonDisplay")
	private Object salesPersonDisplay;
	@JsonProperty("salesConsumerType")
	private Object salesConsumerType;
	@JsonProperty("salesKontaktType")
	private Object salesKontaktType;
	@JsonProperty("source")
	private Object source;
	@JsonProperty("salesChannel")
	private Object salesChannel;
	@JsonProperty("interestedLastSeenBySalesPerson")
	private Object interestedLastSeenBySalesPerson;
	@JsonProperty("salesInternalOrganisation")
	private Object salesInternalOrganisation;
	@JsonProperty("salesNielsenRegion")
	private Object salesNielsenRegion;
	@JsonProperty("salesRegion")
	private Object salesRegion;
	@JsonProperty("salesRisk")
	private Object salesRisk;
	@JsonProperty("salesPriority")
	private Object salesPriority;
	@JsonProperty("salesBehavior")
	private Object salesBehavior;
	@JsonProperty("salesPhase")
	private Object salesPhase;
	@JsonProperty("salesStatus")
	private Object salesStatus;
	@JsonProperty("salesActivity")
	private Object salesActivity;
	@JsonProperty("salesContractPersonName")
	private Object salesContractPersonName;
	@JsonProperty("salesCampaignName")
	private Object salesCampaignName;
	@JsonProperty("salesReminderFrom")
	private Object salesReminderFrom;
	@JsonProperty("salesReminderTo")
	private Object salesReminderTo;
	@JsonProperty("salesTemplate")
	private Object salesTemplate;
	@JsonProperty("salesDescription")
	private Object salesDescription;
	@JsonProperty("segmentationAudience")
	private Object segmentationAudience;
	@JsonProperty("segmentationEducationalBackground")
	private Object segmentationEducationalBackground;
	@JsonProperty("segmentationIncomeGroup")
	private Object segmentationIncomeGroup;
	@JsonProperty("segmentationAttitude")
	private Object segmentationAttitude;
	@JsonProperty("segmentationMotivation")
	private Object segmentationMotivation;
	@JsonProperty("segmentationBuyingBehavior")
	private Object segmentationBuyingBehavior;
	@JsonProperty("segmentationLifestyle")
	private Object segmentationLifestyle;
	@JsonProperty("segmentationCustomerBehavior")
	private Object segmentationCustomerBehavior;
	@JsonProperty("sphereInterested")
	private Object sphereInterested;
	@JsonProperty("sphereLead")
	private Object sphereLead;
	@JsonProperty("sphereCustomer")
	private Object sphereCustomer;
	@JsonProperty("sphereVendor")
	private Object sphereVendor;
	@JsonProperty("sphereDebitor")
	private Object sphereDebitor;
	@JsonProperty("sphereKreditor")
	private Object sphereKreditor;
	@JsonProperty("sphereEmployee")
	private Object sphereEmployee;
	@JsonProperty("spherePartner")
	private Object spherePartner;
	@JsonProperty("sphereWorker")
	private Object sphereWorker;
	@JsonProperty("statusLeadDisplay")
	private Object statusLeadDisplay;
	@JsonProperty("statusInterestedDisplay")
	private Object statusInterestedDisplay;
	@JsonProperty("statusCustomerDisplay")
	private Object statusCustomerDisplay;
	@JsonProperty("sphereOrganisationUser")
	private Object sphereOrganisationUser;
	@JsonProperty("sphereImplementation")
	private Object sphereImplementation;
	@JsonProperty("sphereBilling")
	private Object sphereBilling;
	@JsonProperty("interestedClassification")
	private Object interestedClassification;
	@JsonProperty("interestedQualification")
	private Object interestedQualification;
	@JsonProperty("interestedQualificationRange")
	private Object interestedQualificationRange;
	@JsonProperty("interestedBudget")
	private Object interestedBudget;
	@JsonProperty("interestedBudgetSum")
	private Object interestedBudgetSum;
	@JsonProperty("interestedBudgetPoints")
	private Object interestedBudgetPoints;
	@JsonProperty("interestedAuthority")
	private Object interestedAuthority;
	@JsonProperty("interestedAuthorityPoints")
	private Object interestedAuthorityPoints;
	@JsonProperty("interestedNeed")
	private Object interestedNeed;
	@JsonProperty("interestedNeedPoints")
	private Object interestedNeedPoints;
	@JsonProperty("interestedTime")
	private Object interestedTime;
	@JsonProperty("interestedTimePoints")
	private Object interestedTimePoints;
	@JsonProperty("interestedSumPoints")
	private Object interestedSumPoints;
	@JsonProperty("interestedTransfer")
	private Object interestedTransfer;
	@JsonProperty("permissionDisplay")
	private String permissionDisplay;
	@JsonProperty("ownerUid")
	private String ownerUid;
	@JsonProperty("permissionType")
	private Long permissionType;
	@JsonProperty("readPermissionProfiles")
	private Object readPermissionProfiles;
	@JsonProperty("readPermissionUids")
	private Object readPermissionUids;
	@JsonProperty("writePermissionProfiles")
	private Object writePermissionProfiles;
	@JsonProperty("writePermissionUids")
	private Object writePermissionUids;
	@JsonProperty("centerdeviceCollectionName")
	private Object centerdeviceCollectionName;
	@JsonProperty("centerdeviceCollectionId")
	private Object centerdeviceCollectionId;
	@JsonProperty("mail")
	private Object mail;
	@JsonProperty("entryTypeDisplay")
	private Object entryTypeDisplay;
	@JsonProperty("entryType")
	private Object entryType;
	@JsonProperty("childId")
	private Object childId;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("organisation")
	public Long getOrganisation() {
		return organisation;
	}

	@JsonProperty("organisation")
	public void setOrganisation(Long organisation) {
		this.organisation = organisation;
	}

	@JsonProperty("parentId")
	public Object getParentId() {
		return parentId;
	}

	@JsonProperty("parentId")
	public void setParentId(Object parentId) {
		this.parentId = parentId;
	}

	@JsonProperty("projectFileMigrated")
	public Object getProjectFileMigrated() {
		return projectFileMigrated;
	}

	@JsonProperty("projectFileMigrated")
	public void setProjectFileMigrated(Object projectFileMigrated) {
		this.projectFileMigrated = projectFileMigrated;
	}

	@JsonProperty("sales")
	public Object getSales() {
		return sales;
	}

	@JsonProperty("sales")
	public void setSales(Object sales) {
		this.sales = sales;
	}

	@JsonProperty("createdTs")
	public Long getCreatedTs() {
		return createdTs;
	}

	@JsonProperty("createdTs")
	public void setCreatedTs(Long createdTs) {
		this.createdTs = createdTs;
	}

	@JsonProperty("modifiedTs")
	public Long getModifiedTs() {
		return modifiedTs;
	}

	@JsonProperty("modifiedTs")
	public void setModifiedTs(Long modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	@JsonProperty("creatorUid")
	public String getCreatorUid() {
		return creatorUid;
	}

	@JsonProperty("creatorUid")
	public void setCreatorUid(String creatorUid) {
		this.creatorUid = creatorUid;
	}

	@JsonProperty("creatorName")
	public String getCreatorName() {
		return creatorName;
	}

	@JsonProperty("creatorName")
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	@JsonProperty("modifierUid")
	public String getModifierUid() {
		return modifierUid;
	}

	@JsonProperty("modifierUid")
	public void setModifierUid(String modifierUid) {
		this.modifierUid = modifierUid;
	}

	@JsonProperty("modifierName")
	public String getModifierName() {
		return modifierName;
	}

	@JsonProperty("modifierName")
	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}

	@JsonProperty("ownerName")
	public String getOwnerName() {
		return ownerName;
	}

	@JsonProperty("ownerName")
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@JsonProperty("status")
	public Long getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(Long status) {
		this.status = status;
	}

	@JsonProperty("statusDisplay")
	public String getStatusDisplay() {
		return statusDisplay;
	}

	@JsonProperty("statusDisplay")
	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("number")
	public String getNumber() {
		return number;
	}

	@JsonProperty("number")
	public void setNumber(String number) {
		this.number = number;
	}

	@JsonProperty("closedByUid")
	public Object getClosedByUid() {
		return closedByUid;
	}

	@JsonProperty("closedByUid")
	public void setClosedByUid(Object closedByUid) {
		this.closedByUid = closedByUid;
	}

	@JsonProperty("closedByName")
	public Object getClosedByName() {
		return closedByName;
	}

	@JsonProperty("closedByName")
	public void setClosedByName(Object closedByName) {
		this.closedByName = closedByName;
	}

	@JsonProperty("closedReason")
	public Object getClosedReason() {
		return closedReason;
	}

	@JsonProperty("closedReason")
	public void setClosedReason(Object closedReason) {
		this.closedReason = closedReason;
	}

	@JsonProperty("legacyNumber")
	public Object getLegacyNumber() {
		return legacyNumber;
	}

	@JsonProperty("legacyNumber")
	public void setLegacyNumber(Object legacyNumber) {
		this.legacyNumber = legacyNumber;
	}

	@JsonProperty("contactPerson")
	public Object getContactPerson() {
		return contactPerson;
	}

	@JsonProperty("contactPerson")
	public void setContactPerson(Object contactPerson) {
		this.contactPerson = contactPerson;
	}

	@JsonProperty("contactPersonName")
	public Object getContactPersonName() {
		return contactPersonName;
	}

	@JsonProperty("contactPersonName")
	public void setContactPersonName(Object contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("startTs")
	public Long getStartTs() {
		return startTs;
	}

	@JsonProperty("startTs")
	public void setStartTs(Long startTs) {
		this.startTs = startTs;
	}

	@JsonProperty("endTs")
	public Long getEndTs() {
		return endTs;
	}

	@JsonProperty("endTs")
	public void setEndTs(Long endTs) {
		this.endTs = endTs;
	}

	@JsonProperty("estimatedHours")
	public Long getEstimatedHours() {
		return estimatedHours;
	}

	@JsonProperty("estimatedHours")
	public void setEstimatedHours(Long estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	@JsonProperty("estimatedHoursMode")
	public Long getEstimatedHoursMode() {
		return estimatedHoursMode;
	}

	@JsonProperty("estimatedHoursMode")
	public void setEstimatedHoursMode(Long estimatedHoursMode) {
		this.estimatedHoursMode = estimatedHoursMode;
	}

	@JsonProperty("billingNumber")
	public Object getBillingNumber() {
		return billingNumber;
	}

	@JsonProperty("billingNumber")
	public void setBillingNumber(Object billingNumber) {
		this.billingNumber = billingNumber;
	}

	@JsonProperty("decisionTs")
	public Object getDecisionTs() {
		return decisionTs;
	}

	@JsonProperty("decisionTs")
	public void setDecisionTs(Object decisionTs) {
		this.decisionTs = decisionTs;
	}

	@JsonProperty("billable")
	public String getBillable() {
		return billable;
	}

	@JsonProperty("billable")
	public void setBillable(String billable) {
		this.billable = billable;
	}

	@JsonProperty("timeRecordable")
	public String getTimeRecordable() {
		return timeRecordable;
	}

	@JsonProperty("timeRecordable")
	public void setTimeRecordable(String timeRecordable) {
		this.timeRecordable = timeRecordable;
	}

	@JsonProperty("timeRecordType")
	public String getTimeRecordType() {
		return timeRecordType;
	}

	@JsonProperty("timeRecordType")
	public void setTimeRecordType(String timeRecordType) {
		this.timeRecordType = timeRecordType;
	}

	@JsonProperty("hoursPerDay")
	public Object getHoursPerDay() {
		return hoursPerDay;
	}

	@JsonProperty("hoursPerDay")
	public void setHoursPerDay(Object hoursPerDay) {
		this.hoursPerDay = hoursPerDay;
	}

	@JsonProperty("percentTasksDone")
	public Long getPercentTasksDone() {
		return percentTasksDone;
	}

	@JsonProperty("percentTasksDone")
	public void setPercentTasksDone(Long percentTasksDone) {
		this.percentTasksDone = percentTasksDone;
	}

	@JsonProperty("percentInvoiced")
	public Long getPercentInvoiced() {
		return percentInvoiced;
	}

	@JsonProperty("percentInvoiced")
	public void setPercentInvoiced(Long percentInvoiced) {
		this.percentInvoiced = percentInvoiced;
	}

	@JsonProperty("percentPaid")
	public Double getPercentPaid() {
		return percentPaid;
	}

	@JsonProperty("percentPaid")
	public void setPercentPaid(Double percentPaid) {
		this.percentPaid = percentPaid;
	}

	@JsonProperty("taskCount")
	public Long getTaskCount() {
		return taskCount;
	}

	@JsonProperty("taskCount")
	public void setTaskCount(Long taskCount) {
		this.taskCount = taskCount;
	}

	@JsonProperty("taskOpenCount")
	public Long getTaskOpenCount() {
		return taskOpenCount;
	}

	@JsonProperty("taskOpenCount")
	public void setTaskOpenCount(Long taskOpenCount) {
		this.taskOpenCount = taskOpenCount;
	}

	@JsonProperty("taskDoneCount")
	public Long getTaskDoneCount() {
		return taskDoneCount;
	}

	@JsonProperty("taskDoneCount")
	public void setTaskDoneCount(Long taskDoneCount) {
		this.taskDoneCount = taskDoneCount;
	}

	@JsonProperty("opportunityCount")
	public Object getOpportunityCount() {
		return opportunityCount;
	}

	@JsonProperty("opportunityCount")
	public void setOpportunityCount(Object opportunityCount) {
		this.opportunityCount = opportunityCount;
	}

	@JsonProperty("opportunitySumNet")
	public Object getOpportunitySumNet() {
		return opportunitySumNet;
	}

	@JsonProperty("opportunitySumNet")
	public void setOpportunitySumNet(Object opportunitySumNet) {
		this.opportunitySumNet = opportunitySumNet;
	}

	@JsonProperty("opportunitySum")
	public Object getOpportunitySum() {
		return opportunitySum;
	}

	@JsonProperty("opportunitySum")
	public void setOpportunitySum(Object opportunitySum) {
		this.opportunitySum = opportunitySum;
	}

	@JsonProperty("opportunitySumWeighted")
	public Object getOpportunitySumWeighted() {
		return opportunitySumWeighted;
	}

	@JsonProperty("opportunitySumWeighted")
	public void setOpportunitySumWeighted(Object opportunitySumWeighted) {
		this.opportunitySumWeighted = opportunitySumWeighted;
	}

	@JsonProperty("opportunitySumWeighted2")
	public Object getOpportunitySumWeighted2() {
		return opportunitySumWeighted2;
	}

	@JsonProperty("opportunitySumWeighted2")
	public void setOpportunitySumWeighted2(Object opportunitySumWeighted2) {
		this.opportunitySumWeighted2 = opportunitySumWeighted2;
	}

	@JsonProperty("opportunitySumAsIfSoldWeighted")
	public Object getOpportunitySumAsIfSoldWeighted() {
		return opportunitySumAsIfSoldWeighted;
	}

	@JsonProperty("opportunitySumAsIfSoldWeighted")
	public void setOpportunitySumAsIfSoldWeighted(Object opportunitySumAsIfSoldWeighted) {
		this.opportunitySumAsIfSoldWeighted = opportunitySumAsIfSoldWeighted;
	}

	@JsonProperty("opportunitySumAsIfSoldWeighted2")
	public Object getOpportunitySumAsIfSoldWeighted2() {
		return opportunitySumAsIfSoldWeighted2;
	}

	@JsonProperty("opportunitySumAsIfSoldWeighted2")
	public void setOpportunitySumAsIfSoldWeighted2(Object opportunitySumAsIfSoldWeighted2) {
		this.opportunitySumAsIfSoldWeighted2 = opportunitySumAsIfSoldWeighted2;
	}

	@JsonProperty("opportunitySumRatio1")
	public Long getOpportunitySumRatio1() {
		return opportunitySumRatio1;
	}

	@JsonProperty("opportunitySumRatio1")
	public void setOpportunitySumRatio1(Long opportunitySumRatio1) {
		this.opportunitySumRatio1 = opportunitySumRatio1;
	}

	@JsonProperty("opportunitySumRatio2")
	public Long getOpportunitySumRatio2() {
		return opportunitySumRatio2;
	}

	@JsonProperty("opportunitySumRatio2")
	public void setOpportunitySumRatio2(Long opportunitySumRatio2) {
		this.opportunitySumRatio2 = opportunitySumRatio2;
	}

	@JsonProperty("opportunityLastModifiedTs")
	public Object getOpportunityLastModifiedTs() {
		return opportunityLastModifiedTs;
	}

	@JsonProperty("opportunityLastModifiedTs")
	public void setOpportunityLastModifiedTs(Object opportunityLastModifiedTs) {
		this.opportunityLastModifiedTs = opportunityLastModifiedTs;
	}

	@JsonProperty("opportunityDocumentNumbers")
	public String getOpportunityDocumentNumbers() {
		return opportunityDocumentNumbers;
	}

	@JsonProperty("opportunityDocumentNumbers")
	public void setOpportunityDocumentNumbers(String opportunityDocumentNumbers) {
		this.opportunityDocumentNumbers = opportunityDocumentNumbers;
	}

	@JsonProperty("offerCount")
	public Object getOfferCount() {
		return offerCount;
	}

	@JsonProperty("offerCount")
	public void setOfferCount(Object offerCount) {
		this.offerCount = offerCount;
	}

	@JsonProperty("offerSumNet")
	public Object getOfferSumNet() {
		return offerSumNet;
	}

	@JsonProperty("offerSumNet")
	public void setOfferSumNet(Object offerSumNet) {
		this.offerSumNet = offerSumNet;
	}

	@JsonProperty("offerSum")
	public Object getOfferSum() {
		return offerSum;
	}

	@JsonProperty("offerSum")
	public void setOfferSum(Object offerSum) {
		this.offerSum = offerSum;
	}

	@JsonProperty("offerSumWeighted")
	public Object getOfferSumWeighted() {
		return offerSumWeighted;
	}

	@JsonProperty("offerSumWeighted")
	public void setOfferSumWeighted(Object offerSumWeighted) {
		this.offerSumWeighted = offerSumWeighted;
	}

	@JsonProperty("offerSumWeighted2")
	public Object getOfferSumWeighted2() {
		return offerSumWeighted2;
	}

	@JsonProperty("offerSumWeighted2")
	public void setOfferSumWeighted2(Object offerSumWeighted2) {
		this.offerSumWeighted2 = offerSumWeighted2;
	}

	@JsonProperty("offerSumAsIfSoldWeighted")
	public Object getOfferSumAsIfSoldWeighted() {
		return offerSumAsIfSoldWeighted;
	}

	@JsonProperty("offerSumAsIfSoldWeighted")
	public void setOfferSumAsIfSoldWeighted(Object offerSumAsIfSoldWeighted) {
		this.offerSumAsIfSoldWeighted = offerSumAsIfSoldWeighted;
	}

	@JsonProperty("offerSumAsIfSoldWeighted2")
	public Object getOfferSumAsIfSoldWeighted2() {
		return offerSumAsIfSoldWeighted2;
	}

	@JsonProperty("offerSumAsIfSoldWeighted2")
	public void setOfferSumAsIfSoldWeighted2(Object offerSumAsIfSoldWeighted2) {
		this.offerSumAsIfSoldWeighted2 = offerSumAsIfSoldWeighted2;
	}

	@JsonProperty("offerSumRatio1")
	public Long getOfferSumRatio1() {
		return offerSumRatio1;
	}

	@JsonProperty("offerSumRatio1")
	public void setOfferSumRatio1(Long offerSumRatio1) {
		this.offerSumRatio1 = offerSumRatio1;
	}

	@JsonProperty("offerSumRatio2")
	public Long getOfferSumRatio2() {
		return offerSumRatio2;
	}

	@JsonProperty("offerSumRatio2")
	public void setOfferSumRatio2(Long offerSumRatio2) {
		this.offerSumRatio2 = offerSumRatio2;
	}

	@JsonProperty("offerLastModifiedTs")
	public Object getOfferLastModifiedTs() {
		return offerLastModifiedTs;
	}

	@JsonProperty("offerLastModifiedTs")
	public void setOfferLastModifiedTs(Object offerLastModifiedTs) {
		this.offerLastModifiedTs = offerLastModifiedTs;
	}

	@JsonProperty("offerDocumentNumbers")
	public String getOfferDocumentNumbers() {
		return offerDocumentNumbers;
	}

	@JsonProperty("offerDocumentNumbers")
	public void setOfferDocumentNumbers(String offerDocumentNumbers) {
		this.offerDocumentNumbers = offerDocumentNumbers;
	}

	@JsonProperty("opportunityMinDecisionDate")
	public Object getOpportunityMinDecisionDate() {
		return opportunityMinDecisionDate;
	}

	@JsonProperty("opportunityMinDecisionDate")
	public void setOpportunityMinDecisionDate(Object opportunityMinDecisionDate) {
		this.opportunityMinDecisionDate = opportunityMinDecisionDate;
	}

	@JsonProperty("opportunityMaxDecisionDate")
	public Object getOpportunityMaxDecisionDate() {
		return opportunityMaxDecisionDate;
	}

	@JsonProperty("opportunityMaxDecisionDate")
	public void setOpportunityMaxDecisionDate(Object opportunityMaxDecisionDate) {
		this.opportunityMaxDecisionDate = opportunityMaxDecisionDate;
	}

	@JsonProperty("offerMinDecisionDate")
	public Object getOfferMinDecisionDate() {
		return offerMinDecisionDate;
	}

	@JsonProperty("offerMinDecisionDate")
	public void setOfferMinDecisionDate(Object offerMinDecisionDate) {
		this.offerMinDecisionDate = offerMinDecisionDate;
	}

	@JsonProperty("offerMaxDecisionDate")
	public Object getOfferMaxDecisionDate() {
		return offerMaxDecisionDate;
	}

	@JsonProperty("offerMaxDecisionDate")
	public void setOfferMaxDecisionDate(Object offerMaxDecisionDate) {
		this.offerMaxDecisionDate = offerMaxDecisionDate;
	}

	@JsonProperty("combinedMinDecisionDate")
	public Object getCombinedMinDecisionDate() {
		return combinedMinDecisionDate;
	}

	@JsonProperty("combinedMinDecisionDate")
	public void setCombinedMinDecisionDate(Object combinedMinDecisionDate) {
		this.combinedMinDecisionDate = combinedMinDecisionDate;
	}

	@JsonProperty("combinedMaxDecisionDate")
	public Object getCombinedMaxDecisionDate() {
		return combinedMaxDecisionDate;
	}

	@JsonProperty("combinedMaxDecisionDate")
	public void setCombinedMaxDecisionDate(Object combinedMaxDecisionDate) {
		this.combinedMaxDecisionDate = combinedMaxDecisionDate;
	}

	@JsonProperty("combinedCount")
	public Long getCombinedCount() {
		return combinedCount;
	}

	@JsonProperty("combinedCount")
	public void setCombinedCount(Long combinedCount) {
		this.combinedCount = combinedCount;
	}

	@JsonProperty("combinedSumNet")
	public Long getCombinedSumNet() {
		return combinedSumNet;
	}

	@JsonProperty("combinedSumNet")
	public void setCombinedSumNet(Long combinedSumNet) {
		this.combinedSumNet = combinedSumNet;
	}

	@JsonProperty("combinedSum")
	public Long getCombinedSum() {
		return combinedSum;
	}

	@JsonProperty("combinedSum")
	public void setCombinedSum(Long combinedSum) {
		this.combinedSum = combinedSum;
	}

	@JsonProperty("combinedSumWeighted")
	public Long getCombinedSumWeighted() {
		return combinedSumWeighted;
	}

	@JsonProperty("combinedSumWeighted")
	public void setCombinedSumWeighted(Long combinedSumWeighted) {
		this.combinedSumWeighted = combinedSumWeighted;
	}

	@JsonProperty("combinedSumWeighted2")
	public Long getCombinedSumWeighted2() {
		return combinedSumWeighted2;
	}

	@JsonProperty("combinedSumWeighted2")
	public void setCombinedSumWeighted2(Long combinedSumWeighted2) {
		this.combinedSumWeighted2 = combinedSumWeighted2;
	}

	@JsonProperty("combinedSumAsIfSoldWeighted")
	public Long getCombinedSumAsIfSoldWeighted() {
		return combinedSumAsIfSoldWeighted;
	}

	@JsonProperty("combinedSumAsIfSoldWeighted")
	public void setCombinedSumAsIfSoldWeighted(Long combinedSumAsIfSoldWeighted) {
		this.combinedSumAsIfSoldWeighted = combinedSumAsIfSoldWeighted;
	}

	@JsonProperty("combinedSumAsIfSoldWeighted2")
	public Long getCombinedSumAsIfSoldWeighted2() {
		return combinedSumAsIfSoldWeighted2;
	}

	@JsonProperty("combinedSumAsIfSoldWeighted2")
	public void setCombinedSumAsIfSoldWeighted2(Long combinedSumAsIfSoldWeighted2) {
		this.combinedSumAsIfSoldWeighted2 = combinedSumAsIfSoldWeighted2;
	}

	@JsonProperty("combinedSumRatio1")
	public Long getCombinedSumRatio1() {
		return combinedSumRatio1;
	}

	@JsonProperty("combinedSumRatio1")
	public void setCombinedSumRatio1(Long combinedSumRatio1) {
		this.combinedSumRatio1 = combinedSumRatio1;
	}

	@JsonProperty("combinedSumRatio2")
	public Long getCombinedSumRatio2() {
		return combinedSumRatio2;
	}

	@JsonProperty("combinedSumRatio2")
	public void setCombinedSumRatio2(Long combinedSumRatio2) {
		this.combinedSumRatio2 = combinedSumRatio2;
	}

	@JsonProperty("orderCount")
	public Object getOrderCount() {
		return orderCount;
	}

	@JsonProperty("orderCount")
	public void setOrderCount(Object orderCount) {
		this.orderCount = orderCount;
	}

	@JsonProperty("orderSumNet")
	public Object getOrderSumNet() {
		return orderSumNet;
	}

	@JsonProperty("orderSumNet")
	public void setOrderSumNet(Object orderSumNet) {
		this.orderSumNet = orderSumNet;
	}

	@JsonProperty("orderSum")
	public Object getOrderSum() {
		return orderSum;
	}

	@JsonProperty("orderSum")
	public void setOrderSum(Object orderSum) {
		this.orderSum = orderSum;
	}

	@JsonProperty("orderOpenSumNet")
	public Double getOrderOpenSumNet() {
		return orderOpenSumNet;
	}

	@JsonProperty("orderOpenSumNet")
	public void setOrderOpenSumNet(Double orderOpenSumNet) {
		this.orderOpenSumNet = orderOpenSumNet;
	}

	@JsonProperty("orderOpenSum")
	public Double getOrderOpenSum() {
		return orderOpenSum;
	}

	@JsonProperty("orderOpenSum")
	public void setOrderOpenSum(Double orderOpenSum) {
		this.orderOpenSum = orderOpenSum;
	}

	@JsonProperty("orderLastModifiedTs")
	public Object getOrderLastModifiedTs() {
		return orderLastModifiedTs;
	}

	@JsonProperty("orderLastModifiedTs")
	public void setOrderLastModifiedTs(Object orderLastModifiedTs) {
		this.orderLastModifiedTs = orderLastModifiedTs;
	}

	@JsonProperty("orderDocumentNumbers")
	public String getOrderDocumentNumbers() {
		return orderDocumentNumbers;
	}

	@JsonProperty("orderDocumentNumbers")
	public void setOrderDocumentNumbers(String orderDocumentNumbers) {
		this.orderDocumentNumbers = orderDocumentNumbers;
	}

	@JsonProperty("invoiceCount")
	public Long getInvoiceCount() {
		return invoiceCount;
	}

	@JsonProperty("invoiceCount")
	public void setInvoiceCount(Long invoiceCount) {
		this.invoiceCount = invoiceCount;
	}

	@JsonProperty("invoicePostingCount")
	public Long getInvoicePostingCount() {
		return invoicePostingCount;
	}

	@JsonProperty("invoicePostingCount")
	public void setInvoicePostingCount(Long invoicePostingCount) {
		this.invoicePostingCount = invoicePostingCount;
	}

	@JsonProperty("invoiceSumNet")
	public Double getInvoiceSumNet() {
		return invoiceSumNet;
	}

	@JsonProperty("invoiceSumNet")
	public void setInvoiceSumNet(Double invoiceSumNet) {
		this.invoiceSumNet = invoiceSumNet;
	}

	@JsonProperty("invoiceSum")
	public Double getInvoiceSum() {
		return invoiceSum;
	}

	@JsonProperty("invoiceSum")
	public void setInvoiceSum(Double invoiceSum) {
		this.invoiceSum = invoiceSum;
	}

	@JsonProperty("invoiceOpenSum")
	public Long getInvoiceOpenSum() {
		return invoiceOpenSum;
	}

	@JsonProperty("invoiceOpenSum")
	public void setInvoiceOpenSum(Long invoiceOpenSum) {
		this.invoiceOpenSum = invoiceOpenSum;
	}

	@JsonProperty("invoicePaidSum")
	public Double getInvoicePaidSum() {
		return invoicePaidSum;
	}

	@JsonProperty("invoicePaidSum")
	public void setInvoicePaidSum(Double invoicePaidSum) {
		this.invoicePaidSum = invoicePaidSum;
	}

	@JsonProperty("invoiceLastModifiedTs")
	public Long getInvoiceLastModifiedTs() {
		return invoiceLastModifiedTs;
	}

	@JsonProperty("invoiceLastModifiedTs")
	public void setInvoiceLastModifiedTs(Long invoiceLastModifiedTs) {
		this.invoiceLastModifiedTs = invoiceLastModifiedTs;
	}

	@JsonProperty("invoiceDocumentNumbers")
	public String getInvoiceDocumentNumbers() {
		return invoiceDocumentNumbers;
	}

	@JsonProperty("invoiceDocumentNumbers")
	public void setInvoiceDocumentNumbers(String invoiceDocumentNumbers) {
		this.invoiceDocumentNumbers = invoiceDocumentNumbers;
	}

	@JsonProperty("invoiceNextDueDate")
	public Object getInvoiceNextDueDate() {
		return invoiceNextDueDate;
	}

	@JsonProperty("invoiceNextDueDate")
	public void setInvoiceNextDueDate(Object invoiceNextDueDate) {
		this.invoiceNextDueDate = invoiceNextDueDate;
	}

	@JsonProperty("dispatchCount")
	public Object getDispatchCount() {
		return dispatchCount;
	}

	@JsonProperty("dispatchCount")
	public void setDispatchCount(Object dispatchCount) {
		this.dispatchCount = dispatchCount;
	}

	@JsonProperty("dispatchSumNet")
	public Object getDispatchSumNet() {
		return dispatchSumNet;
	}

	@JsonProperty("dispatchSumNet")
	public void setDispatchSumNet(Object dispatchSumNet) {
		this.dispatchSumNet = dispatchSumNet;
	}

	@JsonProperty("dispatchSum")
	public Object getDispatchSum() {
		return dispatchSum;
	}

	@JsonProperty("dispatchSum")
	public void setDispatchSum(Object dispatchSum) {
		this.dispatchSum = dispatchSum;
	}

	@JsonProperty("dispatchLastModifiedTs")
	public Object getDispatchLastModifiedTs() {
		return dispatchLastModifiedTs;
	}

	@JsonProperty("dispatchLastModifiedTs")
	public void setDispatchLastModifiedTs(Object dispatchLastModifiedTs) {
		this.dispatchLastModifiedTs = dispatchLastModifiedTs;
	}

	@JsonProperty("dispatchDocumentNumbers")
	public String getDispatchDocumentNumbers() {
		return dispatchDocumentNumbers;
	}

	@JsonProperty("dispatchDocumentNumbers")
	public void setDispatchDocumentNumbers(String dispatchDocumentNumbers) {
		this.dispatchDocumentNumbers = dispatchDocumentNumbers;
	}

	@JsonProperty("creditCount")
	public Long getCreditCount() {
		return creditCount;
	}

	@JsonProperty("creditCount")
	public void setCreditCount(Long creditCount) {
		this.creditCount = creditCount;
	}

	@JsonProperty("creditSumNet")
	public Double getCreditSumNet() {
		return creditSumNet;
	}

	@JsonProperty("creditSumNet")
	public void setCreditSumNet(Double creditSumNet) {
		this.creditSumNet = creditSumNet;
	}

	@JsonProperty("creditSum")
	public Double getCreditSum() {
		return creditSum;
	}

	@JsonProperty("creditSum")
	public void setCreditSum(Double creditSum) {
		this.creditSum = creditSum;
	}

	@JsonProperty("creditLastModifiedTs")
	public Long getCreditLastModifiedTs() {
		return creditLastModifiedTs;
	}

	@JsonProperty("creditLastModifiedTs")
	public void setCreditLastModifiedTs(Long creditLastModifiedTs) {
		this.creditLastModifiedTs = creditLastModifiedTs;
	}

	@JsonProperty("creditDocumentNumbers")
	public String getCreditDocumentNumbers() {
		return creditDocumentNumbers;
	}

	@JsonProperty("creditDocumentNumbers")
	public void setCreditDocumentNumbers(String creditDocumentNumbers) {
		this.creditDocumentNumbers = creditDocumentNumbers;
	}

	@JsonProperty("dimensionNumber1")
	public Object getDimensionNumber1() {
		return dimensionNumber1;
	}

	@JsonProperty("dimensionNumber1")
	public void setDimensionNumber1(Object dimensionNumber1) {
		this.dimensionNumber1 = dimensionNumber1;
	}

	@JsonProperty("dimensionName1")
	public Object getDimensionName1() {
		return dimensionName1;
	}

	@JsonProperty("dimensionName1")
	public void setDimensionName1(Object dimensionName1) {
		this.dimensionName1 = dimensionName1;
	}

	@JsonProperty("dimensionNumber2")
	public Object getDimensionNumber2() {
		return dimensionNumber2;
	}

	@JsonProperty("dimensionNumber2")
	public void setDimensionNumber2(Object dimensionNumber2) {
		this.dimensionNumber2 = dimensionNumber2;
	}

	@JsonProperty("dimensionName2")
	public Object getDimensionName2() {
		return dimensionName2;
	}

	@JsonProperty("dimensionName2")
	public void setDimensionName2(Object dimensionName2) {
		this.dimensionName2 = dimensionName2;
	}

	@JsonProperty("dimensionNumber3")
	public Long getDimensionNumber3() {
		return dimensionNumber3;
	}

	@JsonProperty("dimensionNumber3")
	public void setDimensionNumber3(Long dimensionNumber3) {
		this.dimensionNumber3 = dimensionNumber3;
	}

	@JsonProperty("dimensionName3")
	public String getDimensionName3() {
		return dimensionName3;
	}

	@JsonProperty("dimensionName3")
	public void setDimensionName3(String dimensionName3) {
		this.dimensionName3 = dimensionName3;
	}

	@JsonProperty("dimensionNumber4")
	public Object getDimensionNumber4() {
		return dimensionNumber4;
	}

	@JsonProperty("dimensionNumber4")
	public void setDimensionNumber4(Object dimensionNumber4) {
		this.dimensionNumber4 = dimensionNumber4;
	}

	@JsonProperty("dimensionName4")
	public Object getDimensionName4() {
		return dimensionName4;
	}

	@JsonProperty("dimensionName4")
	public void setDimensionName4(Object dimensionName4) {
		this.dimensionName4 = dimensionName4;
	}

	@JsonProperty("dimensionNumber5")
	public Object getDimensionNumber5() {
		return dimensionNumber5;
	}

	@JsonProperty("dimensionNumber5")
	public void setDimensionNumber5(Object dimensionNumber5) {
		this.dimensionNumber5 = dimensionNumber5;
	}

	@JsonProperty("dimensionName5")
	public Object getDimensionName5() {
		return dimensionName5;
	}

	@JsonProperty("dimensionName5")
	public void setDimensionName5(Object dimensionName5) {
		this.dimensionName5 = dimensionName5;
	}

	@JsonProperty("dimensionNumber6")
	public Object getDimensionNumber6() {
		return dimensionNumber6;
	}

	@JsonProperty("dimensionNumber6")
	public void setDimensionNumber6(Object dimensionNumber6) {
		this.dimensionNumber6 = dimensionNumber6;
	}

	@JsonProperty("dimensionName6")
	public Object getDimensionName6() {
		return dimensionName6;
	}

	@JsonProperty("dimensionName6")
	public void setDimensionName6(Object dimensionName6) {
		this.dimensionName6 = dimensionName6;
	}

	@JsonProperty("dimensionNumber7")
	public Object getDimensionNumber7() {
		return dimensionNumber7;
	}

	@JsonProperty("dimensionNumber7")
	public void setDimensionNumber7(Object dimensionNumber7) {
		this.dimensionNumber7 = dimensionNumber7;
	}

	@JsonProperty("dimensionName7")
	public Object getDimensionName7() {
		return dimensionName7;
	}

	@JsonProperty("dimensionName7")
	public void setDimensionName7(Object dimensionName7) {
		this.dimensionName7 = dimensionName7;
	}

	@JsonProperty("dimensionNumber8")
	public Object getDimensionNumber8() {
		return dimensionNumber8;
	}

	@JsonProperty("dimensionNumber8")
	public void setDimensionNumber8(Object dimensionNumber8) {
		this.dimensionNumber8 = dimensionNumber8;
	}

	@JsonProperty("dimensionName8")
	public Object getDimensionName8() {
		return dimensionName8;
	}

	@JsonProperty("dimensionName8")
	public void setDimensionName8(Object dimensionName8) {
		this.dimensionName8 = dimensionName8;
	}

	@JsonProperty("dimensionNumber9")
	public Object getDimensionNumber9() {
		return dimensionNumber9;
	}

	@JsonProperty("dimensionNumber9")
	public void setDimensionNumber9(Object dimensionNumber9) {
		this.dimensionNumber9 = dimensionNumber9;
	}

	@JsonProperty("dimensionName9")
	public Object getDimensionName9() {
		return dimensionName9;
	}

	@JsonProperty("dimensionName9")
	public void setDimensionName9(Object dimensionName9) {
		this.dimensionName9 = dimensionName9;
	}

	@JsonProperty("dimensionNumber10")
	public Object getDimensionNumber10() {
		return dimensionNumber10;
	}

	@JsonProperty("dimensionNumber10")
	public void setDimensionNumber10(Object dimensionNumber10) {
		this.dimensionNumber10 = dimensionNumber10;
	}

	@JsonProperty("dimensionName10")
	public Object getDimensionName10() {
		return dimensionName10;
	}

	@JsonProperty("dimensionName10")
	public void setDimensionName10(Object dimensionName10) {
		this.dimensionName10 = dimensionName10;
	}

	@JsonProperty("contactId")
	public Long getContactId() {
		return contactId;
	}

	@JsonProperty("contactId")
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	@JsonProperty("contactName")
	public String getContactName() {
		return contactName;
	}

	@JsonProperty("contactName")
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@JsonProperty("contactEmail")
	public Object getContactEmail() {
		return contactEmail;
	}

	@JsonProperty("contactEmail")
	public void setContactEmail(Object contactEmail) {
		this.contactEmail = contactEmail;
	}

	@JsonProperty("contactSphere")
	public String getContactSphere() {
		return contactSphere;
	}

	@JsonProperty("contactSphere")
	public void setContactSphere(String contactSphere) {
		this.contactSphere = contactSphere;
	}

	@JsonProperty("contactSphereDisplay")
	public String getContactSphereDisplay() {
		return contactSphereDisplay;
	}

	@JsonProperty("contactSphereDisplay")
	public void setContactSphereDisplay(String contactSphereDisplay) {
		this.contactSphereDisplay = contactSphereDisplay;
	}

	@JsonProperty("fileIds")
	public Object getFileIds() {
		return fileIds;
	}

	@JsonProperty("fileIds")
	public void setFileIds(Object fileIds) {
		this.fileIds = fileIds;
	}

	@JsonProperty("centerdeviceId")
	public Object getCenterdeviceId() {
		return centerdeviceId;
	}

	@JsonProperty("centerdeviceId")
	public void setCenterdeviceId(Object centerdeviceId) {
		this.centerdeviceId = centerdeviceId;
	}

	@JsonProperty("centerdeviceTenant")
	public Object getCenterdeviceTenant() {
		return centerdeviceTenant;
	}

	@JsonProperty("centerdeviceTenant")
	public void setCenterdeviceTenant(Object centerdeviceTenant) {
		this.centerdeviceTenant = centerdeviceTenant;
	}

	@JsonProperty("centerdeviceTenantName")
	public Object getCenterdeviceTenantName() {
		return centerdeviceTenantName;
	}

	@JsonProperty("centerdeviceTenantName")
	public void setCenterdeviceTenantName(Object centerdeviceTenantName) {
		this.centerdeviceTenantName = centerdeviceTenantName;
	}

	@JsonProperty("lastCenterdeviceSync")
	public Object getLastCenterdeviceSync() {
		return lastCenterdeviceSync;
	}

	@JsonProperty("lastCenterdeviceSync")
	public void setLastCenterdeviceSync(Object lastCenterdeviceSync) {
		this.lastCenterdeviceSync = lastCenterdeviceSync;
	}

	@JsonProperty("syncDisabled")
	public Object getSyncDisabled() {
		return syncDisabled;
	}

	@JsonProperty("syncDisabled")
	public void setSyncDisabled(Object syncDisabled) {
		this.syncDisabled = syncDisabled;
	}

	@JsonProperty("stopWatch")
	public Object getStopWatch() {
		return stopWatch;
	}

	@JsonProperty("stopWatch")
	public void setStopWatch(Object stopWatch) {
		this.stopWatch = stopWatch;
	}

	@JsonProperty("thumb")
	public Object getThumb() {
		return thumb;
	}

	@JsonProperty("thumb")
	public void setThumb(Object thumb) {
		this.thumb = thumb;
	}

	@JsonProperty("thumbLength")
	public Object getThumbLength() {
		return thumbLength;
	}

	@JsonProperty("thumbLength")
	public void setThumbLength(Object thumbLength) {
		this.thumbLength = thumbLength;
	}

	@JsonProperty("type2")
	public String getType2() {
		return type2;
	}

	@JsonProperty("type2")
	public void setType2(String type2) {
		this.type2 = type2;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("phase")
	public String getPhase() {
		return phase;
	}

	@JsonProperty("phase")
	public void setPhase(String phase) {
		this.phase = phase;
	}

	@JsonProperty("status2")
	public String getStatus2() {
		return status2;
	}

	@JsonProperty("status2")
	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	@JsonProperty("priority")
	public String getPriority() {
		return priority;
	}

	@JsonProperty("priority")
	public void setPriority(String priority) {
		this.priority = priority;
	}

	@JsonProperty("risk")
	public String getRisk() {
		return risk;
	}

	@JsonProperty("risk")
	public void setRisk(String risk) {
		this.risk = risk;
	}

	@JsonProperty("riskDescription")
	public Object getRiskDescription() {
		return riskDescription;
	}

	@JsonProperty("riskDescription")
	public void setRiskDescription(Object riskDescription) {
		this.riskDescription = riskDescription;
	}

	@JsonProperty("workdaysDisplay")
	public String getWorkdaysDisplay() {
		return workdaysDisplay;
	}

	@JsonProperty("workdaysDisplay")
	public void setWorkdaysDisplay(String workdaysDisplay) {
		this.workdaysDisplay = workdaysDisplay;
	}

	@JsonProperty("workdays")
	public Long getWorkdays() {
		return workdays;
	}

	@JsonProperty("workdays")
	public void setWorkdays(Long workdays) {
		this.workdays = workdays;
	}

	@JsonProperty("initiatorContactId")
	public Long getInitiatorContactId() {
		return initiatorContactId;
	}

	@JsonProperty("initiatorContactId")
	public void setInitiatorContactId(Long initiatorContactId) {
		this.initiatorContactId = initiatorContactId;
	}

	@JsonProperty("initiatorContactName")
	public String getInitiatorContactName() {
		return initiatorContactName;
	}

	@JsonProperty("initiatorContactName")
	public void setInitiatorContactName(String initiatorContactName) {
		this.initiatorContactName = initiatorContactName;
	}

	@JsonProperty("initiatorContactEmail")
	public Object getInitiatorContactEmail() {
		return initiatorContactEmail;
	}

	@JsonProperty("initiatorContactEmail")
	public void setInitiatorContactEmail(Object initiatorContactEmail) {
		this.initiatorContactEmail = initiatorContactEmail;
	}

	@JsonProperty("contactIds")
	public Object getContactIds() {
		return contactIds;
	}

	@JsonProperty("contactIds")
	public void setContactIds(Object contactIds) {
		this.contactIds = contactIds;
	}

	@JsonProperty("customText1")
	public Object getCustomText1() {
		return customText1;
	}

	@JsonProperty("customText1")
	public void setCustomText1(Object customText1) {
		this.customText1 = customText1;
	}

	@JsonProperty("customBoolean1")
	public Object getCustomBoolean1() {
		return customBoolean1;
	}

	@JsonProperty("customBoolean1")
	public void setCustomBoolean1(Object customBoolean1) {
		this.customBoolean1 = customBoolean1;
	}

	@JsonProperty("customAmount1")
	public Object getCustomAmount1() {
		return customAmount1;
	}

	@JsonProperty("customAmount1")
	public void setCustomAmount1(Object customAmount1) {
		this.customAmount1 = customAmount1;
	}

	@JsonProperty("customLong1")
	public Object getCustomLong1() {
		return customLong1;
	}

	@JsonProperty("customLong1")
	public void setCustomLong1(Object customLong1) {
		this.customLong1 = customLong1;
	}

	@JsonProperty("customDate1")
	public Object getCustomDate1() {
		return customDate1;
	}

	@JsonProperty("customDate1")
	public void setCustomDate1(Object customDate1) {
		this.customDate1 = customDate1;
	}

	@JsonProperty("customDateTime1")
	public Object getCustomDateTime1() {
		return customDateTime1;
	}

	@JsonProperty("customDateTime1")
	public void setCustomDateTime1(Object customDateTime1) {
		this.customDateTime1 = customDateTime1;
	}

	@JsonProperty("customText2")
	public Object getCustomText2() {
		return customText2;
	}

	@JsonProperty("customText2")
	public void setCustomText2(Object customText2) {
		this.customText2 = customText2;
	}

	@JsonProperty("customBoolean2")
	public Object getCustomBoolean2() {
		return customBoolean2;
	}

	@JsonProperty("customBoolean2")
	public void setCustomBoolean2(Object customBoolean2) {
		this.customBoolean2 = customBoolean2;
	}

	@JsonProperty("customAmount2")
	public Object getCustomAmount2() {
		return customAmount2;
	}

	@JsonProperty("customAmount2")
	public void setCustomAmount2(Object customAmount2) {
		this.customAmount2 = customAmount2;
	}

	@JsonProperty("customLong2")
	public Object getCustomLong2() {
		return customLong2;
	}

	@JsonProperty("customLong2")
	public void setCustomLong2(Object customLong2) {
		this.customLong2 = customLong2;
	}

	@JsonProperty("customDate2")
	public Object getCustomDate2() {
		return customDate2;
	}

	@JsonProperty("customDate2")
	public void setCustomDate2(Object customDate2) {
		this.customDate2 = customDate2;
	}

	@JsonProperty("customDateTime2")
	public Object getCustomDateTime2() {
		return customDateTime2;
	}

	@JsonProperty("customDateTime2")
	public void setCustomDateTime2(Object customDateTime2) {
		this.customDateTime2 = customDateTime2;
	}

	@JsonProperty("customText3")
	public Object getCustomText3() {
		return customText3;
	}

	@JsonProperty("customText3")
	public void setCustomText3(Object customText3) {
		this.customText3 = customText3;
	}

	@JsonProperty("customBoolean3")
	public Object getCustomBoolean3() {
		return customBoolean3;
	}

	@JsonProperty("customBoolean3")
	public void setCustomBoolean3(Object customBoolean3) {
		this.customBoolean3 = customBoolean3;
	}

	@JsonProperty("customAmount3")
	public Object getCustomAmount3() {
		return customAmount3;
	}

	@JsonProperty("customAmount3")
	public void setCustomAmount3(Object customAmount3) {
		this.customAmount3 = customAmount3;
	}

	@JsonProperty("customLong3")
	public Object getCustomLong3() {
		return customLong3;
	}

	@JsonProperty("customLong3")
	public void setCustomLong3(Object customLong3) {
		this.customLong3 = customLong3;
	}

	@JsonProperty("customDate3")
	public Object getCustomDate3() {
		return customDate3;
	}

	@JsonProperty("customDate3")
	public void setCustomDate3(Object customDate3) {
		this.customDate3 = customDate3;
	}

	@JsonProperty("customDateTime3")
	public Object getCustomDateTime3() {
		return customDateTime3;
	}

	@JsonProperty("customDateTime3")
	public void setCustomDateTime3(Object customDateTime3) {
		this.customDateTime3 = customDateTime3;
	}

	@JsonProperty("customText4")
	public Object getCustomText4() {
		return customText4;
	}

	@JsonProperty("customText4")
	public void setCustomText4(Object customText4) {
		this.customText4 = customText4;
	}

	@JsonProperty("customBoolean4")
	public Object getCustomBoolean4() {
		return customBoolean4;
	}

	@JsonProperty("customBoolean4")
	public void setCustomBoolean4(Object customBoolean4) {
		this.customBoolean4 = customBoolean4;
	}

	@JsonProperty("customAmount4")
	public Object getCustomAmount4() {
		return customAmount4;
	}

	@JsonProperty("customAmount4")
	public void setCustomAmount4(Object customAmount4) {
		this.customAmount4 = customAmount4;
	}

	@JsonProperty("customLong4")
	public Object getCustomLong4() {
		return customLong4;
	}

	@JsonProperty("customLong4")
	public void setCustomLong4(Object customLong4) {
		this.customLong4 = customLong4;
	}

	@JsonProperty("customDate4")
	public Object getCustomDate4() {
		return customDate4;
	}

	@JsonProperty("customDate4")
	public void setCustomDate4(Object customDate4) {
		this.customDate4 = customDate4;
	}

	@JsonProperty("customDateTime4")
	public Object getCustomDateTime4() {
		return customDateTime4;
	}

	@JsonProperty("customDateTime4")
	public void setCustomDateTime4(Object customDateTime4) {
		this.customDateTime4 = customDateTime4;
	}

	@JsonProperty("customText5")
	public Object getCustomText5() {
		return customText5;
	}

	@JsonProperty("customText5")
	public void setCustomText5(Object customText5) {
		this.customText5 = customText5;
	}

	@JsonProperty("customBoolean5")
	public Object getCustomBoolean5() {
		return customBoolean5;
	}

	@JsonProperty("customBoolean5")
	public void setCustomBoolean5(Object customBoolean5) {
		this.customBoolean5 = customBoolean5;
	}

	@JsonProperty("customAmount5")
	public Object getCustomAmount5() {
		return customAmount5;
	}

	@JsonProperty("customAmount5")
	public void setCustomAmount5(Object customAmount5) {
		this.customAmount5 = customAmount5;
	}

	@JsonProperty("customLong5")
	public Object getCustomLong5() {
		return customLong5;
	}

	@JsonProperty("customLong5")
	public void setCustomLong5(Object customLong5) {
		this.customLong5 = customLong5;
	}

	@JsonProperty("customDate5")
	public Object getCustomDate5() {
		return customDate5;
	}

	@JsonProperty("customDate5")
	public void setCustomDate5(Object customDate5) {
		this.customDate5 = customDate5;
	}

	@JsonProperty("customDateTime5")
	public Object getCustomDateTime5() {
		return customDateTime5;
	}

	@JsonProperty("customDateTime5")
	public void setCustomDateTime5(Object customDateTime5) {
		this.customDateTime5 = customDateTime5;
	}

	@JsonProperty("customText6")
	public Object getCustomText6() {
		return customText6;
	}

	@JsonProperty("customText6")
	public void setCustomText6(Object customText6) {
		this.customText6 = customText6;
	}

	@JsonProperty("customBoolean6")
	public Object getCustomBoolean6() {
		return customBoolean6;
	}

	@JsonProperty("customBoolean6")
	public void setCustomBoolean6(Object customBoolean6) {
		this.customBoolean6 = customBoolean6;
	}

	@JsonProperty("customAmount6")
	public Object getCustomAmount6() {
		return customAmount6;
	}

	@JsonProperty("customAmount6")
	public void setCustomAmount6(Object customAmount6) {
		this.customAmount6 = customAmount6;
	}

	@JsonProperty("customLong6")
	public Object getCustomLong6() {
		return customLong6;
	}

	@JsonProperty("customLong6")
	public void setCustomLong6(Object customLong6) {
		this.customLong6 = customLong6;
	}

	@JsonProperty("customDate6")
	public Object getCustomDate6() {
		return customDate6;
	}

	@JsonProperty("customDate6")
	public void setCustomDate6(Object customDate6) {
		this.customDate6 = customDate6;
	}

	@JsonProperty("customDateTime6")
	public Object getCustomDateTime6() {
		return customDateTime6;
	}

	@JsonProperty("customDateTime6")
	public void setCustomDateTime6(Object customDateTime6) {
		this.customDateTime6 = customDateTime6;
	}

	@JsonProperty("customText7")
	public Object getCustomText7() {
		return customText7;
	}

	@JsonProperty("customText7")
	public void setCustomText7(Object customText7) {
		this.customText7 = customText7;
	}

	@JsonProperty("customBoolean7")
	public Object getCustomBoolean7() {
		return customBoolean7;
	}

	@JsonProperty("customBoolean7")
	public void setCustomBoolean7(Object customBoolean7) {
		this.customBoolean7 = customBoolean7;
	}

	@JsonProperty("customAmount7")
	public Object getCustomAmount7() {
		return customAmount7;
	}

	@JsonProperty("customAmount7")
	public void setCustomAmount7(Object customAmount7) {
		this.customAmount7 = customAmount7;
	}

	@JsonProperty("customLong7")
	public Object getCustomLong7() {
		return customLong7;
	}

	@JsonProperty("customLong7")
	public void setCustomLong7(Object customLong7) {
		this.customLong7 = customLong7;
	}

	@JsonProperty("customDate7")
	public Object getCustomDate7() {
		return customDate7;
	}

	@JsonProperty("customDate7")
	public void setCustomDate7(Object customDate7) {
		this.customDate7 = customDate7;
	}

	@JsonProperty("customDateTime7")
	public Object getCustomDateTime7() {
		return customDateTime7;
	}

	@JsonProperty("customDateTime7")
	public void setCustomDateTime7(Object customDateTime7) {
		this.customDateTime7 = customDateTime7;
	}

	@JsonProperty("customText8")
	public Object getCustomText8() {
		return customText8;
	}

	@JsonProperty("customText8")
	public void setCustomText8(Object customText8) {
		this.customText8 = customText8;
	}

	@JsonProperty("customBoolean8")
	public Object getCustomBoolean8() {
		return customBoolean8;
	}

	@JsonProperty("customBoolean8")
	public void setCustomBoolean8(Object customBoolean8) {
		this.customBoolean8 = customBoolean8;
	}

	@JsonProperty("customAmount8")
	public Object getCustomAmount8() {
		return customAmount8;
	}

	@JsonProperty("customAmount8")
	public void setCustomAmount8(Object customAmount8) {
		this.customAmount8 = customAmount8;
	}

	@JsonProperty("customLong8")
	public Object getCustomLong8() {
		return customLong8;
	}

	@JsonProperty("customLong8")
	public void setCustomLong8(Object customLong8) {
		this.customLong8 = customLong8;
	}

	@JsonProperty("customDate8")
	public Object getCustomDate8() {
		return customDate8;
	}

	@JsonProperty("customDate8")
	public void setCustomDate8(Object customDate8) {
		this.customDate8 = customDate8;
	}

	@JsonProperty("customDateTime8")
	public Object getCustomDateTime8() {
		return customDateTime8;
	}

	@JsonProperty("customDateTime8")
	public void setCustomDateTime8(Object customDateTime8) {
		this.customDateTime8 = customDateTime8;
	}

	@JsonProperty("customText9")
	public Object getCustomText9() {
		return customText9;
	}

	@JsonProperty("customText9")
	public void setCustomText9(Object customText9) {
		this.customText9 = customText9;
	}

	@JsonProperty("customBoolean9")
	public Object getCustomBoolean9() {
		return customBoolean9;
	}

	@JsonProperty("customBoolean9")
	public void setCustomBoolean9(Object customBoolean9) {
		this.customBoolean9 = customBoolean9;
	}

	@JsonProperty("customAmount9")
	public Object getCustomAmount9() {
		return customAmount9;
	}

	@JsonProperty("customAmount9")
	public void setCustomAmount9(Object customAmount9) {
		this.customAmount9 = customAmount9;
	}

	@JsonProperty("customLong9")
	public Object getCustomLong9() {
		return customLong9;
	}

	@JsonProperty("customLong9")
	public void setCustomLong9(Object customLong9) {
		this.customLong9 = customLong9;
	}

	@JsonProperty("customDate9")
	public Object getCustomDate9() {
		return customDate9;
	}

	@JsonProperty("customDate9")
	public void setCustomDate9(Object customDate9) {
		this.customDate9 = customDate9;
	}

	@JsonProperty("customDateTime9")
	public Object getCustomDateTime9() {
		return customDateTime9;
	}

	@JsonProperty("customDateTime9")
	public void setCustomDateTime9(Object customDateTime9) {
		this.customDateTime9 = customDateTime9;
	}

	@JsonProperty("customText10")
	public Object getCustomText10() {
		return customText10;
	}

	@JsonProperty("customText10")
	public void setCustomText10(Object customText10) {
		this.customText10 = customText10;
	}

	@JsonProperty("customBoolean10")
	public Object getCustomBoolean10() {
		return customBoolean10;
	}

	@JsonProperty("customBoolean10")
	public void setCustomBoolean10(Object customBoolean10) {
		this.customBoolean10 = customBoolean10;
	}

	@JsonProperty("customAmount10")
	public Object getCustomAmount10() {
		return customAmount10;
	}

	@JsonProperty("customAmount10")
	public void setCustomAmount10(Object customAmount10) {
		this.customAmount10 = customAmount10;
	}

	@JsonProperty("customLong10")
	public Object getCustomLong10() {
		return customLong10;
	}

	@JsonProperty("customLong10")
	public void setCustomLong10(Object customLong10) {
		this.customLong10 = customLong10;
	}

	@JsonProperty("customDate10")
	public Object getCustomDate10() {
		return customDate10;
	}

	@JsonProperty("customDate10")
	public void setCustomDate10(Object customDate10) {
		this.customDate10 = customDate10;
	}

	@JsonProperty("customDateTime10")
	public Object getCustomDateTime10() {
		return customDateTime10;
	}

	@JsonProperty("customDateTime10")
	public void setCustomDateTime10(Object customDateTime10) {
		this.customDateTime10 = customDateTime10;
	}

	@JsonProperty("customText11")
	public Object getCustomText11() {
		return customText11;
	}

	@JsonProperty("customText11")
	public void setCustomText11(Object customText11) {
		this.customText11 = customText11;
	}

	@JsonProperty("customBoolean11")
	public Object getCustomBoolean11() {
		return customBoolean11;
	}

	@JsonProperty("customBoolean11")
	public void setCustomBoolean11(Object customBoolean11) {
		this.customBoolean11 = customBoolean11;
	}

	@JsonProperty("customAmount11")
	public Object getCustomAmount11() {
		return customAmount11;
	}

	@JsonProperty("customAmount11")
	public void setCustomAmount11(Object customAmount11) {
		this.customAmount11 = customAmount11;
	}

	@JsonProperty("customLong11")
	public Object getCustomLong11() {
		return customLong11;
	}

	@JsonProperty("customLong11")
	public void setCustomLong11(Object customLong11) {
		this.customLong11 = customLong11;
	}

	@JsonProperty("customDate11")
	public Object getCustomDate11() {
		return customDate11;
	}

	@JsonProperty("customDate11")
	public void setCustomDate11(Object customDate11) {
		this.customDate11 = customDate11;
	}

	@JsonProperty("customDateTime11")
	public Object getCustomDateTime11() {
		return customDateTime11;
	}

	@JsonProperty("customDateTime11")
	public void setCustomDateTime11(Object customDateTime11) {
		this.customDateTime11 = customDateTime11;
	}

	@JsonProperty("customText12")
	public Object getCustomText12() {
		return customText12;
	}

	@JsonProperty("customText12")
	public void setCustomText12(Object customText12) {
		this.customText12 = customText12;
	}

	@JsonProperty("customBoolean12")
	public Object getCustomBoolean12() {
		return customBoolean12;
	}

	@JsonProperty("customBoolean12")
	public void setCustomBoolean12(Object customBoolean12) {
		this.customBoolean12 = customBoolean12;
	}

	@JsonProperty("customAmount12")
	public Object getCustomAmount12() {
		return customAmount12;
	}

	@JsonProperty("customAmount12")
	public void setCustomAmount12(Object customAmount12) {
		this.customAmount12 = customAmount12;
	}

	@JsonProperty("customLong12")
	public Object getCustomLong12() {
		return customLong12;
	}

	@JsonProperty("customLong12")
	public void setCustomLong12(Object customLong12) {
		this.customLong12 = customLong12;
	}

	@JsonProperty("customDate12")
	public Object getCustomDate12() {
		return customDate12;
	}

	@JsonProperty("customDate12")
	public void setCustomDate12(Object customDate12) {
		this.customDate12 = customDate12;
	}

	@JsonProperty("customDateTime12")
	public Object getCustomDateTime12() {
		return customDateTime12;
	}

	@JsonProperty("customDateTime12")
	public void setCustomDateTime12(Object customDateTime12) {
		this.customDateTime12 = customDateTime12;
	}

	@JsonProperty("customText13")
	public Object getCustomText13() {
		return customText13;
	}

	@JsonProperty("customText13")
	public void setCustomText13(Object customText13) {
		this.customText13 = customText13;
	}

	@JsonProperty("customBoolean13")
	public Object getCustomBoolean13() {
		return customBoolean13;
	}

	@JsonProperty("customBoolean13")
	public void setCustomBoolean13(Object customBoolean13) {
		this.customBoolean13 = customBoolean13;
	}

	@JsonProperty("customAmount13")
	public Object getCustomAmount13() {
		return customAmount13;
	}

	@JsonProperty("customAmount13")
	public void setCustomAmount13(Object customAmount13) {
		this.customAmount13 = customAmount13;
	}

	@JsonProperty("customLong13")
	public Object getCustomLong13() {
		return customLong13;
	}

	@JsonProperty("customLong13")
	public void setCustomLong13(Object customLong13) {
		this.customLong13 = customLong13;
	}

	@JsonProperty("customDate13")
	public Object getCustomDate13() {
		return customDate13;
	}

	@JsonProperty("customDate13")
	public void setCustomDate13(Object customDate13) {
		this.customDate13 = customDate13;
	}

	@JsonProperty("customDateTime13")
	public Object getCustomDateTime13() {
		return customDateTime13;
	}

	@JsonProperty("customDateTime13")
	public void setCustomDateTime13(Object customDateTime13) {
		this.customDateTime13 = customDateTime13;
	}

	@JsonProperty("customText14")
	public Object getCustomText14() {
		return customText14;
	}

	@JsonProperty("customText14")
	public void setCustomText14(Object customText14) {
		this.customText14 = customText14;
	}

	@JsonProperty("customBoolean14")
	public Object getCustomBoolean14() {
		return customBoolean14;
	}

	@JsonProperty("customBoolean14")
	public void setCustomBoolean14(Object customBoolean14) {
		this.customBoolean14 = customBoolean14;
	}

	@JsonProperty("customAmount14")
	public Object getCustomAmount14() {
		return customAmount14;
	}

	@JsonProperty("customAmount14")
	public void setCustomAmount14(Object customAmount14) {
		this.customAmount14 = customAmount14;
	}

	@JsonProperty("customLong14")
	public Object getCustomLong14() {
		return customLong14;
	}

	@JsonProperty("customLong14")
	public void setCustomLong14(Object customLong14) {
		this.customLong14 = customLong14;
	}

	@JsonProperty("customDate14")
	public Object getCustomDate14() {
		return customDate14;
	}

	@JsonProperty("customDate14")
	public void setCustomDate14(Object customDate14) {
		this.customDate14 = customDate14;
	}

	@JsonProperty("customDateTime14")
	public Object getCustomDateTime14() {
		return customDateTime14;
	}

	@JsonProperty("customDateTime14")
	public void setCustomDateTime14(Object customDateTime14) {
		this.customDateTime14 = customDateTime14;
	}

	@JsonProperty("customText15")
	public Object getCustomText15() {
		return customText15;
	}

	@JsonProperty("customText15")
	public void setCustomText15(Object customText15) {
		this.customText15 = customText15;
	}

	@JsonProperty("customBoolean15")
	public Object getCustomBoolean15() {
		return customBoolean15;
	}

	@JsonProperty("customBoolean15")
	public void setCustomBoolean15(Object customBoolean15) {
		this.customBoolean15 = customBoolean15;
	}

	@JsonProperty("customAmount15")
	public Object getCustomAmount15() {
		return customAmount15;
	}

	@JsonProperty("customAmount15")
	public void setCustomAmount15(Object customAmount15) {
		this.customAmount15 = customAmount15;
	}

	@JsonProperty("customLong15")
	public Object getCustomLong15() {
		return customLong15;
	}

	@JsonProperty("customLong15")
	public void setCustomLong15(Object customLong15) {
		this.customLong15 = customLong15;
	}

	@JsonProperty("customDate15")
	public Object getCustomDate15() {
		return customDate15;
	}

	@JsonProperty("customDate15")
	public void setCustomDate15(Object customDate15) {
		this.customDate15 = customDate15;
	}

	@JsonProperty("customDateTime15")
	public Object getCustomDateTime15() {
		return customDateTime15;
	}

	@JsonProperty("customDateTime15")
	public void setCustomDateTime15(Object customDateTime15) {
		this.customDateTime15 = customDateTime15;
	}

	@JsonProperty("customText16")
	public Object getCustomText16() {
		return customText16;
	}

	@JsonProperty("customText16")
	public void setCustomText16(Object customText16) {
		this.customText16 = customText16;
	}

	@JsonProperty("customBoolean16")
	public Object getCustomBoolean16() {
		return customBoolean16;
	}

	@JsonProperty("customBoolean16")
	public void setCustomBoolean16(Object customBoolean16) {
		this.customBoolean16 = customBoolean16;
	}

	@JsonProperty("customAmount16")
	public Object getCustomAmount16() {
		return customAmount16;
	}

	@JsonProperty("customAmount16")
	public void setCustomAmount16(Object customAmount16) {
		this.customAmount16 = customAmount16;
	}

	@JsonProperty("customLong16")
	public Object getCustomLong16() {
		return customLong16;
	}

	@JsonProperty("customLong16")
	public void setCustomLong16(Object customLong16) {
		this.customLong16 = customLong16;
	}

	@JsonProperty("customDate16")
	public Object getCustomDate16() {
		return customDate16;
	}

	@JsonProperty("customDate16")
	public void setCustomDate16(Object customDate16) {
		this.customDate16 = customDate16;
	}

	@JsonProperty("customDateTime16")
	public Object getCustomDateTime16() {
		return customDateTime16;
	}

	@JsonProperty("customDateTime16")
	public void setCustomDateTime16(Object customDateTime16) {
		this.customDateTime16 = customDateTime16;
	}

	@JsonProperty("customText17")
	public Object getCustomText17() {
		return customText17;
	}

	@JsonProperty("customText17")
	public void setCustomText17(Object customText17) {
		this.customText17 = customText17;
	}

	@JsonProperty("customBoolean17")
	public Object getCustomBoolean17() {
		return customBoolean17;
	}

	@JsonProperty("customBoolean17")
	public void setCustomBoolean17(Object customBoolean17) {
		this.customBoolean17 = customBoolean17;
	}

	@JsonProperty("customAmount17")
	public Object getCustomAmount17() {
		return customAmount17;
	}

	@JsonProperty("customAmount17")
	public void setCustomAmount17(Object customAmount17) {
		this.customAmount17 = customAmount17;
	}

	@JsonProperty("customLong17")
	public Object getCustomLong17() {
		return customLong17;
	}

	@JsonProperty("customLong17")
	public void setCustomLong17(Object customLong17) {
		this.customLong17 = customLong17;
	}

	@JsonProperty("customDate17")
	public Object getCustomDate17() {
		return customDate17;
	}

	@JsonProperty("customDate17")
	public void setCustomDate17(Object customDate17) {
		this.customDate17 = customDate17;
	}

	@JsonProperty("customDateTime17")
	public Object getCustomDateTime17() {
		return customDateTime17;
	}

	@JsonProperty("customDateTime17")
	public void setCustomDateTime17(Object customDateTime17) {
		this.customDateTime17 = customDateTime17;
	}

	@JsonProperty("customText18")
	public Object getCustomText18() {
		return customText18;
	}

	@JsonProperty("customText18")
	public void setCustomText18(Object customText18) {
		this.customText18 = customText18;
	}

	@JsonProperty("customBoolean18")
	public Object getCustomBoolean18() {
		return customBoolean18;
	}

	@JsonProperty("customBoolean18")
	public void setCustomBoolean18(Object customBoolean18) {
		this.customBoolean18 = customBoolean18;
	}

	@JsonProperty("customAmount18")
	public Object getCustomAmount18() {
		return customAmount18;
	}

	@JsonProperty("customAmount18")
	public void setCustomAmount18(Object customAmount18) {
		this.customAmount18 = customAmount18;
	}

	@JsonProperty("customLong18")
	public Object getCustomLong18() {
		return customLong18;
	}

	@JsonProperty("customLong18")
	public void setCustomLong18(Object customLong18) {
		this.customLong18 = customLong18;
	}

	@JsonProperty("customDate18")
	public Object getCustomDate18() {
		return customDate18;
	}

	@JsonProperty("customDate18")
	public void setCustomDate18(Object customDate18) {
		this.customDate18 = customDate18;
	}

	@JsonProperty("customDateTime18")
	public Object getCustomDateTime18() {
		return customDateTime18;
	}

	@JsonProperty("customDateTime18")
	public void setCustomDateTime18(Object customDateTime18) {
		this.customDateTime18 = customDateTime18;
	}

	@JsonProperty("customText19")
	public Object getCustomText19() {
		return customText19;
	}

	@JsonProperty("customText19")
	public void setCustomText19(Object customText19) {
		this.customText19 = customText19;
	}

	@JsonProperty("customBoolean19")
	public Object getCustomBoolean19() {
		return customBoolean19;
	}

	@JsonProperty("customBoolean19")
	public void setCustomBoolean19(Object customBoolean19) {
		this.customBoolean19 = customBoolean19;
	}

	@JsonProperty("customAmount19")
	public Object getCustomAmount19() {
		return customAmount19;
	}

	@JsonProperty("customAmount19")
	public void setCustomAmount19(Object customAmount19) {
		this.customAmount19 = customAmount19;
	}

	@JsonProperty("customLong19")
	public Object getCustomLong19() {
		return customLong19;
	}

	@JsonProperty("customLong19")
	public void setCustomLong19(Object customLong19) {
		this.customLong19 = customLong19;
	}

	@JsonProperty("customDate19")
	public Object getCustomDate19() {
		return customDate19;
	}

	@JsonProperty("customDate19")
	public void setCustomDate19(Object customDate19) {
		this.customDate19 = customDate19;
	}

	@JsonProperty("customDateTime19")
	public Object getCustomDateTime19() {
		return customDateTime19;
	}

	@JsonProperty("customDateTime19")
	public void setCustomDateTime19(Object customDateTime19) {
		this.customDateTime19 = customDateTime19;
	}

	@JsonProperty("customText20")
	public Object getCustomText20() {
		return customText20;
	}

	@JsonProperty("customText20")
	public void setCustomText20(Object customText20) {
		this.customText20 = customText20;
	}

	@JsonProperty("customBoolean20")
	public Object getCustomBoolean20() {
		return customBoolean20;
	}

	@JsonProperty("customBoolean20")
	public void setCustomBoolean20(Object customBoolean20) {
		this.customBoolean20 = customBoolean20;
	}

	@JsonProperty("customAmount20")
	public Object getCustomAmount20() {
		return customAmount20;
	}

	@JsonProperty("customAmount20")
	public void setCustomAmount20(Object customAmount20) {
		this.customAmount20 = customAmount20;
	}

	@JsonProperty("customLong20")
	public Object getCustomLong20() {
		return customLong20;
	}

	@JsonProperty("customLong20")
	public void setCustomLong20(Object customLong20) {
		this.customLong20 = customLong20;
	}

	@JsonProperty("customDate20")
	public Object getCustomDate20() {
		return customDate20;
	}

	@JsonProperty("customDate20")
	public void setCustomDate20(Object customDate20) {
		this.customDate20 = customDate20;
	}

	@JsonProperty("customDateTime20")
	public Object getCustomDateTime20() {
		return customDateTime20;
	}

	@JsonProperty("customDateTime20")
	public void setCustomDateTime20(Object customDateTime20) {
		this.customDateTime20 = customDateTime20;
	}

	@JsonProperty("customText21")
	public Object getCustomText21() {
		return customText21;
	}

	@JsonProperty("customText21")
	public void setCustomText21(Object customText21) {
		this.customText21 = customText21;
	}

	@JsonProperty("customBoolean21")
	public Object getCustomBoolean21() {
		return customBoolean21;
	}

	@JsonProperty("customBoolean21")
	public void setCustomBoolean21(Object customBoolean21) {
		this.customBoolean21 = customBoolean21;
	}

	@JsonProperty("customAmount21")
	public Object getCustomAmount21() {
		return customAmount21;
	}

	@JsonProperty("customAmount21")
	public void setCustomAmount21(Object customAmount21) {
		this.customAmount21 = customAmount21;
	}

	@JsonProperty("customLong21")
	public Object getCustomLong21() {
		return customLong21;
	}

	@JsonProperty("customLong21")
	public void setCustomLong21(Object customLong21) {
		this.customLong21 = customLong21;
	}

	@JsonProperty("customDate21")
	public Object getCustomDate21() {
		return customDate21;
	}

	@JsonProperty("customDate21")
	public void setCustomDate21(Object customDate21) {
		this.customDate21 = customDate21;
	}

	@JsonProperty("customDateTime21")
	public Object getCustomDateTime21() {
		return customDateTime21;
	}

	@JsonProperty("customDateTime21")
	public void setCustomDateTime21(Object customDateTime21) {
		this.customDateTime21 = customDateTime21;
	}

	@JsonProperty("customText22")
	public Object getCustomText22() {
		return customText22;
	}

	@JsonProperty("customText22")
	public void setCustomText22(Object customText22) {
		this.customText22 = customText22;
	}

	@JsonProperty("customBoolean22")
	public Object getCustomBoolean22() {
		return customBoolean22;
	}

	@JsonProperty("customBoolean22")
	public void setCustomBoolean22(Object customBoolean22) {
		this.customBoolean22 = customBoolean22;
	}

	@JsonProperty("customAmount22")
	public Object getCustomAmount22() {
		return customAmount22;
	}

	@JsonProperty("customAmount22")
	public void setCustomAmount22(Object customAmount22) {
		this.customAmount22 = customAmount22;
	}

	@JsonProperty("customLong22")
	public Object getCustomLong22() {
		return customLong22;
	}

	@JsonProperty("customLong22")
	public void setCustomLong22(Object customLong22) {
		this.customLong22 = customLong22;
	}

	@JsonProperty("customDate22")
	public Object getCustomDate22() {
		return customDate22;
	}

	@JsonProperty("customDate22")
	public void setCustomDate22(Object customDate22) {
		this.customDate22 = customDate22;
	}

	@JsonProperty("customDateTime22")
	public Object getCustomDateTime22() {
		return customDateTime22;
	}

	@JsonProperty("customDateTime22")
	public void setCustomDateTime22(Object customDateTime22) {
		this.customDateTime22 = customDateTime22;
	}

	@JsonProperty("customText23")
	public Object getCustomText23() {
		return customText23;
	}

	@JsonProperty("customText23")
	public void setCustomText23(Object customText23) {
		this.customText23 = customText23;
	}

	@JsonProperty("customBoolean23")
	public Object getCustomBoolean23() {
		return customBoolean23;
	}

	@JsonProperty("customBoolean23")
	public void setCustomBoolean23(Object customBoolean23) {
		this.customBoolean23 = customBoolean23;
	}

	@JsonProperty("customAmount23")
	public Object getCustomAmount23() {
		return customAmount23;
	}

	@JsonProperty("customAmount23")
	public void setCustomAmount23(Object customAmount23) {
		this.customAmount23 = customAmount23;
	}

	@JsonProperty("customLong23")
	public Object getCustomLong23() {
		return customLong23;
	}

	@JsonProperty("customLong23")
	public void setCustomLong23(Object customLong23) {
		this.customLong23 = customLong23;
	}

	@JsonProperty("customDate23")
	public Object getCustomDate23() {
		return customDate23;
	}

	@JsonProperty("customDate23")
	public void setCustomDate23(Object customDate23) {
		this.customDate23 = customDate23;
	}

	@JsonProperty("customDateTime23")
	public Object getCustomDateTime23() {
		return customDateTime23;
	}

	@JsonProperty("customDateTime23")
	public void setCustomDateTime23(Object customDateTime23) {
		this.customDateTime23 = customDateTime23;
	}

	@JsonProperty("customText24")
	public Object getCustomText24() {
		return customText24;
	}

	@JsonProperty("customText24")
	public void setCustomText24(Object customText24) {
		this.customText24 = customText24;
	}

	@JsonProperty("customBoolean24")
	public Object getCustomBoolean24() {
		return customBoolean24;
	}

	@JsonProperty("customBoolean24")
	public void setCustomBoolean24(Object customBoolean24) {
		this.customBoolean24 = customBoolean24;
	}

	@JsonProperty("customAmount24")
	public Object getCustomAmount24() {
		return customAmount24;
	}

	@JsonProperty("customAmount24")
	public void setCustomAmount24(Object customAmount24) {
		this.customAmount24 = customAmount24;
	}

	@JsonProperty("customLong24")
	public Object getCustomLong24() {
		return customLong24;
	}

	@JsonProperty("customLong24")
	public void setCustomLong24(Object customLong24) {
		this.customLong24 = customLong24;
	}

	@JsonProperty("customDate24")
	public Object getCustomDate24() {
		return customDate24;
	}

	@JsonProperty("customDate24")
	public void setCustomDate24(Object customDate24) {
		this.customDate24 = customDate24;
	}

	@JsonProperty("customDateTime24")
	public Object getCustomDateTime24() {
		return customDateTime24;
	}

	@JsonProperty("customDateTime24")
	public void setCustomDateTime24(Object customDateTime24) {
		this.customDateTime24 = customDateTime24;
	}

	@JsonProperty("customText25")
	public Object getCustomText25() {
		return customText25;
	}

	@JsonProperty("customText25")
	public void setCustomText25(Object customText25) {
		this.customText25 = customText25;
	}

	@JsonProperty("customBoolean25")
	public Object getCustomBoolean25() {
		return customBoolean25;
	}

	@JsonProperty("customBoolean25")
	public void setCustomBoolean25(Object customBoolean25) {
		this.customBoolean25 = customBoolean25;
	}

	@JsonProperty("customAmount25")
	public Object getCustomAmount25() {
		return customAmount25;
	}

	@JsonProperty("customAmount25")
	public void setCustomAmount25(Object customAmount25) {
		this.customAmount25 = customAmount25;
	}

	@JsonProperty("customLong25")
	public Object getCustomLong25() {
		return customLong25;
	}

	@JsonProperty("customLong25")
	public void setCustomLong25(Object customLong25) {
		this.customLong25 = customLong25;
	}

	@JsonProperty("customDate25")
	public Object getCustomDate25() {
		return customDate25;
	}

	@JsonProperty("customDate25")
	public void setCustomDate25(Object customDate25) {
		this.customDate25 = customDate25;
	}

	@JsonProperty("customDateTime25")
	public Object getCustomDateTime25() {
		return customDateTime25;
	}

	@JsonProperty("customDateTime25")
	public void setCustomDateTime25(Object customDateTime25) {
		this.customDateTime25 = customDateTime25;
	}

	@JsonProperty("customText26")
	public Object getCustomText26() {
		return customText26;
	}

	@JsonProperty("customText26")
	public void setCustomText26(Object customText26) {
		this.customText26 = customText26;
	}

	@JsonProperty("customBoolean26")
	public Object getCustomBoolean26() {
		return customBoolean26;
	}

	@JsonProperty("customBoolean26")
	public void setCustomBoolean26(Object customBoolean26) {
		this.customBoolean26 = customBoolean26;
	}

	@JsonProperty("customAmount26")
	public Object getCustomAmount26() {
		return customAmount26;
	}

	@JsonProperty("customAmount26")
	public void setCustomAmount26(Object customAmount26) {
		this.customAmount26 = customAmount26;
	}

	@JsonProperty("customLong26")
	public Object getCustomLong26() {
		return customLong26;
	}

	@JsonProperty("customLong26")
	public void setCustomLong26(Object customLong26) {
		this.customLong26 = customLong26;
	}

	@JsonProperty("customDate26")
	public Object getCustomDate26() {
		return customDate26;
	}

	@JsonProperty("customDate26")
	public void setCustomDate26(Object customDate26) {
		this.customDate26 = customDate26;
	}

	@JsonProperty("customDateTime26")
	public Object getCustomDateTime26() {
		return customDateTime26;
	}

	@JsonProperty("customDateTime26")
	public void setCustomDateTime26(Object customDateTime26) {
		this.customDateTime26 = customDateTime26;
	}

	@JsonProperty("customText27")
	public Object getCustomText27() {
		return customText27;
	}

	@JsonProperty("customText27")
	public void setCustomText27(Object customText27) {
		this.customText27 = customText27;
	}

	@JsonProperty("customBoolean27")
	public Object getCustomBoolean27() {
		return customBoolean27;
	}

	@JsonProperty("customBoolean27")
	public void setCustomBoolean27(Object customBoolean27) {
		this.customBoolean27 = customBoolean27;
	}

	@JsonProperty("customAmount27")
	public Object getCustomAmount27() {
		return customAmount27;
	}

	@JsonProperty("customAmount27")
	public void setCustomAmount27(Object customAmount27) {
		this.customAmount27 = customAmount27;
	}

	@JsonProperty("customLong27")
	public Object getCustomLong27() {
		return customLong27;
	}

	@JsonProperty("customLong27")
	public void setCustomLong27(Object customLong27) {
		this.customLong27 = customLong27;
	}

	@JsonProperty("customDate27")
	public Object getCustomDate27() {
		return customDate27;
	}

	@JsonProperty("customDate27")
	public void setCustomDate27(Object customDate27) {
		this.customDate27 = customDate27;
	}

	@JsonProperty("customDateTime27")
	public Object getCustomDateTime27() {
		return customDateTime27;
	}

	@JsonProperty("customDateTime27")
	public void setCustomDateTime27(Object customDateTime27) {
		this.customDateTime27 = customDateTime27;
	}

	@JsonProperty("customText28")
	public Object getCustomText28() {
		return customText28;
	}

	@JsonProperty("customText28")
	public void setCustomText28(Object customText28) {
		this.customText28 = customText28;
	}

	@JsonProperty("customBoolean28")
	public Object getCustomBoolean28() {
		return customBoolean28;
	}

	@JsonProperty("customBoolean28")
	public void setCustomBoolean28(Object customBoolean28) {
		this.customBoolean28 = customBoolean28;
	}

	@JsonProperty("customAmount28")
	public Object getCustomAmount28() {
		return customAmount28;
	}

	@JsonProperty("customAmount28")
	public void setCustomAmount28(Object customAmount28) {
		this.customAmount28 = customAmount28;
	}

	@JsonProperty("customLong28")
	public Object getCustomLong28() {
		return customLong28;
	}

	@JsonProperty("customLong28")
	public void setCustomLong28(Object customLong28) {
		this.customLong28 = customLong28;
	}

	@JsonProperty("customDate28")
	public Object getCustomDate28() {
		return customDate28;
	}

	@JsonProperty("customDate28")
	public void setCustomDate28(Object customDate28) {
		this.customDate28 = customDate28;
	}

	@JsonProperty("customDateTime28")
	public Object getCustomDateTime28() {
		return customDateTime28;
	}

	@JsonProperty("customDateTime28")
	public void setCustomDateTime28(Object customDateTime28) {
		this.customDateTime28 = customDateTime28;
	}

	@JsonProperty("customText29")
	public Object getCustomText29() {
		return customText29;
	}

	@JsonProperty("customText29")
	public void setCustomText29(Object customText29) {
		this.customText29 = customText29;
	}

	@JsonProperty("customBoolean29")
	public Object getCustomBoolean29() {
		return customBoolean29;
	}

	@JsonProperty("customBoolean29")
	public void setCustomBoolean29(Object customBoolean29) {
		this.customBoolean29 = customBoolean29;
	}

	@JsonProperty("customAmount29")
	public Object getCustomAmount29() {
		return customAmount29;
	}

	@JsonProperty("customAmount29")
	public void setCustomAmount29(Object customAmount29) {
		this.customAmount29 = customAmount29;
	}

	@JsonProperty("customLong29")
	public Object getCustomLong29() {
		return customLong29;
	}

	@JsonProperty("customLong29")
	public void setCustomLong29(Object customLong29) {
		this.customLong29 = customLong29;
	}

	@JsonProperty("customDate29")
	public Object getCustomDate29() {
		return customDate29;
	}

	@JsonProperty("customDate29")
	public void setCustomDate29(Object customDate29) {
		this.customDate29 = customDate29;
	}

	@JsonProperty("customDateTime29")
	public Object getCustomDateTime29() {
		return customDateTime29;
	}

	@JsonProperty("customDateTime29")
	public void setCustomDateTime29(Object customDateTime29) {
		this.customDateTime29 = customDateTime29;
	}

	@JsonProperty("customText30")
	public Object getCustomText30() {
		return customText30;
	}

	@JsonProperty("customText30")
	public void setCustomText30(Object customText30) {
		this.customText30 = customText30;
	}

	@JsonProperty("customBoolean30")
	public Object getCustomBoolean30() {
		return customBoolean30;
	}

	@JsonProperty("customBoolean30")
	public void setCustomBoolean30(Object customBoolean30) {
		this.customBoolean30 = customBoolean30;
	}

	@JsonProperty("customAmount30")
	public Object getCustomAmount30() {
		return customAmount30;
	}

	@JsonProperty("customAmount30")
	public void setCustomAmount30(Object customAmount30) {
		this.customAmount30 = customAmount30;
	}

	@JsonProperty("customLong30")
	public Object getCustomLong30() {
		return customLong30;
	}

	@JsonProperty("customLong30")
	public void setCustomLong30(Object customLong30) {
		this.customLong30 = customLong30;
	}

	@JsonProperty("customDate30")
	public Object getCustomDate30() {
		return customDate30;
	}

	@JsonProperty("customDate30")
	public void setCustomDate30(Object customDate30) {
		this.customDate30 = customDate30;
	}

	@JsonProperty("customDateTime30")
	public Object getCustomDateTime30() {
		return customDateTime30;
	}

	@JsonProperty("customDateTime30")
	public void setCustomDateTime30(Object customDateTime30) {
		this.customDateTime30 = customDateTime30;
	}

	@JsonProperty("replacementProductName")
	public Object getReplacementProductName() {
		return replacementProductName;
	}

	@JsonProperty("replacementProductName")
	public void setReplacementProductName(Object replacementProductName) {
		this.replacementProductName = replacementProductName;
	}

	@JsonProperty("contractObligation")
	public Object getContractObligation() {
		return contractObligation;
	}

	@JsonProperty("contractObligation")
	public void setContractObligation(Object contractObligation) {
		this.contractObligation = contractObligation;
	}

	@JsonProperty("residualProductName")
	public Object getResidualProductName() {
		return residualProductName;
	}

	@JsonProperty("residualProductName")
	public void setResidualProductName(Object residualProductName) {
		this.residualProductName = residualProductName;
	}

	@JsonProperty("competitionProductsName")
	public Object getCompetitionProductsName() {
		return competitionProductsName;
	}

	@JsonProperty("competitionProductsName")
	public void setCompetitionProductsName(Object competitionProductsName) {
		this.competitionProductsName = competitionProductsName;
	}

	@JsonProperty("salesPotenzial")
	public Object getSalesPotenzial() {
		return salesPotenzial;
	}

	@JsonProperty("salesPotenzial")
	public void setSalesPotenzial(Object salesPotenzial) {
		this.salesPotenzial = salesPotenzial;
	}

	@JsonProperty("salesUpgrade")
	public Object getSalesUpgrade() {
		return salesUpgrade;
	}

	@JsonProperty("salesUpgrade")
	public void setSalesUpgrade(Object salesUpgrade) {
		this.salesUpgrade = salesUpgrade;
	}

	@JsonProperty("servicePartnerName")
	public Object getServicePartnerName() {
		return servicePartnerName;
	}

	@JsonProperty("servicePartnerName")
	public void setServicePartnerName(Object servicePartnerName) {
		this.servicePartnerName = servicePartnerName;
	}

	@JsonProperty("competitiveStrength")
	public Object getCompetitiveStrength() {
		return competitiveStrength;
	}

	@JsonProperty("competitiveStrength")
	public void setCompetitiveStrength(Object competitiveStrength) {
		this.competitiveStrength = competitiveStrength;
	}

	@JsonProperty("deliveryTermPriority")
	public Object getDeliveryTermPriority() {
		return deliveryTermPriority;
	}

	@JsonProperty("deliveryTermPriority")
	public void setDeliveryTermPriority(Object deliveryTermPriority) {
		this.deliveryTermPriority = deliveryTermPriority;
	}

	@JsonProperty("deliveryTermCompleteDelivery")
	public Object getDeliveryTermCompleteDelivery() {
		return deliveryTermCompleteDelivery;
	}

	@JsonProperty("deliveryTermCompleteDelivery")
	public void setDeliveryTermCompleteDelivery(Object deliveryTermCompleteDelivery) {
		this.deliveryTermCompleteDelivery = deliveryTermCompleteDelivery;
	}

	@JsonProperty("deliveryTermIncoterm")
	public Object getDeliveryTermIncoterm() {
		return deliveryTermIncoterm;
	}

	@JsonProperty("deliveryTermIncoterm")
	public void setDeliveryTermIncoterm(Object deliveryTermIncoterm) {
		this.deliveryTermIncoterm = deliveryTermIncoterm;
	}

	@JsonProperty("deliveryTermIncotermLocation")
	public Object getDeliveryTermIncotermLocation() {
		return deliveryTermIncotermLocation;
	}

	@JsonProperty("deliveryTermIncotermLocation")
	public void setDeliveryTermIncotermLocation(Object deliveryTermIncotermLocation) {
		this.deliveryTermIncotermLocation = deliveryTermIncotermLocation;
	}

	@JsonProperty("dueDate")
	public Object getDueDate() {
		return dueDate;
	}

	@JsonProperty("dueDate")
	public void setDueDate(Object dueDate) {
		this.dueDate = dueDate;
	}

	@JsonProperty("reminderDate")
	public Object getReminderDate() {
		return reminderDate;
	}

	@JsonProperty("reminderDate")
	public void setReminderDate(Object reminderDate) {
		this.reminderDate = reminderDate;
	}

	@JsonProperty("campaignPersonDisplay")
	public Object getCampaignPersonDisplay() {
		return campaignPersonDisplay;
	}

	@JsonProperty("campaignPersonDisplay")
	public void setCampaignPersonDisplay(Object campaignPersonDisplay) {
		this.campaignPersonDisplay = campaignPersonDisplay;
	}

	@JsonProperty("leadPersonId")
	public Object getLeadPersonId() {
		return leadPersonId;
	}

	@JsonProperty("leadPersonId")
	public void setLeadPersonId(Object leadPersonId) {
		this.leadPersonId = leadPersonId;
	}

	@JsonProperty("leadPersonDisplay")
	public Object getLeadPersonDisplay() {
		return leadPersonDisplay;
	}

	@JsonProperty("leadPersonDisplay")
	public void setLeadPersonDisplay(Object leadPersonDisplay) {
		this.leadPersonDisplay = leadPersonDisplay;
	}

	@JsonProperty("leadLastSeenByLeadPerson")
	public Object getLeadLastSeenByLeadPerson() {
		return leadLastSeenByLeadPerson;
	}

	@JsonProperty("leadLastSeenByLeadPerson")
	public void setLeadLastSeenByLeadPerson(Object leadLastSeenByLeadPerson) {
		this.leadLastSeenByLeadPerson = leadLastSeenByLeadPerson;
	}

	@JsonProperty("leadClassification")
	public Object getLeadClassification() {
		return leadClassification;
	}

	@JsonProperty("leadClassification")
	public void setLeadClassification(Object leadClassification) {
		this.leadClassification = leadClassification;
	}

	@JsonProperty("leadIdentification")
	public Object getLeadIdentification() {
		return leadIdentification;
	}

	@JsonProperty("leadIdentification")
	public void setLeadIdentification(Object leadIdentification) {
		this.leadIdentification = leadIdentification;
	}

	@JsonProperty("leadQualification")
	public Object getLeadQualification() {
		return leadQualification;
	}

	@JsonProperty("leadQualification")
	public void setLeadQualification(Object leadQualification) {
		this.leadQualification = leadQualification;
	}

	@JsonProperty("leadQualificationRange")
	public Object getLeadQualificationRange() {
		return leadQualificationRange;
	}

	@JsonProperty("leadQualificationRange")
	public void setLeadQualificationRange(Object leadQualificationRange) {
		this.leadQualificationRange = leadQualificationRange;
	}

	@JsonProperty("leadBudget")
	public Object getLeadBudget() {
		return leadBudget;
	}

	@JsonProperty("leadBudget")
	public void setLeadBudget(Object leadBudget) {
		this.leadBudget = leadBudget;
	}

	@JsonProperty("leadBudgetPoints")
	public Object getLeadBudgetPoints() {
		return leadBudgetPoints;
	}

	@JsonProperty("leadBudgetPoints")
	public void setLeadBudgetPoints(Object leadBudgetPoints) {
		this.leadBudgetPoints = leadBudgetPoints;
	}

	@JsonProperty("leadAuthority")
	public Object getLeadAuthority() {
		return leadAuthority;
	}

	@JsonProperty("leadAuthority")
	public void setLeadAuthority(Object leadAuthority) {
		this.leadAuthority = leadAuthority;
	}

	@JsonProperty("leadAuthorityPoints")
	public Object getLeadAuthorityPoints() {
		return leadAuthorityPoints;
	}

	@JsonProperty("leadAuthorityPoints")
	public void setLeadAuthorityPoints(Object leadAuthorityPoints) {
		this.leadAuthorityPoints = leadAuthorityPoints;
	}

	@JsonProperty("leadNeed")
	public Object getLeadNeed() {
		return leadNeed;
	}

	@JsonProperty("leadNeed")
	public void setLeadNeed(Object leadNeed) {
		this.leadNeed = leadNeed;
	}

	@JsonProperty("leadNeedPoints")
	public Object getLeadNeedPoints() {
		return leadNeedPoints;
	}

	@JsonProperty("leadNeedPoints")
	public void setLeadNeedPoints(Object leadNeedPoints) {
		this.leadNeedPoints = leadNeedPoints;
	}

	@JsonProperty("leadTime")
	public Object getLeadTime() {
		return leadTime;
	}

	@JsonProperty("leadTime")
	public void setLeadTime(Object leadTime) {
		this.leadTime = leadTime;
	}

	@JsonProperty("leadTimePoints")
	public Object getLeadTimePoints() {
		return leadTimePoints;
	}

	@JsonProperty("leadTimePoints")
	public void setLeadTimePoints(Object leadTimePoints) {
		this.leadTimePoints = leadTimePoints;
	}

	@JsonProperty("leadSumPoints")
	public Object getLeadSumPoints() {
		return leadSumPoints;
	}

	@JsonProperty("leadSumPoints")
	public void setLeadSumPoints(Object leadSumPoints) {
		this.leadSumPoints = leadSumPoints;
	}

	@JsonProperty("leadTransfer")
	public Object getLeadTransfer() {
		return leadTransfer;
	}

	@JsonProperty("leadTransfer")
	public void setLeadTransfer(Object leadTransfer) {
		this.leadTransfer = leadTransfer;
	}

	@JsonProperty("leadNotice")
	public Object getLeadNotice() {
		return leadNotice;
	}

	@JsonProperty("leadNotice")
	public void setLeadNotice(Object leadNotice) {
		this.leadNotice = leadNotice;
	}

	@JsonProperty("leadBudgetSum")
	public Object getLeadBudgetSum() {
		return leadBudgetSum;
	}

	@JsonProperty("leadBudgetSum")
	public void setLeadBudgetSum(Object leadBudgetSum) {
		this.leadBudgetSum = leadBudgetSum;
	}

	@JsonProperty("partnerPersonDisplay")
	public Object getPartnerPersonDisplay() {
		return partnerPersonDisplay;
	}

	@JsonProperty("partnerPersonDisplay")
	public void setPartnerPersonDisplay(Object partnerPersonDisplay) {
		this.partnerPersonDisplay = partnerPersonDisplay;
	}

	@JsonProperty("partnerType")
	public Object getPartnerType() {
		return partnerType;
	}

	@JsonProperty("partnerType")
	public void setPartnerType(Object partnerType) {
		this.partnerType = partnerType;
	}

	@JsonProperty("partnerStatus")
	public Object getPartnerStatus() {
		return partnerStatus;
	}

	@JsonProperty("partnerStatus")
	public void setPartnerStatus(Object partnerStatus) {
		this.partnerStatus = partnerStatus;
	}

	@JsonProperty("partnerDateBegin")
	public Object getPartnerDateBegin() {
		return partnerDateBegin;
	}

	@JsonProperty("partnerDateBegin")
	public void setPartnerDateBegin(Object partnerDateBegin) {
		this.partnerDateBegin = partnerDateBegin;
	}

	@JsonProperty("partnerDateEnd")
	public Object getPartnerDateEnd() {
		return partnerDateEnd;
	}

	@JsonProperty("partnerDateEnd")
	public void setPartnerDateEnd(Object partnerDateEnd) {
		this.partnerDateEnd = partnerDateEnd;
	}

	@JsonProperty("partnerClassification")
	public Object getPartnerClassification() {
		return partnerClassification;
	}

	@JsonProperty("partnerClassification")
	public void setPartnerClassification(Object partnerClassification) {
		this.partnerClassification = partnerClassification;
	}

	@JsonProperty("partnerExperience")
	public Object getPartnerExperience() {
		return partnerExperience;
	}

	@JsonProperty("partnerExperience")
	public void setPartnerExperience(Object partnerExperience) {
		this.partnerExperience = partnerExperience;
	}

	@JsonProperty("salesPersonId")
	public Object getSalesPersonId() {
		return salesPersonId;
	}

	@JsonProperty("salesPersonId")
	public void setSalesPersonId(Object salesPersonId) {
		this.salesPersonId = salesPersonId;
	}

	@JsonProperty("salesPersonDisplay")
	public Object getSalesPersonDisplay() {
		return salesPersonDisplay;
	}

	@JsonProperty("salesPersonDisplay")
	public void setSalesPersonDisplay(Object salesPersonDisplay) {
		this.salesPersonDisplay = salesPersonDisplay;
	}

	@JsonProperty("salesConsumerType")
	public Object getSalesConsumerType() {
		return salesConsumerType;
	}

	@JsonProperty("salesConsumerType")
	public void setSalesConsumerType(Object salesConsumerType) {
		this.salesConsumerType = salesConsumerType;
	}

	@JsonProperty("salesKontaktType")
	public Object getSalesKontaktType() {
		return salesKontaktType;
	}

	@JsonProperty("salesKontaktType")
	public void setSalesKontaktType(Object salesKontaktType) {
		this.salesKontaktType = salesKontaktType;
	}

	@JsonProperty("source")
	public Object getSource() {
		return source;
	}

	@JsonProperty("source")
	public void setSource(Object source) {
		this.source = source;
	}

	@JsonProperty("salesChannel")
	public Object getSalesChannel() {
		return salesChannel;
	}

	@JsonProperty("salesChannel")
	public void setSalesChannel(Object salesChannel) {
		this.salesChannel = salesChannel;
	}

	@JsonProperty("interestedLastSeenBySalesPerson")
	public Object getInterestedLastSeenBySalesPerson() {
		return interestedLastSeenBySalesPerson;
	}

	@JsonProperty("interestedLastSeenBySalesPerson")
	public void setInterestedLastSeenBySalesPerson(Object interestedLastSeenBySalesPerson) {
		this.interestedLastSeenBySalesPerson = interestedLastSeenBySalesPerson;
	}

	@JsonProperty("salesInternalOrganisation")
	public Object getSalesInternalOrganisation() {
		return salesInternalOrganisation;
	}

	@JsonProperty("salesInternalOrganisation")
	public void setSalesInternalOrganisation(Object salesInternalOrganisation) {
		this.salesInternalOrganisation = salesInternalOrganisation;
	}

	@JsonProperty("salesNielsenRegion")
	public Object getSalesNielsenRegion() {
		return salesNielsenRegion;
	}

	@JsonProperty("salesNielsenRegion")
	public void setSalesNielsenRegion(Object salesNielsenRegion) {
		this.salesNielsenRegion = salesNielsenRegion;
	}

	@JsonProperty("salesRegion")
	public Object getSalesRegion() {
		return salesRegion;
	}

	@JsonProperty("salesRegion")
	public void setSalesRegion(Object salesRegion) {
		this.salesRegion = salesRegion;
	}

	@JsonProperty("salesRisk")
	public Object getSalesRisk() {
		return salesRisk;
	}

	@JsonProperty("salesRisk")
	public void setSalesRisk(Object salesRisk) {
		this.salesRisk = salesRisk;
	}

	@JsonProperty("salesPriority")
	public Object getSalesPriority() {
		return salesPriority;
	}

	@JsonProperty("salesPriority")
	public void setSalesPriority(Object salesPriority) {
		this.salesPriority = salesPriority;
	}

	@JsonProperty("salesBehavior")
	public Object getSalesBehavior() {
		return salesBehavior;
	}

	@JsonProperty("salesBehavior")
	public void setSalesBehavior(Object salesBehavior) {
		this.salesBehavior = salesBehavior;
	}

	@JsonProperty("salesPhase")
	public Object getSalesPhase() {
		return salesPhase;
	}

	@JsonProperty("salesPhase")
	public void setSalesPhase(Object salesPhase) {
		this.salesPhase = salesPhase;
	}

	@JsonProperty("salesStatus")
	public Object getSalesStatus() {
		return salesStatus;
	}

	@JsonProperty("salesStatus")
	public void setSalesStatus(Object salesStatus) {
		this.salesStatus = salesStatus;
	}

	@JsonProperty("salesActivity")
	public Object getSalesActivity() {
		return salesActivity;
	}

	@JsonProperty("salesActivity")
	public void setSalesActivity(Object salesActivity) {
		this.salesActivity = salesActivity;
	}

	@JsonProperty("salesContractPersonName")
	public Object getSalesContractPersonName() {
		return salesContractPersonName;
	}

	@JsonProperty("salesContractPersonName")
	public void setSalesContractPersonName(Object salesContractPersonName) {
		this.salesContractPersonName = salesContractPersonName;
	}

	@JsonProperty("salesCampaignName")
	public Object getSalesCampaignName() {
		return salesCampaignName;
	}

	@JsonProperty("salesCampaignName")
	public void setSalesCampaignName(Object salesCampaignName) {
		this.salesCampaignName = salesCampaignName;
	}

	@JsonProperty("salesReminderFrom")
	public Object getSalesReminderFrom() {
		return salesReminderFrom;
	}

	@JsonProperty("salesReminderFrom")
	public void setSalesReminderFrom(Object salesReminderFrom) {
		this.salesReminderFrom = salesReminderFrom;
	}

	@JsonProperty("salesReminderTo")
	public Object getSalesReminderTo() {
		return salesReminderTo;
	}

	@JsonProperty("salesReminderTo")
	public void setSalesReminderTo(Object salesReminderTo) {
		this.salesReminderTo = salesReminderTo;
	}

	@JsonProperty("salesTemplate")
	public Object getSalesTemplate() {
		return salesTemplate;
	}

	@JsonProperty("salesTemplate")
	public void setSalesTemplate(Object salesTemplate) {
		this.salesTemplate = salesTemplate;
	}

	@JsonProperty("salesDescription")
	public Object getSalesDescription() {
		return salesDescription;
	}

	@JsonProperty("salesDescription")
	public void setSalesDescription(Object salesDescription) {
		this.salesDescription = salesDescription;
	}

	@JsonProperty("segmentationAudience")
	public Object getSegmentationAudience() {
		return segmentationAudience;
	}

	@JsonProperty("segmentationAudience")
	public void setSegmentationAudience(Object segmentationAudience) {
		this.segmentationAudience = segmentationAudience;
	}

	@JsonProperty("segmentationEducationalBackground")
	public Object getSegmentationEducationalBackground() {
		return segmentationEducationalBackground;
	}

	@JsonProperty("segmentationEducationalBackground")
	public void setSegmentationEducationalBackground(Object segmentationEducationalBackground) {
		this.segmentationEducationalBackground = segmentationEducationalBackground;
	}

	@JsonProperty("segmentationIncomeGroup")
	public Object getSegmentationIncomeGroup() {
		return segmentationIncomeGroup;
	}

	@JsonProperty("segmentationIncomeGroup")
	public void setSegmentationIncomeGroup(Object segmentationIncomeGroup) {
		this.segmentationIncomeGroup = segmentationIncomeGroup;
	}

	@JsonProperty("segmentationAttitude")
	public Object getSegmentationAttitude() {
		return segmentationAttitude;
	}

	@JsonProperty("segmentationAttitude")
	public void setSegmentationAttitude(Object segmentationAttitude) {
		this.segmentationAttitude = segmentationAttitude;
	}

	@JsonProperty("segmentationMotivation")
	public Object getSegmentationMotivation() {
		return segmentationMotivation;
	}

	@JsonProperty("segmentationMotivation")
	public void setSegmentationMotivation(Object segmentationMotivation) {
		this.segmentationMotivation = segmentationMotivation;
	}

	@JsonProperty("segmentationBuyingBehavior")
	public Object getSegmentationBuyingBehavior() {
		return segmentationBuyingBehavior;
	}

	@JsonProperty("segmentationBuyingBehavior")
	public void setSegmentationBuyingBehavior(Object segmentationBuyingBehavior) {
		this.segmentationBuyingBehavior = segmentationBuyingBehavior;
	}

	@JsonProperty("segmentationLifestyle")
	public Object getSegmentationLifestyle() {
		return segmentationLifestyle;
	}

	@JsonProperty("segmentationLifestyle")
	public void setSegmentationLifestyle(Object segmentationLifestyle) {
		this.segmentationLifestyle = segmentationLifestyle;
	}

	@JsonProperty("segmentationCustomerBehavior")
	public Object getSegmentationCustomerBehavior() {
		return segmentationCustomerBehavior;
	}

	@JsonProperty("segmentationCustomerBehavior")
	public void setSegmentationCustomerBehavior(Object segmentationCustomerBehavior) {
		this.segmentationCustomerBehavior = segmentationCustomerBehavior;
	}

	@JsonProperty("sphereInterested")
	public Object getSphereInterested() {
		return sphereInterested;
	}

	@JsonProperty("sphereInterested")
	public void setSphereInterested(Object sphereInterested) {
		this.sphereInterested = sphereInterested;
	}

	@JsonProperty("sphereLead")
	public Object getSphereLead() {
		return sphereLead;
	}

	@JsonProperty("sphereLead")
	public void setSphereLead(Object sphereLead) {
		this.sphereLead = sphereLead;
	}

	@JsonProperty("sphereCustomer")
	public Object getSphereCustomer() {
		return sphereCustomer;
	}

	@JsonProperty("sphereCustomer")
	public void setSphereCustomer(Object sphereCustomer) {
		this.sphereCustomer = sphereCustomer;
	}

	@JsonProperty("sphereVendor")
	public Object getSphereVendor() {
		return sphereVendor;
	}

	@JsonProperty("sphereVendor")
	public void setSphereVendor(Object sphereVendor) {
		this.sphereVendor = sphereVendor;
	}

	@JsonProperty("sphereDebitor")
	public Object getSphereDebitor() {
		return sphereDebitor;
	}

	@JsonProperty("sphereDebitor")
	public void setSphereDebitor(Object sphereDebitor) {
		this.sphereDebitor = sphereDebitor;
	}

	@JsonProperty("sphereKreditor")
	public Object getSphereKreditor() {
		return sphereKreditor;
	}

	@JsonProperty("sphereKreditor")
	public void setSphereKreditor(Object sphereKreditor) {
		this.sphereKreditor = sphereKreditor;
	}

	@JsonProperty("sphereEmployee")
	public Object getSphereEmployee() {
		return sphereEmployee;
	}

	@JsonProperty("sphereEmployee")
	public void setSphereEmployee(Object sphereEmployee) {
		this.sphereEmployee = sphereEmployee;
	}

	@JsonProperty("spherePartner")
	public Object getSpherePartner() {
		return spherePartner;
	}

	@JsonProperty("spherePartner")
	public void setSpherePartner(Object spherePartner) {
		this.spherePartner = spherePartner;
	}

	@JsonProperty("sphereWorker")
	public Object getSphereWorker() {
		return sphereWorker;
	}

	@JsonProperty("sphereWorker")
	public void setSphereWorker(Object sphereWorker) {
		this.sphereWorker = sphereWorker;
	}

	@JsonProperty("statusLeadDisplay")
	public Object getStatusLeadDisplay() {
		return statusLeadDisplay;
	}

	@JsonProperty("statusLeadDisplay")
	public void setStatusLeadDisplay(Object statusLeadDisplay) {
		this.statusLeadDisplay = statusLeadDisplay;
	}

	@JsonProperty("statusInterestedDisplay")
	public Object getStatusInterestedDisplay() {
		return statusInterestedDisplay;
	}

	@JsonProperty("statusInterestedDisplay")
	public void setStatusInterestedDisplay(Object statusInterestedDisplay) {
		this.statusInterestedDisplay = statusInterestedDisplay;
	}

	@JsonProperty("statusCustomerDisplay")
	public Object getStatusCustomerDisplay() {
		return statusCustomerDisplay;
	}

	@JsonProperty("statusCustomerDisplay")
	public void setStatusCustomerDisplay(Object statusCustomerDisplay) {
		this.statusCustomerDisplay = statusCustomerDisplay;
	}

	@JsonProperty("sphereOrganisationUser")
	public Object getSphereOrganisationUser() {
		return sphereOrganisationUser;
	}

	@JsonProperty("sphereOrganisationUser")
	public void setSphereOrganisationUser(Object sphereOrganisationUser) {
		this.sphereOrganisationUser = sphereOrganisationUser;
	}

	@JsonProperty("sphereImplementation")
	public Object getSphereImplementation() {
		return sphereImplementation;
	}

	@JsonProperty("sphereImplementation")
	public void setSphereImplementation(Object sphereImplementation) {
		this.sphereImplementation = sphereImplementation;
	}

	@JsonProperty("sphereBilling")
	public Object getSphereBilling() {
		return sphereBilling;
	}

	@JsonProperty("sphereBilling")
	public void setSphereBilling(Object sphereBilling) {
		this.sphereBilling = sphereBilling;
	}

	@JsonProperty("interestedClassification")
	public Object getInterestedClassification() {
		return interestedClassification;
	}

	@JsonProperty("interestedClassification")
	public void setInterestedClassification(Object interestedClassification) {
		this.interestedClassification = interestedClassification;
	}

	@JsonProperty("interestedQualification")
	public Object getInterestedQualification() {
		return interestedQualification;
	}

	@JsonProperty("interestedQualification")
	public void setInterestedQualification(Object interestedQualification) {
		this.interestedQualification = interestedQualification;
	}

	@JsonProperty("interestedQualificationRange")
	public Object getInterestedQualificationRange() {
		return interestedQualificationRange;
	}

	@JsonProperty("interestedQualificationRange")
	public void setInterestedQualificationRange(Object interestedQualificationRange) {
		this.interestedQualificationRange = interestedQualificationRange;
	}

	@JsonProperty("interestedBudget")
	public Object getInterestedBudget() {
		return interestedBudget;
	}

	@JsonProperty("interestedBudget")
	public void setInterestedBudget(Object interestedBudget) {
		this.interestedBudget = interestedBudget;
	}

	@JsonProperty("interestedBudgetSum")
	public Object getInterestedBudgetSum() {
		return interestedBudgetSum;
	}

	@JsonProperty("interestedBudgetSum")
	public void setInterestedBudgetSum(Object interestedBudgetSum) {
		this.interestedBudgetSum = interestedBudgetSum;
	}

	@JsonProperty("interestedBudgetPoints")
	public Object getInterestedBudgetPoints() {
		return interestedBudgetPoints;
	}

	@JsonProperty("interestedBudgetPoints")
	public void setInterestedBudgetPoints(Object interestedBudgetPoints) {
		this.interestedBudgetPoints = interestedBudgetPoints;
	}

	@JsonProperty("interestedAuthority")
	public Object getInterestedAuthority() {
		return interestedAuthority;
	}

	@JsonProperty("interestedAuthority")
	public void setInterestedAuthority(Object interestedAuthority) {
		this.interestedAuthority = interestedAuthority;
	}

	@JsonProperty("interestedAuthorityPoints")
	public Object getInterestedAuthorityPoints() {
		return interestedAuthorityPoints;
	}

	@JsonProperty("interestedAuthorityPoints")
	public void setInterestedAuthorityPoints(Object interestedAuthorityPoints) {
		this.interestedAuthorityPoints = interestedAuthorityPoints;
	}

	@JsonProperty("interestedNeed")
	public Object getInterestedNeed() {
		return interestedNeed;
	}

	@JsonProperty("interestedNeed")
	public void setInterestedNeed(Object interestedNeed) {
		this.interestedNeed = interestedNeed;
	}

	@JsonProperty("interestedNeedPoints")
	public Object getInterestedNeedPoints() {
		return interestedNeedPoints;
	}

	@JsonProperty("interestedNeedPoints")
	public void setInterestedNeedPoints(Object interestedNeedPoints) {
		this.interestedNeedPoints = interestedNeedPoints;
	}

	@JsonProperty("interestedTime")
	public Object getInterestedTime() {
		return interestedTime;
	}

	@JsonProperty("interestedTime")
	public void setInterestedTime(Object interestedTime) {
		this.interestedTime = interestedTime;
	}

	@JsonProperty("interestedTimePoints")
	public Object getInterestedTimePoints() {
		return interestedTimePoints;
	}

	@JsonProperty("interestedTimePoints")
	public void setInterestedTimePoints(Object interestedTimePoints) {
		this.interestedTimePoints = interestedTimePoints;
	}

	@JsonProperty("interestedSumPoints")
	public Object getInterestedSumPoints() {
		return interestedSumPoints;
	}

	@JsonProperty("interestedSumPoints")
	public void setInterestedSumPoints(Object interestedSumPoints) {
		this.interestedSumPoints = interestedSumPoints;
	}

	@JsonProperty("interestedTransfer")
	public Object getInterestedTransfer() {
		return interestedTransfer;
	}

	@JsonProperty("interestedTransfer")
	public void setInterestedTransfer(Object interestedTransfer) {
		this.interestedTransfer = interestedTransfer;
	}

	@JsonProperty("permissionDisplay")
	public String getPermissionDisplay() {
		return permissionDisplay;
	}

	@JsonProperty("permissionDisplay")
	public void setPermissionDisplay(String permissionDisplay) {
		this.permissionDisplay = permissionDisplay;
	}

	@JsonProperty("ownerUid")
	public String getOwnerUid() {
		return ownerUid;
	}

	@JsonProperty("ownerUid")
	public void setOwnerUid(String ownerUid) {
		this.ownerUid = ownerUid;
	}

	@JsonProperty("permissionType")
	public Long getPermissionType() {
		return permissionType;
	}

	@JsonProperty("permissionType")
	public void setPermissionType(Long permissionType) {
		this.permissionType = permissionType;
	}

	@JsonProperty("readPermissionProfiles")
	public Object getReadPermissionProfiles() {
		return readPermissionProfiles;
	}

	@JsonProperty("readPermissionProfiles")
	public void setReadPermissionProfiles(Object readPermissionProfiles) {
		this.readPermissionProfiles = readPermissionProfiles;
	}

	@JsonProperty("readPermissionUids")
	public Object getReadPermissionUids() {
		return readPermissionUids;
	}

	@JsonProperty("readPermissionUids")
	public void setReadPermissionUids(Object readPermissionUids) {
		this.readPermissionUids = readPermissionUids;
	}

	@JsonProperty("writePermissionProfiles")
	public Object getWritePermissionProfiles() {
		return writePermissionProfiles;
	}

	@JsonProperty("writePermissionProfiles")
	public void setWritePermissionProfiles(Object writePermissionProfiles) {
		this.writePermissionProfiles = writePermissionProfiles;
	}

	@JsonProperty("writePermissionUids")
	public Object getWritePermissionUids() {
		return writePermissionUids;
	}

	@JsonProperty("writePermissionUids")
	public void setWritePermissionUids(Object writePermissionUids) {
		this.writePermissionUids = writePermissionUids;
	}

	@JsonProperty("centerdeviceCollectionName")
	public Object getCenterdeviceCollectionName() {
		return centerdeviceCollectionName;
	}

	@JsonProperty("centerdeviceCollectionName")
	public void setCenterdeviceCollectionName(Object centerdeviceCollectionName) {
		this.centerdeviceCollectionName = centerdeviceCollectionName;
	}

	@JsonProperty("centerdeviceCollectionId")
	public Object getCenterdeviceCollectionId() {
		return centerdeviceCollectionId;
	}

	@JsonProperty("centerdeviceCollectionId")
	public void setCenterdeviceCollectionId(Object centerdeviceCollectionId) {
		this.centerdeviceCollectionId = centerdeviceCollectionId;
	}

	@JsonProperty("mail")
	public Object getMail() {
		return mail;
	}

	@JsonProperty("mail")
	public void setMail(Object mail) {
		this.mail = mail;
	}

	@JsonProperty("entryTypeDisplay")
	public Object getEntryTypeDisplay() {
		return entryTypeDisplay;
	}

	@JsonProperty("entryTypeDisplay")
	public void setEntryTypeDisplay(Object entryTypeDisplay) {
		this.entryTypeDisplay = entryTypeDisplay;
	}

	@JsonProperty("entryType")
	public Object getEntryType() {
		return entryType;
	}

	@JsonProperty("entryType")
	public void setEntryType(Object entryType) {
		this.entryType = entryType;
	}

	@JsonProperty("childId")
	public Object getChildId() {
		return childId;
	}

	@JsonProperty("childId")
	public void setChildId(Object childId) {
		this.childId = childId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}