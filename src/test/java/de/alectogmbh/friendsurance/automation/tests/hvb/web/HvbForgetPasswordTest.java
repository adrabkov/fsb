package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import org.junit.Test;

public class HvbForgetPasswordTest extends AbstractScenarioTest {

    @Test
    public void onboardedUserResetPassword() {

        clients.getHvbLandingSteps().open_landing_page();
        clients.getHvbLandingSteps().click_on_header_login_link();

        clients.getHvbEmailLoginSteps().verify_login_page_is_loaded_and_headline_is_present(messages.getLoginPageHeadline());
        clients.getHvbEmailLoginSteps().click_on_cookiebar_close_button();
        clients.getHvbEmailLoginSteps().click_on_forget_password_link();
        clients.getHvbForgetPasswordSteps().enter_user_email(dbCustomerData.getEmail());
        clients.getHvbForgetPasswordSteps().click_on_send_button_to_trigger_email();
        clients.getHvbForgetPasswordSteps().verify_if_success_toast_banner_is_displayed(messages.getForgotPassSuccessMessage());
    }

    protected AbstractScenarioSteps getSteps() {
        return null;
    }
}
