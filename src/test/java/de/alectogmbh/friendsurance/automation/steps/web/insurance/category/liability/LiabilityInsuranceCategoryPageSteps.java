package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.liability;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.liability.LiabilityInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.AbstractOtherInsuranceCategoryPageSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;


public class LiabilityInsuranceCategoryPageSteps extends
    AbstractOtherInsuranceCategoryPageSteps<LiabilityInsuranceCategoryPage> {

  private LiabilityInsuranceCategoryPage liabilityInsurancePage;

  public LiabilityInsuranceCategoryPageSteps() {
  }

  public LiabilityInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void click_main_cta() {
    getPageObject().clickMainCta();
  }


  @Override
  protected LiabilityInsuranceCategoryPage getPageObject() {
    return liabilityInsurancePage;
  }

}
