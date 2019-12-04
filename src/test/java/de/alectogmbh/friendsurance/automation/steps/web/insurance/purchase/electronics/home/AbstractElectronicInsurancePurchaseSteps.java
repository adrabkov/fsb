package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.AbstractElectronicInsurancePurchasePage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.activation.ElectronicInsuranceActivationSteps;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.checkout.ElectronicInsuranceCheckoutSteps;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.payment.ElectronicsInsuranceDirectDebitPaymentSteps;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.success.ElectronicInsuranceSuccessSteps;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.verification.ElectronicInsuranceVerificationSteps;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.xselling.ElectronicInsuranceXsellingSteps;
import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import de.alectogmbh.friendsurance.automation.steps.web.utils.InsuranceData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.CustomerDataUtils;
import de.alectogmbh.friendsurance.automation.tests.web.utils.InsuranceDataUtils;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;

public abstract class AbstractElectronicInsurancePurchaseSteps<T extends AbstractElectronicInsurancePurchasePage>
    extends AbstractScenarioSteps {

  @Steps
  ElectronicInsuranceCheckoutSteps electronicInsuranceCheckoutSteps;

  @Steps
  ElectronicsInsuranceDirectDebitPaymentSteps electronicsInsuranceDirectDebitPaymentSteps;

  @Steps
  ElectronicInsuranceActivationSteps electronicInsuranceActivationSteps;

  @Steps
  ElectronicInsuranceSuccessSteps electronicInsuranceSuccessSteps;

  @Steps
  ElectronicInsuranceXsellingSteps electronicInsuranceXsellingSteps;

  @Steps
  ElectronicInsuranceVerificationSteps electronicInsuranceVerificationSteps;

  protected AbstractElectronicInsurancePurchaseSteps() {
  }

  @StepGroup
  public void go_to_payment_page(CustomerData customerData, InsuranceData insuranceData) {
    electronicInsuranceCheckoutSteps.checkout_insurance(customerData, insuranceData);
  }

  @StepGroup
  public void go_to_activation_page_unverified(CustomerData customerData, InsuranceData insuranceData) {
    go_to_payment_page(customerData, insuranceData);
    electronicsInsuranceDirectDebitPaymentSteps.fill_out_payment_form(customerData);
    electronicsInsuranceDirectDebitPaymentSteps.submit_account_form();
    electronicsInsuranceDirectDebitPaymentSteps.wait_for_submit_button_disappear();
  }

  @StepGroup
  public void go_to_activation_page_verified(CustomerData customerData, InsuranceData insuranceData) {
    go_to_activation_page_unverified(customerData, insuranceData);
    electronicInsuranceVerificationSteps.set_verification_code_for_user(customerData.getEmail());
    electronicInsuranceVerificationSteps.click_on_send_verification_code();
    electronicInsuranceVerificationSteps.wait_for_button_disappear();
  }

  @StepGroup
  public void go_to_success_page(CustomerData customerData, InsuranceData insuranceData) {
    go_to_activation_page_verified(customerData, insuranceData);
    electronicInsuranceActivationSteps
        .fill_out_activation_form_mobile(new CustomerDataUtils().createCorrectCustomerData(),
            new InsuranceDataUtils().createInsuranceData());
    electronicInsuranceActivationSteps.click_submit_button();
  }

  @StepGroup
  public void go_to_invitation_page_via_success(CustomerData customerData, InsuranceData insuranceData) {
    go_to_success_page(customerData, insuranceData);
    electronicInsuranceSuccessSteps.click_goto_invitation_button();
  }

  @StepGroup
  public void go_to_invitation_page_via_xselling(CustomerData customerData, InsuranceData insuranceData) {
    go_to_xselling_page(customerData, insuranceData);
    electronicInsuranceXsellingSteps.click_invitation_button();
  }

  @StepGroup
  public void go_to_xselling_page(CustomerData customerData, InsuranceData insuranceData) {
    go_to_success_page(customerData, insuranceData);
    electronicInsuranceSuccessSteps.click_xselling_button();
  }
}
