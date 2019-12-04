package de.alectogmbh.friendsurance.automation.steps.web.insurance.comparison.household;

import de.alectogmbh.friendsurance.automation.data.SearchResult;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.comparison.household.HouseholdInsuranceComparisonPage;
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

public class HouseholdInsuranceComparisonSteps extends
        AbstractOtherInsuranceComparisonSteps<HouseholdInsuranceComparisonPage> {

  private HouseholdInsuranceComparisonPage householdInsuranceComparisonPage;

  public HouseholdInsuranceComparisonSteps() {
  }

  public HouseholdInsuranceComparisonSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void enter_postal_code(String postalCode) {
    getPageObject().enterPostalCode(postalCode);
  }

  @Step
  public void select_city(String city) {
    getPageObject().selectCityByText(city);
  }

  @Step
  public void select_street(String street) {
    getPageObject().selectStreet(street);
  }

  @Step
  public void enter_house_number(String houseNumber) {
    getPageObject().enterHouseNumber(houseNumber);
  }

  @Step
  public void enter_living_space(String livingSpace) {
    getPageObject().enterLivingSpace(livingSpace);
  }

  @Step
  public void select_building_type(String buildingType) {
    switch (buildingType) {
      case "APARTMENT_BUILDING":
        getPageObject().selectBuildingType("APARTMENT_BUILDING");
        break;
      case "ONE_FAMILY_HOUSE":
        getPageObject().selectBuildingType("ONE_FAMILY_HOUSE");
        break;
      case "TWO_FAMILIES_HOUSE":
        getPageObject().selectBuildingType("TWO_FAMILIES_HOUSE");
        break;
      case "SEMI_DETACHED_HOUSE":
        getPageObject().selectBuildingType("SEMI_DETACHED_HOUSE");
        break;
      case "TOWNHOUSE":
        getPageObject().selectBuildingType("TOWNHOUSE");
        break;
      default:
        break;
    }

  }


  @Step
  public void set_include_bike_theft_coverage_to_yes() {
    getPageObject().clickBikeTheftYes();
  }

  @Step
  public void set_include_bike_theft_coverage_to_no() {
    getPageObject().clickBikeTheftNo();
  }

  @Step
  public void enter_bike_coverage_amount(String bikeCoverageAmount) {
    getPageObject().enterBikeCoverageAmount(bikeCoverageAmount);
  }

  @Step
  public void enter_insurance_sum(String insuranceSum) {
    getPageObject().enterInsuranceSum(insuranceSum);
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
  public void set_include_lightning_damage_coverage_to_yes() {
    getPageObject().clickLightningDamageYes();
  }

  @Step
  public void set_include_lightning_damage_coverage_to_no() {
    getPageObject().clickLightningDamageNo();
  }

  @Step
  public void set_include_glass_breakage_coverage_to_yes() {
    getPageObject().clickGlassBreakageYes();
  }

  @Step
  public void set_include_glass_breakage_coverage_to_no() {
    getPageObject().clickGlassBreakageNo();
  }

  @Step
  public void set_include_elemental_damage_coverage_to_yes() {
    getPageObject().clickElementalDamageYes();
  }

  @Step
  public void set_include_elemental_damage_coverage_to_no() {
    getPageObject().clickElementalDamageNo();
  }

  @Step
  public void household_insurance_contract_offers_by_criteria_are_available(
      InsuranceData searchCriteria, CustomerData userData
  ) {
    search_household_insurance_contract_offers_by_criteria(searchCriteria, userData);
    List<SearchResult> searchResults = get_search_results();

    assertThat(
        "Household insurance contact offers are not available for [" + searchCriteria.toString()
            + "]",
        searchResults, is(not(empty()))
    );
  }

  @StepGroup
  public void search_household_insurance_contract_offers_by_criteria(
      InsuranceData insuranceSearchCriteria, CustomerData customerSearchCriteria
  ) {
    open_page();
    getDriver().navigate().refresh();
    if (customerSearchCriteria.getPostalCode() != null) {
      enter_postal_code(customerSearchCriteria.getPostalCode());
    }
    if (customerSearchCriteria.getCity() != null) {
      select_city(customerSearchCriteria.getCity());
    }
    if (customerSearchCriteria.getStreet() != null) {
      select_street(customerSearchCriteria.getStreet());
    }
    if (customerSearchCriteria.getHouseNumber() != null) {
      enter_house_number(customerSearchCriteria.getHouseNumber());
    }
    if (insuranceSearchCriteria.getHouseholdLivingSpace() != null) {
      enter_living_space(insuranceSearchCriteria.getHouseholdLivingSpace());
    }
    if (insuranceSearchCriteria.getHouseholdBuildingType() != null) {
      select_building_type(insuranceSearchCriteria.getHouseholdBuildingType());
    }
    unselect_birthday_fields();
    if (customerSearchCriteria.getBirthDay() != null) {
      select_birth_day(customerSearchCriteria.getBirthDay());
    }
    if (customerSearchCriteria.getBirthMonth() > 0) {
      select_birth_month(customerSearchCriteria.getBirthMonth());
    }
    if (customerSearchCriteria.getBirthYear() != null) {
      select_birth_year(customerSearchCriteria.getBirthYear());
    }
    if (insuranceSearchCriteria.getHouseholdBike() != null) {
      if (insuranceSearchCriteria.getHouseholdBike()) {
        set_include_bike_theft_coverage_to_yes();
        enter_bike_coverage_amount(insuranceSearchCriteria.getHouseholdBikeCoverage());
      } else {
        set_include_bike_theft_coverage_to_no();
      }
    }
    search_for_offers();
  }

  @StepGroup
  public void search_household_insurance_contract_offers_by_additional_criteria(
      InsuranceData insuranceSearchCriteria, CustomerData customerSearchCriteria
  ) {
    if (insuranceSearchCriteria.getHouseholdInsuranceSum() != null) {
      enter_insurance_sum(insuranceSearchCriteria.getHouseholdInsuranceSum());
    }
    if (insuranceSearchCriteria.getHouseholdPreviouslyInsured() != null) {
      if (insuranceSearchCriteria.getHouseholdPreviouslyInsured()) {
        select_previously_insured_yes();
        enter_number_of_claims(insuranceSearchCriteria.getHouseholdPreviousDamages());
      } else {
        select_previously_insured_no();
      }
    }
    if (insuranceSearchCriteria.getHouseholdLightningCoverage() != null) {
      if (insuranceSearchCriteria.getHouseholdLightningCoverage()) {
        set_include_lightning_damage_coverage_to_yes();
      } else {
        set_include_lightning_damage_coverage_to_no();
      }
    }
    if (insuranceSearchCriteria.getHouseholdGlassBreakageCoverage() != null) {
      if (insuranceSearchCriteria.getHouseholdGlassBreakageCoverage()) {
        set_include_glass_breakage_coverage_to_yes();
      } else {
        set_include_glass_breakage_coverage_to_no();
      }
    }
    if (insuranceSearchCriteria.getHouseholdElementalDamageCoverage() != null) {
      if (insuranceSearchCriteria.getHouseholdElementalDamageCoverage()) {
        set_include_elemental_damage_coverage_to_yes();
      } else {
        set_include_elemental_damage_coverage_to_no();
      }
    }

    search_for_offers();
  }

  @Override
  protected HouseholdInsuranceComparisonPage getPageObject() {
    return householdInsuranceComparisonPage;
  }
}
