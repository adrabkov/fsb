package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.iphone;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.IphoneInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategoryPageSteps;
import net.thucydides.core.pages.Pages;

public class IphoneInsuranceCategoryPageSteps extends
        AbstractElectronicsInsuranceCategoryPageSteps<IphoneInsuranceCategoryPage> {

  private IphoneInsuranceCategoryPage iphoneInsurancePage;

  public IphoneInsuranceCategoryPageSteps() {
  }

  public IphoneInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }


  @Override
  protected IphoneInsuranceCategoryPage getPageObject() {
    return iphoneInsurancePage;
  }

}
