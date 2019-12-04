package steps.client.onboarding;

import org.openqa.selenium.support.ui.Select;
import pages.onboarding.BanksPage;

public class BankStep {

    public void searchingBank(String text) {
        BanksPage banksPage = new BanksPage();
        banksPage.clickBanksList();
        banksPage.fillBankField(text);
        Select select = new Select(banksPage.getBanksList());
        select.selectByIndex(0);
        banksPage.clickNextButton();
    }
}
