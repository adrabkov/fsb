package de.alectogmbh.friendsurance.automation.steps.web.user.registration;

import de.alectogmbh.friendsurance.automation.pages.web.user.RegistrationPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.pages.Pages;

public abstract class AbstractRegistrationSteps extends AbstractScenarioSteps<RegistrationPage> {

  private RegistrationPage registrationPage;

  public AbstractRegistrationSteps() {
  }

  public AbstractRegistrationSteps(Pages pages) {
    super(pages);
  }

  @Override
  protected RegistrationPage getPageObject() {
    return registrationPage;
  }

}
