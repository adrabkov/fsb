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
    public void verify_ona_intro_page_is_loaded_and_headline_is_present(String ona_intro_headline) {
        assertEquals(ona_intro_headline, get_ona_intro_page_headline_text());
    }

    @Step
    public void verify_ona_intro_page_is_loaded_after_addcontract_flow_during_onboarding(String ona_intro_headline_text_during_onboarding) {
        assertEquals(ona_intro_headline_text_during_onboarding, get_ona_intro_page_headline_text());
    }

    @Step
    public void verify_ona_intro_page_is_loaded_after_click_on_profile_link(String ona_intro_headline_text_during_onboarding) {
        assertEquals(ona_intro_headline_text_during_onboarding, get_ona_intro_page_headline_text());
    }

    @StepGroup
    public void verify_ona_intro_page_is_loaded_and_click_on_go_next(String ona_intro_headline_text_during_onboarding) {
        verify_ona_intro_page_is_loaded_after_click_on_profile_link(ona_intro_headline_text_during_onboarding);
        click_ona_go_next_button();
    }

    @StepGroup
    public void verify_ona_intro_page_and_go_next(String ona_intro_headline) {
        verify_ona_intro_page_is_loaded_and_headline_is_present(ona_intro_headline);
        click_ona_go_next_button();
    }

}
