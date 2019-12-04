package de.alectogmbh.friendsurance.automation.steps.web.insurance.category;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.AbstractInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public abstract class AbstractInsuranceCategoryPageSteps<T extends AbstractInsuranceCategoryPage>
    extends
        AbstractScenarioSteps<T> {

  public AbstractInsuranceCategoryPageSteps() {
  }

  public AbstractInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void find_insurance() {
    getPageObject().clickFindInsuranceButton();
  }

  @Step
  public void is_main_cta_correct() {
    ValidationUtils.checkLinkIsCorrect("#", getPageObject().getMainCtaHref());
  }

  @Step
  public void click_main_cta() {
    getPageObject().clickMainCta();
  }

  @Step
  public void to_tariffs_first_button_is_present() {
    ValidationUtils
        .checkElementIsDisplayed("to tariffs first button",
            getPageObject().isToTariffsFirstButtonPresent());
  }

  @Step
  public void isToTariffsFirstButtonTextCorrect() {
    ValidationUtils
        .checkTextIsCorrect("Tarife vergleichen", getPageObject().getToTariffsFirstButtonText());
  }

  @Step
  public void to_tariffs_first_button_link_is_correct() {
    ValidationUtils
        .checkLinkIsCorrect("#tarif-hook", getPageObject().getToTariffsFirstButtonHref());
  }

  @Step
  public void to_tariffs_second_button_is_present() {
    ValidationUtils
        .checkElementIsDisplayed("to tariffs second button",
            getPageObject().isToTariffsSecondButtonPresent());
  }

  @Step
  public void isToTariffsSecondButtonTextCorrect() {
    ValidationUtils
        .checkTextIsCorrect("Tarife vergleichen", getPageObject().getToTariffsSecondButtonText());
  }

  @Step
  public void to_tariffs_second_button_link_is_correct() {
    ValidationUtils
        .checkLinkIsCorrect("#tarif-hook", getPageObject().getToTariffsSecondButtonHref());
  }

  @Step
  public String getHeadLineText() {
    return getPageObject().getHeadlineText();
  }
}
