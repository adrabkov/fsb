package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.verification;


import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.verification.ElectronicInsuranceVerificationPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.testdata.UserTestDataHelper;
import net.thucydides.core.annotations.Step;

public class ElectronicInsuranceVerificationSteps
    extends AbstractScenarioSteps<ElectronicInsuranceVerificationPage> {

  private ElectronicInsuranceVerificationPage electronicInsuranceVerificationPage;

  public ElectronicInsuranceVerificationPage getPageObject() {
    return electronicInsuranceVerificationPage;
  }

  @Step
  public void set_verification_code_for_user(String email) {
    String code = UserTestDataHelper.getVerificationCodeForUser(email);
    getPageObject().setActivationCode(code);
  }

  @Step
  public void click_on_send_verification_code() {
    getPageObject().clickOnSendActivationCode();
  }

  @Step
  public void wait_for_button_disappear() {
    getPageObject().waitUntilButtonIsNotVisble();
  }

}
