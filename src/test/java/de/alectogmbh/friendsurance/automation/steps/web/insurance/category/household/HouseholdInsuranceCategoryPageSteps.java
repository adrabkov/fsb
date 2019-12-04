package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.household;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.household.HouseholdInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.AbstractOtherInsuranceCategoryPageSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;


public class HouseholdInsuranceCategoryPageSteps extends
    AbstractOtherInsuranceCategoryPageSteps<HouseholdInsuranceCategoryPage> {

  private HouseholdInsuranceCategoryPage householdInsurancePage;

  public HouseholdInsuranceCategoryPageSteps() {
  }

  public HouseholdInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }


  @Step
  public void click_main_cta() {
    getPageObject().clickMainCta();
  }

  @Override
  protected HouseholdInsuranceCategoryPage getPageObject() {
    return householdInsurancePage;
  }

}
