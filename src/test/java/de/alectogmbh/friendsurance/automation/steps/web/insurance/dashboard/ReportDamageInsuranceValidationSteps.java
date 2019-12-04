package de.alectogmbh.friendsurance.automation.steps.web.insurance.dashboard;

import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class ReportDamageInsuranceValidationSteps extends ReportDamageInsuranceSteps {

  public ReportDamageInsuranceValidationSteps() {
  }

  public ReportDamageInsuranceValidationSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void not_selected_insurance_error_message_is_displayed(String expected) {
    ValidationUtils
        .checkValidationErrorMessage(expected, getPageObject().getInsuranceSelectErrorMessage());
  }

  @Step
  public void empty_damage_date_error_message_is_displayed(String expected) {
    ValidationUtils
        .checkValidationErrorMessage(expected, getPageObject().getDamageDateErrorMessage());
  }
}
