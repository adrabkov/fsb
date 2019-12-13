package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbEmailLoginPage;
import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbPersonalDetailsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class FsbEmailLoginSteps {

    private static final String EXPECTED_LOGIN_PAGE_HEADLINE_TEXT = "Willkommen beim Kunden-Login";

    private FsbEmailLoginPage fsbEmailLoginPage = new FsbEmailLoginPage();

    private FsbEmailLoginPage getPageObject() {
        return fsbEmailLoginPage;
    }

    @Step
    public String get_login_page_headline_text(){
        return getPageObject().getLoginPageHeadlineText();
    }

    @Step
    public void click_on_forget_password_link(){
        getPageObject().clickOnForgetPasswordLink();
    }

    @Step
    public void enter_user_login_email(String email){
        getPageObject().enterUserLoginEmail(email);
    }

    @Step
    public void enter_user_login_password(String password){
        getPageObject().enterUserLoginPassword(password);
    }

    @Step
    public void click_on_user_login_button(){
        getPageObject().clickOnUserLoginButton();
    }

    @Step
    public void verify_login_page_is_loaded_and_headline_is_present(){
        assertEquals(EXPECTED_LOGIN_PAGE_HEADLINE_TEXT, get_login_page_headline_text());
    }

    @StepGroup
    public void verify_login_page_enter_user_credentials_and_click_on_login_button(String email, String password){
        verify_login_page_is_loaded_and_headline_is_present();
        enter_user_login_email(email);
        enter_user_login_password(password);
        click_on_user_login_button();
    }

}
