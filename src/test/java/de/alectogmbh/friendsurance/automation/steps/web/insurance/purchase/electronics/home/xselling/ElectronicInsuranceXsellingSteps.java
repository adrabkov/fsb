package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.xselling;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.invitation.ElectronicInsuranceInvitationPage;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.purchase.xselling.ElectronicInsuranceXsellingPage;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.home.AbstractElectronicInsurancePurchaseSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class ElectronicInsuranceXsellingSteps extends AbstractElectronicInsurancePurchaseSteps {

  private ElectronicInsuranceXsellingPage electronicInsuranceXsellingPage;

  @Step
  public void click_invitation_button() {
    getPageObject().clickInvitationButton();
  }

  @Step
  public void check_upgrade_button_link_is_correct() {
    ValidationUtils
        .checkLinkIsCorrect("/check", getPageObject().getUpgradeHref());
  }

  @Step
  public void check_invitation_button_link_is_correct() {
    ValidationUtils.checkLinkIsCorrect(ElectronicInsuranceInvitationPage.DEFAULT_URL,
        getPageObject().getInvitationHref());
  }

  @StepGroup
  public void check_button_links_are_correct() {
    check_invitation_button_link_is_correct();
    check_upgrade_button_link_is_correct();
  }

  protected ElectronicInsuranceXsellingPage getPageObject() {
    return electronicInsuranceXsellingPage;
  }
}
