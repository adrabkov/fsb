package de.alectogmbh.friendsurance.automation.pages.client;


import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import form.BaseForm;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static de.alectogmbh.friendsurance.automation.pages.client.FsbBankSelectionPage.BANK_SELECTION_PAGE_URL;

@At("#HOST" + BANK_SELECTION_PAGE_URL)
@DefaultUrl(BANK_SELECTION_PAGE_URL)
public class FsbBankSelectionPage extends AbstractPageObject {

    final static String BANK_SELECTION_PAGE_URL = "/onboarding/bank-selection/";

    @FindBy(xpath = "//div[@role='combobox']")
    private WebElementFacade banksList;

    @FindBy(className = "onboarding-headline__headline")
    private WebElementFacade bankSelectionHeadlineText;

    @FindBy(id = "select-bank")
    private WebElementFacade bankNameSelector;

    @FindBy(id = "bank-selection-gonext__button")
    private WebElementFacade nextButton;

    @FindBy(id = "bank-selection-error__text")
    private WebElementFacade validationMessageForBankList;

//    public String getBankSelectionHeadlineText() {
////        bankSelectionHeadlineText.waitUntilVisible();
//        return bankSelectionHeadlineText.getText();
//    }

    public void waitUntilBankNameSelectorIsPresent() {
        bankNameSelector.waitUntilPresent();
    }

    public void selectBankNameByText(String bankName){
        scrollToElement(bankNameSelector);
        bankNameSelector.click();
        bankNameSelector.type(bankName);
        bankNameSelector.sendKeys(Keys.RETURN);
    }

    public void clickBankSelectionNextButton(){
        nextButton.waitUntilClickable();
        nextButton.click();
    }

    public String getValidationMessageForBankList() {
        return validationMessageForBankList.getText();
    }

    public WebElement getBanksList() {
        return banksList;
    }

}
