package de.alectogmbh.friendsurance.automation.steps.web.insurance.order;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.SuccessPage;
import net.thucydides.core.pages.Pages;

public class SuccessPageSteps extends AbstractOrderFlowSteps<SuccessPage> {

  private SuccessPage successPage;

  public SuccessPageSteps(Pages pages) {
    super(pages);
  }

  @Override
  protected SuccessPage getPageObject() {
    return successPage;
  }
}
