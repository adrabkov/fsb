package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbOverallNeedAnalysisIntroPage.ONA_INTRO_PAGE_URL;

@At("#HOST" + ONA_INTRO_PAGE_URL)
@DefaultUrl(ONA_INTRO_PAGE_URL)
public class FsbOverallNeedAnalysisIntroPage extends BaseForm {

    final static String ONA_INTRO_PAGE_URL = "overallneedanalysis/intro";

    @FindBy(xpath = "//h1[@id='undefined_headline']/span")
    private WebElement onaIntroHeadlineText;

    @FindBy(id = "overallneedanalysis-intro__gonext-button")
    private WebElement onaIntroPageButton;

    @FindBy(id = "overallneedanalysis-intro-link")
    private WebElement rememberLaterButton;

    public String getOnaIntroPageHeadlineText() {
        return onaIntroHeadlineText.getText();
    }

    public void clickOnaGoNextButton() {
//        onaIntroHeadlineText.waitUntilVisible();
        onaIntroPageButton.click();
    }

    public void clickRememberLaterButton(){
//        scroll_element_into_view(onaIntroPageButton);
//        onaIntroPageButton.waitUntilClickable();
        rememberLaterButton.click();
    }




}
