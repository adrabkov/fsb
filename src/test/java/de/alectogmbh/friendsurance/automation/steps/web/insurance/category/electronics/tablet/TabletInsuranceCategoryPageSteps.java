package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.tablet;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.TabletInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategoryPageSteps;
import net.thucydides.core.pages.Pages;

public class TabletInsuranceCategoryPageSteps extends
    AbstractElectronicsInsuranceCategoryPageSteps<TabletInsuranceCategoryPage> {

  private TabletInsuranceCategoryPage tabletInsurancePage;

  public TabletInsuranceCategoryPageSteps() {
  }

  public TabletInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }

  @Override
  protected TabletInsuranceCategoryPage getPageObject() {
    return tabletInsurancePage;
  }

}
