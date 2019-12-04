package de.alectogmbh.friendsurance.automation.steps.web.insurance.order;

import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

public class Step3ValidationSteps extends Step3Steps {

  private String emptyLegalTermsErrorMessage;

  public Step3ValidationSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void empty_legal_terms_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(emptyLegalTermsErrorMessage,
        getPageObject().getLegalTermsRequiredErrorMessage()
    );
  }

  @StepGroup
  public void submit_with_empty_legal_terms() {
    deselect_legal_terms();
    sign_conversion();
    submit_upgrade();
  }
}
