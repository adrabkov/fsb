package de.alectogmbh.friendsurance.automation.tests.web.utils.db;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DBCustomerData {

    private boolean gender;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String streetName;
    private String houseNumber;
    private String postalCode;
    private String place;
    private String email;
    private String incorrect_email;
    private String phoneNum;
    private String password;
    private String incorrect_password;
    private String repeatPassword;
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;
    private String userId;
    private String pin;

}
