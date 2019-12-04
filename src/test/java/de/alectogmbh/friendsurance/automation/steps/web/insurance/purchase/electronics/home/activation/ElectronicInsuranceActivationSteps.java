package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.activation;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.activation.ElectronicsInsuranceActivationPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.AbstractElectronicInsurancePurchaseSteps;
import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import de.alectogmbh.friendsurance.automation.steps.web.utils.InsuranceData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

public class ElectronicInsuranceActivationSteps extends AbstractElectronicInsurancePurchaseSteps {

  private ElectronicsInsuranceActivationPage electronicsInsuranceActivationPage;

  public ElectronicInsuranceActivationSteps(Pages pages) {
  }

  @Step
  public void enter_IMEI(String imei) {
    getPageObject().enterImei(imei);
  }

  @Step
  public void enter_price(String price) {
    getPageObject().enterPrice(price);
  }

  @Step
  public void enter_phone_number(String phoneNumber) {
    getPageObject().enterPhone(phoneNumber);
  }

  @Step
  public void enter_manufacturer(String manufacturer) {
    getPageObject().enterManufacturer(manufacturer);
  }

  @Step
  public void enter_model(String model) {
    getPageObject().enterModel(model);
  }

  @Step
  public void select_gender(String gender) {
    switch (gender) {
      case "MALE":
        getPageObject().selectGender("male");
        break;
      case "FEMALE":
        getPageObject().selectGender("female");
        break;
      case "nogender":
        getPageObject().selectGender("nogender");
        break;
    }
  }

  @Step
  public void select_birth_day(String birthDay) {
    getPageObject().selectBirthdayDay(birthDay);
  }

  @Step
  public void select_birth_month(int birthMonth) {
    getPageObject().selectBirthdayMonth(birthMonth);
  }

  @Step
  public void select_birth_year(String birthYear) {
    getPageObject().selectBirthdayYear(birthYear);
  }

  @Step
  public void enter_postal_code(String postalCode) {
    getPageObject().enterPostalCode(postalCode);
  }

  @Step
  public void select_city(String city) {
    getPageObject().selectCity(city);
  }

  @Step
  public void select_street(String street) {
    getPageObject().selectStreet(street);
  }

  @Step
  public void enter_house_number(String houseNumber) {
    getPageObject().enterHouseNr(houseNumber);
  }

  @Step
  public void select_accept_special(Boolean acceptSpecial) {
    getPageObject().setConfirmSpecialInfo(acceptSpecial);
  }

  @Step
  public void select_accept_phone(Boolean acceptPhone) {
    getPageObject().setConfirmContactViaPhone(acceptPhone);
  }

  @Step
  public void click_submit_button() {
    getPageObject().clickSubmitButton();
  }

  @StepGroup
  public void fill_out_activation_form_mobile(CustomerData cData, InsuranceData iData) {
    enter_price(iData.getDevicePrice());
    enter_IMEI(iData.getIMEI());
    enter_phone_number(cData.getPhoneNumber());
    enter_manufacturer(iData.getManufacturer());
    enter_model(iData.getModel());
    select_gender(cData.getGender());
    select_birth_day(cData.getBirthDay());
    select_birth_month(cData.getBirthMonth());
    select_birth_year(cData.getBirthYear());
    enter_postal_code(cData.getPostalCode());
    select_city(cData.getCity());
    select_street(cData.getStreet());
    enter_house_number(cData.getHouseNumber());
    select_accept_special(cData.getAcceptSpecial());
    select_accept_phone(cData.getAcceptPhoneOptIn());
  }

  protected ElectronicsInsuranceActivationPage getPageObject() {
    return electronicsInsuranceActivationPage;
  }
}
