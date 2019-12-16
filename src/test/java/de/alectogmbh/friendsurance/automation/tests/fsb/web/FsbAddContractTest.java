package de.alectogmbh.friendsurance.automation.tests.fsb.web;

import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.*;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerDataUtils;
import net.thucydides.core.annotations.Steps;
import org.testng.annotations.Test;


public class FsbAddContractTest extends AbstractScenarioTest<FsbAddContractSteps> {

    @Steps
    private FsbOrderOverviewSteps fsbOrderOverviewSteps = new FsbOrderOverviewSteps();

    @Steps
    private FsbAddContractSteps fsbAddContractSteps = new FsbAddContractSteps();

    @Steps
    private FsbSignOrderStep fsbSignOrderStep = new FsbSignOrderStep();

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
    private FsbEditOrderSteps fsbEditOrderSteps = new FsbEditOrderSteps();

    @Test
    public void addExistingInsuranceContracts() {
        DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

        OnboardUserWithBankCredentials(dbCustomerData);

        fsbOrderOverviewSteps.verify_order_overview_page_and_click_on_missing_info_order_item_one();

        fsbEditOrderSteps.verify_edit_order_page_for_item_one_and_click_on_delete_order_item_link();

        fsbOrderOverviewSteps.verify_order_items_after_deleting_one_item_and_click_on_error_order_two();

        fsbEditOrderSteps.verify_edit_order_page_for_item_two_and_click_on_delete_order_item_link();

        fsbOrderOverviewSteps.verify_order_overview_page_and_click_on_contracts_submit_button();

        fsbSignOrderStep.verify_sign_authorization_and_submit_order_items();



    }

    private void OnboardUserWithBankCredentials(DBCustomerData dbCustomerData){
        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

        fsbSignUpSteps.verify_second_step_and_go_to_next_step(dbCustomerData.getEmail(), dbCustomerData.getPassword());

        fsbBankSelectionSteps.verify_bank_step_select_bank_and_click_on_next_button();

        fsbFinApiWebFormSteps.enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(), dbCustomerData.getPin());

        fsbRetrieveBankDataStep.click_on_retrieve_bank_page_submit_button();

        fsbAccountStep.click_on_bank_account_next_button();

        fsbOrderOverviewSteps.verify_order_overview_page_is_loaded_and_headline_is_present();
    }

    protected FsbAddContractSteps getSteps() {
        return fsbAddContractSteps;
    }
}
