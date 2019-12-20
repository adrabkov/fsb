package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbTermsConditionsPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbTermsConditionsSteps extends AbstractScenarioSteps<HvbTermsConditionsPage> {

  private static final String EXPECTED_BANK_CONDITIONS_HEADLINE = "Wenn wir um noch zwei Häkchen bitten dürften.";

  private HvbTermsConditionsPage hvbTermsConditionsPage;

  public HvbTermsConditionsPage getPageObject() {
    return hvbTermsConditionsPage;
  }

  @Step
  public String get_bank_conditions_headline_text() {
    return getPageObject().getBankConditionsHeadlineText();
  }

  @Step
  public void check_terms_of_use_checkbox() {
    getPageObject().checkTermsOfUseCheckbox();
  }

  @Step
  public void check_consent_declaration_checkbox() {
    getPageObject().checkConsentDeclarationCheckbox();
  }

  @Step
  public void click_on_bank_conditions_next_button() {
    getPageObject().clickBankConditionsGoNextButton();
  }

  @Step
  public void switch_to_fin_api_modal_window_prompt() {
    getPageObject().switchToFinApiModalWindowPrompt();
  }

  @Step
  public void click_on_fin_api_modal_window_prompt_confirm_button() {
    getPageObject().clickOnFinApiModalWindowPromptConfirmButton();
  }

  @Step
  public void verify_bank_conditions_page_is_loaded_and_headline_is_present() {
    assertEquals(EXPECTED_BANK_CONDITIONS_HEADLINE, get_bank_conditions_headline_text());
  }

  @StepGroup
  public void check_bank_terms_policy_and_click_next_button() {
    check_terms_of_use_checkbox();
    check_consent_declaration_checkbox();
    click_on_bank_conditions_next_button();
  }

  @StepGroup
  public void switch_to_fin_api_modal_prompt_and_click_next_button() {
    switch_to_fin_api_modal_window_prompt();
    click_on_fin_api_modal_window_prompt_confirm_button();
  }

  @StepGroup
  public void verify_third_step_bank_conditions_page_and_click_next_button () {
    verify_bank_conditions_page_is_loaded_and_headline_is_present();
    check_bank_terms_policy_and_click_next_button();
    switch_to_fin_api_modal_prompt_and_click_next_button();
  }

}
