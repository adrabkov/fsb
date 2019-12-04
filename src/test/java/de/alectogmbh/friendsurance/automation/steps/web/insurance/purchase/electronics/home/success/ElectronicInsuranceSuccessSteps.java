package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.success;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.invitation.ElectronicInsuranceInvitationPage;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.success.ElectronicInsuranceSuccessPage;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.xselling.ElectronicInsuranceXsellingPage;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.AbstractElectronicInsurancePurchaseSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class ElectronicInsuranceSuccessSteps extends AbstractElectronicInsurancePurchaseSteps {

  private ElectronicInsuranceSuccessPage electronicInsuranceSuccessPage;

  @Step
  public void click_xselling_button() {
    getPageObject().clickCrossSellingButton();
  }

  @Step
  public void click_goto_invitation_button() {
    getPageObject().clickGoToInvitation();
  }

  @Step
  public void check_xselling_button_link_is_correct() {
    ValidationUtils.checkLinkIsCorrect(ElectronicInsuranceXsellingPage.DEFAULT_URL,
        getPageObject().getXsellingHref());
  }

  @Step
  public void check_invitation_button_link_is_correct() {
    ValidationUtils.checkLinkIsCorrect(ElectronicInsuranceInvitationPage.DEFAULT_URL,
        getPageObject().getInvitationHref());
  }

  @StepGroup
  public void check_button_links() {
    check_invitation_button_link_is_correct();
    check_xselling_button_link_is_correct();
  }

  @Override
  protected ElectronicInsuranceSuccessPage getPageObject() {
    return electronicInsuranceSuccessPage;
  }
}
