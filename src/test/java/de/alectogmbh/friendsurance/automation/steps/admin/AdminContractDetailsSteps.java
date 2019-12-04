package de.alectogmbh.friendsurance.automation.steps.admin;

import de.alectogmbh.friendsurance.automation.pages.admin.AdminContractDetailsPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;

public class AdminContractDetailsSteps extends AbstractScenarioSteps<AdminContractDetailsPage> {


  AdminContractDetailsPage adminContractDetailsPage;

  @Step
  public void clickActivateContractViaApi() {
    adminContractDetailsPage.clickActivationButton();
    adminContractDetailsPage.clickConfirmationButton();
  }

  @Step
  public String getPolicyNumber() {
    return adminContractDetailsPage.getPolicyNumber();
  }

  @Override
  protected AdminContractDetailsPage getPageObject() {
    return adminContractDetailsPage;
  }
}