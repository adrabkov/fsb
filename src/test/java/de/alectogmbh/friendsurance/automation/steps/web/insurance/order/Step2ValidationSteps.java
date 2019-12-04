package de.alectogmbh.friendsurance.automation.steps.web.insurance.order;

import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Step2ValidationSteps extends Step2Steps {

  protected String emptyEmailErrorMessage;
  protected String incorrectEmailErrorMessage;
  protected String salutationErrorMessage;
  protected String firstLastNameErrorMessage;
  protected String birthdayErrorMessage;
  protected String minimumAgeAllowedErrorMessage;
  protected String phoneNumberErrorMessage;
  protected String postalCodeErrorMessage;
  protected String cityNameErrorMessage;
  protected String streetHouseNumberErrorMessage;

  public Step2ValidationSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void empty_email_error_message_is_correct() {
    ValidationUtils.checkValidationErrorMessage(emptyEmailErrorMessage,
        getPageObject().getEmailAddressRequiredErrorMessage()
    );
  }

  @Step
  public void empty_email_error_message_is_not_shown() {
    ValidationUtils.checkElementIsNotDisplayed("Email Required Error Message",
        getPageObject().isEmailRequiredErrorMessageVisible()
    );
  }

  @Step
  public void incorrect_email_error_message_is_correct() {
    ValidationUtils.checkValidationErrorMessage(incorrectEmailErrorMessage,
        getPageObject().getEmailAddressIncorrectErrorMessage()
    );
  }

  @Step
  public void not_selected_salutation_error_message_is_correct() {
    ValidationUtils
        .checkValidationErrorMessage(salutationErrorMessage,
            getPageObject().getSalutationErrorMessage());
  }

  @Step
  public void first_last_name_error_message_is_correct() {
    ValidationUtils
        .checkValidationErrorMessage(firstLastNameErrorMessage,
            getPageObject().getFirstLastNameErrorMessage());
  }

  @Step
  public void not_selected_birthday_error_message_is_correct() {
    ValidationUtils.checkValidationErrorMessage(birthdayErrorMessage,
        getPageObject().getBirthdayErrorMessage());
  }

  @Step
  public void minimum_age_error_message_is_correct() {
    ValidationUtils.checkValidationErrorMessage(minimumAgeAllowedErrorMessage,
        getPageObject().getMinimumAgeAllowedErrorMessage()
    );
  }

  @Step
  public void phone_number_error_message_is_correct() {
    ValidationUtils
        .checkValidationErrorMessage(phoneNumberErrorMessage,
            getPageObject().getPhoneNumberErrorMessage());
  }

  @Step
  public void postal_code_error_message_is_correct() {
    ValidationUtils
        .checkValidationErrorMessage(postalCodeErrorMessage,
            getPageObject().getPostalCodeErrorMessage());
  }

  @Step
  public void city_name_error_message_is_correct() {
    ValidationUtils.checkValidationErrorMessage(cityNameErrorMessage,
        getPageObject().getCityNameErrorMessage());
  }

  @Step
  public void street_house_number_error_message_is_correct() {
    ValidationUtils.checkValidationErrorMessage(streetHouseNumberErrorMessage,
        getPageObject().getStreetHouseNumberErrorMessage()
    );
  }

  @StepGroup
  public void submit_with_empty_email_address() {
    enter_email_address("");
    click_on_submit_button();
    empty_email_error_message_is_correct();
  }

  @StepGroup
  public void submit_with_incorrect_email_address(String incorrectEmail) {
    enter_email_address(incorrectEmail);
    click_on_submit_button();
    incorrect_email_error_message_is_correct();
  }

  @StepGroup
  public void submit_data_without_salutation() {
    click_on_submit_button();
    not_selected_salutation_error_message_is_correct();
  }

  @StepGroup
  public void submit_data_with_empty_first_name() {
    click_on_submit_button();
    enter_last_name("test");
    first_last_name_error_message_is_correct();
  }

  @StepGroup
  public void submit_data_with_empty_last_name() {
    click_on_submit_button();
    enter_first_name("test");
    first_last_name_error_message_is_correct();
  }

  @StepGroup
  public void submit_without_birthday() {
    unselect_birthday_fields();
    click_on_submit_button();
    not_selected_birthday_error_message_is_correct();
  }

  @StepGroup
  public void submit_without_birthday_day() {
    unselect_birthday_fields();
    select_birth_month_by_index(1);
    select_birthday_year_by_index(1);
    click_on_submit_button();
    not_selected_birthday_error_message_is_correct();
  }

  @StepGroup
  public void submit_without_birthday_month() {
    unselect_birthday_fields();
    select_birthday_day_by_index(1);
    select_birthday_year_by_index(1);
    click_on_submit_button();
    not_selected_birthday_error_message_is_correct();
  }

  @StepGroup
  public void submit_without_birthday_year() {
    unselect_birthday_fields();
    select_birthday_day_by_index(1);
    select_birth_month_by_index(1);
    click_on_submit_button();
    not_selected_birthday_error_message_is_correct();
  }

  @StepGroup
  public void submit_with_not_allowed_age() {
    unselect_birthday_fields();
    select_birthday_year_by_index(1);
    select_birth_month_by_index(12);
    select_birthday_day_by_index(31);
    click_on_submit_button();
    minimum_age_error_message_is_correct();
  }

  @StepGroup
  public void submit_with_not_allowed_age_current_month() {
    unselect_birthday_fields();
    Calendar date = Calendar.getInstance();
    date.add(Calendar.YEAR, -18);
    date.add(Calendar.DAY_OF_MONTH, 1);

    int birth_day = date.get(Calendar.DAY_OF_MONTH);
    String birth_month_name = new SimpleDateFormat("LLLL", Locale.GERMANY).format(date.getTime());
    int birth_year = date.get(Calendar.YEAR);

    select_birthday_day_by_value(String.format("%02d", birth_day));
    select_birthday_month_by_value(birth_month_name);
    select_birth_year_by_value(String.valueOf(birth_year));

    click_on_submit_button();
    minimum_age_error_message_is_correct();
  }

  @StepGroup
  public void submit_with_incorrect_phone_number(String phoneNumber) {
    enter_phone_number(phoneNumber);
    click_on_submit_button();
    phone_number_error_message_is_correct();
  }

  @StepGroup
  public void submit_data_with_empty_postal_code() {
    click_on_submit_button();
    postal_code_error_message_is_correct();
  }

  @StepGroup
  public void submit_data_with_incorrect_postal_code_short_digit(String shortDigitPostalCode) {
    enter_postal_code(shortDigitPostalCode);
    click_on_submit_button();
    postal_code_error_message_is_correct();
  }

  @StepGroup
  public void submit_data_with_incorrect_postal_code_long_digit(String longDigitPostalCode) {
    enter_postal_code(longDigitPostalCode);
    click_on_submit_button();
    postal_code_error_message_is_correct();
  }

  @StepGroup
  public void submit_data_with_incorrect_postal_code_not_digit(String notDigitPostalCode) {
    enter_postal_code(notDigitPostalCode);
    click_on_submit_button();
    postal_code_error_message_is_correct();
  }

  @StepGroup
  public void submit_data_with_empty_city_name() {
    click_on_submit_button();
    city_name_error_message_is_correct();
  }

  @StepGroup
  public void submit_data_with_empty_street_name() {
    click_on_submit_button();
    street_house_number_error_message_is_correct();
  }

  @StepGroup
  public void submit_data_with_empty_house_number() {
    click_on_submit_button();
    street_house_number_error_message_is_correct();
  }

}
