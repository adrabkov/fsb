package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.client.FsbSignUpPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class FsbSignUpsteps extends AbstractScenarioSteps<FsbSignUpPage> {

    private static final String EXPECTED_SIGN_UP_PAGE_HEADLINE = "E-Mail eingeben, Passwort festlegen und geschafft!";

    private FsbSignUpPage fsbSignUpPage;

    public FsbSignUpPage getPageObject() {
        return fsbSignUpPage;
    }

    @Step
    public String get_sign_up_page_headline_text() {
        return getPageObject().getSignUpPageHeadlineText();
    }

    @Step
    public void enter_user_email(String email) {
        getPageObject().enterUserEmail(email);
    }

    @Step
    public void enter_user_password(String password) {
        getPageObject().enterUserPassword(password);
    }

    @Step
    public void click_on_sign_up_button() {
        getPageObject().clickSubmitButton();
    }


    @Step
    public void verify_sign_up_page_is_loaded_and_headline_is_present() {
        assertEquals(EXPECTED_SIGN_UP_PAGE_HEADLINE, get_sign_up_page_headline_text());
    }


    @StepGroup
    public void verify_second_step_and_finish_sign_up(String email, String password) {
        verify_sign_up_page_is_loaded_and_headline_is_present();
        enter_user_email(email);
        enter_user_password(password);
        click_on_sign_up_button();
    }


}
