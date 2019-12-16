package de.alectogmbh.friendsurance.automation.tests.fsb.web;

import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.*;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerDataUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import de.alectogmbh.friendsurance.automation.tests.BaseTest;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(SerenityRunner.class)
public class FsbOnboardingTest extends BaseTest {

    private static DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

    @Steps
    private FsbPersonalDetailsSteps fsbPersonalDetailsSteps = new FsbPersonalDetailsSteps();

    @Steps
    private FsbSignUpSteps fsbSignUpSteps = new FsbSignUpSteps();

    @Steps
    private FsbBankSelectionSteps fsbBankSelectionSteps = new FsbBankSelectionSteps();

    @Steps
    private FsbFinApiWebFormSteps fsbFinApiWebFormSteps = new FsbFinApiWebFormSteps();

    @Steps
    private FsbDashboardSteps fsbDashboardSteps = new FsbDashboardSteps();

    @Steps
    private FsbRetrieveBankDataStep fsbRetrieveBankDataStep = new FsbRetrieveBankDataStep();

    @Steps
    private FsbAccountStep fsbAccountStep = new FsbAccountStep();

    @Steps
    private FsbOrderOverviewSteps fsbOrderOverviewSteps = new FsbOrderOverviewSteps();

    @Test()
    public void testRegistrationWithCorrectData() throws InterruptedException {

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

        fsbSignUpSteps.verify_second_step_and_go_to_next_step(dbCustomerData.getEmail(), dbCustomerData.getPassword());

        fsbBankSelectionSteps.verify_bank_step_select_bank_and_click_on_next_button();

        fsbFinApiWebFormSteps.enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(), dbCustomerData.getPin());

//        fsbRetrieveBankDataStep.verify_retrieve_bank_page_text_and_click_submit_button();

        fsbAccountStep.choose_Phone_Number_Checkbox_and_click_next_button();

        fsbOrderOverviewSteps.verify_order_overview_page_is_loaded_and_headline_is_present();

    }



    @Test()
    public void testRegistrationWithAlreadyExistedUser() {

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

        fsbSignUpSteps.verify_second_step_and_go_to_next_step(dbCustomerData.getEmail(), dbCustomerData.getPassword());

        driver.navigate().to(getStartUrl());

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

        fsbSignUpSteps.verify_validation_message_for_already_existed_email(dbCustomerData.getEmail(), dbCustomerData.getPassword());

    }

    @Test()
    public void testRegistrationWithEmptyEmailField() {

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

        fsbSignUpSteps.verify_validation_message_for_empty_email_field(dbCustomerData.getPassword());

    }

    @Test()
    public void testRegistrationWithEmptyPasswordField() {

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

        fsbSignUpSteps.verify_validation_message_for_empty_password_field(dbCustomerData.getEmail());

    }

    @Test()
    public void testRegistrationWithIncorrectPasswordField() {

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

        fsbSignUpSteps.verify_validation_message_for_incorrect_password(dbCustomerData.getEmail(), dbCustomerData.getIncorrect_password());
    }

    @Test()
    public void testShowPasswordButtonOnTheSignUpPage() {

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

        fsbSignUpSteps.verify_show_password_button(dbCustomerData.getPassword());

    }

    @Test()
    public void testRegistrationWithoutConditionsCheckBox() {

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

        fsbSignUpSteps.verify_validation_messages_for_conditions_checkbox(dbCustomerData.getEmail(), dbCustomerData.getPassword());

    }

    @Test()
    public void testOpenDashboardFromSelectionBankPage() {

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

        fsbSignUpSteps.verify_second_step_and_go_to_next_step(dbCustomerData.getEmail(), dbCustomerData.getPassword());

        fsbBankSelectionSteps.verify_ability_to_open_dashboard_from_Bank_selection();

        fsbDashboardSteps.verify_if_home_page_is_loaded_and_dashboard_headline_is_present();

    }

    @Test()
    public void testRegistrationWithEmptyDropDownOnTheBankSelection() {

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

        fsbSignUpSteps.verify_second_step_and_go_to_next_step(dbCustomerData.getEmail(), dbCustomerData.getPassword());

        fsbBankSelectionSteps.verify_error_text_for_bank_selection();

    }

}