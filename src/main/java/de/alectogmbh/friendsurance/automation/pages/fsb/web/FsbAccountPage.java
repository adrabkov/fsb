package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.support.FindBy;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbAccountPage.ONBOARDING_ACCOUNT_PAGE_URL;


@At("#HOST" + ONBOARDING_ACCOUNT_PAGE_URL)
@DefaultUrl(ONBOARDING_ACCOUNT_PAGE_URL)
public class FsbAccountPage extends BaseForm {

    final static String ONBOARDING_ACCOUNT_PAGE_URL = "/onboarding/accounts/";

    @FindBy(id = "bank-accounts-submit__button")
    private WebElementFacade bankAccountNextButton;

    @FindBy(id = "$-acceptPhoneNumber-checkbox__span")
    private WebElementFacade acceptPhoneNumberCheckbox;

    public void clickBankAccountNextButton(){
        bankAccountNextButton.click();
    }

    public void choosePhoneNumberCheckbox(){
        acceptPhoneNumberCheckbox.click();
    }
}
