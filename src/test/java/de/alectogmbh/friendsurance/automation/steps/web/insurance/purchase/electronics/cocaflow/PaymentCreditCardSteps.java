package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.PaymentMethodCardCocaFlowPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import java.util.Calendar;

import static de.alectogmbh.friendsurance.common.util.DateUtil.formatDate;

public class PaymentCreditCardSteps extends AbstractCocaFlowScenarioSteps<PaymentMethodCardCocaFlowPage> {

  private PaymentMethodCardCocaFlowPage paymentMethodCardCocaFlowPage;

  @Step
  public void enter_card_expiration_date() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.YEAR, 3);
    getPageObject().enterCardExpirationDate(formatDate(calendar.getTime(), "MMyy"));

  }

  @StepGroup
  public void fill_credit_card_form_and_verify_card_holder() {
    getPageObject().getCardHolderName();
    getPageObject().enterCardNumber("4111111111111111");
    enter_card_expiration_date();
    getPageObject().enterCardCvcCode("200");
    click_on_continue_button();
  }

  @Override
  protected PaymentMethodCardCocaFlowPage getPageObject() {
    return paymentMethodCardCocaFlowPage;
  }

}
