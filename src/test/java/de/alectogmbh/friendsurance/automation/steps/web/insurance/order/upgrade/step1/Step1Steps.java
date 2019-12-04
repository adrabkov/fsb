package de.alectogmbh.friendsurance.automation.steps.web.insurance.order.upgrade.step1;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.Step1Page;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.order.AbstractOrderFlowSteps;
import de.alectogmbh.friendsurance.automation.steps.web.utils.InsuranceData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

public class Step1Steps extends AbstractOrderFlowSteps<Step1Page> {

  private static final String LIABILITY = "Privat-Haftpflicht";
  private static final String HOUSEHOLD = "Hausrat";
  private static final String LEGAL = "Rechtsschutz";
  private static final String CAR = "Kfz";

  private Step1Page step1Page;

  public Step1Steps(Pages pages) {
  }

  @Step
  public void select_liability_insurance(String liaName) {
    getPageObject().selectInsurance(LIABILITY, liaName);
  }

  @Step
  public void enter_liability_insurance_policy_number(String liabilityInsurancePolicyNumber) {
    getPageObject().enterInsurancePolicyNumber(LIABILITY, liabilityInsurancePolicyNumber);
  }

  @Step
  public void select_household_insurance(String hhName) {
    getPageObject().selectInsurance(HOUSEHOLD, hhName);
  }

  @Step
  public void enter_household_insurance_policy_number(String householdInsurancePolicyNumber) {
    getPageObject().enterInsurancePolicyNumber(HOUSEHOLD, householdInsurancePolicyNumber);
  }

  @Step
  public void select_legal_insurance(String legal) {
    getPageObject().selectInsurance(LEGAL, legal);
  }

  @Step
  public void enter_legal_insurance_policy_number(String legalInsurancePolicyNumber) {
    getPageObject().enterInsurancePolicyNumber(LEGAL, legalInsurancePolicyNumber);
  }

  @Step
  public void select_car_insurance(String carName) {
    getPageObject().selectInsurance(CAR, carName);
  }

  @Step
  public void enter_car_insurance_policy_number(String kfzPolicyNumber) {
    getPageObject().enterInsurancePolicyNumber(CAR, kfzPolicyNumber);
  }

  @Step
  public void click_submit_button() {
    getPageObject().click_submit_button();
  }

  @StepGroup
  public void enter_correct_data_x_selling_liability(InsuranceData data) {
    select_liability_insurance(data.getLiabilityNameXselling());
    enter_liability_insurance_policy_number(data.getLiabilityPolicyNumber());
  }

  @StepGroup
  public void enter_correct_data_x_selling_household(InsuranceData data) {
    select_household_insurance(data.getHouseholdNameXselling());
    enter_household_insurance_policy_number(data.getHouseholdPolicyNumber());
  }

  @StepGroup
  public void enter_correct_data_x_selling_legal(InsuranceData data) {
    select_legal_insurance(data.getLegalNameXselling());
    enter_legal_insurance_policy_number(data.getLegalPolicyNumber());

  }

  @StepGroup
  public void enter_correct_data_x_selling_car(InsuranceData data) {
    select_car_insurance(data.getCarNameXselling());
    enter_car_insurance_policy_number(data.getCarPolicyNumber());
  }

  @StepGroup
  public void enter_correct_data_upgrade_liability(InsuranceData data) {
    select_liability_insurance(data.getLiabilityNameUpgrade());
    enter_liability_insurance_policy_number(data.getLiabilityPolicyNumber());
  }

  @StepGroup
  public void enter_correct_data_upgrade_household(InsuranceData data) {
    select_household_insurance(data.getHouseholdNameUpgrade());
    enter_household_insurance_policy_number(data.getHouseholdPolicyNumber());
  }

  @StepGroup
  public void enter_correct_data_upgrade_legal(InsuranceData data) {
    select_legal_insurance(data.getLegalNameUpgrade());
    enter_legal_insurance_policy_number(data.getLegalPolicyNumber());
  }

  @StepGroup
  public void enter_correct_data_upgrade_car(InsuranceData data) {
    select_car_insurance(data.getCarNameUpgrade());
    enter_car_insurance_policy_number(data.getCarPolicyNumber());
  }

  @StepGroup
  public void enter_all_upgrade(InsuranceData data) {
    enter_correct_data_upgrade_liability(data);
    enter_correct_data_upgrade_household(data);
    enter_correct_data_upgrade_legal(data);
    enter_correct_data_upgrade_car(data);
  }

  @Override
  protected Step1Page getPageObject() {
    return step1Page;
  }

}
