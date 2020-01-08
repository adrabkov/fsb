package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import org.junit.Test;

public class HvbRequestDeleteAccountTest extends AbstractScenarioTest {

    @Test
    public void testDeleteAccountRequestFromProfile() {

        clients.registerUserWithBankCredentials(dbCustomerData, messages);

        clients.getHvbOrderOverviewSteps().click_on_profile_link();

        clients.getHvbProfileSteps().click_on_delete_account_link();

        clients.getHvbDeleteAccountSteps().verify_delete_account_page_is_loaded(messages.getDeleteAccountPageHeadLine());
        clients.getHvbDeleteAccountSteps().click_on_delete_account_request_button();
        clients.getHvbDeleteAccountSteps().switch_to_delete_account_modal_window_and_click_on_confirm_button();

    }


    protected AbstractScenarioSteps getSteps() {
        return null;
    }
}
