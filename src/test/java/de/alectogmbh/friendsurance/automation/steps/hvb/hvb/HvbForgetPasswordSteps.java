package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbEmailLoginPage;
import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbForgetPasswordPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbForgetPasswordSteps extends AbstractScenarioSteps<HvbForgetPasswordPage> {

  private HvbForgetPasswordPage hvbForgetPasswordPage;

  private HvbEmailLoginPage hvbEmailLoginPage;

  public HvbForgetPasswordPage getPageObject() {
    return hvbForgetPasswordPage;
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
