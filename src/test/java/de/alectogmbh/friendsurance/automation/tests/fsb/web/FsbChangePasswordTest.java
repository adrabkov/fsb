package de.alectogmbh.friendsurance.automation.tests.fsb.web;

import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.*;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerDataUtils;
import net.thucydides.core.annotations.Steps;
import org.junit.Rule;
import org.junit.Test;

public class FsbChangePasswordTest extends AbstractScenarioTest<FsbPersonalDetailsSteps> {

    private static final String EXPECTED_LOGIN_PAGE_HEADLINE_TEXT = "Willkommen beim Kunden-Login";
    private static final String EXPECTED_PERSONAL_DETAILS_HEADLINE = "Bitte geben Sie Ihre persönlichen Daten ein.";
    private static final String EXPECTED_SIGN_UP_PAGE_HEADLINE = "E-Mail eingeben, Passwort festlegen und geschafft!";
    private static final String EXPECTED_BANK_SELECTION_HEADLINE = "Bei welcher Bank sind Sie Kunde?";
    private static final String EXPECTED_BANK_MODAL_TEXT = "Ihr Konto schnell und sicher verbinden mit";
    private static final String BANK_NAME = "Leipziger Volksbank";
    private static final String EXPECTED_EDIT_ORDER_PAGE_HEADLINE = "Da müssen Sie noch einmal kurz ran.";
    private static final String EXPECTED_ORDER_OVERVIEW_HEADLINE = "Verträge überprüfen und hinzufügen";
    private static final String EXPECTED_SIGN_UP_ORDER_PAGE_HEADLINE = "Fehlt nur noch das Maklermandat.";

    @Steps
    private FsbPersonalDetailsSteps fsbPersonalDetailsSteps;

    @Steps
    private FsbOrderOverviewSteps fsbOrderOverviewSteps;

    @Steps
    private FsbAddContractSteps fsbAddContractSteps;

    @Steps
    private FsbSignOrderSteps fsbSignOrderSteps;

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

    @Steps
    private FsbOverallNeedAnalysisSummarySteps fsbOverallNeedAnalysisSummarySteps;

    @Steps
    private FsbEmailLoginSteps fsbEmailLoginSteps;

    protected FsbPersonalDetailsSteps getSteps() {
        return fsbPersonalDetailsSteps;
    }

    @Rule
//    public EnvironmentExecutionRule rule = new EnvironmentExecutionRule();

    @Test
//    @EnvironmentExecution(exclude = ALL, include = RUV)
    public void profilePasswordChange() {
        DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

        createOnboardUserWithBankCredentials(dbCustomerData);

        addContractAndFinishRegistration();


    }

    private void createOnboardUserWithBankCredentials(DBCustomerData dbCustomerData) {
        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace(), EXPECTED_PERSONAL_DETAILS_HEADLINE);

        fsbSignUpSteps.verify_second_step_and_go_to_next_step(dbCustomerData.getEmail(), dbCustomerData.getPassword(), EXPECTED_SIGN_UP_PAGE_HEADLINE);

        fsbBankSelectionSteps.verify_bank_step_select_bank_and_click_on_next_button(EXPECTED_BANK_SELECTION_HEADLINE, EXPECTED_BANK_MODAL_TEXT, BANK_NAME);

        fsbFinApiWebFormSteps.enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(), dbCustomerData.getPin());

        fsbAccountStep.choose_Phone_Number_Checkbox_and_click_next_button();
    }

    private void addContractAndFinishRegistration() {

        fsbOrderOverviewSteps.verify_order_overview_page_and_click_on_missing_info_order_item_one(EXPECTED_ORDER_OVERVIEW_HEADLINE);

        fsbEditOrderSteps.verify_edit_order_page_for_item_one_and_click_on_delete_order_item_link(EXPECTED_EDIT_ORDER_PAGE_HEADLINE);

        fsbOrderOverviewSteps.verify_order_items_after_deleting_one_item_and_click_on_error_order_two(EXPECTED_ORDER_OVERVIEW_HEADLINE);

        fsbEditOrderSteps.verify_edit_order_page_for_item_two_and_click_on_delete_order_item_link(EXPECTED_EDIT_ORDER_PAGE_HEADLINE);

        fsbOrderOverviewSteps.click_overview_page_submit_button();

        fsbSignOrderSteps.verify_sign_authorization_and_submit_order_items(EXPECTED_SIGN_UP_ORDER_PAGE_HEADLINE);

    }

    private void verifyOnboardedUserLoginFunctionality(DBCustomerData dbCustomerData) {
        fsbOrderOverviewSteps.click_on_header_logout_link();
        webdriver.navigate().refresh();
        fsbEmailLoginSteps.verify_login_page_enter_user_credentials_and_click_on_login_button(dbCustomerData.getEmail(), dbCustomerData.getNewPassword(), EXPECTED_LOGIN_PAGE_HEADLINE_TEXT);
    }

}
