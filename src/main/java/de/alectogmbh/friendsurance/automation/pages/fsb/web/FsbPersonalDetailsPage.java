package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FsbPersonalDetailsPage extends BaseForm {

    @FindBy(id = "header__login")
    private WebElement loginButton;

    @FindBy(css = "#personal-info__form__label--title-ms")
    private WebElement genderRadioButton;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameField;

    @FindBy(id = "personal-info-birth-date")
    private  WebElement birthField;

    @FindBy(xpath = "//input[@name='street']")
    private WebElement streetField;

    @FindBy(xpath = "//input[@name='houseNumber']")
    private  WebElement houseNumberField;

    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement postalCodeField;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phoneNumberField;

    @FindBy(id = "personal-info-submit__button")
    private WebElement submitButton;

    @FindBy(id = "personal-info-back__button")
    private WebElement backButton;

    public void clickLoginButton(){
        loginButton.click();
    }

    public void selectGender(){
        genderRadioButton.click();
    }

    public void fillFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public  void fillLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void setBirthField(String birthDate){
        birthField.sendKeys(birthDate);
    }

    public void fillStreet(String streetName){
        streetField.sendKeys(streetName);
    }

    public void fillHouseNumber(String houseNumber){
        houseNumberField.sendKeys(houseNumber);
    }

    public void fillPostalCode(String postalCode){
        postalCodeField.sendKeys(postalCode);
    }

    public void fillCity(String city){
        cityField.sendKeys(city);
    }

    public void fillPhoneNumber(String phoneNumber){
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void clickBackButton(){
        backButton.click();
    }
}
