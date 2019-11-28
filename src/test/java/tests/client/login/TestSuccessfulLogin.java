package tests.client.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.client.LoginStep;
import tests.BaseTest;

public class TestSuccessfulLogin extends BaseTest {

    private static final String LOGOUT = "header__logout";

    @Test
    @Parameters({"email", "password"})

    public void testLogin(String email, String password) {
        LoginStep.loginInApp(email, password);
        Assert.assertTrue(driver.findElement(By.id(LOGOUT)).isDisplayed());
    }
}
