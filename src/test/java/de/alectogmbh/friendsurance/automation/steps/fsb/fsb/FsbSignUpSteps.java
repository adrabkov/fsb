package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbSignUpPage;

public class FsbSignUpSteps {

    public static void fillingFieldsForStep2(String email, String password){
        FsbSignUpPage signupPage = new FsbSignUpPage();

        signupPage.fillEmailField(email);
        signupPage.fillPasswordField(password);
        signupPage.clickCondition1();
        signupPage.clickCondition2();
        signupPage.clickCondition3();
        signupPage.clickSubmitButton();
    }
}
