package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbOverallNeedAnalysisSummaryPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class FsbOverallNeedAnalysisSummarySteps extends AbstractScenarioSteps<FsbOverallNeedAnalysisSummaryPage> {

//    private static final String EXPECTED_ONA_SUMMARY_PAGE_HEADLINE = "Noch einmal alles auf einen Blick.";
//    private static final String EXPECTED_ONA_COMPLETED_PAGE_HEADLINE = "Großartig, vielen Dank! Dann kann’s ja losgehen.";

    private FsbOverallNeedAnalysisSummaryPage ruvOverallNeedAnalysisSummaryPage;

    public FsbOverallNeedAnalysisSummaryPage getPageObject() {
        return ruvOverallNeedAnalysisSummaryPage;
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

    @StepGroup
    public void verify_ona_save_summary_and_completed_pages(String EXPECTED_ONA_SUMMARY_PAGE_HEADLINE, String EXPECTED_ONA_COMPLETED_PAGE_HEADLINE) {
        verify_if_ona_summary_page_is_loaded(EXPECTED_ONA_SUMMARY_PAGE_HEADLINE);
        click_on_save_ona_button();
        verify_if_ona_completed_page_is_loaded(EXPECTED_ONA_COMPLETED_PAGE_HEADLINE);
    }
}
