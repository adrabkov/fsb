package de.alectogmbh.friendsurance.automation.steps.web.user.login;

import de.alectogmbh.friendsurance.automation.pages.web.user.LoginPage;
import de.alectogmbh.friendsurance.automation.pages.web.user.RegistrationPage;
import de.alectogmbh.friendsurance.automation.pages.web.user.ResetPasswordPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class LoginPageSteps extends AbstractScenarioSteps<LoginPage> {

  private LoginPage loginPage;

  public LoginPageSteps() {
  }

  public LoginPageSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void click_registration_link() {
    getPageObject().clickRegistrationLink();
  }

  @Step
  public void click_password_forgotten_link() {
    getPageObject().clickPasswordForgottenLink();
  }

  @Step
  public void is_login_page_loaded() {
    ValidationUtils
        .checkCorrectPageLoaded(LoginPage.DEFAULT_URL, getPageObject().getCurrentPageUrl());
  }
  public void is_registration_page_loaded() {
    ValidationUtils
        .checkCorrectPageLoaded(RegistrationPage.DEFAULT_URL, getPageObject().getCurrentPageUrl());
  }

  @Step
  public void is_password_forgotten_page_loaded() {
    ValidationUtils
        .checkCorrectPageLoaded(ResetPasswordPage.DEFAULT_URL, getPageObject().getCurrentPageUrl());
  }

  @Override
  protected LoginPage getPageObject() {
    return loginPage;
  }

}
