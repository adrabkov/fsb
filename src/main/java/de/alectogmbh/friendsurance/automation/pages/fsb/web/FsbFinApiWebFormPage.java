package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbFinApiWebFormPage.BANKING_PAGE_URL;
import static java.util.concurrent.TimeUnit.SECONDS;

@At("#HOST" + BANKING_PAGE_URL)
@DefaultUrl(BANKING_PAGE_URL)
public class FsbFinApiWebFormPage extends AbstractPageObject {

    final static String BANKING_PAGE_URL = "/onboarding/accounts/";

    private static final int FIN_API_PAGE_DISAPPEAR = 10;

    @FindBy(id = "userId")
    private WebElementFacade onlineBankingUserId;

    @FindBy(id = "pin")
    private WebElementFacade onlineBankingPin;

    @FindBy(id = "storeSecrets")
    private WebElementFacade savePinCheckbox;

    @FindBy(id = "btnSubmit")
    private WebElementFacade bankDataRetrieveButton;

    @FindBy(xpath = "//*[@id='twoStepProcedureId']")
    private WebElementFacade twoStepProcedureId;

    public void enterOnlineBankingInputUserId(String userId) {
        onlineBankingUserId.sendKeys(userId);
    }

    public void enterOnlineBankingInputPin(String pin) {
        onlineBankingPin.sendKeys(pin);
    }

    public void checkSavePinCheckbox() {
        if (!savePinCheckbox.isSelected()) {
            savePinCheckbox.click();
        }
    }

    public void clickOnBankDataRetrieveButton() {
        bankDataRetrieveButton.waitUntilClickable();
        bankDataRetrieveButton.click();
        bankDataRetrieveButton.withTimeoutOf(FIN_API_PAGE_DISAPPEAR, SECONDS).waitUntilNotVisible();
    }

}


