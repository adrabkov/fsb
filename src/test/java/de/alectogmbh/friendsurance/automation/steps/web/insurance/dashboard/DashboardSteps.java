package de.alectogmbh.friendsurance.automation.steps.web.insurance.dashboard;

import de.alectogmbh.friendsurance.automation.pages.web.user.DashboardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class DashboardSteps extends AbstractDashboardInsuranceSteps {

  DashboardPage dashboardPage;

  public DashboardSteps() {

  }

  public DashboardSteps(Pages pages) {
    super(pages);
  }

  @Step
  public List<String> get_all_shown_pending_insurance_types() {
    return getPageObject().getAllPendingInsurances();
  }

  @Step
  public void check_if_all_insurance_types_are_shown(Map<String, String> categoryAndCompanyMap) {
    List<String> insuranceTypes = get_all_shown_pending_insurance_types();
    Assert.assertEquals("Should be 4 insurance types", 4, insuranceTypes.size());

    for (String type : insuranceTypes) {
      Assert.assertTrue(type + " is not found", categoryAndCompanyMap.containsKey(type));
    }

  }

  @Override
  protected DashboardPage getPageObject() {
    return dashboardPage;
  }


}
