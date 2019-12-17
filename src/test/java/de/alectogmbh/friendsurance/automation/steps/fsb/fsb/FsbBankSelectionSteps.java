package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbBankSelectionPage;

import static org.junit.Assert.assertEquals;

public class FsbBankSelectionSteps extends AbstractScenarioSteps<FsbBankSelectionPage> {

    private static final String EXPECTED_BANK_SELECTION_HEADLINE = "Bei welcher Bank sind Sie Kunde?";
    private static final String EXPECTED_BANK_MODAL_TEXT = "Ihr Konto schnell und sicher verbinden mit";
    private static final String BANK_NAME = "Leipziger Volksbank";
    private static final String EXPECTED_BANK_SELECTION_ERROR_TEXT = "Bitte wählen Sie eine Bank aus.";

    private FsbBankSelectionPage fsbBankSelectionPage;

    public FsbBankSelectionPage getPageObject() {
        return fsbBankSelectionPage;
    }

    @Step
    public String get_bank_selection_headline_text() {
        return getPageObject().getBankSelectionHeadlineText();
    }

    @Step
    public String get_bank_modal_selection_text() {
        return getPageObject().getBankModalSelectionText();
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
    public void click_bank_modal_ok_button() {
        getPageObject().clickBankModalOkButton();
    }


    @Step
    public void verify_bank_selection_page_is_loaded_and_headline_is_present() {
        assertEquals(EXPECTED_BANK_SELECTION_HEADLINE, get_bank_selection_headline_text());
    }

    @Step
    public void verify_bank_modal_finApi_popUp_is_present() {
        assertEquals(EXPECTED_BANK_MODAL_TEXT, get_bank_modal_selection_text());
    }

    @StepGroup
    public void verify_bank_step_select_bank_and_click_on_next_button() {
        verify_bank_selection_page_is_loaded_and_headline_is_present();
        select_bank_name_by_text(BANK_NAME);
        click_bank_selection_next_button();
        verify_bank_modal_finApi_popUp_is_present();
        click_bank_modal_ok_button();
    }
}
