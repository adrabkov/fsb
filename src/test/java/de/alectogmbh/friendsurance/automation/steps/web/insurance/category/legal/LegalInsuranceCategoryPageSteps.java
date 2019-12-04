package de.alectogmbh.friendsurance.automation.steps.web.insurance.category.legal;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.legal.LegalInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.category.AbstractOtherInsuranceCategoryPageSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;

public class LegalInsuranceCategoryPageSteps extends
    AbstractOtherInsuranceCategoryPageSteps<LegalInsuranceCategoryPage> {

  private LegalInsuranceCategoryPage legalInsurancePage;

  public LegalInsuranceCategoryPageSteps() {
  }

  public LegalInsuranceCategoryPageSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void is_main_cta_correct() {
    ValidationUtils.checkLinkIsCorrect("#", getPageObject().getMainCtaHref());
  }

  @Step
  public void click_main_cta() {
    getPageObject().clickMainCta();
  }


  @Step
  public List<String> get_professional_activities() {
    return legalInsurancePage.getProfessionalActivities();
  }

  @Step
  public void professional_activities_are_available() {
    List<String> professionalActivities = get_professional_activities();

    assertThat("Models and price categories must be available", professionalActivities,
        is(not(empty())));
  }

  @Step
  public void professional_activities_are_correct(String professionalActivityData) {
    List<String> list = Arrays.asList(StringUtils.split(professionalActivityData, ';'));
    List<String> actual = get_professional_activities();

    Collection result = CollectionUtils.disjunction(actual, list);

    assertThat(
        "Professional activities list is not correct, " + result.size() + " elements difference",
        result.isEmpty(), is(true)
    );
  }

  @Step
  public void isToTariffsFirstButtonTextCorrect() {
    ValidationUtils
        .checkTextIsCorrect("Tarife anzeigen", getPageObject().getToTariffsFirstButtonText());
  }

  @Step
  public void isToTariffsSecondButtonTextCorrect() {
    ValidationUtils
        .checkTextIsCorrect("Tarife anzeigen", getPageObject().getToTariffsSecondButtonText());
  }


  @Override
  protected LegalInsuranceCategoryPage getPageObject() {
    return legalInsurancePage;
  }

}
