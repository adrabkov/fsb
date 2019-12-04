package de.alectogmbh.friendsurance.automation.steps.web.insurance.order.upgrade.step1;

import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class Step1ValidationSteps extends Step1Steps {

  private String emptyLiabilityPolicyNumberMessage;
  private String emptyHouseholdPolicyNumberMessage;
  private String emptyLegalPolicyNumberMessage;
  private String emptyCarPolicyNumberMessage;
  private String generalErrorMessage;
  private String xSellingHouseholdLivingSpaceRequiredErrorMessage;
  private static final String LIABILITY = "Privat-Haftpflicht";
  private static final String HOUSEHOLD = "Hausrat";
  private static final String LEGAL = "Rechtsschutz";
  private static final String CAR = "Kfz";

  public Step1ValidationSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void empty_liability_insurance_policy_number_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(emptyLiabilityPolicyNumberMessage,
        getPageObject().get_policy_number_error(LIABILITY)
    );
  }

  @Step
  public void empty_household_insurance_policy_number_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(emptyHouseholdPolicyNumberMessage,
        getPageObject().get_policy_number_error(HOUSEHOLD)
    );
  }

  @Step
  public void empty_legal_insurance_policy_number_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(emptyLegalPolicyNumberMessage,
        getPageObject().get_policy_number_error(LEGAL)
    );
  }

  @Step
  public void empty_car_insurance_policy_number_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(emptyCarPolicyNumberMessage,
        getPageObject().get_policy_number_error(CAR)
    );
  }

  @Step
  public void general_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(generalErrorMessage,
        getPageObject().get_general_error_message());
  }
}
