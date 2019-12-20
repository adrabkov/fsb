package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbSignUpPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbSignUpSteps extends AbstractScenarioSteps<HvbSignUpPage> {

  private static final String EXPECTED_SIGN_UP_PAGE_HEADLINE = "E-Mail eingeben, Passwort festlegen und geschafft!";

  private HvbSignUpPage hvbSignUpPage;

  public HvbSignUpPage getPageObject() {
    return hvbSignUpPage;
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
    getPageObject().clickOnSignUpButton();
  }

  @Step
  public void confirm_extracted_data_info_confirmation_modal_step_one() {
    getPageObject().clickExtractedDataInfoStepOneContinue();
  }

  @Step
  public void confirm_extracted_data_info_confirmation_modal_step_two() {
    getPageObject().clickExtractedDataInfoStepTwoContinue();
  }

  @Step
  public void verify_sign_up_page_is_loaded_and_headline_is_present() {
    assertEquals(EXPECTED_SIGN_UP_PAGE_HEADLINE, get_sign_up_page_headline_text());
  }

  @StepGroup
  public void confirm_extract_data_info_confirmation_modal() throws InterruptedException {
    confirm_extracted_data_info_confirmation_modal_step_one();
    Thread.sleep(1000);
    confirm_extracted_data_info_confirmation_modal_step_two();
  }

  @StepGroup
  public void verify_sixth_step_and_finish_sign_up(String email, String password) throws InterruptedException {
   verify_sign_up_page_is_loaded_and_headline_is_present();
   enter_user_email(email);
   enter_user_password(password);
   click_on_sign_up_button();
   confirm_extract_data_info_confirmation_modal();
  }

}
