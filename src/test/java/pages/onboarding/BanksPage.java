package pages.onboarding;

import form.BaseForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BanksPage extends BaseForm {

    @FindBy(xpath = "//div[@role='combobox']")
    private WebElement banksList;

    @FindBy(id = "bank-selection-gonext__button")
    private WebElement nextButton;

    public WebElement getBanksList() {
        return banksList;
    }
}
