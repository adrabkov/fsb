package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.*;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.HvbDBCustomerDataUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static de.alectogmbh.friendsurance.automation.tests.web.utils.hvb.HvbPageHeadline.*;

@RunWith(SerenityRunner.class)
public class HvbOnboardingTest extends AbstractScenarioTest<HvbStepCollection> {

    @Steps
    private HvbStepCollection hvbStepCollection;

    protected HvbStepCollection getSteps() {
        return hvbStepCollection;
    }

//    @Rule
//    public EnvironmentExecutionRule rule = new EnvironmentExecutionRule();

    @Test
//    @EnvironmentExecution(exclude = ALL, include = HVB)
    public void userRegistrationWithBankCredentials() throws InterruptedException {

        DBCustomerData dbCustomerData = HvbDBCustomerDataUtils.createDBCustomerData();

        hvbStepCollection.getHvbBankSelectionSteps().verify_first_step_select_bank_branch_and_click_on_next_button(EXPECTED_BANK_SELECTION_PAGE_HEADLINE, dbCustomerData.getHvbBankName());

        hvbStepCollection.getHvbInsuranceInformationSteps().verify_second_step_insurance_information_page_and_click_on_next_button(EXPECTED_INSURANCE_INFORMATION_HEADLINE);

        hvbStepCollection.getHvbTermsConditionsSteps().verify_third_step_bank_conditions_page_and_click_next_button(EXPECTED_BANK_CONDITIONS_HEADLINE);

        hvbStepCollection.getHvbFinApiWebFormSteps()
                .enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(),
                        dbCustomerData.getPin());

        hvbStepCollection.getHvbPersonalDetailsSteps()
                .verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.isGender(), dbCustomerData.getBirthDay(),
                        dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                        dbCustomerData.getPlace(), dbCustomerData.getPhoneNum(), EXPECTED_PERSONAL_DETAILS_HEADLINE);

        hvbStepCollection.getHvbSignUpSteps()
                .verify_sixth_step_and_finish_sign_up(dbCustomerData.getEmail(), dbCustomerData.getPassword(), EXPECTED_SIGN_UP_PAGE_HEADLINE);

        hvbStepCollection.getHvbOrderOverviewSteps().verify_order_overview_page_is_loaded_and_click_on_logout_link(EXPECTED_ORDER_OVERVIEW_HEADLINE);

        hvbStepCollection.userLogin(dbCustomerData.getEmail(), dbCustomerData.getPassword());

        hvbStepCollection.getHvbDashboardSteps().click_on_dashboard_header_logout_link();

    }

}
