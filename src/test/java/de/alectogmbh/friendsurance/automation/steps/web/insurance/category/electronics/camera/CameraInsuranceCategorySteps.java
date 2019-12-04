package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.camera;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.CameraInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategorySteps;
import net.thucydides.core.pages.Pages;

public class CameraInsuranceCategorySteps extends
    AbstractElectronicsInsuranceCategorySteps<CameraInsuranceCategoryPage> {

  private CameraInsuranceCategoryPage cameraInsurancePage;

  public CameraInsuranceCategorySteps(Pages pages) {
    super(pages);
  }

  @Override
  protected CameraInsuranceCategoryPage getPageObject() {
    return cameraInsurancePage;
  }

}
