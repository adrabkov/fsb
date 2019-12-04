package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.UserInfoPersonalDataCocaFlowPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import java.util.Calendar;
import java.util.Date;

import static de.alectogmbh.friendsurance.common.util.DateUtil.formatDate;

public class UserInfoPersonalDataSteps extends AbstractCocaFlowScenarioSteps<UserInfoPersonalDataCocaFlowPage> {

  private static final int YEARS = 19;

  private UserInfoPersonalDataCocaFlowPage userInfoPersonalDataPage;

  @Step
  public void enter_login_email_address(String email) {
    getPageObject().enterEmailAddress(email);
  }

  @Step
  public void enter_phone_number() {
    getPageObject().enterPhoneNumber("012345678");
  }

  @Step
  public void enter_user_birth_day() {
    getPageObject().enterUserBirthDay(formatDate(calculate_birthdate(), "dd"));
  }

  @Step
  public void enter_user_birth_month() {
    getPageObject().enterUserBirthMonth(formatDate(calculate_birthdate(), "MM"));
  }

  @Step
  public void enter_user_birth_year() {
    getPageObject().enterUserBirthYear(formatDate(calculate_birthdate(), "yyyy"));
  }

  public Date calculate_birthdate() {
    Calendar calendar = Calendar.getInstance();
    calendar.get(Calendar.YEAR);
    calendar.add(Calendar.YEAR, -YEARS);
    return calendar.getTime();
  }

  @StepGroup
  public void fill_user_personal_data_form(String email) {
    enter_login_email_address(email);
    enter_phone_number();
    enter_user_birth_day();
    enter_user_birth_month();
    enter_user_birth_year();
    click_on_continue_button();
  }

  @StepGroup
  public void fill_user_personal_data_form_for_existing_user_with_incomplete_personal_data() {
    enter_phone_number();
    enter_user_birth_day();
    enter_user_birth_month();
    enter_user_birth_year();
    click_on_continue_button();
  }

  @Override
  protected UserInfoPersonalDataCocaFlowPage getPageObject() {
    return userInfoPersonalDataPage;
  }

}
