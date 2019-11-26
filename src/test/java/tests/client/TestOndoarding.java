package tests.client;

import models.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.onboarding.BanksPage;
import pages.onboarding.SignupPage;
import requirements.ValidationMessages;
import steps.client.onboarding.StepFirst;
import steps.client.onboarding.StepSecond;
import tests.BaseTest;

public class TestOndoarding extends BaseTest {


    private static final WebElement BANKS_LIST = new BanksPage().getBanksList();
    private static final String INCORRECT_EMAIL = new CommonFunctions().getIncorrectEmail();
    private static final String INCORRECT_PASSWORD = new CommonFunctions().getIncorrectPassword();
    private static final String EXPECTED_EMAIL_TEXT = new ValidationMessages().getTextForEmailValidation();
    private static final String ACTUAL_EMAIL_TEXT = new SignupPage().textForEmailValidation();
    private static final String EXPECTED_PASS_TEXT = new ValidationMessages().getTextForPasswordValidation();
    private static final String ACTUAL_PASS_TEXT = new SignupPage().textForPasswordValidation();

//    @Test
//    @Parameters({"firstName", "lastName", "birthDate", "streetName", "houseNumber", "postalCode", "city", "password"})
//    public void testRegistrationWithCorrectDate(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city, String password) {
//        StepFirst.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
//        Assert.assertTrue(new SignupPage().getEmailField().isDisplayed());
//        StepSecond.fillingFieldsForStep2(new CommonFunctions().getEmail(), password);
//        Assert.assertTrue(BANKS_LIST.isDisplayed());
//    }

    @Test
    @Parameters({"firstName", "lastName", "birthDate", "streetName", "houseNumber", "postalCode", "city", "password"})
    public void testRegistrationWithIncorrectCredentials(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
        StepFirst.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
        StepSecond.fillingFieldsForStep2(INCORRECT_EMAIL, INCORRECT_PASSWORD);
        Assert.assertEquals(EXPECTED_EMAIL_TEXT, ACTUAL_EMAIL_TEXT);
        Assert.assertEquals(EXPECTED_PASS_TEXT, ACTUAL_PASS_TEXT);





    }
}
