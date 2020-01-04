package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbBankSelectionPage.BANK_SELECTION_PAGE_URL;
import static java.util.concurrent.TimeUnit.SECONDS;

@At("#HOST" + BANK_SELECTION_PAGE_URL)
@DefaultUrl(BANK_SELECTION_PAGE_URL)
public class FsbBankSelectionPage extends AbstractPageObject {

    final static String BANK_SELECTION_PAGE_URL = "/onboarding/banks/";

    private static final int MODAL_POPUP_DISAPPEAR = 10;

    @FindBy(className = "bank-selection__headline_text")
    private WebElementFacade bankSelectionHeadlineText;

    @FindBy(xpath = "//div[@class='onboarding-modal-content']/h2")
    private WebElementFacade bankModalSelectionText;

    @FindBy(id = "select-bank")
    private WebElementFacade bankNameSelector;

    @FindBy(id = "bank-selection-gonext__button")
    private WebElementFacade bankSelectionNextButton;

    @FindBy(id = "onboarding-modal-ok__button")
    private WebElementFacade bankModalOkButton;

    public String getBankSelectionHeadlineText() {
        return bankSelectionHeadlineText.getText();
    }

    public String getBankModalSelectionText() {
        return bankModalSelectionText.getText();
    }

    public void selectBankNameByText(String bankName) {
        withTimeoutOf(15, TimeUnit.SECONDS).waitFor(bankNameSelector);
        scrollToElement(bankNameSelector);
        bankNameSelector.click();
        bankNameSelector.type(bankName);
        bankNameSelector.sendKeys(Keys.RETURN);
    }

    public void clickBankSelectionNextButton() {
        bankSelectionNextButton.click();
    }

    public void clickBankModalOkButton() {
        bankModalOkButton.click();
        bankModalOkButton.withTimeoutOf(MODAL_POPUP_DISAPPEAR, SECONDS).waitUntilNotVisible();
    }
}
