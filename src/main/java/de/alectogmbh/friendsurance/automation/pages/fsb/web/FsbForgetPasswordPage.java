package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbForgetPasswordPage.FORGETPASSWORD_PAGE_URL;

@At("#HOST" + FORGETPASSWORD_PAGE_URL)
@DefaultUrl(FORGETPASSWORD_PAGE_URL)
public class FsbForgetPasswordPage extends AbstractPageObject {

    final static String FORGETPASSWORD_PAGE_URL = "/forgetpassword/";

    @FindBy(id = "user-forget-password-email__input")
    private WebElementFacade forgetPasswordEmailField;

    @FindBy(id = "user-forget-password_next")
    private WebElementFacade forgetPasswordButton;

    @FindBy(id = "toast-message-success__text")
    private WebElementFacade successToastBanner;

    public void enterUserEmail(String email) {
        forgetPasswordEmailField.waitUntilVisible();
        forgetPasswordEmailField.clear();
        forgetPasswordEmailField.sendKeys(email);
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
