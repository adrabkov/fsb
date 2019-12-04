package de.alectogmbh.friendsurance.automation.steps.web.insurance.comparison;

import de.alectogmbh.friendsurance.automation.data.SearchResult;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.comparison.AbstractOtherInsuranceComparisonPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import de.alectogmbh.friendsurance.automation.utils.DateUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import java.util.Calendar;
import java.util.List;

public abstract class AbstractOtherInsuranceComparisonSteps<T extends AbstractOtherInsuranceComparisonPage>
    extends
        AbstractScenarioSteps<T> {

  private String emptyBirthDateErrorMessage;
  private String minAgeErrorMessage;

  public AbstractOtherInsuranceComparisonSteps() {
  }

  public AbstractOtherInsuranceComparisonSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void select_birth_day(String birthDay) {
    getPageObject().selectBirthDay(birthDay);
  }

  @Step
  public void select_birth_month(int birthMonth) {
    switch (birthMonth) {
      case 0:
        getPageObject().selectBirthMonth("");
        break;
      case 1:
        getPageObject().selectBirthMonth("Januar");
        break;
      case 2:
        getPageObject().selectBirthMonth("Februar");
        break;
      case 3:
        getPageObject().selectBirthMonth("März");
        break;
      case 4:
        getPageObject().selectBirthMonth("April");
        break;
      case 5:
        getPageObject().selectBirthMonth("Mai");
        break;
      case 6:
        getPageObject().selectBirthMonth("Juni");
        break;
      case 7:
        getPageObject().selectBirthMonth("Juli");
        break;
      case 8:
        getPageObject().selectBirthMonth("August");
        break;
      case 9:
        getPageObject().selectBirthMonth("September");
        break;
      case 10:
        getPageObject().selectBirthMonth("Oktober");
        break;
      case 11:
        getPageObject().selectBirthMonth("November");
        break;
      case 12:
        getPageObject().selectBirthMonth("Dezember");
        break;
      default:
        break;
    }
  }

  @Step
  public void select_birth_year(String birthYear) {
    getPageObject().selectBirthYear(birthYear);
  }

  @Step
  public void select_birth_year_by_index(int index) {
    getPageObject().selectBirthYearByIndex(index);
  }

  @Step
  public void select_birth_day_by_index(int index) {
    getPageObject().selectBirthDayByIndex(index);
  }

  @Step
  public void search_for_offers() {
    getPageObject().clickSearchButton();
  }

  @Step
  public List<SearchResult> get_search_results() {
    return getPageObject().getSearchResults();
  }


  @Step
  public void click_best_price_button() {
    getPageObject().clickCheapestInsuranceButton();
  }

  @Step
  public void click_edit_search_button() {
    getPageObject().clickEditSearchButton();
  }

  @Step
  public void select_previously_insured_yes() {
    getPageObject().clickPreviouslyInsuredYes();
  }

  @Step
  public void select_previously_insured_no() {
    getPageObject().clickPreviouslyInsuredNo();
  }

  @Step
  public void enter_number_of_claims(String prevDamages) {
    getPageObject().enterPreviousDamages(prevDamages);
  }

  @Step
  public void empty_birthdate_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(emptyBirthDateErrorMessage,
        getPageObject().getBirthDateRequiredMessage()
    );
  }

  @Step
  public void min_age_error_message_is_displayed() {
    ValidationUtils.checkValidationErrorMessage(minAgeErrorMessage,
        getPageObject().getMinAgeRequiredErrorMessage());
  }

  @StepGroup
  public void unselect_birthday_fields() {
    select_birth_day("");
    select_birth_month(0);
    select_birth_year("");
  }

  @StepGroup
  public void submit_with_not_allowed_age() {
    unselect_birthday_fields();
    Calendar date = Calendar.getInstance();
    if (DateUtil.isLastDayInMonth()) {
      //This is the next month
      select_birth_month(date.get(Calendar.MONTH) + 2);
      select_birth_day_by_index(1);
    } else {
      //This is the current month
      select_birth_month(date.get(Calendar.MONTH) + 1);
      select_birth_day_by_index(date.get(Calendar.DAY_OF_MONTH) + 1);
    }
    select_birth_year_by_index(1);
    search_for_offers();
    min_age_error_message_is_displayed();
  }

}
