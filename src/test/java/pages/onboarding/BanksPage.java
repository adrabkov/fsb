package pages.onboarding;

import form.BaseForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BanksPage extends BaseForm {

    @FindBy(xpath = "//div[@role='combobox']")
    private WebElement banksList;

    @FindBy(xpath = "select-bank")
    private WebElement bankNameField;

    @FindBy(id = "bank-selection-gonext__button")
    private WebElement nextButton;

    @FindBy(id = "bank-selection-error__text")
    private WebElement validationMessageForBankList;

    public void clickBanksList() {
        banksList.click();
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public void fillBankField(String text){
        bankNameField.sendKeys(text);
    }

    public String getValidationMessageForBankList() {
        return validationMessageForBankList.getText();
    }

    public WebElement getBanksList() {
        return banksList;
    }
}
