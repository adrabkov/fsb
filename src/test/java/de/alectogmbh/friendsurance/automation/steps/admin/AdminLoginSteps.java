package de.alectogmbh.friendsurance.automation.steps.admin;

import de.alectogmbh.friendsurance.automation.pages.admin.AdminLoginPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AdminLoginSteps extends AbstractScenarioSteps<AdminLoginPage> {

  AdminLoginPage adminLoginPage;

  @Step
  public void enter_user_name(String username) {
    adminLoginPage.enterUserName(username);
  }

  @Step
  public void enter_password(String password) {
    adminLoginPage.enterPassword(password);
  }

  @Step
  public void login() {
    adminLoginPage.login();
  }

  @Step
  public void check_admin_login_page_loaded() {
    ValidationUtils
        .checkCorrectPageLoaded(AdminLoginPage.DEFAULT_URL, getPageObject().getCurrentPageUrl());
  }

  @Step
  public void login_with_user_name_and_password(String username, String password) {
    enter_user_name(username);
    enter_password(password);
    login();
  }

  @Step
  public void verifySuccessfulLogin() {
    assertThat(adminLoginPage.getCurrentPageUrl().contains("authfailed="), is(false));
  }

  @Step
  public void verifyFailingLogin() {
    ValidationUtils
        .checkElementIsDisplayed("Admin Login Failed", adminLoginPage.isErrorMessageVisible());
  }

  @Override
  protected AdminLoginPage getPageObject() {
    return adminLoginPage;
  }

}
