package de.alectogmbh.friendsurance.automation.steps.web.insurance.dashboard;

import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.dashboard.MyInsurancesPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class MyInsurancesSteps extends AbstractDashboardInsuranceSteps<MyInsurancesPage> {

  private MyInsurancesPage myInsurancesPage;

  @Step
  public List<String> get_all_non_inactive_insurance_types() {
    return getPageObject().getAllNonInactiveInsuranceTypes();
  }

  @Step
  public void check_all_non_inactive_insurance_types_are_shown_in_details_page(Map<String, String> categoryAndCompanyMap) {
    List<String> actualTypes = get_all_non_inactive_insurance_types();
    Assert.assertEquals("4 insurance types should be shown", 4, actualTypes.size());

    for (String type : actualTypes) {
      Assert.assertTrue(type + " is not found", categoryAndCompanyMap.containsKey(type));
    }
  }

  @Override
  protected MyInsurancesPage getPageObject() {
    return myInsurancesPage;
  }
}
