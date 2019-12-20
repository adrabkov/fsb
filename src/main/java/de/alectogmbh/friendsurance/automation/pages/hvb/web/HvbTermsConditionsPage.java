package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbTermsConditionsPage.BANK_CONDITIONS_PAGE_URL;
import static java.util.concurrent.TimeUnit.SECONDS;

@At("#HOST" + BANK_CONDITIONS_PAGE_URL)
@DefaultUrl(BANK_CONDITIONS_PAGE_URL)
public class HvbTermsConditionsPage extends AbstractPageObject {

  final static String BANK_CONDITIONS_PAGE_URL = "/onboarding/conditions/";

  private static final int MODAL_DISAPPEAR_TIMEOUT = 10;

  @FindBy(className = "onboarding-headline__headline")
  private WebElementFacade bankConditionsHeadlineText;

  @FindBy(id = "bank-conditions__checkbox--1__span")
  private WebElementFacade termsOfUseCheckbox;

  @FindBy(id = "bank-conditions__checkbox--2__span")
  private WebElementFacade consentDeclarationCheckbox;

  @FindBy(id = "bank-conditions-gonext__button")
  private WebElementFacade bankConditionsNextButton;

  @FindBy(className = "banking-modal-content")
  private WebElementFacade finApiModalWindowPrompt;

  @FindBy(id = "bank-conditions-modal-ok__button")
  private WebElementFacade finApiModalWindowPromptButton;

  public String getBankConditionsHeadlineText() {
    bankConditionsHeadlineText.waitUntilVisible();
    return bankConditionsHeadlineText.getText();
  }

  public void checkTermsOfUseCheckbox() {
    if (!termsOfUseCheckbox.isSelected()) {
      termsOfUseCheckbox.waitUntilClickable();
      termsOfUseCheckbox.click();
    }
  }

  public void checkConsentDeclarationCheckbox() {
    if (!consentDeclarationCheckbox.isSelected()) {
      consentDeclarationCheckbox.waitUntilClickable();
      consentDeclarationCheckbox.click();
    }
  }

  public void clickBankConditionsGoNextButton() {
    bankConditionsNextButton.waitUntilClickable();
    bankConditionsNextButton.click();
  }

  public void switchToFinApiModalWindowPrompt() {
    finApiModalWindowPrompt.waitUntilVisible();
    getDriver().switchTo().activeElement();
  }

  public void clickOnFinApiModalWindowPromptConfirmButton() {
    scroll_element_into_view(finApiModalWindowPromptButton);
    finApiModalWindowPromptButton.waitUntilClickable();
    finApiModalWindowPromptButton.click();
    finApiModalWindowPrompt.withTimeoutOf(MODAL_DISAPPEAR_TIMEOUT, SECONDS).waitUntilNotVisible();
  }

}

