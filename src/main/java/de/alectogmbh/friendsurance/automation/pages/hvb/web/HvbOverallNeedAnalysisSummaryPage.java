package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbOverallNeedAnalysisSummaryPage.ONA_SUMMARY_PAGE_URL;
import static de.alectogmbh.friendsurance.automation.utils.SeleniumWaitUtils.waitForAnimationToFinish;

@At("#HOST" + ONA_SUMMARY_PAGE_URL)
@DefaultUrl(ONA_SUMMARY_PAGE_URL)
public class HvbOverallNeedAnalysisSummaryPage extends AbstractPageObject {

    final static String ONA_SUMMARY_PAGE_URL = "/home/profile/overallneedanalysis/summary/";

    @FindBy(id = "intro")
    private WebElementFacade onaSummaryPageHeadlineText;

    @FindBy(id = "overallneedanalysis-gonext__button")
    private WebElementFacade onaSaveButton;

    @FindBy(id = "overallneedanalysis-completed-intro-header")
    private WebElementFacade onaCompletedHeadlineText;

    @FindBy(id = "header-navigation__link-notifications")
    private WebElementFacade navigationItemNotificationsLink;

    private static final int TIME_IN_SECONDS = 5;

    public String getOnaSummaryPageHeadlineText() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, onaSummaryPageHeadlineText);
        onaSummaryPageHeadlineText.waitUntilVisible();
        scrollToElement(onaSummaryPageHeadlineText);
        return onaSummaryPageHeadlineText.getText();
    }

    public void clickOnSaveOnaButton() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, onaSaveButton);
        onaSaveButton.waitUntilVisible();
        scroll_element_into_view(onaSaveButton);
        onaSaveButton.waitUntilClickable();
        onaSaveButton.click();
    }

    public void clickOnNavigationItemNotificationsLink() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, navigationItemNotificationsLink);
        scrollToElement(navigationItemNotificationsLink);
        navigationItemNotificationsLink.waitUntilClickable();
        navigationItemNotificationsLink.click();
    }

    public String getOnaCompletedPageHeadlineText() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, onaCompletedHeadlineText);
        onaCompletedHeadlineText.waitUntilVisible();
        return onaCompletedHeadlineText.getText();
    }

}


