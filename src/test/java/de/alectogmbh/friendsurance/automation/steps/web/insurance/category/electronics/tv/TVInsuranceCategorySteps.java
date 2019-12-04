package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.tv;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.TVInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategorySteps;
import net.thucydides.core.pages.Pages;

public class TVInsuranceCategorySteps
    extends AbstractElectronicsInsuranceCategorySteps<TVInsuranceCategoryPage> {

  private TVInsuranceCategoryPage tvInsuranceCategoryPage;

  public TVInsuranceCategorySteps(Pages pages) {
    super(pages);
  }

  @Override
  protected TVInsuranceCategoryPage getPageObject() {
    return tvInsuranceCategoryPage;
  }
}
