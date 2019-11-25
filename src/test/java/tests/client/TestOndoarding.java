package tests.client;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.client.onboarding.StepFirst;
import tests.BaseTest;

public class TestOndoarding extends BaseTest {

    @Test
    @Parameters({"firstName", "lastName", "birthDate", "streetName", "houseNumber", "postalCode", "city" })

    public void testRegistrationStep1(String firstName, String lastName, String birthDate, String streetName, String houseNumber, String postalCode, String city)  {
        StepFirst.fillingRequiredFields(firstName, lastName, birthDate, streetName, houseNumber, postalCode, city);
    }
}
