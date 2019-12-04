package de.alectogmbh.friendsurance.automation.steps.web.insurance.comparison.legal;

import de.alectogmbh.friendsurance.automation.data.SearchResult;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.comparison.legal.LegalInsuranceComparisonPage;
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

public class LegalInsuranceComparisonSteps
    extends AbstractOtherInsuranceComparisonSteps<LegalInsuranceComparisonPage> {

  private LegalInsuranceComparisonPage legalInsuranceComparisonPage;

  public LegalInsuranceComparisonSteps() {
  }

  public LegalInsuranceComparisonSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void selectLegalProfession(String legalProfession) {
    switch (legalProfession) {
      case "EMPLOYEE":
        getPageObject().selectProfession("EMPLOYEE");
        break;
      case "FREELANCER":
        getPageObject().selectProfession("FREELANCER");
        break;
      case "PUBLIC":
        getPageObject().selectProfession("CIVIL_SERVICE");
        break;
      default:
        break;
    }
  }

  @Step
  public void checkProfessionCoverage() {
    if (!legalInsuranceComparisonPage.isInsuranceAreaProfessionChecked()) {
      legalInsuranceComparisonPage.clickInsuranceAreaPrivate();
    }
  }

  @Step
  public void checkTrafficCoverage() {
    if (!legalInsuranceComparisonPage.isInsuranceAreaTrafficChecked()) {
      legalInsuranceComparisonPage.clickInsuranceAreaTraffic();
    }
  }

  @Step
  public void checkLivingCoverage() {
    if (!legalInsuranceComparisonPage.isInsuranceAreaLivingChecked()) {
      legalInsuranceComparisonPage.clickInsuranceAreaLiving();
    }
  }

  @Step
  public void checkPrivateCoverage() {
    if (!legalInsuranceComparisonPage.isInsuranceAreaPrivateChecked()) {
      legalInsuranceComparisonPage.clickInsuranceAreaPrivate();
    }
  }

  @Step
  public void checkRentalCoverage() {
    if (!legalInsuranceComparisonPage.isInsuranceAreaRentalChecked()) {
      legalInsuranceComparisonPage.clickInsuranceAreaPrivate();
    }
  }

  @Step
  public void uncheckProfessionCoverage() {
    if (legalInsuranceComparisonPage.isInsuranceAreaProfessionChecked()) {
      legalInsuranceComparisonPage.clickInsuranceAreaPrivate();
    }
  }

  @Step
  public void uncheckTrafficCoverage() {
    if (legalInsuranceComparisonPage.isInsuranceAreaTrafficChecked()) {
      legalInsuranceComparisonPage.clickInsuranceAreaTraffic();
    }
  }

  @Step
  public void uncheckLivingCoverage() {
    if (legalInsuranceComparisonPage.isInsuranceAreaLivingChecked()) {
      legalInsuranceComparisonPage.clickInsuranceAreaLiving();
    }
  }

  @Step
  public void uncheckPrivateCoverage() {
    if (legalInsuranceComparisonPage.isInsuranceAreaPrivateChecked()) {
      legalInsuranceComparisonPage.clickInsuranceAreaPrivate();
    }
  }

  @Step
  public void uncheckRentalCoverage() {
    if (legalInsuranceComparisonPage.isInsuranceAreaRentalChecked()) {
      legalInsuranceComparisonPage.clickInsuranceAreaPrivate();
    }
  }

  @Step
  public void chooseFamilyInsured(Boolean family) {
    if (family) {
      legalInsuranceComparisonPage.selectFamilyInsuranceYes();
    } else {
      legalInsuranceComparisonPage.selectFamilyInsuranceNo();
    }
  }

  @Step
  public void selectDeductibleYes() {
    legalInsuranceComparisonPage.selectDeductibleYes();
  }

  @Step
  public void selectDeductibleNo() {
    legalInsuranceComparisonPage.selectDeductibleNo();
  }

  @StepGroup
  public void search_legal_insurance_contract_offers_by_criteria(
      InsuranceData insuranceData, CustomerData customerData
  ) {
    insuranceData.setLegalFamilyCoverage(false);
    open_page();
    unselect_birthday_fields();
    select_birth_day(customerData.getBirthDay());
    select_birth_month(customerData.getBirthMonth());
    select_birth_year(customerData.getBirthYear());
    selectLegalProfession(insuranceData.getLegalProfession());
    if (insuranceData.getLegalPrivateCoverage()) {
      checkPrivateCoverage();
    } else {
      uncheckPrivateCoverage();
    }
    if (insuranceData.getLegalProfessionCoverage()) {
      checkProfessionCoverage();
    } else {
      uncheckProfessionCoverage();
    }
    if (insuranceData.getLegalTrafficCoverage()) {
      checkTrafficCoverage();
    } else {
      uncheckTrafficCoverage();
    }
    if (insuranceData.getLegalLivingCoverage()) {
      checkLivingCoverage();
    } else {
      uncheckLivingCoverage();
    }
    if (insuranceData.getLegalRentalCoverage()) {
      checkRentalCoverage();
    } else {
      uncheckRentalCoverage();
    }
    chooseFamilyInsured(insuranceData.getLegalFamilyCoverage());
    search_for_offers();
  }

  @Step
  public void legal_insurance_contract_offers_by_criteria_are_available(
      InsuranceData insuranceData, CustomerData customerData
  ) {
    search_legal_insurance_contract_offers_by_criteria(insuranceData, customerData);
    List<SearchResult> searchResults = get_search_results();
    assertThat("Legal insurance offers are not available.", searchResults, is(not(empty())));
  }

  @Override
  protected LegalInsuranceComparisonPage getPageObject() {
    return legalInsuranceComparisonPage;
  }

}
