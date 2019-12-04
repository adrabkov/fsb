package de.alectogmbh.friendsurance.automation.tests.fsb.web;

import models.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbBankSelectionPage;
import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbSignUpPage;
import de.alectogmbh.friendsurance.automation.requirements.ValidationMessages;
import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbBankSelectionSteps;
import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbPersonalDetailsSteps;
import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbSignUpSteps;
import de.alectogmbh.friendsurance.automation.tests.BaseTest;
import de.alectogmbh.friendsurance.automation.tests.DataProviderClass;

public class FsbOnboardingTest extends BaseTest {

//    private static final WebElement BANKS_LIST = new FsbBankSelectionPage().getBanksList();
    private static final String INCORRECT_EMAIL = new CommonFunctions().getIncorrectEmail();
    private static final String INCORRECT_PASSWORD = new CommonFunctions().getIncorrectPassword();
    private static final String EXPECTED_EMAIL_TEXT = new ValidationMessages().getTextForEmailValidation();
    private static final String EXPECTED_PASS_TEXT = new ValidationMessages().getTextForPasswordValidation();
    private static final String EXPECTED_EMAIL_ALREADY = new ValidationMessages().getTextForAlreadyExistedEmail();
    private static final String CORRECT_EMAIL = new CommonFunctions().getEmail();
    private static final String PASSWORD = "Test1@34";

    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
    public void testRegistrationWithCorrectDate(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
//        FsbPersonalDetailsSteps fsbPersonalDetailsSteps = new FsbPersonalDetailsSteps();
//        fsbPersonalDetailsSteps.selectGender();
        FsbPersonalDetailsSteps.selectGender();
//        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
//        FsbPersonalDetailsSteps.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
//        Assert.assertTrue(new FsbSignUpPage().getEmailField().isDisplayed());
//        FsbSignUpSteps.fillingFieldsForStep2(CORRECT_EMAIL, PASSWORD);
//        Assert.assertTrue(BANKS_LIST.isDisplayed());
    }

//    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
//    public void testRegistrationWithIncorrectCredentials(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
//        FsbPersonalDetailsSteps.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
//        FsbSignUpSteps.fillingFieldsForStep2(INCORRECT_EMAIL, INCORRECT_PASSWORD);
//        Assert.assertEquals(new FsbSignUpPage().textForEmailValidation(), EXPECTED_EMAIL_TEXT);
//        Assert.assertEquals(new FsbSignUpPage().textForPasswordValidation(), EXPECTED_PASS_TEXT);
//    }
//
//    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
//    public void testRegistrationWithAlreadyExistedUser(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
//        String email = new CommonFunctions().getEmail();
//        FsbPersonalDetailsSteps.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
//        FsbSignUpSteps.fillingFieldsForStep2(email, PASSWORD);
//        Assert.assertTrue(BANKS_LIST.isDisplayed());
//        driver.navigate().to(getStartUrl());
//        FsbPersonalDetailsSteps.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
//        FsbSignUpSteps.fillingFieldsForStep2(email, PASSWORD);
//        Assert.assertEquals(new FsbSignUpPage().textMessageForAlreadyExistedEmail(), EXPECTED_EMAIL_ALREADY);
//    }
//
//    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
//    public void testShowPasswordButton(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
//        FsbPersonalDetailsSteps.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
//        FsbSignUpPage signupPage = new FsbSignUpPage();
//        signupPage.fillEmailField(CORRECT_EMAIL);
//        signupPage.fillPasswordField(PASSWORD);
//        signupPage.clickShowPasswordButton();
//        Assert.assertEquals(new FsbSignUpPage().getShowPasswordButton().getAttribute("class"), "active");
//    }
//
//    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
//    public void testRegistrationWithoutCheckBox(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
//        FsbPersonalDetailsSteps.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
//        FsbSignUpPage signupPage = new FsbSignUpPage();
//        signupPage.fillEmailField(CORRECT_EMAIL);
//        signupPage.fillPasswordField(PASSWORD);
//        signupPage.clickSubmitButton();
//        Assert.assertEquals(new FsbSignUpPage().actualConditionTextForCheckBox(), new ValidationMessages().getConditionText());
//        signupPage.clickCondition1();
//        signupPage.clickCondition2();
//        signupPage.clickCondition3();
//        signupPage.clickSubmitButton();
//        Assert.assertTrue(BANKS_LIST.isDisplayed());
//    }
//
//    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
//    public void testRegistrationWithEmptyBankField(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
//        FsbPersonalDetailsSteps.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
//        FsbSignUpSteps.fillingFieldsForStep2(CORRECT_EMAIL, PASSWORD);
//        FsbBankSelectionPage banksPage = new FsbBankSelectionPage();
//        banksPage.clickNextButton();
//        Assert.assertEquals(banksPage.getValidationMessageForBankList(), new ValidationMessages().getTextForBankFieldValidation());
//    }
//
//    @Test(dataProvider = "data for registration", dataProviderClass = DataProviderClass.class)
//    public void testSearchByBankName(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city) {
//        FsbPersonalDetailsSteps.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
//        FsbSignUpSteps.fillingFieldsForStep2(CORRECT_EMAIL, PASSWORD);
//        FsbBankSelectionSteps bankStep = new FsbBankSelectionSteps();
//        bankStep.searchingBank("ab");
//    }
}
