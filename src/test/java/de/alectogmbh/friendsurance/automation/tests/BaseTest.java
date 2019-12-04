package de.alectogmbh.friendsurance.automation.tests;

import de.alectogmbh.friendsurance.automation.driver.DriverHolder;
import de.alectogmbh.friendsurance.automation.driver.PropertyManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    private static PropertyManager globalConfig = new PropertyManager("timeout");
    private static long pageLoadTime = Long.parseLong(globalConfig.getSystemProperty("pageload"));
    private static long implicitlyWait = Long.parseLong(globalConfig.getSystemProperty("implicitlyWait"));
    private static PropertyManager envConfig = new PropertyManager("config");
    private static String startUrl = envConfig.getSystemProperty("startUrl");
    private static org.apache.logging.log4j.Logger log = LogManager.getLogger();

    @BeforeMethod
    public void setUp() {
        log.info("Starting browser");
        driver = DriverHolder.getInstance();
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(startUrl);
    }

    @AfterMethod
    public void tearDown() {
        log.info("Closing browser");
        DriverHolder.clean();
    }

    public static String getStartUrl() {
        return startUrl;
    }
}
