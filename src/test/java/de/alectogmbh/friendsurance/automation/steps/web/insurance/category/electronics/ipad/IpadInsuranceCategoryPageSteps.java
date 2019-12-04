package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.ipad;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.IpadInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategoryPageSteps;
import net.thucydides.core.pages.Pages;

public class IpadInsuranceCategoryPageSteps extends
        AbstractElectronicsInsuranceCategoryPageSteps<IpadInsuranceCategoryPage> {

  private IpadInsuranceCategoryPage ipadInsurancePage;

  public IpadInsuranceCategoryPageSteps() {
  }

  public IpadInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }

  @Override
  protected IpadInsuranceCategoryPage getPageObject() {
    return ipadInsurancePage;
  }

}
