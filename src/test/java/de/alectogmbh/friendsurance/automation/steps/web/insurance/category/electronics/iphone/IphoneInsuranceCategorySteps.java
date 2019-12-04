package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.iphone;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.IphoneInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategorySteps;
import net.thucydides.core.pages.Pages;

public class IphoneInsuranceCategorySteps extends
        AbstractElectronicsInsuranceCategorySteps<IphoneInsuranceCategoryPage> {

  private IphoneInsuranceCategoryPage iphoneInsurancePage;

  public IphoneInsuranceCategorySteps(Pages pages) {
    super(pages);
  }

  @Override
  protected IphoneInsuranceCategoryPage getPageObject() {
    return iphoneInsurancePage;
  }


}
