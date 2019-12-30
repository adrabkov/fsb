package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbProfilePasswordChangePage.CHANGE_PASSWORD_PAGE_URL;

@At("#HOST" + CHANGE_PASSWORD_PAGE_URL)
@DefaultUrl(CHANGE_PASSWORD_PAGE_URL)
public class HvbProfilePasswordChangePage extends AbstractPageObject {

    final static String CHANGE_PASSWORD_PAGE_URL = "/home/profile/changepassword/";

    @FindBy(className = "profile-change-password__headline_title")
    private WebElementFacade changePasswordPageHeadline;

    @FindBy(id = "profile-change-password_password--old")
    private WebElementFacade oldPasswordInput;

    @FindBy(id = "profile-change-password_password--new")
    private WebElementFacade newPasswordInput;

    @FindBy(className = "profile-change-password__cta")
    private WebElementFacade savePasswordButton;

    @FindBy(className = "toast-message")
    private WebElementFacade successToastBanner;

    public String getPasswordChangePageHeadline() {
        changePasswordPageHeadline.waitUntilVisible();
        return changePasswordPageHeadline.getText();
    }

    public void enterOldPassword(String password) {
        oldPasswordInput.waitUntilVisible();
        oldPasswordInput.clear();
        oldPasswordInput.type(password);
    }

    public void enterNewPassword(String newPassword) {
        newPasswordInput.waitUntilVisible();
        newPasswordInput.clear();
        newPasswordInput.type(newPassword);
    }

    public void clickOnSavePasswordButton() {
        savePasswordButton.waitUntilClickable();
        savePasswordButton.click();
    }

    public String getToastBannerText() {
        successToastBanner.waitUntilVisible();
        return successToastBanner.getText();
    }

}
