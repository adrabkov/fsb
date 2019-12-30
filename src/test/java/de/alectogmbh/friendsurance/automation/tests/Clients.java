package de.alectogmbh.friendsurance.automation.tests;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbProfilePage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.*;
import de.alectogmbh.friendsurance.automation.tests.web.utils.HvbMessages;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import lombok.Getter;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

@Getter
public class Clients extends AbstractScenarioSteps {

    @Steps
    private HvbBankSelectionSteps hvbBankSelectionSteps;

    @Steps
    private HvbInsuranceInformationSteps hvbInsuranceInformationSteps;

    @Steps
    private HvbTermsConditionsSteps hvbTermsConditionsSteps;

    @Steps
    private HvbFinApiWebFormSteps hvbFinApiWebFormSteps;

    @Steps
    private HvbPersonalDetailsSteps hvbPersonalDetailsSteps;

    @Steps
    private HvbSignUpSteps hvbSignUpSteps;

    @Steps
    private HvbOrderOverviewSteps hvbOrderOverviewSteps;

    @Steps
    private HvbLandingSteps hvbLandingSteps;

    @Steps
    private HvbEmailLoginSteps hvbEmailLoginSteps;

    @Steps
    private HvbForgetPasswordSteps hvbForgetPasswordSteps;

    @Steps
    private HvbDashboardSteps hvbDashboardSteps;

    @Steps
    private HvbEditOrderSteps hvbEditOrderSteps;

    @Steps
    private HvbAddContractSteps hvbAddContractSteps;

    @Steps
    private HvbSignOrderSteps hvbSignOrderSteps;

    @Steps
    private HvbOverallNeedAnalysisIntroSteps hvbOverallNeedAnalysisIntroSteps;

    @Steps
    private HvbOverallNeedAnalysisSummarySteps hvbOverallNeedAnalysisSummarySteps;

    @Steps
    private HvbOverallNeedАnalysisSteps hvbOverallNeedАnalysisSteps;

    @Steps
    private HvbProfilePage hvbProfilePage;

    @Steps
    private HvbProfileChangePasswordSteps hvbProfileChangePasswordSteps;

    @Step
    public void userLogin(DBCustomerData dbCustomerData, HvbMessages messages) {
        hvbLandingSteps.click_on_header_login_link();
        hvbEmailLoginSteps.verify_login_page_enter_user_credentials_and_click_on_login_button(dbCustomerData.getEmail(), dbCustomerData.getPassword(), messages.getLoginPageHeadline());
        hvbDashboardSteps.click_on_dashboard_header_logout_link();
    }

    @Step
    public void registerUserWithBankCredentials(DBCustomerData dbCustomerData, HvbMessages messages) throws InterruptedException {

        hvbBankSelectionSteps.verify_first_step_select_bank_branch_and_click_on_next_button(messages.getBankSelectionHeadline(), dbCustomerData.getHvbBankName());

        hvbInsuranceInformationSteps.verify_second_step_insurance_information_page_and_click_on_next_button(messages.getInsuranceInformationHeadline());

        hvbTermsConditionsSteps.verify_third_step_bank_conditions_page_and_click_next_button(messages.getBankConditionsHeadline());

        hvbFinApiWebFormSteps.enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(), dbCustomerData.getPin());

        hvbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.isGender(), dbCustomerData.getBirthDay(),
                dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace(), dbCustomerData.getPhoneNum(), messages.getPersonalDetailsHeadline());

        hvbSignUpSteps.verify_sixth_step_and_finish_sign_up(dbCustomerData.getEmail(), dbCustomerData.getPassword(), messages.getSignUpPageHeadline());
    }

    protected AbstractPageObject getPageObject() {
        return null;
    }
}
