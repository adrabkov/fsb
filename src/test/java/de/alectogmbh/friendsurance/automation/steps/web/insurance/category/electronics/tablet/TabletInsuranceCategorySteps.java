package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.tablet;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.TabletInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategorySteps;
import net.thucydides.core.pages.Pages;

public class TabletInsuranceCategorySteps extends
    AbstractElectronicsInsuranceCategorySteps<TabletInsuranceCategoryPage> {

  private TabletInsuranceCategoryPage tabletInsuranceCategoryPage;

  public TabletInsuranceCategorySteps(Pages pages) {
    super(pages);
  }

  @Override
  protected TabletInsuranceCategoryPage getPageObject() {
    return tabletInsuranceCategoryPage;
  }

}
