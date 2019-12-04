package de.alectogmbh.friendsurance.automation.pages;


import com.google.common.base.Predicate;
import de.alectogmbh.friendsurance.automation.utils.SeleniumWaitUtils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



public abstract class AbstractPageObject extends PageObject {

  @FindBy(className = "cookiebar-container__close--button")
  private WebElementFacade cookiebarCloseButton;

  protected AbstractPageObject() {
  }

//  protected AbstractPageObject(WebDriver driver, Predicate<PageObject> callback) {
//    super(driver, callback);
//  }

  public AbstractPageObject(WebDriver driver, int ajaxTimeout) {
    super(driver, ajaxTimeout);
  }

  public AbstractPageObject(WebDriver driver) {
    super(driver);
  }

//  public String getCurrentPageUrl() {
//    waitFor(ExpectedConditions.jsReturnsValue(
//        "return document.readyState != 'loading' ? document.readyState : undefined"));
//    return getDriver().getCurrentUrl();
//  }

  public String getCurrentPageTitle() {
    return getDriver().getTitle();
  }

//  protected void dynamicWaitForElementPresence(By by, int timeoutInSeconds) {
//    WebElement myDynamicElement = (new WebDriverWait(getDriver(), timeoutInSeconds))
//        .until(ExpectedConditions.presenceOfElementLocated(by));
//  }

//  public void scroll_element_into_view(WebElementFacade element) {
//    int Y = (element.getLocation().getY() - 300);
//    JavascriptExecutor js = (JavascriptExecutor) getDriver();
//    js.executeScript("javascript:window.scrollTo(0," + Y + ");");
//  }

  public void scrollToElement(WebElement webElement) {
    Actions actions = new Actions(getDriver());
    actions.moveToElement(webElement);
    actions.perform();
  }

//  public void clickOnCookiebarCloseButton() {
//    cookiebarCloseButton.waitUntilClickable();
//    cookiebarCloseButton.click();
//  }

  protected void implicitWait(int timeoutInSeconds) {
    getDriver().manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.MILLISECONDS);
  }

//  public void scrollAndClick(String id) {
//    executeActionWithElementById(getDriver(), id, new SeleniumWaitUtils.Action() {
//      @Override
//      public void execute(WebElement webElement) {
//        scrollToElement(webElement);
//        webElement.click();
//      }
//    });
//  }

}
