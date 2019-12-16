package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbForgetPasswordPage.FORGETPASSWORD_PAGE_URL;

@At("#HOST" + FORGETPASSWORD_PAGE_URL)
@DefaultUrl(FORGETPASSWORD_PAGE_URL)
public class FsbForgetPasswordPage extends BaseForm {

    final static String FORGETPASSWORD_PAGE_URL = "/forgetpassword/";

    @FindBy(id = "user-forget-password-email__input")
    private WebElement forgetPasswordEmailField;

    @FindBy(id = "user-forget-password_next")
    private WebElement forgetPasswordButton;

    @FindBy(id = "toast-message-success__text")
    private WebElement successToastBanner;

    public void enterUserEmail(String email) {
//        forgetPasswordEmailField.waitUntilVisible();
        forgetPasswordEmailField.clear();
        forgetPasswordEmailField.sendKeys(email);
    }

    public void clickOnSendButtonToTriggerEmail() {
//        forgetPasswordButton.waitUntilClickable();
        forgetPasswordButton.click();
    }

    public String getToastBannerText() {
//        successToastBanner.waitUntilVisible();
        return successToastBanner.getText();
    }

}
