package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.*;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import org.junit.Test;

public class HvbAddContractTest extends AbstractScenarioTest<HvbBankSelectionSteps> {

    @Test
    public void addExtractedAndExistingInsuranceContracts() {

        clients.registerUserWithBankCredentials(dbCustomerData, messages);

        clients.getHvbOrderOverviewSteps().delete_missing_orders_items();

        clients.getHvbOrderOverviewSteps().verify_order_items_after_deleting_error_items();

        clients.getHvbOrderOverviewSteps().click_order_on_any_item();

        clients.getHvbEditOrderSteps()
                .verify_order_page_and_edit_company_name(messages.getEditOrderPageHeadline(), dbCustomerData.getInsuranceNewCompany());

        clients.getHvbOrderOverviewSteps()
                .check_company_name_item_after_edit_action(dbCustomerData.getInsuranceNewCompany());

        clients.getHvbOrderOverviewSteps()
                .verify_order_overview_page_and_perform_user_actions_and_click_add_button(messages.getOrderOverviewHeadline(), dbCustomerData.getInsuranceNewCompany());

        clients.getHvbAddContractSteps()
                .verify_add_contract_page_enter_policy_details_and_go_next(dbCustomerData.getInsuranceCategory(),
                        dbCustomerData.getInsuranceCompany(), dbCustomerData.getPolicyNumber(), dbCustomerData.getPremiumAmount(),
                        dbCustomerData.getPaymentInterval(), messages.getAddContractPageHeadline());

        clients.getHvbOrderOverviewSteps()
                .verify_order_items_after_adding_contract_and_click_on_overview_page_submit_button(messages.getOrderOverviewHeadline());

        clients.getHvbSignOrderSteps()
                .verify_sign_authorization_and_submit_order_items(messages.getSignOrderPageHeadline());

        clients.getHvbOverallNeedAnalysisIntroSteps()
                .verify_ona_intro_page_is_loaded_after_addcontract_flow_during_onboarding(messages.getOnaIntroHeadlineTextDuringOnboarding());

    }

    protected HvbBankSelectionSteps getSteps() {
        return clients.getHvbBankSelectionSteps();
    }

}
