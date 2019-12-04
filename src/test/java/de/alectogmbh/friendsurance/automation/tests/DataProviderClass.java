package de.alectogmbh.friendsurance.automation.tests;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "data for registration")
    public static Object[][] dataProviderMethod() {
        return new Object[][]{
                {"alex", "tester", "03.03.1980", "linina", "15", "12345", "mogilev"}};
    }
}
