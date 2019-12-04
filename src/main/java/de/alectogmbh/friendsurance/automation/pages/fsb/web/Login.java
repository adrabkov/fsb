package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login extends BaseForm {

    @FindBy(xpath = "//input[@name='emailLogin']")
    private WebElement emailfield;

    @FindBy(id = "user-login-password__input")
    private  WebElement passwordField;

    @FindBy(id = "user-login-email-forgot-password__link")
    private WebElement forgotPasswordLink;

    @FindBy(id = "user-login__back")
    private WebElement backButton;

    @FindBy(id = "user-login__button")
    private WebElement loginButton;

    public void fillEmailField(String email){
        emailfield.click();
        emailfield.sendKeys(email);
    }

    public void fillPasswordField(String pass){
        passwordField.sendKeys(pass);
    }

    public void clickForgotPasswordLink(){
        forgotPasswordLink.click();
    }

    public  void clickLoginButton(){
        loginButton.click();
    }


}
