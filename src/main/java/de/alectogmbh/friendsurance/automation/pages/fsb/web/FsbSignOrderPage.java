package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbSignOrderPage.SIGN_ORDER_PAGE_URL;
import static de.alectogmbh.friendsurance.automation.utils.InSignUtils.signWithDummySignature;
import static de.alectogmbh.friendsurance.automation.utils.SeleniumWaitUtils.waitUntilAutoScrollStops;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@At("#HOST" + SIGN_ORDER_PAGE_URL)
@DefaultUrl(SIGN_ORDER_PAGE_URL)
public class FsbSignOrderPage extends BaseForm {

    final static String SIGN_ORDER_PAGE_URL = "addcontract/sign-order/";

    private static final int ITERATION_COUNT = 5;
    private static final int SCROLL_WAIT_TIME_IN_SECONDS = 5;

    @FindBy(className = "addcontract-sign-order__headline")
    private WebElement signOrderPageHeadline;

    @FindBy(id = "signature")
    private WebElement signatureCanvas;

    @FindBy(id = "addcontract-sign-order-submit__button")
    private WebElement signOrderSubmitButton;

    public String getSignOrderPageHeadline() {
        return signOrderPageHeadline.getText();
    }

    public void sign() {
        waitUntilAutoScrollStops(getDriver(), SCROLL_WAIT_TIME_IN_SECONDS);
        signWithDummySignature(getDriver(), signatureCanvas, ITERATION_COUNT);
    }

    public void clickSignOrderSubmitButton() {
        signOrderSubmitButton.click();
    }

}
