package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbEmailLoginPage.LOGIN_PAGE_URL;

@At("#HOST" + LOGIN_PAGE_URL)
@DefaultUrl(LOGIN_PAGE_URL)
public class FsbEmailLoginPage extends AbstractPageObject {

    final static String LOGIN_PAGE_URL = "/user/login/";

    @FindBy(id = "user-login__headline")
    private WebElementFacade loginPageHeadlineText;

    @FindBy(id = "user-login-email__input")
    private WebElementFacade userLoginEmailInputField;

    @FindBy(id = "user-login-password__input")
    private WebElementFacade userLoginPasswordInputField;

    @FindBy(id = "user-login-email-forgot-password__link")
    private WebElementFacade forgotPasswordLink;

    @FindBy(id = "user-login__back")
    private WebElementFacade backButton;

    @FindBy(id = "user-login__button")
    private WebElementFacade userLoginButton;

    public String getLoginPageHeadlineText() {
        loginPageHeadlineText.waitUntilVisible();
        return loginPageHeadlineText.getText();
    }

    public void clickOnForgetPasswordLink() {
        forgotPasswordLink.waitUntilClickable();
        forgotPasswordLink.click();
    }

    public void enterUserLoginEmail(String email) {
        userLoginEmailInputField.waitUntilVisible();
        userLoginEmailInputField.clear();
        userLoginEmailInputField.sendKeys(email);
    }

    public void enterUserLoginPassword(String password) {
        userLoginPasswordInputField.waitUntilVisible();
        userLoginPasswordInputField.clear();
        userLoginPasswordInputField.sendKeys(password);
    }

    public void clickOnUserLoginButton() {
        userLoginButton.waitUntilClickable();
        userLoginButton.click();
    }
}
