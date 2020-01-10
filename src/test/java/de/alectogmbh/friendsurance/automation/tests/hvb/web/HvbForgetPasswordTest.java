package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.HvbStepCollection;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.HvbDBCustomerDataUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static de.alectogmbh.friendsurance.automation.tests.web.utils.hvb.HvbPageHeadline.*;

@RunWith(SerenityRunner.class)
public class HvbForgetPasswordTest extends AbstractScenarioTest<HvbStepCollection> {

    @Steps
    private HvbStepCollection hvbStepCollection;

    protected HvbStepCollection getSteps() {
        return hvbStepCollection;
    }

//    @Rule
//    public EnvironmentExecutionRule rule = new EnvironmentExecutionRule();

    @Test
    //    @EnvironmentExecution(exclude = ALL, include = HVB)
    public void onboardedUserResetPassword() {

        DBCustomerData dbCustomerData = HvbDBCustomerDataUtils.createDBCustomerData();

        hvbStepCollection.getHvbLandingSteps().open_landing_page();
        hvbStepCollection.getHvbLandingSteps().click_on_header_login_link();

        hvbStepCollection.getHvbEmailLoginSteps().verify_login_page_is_loaded_and_headline_is_present(EXPECTED_LOGIN_PAGE_HEADLINE);
        hvbStepCollection.getHvbEmailLoginSteps().click_on_cookiebar_close_button();
        hvbStepCollection.getHvbEmailLoginSteps().click_on_forget_password_link();
        hvbStepCollection.getHvbForgetPasswordSteps().enter_user_email(dbCustomerData.getEmail());
        hvbStepCollection.getHvbForgetPasswordSteps().click_on_send_button_to_trigger_email();
        hvbStepCollection.getHvbForgetPasswordSteps().verify_if_success_toast_banner_is_displayed(EXPECTED_FORGOT_PASS_SUCCESS_MESSAGE);
    }

}
