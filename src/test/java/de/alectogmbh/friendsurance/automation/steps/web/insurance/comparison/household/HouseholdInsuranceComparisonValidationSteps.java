package de.alectogmbh.friendsurance.automation.steps.web.insurance.comparison.household;

import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import de.alectogmbh.friendsurance.automation.steps.web.utils.InsuranceData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

public class HouseholdInsuranceComparisonValidationSteps extends HouseholdInsuranceComparisonSteps {

  private String householdEmptyPostalCodeErrorMessage;
  private String householdWrongPostalCodeErrorMessage;
  private String householdUknownAddressErrorMessage;
  private String householdLivingSpaceRequiredErrorMessage;
  private String householdMaxLivinSpaceSizeErrorMessage;
  private String householdEmptyInsuredSumErrorMessage;
  private String emptyNumberOfDamagesErrorMessage;
  private String numberOfDamagesLimitErrorMessage;

  public HouseholdInsuranceComparisonValidationSteps(Pages pages) {
    super(pages);
  }

  private HouseholdInsuranceComparisonValidationSteps householdInsuranceComparisonValidationSteps;

  @Step
  public void household_empty_postal_code_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(householdEmptyPostalCodeErrorMessage,
        getPageObject().getHouseholdPostalCodeRequiredErrorMessage());
  }

  @Step
  public void household_wrong_postal_code_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(householdWrongPostalCodeErrorMessage,
        getPageObject().getHouseholdWrongPostalCodeRequiredErrorMessage());
  }

  @Step
  public void unknown_address_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(householdUknownAddressErrorMessage,
        getPageObject().getUknownAddressErrorMessage());
  }

  @Step
  public void household_empty_living_space_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(householdLivingSpaceRequiredErrorMessage,
        getPageObject().getHouseholdLivingSpaceRequiredErrorMessage());
  }

  @Step
  public void max_living_space_size_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(householdMaxLivinSpaceSizeErrorMessage,
        getPageObject().getHouseholdLivingSpaceAreaSizeErrorMessage());
  }

  @Step
  public void empty_insurance_sum_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(householdEmptyInsuredSumErrorMessage,
        getPageObject().getHouseholdInsuredSumRequiredErrorMessage());
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

  @StepGroup
  public void submit_comparison_household(InsuranceData insuranceDatadata,
                                          CustomerData customerDatadata) {
    open_page();
    enter_postal_code(customerDatadata.getPostalCode());
    enter_living_space(insuranceDatadata.getHouseholdLivingSpace());
    unselect_birthday_fields();
    select_birth_day(customerDatadata.getBirthDay());
    select_birth_month(customerDatadata.getBirthMonth());
    select_birth_year(customerDatadata.getBirthYear());
    search_for_offers();
  }
}
