package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbSignUpPage.SIGN_UP_PAGE_URL;

@At("#HOST" + SIGN_UP_PAGE_URL)
@DefaultUrl(SIGN_UP_PAGE_URL)
public class FsbSignUpPage extends BaseForm {

    final static String SIGN_UP_PAGE_URL = "/onboarding/signup/";

    @FindBy(className = "onboarding-headline__text")
    private WebElement signUpPageHeadlineText;

    @FindBy(id = "personal-signup-email")
    private WebElement userEmailInputField;

    @FindBy(id = "personal-signup-password")
    private WebElement userPasswordInputField;

    @FindBy(xpath = "//div/button[@type='button']")
    private WebElement showPasswordButton;

    @FindBy(id = "personal-signup-conditions__checkbox--1__span")
    private WebElement conditions1;

    @FindBy(id = "personal-signup-conditions__checkbox--2__span")
    private WebElement conditions2;

    @FindBy(id = "personal-signup-conditions__checkbox--3__span")
    private WebElement conditions3;

    @FindBy(id = "personal-signup-submit")
    private WebElement signUpButton;

    @FindBy(xpath = "//p[@class='sc-eNQAEJ jTNZui']")
    private WebElement validationMessageForEmailField;

    @FindBy(xpath = "//div[@class='pass__validation-error-message']/p")
    private WebElement validationMessageForEmptyPasswordField;

    @FindBy(xpath = "//div[@class='pass__validation-error-message']/p")
    private WebElement validationMessageForIncorrectPasswordField;

    @FindBy(xpath = "//p[@class='sc-eNQAEJ jTNZui']")
    private WebElement validationMessageForAlreadyExistedEmail;

    @FindBy(id = "personal-signup-conditions-error__text")
    private WebElement validationMessageForCondition1;

    @FindAll(@FindBy(how = How.CSS, using = "#personal-signup-conditions-error__text"))
    List<WebElement> validationMessagesList;

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

    public WebElement getShowPasswordButton() {
        return showPasswordButton;
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

    public WebElement getUserEmailInputField() {
        return userEmailInputField;
    }

    public String textMessageForAlreadyExistedEmail() {
        return validationMessageForAlreadyExistedEmail.getText();
    }

    public List<String> actualConditionTextForCheckBox() {
        List<String> texts = new ArrayList<>();
        for (WebElement messagesList : validationMessagesList) {
            texts.add(messagesList.getText());
        }
        return texts;
    }
}
