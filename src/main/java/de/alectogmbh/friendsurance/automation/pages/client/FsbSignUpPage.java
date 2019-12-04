package de.alectogmbh.friendsurance.automation.pages.client;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import form.BaseForm;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

@At("#HOST" + FsbSignUpPage.SIGN_UP_PAGE_URL)
@DefaultUrl(FsbSignUpPage.SIGN_UP_PAGE_URL)
public class FsbSignUpPage extends AbstractPageObject {

    public final static String SIGN_UP_PAGE_URL = "/onboarding/personal-details/signup/";

    @FindBy(className = "onboarding-headline__headline")
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
    private WebElementFacade submit;

    @FindBy(xpath = "//p[@class='sc-eNQAEJ jTNZui']")
    private WebElementFacade validationMessageForEmailField;

    @FindBy(xpath = "//div[@class='pass__validation-error-message']/p")
    private WebElementFacade validationMessageForPasswordField;

    @FindBy(xpath = "//p[@class='sc-eNQAEJ jTNZui']")
    private WebElementFacade validationMessageForAlreadyExistedEmail;

    @FindBy(id = "personal-signup-conditions-error__text")
    private WebElementFacade validationMessageForCondition1;

    @FindAll(@FindBy(how = How.CSS, using = "#personal-signup-conditions-error__text"))
    List<WebElementFacade> validationMessagesList;

    public String getSignUpPageHeadlineText() {
        signUpPageHeadlineText.waitUntilVisible();
        return signUpPageHeadlineText.getText();
    }

    public void enterUserEmail(String email) {
        userEmailInputField.waitUntilVisible();
        userEmailInputField.clear();
        userEmailInputField.type(email);
    }

    public void enterUserPassword(String password) {
        userPasswordInputField.waitUntilVisible();
        userPasswordInputField.clear();
        userPasswordInputField.type(password);
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

    public void clickSubmitButton() {
        submit.click();
    }

    public String textForEmailValidation() {
        return validationMessageForEmailField.getText();
    }

    public String textForPasswordValidation() {
        return validationMessageForPasswordField.getText();
    }

    public WebElement getUserEmailInputField() {
        return userEmailInputField;
    }

    public String textMessageForAlreadyExistedEmail() {
        return validationMessageForAlreadyExistedEmail.getText();
    }

    public List<String> actualConditionTextForCheckBox() {
        List<String> texts = new ArrayList<>();
        for (WebElementFacade messagesList : validationMessagesList) {
            texts.add(messagesList.getText());
        }
        return texts;
    }

}
