package de.alectogmbh.friendsurance.automation.steps.web.insurance.order.tarifcheck;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.tarifcheck.*;
import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import de.alectogmbh.friendsurance.automation.testdata.OrderTestDataHelper;
import de.alectogmbh.friendsurance.order.OrderItem;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import java.util.List;


public class TarifCheckSteps extends ScenarioSteps {

  private TarifCheckIndexPage tarifCheckIndexPage;
  private TarifCheckUserPage tarifCheckUserPage;
  private TarifCheckInsurancePage tarifCheckInsurancePage;
  private TariffCheckBrokeragePage tariffCheckBrokeragePage;
  private TarifCheckContactEmailPage tarifCheckContactEmailPage;
  private TarifCheckContactAddressPage tarifCheckContactAddressPage;
  private TarifCheckContactBirthdatePage tarifCheckContactBirthdatePage;
  private TarifCheckCheckoutPage tarifCheckCheckoutPage;
  private TarifCheckSummaryPage tarifCheckSummaryPage;

  public final static String UNFALL = "Unfall";
  public final static String WOHN_GEBAUDE = "Wohn-/Gebäude";
  public final static String ALTERSVORSORGE = "Altersvorsorge";
  public final static String GLAS = "Glas";
  private final static int SIGN_ITEARTION = 5;

  private CustomerData customerData;

  public void setCustomerData(CustomerData data) {
    customerData = data;
  }

  public CustomerData getCustomerData() {
    return customerData;
  }

  @Step
  public void open_index_page() {
    tarifCheckIndexPage.open();
  }

  @Step
  public void click_on_next_button() {
    tarifCheckIndexPage.clickOnNextButton();
  }

  @Step
  public void set_first_name() {
    tarifCheckUserPage.setFirstName(customerData.getFirstName());
  }

  @Step
  public void set_last_name() {
    tarifCheckUserPage.setLastName(customerData.getLastName());
  }

  @Step
  public void select_female() {
    tarifCheckUserPage.selectFemale();
  }

  @Step
  public void select_male() {
    tarifCheckUserPage.selectMale();
  }

  @Step
  public void select_incurance_type(String name) {
    tarifCheckInsurancePage.setInsuranceCompany(name);
  }

  @Step
  public void select_policy_number(String number) {
    tarifCheckInsurancePage.setPolicyNumber(number);
  }

  @Step
  public void click_on_cancel_button() {
    tarifCheckInsurancePage.clickOnCancel();
  }

  @Step
  public void toggle_insurance_type(boolean select, String name) {

    tariffCheckBrokeragePage.toggleInsuranceType(select, name);

  }

  @Step
  public void click_on_plus_button() {
    tariffCheckBrokeragePage.clickOnPlusButton();
  }

  @Step
  public void enter_email() {
    tarifCheckContactEmailPage.setEmail(customerData.getEmail());
  }

  @Step
  public void enter_phone() {
    tarifCheckContactEmailPage.setPhone(customerData.getPhoneNumber());
  }

  @Step
  public void enter_postal_code() {
    tarifCheckContactAddressPage.setPostalCode(customerData.getPostalCode());
  }

  @Step
  public void enter_city() {
    tarifCheckContactAddressPage.setCity(getCustomerData().getCity());
  }

  @Step
  public void enter_street() {
    tarifCheckContactAddressPage.setStreet(getCustomerData().getStreet());
  }

  @Step
  public void enter_house_number() {
    tarifCheckContactAddressPage.setHousNumber(customerData.getHouseNumber());
  }

  @Step
  public void select_day() {
    tarifCheckContactBirthdatePage.selectDay(customerData.getBirthDay());
  }

  @Step
  public void select_month() {
    tarifCheckContactBirthdatePage.selectMonth(customerData.getBirthMonthString().substring(0,3));
  }

  @Step
  public void select_year() {
    tarifCheckContactBirthdatePage.selectYear(customerData.getBirthYear());
  }

  @Step
  public void sign_the_order() {
    tarifCheckCheckoutPage.sign(SIGN_ITEARTION);
  }

  @Step
  public void click_on_sumbit() {
    tarifCheckCheckoutPage.clickOnSubmit();
  }

  @Step
  public void check_if_correct_order_count_is_shown_in_summary_page(int expected) {
    Assert.assertEquals(expected + " order items should be shown",
        expected, tarifCheckSummaryPage.getSummaryElements().size());
  }

  @Step("Check if orders are created with correct policy numbers. Policy numbers are set to coresponding insurance types from test")
  public void check_if_order_created_with_correct_policy_numbers(int expected) {

    List<OrderItem> orders = OrderTestDataHelper.getOrderItemsForUser(customerData.getEmail());
    Assert.assertNotNull(orders);
    Assert.assertEquals("User should have " + expected + " orders", expected, orders.size());

    for (OrderItem orderItem : orders) {
      Assert.assertEquals("Wrong policy number", orderItem.getInsuranceCategory().toString(),
          orderItem.getPolicyNumber());
    }
  }

  @StepGroup
  public void select_insurance_and_click_next(String name, String number) {
    select_incurance_type(name);
    select_policy_number(number);
    click_on_next_button();
  }

  @StepGroup
  public void enter_email_phone_and_click_next() {
    enter_email();
    enter_phone();
    selectOptIn();
    click_on_next_button();
  }

  private void selectOptIn() {
    tarifCheckContactEmailPage.selectOptIn();
  }

  @StepGroup
  public void set_user_credentials_click_next() {
    set_first_name();
    set_last_name();
    if (customerData.getGender().equals("MALE")) {
      select_male();
    } else {
      select_female();
    }
    click_on_next_button();
  }

  @StepGroup
  public void set_address_and_click_next() {
    enter_postal_code();
    enter_city();
    enter_street();
    enter_house_number();
    click_on_next_button();
  }

  @StepGroup
  public void set_birthdate_and_click_next() {
    select_day();
    select_month();
    select_year();
    click_on_next_button();
  }

}

