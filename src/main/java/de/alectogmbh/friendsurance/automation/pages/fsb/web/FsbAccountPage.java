package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;


import java.util.concurrent.TimeUnit;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbAccountPage.ONBOARDING_ACCOUNT_PAGE_URL;

@At("#HOST" + ONBOARDING_ACCOUNT_PAGE_URL)
@DefaultUrl(ONBOARDING_ACCOUNT_PAGE_URL)
public class FsbAccountPage extends AbstractPageObject {

    final static String ONBOARDING_ACCOUNT_PAGE_URL = "/onboarding/accounts/";

    @FindBy(id = "bank-accounts-submit__button")
    private WebElementFacade bankAccountNextButton;

    @FindBy(id = "$-acceptPhoneNumber-checkbox__span")
    private WebElementFacade acceptPhoneNumberCheckbox;

    public void clickBankAccountNextButton() {
        bankAccountNextButton.click();
    }

    public void choosePhoneNumberCheckbox() {
        acceptPhoneNumberCheckbox.click();
    }
}
