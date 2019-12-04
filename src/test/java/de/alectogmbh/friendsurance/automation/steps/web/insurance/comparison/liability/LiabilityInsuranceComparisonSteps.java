package de.alectogmbh.friendsurance.automation.steps.web.insurance.comparison.liability;

import de.alectogmbh.friendsurance.automation.data.SearchResult;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.comparison.liability.LiabilityInsuranceComparisonPage;
import de.alectogmbh.friendsurance.automation.steps.web.insurance.comparison.AbstractOtherInsuranceComparisonSteps;
import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import de.alectogmbh.friendsurance.automation.steps.web.utils.InsuranceData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;

public class LiabilityInsuranceComparisonSteps extends
        AbstractOtherInsuranceComparisonSteps<LiabilityInsuranceComparisonPage> {

  private LiabilityInsuranceComparisonPage liabilityInsuranceComparisonPage;

  public LiabilityInsuranceComparisonSteps() {
  }

  public LiabilityInsuranceComparisonSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void select_liability_insured_persons(String liaFamily) {
    switch (liaFamily) {
      case "SINGLE":
        getPageObject().clickSingleButton();
        break;
      case "COUPLE":
        getPageObject().clickCoupleButton();
        break;
      case "FAMILY_WITHOUT_CHILDREN":
        getPageObject().clickFamilyButton();
        break;
      case "FAMILY_WITH_CHILDREN":
        getPageObject().clickSingleChildButton();
        break;
      default:
        break;
    }
  }

  @Step
  public void enter_postal_code(String postalCode) {
    getPageObject().enterPostalCode(postalCode);
  }

  @Step
  public void select_public_service_yes() {
    getPageObject().clickPublicServiceYes();
  }

  @Step
  public void select_public_service_no() {
    getPageObject().clickPublicServiceNo();
  }

  @Step
  public void select_failure_covered_yes() {
    getPageObject().clickFailureCoveredYes();
  }

  @Step
  public void select_failure_covered_no() {
    getPageObject().clickFailureCoveredNo();
  }

  @Step
  public void select_key_loss_yes() {
    getPageObject().clickKeyLossYes();
  }

  @Step
  public void select_key_loss_no() {
    getPageObject().clickKeyLossNo();
  }

  @Step
  public void liability_insurance_contract_offers_by_criteria_are_available(
          InsuranceData insuranceData, CustomerData customerData
  ) {
    search_liability_insurance_contract_offers_by_criteria(insuranceData, customerData);
    List<SearchResult> searchResults = get_search_results();

    assertThat(
        "Liability insurance contract offers are not available.",
        searchResults, is(not(empty()))
    );
  }

  @StepGroup
  public void search_liability_insurance_contract_offers_by_criteria(
          InsuranceData insuranceData, CustomerData customerData) {
    open_page();
    getDriver().navigate().refresh();
    select_liability_insured_persons(insuranceData.getLiabilityFamily());
    enter_postal_code(customerData.getPostalCode());
    select_birth_day(customerData.getBirthDay());
    select_birth_month(customerData.getBirthMonth());
    select_birth_year(customerData.getBirthYear());
    if (insuranceData.getLiabilityPublicService()) {
      select_public_service_yes();
    } else {
      select_public_service_no();
    }
    //set_coverage(insuranceData.getLiabilityCoverage());
    search_for_offers();
  }

  @StepGroup
  public void search_liability_insurance_contract_offers_by_extended_criteria(
          InsuranceData insuranceData, CustomerData customerData) {
    if (insuranceData.getLiabilityPreviouslyInsured()) {
      select_previously_insured_yes();
      enter_number_of_claims(insuranceData.getLiabilityDamagePeriod());
    } else {
      select_previously_insured_no();
    }
    if (insuranceData.getLiabilityFailureCoverage()) {
      select_failure_covered_yes();
    } else {
      select_failure_covered_no();
    }
    if (insuranceData.getLiabilityKeyLoss()) {
      select_key_loss_yes();
    } else {
      select_key_loss_no();
    }
    search_for_offers();
  }

  @Override
  protected LiabilityInsuranceComparisonPage getPageObject() {
    return liabilityInsuranceComparisonPage;
  }

}
