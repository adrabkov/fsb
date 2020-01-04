package de.alectogmbh.friendsurance.automation.tests.fsb.web;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbDashboardSteps;
import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbEmailLoginSteps;
import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbForgetPasswordSteps;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerDataUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FsbForgetPasswordTest extends AbstractScenarioTest<AbstractScenarioSteps> {

    private static final String EXPECTED_SUCCESS_BANNER_TEXT =
            "Wir haben eine E-Mail an die angegebene E-Mail Adresse versendet. Darin finden Sie einen Link, um Ihr Passwort zurück setzen zu können.";
    private static final String EXPECTED_LOGIN_PAGE_HEADLINE_TEXT = "Willkommen beim Kunden-Login";

    @Steps
    private AbstractScenarioSteps fsbPersonalDetailsSteps;

    @Steps
    private FsbEmailLoginSteps fsbEmailLoginSteps;
    @Steps
    private FsbDashboardSteps fsbDashboardSteps;

    @Steps
    private FsbForgetPasswordSteps fsbForgetPasswordSteps;

    protected AbstractScenarioSteps getSteps() {
        return fsbPersonalDetailsSteps;
    }

//    @Rule
//    public EnvironmentExecutionRule rule = new EnvironmentExecutionRule();

    @Test
//    @EnvironmentExecution(exclude = ALL, include = FS)
    public void onboardedUserResetPassword() {
        DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

        fsbEmailLoginSteps.open_login_page();
        fsbEmailLoginSteps.verify_login_page_is_loaded_and_headline_is_present(EXPECTED_LOGIN_PAGE_HEADLINE_TEXT);
        fsbEmailLoginSteps.click_on_forget_password_link();
        fsbForgetPasswordSteps.enter_user_email(dbCustomerData.getEmail());

        fsbForgetPasswordSteps.click_on_send_button_to_trigger_email();
        fsbForgetPasswordSteps.verify_if_success_toast_banner_is_displayed(EXPECTED_SUCCESS_BANNER_TEXT);
    }
}
