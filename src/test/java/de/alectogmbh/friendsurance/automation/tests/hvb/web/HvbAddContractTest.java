package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.*;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import org.junit.Test;

public class HvbAddContractTest extends AbstractScenarioTest<HvbBankSelectionSteps> {

    @Test
    public void addExtractedAndExistingInsuranceContracts() throws InterruptedException {

        OnboardUserWithBankCredentials(dbCustomerData);

        clients.getHvbOrderOverviewSteps().check_and_delete_missing_orders_items();

        clients.getHvbOrderOverviewSteps().verify_company_name_before_editing_and_click_on_item();

        clients.getHvbEditOrderSteps().verify_order_page_and_edit_company_name(dbCustomerData.getInsuranceNewCompany(), messages.getEditOrderPageHeadline());

        clients.getHvbOrderOverviewSteps().check_company_name_item_after_edit_action();

        clients.getHvbOrderOverviewSteps().verify_order_overview_page_and_perform_user_actions_and_click_add_button(messages.getOrderOverviewHeadline());

        clients.getHvbAddContractSteps().
                verify_add_contract_page_enter_policy_details_and_go_next(dbCustomerData.getInsuranceCategory(),
                        dbCustomerData.getInsuranceCompany(), dbCustomerData.getPolicyNumber(), dbCustomerData.getPremiumAmount(),
                        dbCustomerData.getPaymentInterval(), messages.getAddContractPageHeadline());

        clients.getHvbOrderOverviewSteps().verify_order_items_after_adding_contract_and_click_on_overview_page_submit_button(messages.getOrderOverviewHeadline());

        clients.getHvbSignOrderSteps().verify_sign_authorization_and_submit_order_items(messages.getSignOrderPageHeadline());

        clients.getHvbOverallNeedAnalysisIntroSteps().verify_ona_intro_page_is_loaded_after_addcontract_flow_during_onboarding(messages.getOnaIntroHeadlineTextDuringOnboarding());

    }

    private void OnboardUserWithBankCredentials(DBCustomerData dbCustomerData) throws InterruptedException {
        clients.getHvbBankSelectionSteps().verify_first_step_select_bank_branch_and_click_on_next_button(dbCustomerData.getHvbBankName(), messages.getBankSelectionHeadline());

        clients.getHvbInsuranceInformationSteps().verify_second_step_insurance_information_page_and_click_on_next_button(messages.getInsuranceInformationHeadline());

        clients.getHvbTermsConditionsSteps().verify_third_step_bank_conditions_page_and_click_next_button(messages.getBankConditionsHeadline());

        clients.getHvbFinApiWebFormSteps().enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(),
                dbCustomerData.getPin());

        clients.getHvbPersonalDetailsSteps()
                .verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.isGender(), dbCustomerData.getBirthDay(),
                        dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                        dbCustomerData.getPlace(), dbCustomerData.getPhoneNum(), messages.getPersonalDetailsHeadline());

        clients.getHvbSignUpSteps().verify_sixth_step_and_finish_sign_up(dbCustomerData.getEmail(), dbCustomerData.getPassword(), messages.getSignUpPageHeadline());
    }

    protected HvbBankSelectionSteps getSteps() {
        return clients.getHvbBankSelectionSteps();
    }

}
