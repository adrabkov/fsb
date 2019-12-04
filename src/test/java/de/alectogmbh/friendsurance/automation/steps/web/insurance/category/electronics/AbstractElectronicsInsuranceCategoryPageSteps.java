package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.electronics;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.AbstractElectronicsInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.AbstractInsuranceCategoryPageSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public abstract class AbstractElectronicsInsuranceCategoryPageSteps<T extends AbstractElectronicsInsuranceCategoryPage>
    extends
        AbstractInsuranceCategoryPageSteps<T> {

  public AbstractElectronicsInsuranceCategoryPageSteps() {
  }

  public AbstractElectronicsInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void models_and_price_categories_are_correct(String modelAndPriceCategoryData) {
    List<String> list = Arrays.asList(StringUtils.split(modelAndPriceCategoryData, ';'));
    List<String> actual = getPageObject().getModelsAndPriceCategories();

    Assert.assertEquals("Elemen count is wrong", list.size(), actual.size());

    for (int i = 0; i < list.size(); ++i) {
      String trimmedElement = actual.get(i).trim().replace("\n", "");
      Assert.assertTrue("Elements is not found", list.contains(trimmedElement));
    }
  }

  @Step
  public void default_selection_is_correct(String selectionText) {
    assertThat(
        "Default selection is not correct",
        getPageObject().getDefaultModelOrPriceCategorySelection(),
        equalTo(selectionText)
    );
  }

  @Step
  public void selectDevice(int index) {
    getPageObject().selectModelOrPriceCategory(index);
  }

  @Step
  public void gotoCheckout(String ppp) {
    switch (ppp) {
      case "standard":
        getPageObject().clickButtonStandard();
        break;
      case "komfort":
        getPageObject().clickButtonKomfort();
        break;
      case "premium":
        getPageObject().clickButtonPremium();
        break;
    }
  }

  @Step
  public void toStandardCheckoutButtonPresent() {
    ValidationUtils.checkElementIsDisplayed("to checkout standard button",
        getPageObject().is_to_standard_checkout_button_present());
  }

  @Step
  public void toKomfortCheckoutButtonPresent() {
    ValidationUtils.checkElementIsDisplayed("to checkout komfort button",
        getPageObject().is_to_komfort_checkout_button_present());
  }

  @Step
  public void toPremiumCheckoutButtonPresent() {
    ValidationUtils.checkElementIsDisplayed("to checkout premium button",
        getPageObject().is_to_premium_checkout_button_present());
  }

  @Step
  public void isStandardCheckoutButtonCorrect() {
    ValidationUtils.checkLinkIsCorrect("", getPageObject().get_to_standard_checkout_button_href());
  }

  @Step
  public void isKomfortCheckoutButtonCorrect() {
    ValidationUtils.checkLinkIsCorrect("#", getPageObject().get_to_komfort_checkout_button_href());
  }

  @Step
  public void isPremiumCheckoutButtonCorrect() {
    ValidationUtils.checkLinkIsCorrect("", getPageObject().get_to_premium_checkout_button_href());
  }

  @Step
  public void to_tariffs_second_button_is_present() {
    ValidationUtils.checkElementIsDisplayed("to tariffs second button",
        getPageObject().isToTariffsSecondButtonPresent());
  }

  @Step
  public void to_tariffs_second_button_link_is_correct() {
    ValidationUtils
        .checkLinkIsCorrect("#tarif-hook", getPageObject().getToTariffsSecondButtonHref());
  }

  @Step
  public String getHeaderText() {
    return getPageObject().getHeaderText();
  }
}
