package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import org.junit.Test;

public class HvbChangePasswordTest extends AbstractScenarioTest {

    @Test
    public void profilePasswordChange() throws InterruptedException {

        OnboardUserWithBankCredentials(dbCustomerData);

        clients.getHvbProfilePage().clickOnChangePasswordLink();

        clients.getHvbProfileChangePasswordSteps().verify_password_change_page_is_loaded_and_headline_is_present(messages.getPasswordChangeHeadline());
        clients.getHvbProfileChangePasswordSteps().
                enter_old_and_new_password_and_click_on_save_button(dbCustomerData.getOldPassword(),
                        dbCustomerData.getNewPassword());
        clients.getHvbProfileChangePasswordSteps().verify_if_success_toast_banner_is_displayed(messages.getPasswordChangeSuccessText());

        verifyOnboardedUserLoginFunctionality(dbCustomerData);
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

    private void verifyOnboardedUserLoginFunctionality(DBCustomerData dbCustomerData) {
        clients.getHvbOrderOverviewSteps().click_on_header_logout_link();
        clients.getHvbLandingSteps().click_on_header_login_link();
        clients.getHvbEmailLoginSteps()
                .verify_login_page_enter_user_credentials_and_click_on_login_button
                        (messages.getLoginPageHeadline(), dbCustomerData.getEmail(), dbCustomerData.getNewPassword());
    }

    protected AbstractScenarioSteps getSteps() {
        return null;
    }
}
