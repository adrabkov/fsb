package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbPersonalDetailsPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class FsbPersonalDetailsSteps extends AbstractScenarioSteps<FsbPersonalDetailsPage> {

    private static final String EXPECTED_PERSONAL_DETAILS_HEADLINE = "Bitte geben Sie Ihre persönlichen Daten ein.";

    private FsbPersonalDetailsPage fsbPersonalDetailsPage;

    public FsbPersonalDetailsPage getPageObject() {
        return fsbPersonalDetailsPage;
    }

//    @Step
//    public void open_onboarding_first_step() {
//        getPageObject().open();
//    }

    @Step
    public void click_login_button(){
        getPageObject().clickLoginButton();
    }

    @Step
    public String get_personal_details_headline_text() {
        return getPageObject().getPersonalDetailsHeadlineText();
    }

    @Step
    public void selectGender() {
        getPageObject().selectGender();
    }

    @Step
    public void enterFirstName(String firstName) {
        getPageObject().fillFirstName(firstName);
    }

    @Step
    public void enterLastName(String lastName) {
        getPageObject().fillLastName(lastName);
    }

    @Step
    public void enterStreetName(String street) {
        getPageObject().fillStreet(street);
    }

    @Step
    public void enterBirthDate(String birth) {
        getPageObject().setBirthField(birth);
    }

    @Step
    public void enterHouseNumber(String house) {
        getPageObject().fillHouseNumber(house);
    }

    @Step
    public void enterPostalCode(String postalCode) {
        getPageObject().fillPostalCode(postalCode);
    }

    @Step
    public void enterCity(String city) {
        getPageObject().fillCity(city);
    }

    @Step
    public void enterPhoneNumber(String phoneNum) {
        getPageObject().fillPhoneNumber(phoneNum);
    }

    @Step
    public void click_on_personal_details_submit_button() {
        getPageObject().clickSubmitButton();
    }

    @Step
    public void verify_personal_details_page_is_loaded_and_headline_is_present() {
        assertEquals(EXPECTED_PERSONAL_DETAILS_HEADLINE, get_personal_details_headline_text());
    }

    @StepGroup
    public void verify_fifth_step_and_set_onboarding_personal_details(String firstName, String lastName, String birth, String street, String house, String postalCode, String city) {
//        open_onboarding_first_step();
        verify_personal_details_page_is_loaded_and_headline_is_present();
        selectGender();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterBirthDate(birth);
        enterStreetName(street);
        enterHouseNumber(house);
        enterPostalCode(postalCode);
        enterCity(city);
        click_on_personal_details_submit_button();
    }
}
