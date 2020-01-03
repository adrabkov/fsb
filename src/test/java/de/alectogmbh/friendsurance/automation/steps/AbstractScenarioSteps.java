package de.alectogmbh.friendsurance.automation.steps;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.TimeoutException;

public abstract class AbstractScenarioSteps<T extends AbstractPageObject> extends ScenarioSteps {

    public AbstractScenarioSteps() {
    }


    String[] para = {""};

    public AbstractScenarioSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void open_page() {
        try {
            getPageObject().open();
        } catch (TimeoutException exc) {
            getPageObject().evaluateJavascript("window.stop();");
        }
    }

    @Step
    public void open_page_named(String name) {
        try {
            getPageObject().open(name, para);
        } catch (TimeoutException exc) {
            getPageObject().evaluateJavascript("window.stop();");
        }
    }

    @Step
    public void click_on_cookiebar_close_button() {
        getPageObject().clickOnCookiebarCloseButton();
    }

    protected abstract T getPageObject();
}
