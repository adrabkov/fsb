package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.*;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerDataUtils;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class HvbOnboardingTest extends AbstractScenarioTest {

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

  protected HvbBankSelectionSteps getSteps() {
    return hvbBankSelectionSteps;
  }

  @Test
  public void userRegistrationWithBankCredentials() throws InterruptedException {

    DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

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

    hvbOrderOverviewSteps.verify_order_overview_page_is_loaded_and_click_on_logout_link();

    verifyOnboardedUserLoginFunctionality(dbCustomerData);
  }

  private void verifyOnboardedUserLoginFunctionality(DBCustomerData dbCustomerData) {
    hvbLandingSteps.click_on_header_login_link();
    hvbEmailLoginSteps.verify_login_page_enter_user_credentials_and_click_on_login_button(dbCustomerData.getEmail(),
        dbCustomerData.getPassword());
    hvbDashboardSteps.click_on_dashboard_header_logout_link();
  }

}
