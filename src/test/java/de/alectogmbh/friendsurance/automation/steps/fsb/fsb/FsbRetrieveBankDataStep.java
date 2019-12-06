package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbRetrieveBankDataPage;
import net.thucydides.core.annotations.Step;

public class FsbRetrieveBankDataStep {

    private FsbRetrieveBankDataPage fsbRetrieveBankDataPage = new FsbRetrieveBankDataPage();

    private FsbRetrieveBankDataPage getPageObject() {
        return fsbRetrieveBankDataPage;
    }

    @Step
    public void click_on_retrieve_bank_page_submit_button(){
        getPageObject().click_submit_button_on_Retrieve_Bank_Page();
    }
}
