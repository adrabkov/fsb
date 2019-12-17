package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbRetrieveBankDataPage.BANKING_PAGE_URL;

@At("#HOST" + BANKING_PAGE_URL)
@DefaultUrl(BANKING_PAGE_URL)
public class FsbRetrieveBankDataPage extends AbstractPageObject {

    final static String BANKING_PAGE_URL = "/onboarding/banks/";

    @FindBy(xpath = "//*[@id='twoStepProcedureIdBlock']/label")
    private WebElement retrieveBankDataText;

    @FindBy(id = "btnSubmit")
    private WebElement btnSubmitOnRetrieveBankDataPage;

    public String getRetrieveBankDataText(){
        return retrieveBankDataText.getText();
    }

    public void click_submit_button_on_Retrieve_Bank_Page() {
        btnSubmitOnRetrieveBankDataPage.click();
    }
}
