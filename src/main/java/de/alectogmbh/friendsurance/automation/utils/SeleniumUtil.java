package de.alectogmbh.friendsurance.automation.utils;

import net.serenitybdd.core.pages.WebElementFacade;

public class SeleniumUtil {

  public static void typeInputAndEnter(WebElementFacade webElementFacade, String text) {
    webElementFacade.click();
    webElementFacade.typeAndEnter(text);
  }

  public static void typeInput(WebElementFacade webElementFacade, String text) {
    webElementFacade.click();
    webElementFacade.type(text);
  }

}
