package de.alectogmbh.friendsurance.automation.steps.web.insurance.order;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.Step2Page;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.utils.StringHelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class Step2PageSteps extends AbstractBrokerageFlowPageSteps<Step2Page> {

  private String noteText;
  private String noteHeader;

  private Step2Page step2Page;

  public Step2PageSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void is_note_header_correct() {
    ValidationUtils.checkTextIsCorrect(noteHeader, getPageObject().getNoteUserHeader());
  }

  @Step
  public void is_note_text_correct() {
    ValidationUtils.checkTextIsCorrect(StringHelper.convertToUTF8(noteText),
        getPageObject().getNoteUserText());
  }

  @Step
  public void click_name_field() {
    getPageObject().enterFirstName("");
  }

  @Override
  protected Step2Page getPageObject() {
    return step2Page;
  }

}
