package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbDeleteAccountPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.junit.Assert.assertEquals;

public class HvbDeleteAccountSteps extends AbstractScenarioSteps<HvbDeleteAccountPage> {

    private HvbDeleteAccountPage hvbDeleteAccountPage;

    public HvbDeleteAccountPage getPageObject() {
        return hvbDeleteAccountPage;
    }

    @Step
    public String get_delete_account_page_headline_text() {
        return getPageObject().getDeleteAccountPageHeadline().replaceAll(LF, SPACE);
    }

    @Step
    public void click_on_delete_account_request_button() {
        getPageObject().clickOnDeleteAccountRequestButton();
    }

    @Step
    public void switch_to_delete_account_modal_window_prompt() {
        getPageObject().switchToDeleteAccountModalWindowPrompt();
    }

    @Step
    public void click_on_delete_account_modal_window_confirm_button() {
        getPageObject().clickOnDeleteAccountModalWindowConfirmButton();
    }

    @Step
    public void verify_delete_account_page_is_loaded(String deleteAccountPageHeadline) {
        assertEquals(deleteAccountPageHeadline, get_delete_account_page_headline_text());
    }

    @StepGroup
    public void switch_to_delete_account_modal_window_and_click_on_confirm_button() {
        switch_to_delete_account_modal_window_prompt();
        click_on_delete_account_modal_window_confirm_button();
    }

}
