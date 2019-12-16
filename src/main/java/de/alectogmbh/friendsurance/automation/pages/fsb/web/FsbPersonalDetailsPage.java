package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbPersonalDetailsPage.PERSONAL_DETAILS_PAGE_URL;

@At("#HOST" + PERSONAL_DETAILS_PAGE_URL)
@DefaultUrl(PERSONAL_DETAILS_PAGE_URL)
public class FsbPersonalDetailsPage extends AbstractPageObject {

    final static String PERSONAL_DETAILS_PAGE_URL = "/onboarding/start";

    @FindBy(className = "onboarding-headline__text")
    private WebElementFacade personalDetailsHeadlineText;

    @FindBy(id = "header__login")
    private WebElementFacade loginButton;

    @FindBy(css = "#personal-info__form__label--title-ms")
    private WebElementFacade genderRadioButton;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElementFacade firstNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElementFacade lastNameField;

    @FindBy(id = "personal-info-birth-date")
    private  WebElementFacade birthField;

    @FindBy(xpath = "//input[@name='street']")
    private WebElementFacade streetField;

    @FindBy(xpath = "//input[@name='houseNumber']")
    private  WebElementFacade houseNumberField;

    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElementFacade postalCodeField;

    @FindBy(xpath = "//input[@name='city']")
    private WebElementFacade cityField;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElementFacade phoneNumberField;

    @FindBy(id = "personal-info-submit__button")
    private WebElementFacade submitButton;

    @FindBy(id = "personal-info-back__button")
    private WebElementFacade backButton;

    public String getPersonalDetailsHeadlineText() {
        return personalDetailsHeadlineText.getText();
    }

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
