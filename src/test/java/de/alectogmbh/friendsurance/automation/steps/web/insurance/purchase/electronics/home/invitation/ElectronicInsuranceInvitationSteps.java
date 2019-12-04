package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.invitation;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.invitation.ElectronicInsuranceInvitationPage;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.AbstractElectronicInsurancePurchaseSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;


public class ElectronicInsuranceInvitationSteps extends AbstractElectronicInsurancePurchaseSteps {

  private ElectronicInsuranceInvitationPage electronicInsuranceInvitationPage;

  @Step
  public void skip_electronics_invitation_page() {
    getPageObject().skipInvitationPage();
  }

  @Step
  public void close_network_survey_modal() {
    getPageObject().clickNetworkSurveyCloseButton();
  }

  @Step
  public void close_user_survey_modal() {
    getPageObject().clickUserSurveyCloseButton();
    getPageObject().waitForAbsenceOf("//*[contains(@class,'modal-backdrop')]");
  }

  @Step
  public void go_to_dashboard_after_purchase() {
    getPageObject().clickGoToDashboardButton();
  }

  @Step
  public void invitation_page_passed_successful() {
    getPageObject().waitFor("//*[@id = 'insuranceSection']");
    ValidationUtils.checkCorrectPageLoaded("dashboard", getPageObject().getCurrentPageUrl());
  }

  @StepGroup
  public void skip_network_and_bonus_pages_for_new_users() {
    skip_electronics_invitation_page();
    close_network_survey_modal();
    close_user_survey_modal();
    go_to_dashboard_after_purchase();
    invitation_page_passed_successful();
  }

  @Override
  protected ElectronicInsuranceInvitationPage getPageObject() {
    return electronicInsuranceInvitationPage;
  }

}
