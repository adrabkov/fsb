package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbSignUpPage.SIGN_UP_PAGE_URL;

@At("#HOST" + SIGN_UP_PAGE_URL)
@DefaultUrl(SIGN_UP_PAGE_URL)
public class HvbSignUpPage extends AbstractPageObject {

    public final static String SIGN_UP_PAGE_URL = "/onboarding/personal-details/signup/";

    @FindBy(className = "onboarding-headline__headline")
    private WebElementFacade signUpPageHeadlineText;

    @FindBy(id = "personal-details-email")
    private WebElementFacade userEmailInputField;

    @FindBy(id = "personal-details-password")
    private WebElementFacade userPasswordInputField;

    @FindBy(id = "personal-details-submit")
    private WebElementFacade signUpButton;

    @FindBy(className = "modal-notification-content__firsticon")
    private WebElementFacade infoModalFirstWindow;

    @FindBy(id = "overview_page-info-modal__button_one")
    private WebElementFacade infoModalFirstButton;

    @FindBy(className = "modal-notification-content__secondicon")
    private WebElementFacade infoModalSecondWindow;

    @FindBy(id = "overview_page-info-modal__button_two")
    private WebElementFacade infoModalSecondButton;

    public String getSignUpPageHeadlineText() {
        signUpPageHeadlineText.waitUntilVisible();
        return signUpPageHeadlineText.getText();
    }

    public void enterUserEmail(String email) {
        userEmailInputField.waitUntilVisible();
        userEmailInputField.clear();
        userEmailInputField.type(email);
    }

    public void enterUserPassword(String password) {
        userPasswordInputField.waitUntilVisible();
        userPasswordInputField.clear();
        userPasswordInputField.type(password);
    }

    public void clickOnSignUpButton() {
        signUpButton.waitUntilClickable();
        signUpButton.click();
    }

    public void clickExtractedDataInfoStepOneContinue() {
//        infoModalFirstWindow.waitUntilVisible();
        infoModalFirstButton.waitUntilPresent();
        infoModalFirstButton.waitUntilClickable();
        infoModalFirstButton.click();
    }

    public void clickExtractedDataInfoStepTwoContinue() {
        infoModalSecondButton.click();
    }

}
