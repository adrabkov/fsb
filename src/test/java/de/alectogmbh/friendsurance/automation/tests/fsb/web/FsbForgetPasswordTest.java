package de.alectogmbh.friendsurance.automation.tests.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbPersonalDetailsPage;
import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbDashboardSteps;
import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbEmailLoginSteps;
import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbForgetPasswordSteps;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerDataUtils;
import net.thucydides.core.annotations.Steps;
import org.testng.annotations.Test;

public class FsbForgetPasswordTest {

    private static final String
            EXPECTED_SUCCESS_BANNER_TEXT =
            "Wir haben eine E-Mail an die angegebene E-Mail Adresse versendet. Darin finden Sie einen Link, um Ihr Passwort zurück setzen zu können.";

    @Steps
    private FsbPersonalDetailsPage fsbPersonalDetailsPage = new FsbPersonalDetailsPage();

    @Steps
    private FsbEmailLoginSteps fsbEmailLoginSteps = new FsbEmailLoginSteps();

    @Steps
    private FsbDashboardSteps fsbDashboardSteps = new FsbDashboardSteps();

    @Steps
    private FsbForgetPasswordSteps fsbForgetPasswordSteps = new FsbForgetPasswordSteps();

    protected FsbEmailLoginSteps getSteps() {
        return fsbEmailLoginSteps;
    }

    @Test
    public void onboardedUserResetPassword() {
        DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

        fsbPersonalDetailsPage.clickLoginButton();
        fsbEmailLoginSteps.verify_login_page_is_loaded_and_headline_is_present();
        fsbEmailLoginSteps.click_on_forget_password_link();

        fsbForgetPasswordSteps.enter_user_email(dbCustomerData.getEmail());
        fsbForgetPasswordSteps.click_on_send_button_to_trigger_email();
        fsbForgetPasswordSteps.verify_if_success_toast_banner_is_displayed(EXPECTED_SUCCESS_BANNER_TEXT);
    }
}
