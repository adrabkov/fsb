package de.alectogmbh.friendsurance.automation.tests;

import de.alectogmbh.friendsurance.automation.driver.DriverHolder;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractScenarioTest <T extends AbstractScenarioSteps>{

    private final static int PAGE_LOAD_TIMEOUT = 15;

    @Before
    public void settingTimeout() {
        webdriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();
        webdriver.get("https://fsb.fsb1.safeties.de");
    }

    @Managed(uniqueSession = true)
    public WebDriver webdriver = DriverHolder.getInstance();

    @ManagedPages
    public Pages pages;

    protected abstract T getSteps();
}
