package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.checkout;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.checkout.ElectronicsInsuranceCheckoutPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import de.alectogmbh.friendsurance.automation.steps.web.utils.InsuranceData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

public class ElectronicInsuranceCheckoutSteps
    extends AbstractScenarioSteps<ElectronicsInsuranceCheckoutPage> {

  private ElectronicsInsuranceCheckoutPage electronicsInsuranceCheckoutPage;

  public ElectronicInsuranceCheckoutSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void click_on_new_user_button() {
    getPageObject().selectNewUser();
  }

  @Step
  public void click_on_already_registered_button() {
    getPageObject().selectOldUser();
  }

  @Step
  public void enter_purchase_day(String purchaseDay) {
    getPageObject().selectPurchaseDay(purchaseDay);
  }

  @Step
  public void enter_purchase_month(int purchaseMonth) {
    getPageObject().selectPurchaseMonth(purchaseMonth);
  }

  @Step
  public void enter_purchase_year(String purchaseYear) {
    getPageObject().selectPurchaseYear(purchaseYear);
  }

  @Step
  public void enter_email_address(String emailAddress) {
    getPageObject().enterEmailAddress(emailAddress);
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
  public void check_accept_legal_checkbox() {
    getPageObject().checkLegalCheckbox();
  }

  @Step
  public void un_check_accept_legal_checkbox() {
    getPageObject().unCheckLegalCheckbox();
  }

  @Step
  public void click_on_submit_button() {
    getPageObject().clickOnSubmitButton();
  }

  @Step
  public void accept_legal_condition(boolean legalAccepted) {
    if (legalAccepted) {
      check_accept_legal_checkbox();
    } else {
      un_check_accept_legal_checkbox();
    }
  }

  @StepGroup
  public void checkout_insurance(CustomerData checkoutData, InsuranceData insuranceData) {
    electronicsInsuranceCheckoutPage.open();
    if (checkoutData.getIsNewUser()) {
      click_on_new_user_button();
    } else {
      click_on_already_registered_button();
    }

    enter_purchase_day(insuranceData.getPurchaseDay());
    enter_purchase_month(insuranceData.getPurchaseMonth());
    enter_purchase_year(insuranceData.getPurchaseYear());

    if (checkoutData.getEmail() != null) {
      enter_email_address(checkoutData.getEmail());
    }

    if (checkoutData.getFirstName() != null) {
      enter_first_name(checkoutData.getFirstName());
    }

    if (checkoutData.getLastName() != null) {
      enter_last_name(checkoutData.getLastName());
    }

    accept_legal_condition(checkoutData.getAcceptLegals());

    click_on_submit_button();
  }

  @Override
  protected ElectronicsInsuranceCheckoutPage getPageObject() {
    return electronicsInsuranceCheckoutPage;
  }
}
