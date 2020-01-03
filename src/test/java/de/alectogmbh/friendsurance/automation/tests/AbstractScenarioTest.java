package de.alectogmbh.friendsurance.automation.tests;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.tests.web.utils.JsonParser;
import de.alectogmbh.friendsurance.automation.tests.web.utils.HvbMessages;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerDataUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public abstract class AbstractScenarioTest<T extends AbstractScenarioSteps> {

    private final static int PAGE_LOAD_TIMEOUT = 15;
    private final static String FILE_PATH_JSON = "src/test/resources/expectedMessages.json";

    protected HvbMessages messages = new JsonParser().mapToObject(FILE_PATH_JSON, HvbMessages.class);
    protected DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

//    @Before
//    public void settingTimeout() {
//        webdriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    }

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    protected Clients clients;

    protected abstract T getSteps();
}
