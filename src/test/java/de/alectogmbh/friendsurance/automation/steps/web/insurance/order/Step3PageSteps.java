package de.alectogmbh.friendsurance.automation.steps.web.insurance.order;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.Step3Page;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class Step3PageSteps extends AbstractBrokerageFlowPageSteps<Step3Page> {

  private Step3Page step3Page;

  public Step3PageSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void is_signature_text_correct() {
    ValidationUtils.checkTextIsCorrect(
        "Bitte unterschreiben Sie hier mit der Maus oder dem Touchpad die Maklervollmacht und die besonderen Datenschutzerklärungen.Um Missbrauch vorzubeugen, speichern wir gemeinsam mit der Unterschrift die IP-Adresse des Gerätes, auf dem die Unterschrift geleistet wird, ab.",
        getPageObject().getSignatureText().replace("\n", "")
    );
  }

  @Step
  public void is_signature_text_visible() {
    ValidationUtils
        .checkElementIsDisplayed("Signature Text", getPageObject().isSignatureTextVisible());
  }

  @Step
  public void is_agb_text_correct() {
    ValidationUtils.checkTextIsCorrect("AGB", getPageObject().getConfirmAgbText());
  }

  @Step
  public void click_agb_link() {
    getPageObject().clickConfirmAgbLink();
  }

  @Step
  public void is_agb_modal_visible() {
    ValidationUtils.checkElementIsDisplayed("AGB Modal", getPageObject().isAgbModalVisible());
  }

  @Step
  public void is_datasafe_text_correct() {
    ValidationUtils
        .checkTextIsCorrect("allgemeinen Datenschutzerklärungen",
            getPageObject().getConfirmDatasafeText());
  }

  @Step
  public void click_datasafe_link() {
    getPageObject().clickConfirmDatasafeLink();
  }

  @Step
  public void is_datasafe_modal_visible() {
    ValidationUtils.checkElementIsDisplayed("AGB Modal", getPageObject().isDatasafeModalVisible());
  }

  @Step
  public void is_broker_agreement_text_correct() {
    ValidationUtils
        .checkTextIsCorrect("allgemeinen Datenschutzerklärungen",
            getPageObject().getConfirmDatasafeText());
  }

  @Step
  public void is_broker_agreement_href_correct() {
    ValidationUtils.checkLinkIsCorrect(
        "/api/document/public/upgrade_broker_agreement_2018_01_PDF",
        getPageObject().getConfirmBrokerContractHref()
    );
  }


  @Override
  protected Step3Page getPageObject() {
    return step3Page;
  }

}
