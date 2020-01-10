package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.HvbStepCollection;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.HvbDBCustomerDataUtils;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

import static de.alectogmbh.friendsurance.automation.tests.web.utils.hvb.HvbPageHeadline.*;

public class HvbRequestDeleteAccountTest extends AbstractScenarioTest<HvbStepCollection> {

    @Steps
    private HvbStepCollection hvbStepCollection;

    protected HvbStepCollection getSteps() {
        return hvbStepCollection;
    }

//    @Rule
//    public EnvironmentExecutionRule rule = new EnvironmentExecutionRule();

    @Test
//    @EnvironmentExecution(exclude = ALL, include = HVB)
    public void testDeleteAccountRequestFromProfile() throws InterruptedException {

        DBCustomerData dbCustomerData = HvbDBCustomerDataUtils.createDBCustomerData();

        hvbStepCollection.registerUserWithBankCredentials(dbCustomerData);

        hvbStepCollection.getHvbOrderOverviewSteps().click_on_profile_link();

        hvbStepCollection.getHvbProfileSteps().click_on_delete_account_link();

        hvbStepCollection.getHvbDeleteAccountSteps().verify_delete_account_page_is_loaded(EXPECTED_DELETE_ACCOUNT_PAGE_HEADLINE);
        hvbStepCollection.getHvbDeleteAccountSteps().click_on_delete_account_request_button();
        hvbStepCollection.getHvbDeleteAccountSteps().switch_to_delete_account_modal_window_and_click_on_confirm_button();

    }

}
