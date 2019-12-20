package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbInsuranceInformationPage.INSURANCE_INFORMATION_PAGE_URL;

@At("#HOST" + INSURANCE_INFORMATION_PAGE_URL)
@DefaultUrl(INSURANCE_INFORMATION_PAGE_URL)
public class HvbInsuranceInformationPage extends AbstractPageObject {

  final static String INSURANCE_INFORMATION_PAGE_URL = "/onboarding/insurance-information/";

  @FindBy(className = "insurance-information")
  private WebElementFacade insuranceInformationContent;

  @FindBy(className = "onboarding-headline__headline")
  private WebElementFacade insuranceInformationHeadlineText;

  @FindBy(id = "insurance-information-gonext__button")
  private WebElementFacade insuranceInformationGoNextButton;

  public String getInsuranceInformationHeadlineText() {
    insuranceInformationContent.waitUntilPresent();
    insuranceInformationHeadlineText.waitUntilVisible();
    return insuranceInformationHeadlineText.getText();
  }

  public void clickInsuranceInformationGoNextButton() {
    insuranceInformationGoNextButton.waitUntilClickable();
    insuranceInformationGoNextButton.click();
  }

}