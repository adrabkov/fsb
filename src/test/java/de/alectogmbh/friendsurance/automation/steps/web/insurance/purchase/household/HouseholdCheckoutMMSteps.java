package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.household;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.checkout.household.HouseholdCheckoutMMPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class HouseholdCheckoutMMSteps extends AbstractScenarioSteps<HouseholdCheckoutMMPage> {

  private HouseholdCheckoutMMPage householdCheckoutMMPage;

  @Step
  public void select_salutation(String salutation) {
    switch (salutation) {
      case "MALE":
        getPageObject().selectSalutationByIndex(0);
        break;
      case "FEMALE":
        getPageObject().selectSalutationByIndex(1);
        break;
      default:
        break;
    }
  }

  @Step
  public void enter_title(String title) {
    getPageObject().enterTitle(title);
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
  public void enter_postal_code(String postalCode) {
    getPageObject().enterPostalCode(postalCode);
  }

  @Step
  public void enter_street(String street) {
    getPageObject().enterStreet(street);
  }

  @Step
  public void enter_house_number(String houseNumber) {
    getPageObject().enterHouseNumber(houseNumber);
  }

  @Step
  public void enter_phone_number(String phoneNumber) {
    getPageObject().enterPhoneNumber(phoneNumber);
  }

  @Step
  public void enter_fax(String faxNumber) {
    getPageObject().enterFax(faxNumber);
  }

  @Step
  public void enter_email(String email) {
    getPageObject().enterEmail(email);
  }

  @Step
  public void enter_profession(String profession) {
    getPageObject().enterProfession(profession);
  }

  @Step
  public void enter_birth_date(String birthDate) {
    getPageObject().enterBirthDate(birthDate);
  }

  @Step
  public void select_family_status(String familyStatus) {
    switch (familyStatus) {
      case "Single":
        getPageObject().selectFamilyStatusByIndex(0);
        break;
      case "Divorced":
        getPageObject().selectFamilyStatusByIndex(1);
        break;
      case "Separated":
        getPageObject().selectFamilyStatusByIndex(2);
        break;
      case "Widowed":
        getPageObject().selectFamilyStatusByIndex(3);
        break;
      default:
        break;
    }
  }

  @Step
  public void select_payment_intervall() {
    getPageObject().selectPaymentIntervall(0);
  }

  @Step
  public void select_payment_type() {
    getPageObject().selectPaymentType(0);
  }

  @Step
  public void enter_iban(String iban) {
    getPageObject().enterIban(iban);
  }

  @Step
  public void select_sepa_agreement() {
    getPageObject().selectSepaAgreement();
  }

  @Step
  public void select_orders_refused(int refused) {
    getPageObject().selectOrdersRefused(refused);
  }

  @Step
  public void select_check_offer() {
    getPageObject().selectCheckOffer();
  }

  @Step
  public void select_check_privacy_protection() {
    getPageObject().selectCheckPrivacyProtection();
  }

  @Step
  public void click_buy_button() {
    getPageObject().clickBuyButton();
  }

  @Step
  public void click_next_button() {
    getPageObject().clickNextButton();
  }

  @Step
  public void check_success_page() {
    getPageObject().waitForPresenceOf(
        "//*[text() = 'Bonus sichern' or text() = 'Versicherung abschließen']");
    ValidationUtils.checkCorrectPageLoaded("/success/", getPageObject().getCurrentPageUrl());
  }

  @StepGroup
  public void enter_first_page(CustomerData data) {
    select_salutation(data.getGender());
    enter_title(data.getTitle());
    enter_first_name(data.getFirstName());
    enter_last_name(data.getLastName());
    enter_street(data.getStreet());
    enter_house_number(data.getHouseNumber());
    enter_phone_number(data.getPhoneNumber());
    enter_fax(data.getFaxNumber());
    enter_email(data.getEmail());
    enter_profession(data.getProfession());
    enter_birth_date(data.getBirthDay() + "." + data.getBirthMonth() + "." + data.getBirthYear());
    select_family_status(data.getFamilyStatus());
    click_next_button();
  }

  @StepGroup
  public void enter_second_page(CustomerData data) {
    select_payment_intervall();
    select_payment_type();
    enter_iban(data.getIban());
    select_sepa_agreement();
    select_orders_refused(0);
    click_next_button();
  }

  @StepGroup
  public void enter_third_page() {
    select_check_offer();
    select_check_privacy_protection();
    click_buy_button();
  }

  @StepGroup
  public void fill_complete_checkout_form(CustomerData data) {
    enter_first_page(data);
    enter_second_page(data);
    enter_third_page();
  }

  @Override
  public HouseholdCheckoutMMPage getPageObject() {
    return householdCheckoutMMPage;
  }
}