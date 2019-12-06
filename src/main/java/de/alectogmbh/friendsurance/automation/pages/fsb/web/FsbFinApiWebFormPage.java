package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class FsbFinApiWebFormPage {

    @FindBy(id = "userId")
    private WebElementFacade onlineBankingUserId;

    @FindBy(id = "pin")
    private WebElementFacade onlineBankingPin;

    @FindBy(id = "storeSecrets")
    private WebElementFacade savePinCheckbox;

    @FindBy(id = "btnSubmit")
    private WebElementFacade bankDataRetrieveButton;

    public void enterOnlineBankingInputUserId(String userId) {
        onlineBankingUserId.waitUntilVisible();
        onlineBankingUserId.clear();
        onlineBankingUserId.sendKeys(userId);
    }

    public void enterOnlineBankingInputPin(String pin) {
        onlineBankingPin.waitUntilVisible();
        onlineBankingPin.clear();
        onlineBankingPin.sendKeys(pin);
    }

    public void checkSavePinCheckbox() {
        if (!savePinCheckbox.isSelected()) {
            savePinCheckbox.click();
        }
    }

    public void clickOnBankDataRetrieveButton() {
        bankDataRetrieveButton.click();
    }
}


