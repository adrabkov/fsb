package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbOverallNeedAnalysisSummaryPage.ONA_SUMMARY_PAGE_URL;
import static de.alectogmbh.friendsurance.automation.utils.SeleniumWaitUtils.waitForAnimationToFinish;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@At("#HOST" + ONA_SUMMARY_PAGE_URL)
@DefaultUrl(ONA_SUMMARY_PAGE_URL)
public class FsbOverallNeedAnalysisSummaryPage extends BaseForm {

    final static String ONA_SUMMARY_PAGE_URL = "/overallneedanalysis/summary/";

    @FindBy(id = "intro")
    private WebElement onaSummaryPageHeadlineText;

    @FindBy(id = "overallneedanalysis-gonext__button")
    private WebElement onaSaveButton;

    @FindBy(id = "overallneedanalysis-completed-intro-header")
    private WebElement onaCompletedHeadlineText;

    @FindBy(id = "overallneedanalysis-completed__gonext-button")
    private WebElement onaCompletedGoNextButton;

    private static final int TIME_IN_SECONDS = 5;

    public String getOnaSummaryPageHeadlineText() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, onaSummaryPageHeadlineText);
//        onaSummaryPageHeadlineText.waitUntilVisible();
//        scrollToElement(onaSummaryPageHeadlineText);
        return onaSummaryPageHeadlineText.getText();
    }

    public void clickOnSaveOnaButton() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, onaSaveButton);
//        onaSaveButton.waitUntilVisible();
//        scroll_element_into_view(onaSaveButton);
//        onaSaveButton.waitUntilClickable();
        onaSaveButton.click();
    }

    public String getOnaCompletedPageHeadlineText() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, onaCompletedHeadlineText);
//        onaCompletedHeadlineText.waitUntilVisible();
        return onaCompletedHeadlineText.getText();
    }

    public void clickOnaCompletedGoNextButton() {
        onaCompletedGoNextButton.click();
    }
}
