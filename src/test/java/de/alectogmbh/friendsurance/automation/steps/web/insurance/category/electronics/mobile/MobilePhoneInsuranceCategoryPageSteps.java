package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.mobile;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.MobilePhoneInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics.AbstractElectronicsInsuranceCategoryPageSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class MobilePhoneInsuranceCategoryPageSteps extends
    AbstractElectronicsInsuranceCategoryPageSteps<MobilePhoneInsuranceCategoryPage> {

  private MobilePhoneInsuranceCategoryPage mobilePhoneInsurancePage;

  public MobilePhoneInsuranceCategoryPageSteps() {
  }

  public MobilePhoneInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }

  @Override
  protected MobilePhoneInsuranceCategoryPage getPageObject() {
    return mobilePhoneInsurancePage;
  }

  @Step
  public void is_inline_testsieger_visible() {
    ValidationUtils.checkElementIsDisplayed("Inline Testsieger Symbol is displayed",
        getPageObject().isInlineTestsiegerVisible());
  }

  @Step
  public void is_footer_testsieger_visible() {
    ValidationUtils.checkElementIsDisplayed("Foter Testsieger Symbol is displayed",
        getPageObject().isFooterTestsiegerVisible());
  }
}
