package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbBankSelectionPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbBankSelectionSteps extends AbstractScenarioSteps<HvbBankSelectionPage> {

    private static final String EXPECTED_BANK_SELECTION_HEADLINE = "Bei welcher Bank sind Sie Kunde?";
    private static final String BANK_NAME = "Leipzig";

    private HvbBankSelectionPage hvbBankSelectionPage;

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
    public void verify_bank_selection_page_is_loaded_and_headline_is_present() {
        assertEquals(EXPECTED_BANK_SELECTION_HEADLINE, get_bank_selection_headline_text());
    }

    @StepGroup
    public void verify_first_step_select_bank_branch_and_click_on_next_button() {
        open_onboarding_first_step();
        verify_bank_selection_page_is_loaded_and_headline_is_present();
        click_on_cookiebar_close_button();
        verify_if_bank_name_selector_is_present_and_field_is_empty();
        select_bank_name_by_text(BANK_NAME);
        click_bank_selection_next_button();
    }

}