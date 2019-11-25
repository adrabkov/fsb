package steps.client;

import form.BaseForm;
import pages.Login;
import pages.onboarding.StartPage;

public class LoginStep extends BaseForm {

    public static void loginInApp(String email, String password) {
        log.info("Clicking to login page");
        new StartPage().clickLoginButton();
        Login login = new Login();
        log.info("filling email field");
        login.fillEmailField(email);
        log.info("filling password field");
        login.fillPasswordField(password);
        log.info("clicking login button");
        login.clickLoginButton();
    }
}
