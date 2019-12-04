package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.UserInfoAddressCocaFlowPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class UserInfoAddressSteps extends AbstractCocaFlowScenarioSteps<UserInfoAddressCocaFlowPage> {

  private UserInfoAddressCocaFlowPage userInfoAddressPage;

  @Step
  public void select_gender() {
    getPageObject().selectTitle();
  }

  @Step
  public void enter_first_name() {
    getPageObject().enterFirstName("Tester");
  }

  @Step
  public void enter_last_name() {
    getPageObject().enterLastName("Testovsky");
  }

  @Step
  public void enter_user_address() {
    getPageObject().enterStreetName("Ufnaustraße");
    getPageObject().enterHouseNumber("77A");
    getPageObject().enterPostalCode("10553");
    getPageObject().enterCityName("Berlin");
  }

  @StepGroup
  public void fill_user_address_form() {
    select_gender();
    enter_first_name();
    enter_last_name();
    enter_user_address();
    click_on_continue_button();
  }

  @StepGroup
  public void fill_user_address_for_existing_user_with_incomplete_address_data() {
    select_gender();
    enter_user_address();
    click_on_continue_button();
  }

  @Override
  protected UserInfoAddressCocaFlowPage getPageObject() {
    return userInfoAddressPage;
  }

}
