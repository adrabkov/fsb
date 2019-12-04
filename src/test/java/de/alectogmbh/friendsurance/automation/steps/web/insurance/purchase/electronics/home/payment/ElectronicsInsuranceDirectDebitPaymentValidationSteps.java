package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.payment;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.payment.InsuranceDirectDebitPaymentPage;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class ElectronicsInsuranceDirectDebitPaymentValidationSteps
    extends ElectronicsInsuranceDirectDebitPaymentSteps {

  private InsuranceDirectDebitPaymentPage insuranceDirectDebitPaymentPage;

  protected InsuranceDirectDebitPaymentPage getPageObject() {
    return insuranceDirectDebitPaymentPage;
  }

  public void verify_empty_account_number_error_message_is_displayed() {
    Assert.assertThat(getPageObject().getAccountNumberErrorText(), is(equalTo("Keine gültige Konto-Nr.")));
  }

  public void verify_empty_bank_code_error_message_is_displayed() {
    Assert.assertThat(getPageObject().getBankCodeErrorText(), is(equalTo("Keine gültige BLZ")));
  }

  public void verify_not_accepted_sepa_error_message_is_displayed() {
    Assert.assertThat(getPageObject().getUncheckedSepaErrorText(), is(equalTo("Bitte bestätigen")));
  }
}
