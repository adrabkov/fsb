package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.laptop;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.LaptopInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategoryPageSteps;
import net.thucydides.core.pages.Pages;

public class LaptopInsuranceCategoryPageSteps extends
    AbstractElectronicsInsuranceCategoryPageSteps<LaptopInsuranceCategoryPage> {

  private LaptopInsuranceCategoryPage laptopInsurancePage;

  public LaptopInsuranceCategoryPageSteps() {
  }

  public LaptopInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }

  @Override
  protected LaptopInsuranceCategoryPage getPageObject() {
    return laptopInsurancePage;
  }

}
