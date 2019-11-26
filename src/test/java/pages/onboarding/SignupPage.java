package pages.onboarding;

import form.BaseForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BaseForm {

    @FindBy(id = "personal-signup-email")
    private WebElement emailField;

    @FindBy(id = "personal-signup-password")
    private WebElement passwordField;

    @FindBy(xpath = "//div/button[@type='button']")
    private WebElement showPasswordButton;

    @FindBy(id = "personal-signup-conditions__checkbox--1__span")
    private WebElement conditions1;

    @FindBy(id = "personal-signup-conditions__checkbox--2__span")
    private WebElement conditions2;

    @FindBy(id = "personal-signup-conditions__checkbox--3__span")
    private WebElement conditions3;

    @FindBy(id = "personal-signup-submit")
    private WebElement submit;

    @FindBy(xpath = "//p[@class='sc-eNQAEJ jTNZui']")
    private WebElement validationMessageForEmailField;

    @FindBy(xpath = "//div[@class='pass__validation-error-message']/p")
    private WebElement validationMessageForPasswordField;

    public void fillEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void fillPasswordField(String password) {
        passwordField.sendKeys(password);
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

    public void clickSubmitButton() {
        submit.click();
    }

    public String textForEmailValidation() {
        return validationMessageForEmailField.getText();
    }

    public String textForPasswordValidation() {
        return validationMessageForPasswordField.getText();
    }

    public WebElement getEmailField() {
        return emailField;
    }
}
