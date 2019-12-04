package de.alectogmbh.friendsurance.automation.steps.web.utils;

public class CustomerData {

  private Boolean isNewUser;

  private String title;
  private String firstName;
  private String lastName;
  private String email;
  private String accountNumber;
  private String accountHolder;
  private String bankCode;
  private String iban;
  private Boolean acceptSEPA;
  private String paymentType;
  private String phoneNumber;
  private String mobileNumber;
  private String faxNumber;
  private String gender;
  private String profession;
  private String birthDay;
  private int birthMonth;
  private String birthMonthString;
  private String birthYear;
  private String postalCode;
  private String city;
  private String street;
  private String houseNumber;
  private String familyStatus;
  private boolean acceptLegals;
  private boolean acceptSpecial;
  private boolean acceptPhoneOptIn;
  private String password;
  private String passwordVerify;

  public CustomerData() {

  }

  public CustomerData(
      Boolean isNewUser,
      String title, String firstName, String lastName, String email, String accountNumber,
      String accountHolder, String bankCode,
      String iban, Boolean acceptSEPA, String paymentType, String phoneNumber, String mobileNumber,
      String faxNumber, String gender,
      String profession, String birthDay, int birthMonth, String birthMonthString, String birthYear,
      String postalCode, String city, String street,
      String houseNumber, String familyStatus, boolean acceptLegals, boolean acceptSpecial,
      boolean acceptPhoneOptIn, String password,
      String passwordVerify
  ) {
    this.isNewUser = isNewUser;
    this.title = title;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.accountNumber = accountNumber;
    this.accountHolder = accountHolder;
    this.bankCode = bankCode;
    this.iban = iban;
    this.acceptSEPA = acceptSEPA;
    this.paymentType = paymentType;
    this.phoneNumber = phoneNumber;
    this.mobileNumber = mobileNumber;
    this.faxNumber = faxNumber;
    this.gender = gender;
    this.profession = profession;
    this.birthDay = birthDay;
    this.birthMonth = birthMonth;
    this.birthYear = birthYear;
    this.postalCode = postalCode;
    this.city = city;
    this.street = street;
    this.houseNumber = houseNumber;
    this.familyStatus = familyStatus;
    this.acceptLegals = acceptLegals;
    this.acceptSpecial = acceptSpecial;
    this.acceptPhoneOptIn = acceptPhoneOptIn;
    this.password = password;
    this.passwordVerify = passwordVerify;
    this.birthMonthString = birthMonthString;

  }

  public void setIsNewUser(Boolean isNewUser) {
    this.isNewUser = isNewUser;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }

  public void setAccountHolder(String accountHolder) {
    this.accountHolder = accountHolder;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public void setAcceptSEPA(Boolean acceptSEPA) {
    this.acceptSEPA = acceptSEPA;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public void setBirthDay(String birthDay) {
    this.birthDay = birthDay;
  }

  public void setBirthMonth(int birthMonth) {
    this.birthMonth = birthMonth;
  }

  public void setBirthMonthString(String birthMonthString) {
    this.birthMonthString = birthMonthString;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }

  public void setFamilyStatus(String familyStatus) {
    this.familyStatus = familyStatus;
  }

  public void setAcceptLegals(boolean acceptLegals) {
    this.acceptLegals = acceptLegals;
  }

  public void setAcceptSpecial(boolean acceptSpecial) {
    this.acceptSpecial = acceptSpecial;
  }

  public void setAcceptPhoneOptIn(boolean acceptPhoneOptIn) {
    this.acceptPhoneOptIn = acceptPhoneOptIn;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setPasswordVerify(String passwordVerify) {
    this.passwordVerify = passwordVerify;
  }

  public Boolean getIsNewUser() {
    return isNewUser;
  }

  public String getTitle() {
    return title;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getBankCode() {
    return bankCode;
  }

  public String getAccountHolder() {
    return accountHolder;
  }

  public String getIban() {
    return iban;
  }

  public Boolean getAcceptSEPA() {
    return acceptSEPA;
  }

  public String getPaymentType() {
    return paymentType;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getFaxNumber() {
    return faxNumber;
  }

  public String getGender() {
    return gender;
  }

  public String getProfession() {
    return profession;
  }

  public String getBirthDay() {
    return birthDay;
  }

  public int getBirthMonth() {
    return birthMonth;
  }

  public String getBirthMonthString() {
    return birthMonthString;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public String getCity() {
    return city;
  }

  public String getStreet() {
    return street;
  }

  public String getHouseNumber() {
    return houseNumber;
  }

  public String getFamilyStatus() {
    return familyStatus;
  }

  public Boolean getAcceptLegals() {
    return acceptLegals;
  }

  public Boolean getAcceptSpecial() {
    return acceptSpecial;
  }

  public Boolean getAcceptPhoneOptIn() {
    return acceptPhoneOptIn;
  }

  public String getPassword() {
    return password;
  }

  public String getPasswordVerify() {
    return passwordVerify;
  }
}



