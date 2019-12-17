package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbSignOrderPage;
import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbSignUpPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.junit.Assert.assertEquals;

public class FsbSignOrderSteps extends AbstractScenarioSteps<FsbSignOrderPage> {

    private static final String EXPECTED_SIGN_UP_PAGE_HEADLINE = "Fehlt nur noch das Maklermandat.";

    private FsbSignOrderPage fsbSignOrderPage;

    public FsbSignOrderPage getPageObject() {
        return fsbSignOrderPage;
    }

    @Step
    public String get_sign_order_page_headline(){
        return getPageObject().getSignOrderPageHeadline().replaceAll(LF, SPACE);
    }

    @Step
    public void sign_authorize_component(){
        getPageObject().sign();
    }

    @Step
    public void click_sign_order_submit_button() {
        getPageObject().clickSignOrderSubmitButton();
    }

    @Step
    public void verify_sign_order_page_is_loaded_and_headline_is_present() {
        assertEquals(EXPECTED_SIGN_UP_PAGE_HEADLINE, get_sign_order_page_headline());
    }

    @StepGroup
    public void verify_sign_authorization_and_submit_order_items(){
        verify_sign_order_page_is_loaded_and_headline_is_present();
        sign_authorize_component();
        click_sign_order_submit_button();
        click_sign_order_submit_button();
    }

}
