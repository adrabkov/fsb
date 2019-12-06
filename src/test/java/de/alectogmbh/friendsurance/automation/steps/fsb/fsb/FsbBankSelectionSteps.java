package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbBankSelectionPage;
import static org.junit.Assert.assertEquals;

public class FsbBankSelectionSteps {

    private static final String EXPECTED_BANK_SELECTION_HEADLINE = "Bei welcher Bank sind Sie Kunde?";
    private static final String EXPECTED_BANK_MODAL_TEXT = "Ihr Konto schnell und sicher verbinden mit";
    private static final String BANK_NAME = "Leipziger Volksbank";
    private static final String EXPECTED_BANK_SELECTION_ERROR_TEXT = "Bitte wählen Sie eine Bank aus.";

    private FsbBankSelectionPage fsbBankSelectionPage = new FsbBankSelectionPage();

    private FsbBankSelectionPage getPageObject() {
        return fsbBankSelectionPage;
    }

    @Step
    public String get_bank_selection_headline_text() {
        return getPageObject().getBankSelectionHeadlineText();
    }

    @Step
    public String get_bank_modal_selection_text(){
        return getPageObject().getBankModalSelectionText();
    }

    @Step
    public String get_bank_selection_error(){
        return getPageObject().getBankSelectionErrorText();
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
    public void open_dashboard_from_bank_selection_page(){
        getPageObject().clickDashboardFromBankSelection();
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

    @StepGroup
    public void verify_error_text_for_bank_selection(){
        verify_bank_selection_page_is_loaded_and_headline_is_present();
        click_bank_selection_next_button();
        assertEquals(EXPECTED_BANK_SELECTION_ERROR_TEXT, get_bank_selection_error());
    }

    @StepGroup
    public void verify_ability_to_open_dashboard_from_Bank_selection(){
        verify_bank_selection_page_is_loaded_and_headline_is_present();
        open_dashboard_from_bank_selection_page();

    }
}
