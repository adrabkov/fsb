package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbSignOrderPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbSignOrderSteps extends AbstractScenarioSteps<HvbSignOrderPage> {

    private HvbSignOrderPage hvbSignOrderPage;

    public HvbSignOrderPage getPageObject() {
        return hvbSignOrderPage;
    }

    @Step
    public String get_sign_order_page_headline() {
        return getPageObject().getSignOrderPageHeadline();
    }

    @Step
    public void sign_authorize_component() {
        getPageObject().sign();
    }

    @Step
    public void click_sign_order_submit_button() {
        getPageObject().clickSignOrderSubmitButton();
    }

    @Step
    public void verify_sign_order_page_is_loaded_and_headline_is_present(String sign_order_page_headline) {
        assertEquals(sign_order_page_headline, get_sign_order_page_headline());
    }

    @StepGroup
    public void verify_sign_authorization_and_submit_order_items(String sign_order_page_headline) {
        verify_sign_order_page_is_loaded_and_headline_is_present(sign_order_page_headline);
        sign_authorize_component();
        click_sign_order_submit_button();
    }

}
