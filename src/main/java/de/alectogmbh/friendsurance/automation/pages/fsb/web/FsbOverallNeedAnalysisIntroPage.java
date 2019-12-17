package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbOverallNeedAnalysisIntroPage.ONA_INTRO_PAGE_URL;

@At("#HOST" + ONA_INTRO_PAGE_URL)
@DefaultUrl(ONA_INTRO_PAGE_URL)
public class FsbOverallNeedAnalysisIntroPage extends AbstractPageObject {

    final static String ONA_INTRO_PAGE_URL = "overallneedanalysis/intro";

    @FindBy(xpath = "//h1[@id='undefined_headline']/span")
    private WebElementFacade onaIntroHeadlineText;

    @FindBy(id = "overallneedanalysis-intro__gonext-button")
    private WebElementFacade onaIntroPageButton;

    public String getOnaIntroPageHeadlineText() {
        onaIntroHeadlineText.waitUntilVisible();
        return onaIntroHeadlineText.getText();
    }

    public void clickOnaGoNextButton() {
        onaIntroHeadlineText.waitUntilVisible();
        onaIntroPageButton.click();
    }
}
