package de.alectogmbh.friendsurance.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(BrowserUtils.class);


  public static void clearBrowserStorage(WebDriver webDriver) {
    try {
      ((JavascriptExecutor) webDriver).executeScript("window.localStorage.clear();");
    } catch (Exception exc) {
      LOGGER.warn("Was not able to clear browser storage", exc);
    }
  }

  public static void switchToSecondWindow(WebDriver webDriver) {
    String currentWindow = webDriver.getWindowHandle();
    for (String windowHandle : webDriver.getWindowHandles()) {
      if (!currentWindow.equals(windowHandle)) {
        webDriver.switchTo().window(windowHandle);
      }
    }
  }

}
