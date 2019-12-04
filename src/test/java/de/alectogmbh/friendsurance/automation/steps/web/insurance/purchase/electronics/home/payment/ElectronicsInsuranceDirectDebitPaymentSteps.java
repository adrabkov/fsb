package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.payment;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.payment.InsuranceDirectDebitPaymentPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.AbstractElectronicInsurancePurchaseSteps;
import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class ElectronicsInsuranceDirectDebitPaymentSteps
    extends AbstractElectronicInsurancePurchaseSteps {

  private InsuranceDirectDebitPaymentPage insuranceDirectDebitPaymentPage;

  @Step
  public void enter_account_number(String accountNumber) {
    getPageObject().enterAccountNumber(accountNumber);
  }

  @Step
  public void enter_iban(String iban) {
    getPageObject().enterIBAN(iban);
  }

  @Step
  public void enter_bank_code(String bankCode) {
    getPageObject().enterBankCode(bankCode);
  }

  @Step
  public void enter_account_holder_name(String holderName) {
    getPageObject().enterAccountHolderName(holderName);
  }

  @Step
  public void accept_sepa_conditions() {
    getPageObject().checkSepaAgreement();
  }

  @Step
  public void reject_sepa_conditions() {
    getPageObject().unCheckSepaAgreement();
  }

  @Step
  public void submit_account_form() {
    getPageObject().clickOnAccountSubmitButton();
  }

  @Step
  public void click_account_field() {
    getPageObject().clickOnAccountField();
  }

  @Step
  public void click_bank_code_field() {
    getPageObject().clickOnBankCodeField();
  }

  @Step
  public void accept_sepa_agreement(Boolean sepaAccepted) {
    if (sepaAccepted) {
      accept_sepa_conditions();
    } else {
      reject_sepa_conditions();
    }
  }

  @Step
  public void wait_for_submit_button_disappear() {
    getPageObject().waitForSumbitButtonToDisappear();
  }

  @StepGroup
  public void fill_out_payment_form(CustomerData data) {
    final String IBAN = "iban";
    if (data.getPaymentType().equals(IBAN)) {
      if (data.getIban() != null) {
        enter_iban(data.getIban());
      }
    } else {
      if (data.getAccountNumber() != null) {
        enter_account_number(data.getAccountNumber());
      } else {
        click_account_field();
      }
      if (data.getBankCode() != null) {
        enter_bank_code(data.getBankCode());
      } else {
        click_bank_code_field();
      }
    }

    if (data.getAccountHolder() != null) {
      enter_account_holder_name(data.getAccountHolder());
    }

    accept_sepa_agreement(data.getAcceptSEPA());
  }

  protected InsuranceDirectDebitPaymentPage getPageObject() {
    return insuranceDirectDebitPaymentPage;
  }
}
