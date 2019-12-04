package de.alectogmbh.friendsurance.automation.steps.web.utils;

public class InsuranceData {

  private String electronicDeviceType;
  private Boolean isDeviceYounger3Month;
  private String devicePrice;
  private String IMEI;
  private String serial;
  private String purchaseDay;
  private int purchaseMonth;
  private String purchaseYear;
  private String manufacturer;
  private String model;
  private String ppp;
  private String liabilityNameXselling;
  private String liabilityNameUpgrade;
  private String liabilityPolicyNumber;
  private String liabilityAnnualContribution;
  private Boolean liabilityPreviouslyInsured;
  private String liabilityDamagePeriod;
  private int liabilityPaymentInterval;
  private int liabilityCancellationDay;
  private int liabilityCancellationMonth;
  private String liabilityCancellationYear;
  private Boolean liabilityAge;
  private Boolean liabilityFailureCoverage;
  private Boolean liabilityKeyLoss;
  private String liabilityFamily;
  private String liabilityCoverage;
  private String liabilityProfession;
  private Boolean liabilityPublicService;
  private String householdNameXselling;
  private String householdNameUpgrade;
  private String householdPolicyNumber;
  private String householdLivingSpace;
  private String householdBuildingType;
  private Boolean householdLightningCoverage;
  private Boolean householdBike;
  private String householdBikeCoverage;
  private String householdInsuranceSum;
  private Boolean householdPreviouslyInsured;
  private String householdPreviousDamages;
  private Boolean householdElementalDamageCoverage;
  private Boolean householdGlassBreakageCoverage;
  private String legalNameXselling;
  private String legalNameUpgrade;
  private String legalPolicyNumber;
  private String legalProfession;
  private Boolean legalPrivateCoverage;
  private Boolean legalProfessionCoverage;
  private Boolean legalTrafficCoverage;
  private Boolean legalLivingCoverage;
  private Boolean legalRentalCoverage;
  private String legalFamily;
  private Boolean legalFamilyCoverage;
  private Boolean legalDeductible;
  private String carNameXselling;
  private String carNameUpgrade;
  private String carPolicyNumber;
  private String homeOwnersNameXselling;
  private String homeOwnersNameUpgrade;
  private String homeOwnersPolicyNumber;
  private String accidentsNameXselling;
  private String accidentsNameUpgrade;
  private String accidentsPolicyNumber;
  private String retirementArrangementNameXselling;
  private String retirementArrangementNameUpgrade;
  private String retirementArrangementPolicyNumber;
  private String petOwnerLiabilityNameXselling;
  private String petOwnerLiabilityNameUpgrade;
  private String petOwnerLiabilityPolicyNumber;

  public InsuranceData() {
  }

  public InsuranceData(
      String electronicDeviceType, Boolean isDeviceYounger3Month, String devicePrice, String IMEI,
      String serial,
      String purchaseDay, int purchaseMonth, String purchaseYear, String manufacturer, String model,
      String ppp,
      String liabilityNameXselling, String liabilityNameUpgrade, String liabilityPolicyNumber,
      String liabilityAnnualContribution, Boolean liabilityPreviouslyInsured,
      String liabilityDamagePeriod,
      int liabilityPaymentInterval, int liabilityCancellationDay, int liabilityCancellationMonth,
      String liabilityCancellationYear, Boolean liabilityAge, Boolean liabilityFailureCoverage,
      Boolean liabilityKeyLoss, String liabilityFamily, String liabilityCoverage,
      String liabilityProfession,
      Boolean liabilityPublicService, String householdNameXselling, String householdNameUpgrade,
      String householdPolicyNumber, String householdLivingSpace, String householdBuildingType,
      Boolean householdLightningCoverage, Boolean householdBike, String householdBikeCoverage,
      String householdInsuranceSum, Boolean householdPreviouslyInsured,
      String householdPreviousDamages,
      Boolean householdElementalDamageCoverage, Boolean householdGlassBreakageCoverage,
      String legalNameXselling,
      String legalNameUpgrade, String legalPolicyNumber, String legalProfession,
      Boolean legalPrivateCoverage,
      Boolean legalProfessionCoverage, Boolean legalTrafficCoverage, Boolean legalLivingCoverage,
      Boolean legalRentalCoverage, String legalFamily, Boolean legalFamilyCoverage,
      Boolean legalDeductible,
      String carNameXselling, String carNameUpgrade, String carPolicyNumber,
      String homeOwnersNameXselling,
      String homeOwnersNameUpgrade, String homeOwnersPolicyNumber, String accidentsNameXselling,
      String accidentsNameUpgrade, String accidentsPolicyNumber,
      String retirementArrangementNameXselling,
      String retirementArrangementNameUpgrade, String retirementArrangementPolicyNumber,
      String petOwnerLiabilityNameXselling, String petOwnerLiabilityNameUpgrade,
      String petOwnerLiabilityPolicyNumber
  ) {
    this.electronicDeviceType = electronicDeviceType;
    this.isDeviceYounger3Month = isDeviceYounger3Month;
    this.devicePrice = devicePrice;
    this.IMEI = IMEI;
    this.serial = serial;
    this.purchaseDay = purchaseDay;
    this.purchaseMonth = purchaseMonth;
    this.purchaseYear = purchaseYear;
    this.manufacturer = manufacturer;
    this.model = model;
    this.ppp = ppp;
    this.liabilityNameXselling = liabilityNameXselling;
    this.liabilityNameUpgrade = liabilityNameUpgrade;
    this.liabilityPolicyNumber = liabilityPolicyNumber;
    this.liabilityAnnualContribution = liabilityAnnualContribution;
    this.liabilityPreviouslyInsured = liabilityPreviouslyInsured;
    this.liabilityDamagePeriod = liabilityDamagePeriod;
    this.liabilityPaymentInterval = liabilityPaymentInterval;
    this.liabilityCancellationDay = liabilityCancellationDay;
    this.liabilityCancellationMonth = liabilityCancellationMonth;
    this.liabilityCancellationYear = liabilityCancellationYear;
    this.liabilityAge = liabilityAge;
    this.liabilityFailureCoverage = liabilityFailureCoverage;
    this.liabilityKeyLoss = liabilityKeyLoss;
    this.liabilityFamily = liabilityFamily;
    this.liabilityCoverage = liabilityCoverage;
    this.liabilityProfession = liabilityProfession;
    this.liabilityPublicService = liabilityPublicService;
    this.householdNameXselling = householdNameXselling;
    this.householdNameUpgrade = householdNameUpgrade;
    this.householdPolicyNumber = householdPolicyNumber;
    this.householdLivingSpace = householdLivingSpace;
    this.householdBuildingType = householdBuildingType;
    this.householdLightningCoverage = householdLightningCoverage;
    this.householdBike = householdBike;
    this.householdBikeCoverage = householdBikeCoverage;
    this.householdInsuranceSum = householdInsuranceSum;
    this.householdPreviouslyInsured = householdPreviouslyInsured;
    this.householdPreviousDamages = householdPreviousDamages;
    this.householdElementalDamageCoverage = householdElementalDamageCoverage;
    this.householdGlassBreakageCoverage = householdGlassBreakageCoverage;
    this.legalNameXselling = legalNameXselling;
    this.legalNameUpgrade = legalNameUpgrade;
    this.legalPolicyNumber = legalPolicyNumber;
    this.legalProfession = legalProfession;
    this.legalPrivateCoverage = legalPrivateCoverage;
    this.legalProfessionCoverage = legalProfessionCoverage;
    this.legalTrafficCoverage = legalTrafficCoverage;
    this.legalLivingCoverage = legalLivingCoverage;
    this.legalRentalCoverage = legalRentalCoverage;
    this.legalFamily = legalFamily;
    this.legalFamilyCoverage = legalFamilyCoverage;
    this.legalDeductible = legalDeductible;
    this.carNameXselling = carNameXselling;
    this.carNameUpgrade = carNameUpgrade;
    this.carPolicyNumber = carPolicyNumber;
    this.homeOwnersNameXselling = homeOwnersNameXselling;
    this.homeOwnersNameUpgrade = homeOwnersNameUpgrade;
    this.homeOwnersPolicyNumber = homeOwnersPolicyNumber;
    this.accidentsNameXselling = accidentsNameXselling;
    this.accidentsNameUpgrade = accidentsNameUpgrade;
    this.accidentsPolicyNumber = accidentsPolicyNumber;
    this.retirementArrangementNameXselling = retirementArrangementNameXselling;
    this.retirementArrangementNameUpgrade = retirementArrangementNameUpgrade;
    this.retirementArrangementPolicyNumber = retirementArrangementPolicyNumber;
    this.petOwnerLiabilityNameXselling = petOwnerLiabilityNameXselling;
    this.petOwnerLiabilityNameUpgrade = petOwnerLiabilityNameUpgrade;
    this.petOwnerLiabilityPolicyNumber = petOwnerLiabilityPolicyNumber;
  }

  public void setElectronicDeviceType(String electronicDeviceType) {
    this.electronicDeviceType = electronicDeviceType;
  }

  public void setIsDeviceYounger3Month(Boolean isDeviceYounger3Month) {
    this.isDeviceYounger3Month = isDeviceYounger3Month;
  }

  public void setDevicePrice(String devicePrice) {
    this.devicePrice = devicePrice;
  }

  public void setIMEI(String IMEI) {
    this.IMEI = IMEI;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  public void setPurchaseDay(String purchaseDay) {
    this.purchaseDay = purchaseDay;
  }

  public void setPurchaseMonth(int purchaseMonth) {
    this.purchaseMonth = purchaseMonth;
  }

  public void setPurchaseYear(String purchaseYear) {
    this.purchaseYear = purchaseYear;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setPpp(String ppp) {
    this.ppp = ppp;
  }

  public void setLiabilityNameXselling(String liabilityNameXselling) {
    this.liabilityNameXselling = liabilityNameXselling;
  }

  public void setLiabilityNameUpgrade(String liabilityNameUpgrade) {
    this.liabilityNameUpgrade = liabilityNameUpgrade;
  }

  public void setLiabilityPolicyNumber(String liabilityPolicyNumber) {
    this.liabilityPolicyNumber = liabilityPolicyNumber;
  }

  public void setLiabilityAnnualContribution(String liabilityAnnualContribution) {
    this.liabilityAnnualContribution = liabilityAnnualContribution;
  }

  public void setLiabilityPreviouslyInsured(Boolean liabilityPreviouslyInsured) {
    this.liabilityPreviouslyInsured = liabilityPreviouslyInsured;
  }

  public void setLiabilityDamagePeriod(String liabilityDamagePeriod) {
    this.liabilityDamagePeriod = liabilityDamagePeriod;
  }

  public void setLiabilityCancellationDay(int liabilityCancellationDay) {
    this.liabilityCancellationDay = liabilityCancellationDay;
  }

  public void setLiabilityCancellationMonth(int liabilityCancellationMonth) {
    this.liabilityCancellationMonth = liabilityCancellationMonth;
  }

  public void setLiabilityCancellationYear(String liabilityCancellationYear) {
    this.liabilityCancellationYear = liabilityCancellationYear;
  }

  public void setLiabilityAge(Boolean liabilityAge) {
    this.liabilityAge = liabilityAge;
  }

  public void setLiabilityFailureCoverage(Boolean liabilityFailureCoverage) {
    this.liabilityFailureCoverage = liabilityFailureCoverage;
  }

  public void setLiabilityKeyLoss(Boolean liabilityKeyLoss) {
    this.liabilityKeyLoss = liabilityKeyLoss;
  }

  public void setLiabilityFamily(String liabilityFamily) {
    this.liabilityFamily = liabilityFamily;
  }

  public void setLiabilityCoverage(String liabilityCoverage) {
    this.liabilityCoverage = liabilityCoverage;
  }

  public void setLiabilityProfession(String liabilityProfession) {
    this.liabilityProfession = liabilityProfession;
  }

  public void setLiabilityPublicService(Boolean liabilityPublicService) {
    this.liabilityPublicService = liabilityPublicService;
  }

  public void setHouseholdNameXselling(String householdNameXselling) {
    this.householdNameXselling = householdNameXselling;
  }

  public void setHouseholdNameUpgrade(String householdNameUpgrade) {
    this.householdNameUpgrade = householdNameUpgrade;
  }

  public void setHouseholdPolicyNumber(String householdPolicyNumber) {
    this.householdPolicyNumber = householdPolicyNumber;
  }

  public void setHouseholdLivingSpace(String householdLivingSpace) {
    this.householdLivingSpace = householdLivingSpace;
  }

  public void setHouseholdBuildingType(String householdBuildingType) {
    this.householdBuildingType = householdBuildingType;
  }

  public void setHouseholdLightningCoverage(Boolean householdLightningCoverage) {
    this.householdLightningCoverage = householdLightningCoverage;
  }

  public void setHouseholdBike(Boolean householdBike) {
    this.householdBike = householdBike;
  }

  public void setHouseholdBikeCoverage(String householdBikeCoverage) {
    this.householdBikeCoverage = householdBikeCoverage;
  }

  public void setHouseholdInsuranceSum(String householdInsuranceSum) {
    this.householdInsuranceSum = householdInsuranceSum;
  }

  public void setHouseholdPreviouslyInsured(Boolean householdPreviouslyInsured) {
    this.householdPreviouslyInsured = householdPreviouslyInsured;
  }

  public void setHouseholdPreviousDamages(String householdPreviousDamages) {
    this.householdPreviousDamages = householdPreviousDamages;
  }

  public void setLegalNameXselling(String legalNameXselling) {
    this.legalNameXselling = legalNameXselling;
  }

  public void setLegalNameUpgrade(String legalNameUpgrade) {
    this.legalNameUpgrade = legalNameUpgrade;
  }

  public void setLegalPolicyNumber(String legalPolicyNumber) {
    this.legalPolicyNumber = legalPolicyNumber;
  }

  public void setLegalProfession(String legalProfession) {
    this.legalProfession = legalProfession;
  }

  public void setLegalPrivateCoverage(Boolean legalPrivateCoverage) {
    this.legalPrivateCoverage = legalPrivateCoverage;
  }

  public void setLegalProfessionCoverage(Boolean legalProfessionCoverage) {
    this.legalProfessionCoverage = legalProfessionCoverage;
  }

  public void setLegalTrafficCoverage(Boolean legalTrafficCoverage) {
    this.legalTrafficCoverage = legalTrafficCoverage;
  }

  public void setLegalLivingCoverage(Boolean legalLivingCoverage) {
    this.legalLivingCoverage = legalLivingCoverage;
  }

  public void setLegalRentalCoverage(Boolean legalRentalCoverage) {
    this.legalRentalCoverage = legalRentalCoverage;
  }

  public void setLegalFamily(String legalFamily) {
    this.legalFamily = legalFamily;
  }

  public void setLegalFamilyCoverage(Boolean legalFamilyCoverage) {
    this.legalFamilyCoverage = legalFamilyCoverage;
  }

  public void setLegalDeductible(Boolean legalDeductible) {
    this.legalDeductible = legalDeductible;
  }

  public void setCarNameXselling(String carNameXselling) {
    this.carNameXselling = carNameXselling;
  }

  public void setCarNameUpgrade(String carNameUpgrade) {
    this.carNameUpgrade = carNameUpgrade;
  }

  public void setCarPolicyNumber(String carPolicyNumber) {
    this.carPolicyNumber = carPolicyNumber;
  }

  public void setHomeOwnersNameXselling(String homeOwnersNameXselling) {
    this.homeOwnersNameXselling = homeOwnersNameXselling;
  }

  public void setHomeOwnersNameUpgrade(String homeOwnersNameUpgrade) {
    this.homeOwnersNameUpgrade = homeOwnersNameUpgrade;
  }

  public void setHomeOwnersPolicyNumber(String homeOwnersPolicyNumber) {
    this.homeOwnersPolicyNumber = homeOwnersPolicyNumber;
  }

  public void setAccidentsNameXselling(String accidentsNameXselling) {
    this.accidentsNameXselling = accidentsNameXselling;
  }

  public void setAccidentsNameUpgrade(String accidentsNameUpgrade) {
    this.accidentsNameUpgrade = accidentsNameUpgrade;
  }

  public void setAccidentsPolicyNumber(String accidentsPolicyNumber) {
    this.accidentsPolicyNumber = accidentsPolicyNumber;
  }

  public void setRetirementArrangementNameXselling(String retirementArrangementNameXselling) {
    this.retirementArrangementNameXselling = retirementArrangementNameXselling;
  }

  public void setRetirementArrangementNameUpgrade(String retirementArrangementNameUpgrade) {
    this.retirementArrangementNameUpgrade = retirementArrangementNameUpgrade;
  }

  public void setRetirementArrangementPolicyNumber(String retirementArrangementPolicyNumber) {
    this.retirementArrangementPolicyNumber = retirementArrangementPolicyNumber;
  }

  public void setPetOwnerLiabilityNameXselling(String petOwnerLiabilityNameXselling) {
    this.petOwnerLiabilityNameXselling = petOwnerLiabilityNameXselling;
  }

  public void setPetOwnerLiabilityNameUpgrade(String petOwnerLiabilityNameUpgrade) {
    this.petOwnerLiabilityNameUpgrade = petOwnerLiabilityNameUpgrade;
  }

  public void setPetOwnerLiabilityPolicyNumber(String petOwnerLiabilityPolicyNumber) {
    this.petOwnerLiabilityPolicyNumber = petOwnerLiabilityPolicyNumber;
  }

  public String getElectronicDeviceType() {
    return electronicDeviceType;
  }

  public Boolean getIsDeviceYounger3Month() {
    return isDeviceYounger3Month;
  }

  public String getIMEI() {
    return IMEI;
  }

  public String getSerial() {
    return serial;
  }

  public String getDevicePrice() {
    return devicePrice;
  }

  public String getPurchaseDay() {
    return purchaseDay;
  }

  public int getPurchaseMonth() {
    return purchaseMonth;
  }

  public String getPurchaseYear() {
    return purchaseYear;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public String getModel() {
    return model;
  }

  public String getPpp() {
    return ppp;
  }

  public Boolean getLiabilityPreviouslyInsured() {
    return liabilityPreviouslyInsured;
  }

  public String getLiabilityDamagePeriod() {
    return liabilityDamagePeriod;
  }

  public Boolean getLiabilityFailureCoverage() {
    return liabilityFailureCoverage;
  }

  public Boolean getLiabilityKeyLoss() {
    return liabilityKeyLoss;
  }

  public Boolean getLiabilityPublicService() {
    return liabilityPublicService;
  }

  public Boolean getLegalLivingCoverage() {
    return legalLivingCoverage;
  }

  public Boolean getLegalPrivateCoverage() {
    return legalPrivateCoverage;
  }

  public Boolean getLegalProfessionCoverage() {
    return legalProfessionCoverage;
  }

  public Boolean getLegalRentalCoverage() {
    return legalRentalCoverage;
  }

  public Boolean getLegalTrafficCoverage() {
    return legalTrafficCoverage;
  }

  public String getHouseholdNameUpgrade() {
    return householdNameUpgrade;
  }

  public String getHouseholdNameXselling() {
    return householdNameXselling;
  }

  public String getHouseholdPolicyNumber() {
    return householdPolicyNumber;
  }

  public String getHouseholdLivingSpace() {
    return householdLivingSpace;
  }

  public String getHouseholdBuildingType() {
    return householdBuildingType;
  }

  public Boolean getHouseholdBike() {
    return householdBike;
  }

  public String getHouseholdBikeCoverage() {
    return householdBikeCoverage;
  }

  public String getHouseholdInsuranceSum() {
    return householdInsuranceSum;
  }

  public Boolean getHouseholdPreviouslyInsured() {
    return householdPreviouslyInsured;
  }

  public String getHouseholdPreviousDamages() {
    return householdPreviousDamages;
  }

  public Boolean getHouseholdLightningCoverage() {
    return householdLightningCoverage;
  }

  public Boolean getHouseholdGlassBreakageCoverage() {
    return householdGlassBreakageCoverage;
  }

  public Boolean getHouseholdElementalDamageCoverage() {
    return householdElementalDamageCoverage;
  }

  public String getLegalNameUpgrade() {
    return legalNameUpgrade;
  }

  public Boolean getLegalFamilyCoverage() {
    return legalFamilyCoverage;
  }

  public String getLegalNameXselling() {
    return legalNameXselling;
  }

  public String getLegalPolicyNumber() {
    return legalPolicyNumber;
  }

  public String getLegalProfession() {
    return legalProfession;
  }

  public String getLiabilityNameUpgrade() {
    return liabilityNameUpgrade;
  }

  public String getLiabilityFamily() {
    return liabilityFamily;
  }

  public String getLiabilityNameXselling() {
    return liabilityNameXselling;
  }

  public String getLiabilityPolicyNumber() {
    return liabilityPolicyNumber;
  }

  public String getCarNameUpgrade() {
    return carNameUpgrade;
  }

  public String getCarNameXselling() {
    return carNameXselling;
  }

  public String getHomeOwnersNameXselling() {
    return homeOwnersNameXselling;
  }

  public String getHomeOwnersNameUpgrade() {
    return homeOwnersNameUpgrade;
  }

  public String getHomeOwnersPolicyNumber() {
    return homeOwnersPolicyNumber;
  }

  public String getAccidentsNameUpgrade() {
    return accidentsNameUpgrade;
  }

  public String getAccidentsPolicyNumber() {
    return accidentsPolicyNumber;
  }

  public String getRetirementArrangementNameXselling() {
    return retirementArrangementNameXselling;
  }

  public String getRetirementArrangementNameUpgrade() {
    return retirementArrangementNameUpgrade;
  }

  public String getRetirementArrangementPolicyNumber() {
    return retirementArrangementPolicyNumber;
  }

  public String getPetOwnerLiabilityNameUpgrade() {
    return petOwnerLiabilityNameUpgrade;
  }

  public String getPetOwnerLiabilityPolicyNumber() {
    return petOwnerLiabilityPolicyNumber;
  }

  public String getCarPolicyNumber() {
    return carPolicyNumber;
  }
}

