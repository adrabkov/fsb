package de.alectogmbh.friendsurance.automation.tests.web.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class HvbMessages {
    @SerializedName("personal_details_headline")
    @Expose
    private String personalDetailsHeadline;
    @SerializedName("add_contract_page_headline")
    @Expose
    private String addContractPageHeadline;
    @SerializedName("bank_selection_headline")
    @Expose
    private String bankSelectionHeadline;
    @SerializedName("dashboard_headline")
    @Expose
    private String dashboardHeadline;
    @SerializedName("edit_order_page_headline")
    @Expose
    private String editOrderPageHeadline;
    @SerializedName("login_page_headline")
    @Expose
    private String loginPageHeadline;
    @SerializedName("insurance_information_headline")
    @Expose
    private String insuranceInformationHeadline;
    @SerializedName("order_overview_headline")
    @Expose
    private String orderOverviewHeadline;
    @SerializedName("ona_intro_headline")
    @Expose
    private String onaIntroHeadline;
    @SerializedName("ona_intro_headline_text_during_onboarding")
    @Expose
    private String onaIntroHeadlineTextDuringOnboarding;
    @SerializedName("sign_order_page_headline")
    @Expose
    private String signOrderPageHeadline;
    @SerializedName("sign_up_page_headline")
    @Expose
    private String signUpPageHeadline;
    @SerializedName("bank_conditions_headline")
    @Expose
    private String bankConditionsHeadline;
}
