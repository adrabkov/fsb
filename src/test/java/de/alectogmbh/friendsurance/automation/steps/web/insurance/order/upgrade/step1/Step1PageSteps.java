package de.alectogmbh.friendsurance.automation.steps.web.insurance.order.upgrade.step1;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.Step1Page;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.order.AbstractBrokerageFlowPageSteps;
import net.thucydides.core.pages.Pages;

public class Step1PageSteps extends AbstractBrokerageFlowPageSteps<Step1Page> {

  private Step1Page step1Page;

  public Step1PageSteps(Pages pages) {
    super(pages);
  }

  @Override
  protected Step1Page getPageObject() {
    return step1Page;
  }

}
