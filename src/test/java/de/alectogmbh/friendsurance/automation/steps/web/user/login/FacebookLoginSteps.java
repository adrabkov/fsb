package de.alectogmbh.friendsurance.automation.steps.web.user.login;

import de.alectogmbh.friendsurance.automation.pages.web.user.DashboardPage;
import de.alectogmbh.friendsurance.automation.pages.web.user.LoginPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.utils.BrowserUtils;
import de.alectogmbh.friendsurance.automation.utils.SeleniumWaitUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FacebookLoginSteps extends AbstractScenarioSteps<LoginPage> {

  private String parent;
  private final String FB_URL = "www.facebook";

  private LoginPage loginPage;

  @Step
  public void open_facebook_login_window() {
    loginPage.clickFacebookButton();
  }

  @Step
  public void enter_facebook_email(String email) {
    loginPage.enterFacebookEmail(email);
  }

  @Step
  public void enter_facebook_password(String password) {
    loginPage.enterFacebookPassword(password);
  }

  @Step
  public void click_facebook_anmelden_button() {
    loginPage.clickFacebookAnmeldenButton();
  }

  @Step
  public void switch_focus_to_new_window() {
    final int numberOfWindows = 2;
    final int timeoutInSeconds = 5;

    SeleniumWaitUtils.waitForNumberOfWindowsToEqual(numberOfWindows, getDriver(), timeoutInSeconds);
    parent = getDriver().getWindowHandle();
    BrowserUtils.switchToSecondWindow(getDriver());
  }

  @Step
  public void switch_back_to_initial_window() {
    getDriver().switchTo().window(parent);
  }

  @Step
  public void check_login_was_successful() {
    getPageObject().waitForPresenceOf("//*[@id='menu-lnk-overview-notouch']");
    assertThat(loginPage.getCurrentPageUrl().contains(DashboardPage.DEFAULT_URL), is(true));
  }

  @StepGroup
  public void enter_facebook_credentials_and_login(String email, String password) {
    enter_facebook_email(email);
    enter_facebook_password(password);
    click_facebook_anmelden_button();
  }

  @Override
  protected LoginPage getPageObject() {
    return loginPage;
  }
}

