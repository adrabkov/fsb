package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.ChooseBrandAndModelCocaFlowPageObject;
import de.alectogmbh.friendsurance.common.util.DateUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import java.util.Calendar;
import java.util.Date;

public class ChooseBrandAndModelSteps extends AbstractCocaFlowScenarioSteps<ChooseBrandAndModelCocaFlowPageObject> {

  private ChooseBrandAndModelCocaFlowPageObject chooseBrandAndModelPage;

  @Step
  public void open_choose_brand_and_model_page() {
    getPageObject().open();
  }

  @Step
  public void provide_device_maker_and_device_model_data() {
    getPageObject().clickOnAnotherMakerCheckbox();
    getPageObject().enterDeviceMaker("Apple");
    getPageObject().enterDeviceModel("iPhone XS - 64GB");
  }

  @Step
  public void enter_device_IMEI() {
    getPageObject().enterIMEINumber("333333333333337");
  }

  @Step
  public void enter_device_purchase_price() {
    getPageObject().enterDevicePurchasePrice("999,99");
  }

  @Step
  public void enter_device_purchase_day() {
    getPageObject().enterDevicePurchaseDay(DateUtil.formatDate(get_device_purchase_date(), "dd"));
  }

  @Step
  public void enter_device_purchase_month() {
    getPageObject().enterDevicePurchaseMonth(DateUtil.formatDate(get_device_purchase_date(), "MM"));
  }

  @Step
  public void enter_device_purchase_year() {
    getPageObject().enterDevicePurchaseYear(DateUtil.formatDate(get_device_purchase_date(), "yyyy"));
  }

  public Date get_device_purchase_date() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_YEAR, -1);
    return calendar.getTime();
  }

  @StepGroup
  public void fill_choose_brand_and_model_form() {
    open_choose_brand_and_model_page();
    provide_device_maker_and_device_model_data();
    enter_device_IMEI();
    enter_device_purchase_price();
    enter_device_purchase_day();
    enter_device_purchase_month();
    enter_device_purchase_year();
    click_on_continue_button();
  }

  @Override
  protected ChooseBrandAndModelCocaFlowPageObject getPageObject() {
    return chooseBrandAndModelPage;
  }

}
