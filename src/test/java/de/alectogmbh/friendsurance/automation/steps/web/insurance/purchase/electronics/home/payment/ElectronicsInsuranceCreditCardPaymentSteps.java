package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.payment;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.payment.InsuranceDirectDebitPaymentPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.AbstractElectronicInsurancePurchaseSteps;
import net.thucydides.core.annotations.Step;

public class ElectronicsInsuranceCreditCardPaymentSteps
    extends AbstractElectronicInsurancePurchaseSteps {

  private InsuranceDirectDebitPaymentPage insuranceDirectDebitPaymentPage;

  @Step
  public void click_on_credit_card_option() {
    getPageObject().clickOnCreditCardOption();
  }

  protected InsuranceDirectDebitPaymentPage getPageObject() {
    return insuranceDirectDebitPaymentPage;
  }
}
