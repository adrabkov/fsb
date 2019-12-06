package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbDashboardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static junit.framework.TestCase.assertEquals;

public class FsbDashboardSteps {

    private static final String EXPECTED_DASHBOARD_HEADLINE = "Ihre Versicherungen auf einen Blick";

    private FsbDashboardPage fsbDashboardPage;

    private FsbDashboardPage getPageObject() {
        return fsbDashboardPage;
    }

    @Step
    public String get_dashboard_headline_text() {
        return getPageObject().getDashboardHeadlineText();
    }

    @StepGroup
    public void verify_if_home_page_is_loaded_and_dashboard_headline_is_present() {
        assertEquals(EXPECTED_DASHBOARD_HEADLINE, get_dashboard_headline_text());
    }
}
