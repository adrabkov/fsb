package models;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonFunctions {

    private String email = randomEmail();
    private String incorrectEmail = randomWrongEmail();
    private String incorrectPassword = randomWrongPassword();

    private static String randomEmail(){
        String randomString = RandomStringUtils.random(5, true, true);
        return randomString + "@yopmail.com";
    }

    private static String randomWrongEmail(){
        String randomString = RandomStringUtils.random(5, true, true);
        return randomString + "yopmail.com";
    }

    private static String randomWrongPassword() {
        return RandomStringUtils.random(7, true, false);
    }

    public String getEmail() {
        return email;
    }

    public String getIncorrectEmail() {
        return incorrectEmail;
    }

    public String getIncorrectPassword() {
        return incorrectPassword;
    }
}


