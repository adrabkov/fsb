package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import org.junit.Test;

public class HvbChangePasswordTest extends AbstractScenarioTest {

    @Test
    public void profilePasswordChange() {

        clients.registerUserWithBankCredentials(dbCustomerData, messages);

        clients.getHvbOrderOverviewSteps().click_on_profile_link();

        clients.getHvbProfileSteps().click_on_delete_account_link();

        clients.getHvbProfileChangePasswordSteps().verify_password_change_page_is_loaded_and_headline_is_present(messages.getPasswordChangeHeadline());
        clients.getHvbProfileChangePasswordSteps().
                enter_old_and_new_password_and_click_on_save_button(dbCustomerData.getPassword(),
                        dbCustomerData.getNewPassword());
        clients.getHvbProfileChangePasswordSteps().verify_if_success_toast_banner_is_displayed(messages.getPasswordChangeSuccessText());

        clients.getHvbOrderOverviewSteps().click_on_header_logout_link();

        clients.userLogin(dbCustomerData.getEmail(), dbCustomerData.getNewPassword(), messages);

    }

    protected AbstractScenarioSteps getSteps() {
        return null;
    }
}
