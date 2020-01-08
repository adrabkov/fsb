package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbLandingPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;

public class HvbLandingSteps extends AbstractScenarioSteps<HvbLandingPage> {

    private HvbLandingPage hvbLandingPage;

    public HvbLandingPage getPageObject() {
        return hvbLandingPage;
    }

    @Step
    public void open_landing_page() {
        getPageObject().open();
    }

    @Step
    public void click_on_header_login_link() {
        getPageObject().clickOnHeaderLoginLink();
    }

    @Step
    public void click_on_key_visual_login_button() {
        getPageObject().clickOnKeyVisualLoginButton();
    }

    @Step
    public void click_accept_button() {
        getPageObject().acceptBanner();
    }

}
