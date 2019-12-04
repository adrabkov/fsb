package de.alectogmbh.friendsurance.automation.steps.web.insurance.order;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.Step2Page;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.Step3Page;
import de.alectogmbh.friendsurance.automation.steps.utils.CommonConstants;
import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Step2Steps extends AbstractOrderFlowSteps<Step2Page> {

  private Step2Page step2Page;

  public Step2Steps(Pages pages) {
    super(pages);
  }

  @Step
  public void enter_email_address(String email) {
    getPageObject().enterEmailAddress(email);
  }

  @Step
  public void enter_first_name(String firstName) {
    getPageObject().enterFirstName(firstName);
  }

  @Step
  public void enter_last_name(String lastName) {
    getPageObject().enterLastName(lastName);
  }

  @Step
  public void select_salutation_by_index(Integer index) {
    getPageObject().selectSalutationByIndex(index);
  }

  @Step
  public void select_salutation_by_value(String value) {
    getPageObject().selectSalutationByValue(value);
  }

  @Step
  public void select_birthday_day_by_index(int index) {
    getPageObject().selectBirthDayByIndex(index);
  }

  @Step
  public void select_birthday_day_by_value(String value) {
    getPageObject().selectBirthDayByValue(value);
  }

  public void select_birthday_month_by_value(String value) {
    getPageObject().selectBirthMonthByValue(value);
  }

  @Step
  public void select_birth_year_by_value(String value) {
    getPageObject().selectBirthYearByValue(value);
  }

  @Step
  public void select_birth_month_by_index(int month) {
    getPageObject().selectBirthMonthByIndex(month);
  }

  @Step
  public void select_birthday_year_by_index(int year) {
    getPageObject().selectBirthYearByIndex(year);
  }

  @Step
  public void enter_phone_number(String phoneNumber) {
    getPageObject().enterPhoneNumber(phoneNumber);
  }

  @Step
  public void select_street_name(String streetName) {
    getPageObject().selectStreetName(streetName);
  }

  @Step
  public void enter_house_number(String houseNumber) {
    getPageObject().enterHouseNumber(houseNumber);
  }

  @Step
  public void enter_postal_code(String postalCode) {
    getPageObject().enterPostalCode(postalCode);
  }

  @Step
  public void select_city_name(String cityName) {
    getPageObject().selectCityName(cityName);
  }

  @Step
  public void click_on_submit_button() {
    getPageObject().clickOnSubmitButton();
  }

  @StepGroup
  public void unselect_birthday_fields() {
    select_birthday_day_by_index(CommonConstants.NO_OPTION_SELECTED_LIST_INDEX);
    select_birth_month_by_index(CommonConstants.NO_OPTION_SELECTED_LIST_INDEX);
    select_birthday_year_by_index(CommonConstants.NO_OPTION_SELECTED_LIST_INDEX);
  }

  @StepGroup
  public void clear_all_fields() {
    enter_email_address("");
    select_salutation_by_index(0);
    enter_first_name("");
    enter_last_name("");
    unselect_birthday_fields();
    enter_postal_code("");
    enter_house_number("");
  }

  @StepGroup
  public void submit_with_correct_data_new_user(CustomerData data) {
    enter_email_address(data.getEmail());
    select_salutation_by_value(data.getGender());
    enter_first_name(data.getFirstName());
    enter_last_name(data.getLastName());
    select_birthday_day_by_value(data.getBirthDay());
    select_birth_month_by_index(data.getBirthMonth());
    select_birth_year_by_value(data.getBirthYear());
    enter_phone_number(data.getPhoneNumber());
    enter_postal_code(data.getPostalCode());
    select_city_name(data.getCity());
    select_street_name(data.getStreet());
    enter_house_number(data.getHouseNumber());
    click_on_submit_button();
  }

  @StepGroup
  public void submit_with_correct_data_old_user(CustomerData data) {
    if (getPageObject().isEmailEnabled()) {
      enter_email_address(data.getEmail());
    }
    select_salutation_by_value(data.getGender());
    if (getPageObject().isFirstNameEnabled()) {
      enter_first_name(data.getFirstName());
    }
    if (getPageObject().isLastNameEnabled()) {
      enter_last_name(data.getLastName());
    }
    select_birthday_day_by_value(data.getBirthDay());
    select_birth_month_by_index(data.getBirthMonth());
    select_birth_year_by_value(data.getBirthYear());
    if (getPageObject().isPhoneNumberEnabled()) {
      enter_phone_number(data.getPhoneNumber());
    }
    enter_postal_code(data.getPostalCode());
    select_city_name(data.getCity());
    select_street_name(data.getStreet());
    enter_house_number(data.getHouseNumber());
    click_on_submit_button();
  }

  @Step
  public void upgrade_checkout_page_is_loaded() {
    assertThat(
        "Wrong page loaded  [" + getPageObject().getCurrentPageUrl() + "]",
            getPageObject().getCurrentPageUrl().endsWith(Step3Page.DEFAULT_URL_UPGRADE),
        is(true)
    );
  }

  @Override
  protected Step2Page getPageObject() {
    return step2Page;
  }

}
