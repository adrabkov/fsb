package de.alectogmbh.friendsurance.automation.steps.web.insurance.purchase.electronics.cocaflow;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.electronics.cocaflow.AbstractCocaFlowPageObject;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;

public abstract class AbstractCocaFlowScenarioSteps<T extends AbstractCocaFlowPageObject>
    extends AbstractScenarioSteps<T> {

  @Step
  protected void click_on_continue_button() {
    getPageObject().clickToContinue();
  }

}
