package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.CartOverviewCocaFlowPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class CartOverviewSteps extends AbstractCocaFlowScenarioSteps<CartOverviewCocaFlowPage> {

  private static final String EXPECTED_CART_OVERVIEW_PAGE_HEADLINE = "Warenkorb-Übersicht";

  private CartOverviewCocaFlowPage cartOverviewCocaFlowPage;

  @StepGroup
  public void verify_cart_overview(String expectedTariffName, String expectedModelTextAndPrice,
                                   String expectedTariffHints) {
    verify_cart_overview_page_headline_text();
    verify_tariff_name(expectedTariffName);
    verify_model_text_and_price(expectedModelTextAndPrice);
    verify_tariff_hints(expectedTariffHints);
  }

  @Step
  public String get_cart_overview_page_headline() {
    return getPageObject().getCartOverviewPageHeadlineText();
  }

  @Step
  public void verify_cart_overview_page_headline_text() {
    assertEquals(EXPECTED_CART_OVERVIEW_PAGE_HEADLINE, get_cart_overview_page_headline());
  }

  @Step
  public void verify_tariff_name(String expectedTariffName) {
    assertEquals(expectedTariffName, getPageObject().getTariffName());
  }

  @Step
  private void verify_model_text_and_price(String expectedModelTextAndPrice) {
    assertEquals(expectedModelTextAndPrice, getPageObject().getModelTextAndPrice());
  }

  @Step
  private void verify_tariff_hints(String expectedTariffHints) {
    assertEquals(expectedTariffHints, getPageObject().getTariffHints());
  }

  @Step
  public void click_on_next_button() {
    click_on_continue_button();
  }

  @Override
  protected CartOverviewCocaFlowPage getPageObject() {
    return cartOverviewCocaFlowPage;
  }

}
