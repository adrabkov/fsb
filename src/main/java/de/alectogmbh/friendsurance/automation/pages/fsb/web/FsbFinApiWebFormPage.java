package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbFinApiWebFormPage.BANKING_PAGE_URL;
import static java.util.concurrent.TimeUnit.SECONDS;

@At("#HOST" + BANKING_PAGE_URL)
@DefaultUrl(BANKING_PAGE_URL)
public class FsbFinApiWebFormPage extends BaseForm {

    final static String BANKING_PAGE_URL = "/onboarding/accounts/";

    private static final int FIN_API_PAGE_DISAPPEAR = 10;

    @FindBy(id = "userId")
    private WebElement onlineBankingUserId;

    @FindBy(id = "pin")
    private WebElement onlineBankingPin;

    @FindBy(id = "storeSecrets")
    private WebElement savePinCheckbox;

    @FindBy(id = "btnSubmit")
    private WebElement bankDataRetrieveButton;

    @FindBy(xpath = "//*[@id='twoStepProcedureId']")
    private WebElement twoStepProcedureId;

    public void enterOnlineBankingInputUserId(String userId) {
        onlineBankingUserId.clear();
        onlineBankingUserId.sendKeys(userId);
    }

    public void enterOnlineBankingInputPin(String pin) {
        onlineBankingPin.clear();
        onlineBankingPin.sendKeys(pin);
    }

    public void checkSavePinCheckbox() {
        if (!savePinCheckbox.isSelected()) {
            savePinCheckbox.click();
        }
    }

    public void clickOnBankDataRetrieveButton() {
//        bankDataRetrieveButton.waitUntilClickable();
        bankDataRetrieveButton.click();
//        bankDataRetrieveButton.withTimeoutOf(FIN_API_PAGE_DISAPPEAR, SECONDS).waitUntilNotVisible();
    }

}


