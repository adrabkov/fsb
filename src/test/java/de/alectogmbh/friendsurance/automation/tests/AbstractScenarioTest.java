package de.alectogmbh.friendsurance.automation.tests;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public abstract class AbstractScenarioTest <T extends AbstractScenarioSteps>{

    private final static int PAGE_LOAD_TIMEOUT = 15;

    @Before
    public void settingTimeout() {
        webdriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    protected abstract T getSteps();
}
