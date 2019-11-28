package tests.client;

import models.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.onboarding.BanksPage;
import pages.onboarding.SignupPage;
import requirements.ValidationMessages;
import steps.client.onboarding.BankStep;
import steps.client.onboarding.StepFirst;
import steps.client.onboarding.StepSecond;
import tests.BaseTest;
import tests.DataProviderClass;

public class TestOndoarding extends BaseTest {

    private static final WebElement BANKS_LIST = new BanksPage().getBanksList();
    private static final String INCORRECT_EMAIL = new CommonFunctions().getIncorrectEmail();
    private static final String INCORRECT_PASSWORD = new CommonFunctions().getIncorrectPassword();
    private static final String EXPECTED_EMAIL_TEXT = new ValidationMessages().getTextForEmailValidation();
    private static final String EXPECTED_PASS_TEXT = new ValidationMessages().getTextForPasswordValidation();
    private static final String EXPECTED_EMAIL_ALREADY = new ValidationMessages().getTextForAlreadyExistedEmail();
    private static final String CORRECT_EMAIL = new CommonFunctions().getEmail();
    private static final String PASSWORD = "Test1@34";

    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
    public void testRegistrationWithCorrectDate(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
        StepFirst.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
        Assert.assertTrue(new SignupPage().getEmailField().isDisplayed());
        StepSecond.fillingFieldsForStep2(CORRECT_EMAIL, PASSWORD);
        Assert.assertTrue(BANKS_LIST.isDisplayed());
    }

    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
    public void testRegistrationWithIncorrectCredentials(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
        StepFirst.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
        StepSecond.fillingFieldsForStep2(INCORRECT_EMAIL, INCORRECT_PASSWORD);
        Assert.assertEquals(new SignupPage().textForEmailValidation(), EXPECTED_EMAIL_TEXT);
        Assert.assertEquals(new SignupPage().textForPasswordValidation(), EXPECTED_PASS_TEXT);
    }

    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
    public void testRegistrationWithAlreadyExistedUser(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
        String email = new CommonFunctions().getEmail();
        StepFirst.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
        StepSecond.fillingFieldsForStep2(email, PASSWORD);
        Assert.assertTrue(BANKS_LIST.isDisplayed());
        driver.navigate().to(getStartUrl());
        StepFirst.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
        StepSecond.fillingFieldsForStep2(email, PASSWORD);
        Assert.assertEquals(new SignupPage().textMessageForAlreadyExistedEmail(), EXPECTED_EMAIL_ALREADY);
    }

    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
    public void testShowPasswordButton(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
        StepFirst.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
        SignupPage signupPage = new SignupPage();
        signupPage.fillEmailField(CORRECT_EMAIL);
        signupPage.fillPasswordField(PASSWORD);
        signupPage.clickShowPasswordButton();
        Assert.assertEquals(new SignupPage().getShowPasswordButton().getAttribute("class"), "active");
    }

    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
    public void testRegistrationWithoutCheckBox(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
        StepFirst.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
        SignupPage signupPage = new SignupPage();
        signupPage.fillEmailField(CORRECT_EMAIL);
        signupPage.fillPasswordField(PASSWORD);
        signupPage.clickSubmitButton();
        Assert.assertEquals(new SignupPage().actualConditionTextForCheckBox(), new ValidationMessages().getConditionText());
        signupPage.clickCondition1();
        signupPage.clickCondition2();
        signupPage.clickCondition3();
        signupPage.clickSubmitButton();
        Assert.assertTrue(BANKS_LIST.isDisplayed());
    }

    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
    public void testRegistrationWithEmptyBankField(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
        StepFirst.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
        StepSecond.fillingFieldsForStep2(CORRECT_EMAIL, PASSWORD);
        BanksPage banksPage = new BanksPage();
        banksPage.clickNextButton();
        Assert.assertEquals(banksPage.getValidationMessageForBankList(), new ValidationMessages().getTextForBankFieldValidation());
    }

    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
    public void testSearchByBankName(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
        StepFirst.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
        StepSecond.fillingFieldsForStep2(CORRECT_EMAIL, PASSWORD);
        BankStep bankStep = new BankStep();
        bankStep.searchingBank("ab");
    }
}
