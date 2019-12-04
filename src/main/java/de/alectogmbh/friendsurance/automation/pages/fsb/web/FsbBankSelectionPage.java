package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FsbBankSelectionPage extends BaseForm {

    @FindBy(xpath = "//div[@role='combobox']")
    private WebElement banksList;

    @FindBy(xpath = "select-bank")
    private WebElement bankNameField;

    @FindBy(id = "bank-selection-gonext__button")
    private WebElement nextButton;

    @FindBy(id = "bank-selection-error__text")
    private WebElement validationMessageForBankList;

//    public void clickBanksList() {
//        banksList.click();
//    }
//
//    public void clickNextButton(){
//        nextButton.click();
//    }
//
//    public void fillBankField(String text){
//        bankNameField.sendKeys(text);
//    }
//
//    public String getValidationMessageForBankList() {
//        return validationMessageForBankList.getText();
//    }
//
//    public WebElementFacade getBanksList() {
//        return banksList;
//    }
}
