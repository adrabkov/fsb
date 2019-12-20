package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbPersonalDetailsPage.PERSONAL_DETAILS_PAGE_URL;

@At("#HOST" + PERSONAL_DETAILS_PAGE_URL)
@DefaultUrl(PERSONAL_DETAILS_PAGE_URL)
public class HvbPersonalDetailsPage extends AbstractPageObject {

    final static String PERSONAL_DETAILS_PAGE_URL = "/onboarding/personal-details/info";

    @FindBy(id = "undefined_headline")
    private WebElementFacade personalDetailsHeadlineText;

    @FindBy(id = "personal-details-name")
    private WebElementFacade nameText;

    @FindBy(id = "personal-details__form__label--title-mr")
    private WebElementFacade genderMaleCheckbox;

    @FindBy(id = "personal-details__form__label--title-ms")
    private WebElementFacade genderFemaleCheckbox;

    @FindBy(id = "personal-details-birth-date")
    private WebElementFacade birthDateInput;

    @FindBy(id = "personal-details-street")
    private WebElementFacade streetNameInput;

    @FindBy(id = "personal-details-house-number")
    private WebElementFacade houseNumberInput;

    @FindBy(id = "personal-details-postal-code")
    private WebElementFacade postCodeInput;

    @FindBy(id = "personal-details-city")
    private WebElementFacade cityInput;

    @FindBy(id = "personal-details-phone-number")
    private WebElementFacade phoneNumberInput;

    @FindBy(id = "personal-details-submit__button")
    private WebElementFacade registerButton;

    @FindBy(id = "personal-details-spinner")
    WebElementFacade loading;

    private static final int SPINNER_TIMEOUT = 120;

    public String getPersonalDetailsHeadlineText() {
        loading.waitUntilNotVisible();
//    modalAnimation.waitUntilVisible();
//    modalAnimation.withTimeoutOf(SPINNER_TIMEOUT, SECONDS).waitUntilNotVisible();
        personalDetailsHeadlineText.waitUntilVisible();
        return personalDetailsHeadlineText.getText();
    }

    public void selectGender(Boolean isMale) {
        if (isMale) {
            scroll_element_into_view(genderMaleCheckbox);
            genderMaleCheckbox.waitUntilClickable();
            genderMaleCheckbox.click();
        } else {
            scroll_element_into_view(genderFemaleCheckbox);
            genderMaleCheckbox.waitUntilClickable();
            genderFemaleCheckbox.click();
        }
    }

    public String getFirstNameText() {
        return nameText.getText();
    }

    public void enterBirthDate(String birthday) {
        birthDateInput.waitUntilVisible();
        birthDateInput.clear();
        birthDateInput.type(birthday);
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

    public void enterPhoneNumber(String phoneNum) {
        phoneNumberInput.waitUntilVisible();
        phoneNumberInput.clear();
        phoneNumberInput.type(phoneNum);
    }

    public void clickOnPersonalDetailsSubmitButton() {
        registerButton.waitUntilClickable();
        registerButton.click();
    }

}