package de.alectogmbh.friendsurance.automation.steps.web.friendsurance.home;
import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.home.HomePage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class HomeSteps extends AbstractScenarioSteps<HomePage> {

  private HomePage homePage;

  public HomeSteps() {
  }

  public HomeSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void waitUntilHeaderIsVisble() {
    getPageObject().waitForHeadline();
  }

  @Override
  protected HomePage getPageObject() {
    return homePage;
  }
}