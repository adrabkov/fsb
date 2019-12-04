package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.payment;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.payment.InsuranceDirectDebitPaymentPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ElectronicsInsuranceCreditCardPaymentValidationSteps
    extends ElectronicsInsuranceCreditCardPaymentSteps {

  private InsuranceDirectDebitPaymentPage insuranceDirectDebitPaymentPage;

  @Step
  public void credit_card_submit_button_is_present() {
    assertThat(
        "Credit card submit button is not present",
        getPageObject().isCreditCardSubmitButtonPresent(), is(true)
    );
  }

  protected InsuranceDirectDebitPaymentPage getPageObject() {
    return insuranceDirectDebitPaymentPage;
  }
}
