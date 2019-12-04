package de.alectogmbh.friendsurance.automation.steps.web.user.settings;

import de.alectogmbh.friendsurance.automation.pages.web.user.SettingsPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

public class SettingsSteps extends AbstractScenarioSteps<SettingsPage> {

  private SettingsPage settingsPage;

  public SettingsSteps() {
  }

  public SettingsSteps(Pages pages) {
    super(pages);
  }


  @Step
  public void reject_newsletter() {
    getPageObject().rejectNewsletterCheckbox();
  }

  @Step
  public void accept_contact_via_phone() {
    getPageObject().acceptContactViaPhoneCheckbox();
  }

  @Step
  public void reject_receive_info() {
    getPageObject().rejectReceiveInfoCheckbox();
  }

  @Step
  public void submit_settings_changes() {
    getPageObject().submitChanges();
  }

  @Step
  public void open_section_my_profile() {
    getPageObject().openMyProfileSection();
  }

  @Step
  public void select_my_profile_female() {
    getPageObject().selectMyProfileFemale();
  }

  @Step
  public void select_my_profile_male() {
    getPageObject().selectMyProfileMale();
  }

  @Step
  public void submit_my_profile_changes() {
    getPageObject().submitMyProfileChanges();
  }

  @Step
  public void enter_my_profile_mobile_number(String mobileNumber) {
    getPageObject().enterMyProfileMobileNumber(mobileNumber);
  }

  @Step
  public void enter_my_profile_phone_number(String phoneNumber) {
    getPageObject().enterMyProfilePhoneNumber(phoneNumber);
  }

  @Step
  public void enter_my_profile_birthdate(String profileBirthDate) {
    getPageObject().enterMyProfileBirthday(profileBirthDate);
  }

  @Step
  public String get_myprofile_mobile_number() {
    return getPageObject().getMyProfileMobileNumber();
  }

  @Step
  public String get_myprofile_phone_number() {
    return getPageObject().getMyProfilePhoneNumber();
  }

  @Step
  public String get_myprofile_birthdate() {
    return getPageObject().getMyProfileBirthdate();
  }

  @Step
  public void save_new_password() {
    getPageObject().save_new_password();
  }

  @Step
  public void enter_new_password_verify(String newPassword) {
    getPageObject().enter_new_password_verify(newPassword);
  }

  @Step
  public void enter_new_password(String newPassword) {
    getPageObject().enter_new_password(newPassword);
  }

  @Step
  public void enter_old_password(String oldPassword) {
    getPageObject().enter_old_password(oldPassword);
  }

  @Step
  public void open_section_access_data() {
    getPageObject().clickAccessDataLink();
  }

  @Step
  public void open_section_settings_data() {
    getPageObject().openSettingsView();
  }

  @Step
  public Boolean is_settings_phone_saved_correct() {
    return getPageObject().isContactViaPhoneCheckboxSelected();
  }

  @Step
  public Boolean is_settings_newsletter_saved_correct() {
    return getPageObject().isNewsletterCheckboxSelected();
  }

  @Step
  public Boolean is_settings_info_saved_correct() {
    return getPageObject().isReceiveInfoCheckboxSelected();
  }

  @Step
  public void click_menu_logout() {
    getPageObject().getMyFriendsuranceMenu().clickOnLogOutMenu();
  }

  @StepGroup
  public void change_password(String oldPassword, String newPassword) {
    enter_old_password(oldPassword);
    enter_new_password(newPassword);
    enter_new_password_verify(newPassword);
  }

  @Override
  protected SettingsPage getPageObject() {
    return settingsPage;
  }
}
