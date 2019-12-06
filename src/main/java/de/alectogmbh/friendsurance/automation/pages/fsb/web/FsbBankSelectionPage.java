package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FsbBankSelectionPage extends BaseForm{

    @FindBy(className = "bank-selection__headline_text")
    private WebElement bankSelectionHeadlineText;

    @FindBy(id = "bank-selection-error__text")
    private WebElement bankSelectionErrorText;

    @FindBy(xpath = "//div[@class='onboarding-modal-content']/h2")
    private WebElement bankModalSelectionText;

    @FindBy(id = "select-bank")
    private WebElement bankNameSelector;

    @FindBy(id = "bank-selection-gonext__button")
    private WebElement bankSelectionNextButton;

    @FindBy(id = "onboarding-modal-ok__button")
    private WebElement bankModalOkButton;

    @FindBy(xpath = "//a[@href='/home']")
    private WebElement dashboardFromBankSelection;

    public String getBankSelectionHeadlineText() {
        return bankSelectionHeadlineText.getText();
    }

    public String getBankSelectionErrorText() {
        return bankSelectionErrorText.getText();
    }

    public String getBankModalSelectionText() {
        return bankModalSelectionText.getText();
    }

    public void selectBankNameByText(String bankName) {
        bankNameSelector.click();
        bankNameSelector.sendKeys(bankName);
        bankNameSelector.sendKeys(Keys.RETURN);
    }

    public void clickBankSelectionNextButton() {
        bankSelectionNextButton.click();
    }

    public void clickBankModalOkButton() {
        bankModalOkButton.click();
    }

    public void clickDashboardFromBankSelection() {
        dashboardFromBankSelection.click();
    }

}
