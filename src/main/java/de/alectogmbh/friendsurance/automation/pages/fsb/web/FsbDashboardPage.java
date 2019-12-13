package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbDashboardPage.HOME_PAGE_URL;

@At("#HOST" + HOME_PAGE_URL)
@DefaultUrl(HOME_PAGE_URL)
public class FsbDashboardPage {

    final static String HOME_PAGE_URL = "/home/";

    @FindBy(id = "dashboard-home__headline")
    private WebElementFacade dashboardWelcomeText;

    @FindBy(id = "header-navigation__link-notifications")
    private WebElementFacade navigationItemNotificationsLink;

    @FindBy(id = "header__logout")
    private WebElementFacade dashboardHeaderLogoutLink;

    public String getDashboardHeadlineText() {
        dashboardWelcomeText.waitUntilVisible();
        return dashboardWelcomeText.getText();
    }

    public void clickOnNavigationItemNotificationsLink() {
        navigationItemNotificationsLink.waitUntilClickable();
        navigationItemNotificationsLink.click();
    }

    public void clickOnDashboardHeaderLogoutLink() {
        dashboardHeaderLogoutLink.waitUntilClickable();
        dashboardHeaderLogoutLink.click();
    }

}
