package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbLandingPage.LANDING_PAGE;

@At("#HOST" + LANDING_PAGE)
@DefaultUrl(LANDING_PAGE)
public class HvbLandingPage extends AbstractPageObject {

  public static final String LANDING_PAGE = "/";

  @FindBy(id = "header_login")
  private WebElementFacade headerLoginLink;

  @FindBy(id = "key-visuals__button-secondary")
  private WebElementFacade keyVisualLoginButton;

  public void clickOnHeaderLoginLink() {
    headerLoginLink.waitUntilVisible();
    scrollToElement(headerLoginLink);
    headerLoginLink.waitUntilClickable();
    headerLoginLink.click();
  }

  public void clickOnKeyVisualLoginButton() {
    keyVisualLoginButton.waitUntilVisible();
    scrollToElement(keyVisualLoginButton);
    keyVisualLoginButton.waitUntilClickable();
    keyVisualLoginButton.click();
  }

}
