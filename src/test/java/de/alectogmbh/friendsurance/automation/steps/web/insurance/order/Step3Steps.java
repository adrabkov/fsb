package de.alectogmbh.friendsurance.automation.steps.web.insurance.order;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.Step3Page;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

public class Step3Steps extends AbstractOrderFlowSteps<Step3Page> {

  private Step3Page step3Page;

  public Step3Steps(Pages pages) {
    super(pages);
  }

  @Step
  public void select_legal_terms() {
    getPageObject().setLegalCheckbox();
  }

  @Step
  public void deselect_legal_terms() {
    getPageObject().uncheckLegalCheckbox();
  }

  @Step
  public void select_contact_via_phone_option() {
    getPageObject().selectContactViaPhoneCheckbox();
  }

  @Step
  public Boolean is_Contact_via_phone_box_enabled() {
    return getPageObject().isContactViaPhoneCheckboxEnabled();
  }

  @Step
  public void sign_conversion() {
    getPageObject().sign();
  }

  @Step
  public void submit_upgrade() {
    getPageObject().clickOnGetUpgradeButton();
  }
  @Step
  public void wait_for_loading_icon_appear_and_disappear() {
    getPageObject().waitForLoadingIconAppearAndDisappear();
  }
  @StepGroup
  public void checkout() {
    select_legal_terms();
    if (is_Contact_via_phone_box_enabled()) {
      select_contact_via_phone_option();
    }
    sign_conversion();
    submit_upgrade();
  }

  @Step
  public boolean is_headline_next_steps_title_present() {
    return getPageObject().isHeadlineNextStepsTitlePresent();
  }

  @Override
  protected Step3Page getPageObject() {
    return step3Page;
  }

}
