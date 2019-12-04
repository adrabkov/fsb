package de.alectogmbh.friendsurance.automation.steps.web.insurance.category;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.AbstractOtherInsuranceCategoryPage;
import net.thucydides.core.pages.Pages;

public abstract class AbstractOtherInsuranceCategoryPageSteps<T extends AbstractOtherInsuranceCategoryPage>
    extends
        AbstractInsuranceCategoryPageSteps<T> {

  public AbstractOtherInsuranceCategoryPageSteps() {
  }

  public AbstractOtherInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }
}
