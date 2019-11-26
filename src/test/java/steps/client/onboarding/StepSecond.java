package steps.client.onboarding;

import pages.onboarding.SignupPage;

public class StepSecond {

    public static void fillingFieldsForStep2(String email, String password){
        SignupPage signupPage = new SignupPage();

        signupPage.fillEmailField(email);
        signupPage.fillPasswordField(password);
        signupPage.clickCondition1();
        signupPage.clickCondition2();
        signupPage.clickCondition3();
        signupPage.clickSubmitButton();
    }
}
