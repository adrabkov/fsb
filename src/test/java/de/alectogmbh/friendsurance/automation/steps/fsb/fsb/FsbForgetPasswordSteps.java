package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbEmailLoginPage;
import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbForgetPasswordPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class FsbForgetPasswordSteps extends AbstractScenarioSteps<FsbForgetPasswordPage> {

    private FsbForgetPasswordPage fsbForgetPasswordPage;

    private FsbEmailLoginPage fsbEmailLoginPage;

    public FsbForgetPasswordPage getPageObject() {
        return fsbForgetPasswordPage;
    }

    @Step
    public void enter_user_email(String email) {
        getPageObject().enterUserEmail(email);
    }

    @Step
    public void click_on_send_button_to_trigger_email() {
        getPageObject().clickOnSendButtonToTriggerEmail();
    }

    @Step
    public String get_toast_banner_text() {
        return getPageObject().getToastBannerText();
    }

    @StepGroup
    public void verify_if_success_toast_banner_is_displayed(String EXPECTED_SUCCESS_BANNER_TEXT) {
        assertEquals(EXPECTED_SUCCESS_BANNER_TEXT, get_toast_banner_text());
    }
}
