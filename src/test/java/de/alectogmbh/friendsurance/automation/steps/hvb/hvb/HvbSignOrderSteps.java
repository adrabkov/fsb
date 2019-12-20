package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbSignOrderPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import static org.junit.Assert.assertEquals;

public class HvbSignOrderSteps extends AbstractScenarioSteps<HvbSignOrderPage> {

  private static final String EXPECTED_SIGN_ORDER_PAGE_HEADLINE = "Fehlt nur noch das Auskunftsmandat";

  private HvbSignOrderPage hvbSignOrderPage;

  public HvbSignOrderPage getPageObject() {
    return hvbSignOrderPage;
  }

  @Step
  public String get_sign_order_page_headline() {
    return getPageObject().getSignOrderPageHeadline();
  }

  @Step
  public void sign_authorize_component() {
    getPageObject().sign();
  }

  @Step
  public void click_sign_order_submit_button() {
    getPageObject().clickSignOrderSubmitButton();
  }

  @Step
  public void verify_sign_order_page_is_loaded_and_headline_is_present() {
    assertEquals(EXPECTED_SIGN_ORDER_PAGE_HEADLINE, get_sign_order_page_headline());
  }

  @StepGroup
  public void verify_sign_authorization_and_submit_order_items() {
    verify_sign_order_page_is_loaded_and_headline_is_present();
    sign_authorize_component();
    click_sign_order_submit_button();
  }

}
