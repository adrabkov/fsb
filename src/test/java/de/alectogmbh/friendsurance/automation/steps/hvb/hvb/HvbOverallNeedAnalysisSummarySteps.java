package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbOverallNeedAnalysisSummaryPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbOverallNeedAnalysisSummarySteps extends AbstractScenarioSteps<HvbOverallNeedAnalysisSummaryPage> {

    private HvbOverallNeedAnalysisSummaryPage hvbOverallNeedAnalysisSummaryPage;

    public HvbOverallNeedAnalysisSummaryPage getPageObject() {
        return hvbOverallNeedAnalysisSummaryPage;
    }

    @Step
    public String get_ona_summary_page_headline_text() {
        return getPageObject().getOnaSummaryPageHeadlineText();
    }

    @Step
    public void verify_if_ona_summary_page_is_loaded(String EXPECTED_ONA_SUMMARY_PAGE_HEADLINE) {
        assertEquals(EXPECTED_ONA_SUMMARY_PAGE_HEADLINE, get_ona_summary_page_headline_text());
    }

    @Step
    public void click_on_save_ona_button() {
        getPageObject().clickOnSaveOnaButton();
    }

    @Step
    public String get_ona_completed_page_headline_text() {
        return getPageObject().getOnaCompletedPageHeadlineText();
    }

    @Step
    public void verify_if_ona_completed_page_is_loaded(String EXPECTED_ONA_COMPLETED_PAGE_HEADLINE) {
        assertEquals(EXPECTED_ONA_COMPLETED_PAGE_HEADLINE, get_ona_completed_page_headline_text());
    }

    @Step
    public void click_on_navigation_item_notifications_link() {
        getPageObject().clickOnNavigationItemNotificationsLink();
    }

    @StepGroup
    public void verify_ona_save_summary_and_completed_pages(String EXPECTED_ONA_SUMMARY_PAGE_HEADLINE) {
        verify_if_ona_summary_page_is_loaded(EXPECTED_ONA_SUMMARY_PAGE_HEADLINE);
        click_on_save_ona_button();
        verify_if_ona_completed_page_is_loaded(EXPECTED_ONA_SUMMARY_PAGE_HEADLINE);
    }

    @StepGroup
    public void verify_ona_summary_page_and_click_on_navigation_item_notifications_link(String EXPECTED_ONA_SUMMARY_PAGE_HEADLINE) {
        verify_if_ona_summary_page_is_loaded(EXPECTED_ONA_SUMMARY_PAGE_HEADLINE);
        click_on_navigation_item_notifications_link();
    }

}
