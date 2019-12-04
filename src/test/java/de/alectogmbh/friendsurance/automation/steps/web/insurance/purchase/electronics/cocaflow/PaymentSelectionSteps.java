package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.PaymentSelectionCocaFlowPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class PaymentSelectionSteps extends AbstractCocaFlowScenarioSteps<PaymentSelectionCocaFlowPage> {

  private PaymentSelectionCocaFlowPage paymentSelectionPage;

  @Step
  public void select_credit_card_payment_method() {
    getPageObject().selectCardPaymentMethod();
  }

  @Step
  public void select_sepa_payment_method() {
    getPageObject().selectSepaPaymentMethod();
  }

  @StepGroup
  public void select_card_payment_method() {
    select_credit_card_payment_method();
    click_on_continue_button();
  }

  @StepGroup
  public void select_SEPA_payment_method() {
    select_sepa_payment_method();
    click_on_continue_button();
  }

  @Override
  protected PaymentSelectionCocaFlowPage getPageObject() {
    return paymentSelectionPage;
  }

}
