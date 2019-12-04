package de.alectogmbh.friendsurance.automation.pages.client;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import form.BaseForm;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;

import static de.alectogmbh.friendsurance.automation.pages.client.FsbPersonalDetailsPage.PERSONAL_DETAILS_PAGE_URL;
import static java.util.concurrent.TimeUnit.SECONDS;

@At("#HOST" + PERSONAL_DETAILS_PAGE_URL)
@DefaultUrl(PERSONAL_DETAILS_PAGE_URL)
public class FsbPersonalDetailsPage extends AbstractPageObject {

    final static String PERSONAL_DETAILS_PAGE_URL = "/onboarding/personal-details/info";

    @net.serenitybdd.core.annotations.findby.FindBy(className = "onboarding-headline__headline")
    private WebElementFacade personalDetailsHeadlineText;

    @FindBy(id = "header__login")
    private WebElementFacade loginButton;

    @FindBy(css = "#personal-info__form__label--title-ms")
    private WebElementFacade genderMaleCheckbox;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElementFacade firstNameText;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElementFacade lastNameText;

    @FindBy(id = "personal-info-birth-date")
    private WebElementFacade birthDateInput;

    @FindBy(xpath = "//input[@name='street']")
    private WebElementFacade streetNameInput;

    @FindBy(xpath = "//input[@name='houseNumber']")
    private WebElementFacade houseNumberInput;

    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElementFacade postCodeInput;

    @FindBy(xpath = "//input[@name='city']")
    private WebElementFacade cityInput;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElementFacade phoneNumberInput;

    @FindBy(id = "personal-info-submit__button")
    private WebElementFacade registerButton;

    @FindBy(id = "personal-info-back__button")
    private WebElementFacade backButton;

    @FindBy(id = "personal-details-spinner")
    WebElementFacade loading;

    @FindBy(className = "banking-wrapper")
    private WebElementFacade savePinModalWindow;

    @FindBy(id = "banking-modal-ok__button")
    private WebElementFacade savePinWindowConfirmButton;

    @FindBy(className = "personal-details__img")
    private WebElementFacade modalAnimation;

    private static final int SPINNER_TIMEOUT = 120;


    public String getPersonalDetailsHeadlineText() {
        loading.waitUntilNotVisible();
        modalAnimation.waitUntilVisible();
        modalAnimation.withTimeoutOf(SPINNER_TIMEOUT, SECONDS).waitUntilNotVisible();
        personalDetailsHeadlineText.waitUntilVisible();
        return personalDetailsHeadlineText.getText();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void selectGender(Boolean isMale) {
        if (isMale) {
//            scroll_element_into_view(genderMaleCheckbox);
            genderMaleCheckbox.waitUntilClickable();
            genderMaleCheckbox.click();
        } else {
//            scroll_element_into_view(genderMaleCheckbox);
            genderMaleCheckbox.waitUntilClickable();
            genderMaleCheckbox.click();
        }
        genderMaleCheckbox.click();
    }

    public void fillFirstName(String firstName) {
        firstNameText.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameText.sendKeys(lastName);
    }

    public void enterBirthDate(String birthDate) {
        birthDateInput.waitUntilVisible();
        birthDateInput.clear();
        birthDateInput.type(birthDate);
    }

    public void enterStreetName(String streetName) {
        streetNameInput.waitUntilVisible();
        streetNameInput.clear();
        streetNameInput.type(streetName);
    }

    public void enterHouseNumber(String houseNumber) {
        houseNumberInput.waitUntilVisible();
        houseNumberInput.clear();
        houseNumberInput.type(houseNumber);
    }

    public void enterPostalCode(String postalCode) {
        postCodeInput.waitUntilVisible();
        postCodeInput.clear();
        postCodeInput.type(postalCode);
    }

    public void enterCity(String place) {
        cityInput.waitUntilVisible();
        cityInput.clear();
        cityInput.type(place);
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberInput.waitUntilVisible();
        phoneNumberInput.clear();
        phoneNumberInput.type(phoneNumber);
    }

    public void clickOnPersonalDetailsSubmitButton() {
        registerButton.waitUntilClickable();
        registerButton.click();
    }

    public void clickOnPersonalDetailsBackButton() {
        backButton.waitUntilClickable();
        backButton.click();
    }
}
