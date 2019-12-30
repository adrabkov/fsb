package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbOverallNeedAnalysisIntroPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbOverallNeedAnalysisIntroSteps extends AbstractScenarioSteps<HvbOverallNeedAnalysisIntroPage> {

    private HvbOverallNeedAnalysisIntroPage hvbOverallNeedAnalysisIntroPage;

    public HvbOverallNeedAnalysisIntroPage getPageObject() {
        return hvbOverallNeedAnalysisIntroPage;
    }

    @Step
    public String get_ona_intro_page_headline_text() {
        return getPageObject().getOnaIntroPageHeadlineText();
    }

    @Step
    public void click_ona_go_next_button() {
        getPageObject().clickOnaGoNextButton();
    }

    @Step
    public void click_remember_later_button(){
        getPageObject().clickOnaSkippButton();
    }

    @Step
    public void verify_ona_intro_page_is_loaded_after_addcontract_flow_during_onboarding(String ona_intro_headline_text_during_onboarding) {
        assertEquals(ona_intro_headline_text_during_onboarding, get_ona_intro_page_headline_text());
    }

}
