package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.*;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import org.junit.Test;

public class HvbOnboardingTest extends AbstractScenarioTest {

    @Test
    public void userRegistrationWithBankCredentials() throws InterruptedException {

        clients.getHvbBankSelectionSteps().verify_first_step_select_bank_branch_and_click_on_next_button(messages.getBankSelectionHeadline());

        clients.getHvbInsuranceInformationSteps().verify_second_step_insurance_information_page_and_click_on_next_button(messages.getInsuranceInformationHeadline());

        clients.getHvbTermsConditionsSteps().verify_third_step_bank_conditions_page_and_click_next_button(messages.getBankConditionsHeadline());

        clients.getHvbFinApiWebFormSteps()
                .enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(),
                        dbCustomerData.getPin());

        clients.getHvbPersonalDetailsSteps()
                .verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.isGender(), dbCustomerData.getBirthDay(),
                        dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                        dbCustomerData.getPlace(), dbCustomerData.getPhoneNum(), messages.getPersonalDetailsHeadline());

        clients.getHvbSignUpSteps()
                .verify_sixth_step_and_finish_sign_up(dbCustomerData.getEmail(), dbCustomerData.getPassword(), messages.getSignUpPageHeadline());

        clients.getHvbOrderOverviewSteps().verify_order_overview_page_is_loaded_and_click_on_logout_link(messages.getOrderOverviewHeadline());

        verifyOnboardedUserLoginFunctionality(dbCustomerData);
    }

    private void verifyOnboardedUserLoginFunctionality(DBCustomerData dbCustomerData) {
        clients.getHvbLandingSteps().click_on_header_login_link();
        clients.getHvbEmailLoginSteps().verify_login_page_enter_user_credentials_and_click_on_login_button(dbCustomerData.getEmail(),
                dbCustomerData.getPassword(), messages.getLoginPageHeadline());
        clients.getHvbDashboardSteps().click_on_dashboard_header_logout_link();
    }

    protected HvbBankSelectionSteps getSteps() {
        return clients.getHvbBankSelectionSteps();
    }

}
