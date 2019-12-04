package de.alectogmbh.friendsurance.automation.steps.web.insurance.comparison.liability;

import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class LiabilityInsuranceComparisonValidationSteps extends LiabilityInsuranceComparisonSteps {

  private String emptyPostalCodeErrorMessage;
  private String wrongPostalCodeErrorMessage;
  private String emptyNumberOfDamagesErrorMessage;
  private String numberOfDamagesLimitErrorMessage;

  private LiabilityInsuranceComparisonSteps liabilityInsuranceComparisonSteps;

  public LiabilityInsuranceComparisonValidationSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void empty_postal_code_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(
        emptyPostalCodeErrorMessage, getPageObject().getEmptyPostalCodeErrorMessage()
    );
  }

  @Step
  public void wrong_postal_code_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(
        wrongPostalCodeErrorMessage, getPageObject().getWrongPostalCodeErrorMessage()
    );
  }

  @Step
  public void number_of_claims_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(emptyNumberOfDamagesErrorMessage,
        getPageObject().getNumberOfDamagesRequiredErrorMessage());
  }

  @Step
  public void number_of_damages_exceeded_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(numberOfDamagesLimitErrorMessage,
        getPageObject().getNumberOfDamagesIncorrectErrorMessage());
  }

}
