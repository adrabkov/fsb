package de.alectogmbh.friendsurance.automation.tests.web.utils;


import de.alectogmbh.friendsurance.automation.steps.web.utils.CustomerData;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class CustomerDataUtils {


  private static final int DEFAULT_GENERATED_DATA_LENGTH = 6;

  private static final String EMAIL_DOMAIN = "@safeties.de";
  private static final String DEFAULT_ACCOUNT_NUMBER = "1148489891";
  private static final String DEFAULT_BANK_CODE = "50010517";
  private static final String DEFAULT_IBAN = "DE11500105171148489891";
  private static final String DEFAULT_ACCOUNT_HOLDER = "bla bla";
  private static final String DEFAULT_PAYMENT_TYPE = "directDebit";
  private static final boolean DEFAULT_ACCEPT_SEPA = true;
  private static final String PASSWORD = "password";
  private static final int EMAIL_MAX_LENGTH = 255;
  public static final int PASSWORD_LENGTH_MIN = 6;
  public static final int NAME_LENGTH_MIN = 2;
  public static final int NAME_LENGTH_MAX = 25;

  public CustomerData createCorrectCustomerData() {
    CustomerData customerData = new CustomerData();
    customerData.setIsNewUser(Boolean.TRUE);
    customerData.setTitle("BSc");
    customerData.setFirstName(RandomStringUtils.randomAlphabetic(DEFAULT_GENERATED_DATA_LENGTH));
    customerData.setLastName(RandomStringUtils.randomAlphabetic(DEFAULT_GENERATED_DATA_LENGTH));
    customerData.setEmail(
        UUID.randomUUID().toString() +
            EMAIL_DOMAIN);
    customerData.setAccountNumber(DEFAULT_ACCOUNT_NUMBER);
    customerData.setBankCode(DEFAULT_BANK_CODE);
    customerData.setAccountHolder(DEFAULT_ACCOUNT_HOLDER);
    customerData.setIban(DEFAULT_IBAN);
    customerData.setAcceptSEPA(DEFAULT_ACCEPT_SEPA);
    customerData.setPaymentType(DEFAULT_PAYMENT_TYPE);
    customerData.setPhoneNumber("03075687587");
    customerData.setMobileNumber("017975687587");
    customerData.setFaxNumber("098765432");
    customerData.setBirthDay("12");
    customerData.setBirthMonth(12);
    customerData.setBirthMonthString("Juli");
    customerData.setBirthYear("1955");
    customerData.setGender("MALE");
    customerData.setProfession("Test Engineer");
    customerData.setPostalCode("10117");
    customerData.setCity("Berlin");
    customerData.setStreet("Alexanderufer");
    customerData.setHouseNumber("12");
    customerData.setFamilyStatus("Single");
    customerData.setAcceptLegals(true);
    customerData.setAcceptSpecial(true);
    customerData.setAcceptPhoneOptIn(true);
    customerData.setPassword(PASSWORD);
    customerData.setPasswordVerify(customerData.getPassword());
    return customerData;
  }
}
