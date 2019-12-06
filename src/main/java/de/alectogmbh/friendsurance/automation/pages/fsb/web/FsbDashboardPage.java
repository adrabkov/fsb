package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class FsbDashboardPage {

    @FindBy(id = "dashboard-home__headline")
    private WebElementFacade dashboardWelcomeText;

    public String getDashboardHeadlineText() {
        dashboardWelcomeText.waitUntilVisible();
        return dashboardWelcomeText.getText();
    }

}
