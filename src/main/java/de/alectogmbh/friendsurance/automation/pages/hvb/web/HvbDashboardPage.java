package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbDashboardPage.HOME_PAGE_URL;
import static java.util.concurrent.TimeUnit.SECONDS;

@At("#HOST" + HOME_PAGE_URL)
@DefaultUrl(HOME_PAGE_URL)
public class HvbDashboardPage extends AbstractPageObject {

  public static final String HOME_PAGE_URL = "/home/";

  @FindBy(id = "dashboard-home__headline")
  private WebElementFacade dashboardWelcomeText;

  @FindBy(id = "header-navigation__link-notifications")
  private WebElementFacade navigationItemNotificationsLink;

  @FindBy(id = "header_logout")
  private WebElementFacade dashboardHeaderLogoutLink;

  @FindBy(id = "dashboard-home_spinner")
  private WebElementFacade loading;

  private static final int SPINNER_TIMEOUT = 5;

  public String getDashboardHeadlineText() {
    dashboardWelcomeText.waitUntilVisible();
    return dashboardWelcomeText.getText();
  }

  public void clickOnNavigationItemNotificationsLink() {
    loading.withTimeoutOf(SPINNER_TIMEOUT, SECONDS).waitUntilNotVisible();
    navigationItemNotificationsLink.waitUntilVisible();
    scrollToElement(navigationItemNotificationsLink);
    navigationItemNotificationsLink.waitUntilClickable();
    navigationItemNotificationsLink.click();
  }

  public void clickOnDashboardHeaderLogoutLink() {
    dashboardHeaderLogoutLink.waitUntilVisible();
    scrollToElement(dashboardHeaderLogoutLink);
    dashboardHeaderLogoutLink.waitUntilClickable();
    dashboardHeaderLogoutLink.click();
  }

}
