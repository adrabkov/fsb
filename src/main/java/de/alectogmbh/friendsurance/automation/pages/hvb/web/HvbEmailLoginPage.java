package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbEmailLoginPage.LOGIN_PAGE_URL;
import static java.util.concurrent.TimeUnit.SECONDS;

@At("#HOST" + LOGIN_PAGE_URL)
@DefaultUrl(LOGIN_PAGE_URL)
public class HvbEmailLoginPage extends AbstractPageObject {

    final static String LOGIN_PAGE_URL = "/auth/";

    @FindBy(className = "user-login-container")
    private WebElementFacade loginContainer;

    @FindBy(className = "user-login-container")
    private WebElementFacade loginContent;

    @FindBy(id = "user-login__headline")
    private WebElementFacade loginPageHeadlineText;

    @FindBy(id = "user-login-email__input")
    private WebElementFacade userLoginEmailInputField;

    @FindBy(id = "user-login-password__input")
    private WebElementFacade userLoginPasswordInputField;

    @FindBy(id = "user-login-email-forgot-password__link")
    private WebElementFacade forgotPasswordLink;

    @FindBy(id = "user-login__button")
    private WebElementFacade userLoginButton;

    private static final int SPINNER_TIMEOUT = 5;

    public void waitForLoginContentToBePresent() {
        loginContainer.withTimeoutOf(SPINNER_TIMEOUT, SECONDS).waitUntilVisible();
    }

    public String getLoginPageHeadlineText() {
        loginContainer.waitUntilVisible();
        loginContent.waitUntilVisible();
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
        userLoginEmailInputField.type(email);
    }

    public void enterUserLoginPassword(String password) {
        userLoginPasswordInputField.waitUntilVisible();
        userLoginPasswordInputField.clear();
        userLoginPasswordInputField.type(password);
    }

    public void clickOnUserLoginButton() {
        userLoginButton.waitUntilClickable();
        userLoginButton.click();
    }

}
