package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.client.FsbPersonalDetailsPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class FsbPersonalDetailsSteps extends AbstractScenarioSteps<FsbPersonalDetailsPage> {

    private static final String EXPECTED_PERSONAL_DETAILS_HEADLINE = "Kurz vor Schluss wird’s noch persönlich";

    private FsbPersonalDetailsPage fsbPersonalDetailsPage;

    public FsbPersonalDetailsPage getPageObject() {
        return fsbPersonalDetailsPage;
    }

    @Step
    public String get_personal_details_headline_text() {
        return getPageObject().getPersonalDetailsHeadlineText();
    }

    @Step
    public void select_gender(Boolean isMale) {
        getPageObject().selectGender(isMale);
    }

    @Step
    public void enter_birth_date(String birthDay) {
        getPageObject().enterBirthDate(birthDay);
    }

    @Step
    public void enter_street_name(String streetName) {
        getPageObject().enterStreetName(streetName);
    }

    @Step
    public void enter_house_number(String houseNumber) {
        getPageObject().enterHouseNumber(houseNumber);
    }

    @Step
    public void enter_postal_code(String postalCode) {
        getPageObject().enterPostalCode(postalCode);
    }

    @Step
    public void enter_city(String place) {
        getPageObject().enterCity(place);
    }

    @Step
    public void enter_phone_number(String phoneNum) {
        getPageObject().enterPhoneNumber(phoneNum);
    }

    @Step
    public void click_on_personal_details_submit_button() {
        getPageObject().clickOnPersonalDetailsSubmitButton();
    }

    @Step
    public void verify_personal_details_page_is_loaded_and_headline_is_present() {
        assertEquals(EXPECTED_PERSONAL_DETAILS_HEADLINE, get_personal_details_headline_text());
    }

    @StepGroup
    public void verify_first_step_and_set_onboarding_personal_details(Boolean isMale, String birthDay, String streetName, String houseNumber,
                                                                      String postalCode, String place, String phoneNum) {
        verify_personal_details_page_is_loaded_and_headline_is_present();
        select_gender(isMale);
        enter_birth_date(birthDay);
        enter_street_name(streetName);
        enter_house_number(houseNumber);
        enter_postal_code(postalCode);
        enter_city(place);
        enter_phone_number(phoneNum);
        click_on_personal_details_submit_button();
    }
}
