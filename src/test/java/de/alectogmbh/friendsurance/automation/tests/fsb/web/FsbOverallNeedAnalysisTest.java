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
public class FsbOverallNeedAnalysisTest extends AbstractScenarioTest<FsbPersonalDetailsSteps> {

    @Steps
    private FsbOrderOverviewSteps fsbOrderOverviewSteps;

    @Steps
    private FsbAddContractSteps fsbAddContractSteps;

    @Steps
    private FsbSignOrderSteps fsbSignOrderSteps;

    @Steps
    private FsbPersonalDetailsSteps fsbPersonalDetailsSteps;

//    @Steps
//    private FsbSignUpSteps fsbSignUpSteps;

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
    private FsbOverallNeedAnalysisIntroSteps fsbOverallNeedAnalysisIntrosteps;

    @Steps
    private FsbOverallNeedanalysisSteps fsbOverallNeedanalysisSteps;

    protected FsbPersonalDetailsSteps getSteps() {
        return fsbPersonalDetailsSteps;
    }

    @Test
    public void overallNeedAnalysisQuestionnaireAfterRegistration() throws InterruptedException {

        DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

        createOnboardUserWithBankCredentials(dbCustomerData);

        addContractAndFinishRegistration();

        fsbOverallNeedAnalysisIntroSteps.verify_ona_intro_page_is_loaded_and_click_on_go_next();

        fsbOverallNeedanalysisSteps.complete_ona_questionnaire();

    }

    private void createOnboardUserWithBankCredentials(DBCustomerData dbCustomerData) throws InterruptedException {

        fsbPersonalDetailsSteps.verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.getFirstName(), dbCustomerData.getLastName(),
                dbCustomerData.getBirthDay(), dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace());

//        fsbSignUpSteps.verify_second_step_and_go_to_next_step(dbCustomerData.getEmail(), dbCustomerData.getPassword());
        Thread.sleep(10000);

        fsbBankSelectionSteps.verify_bank_step_select_bank_and_click_on_next_button();

        fsbFinApiWebFormSteps.enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(), dbCustomerData.getPin());

        fsbAccountStep.choose_Phone_Number_Checkbox_and_click_next_button();

        Thread.sleep(10000);
    }

    private void addContractAndFinishRegistration(){

        fsbOrderOverviewSteps.verify_order_overview_page_and_click_on_missing_info_order_item_one();

        fsbEditOrderSteps.verify_edit_order_page_for_item_one_and_click_on_delete_order_item_link();

        fsbOrderOverviewSteps.verify_order_items_after_deleting_one_item_and_click_on_error_order_two();

        fsbEditOrderSteps.verify_edit_order_page_for_item_two_and_click_on_delete_order_item_link();

        fsbOrderOverviewSteps.click_overview_page_submit_button();

        fsbSignOrderSteps.verify_sign_authorization_and_submit_order_items();

    }
}
