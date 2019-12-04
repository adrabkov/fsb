package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.ipad;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.IpadInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategorySteps;
import net.thucydides.core.pages.Pages;

public class IpadInsuranceCategorySteps
    extends AbstractElectronicsInsuranceCategorySteps<IpadInsuranceCategoryPage> {

  private IpadInsuranceCategoryPage ipadInsurancePage;

  public IpadInsuranceCategorySteps(Pages pages) {
    super(pages);
  }

  @Override
  protected IpadInsuranceCategoryPage getPageObject() {
    return ipadInsurancePage;
  }

}
