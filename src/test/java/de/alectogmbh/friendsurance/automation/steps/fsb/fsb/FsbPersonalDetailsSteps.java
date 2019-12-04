package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbPersonalDetailsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class FsbPersonalDetailsSteps {

    private FsbPersonalDetailsPage getPageObject;


    public static void selectGender(){
        new FsbPersonalDetailsPage().selectGender();
    }


    public void enterFirstName(String firstName){
        getPageObject.fillFirstName(firstName);
    }


    public void enterLastName(String lastName){
        getPageObject.fillLastName(lastName);
    }


    public void enterStreetName(String street){
        getPageObject.fillStreet(street);
    }


    public void enterBirthDate(String birth){
        getPageObject.setBirthField(birth);
    }


    public void enterHouseNumber(String house){
        getPageObject.fillHouseNumber(house);
    }


    public void enterPostalCode(String postalCode){
        getPageObject.fillPostalCode(postalCode);
    }


    public void enterCity(String city){
        getPageObject.fillCity(city);
    }


    public void enterPhoneNumber(String phoneNum){
        getPageObject.fillPhoneNumber(phoneNum);
    }


    public void click_on_personal_details_submit_button(){
        getPageObject.clickSubmitButton();
    }


    public void verify_fifth_step_and_set_onboarding_personal_details(String firstName, String lastName, String birth, String street, String house, String postalCode, String city){
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



    public static void fillingRequiredFields(String firstName, String lastName, String birth, String street, String house, String postalCode, String city) {

        FsbPersonalDetailsPage startPage = new FsbPersonalDetailsPage();

        startPage.selectGender();
        startPage.fillFirstName(firstName);
        startPage.fillLastName(lastName);
        startPage.setBirthField(birth);
        startPage.fillStreet(street);
        startPage.fillHouseNumber(house);
        startPage.fillPostalCode(postalCode);
        startPage.fillCity(city);
        startPage.clickSubmitButton();
    }
}
