package de.alectogmbh.friendsurance.automation.form;

import de.alectogmbh.friendsurance.automation.driver.DriverHolder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public abstract class BaseForm {
//    protected static org.apache.logging.log4j.Logger log = LogManager.getLogger();

    public BaseForm() {
        PageFactory.initElements(DriverHolder.getInstance(), this);
    }

    public void scroll_element_into_view(WebElement element) {
        int Y = (element.getLocation().getY() - 300);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("javascript:window.scrollTo(0," + Y + ");");
    }

    public void scrollToElement(WebElement webElement) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(webElement);
        actions.perform();
    }
}
