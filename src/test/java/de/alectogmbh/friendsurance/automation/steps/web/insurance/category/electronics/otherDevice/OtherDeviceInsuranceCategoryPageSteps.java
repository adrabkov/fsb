package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.otherDevice;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.OtherDeviceInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategoryPageSteps;
import net.thucydides.core.pages.Pages;

public class OtherDeviceInsuranceCategoryPageSteps extends
        AbstractElectronicsInsuranceCategoryPageSteps<OtherDeviceInsuranceCategoryPage> {

  private OtherDeviceInsuranceCategoryPage otherDeviceInsuranceCategoryPage;

  public OtherDeviceInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }

  @Override
  protected OtherDeviceInsuranceCategoryPage getPageObject() {
    return otherDeviceInsuranceCategoryPage;
  }

}
