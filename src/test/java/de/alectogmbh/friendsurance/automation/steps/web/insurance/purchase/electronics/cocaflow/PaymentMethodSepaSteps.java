package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.PaymentMethodSepaCocaFlowPage;
import net.thucydides.core.annotations.Step;

public class PaymentMethodSepaSteps extends AbstractCocaFlowScenarioSteps<PaymentMethodSepaCocaFlowPage> {

  private PaymentMethodSepaCocaFlowPage paymentMethodSepaCocaFlowPage;

  @Step
  public void enter_iban_number(String iban) {
    getPageObject().enterIbanNumber(iban);
  }

  @Step
  public void check_accept_sepa_condition_check_box() {
    getPageObject().checkAcceptSepaConditionsCheckbox();
  }

  @Step
  public void click_on_next_button() {
    click_on_continue_button();
  }

  @Override
  protected PaymentMethodSepaCocaFlowPage getPageObject() {
    return paymentMethodSepaCocaFlowPage;
  }

}
