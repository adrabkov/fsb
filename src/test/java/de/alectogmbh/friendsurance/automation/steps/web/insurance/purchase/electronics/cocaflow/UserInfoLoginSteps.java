package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.UserInfoLoginCocaFlowPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class UserInfoLoginSteps extends AbstractCocaFlowScenarioSteps<UserInfoLoginCocaFlowPage> {

  private UserInfoLoginCocaFlowPage userInfoLoginCocaFlowPage;

  @Step
  public void enter_user_login_email(String email) {
    getPageObject().enterLoginUserName(email);
  }

  @Step
  public void enter_user_login_password(String password) {
    getPageObject().enterPassword(password);
  }

  @StepGroup
  public void login_user(String email, String password) {
    enter_user_login_email(email);
    enter_user_login_password(password);
    click_on_continue_button();
  }

  @Override
  protected UserInfoLoginCocaFlowPage getPageObject() {
    return userInfoLoginCocaFlowPage;
  }

}
