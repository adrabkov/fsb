package de.alectogmbh.friendsurance.automation.steps.web.user.login;

import de.alectogmbh.friendsurance.automation.pages.web.user.LoginPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EmailLoginSteps extends AbstractScenarioSteps<LoginPage> {

  private LoginPage loginPage;

  @Step
  public void enter_email(String email) {
    getPageObject().enterLogin(email);
  }

  @Step
  public void enter_password(String password) {
    getPageObject().enterPassword(password);
  }

  @Step
  public void login() {
    getPageObject().clickSubmitButton();
  }

  @Step
  public void was_login_succesful() {
    getPageObject().waitForPresenceOf("//*[@id='menu-lnk-overview-notouch']");
    assertThat(loginPage.getCurrentPageUrl().contains("dashboard"), is(true));
  }

  @Step
  public void was_login_not_succesful() {
    assertThat(loginPage.getCurrentPageUrl().contains("dashboard"), is(false));
  }

  @Step
  public boolean isDashboardShownAfterLogin() {
    return getPageObject().isDashboardPageOpened();
  }

  @StepGroup
  public void login_user(String login, String password) {
    enter_email(login);
    enter_password(password);
    login();
  }

  @StepGroup
  public void login_user_and_check_success(String login, String password) {
    login_user(login, password);
    was_login_succesful();
  }

  @Override
  protected LoginPage getPageObject() {
    return loginPage;
  }

}