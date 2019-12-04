package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.UserInfoLandingCocaFlowPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class UserInfoLandingSteps extends AbstractCocaFlowScenarioSteps<UserInfoLandingCocaFlowPage> {

  private UserInfoLandingCocaFlowPage userInfoLandingPage;

  @Step
  public void click_on_login_link() {
    getPageObject().clickOnLoginLink();
  }

  @StepGroup
  public void open_user_info_landing_page_and_click_on_login_link() {
    click_on_login_link();
  }

  @StepGroup
  public void open_user_info_landing_page_and_click_on_continue_button() {
    click_on_continue_button();
  }

  @Override
  protected UserInfoLandingCocaFlowPage getPageObject() {
    return userInfoLandingPage;
  }
}
