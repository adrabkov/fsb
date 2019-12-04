package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.camera;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.CameraInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategoryPageSteps;
import net.thucydides.core.pages.Pages;

public class CameraInsuranceCategoryPageSteps extends
    AbstractElectronicsInsuranceCategoryPageSteps<CameraInsuranceCategoryPage> {

  private CameraInsuranceCategoryPage cameraInsurancePage;

  public CameraInsuranceCategoryPageSteps() {
  }

  public CameraInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }

  @Override
  protected CameraInsuranceCategoryPage getPageObject() {
    return cameraInsurancePage;
  }

}
