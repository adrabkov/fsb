package steps.client.onboarding;

import pages.onboarding.StartPage;

public class StepFirst {

    public static void fillingRequiredFields(String firstName, String lastName, String birth, String street, String house, String postalCode, String city) {
        StartPage startPage = new StartPage();

        startPage.chooseRadioButton();
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
