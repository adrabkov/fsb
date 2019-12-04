package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.tv;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.TVInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategoryPageSteps;
import net.thucydides.core.pages.Pages;

public class TVInsuranceCategoryPageSteps
    extends AbstractElectronicsInsuranceCategoryPageSteps<TVInsuranceCategoryPage> {

  private TVInsuranceCategoryPage tvInsuranceCategoryPage;

  public TVInsuranceCategoryPageSteps() {
  }

  public TVInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }

  @Override
  protected TVInsuranceCategoryPage getPageObject() {
    return tvInsuranceCategoryPage;
  }
}
