package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbDeleteAccountPage.DELETE_ACCOUNT_PAGE_URL;

@At("#HOST" + DELETE_ACCOUNT_PAGE_URL)
@DefaultUrl(DELETE_ACCOUNT_PAGE_URL)
public class HvbDeleteAccountPage extends AbstractPageObject {

    public static final String DELETE_ACCOUNT_PAGE_URL = "/home/profile/deleteaccount/";

    @FindBy(className = "profile-delete-account__headline_title")
    private WebElementFacade deleteAccountPageHeadline;

    @FindBy(className = "profile-delete-account__cta")
    private WebElementFacade deleteAccountRequestButton;

    @FindBy(id = "profile-delete-account-card")
    private WebElementFacade deleteAccountModalWindowPrompt;

    @FindBy(id = "profile-delete-account__ok-button")
    private WebElementFacade deleteAccountModalWindowConfirmButton;

    public String getDeleteAccountPageHeadline() {
        deleteAccountPageHeadline.waitUntilVisible();
        return deleteAccountPageHeadline.getText();
    }

    public void clickOnDeleteAccountRequestButton() {
        deleteAccountRequestButton.waitUntilClickable();
        deleteAccountRequestButton.click();
    }

    public void switchToDeleteAccountModalWindowPrompt() {
        deleteAccountModalWindowPrompt.waitUntilVisible();
        getDriver().switchTo().activeElement();
    }

    public void clickOnDeleteAccountModalWindowConfirmButton() {
        deleteAccountModalWindowConfirmButton.waitUntilClickable();
        deleteAccountModalWindowConfirmButton.click();
    }

}
