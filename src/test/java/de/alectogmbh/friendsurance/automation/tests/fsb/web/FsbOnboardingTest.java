package de.alectogmbh.friendsurance.automation.tests.fsb.web;

import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.*;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerDataUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FsbOnboardingTest extends AbstractScenarioTest<FsbPersonalDetailsSteps> {

    private static final String EXPECTED_PERSONAL_DETAILS_HEADLINE = "Bitte geben Sie Ihre persönlichen Daten ein.";
    private static final String EXPECTED_SIGN_UP_PAGE_HEADLINE = "E-Mail eingeben, Passwort festlegen und geschafft!";
    private static final String EXPECTED_BANK_SELECTION_HEADLINE = "Bei welcher Bank sind Sie Kunde?";
    private static final String EXPECTED_BANK_MODAL_TEXT = "Ihr Konto schnell und sicher verbinden mit";
    private static final String BANK_NAME = "Leipziger Volksbank";
    private static final String EXPECTED_ORDER_OVERVIEW_HEADLINE = "Verträge überprüfen und hinzufügen";

    @Steps
    private FsbPersonalDetailsSteps fsbPersonalDetailsSteps;

    @Steps
    private FsbSignUpSteps fsbSignUpSteps;

    @Steps
    private FsbBankSelectionSteps fsbBankSelectionSteps;

    @Steps
    private FsbFinApiWebFormSteps fsbFinApiWebFormSteps;

    @Steps
    private FsbAccountStep fsbAccountStep;

    @Steps
    private FsbOrderOverviewSteps fsbOrderOverviewSteps;

    protected FsbPersonalDetailsSteps getSteps() {
        return fsbPersonalDetailsSteps;
    }

    @Test()
    public void testRegistrationWithCorrectData() {

        DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace(), EXPECTED_PERSONAL_DETAILS_HEADLINE);

        fsbSignUpSteps.verify_second_step_and_go_to_next_step(dbCustomerData.getEmail(), dbCustomerData.getPassword(), EXPECTED_SIGN_UP_PAGE_HEADLINE);

        fsbBankSelectionSteps.verify_bank_step_select_bank_and_click_on_next_button(EXPECTED_BANK_SELECTION_HEADLINE, EXPECTED_BANK_MODAL_TEXT, BANK_NAME);

        fsbFinApiWebFormSteps.enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(), dbCustomerData.getPin());

        fsbAccountStep.choose_Phone_Number_Checkbox_and_click_next_button();

        fsbOrderOverviewSteps.verify_order_overview_page_is_loaded_and_headline_is_present(EXPECTED_ORDER_OVERVIEW_HEADLINE);
    }
}
