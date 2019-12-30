package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import org.junit.Test;

public class HvbOverallNeedAnalysisTest extends AbstractScenarioTest {

    @Test
    public void overallNeedAnalysisQuestionnaireAfterCreatingUser() throws InterruptedException {
        OnboardUserWithBankCredentials(dbCustomerData);

        clients.getHvbOverallNeedAnalysisIntroSteps().click_ona_go_next_button();

        clients.getHvbOverallNeedАnalysisSteps().select_marital_status_single_option();
        clients.getHvbOverallNeedАnalysisSteps().click_ona_save_family_status_and_go_next_button();
        clients.getHvbOverallNeedАnalysisSteps().select_number_of_children_by_text(dbCustomerData.getChildren());
        clients.getHvbOverallNeedАnalysisSteps().click_ona_save_children_status_and_go_next_button();
        clients.getHvbOverallNeedАnalysisSteps().select_profession_status();
        clients.getHvbOverallNeedАnalysisSteps().click_ona_save_profession_status_and_go_next_button();
        clients.getHvbOverallNeedАnalysisSteps().select_insurance_type();
        clients.getHvbOverallNeedАnalysisSteps().click_ona_save_insurance_type_and_go_next_button();
        clients.getHvbOverallNeedАnalysisSteps().select_living_condition_car_checkbox();
        clients.getHvbOverallNeedАnalysisSteps().select_living_condition_house_checkbox();
        clients.getHvbOverallNeedАnalysisSteps().click_ona_save_living_conditions_and_go_to_summary_button();
        clients.getHvbOverallNeedAnalysisSummarySteps().verify_ona_save_summary_and_completed_pages();

    }

    @Test
    public void overallNeedAnalysisQuestionnaireAfterSkippingONA() throws InterruptedException {

        OnboardUserWithBankCredentials(dbCustomerData);

        clients.getHvbOverallNeedAnalysisIntroSteps().click_remember_later_button();

        clients.getHvbDashboardSteps().verify_dashboard_profile_remainder_is_displayed();

        clients.getHvbDashboardSteps().click_dashboard_profile_remainder();

        clients.getHvbOverallNeedAnalysisIntroSteps().click_ona_go_next_button();

        clients.getHvbOverallNeedАnalysisSteps().select_marital_status_single_option();
        clients.getHvbOverallNeedАnalysisSteps().click_ona_save_family_status_and_go_next_button();
        clients.getHvbOverallNeedАnalysisSteps().select_number_of_children_by_text("2");
        clients.getHvbOverallNeedАnalysisSteps().click_ona_save_children_status_and_go_next_button();
        clients.getHvbOverallNeedАnalysisSteps().select_profession_status();
        clients.getHvbOverallNeedАnalysisSteps().click_ona_save_profession_status_and_go_next_button();
        clients.getHvbOverallNeedАnalysisSteps().select_insurance_type();
        clients.getHvbOverallNeedАnalysisSteps().click_ona_save_insurance_type_and_go_next_button();
        clients.getHvbOverallNeedАnalysisSteps().select_living_condition_car_checkbox();
        clients.getHvbOverallNeedАnalysisSteps().select_living_condition_house_checkbox();
        clients.getHvbOverallNeedАnalysisSteps().click_ona_save_living_conditions_and_go_to_summary_button();
        clients.getHvbOverallNeedAnalysisSummarySteps().verify_ona_save_summary_and_completed_pages();

    }

    private void OnboardUserWithBankCredentials(DBCustomerData dbCustomerData) throws InterruptedException {
        clients.getHvbBankSelectionSteps()
                .verify_first_step_select_bank_branch_and_click_on_next_button(messages.getBankSelectionHeadline(), dbCustomerData.getHvbBankName());

        clients.getHvbInsuranceInformationSteps()
                .verify_second_step_insurance_information_page_and_click_on_next_button(messages.getInsuranceInformationHeadline());

        clients.getHvbTermsConditionsSteps()
                .verify_third_step_bank_conditions_page_and_click_next_button(messages.getBankConditionsHeadline());

        clients.getHvbFinApiWebFormSteps()
                .enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(),
                        dbCustomerData.getPin());

        clients.getHvbPersonalDetailsSteps()
                .verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.isGender(), dbCustomerData.getBirthDay(),
                        dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                        dbCustomerData.getPlace(), dbCustomerData.getPhoneNum(), messages.getPersonalDetailsHeadline());

        clients.getHvbSignUpSteps()
                .verify_sixth_step_and_finish_sign_up(dbCustomerData.getEmail(), dbCustomerData.getPassword(), messages.getSignUpPageHeadline());

        clients.getHvbOrderOverviewSteps().delete_missing_orders_items();

        clients.getHvbOrderOverviewSteps().click_overview_page_submit_button();

        clients.getHvbSignOrderSteps()
                .verify_sign_authorization_and_submit_order_items(messages.getSignOrderPageHeadline());

        clients.getHvbOverallNeedAnalysisIntroSteps()
                .verify_ona_intro_page_is_loaded_after_addcontract_flow_during_onboarding(messages.getOnaIntroHeadlineTextDuringOnboarding());
    }

    protected AbstractScenarioSteps getSteps() {
        return null;
    }
}
