package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.laptop;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.LaptopInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategorySteps;
import net.thucydides.core.pages.Pages;

public class LaptopInsuranceCategorySteps extends
        AbstractElectronicsInsuranceCategorySteps<LaptopInsuranceCategoryPage> {

  private LaptopInsuranceCategoryPage laptopInsurancePage;

  public LaptopInsuranceCategorySteps(Pages pages) {
    super(pages);
  }

  @Override
  protected LaptopInsuranceCategoryPage getPageObject() {
    return laptopInsurancePage;
  }

}
