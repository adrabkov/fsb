package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.mobile;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.MobilePhoneInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategorySteps;
import net.thucydides.core.pages.Pages;

public class MobilePhoneInsuranceCategorySteps extends
        AbstractElectronicsInsuranceCategorySteps<MobilePhoneInsuranceCategoryPage> {

  private MobilePhoneInsuranceCategoryPage mobilePhoneInsuranceCategoryPage;

  public MobilePhoneInsuranceCategorySteps(Pages pages) {
    super(pages);
  }

  @Override
  protected MobilePhoneInsuranceCategoryPage getPageObject() {
    return mobilePhoneInsuranceCategoryPage;
  }

}
