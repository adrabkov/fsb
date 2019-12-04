package de.alectogmbh.friendsurance.automation.steps.web.elements.boxes;

import de.alectogmbh.friendsurance.automation.pages.web.elements.boxes.InsuranceCategoryLinksBox;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.pages.Pages;

public class InsuranceCategoryLinksBoxSteps
    extends AbstractScenarioSteps<InsuranceCategoryLinksBox> {

  private InsuranceCategoryLinksBox insuranceCategoryLinksBox;

  public InsuranceCategoryLinksBoxSteps() {
  }

  public InsuranceCategoryLinksBoxSteps(Pages pages) {
    super(pages);
  }

  @Override
  protected InsuranceCategoryLinksBox getPageObject() {
    return insuranceCategoryLinksBox;
  }

}