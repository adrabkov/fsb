package tests.client.Login;

import form.BaseForm;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.client.LoginStep;
import tests.BaseTest;

public class TestSuccessfulLogin extends BaseTest {

    @Test
    @Parameters({"email", "password"})

    public void testLogin(String email, String password) {
        LoginStep.loginInApp(email, password);
        Assert.assertTrue(driver.findElement(By.id("header__logout")).isDisplayed());
    }
}
