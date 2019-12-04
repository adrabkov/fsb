package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.CheckoutCocaFlowPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class CheckoutCocaFlowSteps extends AbstractCocaFlowScenarioSteps<CheckoutCocaFlowPage> {

  private static final String EXPECTED_CHECKOUT_PAGE_HEADLINE = "Bitte überprüfen Sie Ihre Daten";

  private CheckoutCocaFlowPage checkoutCocaFlowPage;

  @Step
  public String get_checkout_page_headline() {
    return getPageObject().getCheckoutPageHeadlineText();
  }

  @Step
  public void accept_terms_and_conditions_checkbox() {
    getPageObject().acceptTermsAndConditions();
  }

  @Step
  public void verify_checkout_page_headline() {
    assertEquals(EXPECTED_CHECKOUT_PAGE_HEADLINE, get_checkout_page_headline());
  }

  @Step
  public void click_on_purchase_button() {
    getPageObject().clickToContinue();
  }

  @StepGroup
  public void complete_checkout() {
    verify_checkout_page_headline();
    accept_terms_and_conditions_checkbox();
    click_on_purchase_button();
  }

  @Override
  protected CheckoutCocaFlowPage getPageObject() {
    return checkoutCocaFlowPage;
  }
}
