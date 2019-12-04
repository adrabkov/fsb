package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.otherDevice;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.OtherDeviceInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategorySteps;
import net.thucydides.core.pages.Pages;

public class OtherDeviceInsuranceCategorySteps extends
        AbstractElectronicsInsuranceCategorySteps<OtherDeviceInsuranceCategoryPage> {

  private OtherDeviceInsuranceCategoryPage otherDeviceInsuranceCategoryPage;

  public OtherDeviceInsuranceCategorySteps(Pages pages) {
    super(pages);
  }

  @Override
  protected OtherDeviceInsuranceCategoryPage getPageObject() {
    return otherDeviceInsuranceCategoryPage;
  }

}

