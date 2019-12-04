package de.alectogmbh.friendsurance.automation.steps.admin;

import de.alectogmbh.friendsurance.automation.pages.admin.AdminContractDetailsPage;
import de.alectogmbh.friendsurance.automation.pages.admin.AdminContractSearchPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;

public class AdminContractSearchSteps extends AbstractScenarioSteps<AdminContractSearchPage> {

  AdminContractSearchPage adminContractSearchPage;

  AdminContractDetailsPage adminContractDetailsPage;

  @Step
  public void findContractByEmail(String mail) {
    adminContractSearchPage.enterSearchTerm(mail);
    adminContractSearchPage.clickSearchButton();
  }

  @Step
  public void openContractDetails() {
    adminContractDetailsPage.openPage(adminContractSearchPage.getContractId());
  }


  @Override
  protected AdminContractSearchPage getPageObject() {
    return adminContractSearchPage;
  }
}
