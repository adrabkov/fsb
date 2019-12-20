package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbOverallNeedAnalysisIntroPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import static org.junit.Assert.assertEquals;

public class HvbOverallNeedAnalysisIntroSteps extends AbstractScenarioSteps<HvbOverallNeedAnalysisIntroPage> {

  private static final String EXPECTED_ONA_INTRO_HEADLINE_TEXT = "5 kleine Fragen für eine passgenaue Absicherung!";

  private static final String EXPECTED_ONA_INTRO_HEADLINE_TEXT_DURING_ONBOARDING = "Noch 5 kleine Fragen, dann sind wir durch!";

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
  public void verify_ona_intro_page_is_loaded_and_headline_is_present() {
    assertEquals(EXPECTED_ONA_INTRO_HEADLINE_TEXT, get_ona_intro_page_headline_text());
  }

  @Step
  public void verify_ona_intro_page_is_loaded_after_addcontract_flow_during_onboarding() {
    assertEquals(EXPECTED_ONA_INTRO_HEADLINE_TEXT_DURING_ONBOARDING, get_ona_intro_page_headline_text());
  }

  @Step
  public void verify_ona_intro_page_is_loaded_after_click_on_profile_link() {
    assertEquals(EXPECTED_ONA_INTRO_HEADLINE_TEXT_DURING_ONBOARDING, get_ona_intro_page_headline_text());
  }

  @StepGroup
  public void verify_ona_intro_page_is_loaded_and_click_on_go_next() {
    verify_ona_intro_page_is_loaded_after_click_on_profile_link();
    click_ona_go_next_button();
  }

  @StepGroup
  public void verify_ona_intro_page_and_go_next() {
    verify_ona_intro_page_is_loaded_and_headline_is_present();
    click_ona_go_next_button();
  }

}
