package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbDashboardPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import static junit.framework.TestCase.assertEquals;

public class HvbDashboardSteps extends AbstractScenarioSteps<HvbDashboardPage> {

  private static final String EXPECTED_DASHBOARD_HEADLINE = "Ihre Versicherungen auf einen Blick";

  private HvbDashboardPage hvbDashboardPage;

  public HvbDashboardPage getPageObject() {
    return hvbDashboardPage;
  }

  @Step
  public String get_dashboard_headline_text() {
    return getPageObject().getDashboardHeadlineText();
  }

  @StepGroup
  public void verify_if_home_page_is_loaded_and_dashboard_headline_is_present() {
    assertEquals(EXPECTED_DASHBOARD_HEADLINE, get_dashboard_headline_text());
  }

  @Step
  public void click_on_navigation_item_notifications_link() {
    getPageObject().clickOnNavigationItemNotificationsLink();
  }

  @Step
  public void click_on_dashboard_header_logout_link() {
    getPageObject().clickOnDashboardHeaderLogoutLink();
  }

}
