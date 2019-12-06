package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FsbRetrieveBankDataPage {

    @FindBy(id = "btnSubmit")
    private WebElement btnSubmitOnRetrieveBankDataPage;

    public void click_submit_button_on_Retrieve_Bank_Page() {
        btnSubmitOnRetrieveBankDataPage.click();
    }
}
