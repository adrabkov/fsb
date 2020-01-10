package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.*;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.HvbDBCustomerDataUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static de.alectogmbh.friendsurance.automation.tests.web.utils.hvb.HvbAddEditOrderData.*;
import static de.alectogmbh.friendsurance.automation.tests.web.utils.hvb.HvbPageHeadline.*;

@RunWith(SerenityRunner.class)
public class HvbAddContractTest extends AbstractScenarioTest<HvbStepCollection> {

    @Steps
    private HvbStepCollection hvbStepCollection;

    protected HvbStepCollection getSteps() {
        return hvbStepCollection;
    }

//    @Rule
//    public EnvironmentExecutionRule rule = new EnvironmentExecutionRule();

    @Test
//    @EnvironmentExecution(exclude = ALL, include = HVB)
    public void addExtractedAndExistingInsuranceContracts() throws InterruptedException {

        DBCustomerData dbCustomerData = HvbDBCustomerDataUtils.createDBCustomerData();

        hvbStepCollection.registerUserWithBankCredentials(dbCustomerData);

        hvbStepCollection.getHvbOrderOverviewSteps().delete_missing_orders_items();

        hvbStepCollection.getHvbOrderOverviewSteps().verify_order_items_after_deleting_error_items();

        hvbStepCollection.getHvbOrderOverviewSteps().click_on_add_contract_button();

        hvbStepCollection.getHvbAddEditOrderSteps().verify_add_contract_page_add_existing_contract_details_and_click_on_save(EXPECTED_ADD_CONTRACT_PAGE_HEADLINE, insuranceCategory,
                insuranceCompany, policyNumber, premiumAmount, paymentInterval);

        hvbStepCollection.getHvbOrderOverviewSteps().click_order_on_any_item();

        hvbStepCollection.getHvbAddEditOrderSteps().verify_order_page_and_edit_company_name(EXPECTED_EDIT_ORDER_PAGE_HEADLINE, editInsuranceCompany);

        hvbStepCollection.getHvbOrderOverviewSteps()
                .check_company_name_item_after_edit_action(editInsuranceCompany);

        hvbStepCollection.getHvbOrderOverviewSteps().click_overview_page_submit_button();

        hvbStepCollection.getHvbSignOrderSteps()
                .verify_sign_authorization_and_submit_order_items(EXPECTED_SIGN_ORDER_HEADLINE);

        hvbStepCollection.getHvbOverallNeedAnalysisIntroSteps()
                .verify_ona_intro_page_is_loaded_after_addcontract_flow_during_onboarding(EXPECTED_ONA_INTRO_HEADLINE_TEXT_DURING_ONBOARDING);

    }

}
