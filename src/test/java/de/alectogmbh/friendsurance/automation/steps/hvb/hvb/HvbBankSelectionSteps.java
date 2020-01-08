package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbBankSelectionPage;
import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbLandingPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbBankSelectionSteps extends AbstractScenarioSteps<HvbBankSelectionPage> {

    private HvbBankSelectionPage hvbBankSelectionPage;

    private HvbLandingPage hvbLandingPage;

    public HvbBankSelectionPage getPageObject() {
        return hvbBankSelectionPage;
    }

    @Step
    public void open_onboarding_first_step() {
        getPageObject().open();
    }

    @Step
    public String get_bank_selection_headline_text() {
        return getPageObject().getBankSelectionHeadlineText();
    }

    @Step
    public void verify_if_bank_name_selector_is_present_and_field_is_empty() {
        getPageObject().waitUntilBankNameSelectorIsPresent();
    }

    @Step
    public void select_bank_name_by_text(String bankName) {
        getPageObject().selectBankNameByText(bankName);
    }

    @Step
    public void click_bank_selection_next_button() {
        getPageObject().clickBankSelectionNextButton();
    }

    @Step
    public void verify_bank_selection_page_is_loaded_and_headline_is_present(String bank_selection_headline) {
        assertEquals(bank_selection_headline, get_bank_selection_headline_text());
    }

    @StepGroup
    public void verify_first_step_select_bank_branch_and_click_on_next_button(String bank_selection_headline, String bank_name) {
        open_onboarding_first_step();
        hvbLandingPage.acceptBanner();
        verify_bank_selection_page_is_loaded_and_headline_is_present(bank_selection_headline);
        click_on_cookiebar_close_button();
        verify_if_bank_name_selector_is_present_and_field_is_empty();
        select_bank_name_by_text(bank_name);
        click_bank_selection_next_button();
    }

}
