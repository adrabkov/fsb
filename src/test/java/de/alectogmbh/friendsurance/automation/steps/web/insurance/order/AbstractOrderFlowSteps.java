package de.alectogmbh.friendsurance.automation.steps.web.insurance.order;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.AbstractOrderFlowPage;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.Step1Page;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.Step2Page;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.SuccessPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import de.alectogmbh.friendsurance.automation.steps.web.utils.InsuranceData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

public abstract class AbstractOrderFlowSteps<T extends AbstractOrderFlowPage>
    extends AbstractScenarioSteps<T> {

  @Steps
  private de.alectogmbh.friendsurance.automation.steps.web.insurance.order.upgrade.step1.Step1Steps
      step1StepsUpgrade;

  @Steps
  private Step2Steps step2Steps;

  @Steps
  private Step3Steps step3Steps;

  protected AbstractOrderFlowSteps() {
  }

  protected AbstractOrderFlowSteps(Pages pages) {
    super(pages);
  }

  public void click_step2_link() {
    getPageObject().clickStep2Link();
  }

  public void click_step3_link() {
    getPageObject().clickStep3Link();
  }

  @Step
  public void go_to_upgrade_success_page(CustomerData data, InsuranceData insuranceData) {
    step1StepsUpgrade.enter_all_upgrade(insuranceData);
    step1StepsUpgrade.click_submit_button();
    step2Steps.submit_with_correct_data_new_user(data);
    step3Steps.checkout();
    step3Steps.wait_for_loading_icon_appear_and_disappear();
    check_upgrade_success_page_loaded();
  }

  @Step
  public void go_to_upgrade_success_page_registered_user(CustomerData data,
                                                         InsuranceData insuranceData) {
    step1StepsUpgrade.enter_all_upgrade(insuranceData);
    step1StepsUpgrade.click_submit_button();
    step2Steps.submit_with_correct_data_old_user(data);
    step3Steps.checkout();
    step3Steps.wait_for_loading_icon_appear_and_disappear();
    check_upgrade_success_page_loaded();
  }

  @Step
  public void check_upgrade_index_page_loaded() {
    ValidationUtils.checkCorrectPageLoaded(
        Step1Page.DEFAULT_URL_UPGRADE,
        getPageObject().getCurrentPageUrl()
    );
  }

  @Step
  public void check_upgrade_contact_page_loaded() {
    ValidationUtils.checkCorrectPageLoaded(Step2Page.DEFAULT_URL_UPGRADE,
        getPageObject().getCurrentPageUrl());
  }

  @Step
  public void check_upgrade_success_page_loaded() {
    ValidationUtils.checkCorrectPageLoaded(SuccessPage.DEFAULT_URL_UPGRADE,
        getPageObject().getCurrentPageUrl());
  }

}
