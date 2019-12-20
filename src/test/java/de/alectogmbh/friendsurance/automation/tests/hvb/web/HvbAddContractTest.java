package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.*;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerDataUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class HvbAddContractTest extends AbstractScenarioTest<HvbBankSelectionSteps> {

  @Steps
  private HvbBankSelectionSteps hvbBankSelectionSteps;

  @Steps
  private HvbInsuranceInformationSteps hvbInsuranceInformationSteps;

  @Steps
  private HvbTermsConditionsSteps hvbTermsConditionsSteps;

  @Steps
  private HvbFinApiWebFormSteps hvbFinApiWebFormSteps;

  @Steps
  private HvbPersonalDetailsSteps hvbPersonalDetailsSteps;

  @Steps
  private HvbSignUpSteps hvbSignUpSteps;

  @Steps
  private HvbOrderOverviewSteps hvbOrderOverviewSteps;

  @Steps
  private HvbLandingSteps hvbLandingSteps;

  @Steps
  private HvbEmailLoginSteps hvbEmailLoginSteps;

  @Steps
  private HvbDashboardSteps hvbDashboardSteps;

  @Steps
  private HvbEditOrderSteps hvbEditOrderSteps;

  @Steps
  private HvbAddContractSteps hvbAddContractSteps;

  @Steps
  private HvbSignOrderSteps hvbSignOrderSteps;

  @Steps
  private HvbOverallNeedAnalysisIntroSteps hvbOverallNeedAnalysisIntroSteps;

  protected HvbBankSelectionSteps getSteps() {
    return hvbBankSelectionSteps;
  }

  @Test
  public void addExtractedAndExistingInsuranceContracts() throws InterruptedException {

    DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

    OnboardUserWithBankCredentials(dbCustomerData);

    hvbOrderOverviewSteps.check_and_delete_missing_orders_items();

    hvbOrderOverviewSteps.verify_company_name_before_editing_and_click_on_item();

    hvbEditOrderSteps.verify_order_page_and_edit_company_name();

    hvbOrderOverviewSteps.check_company_name_item_after_edit_action();

    hvbOrderOverviewSteps.verify_order_overview_page_and_perform_user_actions_and_click_add_button();

    hvbAddContractSteps.verify_add_contract_page_enter_policy_details_and_go_next();

    hvbOrderOverviewSteps.verify_order_items_after_adding_contract_and_click_on_overview_page_submit_button();

    hvbSignOrderSteps.verify_sign_authorization_and_submit_order_items();

    hvbOverallNeedAnalysisIntroSteps.verify_ona_intro_page_is_loaded_after_addcontract_flow_during_onboarding();




//    hvbOrderOverviewSteps.verify_order_overview_page_and_click_on_missing_info_order_item_one();
//
//    hvbEditOrderSteps.verify_edit_order_page_for_item_one_and_click_on_delete_order_item_link();
//
//    hvbOrderOverviewSteps.verify_order_items_after_deleting_one_item_and_click_on_error_order_two();
//
//    hvbEditOrderSteps.verify_edit_order_page_for_item_two_and_click_on_delete_order_item_link();
//
//    hvbOrderOverviewSteps.verify_order_items_after_deleting_error_items_and_click_on_add_contract_button();
//
//    hvbAddContractSteps.verify_add_contract_page_enter_policy_details_and_go_next();
//
//    hvbOrderOverviewSteps.verify_order_items_after_adding_contract_and_click_on_overview_page_submit_button();
//
//    hvbSignOrderSteps.verify_sign_authorization_and_submit_order_items();
//
//    hvbOverallNeedAnalysisIntroSteps.verify_ona_intro_page_is_loaded_after_addcontract_flow_during_onboarding();
  }

  private void OnboardUserWithBankCredentials(DBCustomerData dbCustomerData) throws InterruptedException {
    hvbBankSelectionSteps.verify_first_step_select_bank_branch_and_click_on_next_button();

    hvbInsuranceInformationSteps.verify_second_step_insurance_information_page_and_click_on_next_button();

    hvbTermsConditionsSteps.verify_third_step_bank_conditions_page_and_click_next_button();

    hvbFinApiWebFormSteps.enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(dbCustomerData.getUserId(),
        dbCustomerData.getPin());

    hvbPersonalDetailsSteps
        .verify_fifth_step_and_set_onboarding_personal_details(dbCustomerData.isGender(), dbCustomerData.getBirthDay(),
            dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
            dbCustomerData.getPlace(), dbCustomerData.getPhoneNum());

    hvbSignUpSteps.verify_sixth_step_and_finish_sign_up(dbCustomerData.getEmail(), dbCustomerData.getPassword());
  }

}
