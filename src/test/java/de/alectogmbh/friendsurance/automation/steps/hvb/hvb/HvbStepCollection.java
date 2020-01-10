package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import lombok.Getter;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static de.alectogmbh.friendsurance.automation.tests.web.utils.hvb.HvbPageHeadline.*;

@Getter
public class HvbStepCollection extends AbstractScenarioSteps {

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
    private HvbSignOrderSteps hvbSignOrderSteps;

    @Steps
    private HvbOverallNeedAnalysisIntroSteps hvbOverallNeedAnalysisIntroSteps;

    @Steps
    private HvbOverallNeedAnalysisSummarySteps hvbOverallNeedAnalysisSummarySteps;

    @Steps
    private HvbOverallNeedАnalysisSteps hvbOverallNeedАnalysisSteps;

    @Steps
    private HvbProfileSteps hvbProfileSteps;

    @Steps
    private HvbProfileChangePasswordSteps hvbProfileChangePasswordSteps;

    @Steps
    private HvbDeleteAccountSteps hvbDeleteAccountSteps;

    @Steps
    private HvbAddEditOrderSteps hvbAddEditOrderSteps;

    @Step
    public void userLogin(String email, String password) {
        hvbLandingSteps.click_on_header_login_link();
        hvbEmailLoginSteps.verify_login_page_enter_user_credentials_and_click_on_login_button(email, password, EXPECTED_LOGIN_PAGE_HEADLINE);
        hvbDashboardSteps.click_on_dashboard_header_logout_link();
    }

    @Step
    public void registerUserWithBankCredentials(DBCustomerData dbCustomerData) throws InterruptedException {

        hvbBankSelectionSteps.verify_first_step_select_bank_branch_and_click_on_next_button(EXPECTED_BANK_SELECTION_PAGE_HEADLINE, dbCustomerData.getHvbBankName());

        hvbInsuranceInformationSteps.verify_second_step_insurance_information_page_and_click_on_next_button(EXPECTED_INSURANCE_INFORMATION_HEADLINE);

        hvbTermsConditionsSteps.verify_third_step_bank_conditions_page_and_click_next_button(EXPECTED_BANK_CONDITIONS_HEADLINE);

        hvbFinApiWebFormSteps.enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(), dbCustomerData.getPin());

        hvbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.isGender(), dbCustomerData.getBirthDay(),
                dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace(), dbCustomerData.getPhoneNum(), EXPECTED_PERSONAL_DETAILS_HEADLINE);

        hvbSignUpSteps.verify_sixth_step_and_finish_sign_up(dbCustomerData.getEmail(), dbCustomerData.getPassword(), EXPECTED_SIGN_UP_PAGE_HEADLINE);
    }

    @Step
    public void finishRegistrationWithBankCredentialsAndContract(DBCustomerData dbCustomerData) throws InterruptedException {
        registerUserWithBankCredentials(dbCustomerData);

        hvbOrderOverviewSteps.delete_missing_orders_items();

        hvbOrderOverviewSteps.click_overview_page_submit_button();

        hvbSignOrderSteps.verify_sign_authorization_and_submit_order_items(EXPECTED_SIGN_ORDER_HEADLINE);

        hvbOverallNeedAnalysisIntroSteps.verify_ona_intro_page_is_loaded_after_addcontract_flow_during_onboarding(EXPECTED_ONA_INTRO_HEADLINE_TEXT_DURING_ONBOARDING);
    }

    @Step
    public void fillingOna(String children) {
        hvbOverallNeedАnalysisSteps.select_marital_status_single_option();
        hvbOverallNeedАnalysisSteps.click_ona_save_family_status_and_go_next_button();
        hvbOverallNeedАnalysisSteps.select_number_of_children_by_text(children);
        hvbOverallNeedАnalysisSteps.click_ona_save_children_status_and_go_next_button();
        hvbOverallNeedАnalysisSteps.select_profession_status();
        hvbOverallNeedАnalysisSteps.click_ona_save_profession_status_and_go_next_button();
        hvbOverallNeedАnalysisSteps.select_insurance_type();
        hvbOverallNeedАnalysisSteps.click_ona_save_insurance_type_and_go_next_button();
        hvbOverallNeedАnalysisSteps.select_living_condition_car_checkbox();
        hvbOverallNeedАnalysisSteps.select_living_condition_house_checkbox();
        hvbOverallNeedАnalysisSteps.click_ona_save_living_conditions_and_go_to_summary_button();
    }


    protected AbstractPageObject getPageObject() {
        return null;
    }
}
