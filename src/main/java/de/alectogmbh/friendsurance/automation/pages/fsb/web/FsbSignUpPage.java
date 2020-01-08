package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbSignUpPage.SIGN_UP_PAGE_URL;

@At("#HOST" + SIGN_UP_PAGE_URL)
@DefaultUrl(SIGN_UP_PAGE_URL)
public class FsbSignUpPage extends AbstractPageObject {

    final static String SIGN_UP_PAGE_URL = "/onboarding/signup/";

    @FindBy(className = "onboarding-headline__text")
    private WebElementFacade signUpPageHeadlineText;

    @FindBy(id = "personal-signup-email")
    private WebElementFacade userEmailInputField;

    @FindBy(id = "personal-signup-password")
    private WebElementFacade userPasswordInputField;

    @FindBy(xpath = "//div/button[@type='button']")
    private WebElementFacade showPasswordButton;

    @FindBy(id = "personal-signup-conditions__checkbox--1__span")
    private WebElementFacade conditions1;

    @FindBy(id = "personal-signup-conditions__checkbox--2__span")
    private WebElementFacade conditions2;

    @FindBy(id = "personal-signup-conditions__checkbox--3__span")
    private WebElementFacade conditions3;

    @FindBy(id = "personal-signup-submit")
    private WebElementFacade signUpButton;

    @FindBy(xpath = "//p[@class='sc-eNQAEJ jTNZui']")
    private WebElementFacade validationMessageForEmailField;

    @FindBy(xpath = "//div[@class='pass__validation-error-message']/p")
    private WebElementFacade validationMessageForEmptyPasswordField;

    @FindBy(xpath = "//div[@class='pass__validation-error-message']/p")
    private WebElementFacade validationMessageForIncorrectPasswordField;

    @FindBy(xpath = "//p[@class='sc-eNQAEJ jTNZui']")
    private WebElementFacade validationMessageForAlreadyExistedEmail;

    @FindBy(id = "personal-signup-conditions-error__text")
    private WebElementFacade validationMessageForCondition1;


    public String getSignUpPageHeadlineText() {
        return signUpPageHeadlineText.getText();
    }

    public void enterUserEmail(String email) {
        userEmailInputField.sendKeys(email);
    }

    public void enterUserPassword(String password) {
        userPasswordInputField.sendKeys(password);
    }

    public void clickShowPasswordButton() {
        showPasswordButton.click();
    }

    public void clickCondition1() {
        conditions1.click();
    }

    public void clickCondition2() {
        conditions2.click();
    }

    public void clickCondition3() {
        conditions3.click();
    }

    public void clickOnSignUpButton() {
        signUpButton.click();
    }

    public String textForEmailValidation() {
        return validationMessageForEmailField.getText();
    }

    public String textForEmptyPasswordValidation() {
        return validationMessageForEmptyPasswordField.getText();
    }

    public String textForIncorrectPasswordValidation() {
        return validationMessageForIncorrectPasswordField.getText();
    }

    public WebElementFacade getUserEmailInputField() {
        return userEmailInputField;
    }

}
