package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbEmailLoginPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbEmailLoginSteps extends AbstractScenarioSteps<HvbEmailLoginPage> {

  private static final String EXPECTED_LOGIN_PAGE_HEADLINE_TEXT = "Willkommen beim Kunden-Login";

  private HvbEmailLoginPage hvbEmailLoginPage;

  public HvbEmailLoginPage getPageObject() {
    return hvbEmailLoginPage;
  }

  @Step
  public void open_login_page() {
    getPageObject().open();
  }

  @Step
  public void wait_for_login_content_to_be_present() {
    getPageObject().waitForLoginContentToBePresent();
  }

  @Step
  public String get_login_page_headline_text() {
    return getPageObject().getLoginPageHeadlineText();
  }

  @Step
  public void click_on_forget_password_link() {
    getPageObject().clickOnForgetPasswordLink();
  }

  @Step
  public void enter_user_login_email(String email) {
    getPageObject().enterUserLoginEmail(email);
  }

  @Step
  public void enter_user_login_password(String password) {
    getPageObject().enterUserLoginPassword(password);
  }

  @Step
  public void click_on_user_login_button() {
    getPageObject().clickOnUserLoginButton();
  }

  @Step
  public void verify_login_page_is_loaded_and_headline_is_present() {
    assertEquals(EXPECTED_LOGIN_PAGE_HEADLINE_TEXT, get_login_page_headline_text());
  }

  @StepGroup
  public void verify_login_page_enter_user_credentials_and_click_on_login_button(String email, String password) {
    verify_login_page_is_loaded_and_headline_is_present();
    enter_user_login_email(email);
    enter_user_login_password(password);
    click_on_user_login_button();
  }

}
