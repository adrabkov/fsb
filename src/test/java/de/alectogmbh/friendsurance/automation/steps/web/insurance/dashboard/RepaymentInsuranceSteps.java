package de.alectogmbh.friendsurance.automation.steps.web.insurance.dashboard;

import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.dashboard.RepaymentInsurancePage;

public class RepaymentInsuranceSteps
    extends AbstractDashboardInsuranceSteps<RepaymentInsurancePage> {

  private RepaymentInsurancePage repaymentInsurancePage;

  @Override
  protected RepaymentInsurancePage getPageObject() {
    return repaymentInsurancePage;
  }
}
