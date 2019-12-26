package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbBankSelectionPage.BANK_SELECTION_PAGE_URL;

@At("#HOST" + BANK_SELECTION_PAGE_URL)
@DefaultUrl(BANK_SELECTION_PAGE_URL)
public class HvbBankSelectionPage extends AbstractPageObject {

    final static String BANK_SELECTION_PAGE_URL = "/onboarding/bank-selection/";

    @FindBy(className = "onboarding-headline__headline")
    private WebElementFacade bankSelectionHeadlineText;

    @FindBy(id = "select-bank")
    private WebElementFacade bankNameSelector;

    @FindBy(id = "bank-selection-gonext__button")
    private WebElementFacade bankSelectionNextButton;

    public String getBankSelectionHeadlineText() {
        bankSelectionHeadlineText.waitUntilVisible();
        return bankSelectionHeadlineText.getText();
    }

    public void waitUntilBankNameSelectorIsPresent() {
        bankNameSelector.waitUntilPresent();
    }

    public void selectBankNameByText(String bankName) {
        scrollToElement(bankNameSelector);
        bankNameSelector.click();
        bankNameSelector.type(bankName);
        bankNameSelector.sendKeys(Keys.RETURN);
    }

    public void clickBankSelectionNextButton() {
        bankSelectionNextButton.waitUntilClickable();
        bankSelectionNextButton.click();
    }

}
