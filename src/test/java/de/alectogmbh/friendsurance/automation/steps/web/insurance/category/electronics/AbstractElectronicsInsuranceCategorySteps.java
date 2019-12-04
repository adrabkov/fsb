package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.AbstractElectronicsInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.AbstractInsuranceCategoryPageSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public abstract class AbstractElectronicsInsuranceCategorySteps<T extends AbstractElectronicsInsuranceCategoryPage>
    extends AbstractInsuranceCategoryPageSteps<T> {

  public AbstractElectronicsInsuranceCategorySteps() {
  }

  public AbstractElectronicsInsuranceCategorySteps(Pages pages) {
    super(pages);
  }

  @Step
  public void choose_insurance_category(String modelOrPriceCategory) {
    getPageObject().selectModelOrPriceCategoryByValue(modelOrPriceCategory);
    getPageObject().clickMainCta();
  }

  public void checkRightTariffIsChosen(String tariffName) {
    Assert.assertThat(getPageObject().getTariffName(), is(equalTo(tariffName)));
  }

  public void selectStandardPackage() {
    getPageObject().selectStandardPackage();
  }
}
