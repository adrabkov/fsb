package de.alectogmbh.friendsurance.automation.steps.web.insurance.dashboard;

import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.dashboard.ReportDamageInsurancePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class ReportDamageInsuranceSteps extends AbstractDashboardInsuranceSteps {

  ReportDamageInsurancePage reportDamageInsurancePage;

  public ReportDamageInsuranceSteps() {
  }

  public ReportDamageInsuranceSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void click_on_submit_button() {
    getPageObject().clickOnSubmitButton();
  }

  @Override
  protected ReportDamageInsurancePage getPageObject() {
    return reportDamageInsurancePage;
  }
}
