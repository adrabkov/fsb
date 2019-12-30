package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbForgetPasswordPage.FORGETPASSWORD_PAGE_URL;

@At("#HOST" + FORGETPASSWORD_PAGE_URL)
@DefaultUrl(FORGETPASSWORD_PAGE_URL)
public class HvbForgetPasswordPage extends AbstractPageObject {

  public final static String FORGETPASSWORD_PAGE_URL = "/forgetpassword/";

  @FindBy(id = "user-forget-password-email__input")
  private WebElementFacade forgetPasswordEmailField;

  @FindBy(id = "user-forget-password_next")
  private WebElementFacade forgetPasswordButton;

  @FindBy(id = "toast-message-success__text")
  private WebElementFacade successToastBanner;

  public void enterUserEmail(String email) {
    forgetPasswordEmailField.waitUntilVisible();
    forgetPasswordEmailField.clear();
    forgetPasswordEmailField.type(email);
  }

  public void clickOnSendButtonToTriggerEmail() {
    forgetPasswordButton.waitUntilClickable();
    forgetPasswordButton.click();
  }

  public String getToastBannerText() {
    successToastBanner.waitUntilVisible();
    return successToastBanner.getText();
  }

}
