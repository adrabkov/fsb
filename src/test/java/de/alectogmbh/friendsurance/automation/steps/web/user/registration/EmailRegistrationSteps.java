package de.alectogmbh.friendsurance.automation.steps.web.user.registration;

import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

public class EmailRegistrationSteps extends AbstractRegistrationSteps {

  private String emailExistsMessage;

  public EmailRegistrationSteps() {
  }

  public EmailRegistrationSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void enter_email_address(String email) {
    getPageObject().enter_email(email);
  }

  @Step
  public void already_existing_email_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage("Sie sind bereits registriert, hier geht's zum Login.",
        getPageObject().get_email_already_exists_error_message()
    );
  }

  @Step
  public void enter_password(String password) {
    getPageObject().enter_password(password);
  }

  @Step
  public void enter_password_verify(String passwordVerify) {
    getPageObject().enter_password_verify(passwordVerify);
  }

  @Step
  public void enter_first_name(String firstName) {
    getPageObject().enter_first_name(firstName);
  }

  @Step
  public void enter_last_name(String lastName) {
    getPageObject().enter_last_name(lastName);
  }

  @Step
  public void accept_terms_and_conditions(boolean acceptTermsAndConditions) {
    if (acceptTermsAndConditions) {
      accept_terms_and_conditions();
    } else {
      reject_terms_and_conditions();
    }
  }

  @Step
  public void accept_terms_and_conditions() {
    getPageObject().check_terms_and_conditions_check_box();
  }

  @Step
  public void reject_terms_and_conditions() {
    getPageObject().uncheck_terms_and_conditions_check_box();
  }

  @Step
  public void submit_registration_form() {
    getPageObject().click_submit_button();
  }

  @StepGroup
  public void register_user(CustomerData userData) {
    fillUserData(userData);
    submit_registration_form();
    getPageObject().waitForAbsenceOf("//*[@id = 'but-register']");
  }

  public void fillUserData(CustomerData userData) {
    open_page();
    if (userData.getEmail() != null) {
      enter_email_address(userData.getEmail());
    }
    if (userData.getPassword() != null) {
      enter_password(userData.getPassword());
    }
    if (userData.getPasswordVerify() != null) {
      enter_password_verify(userData.getPasswordVerify());
    }
    if (userData.getFirstName() != null) {
      enter_first_name(userData.getFirstName());
    }
    if (userData.getLastName() != null) {
      enter_last_name(userData.getLastName());
    }
    accept_terms_and_conditions(userData.getAcceptLegals());
  }

}
