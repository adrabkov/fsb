package de.alectogmbh.friendsurance.automation.steps.web.insurance.dashboard;

import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.dashboard.AbstractDashboardInsurancePage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.pages.Pages;

public abstract class AbstractDashboardInsuranceSteps<T extends AbstractDashboardInsurancePage>
    extends
        AbstractScenarioSteps {

  public AbstractDashboardInsuranceSteps() {
  }

  public AbstractDashboardInsuranceSteps(Pages pages) {
    super(pages);
  }
}
