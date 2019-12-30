package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbOverallNeedAnalysisIntroPage.ONA_INTRO_PAGE_URL;

@At("#HOST" + ONA_INTRO_PAGE_URL)
@DefaultUrl(ONA_INTRO_PAGE_URL)
public class HvbOverallNeedAnalysisIntroPage extends AbstractPageObject {

    final static String ONA_INTRO_PAGE_URL = "/home/profile/overallneedanalysis/intro/";

    @FindBy(className = "onboarding-headline__headline")
    private WebElementFacade onaIntroHeadlineText;

    @FindBy(id = "overallneedanalysis-gonext__button")
    private WebElementFacade onaIntroPageButton;

    @FindBy(id = "overallneedanalysis-link")
    private WebElementFacade rememberLaterButton;

    public String getOnaIntroPageHeadlineText() {
        onaIntroHeadlineText.waitUntilVisible();
        return onaIntroHeadlineText.getText();
    }

    public void clickOnaGoNextButton() {
        scroll_element_into_view(onaIntroPageButton);
        onaIntroPageButton.waitUntilClickable();
        onaIntroPageButton.click();
    }

    public void clickOnaSkippButton() {
        scroll_element_into_view(rememberLaterButton);
        rememberLaterButton.waitUntilClickable();
        rememberLaterButton.click();
    }

}