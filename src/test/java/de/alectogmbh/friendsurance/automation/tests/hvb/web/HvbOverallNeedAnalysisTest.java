package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbEditOrderPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import org.junit.Test;

public class HvbOverallNeedAnalysisTest extends AbstractScenarioTest {

    @Test
    public void overallNeedAnalysisQuestionnaireAfterCreatingUser() throws InterruptedException {
        OnboardUserWithBankCredentials(dbCustomerData);
    }

    @Test
    public void overallNeedAnalysisQuestionnaireAfterSkippingONA() {

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
    }

    protected AbstractScenarioSteps getSteps() {
        return null;
    }
}
