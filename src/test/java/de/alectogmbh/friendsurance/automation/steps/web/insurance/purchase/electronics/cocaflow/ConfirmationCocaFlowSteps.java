package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.ConfirmationCocaFlowPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class ConfirmationCocaFlowSteps extends AbstractCocaFlowScenarioSteps<ConfirmationCocaFlowPage> {

  private static final String EXPECTED_CONFIRMATION_PAGE_HEADLINE = "Herzlichen Glückwunsch!";
  private static final String EXPECTED_MINICARD_HEADLINE = "Friendsurance Mobilgeräteversicherung 1000";

  private ConfirmationCocaFlowPage confirmationCocaFlowPage;

  @Step
  public String get_confirmation_page_headline_text() {
    return getPageObject().getConfirmationPageHeadlineText();
  }

  @Step
  public String get_mini_card_headline_text() {
    return getPageObject().getTariffMiniCardHeadlineText();
  }

  @Step
  public void verify_confirmation_page_headline() {
    assertEquals(EXPECTED_CONFIRMATION_PAGE_HEADLINE, get_confirmation_page_headline_text());
  }

  @Step
  public void verify_mini_card_headline_text() {
    assertEquals(EXPECTED_MINICARD_HEADLINE, get_mini_card_headline_text());
  }

  @Step
  public void click_on_go_to_dashboard_button() {
    getPageObject().clickToContinue();
  }

  @Step
  public void click_on_edit_address_option() {
    getPageObject().clickOnEditAddressIcon();
  }

  @StepGroup
  public void check_data_from_confirmation_page_and_finish_the_flow() {
    verify_confirmation_page_headline();
    verify_mini_card_headline_text();
    click_on_go_to_dashboard_button();
  }

  @Override
  protected ConfirmationCocaFlowPage getPageObject() {
    return confirmationCocaFlowPage;
  }
}
