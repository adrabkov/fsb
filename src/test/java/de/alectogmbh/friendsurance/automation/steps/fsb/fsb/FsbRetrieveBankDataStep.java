package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbRetrieveBankDataPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class FsbRetrieveBankDataStep{


    private static final String EXPECTED_RETRIEVE_BANK_DATA = "TAN medium";

    private FsbRetrieveBankDataPage fsbRetrieveBankDataPage = new FsbRetrieveBankDataPage();

    private FsbRetrieveBankDataPage getPageObject() {
        return fsbRetrieveBankDataPage;
    }

    @Step
    public String get_retrieve_bank_page_text(){
        return getPageObject().getRetrieveBankDataText();
    }

    @Step
    public void click_on_retrieve_bank_page_submit_button(){
        getPageObject().click_submit_button_on_Retrieve_Bank_Page();
    }

    @Step
    public void verify_retrieve_bank_page_text(){

    }

    @StepGroup
    public void verify_retrieve_bank_page_text_and_click_submit_button(){
        verify_retrieve_bank_page_text();
        click_on_retrieve_bank_page_submit_button();
    }
}
