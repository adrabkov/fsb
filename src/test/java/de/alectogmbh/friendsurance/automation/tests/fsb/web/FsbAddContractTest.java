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
public class FsbAddContractTest extends AbstractScenarioTest<FsbPersonalDetailsSteps> {

    private static final String EXPECTED_PERSONAL_DETAILS_HEADLINE = "Bitte geben Sie Ihre persönlichen Daten ein.";
    private static final String EXPECTED_SIGN_UP_PAGE_HEADLINE = "E-Mail eingeben, Passwort festlegen und geschafft!";
    private static final String EXPECTED_BANK_SELECTION_HEADLINE = "Bei welcher Bank sind Sie Kunde?";
    private static final String EXPECTED_BANK_MODAL_TEXT = "Ihr Konto schnell und sicher verbinden mit";
    private static final String BANK_NAME = "Leipziger Volksbank";
    private static final String EXPECTED_EDIT_ORDER_PAGE_HEADLINE = "Da müssen Sie noch einmal kurz ran.";
    private static final String EXPECTED_ORDER_OVERVIEW_HEADLINE = "Verträge überprüfen und hinzufügen";
    private static final String EXPECTED_ONA_INTRO_HEADLINE_TEXT_DURING_ONBOARDING = "Noch 5 kleine Fragen, dann sind wir durch!";
    private static final String EXPECTED_SIGN_UP_ORDER_PAGE_HEADLINE = "Fehlt nur noch das Maklermandat.";

    @Steps
    private FsbOrderOverviewSteps fsbOrderOverviewSteps;

    @Steps
    private FsbAddContractSteps fsbAddContractSteps;

    @Steps
    private FsbSignOrderSteps fsbSignOrderSteps;

    @Steps
    private FsbPersonalDetailsSteps fsbPersonalDetailsSteps;

    @Steps
    private FsbSignUpSteps fsbSignUpSteps;

    @Steps
    private FsbBankSelectionSteps fsbBankSelectionSteps;

    @Steps
    private FsbFinApiWebFormSteps fsbFinApiWebFormSteps;

    @Steps
    private FsbDashboardSteps fsbDashboardSteps;

    @Steps
    private FsbRetrieveBankDataStep fsbRetrieveBankDataStep;

    @Steps
    private FsbAccountStep fsbAccountStep;

    @Steps
    private FsbEditOrderSteps fsbEditOrderSteps;

    @Steps
    private FsbOverallNeedAnalysisIntroSteps fsbOverallNeedAnalysisIntroSteps;

    protected FsbPersonalDetailsSteps getSteps() {
        return fsbPersonalDetailsSteps;
    }

    @Test
    public void addExistingInsuranceContracts() throws InterruptedException {
        DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

        OnboardUserWithBankCredentials(dbCustomerData);

        fsbOrderOverviewSteps.verify_order_overview_page_and_click_on_missing_info_order_item_one(EXPECTED_ORDER_OVERVIEW_HEADLINE);

        fsbEditOrderSteps.verify_edit_order_page_for_item_one_and_click_on_delete_order_item_link(EXPECTED_EDIT_ORDER_PAGE_HEADLINE);

        fsbOrderOverviewSteps.verify_order_items_after_deleting_one_item_and_click_on_error_order_two(EXPECTED_ORDER_OVERVIEW_HEADLINE);

        fsbEditOrderSteps.verify_edit_order_page_for_item_two_and_click_on_delete_order_item_link(EXPECTED_EDIT_ORDER_PAGE_HEADLINE);

        fsbOrderOverviewSteps.verify_order_items_after_deleting_error_items_and_click_on_add_contract_button(EXPECTED_ORDER_OVERVIEW_HEADLINE);

        fsbAddContractSteps.verify_add_contract_page_enter_policy_details_and_go_next();

        fsbOrderOverviewSteps.verify_order_items_after_adding_contract_and_click_on_overview_page_submit_button(EXPECTED_ORDER_OVERVIEW_HEADLINE);

        fsbSignOrderSteps.verify_sign_authorization_and_submit_order_items(EXPECTED_SIGN_UP_ORDER_PAGE_HEADLINE);

        fsbOverallNeedAnalysisIntroSteps.verify_ona_intro_page_is_loaded_after_addcontract_flow_during_onboarding(EXPECTED_ONA_INTRO_HEADLINE_TEXT_DURING_ONBOARDING);

    }

    private void OnboardUserWithBankCredentials(DBCustomerData dbCustomerData) {
        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace(), EXPECTED_PERSONAL_DETAILS_HEADLINE);

        fsbSignUpSteps.verify_second_step_and_go_to_next_step(dbCustomerData.getEmail(), dbCustomerData.getPassword(), EXPECTED_SIGN_UP_PAGE_HEADLINE);

        fsbBankSelectionSteps.verify_bank_step_select_bank_and_click_on_next_button(EXPECTED_BANK_SELECTION_HEADLINE, EXPECTED_BANK_MODAL_TEXT, BANK_NAME);

        fsbFinApiWebFormSteps.enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(), dbCustomerData.getPin());

        fsbAccountStep.choose_Phone_Number_Checkbox_and_click_next_button();

    }
}
