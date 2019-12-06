package de.alectogmbh.friendsurance.automation.tests.fsb.web.web.utils.db;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class DBCustomerDataUtils {

    private static final int DEFAULT_GENERATED_DATA_LENGTH = 10;

    public static DBCustomerData createDBCustomerData() {

        DBCustomerData customerData = DBCustomerData.builder()
                .birthDay("12.11.1991")
                .confirmNewPassword("Fake2*password")
                .email(UUID.randomUUID() + "@yopmail.com")
                .incorrect_email(UUID.randomUUID() + "yopmail.com")
                .firstName(RandomStringUtils.randomAlphabetic(DEFAULT_GENERATED_DATA_LENGTH))
                .houseNumber("12 a")
                .lastName(RandomStringUtils.randomAlphabetic(DEFAULT_GENERATED_DATA_LENGTH))
                .newPassword("Fake2*password")
                .oldPassword("Fake1*password")
                .place("Hamburg")
                .pin("PINTAN")
                .postalCode(RandomStringUtils.randomNumeric(5))
                .phoneNum(0 + RandomStringUtils.randomNumeric(DEFAULT_GENERATED_DATA_LENGTH))
                .password("Test1@34")
                .incorrect_password("123")
                .repeatPassword("Fake1*password")
                .streetName("Hohenzollerndamm Platz")
                .userId("12345")
                .build();

        return customerData;
    }
}
