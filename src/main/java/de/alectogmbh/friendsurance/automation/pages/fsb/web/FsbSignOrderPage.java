package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbSignOrderPage.SIGN_ORDER_PAGE_URL;
import static de.alectogmbh.friendsurance.automation.utils.InSignUtils.signWithDummySignature;
import static de.alectogmbh.friendsurance.automation.utils.SeleniumWaitUtils.waitUntilAutoScrollStops;

@At("#HOST" + SIGN_ORDER_PAGE_URL)
@DefaultUrl(SIGN_ORDER_PAGE_URL)
public class FsbSignOrderPage extends AbstractPageObject {

    final static String SIGN_ORDER_PAGE_URL = "addcontract/sign-order/";

    private static final int ITERATION_COUNT = 5;
    private static final int SCROLL_WAIT_TIME_IN_SECONDS = 5;

    @FindBy(className = "addcontract-sign-order__headline")
    private WebElementFacade signOrderPageHeadline;

    @FindBy(id = "signature")
    private WebElementFacade signatureCanvas;

    @FindBy(className = "loading")
    private WebElementFacade loading;

    @FindBy(id = "addcontract-sign-order-submit__button")
    private WebElementFacade signOrderSubmitButton;

    public String getSignOrderPageHeadline() {
        signOrderPageHeadline.waitUntilVisible();
        return signOrderPageHeadline.getText();
    }

    public void sign() {
        waitUntilAutoScrollStops(getDriver(), SCROLL_WAIT_TIME_IN_SECONDS);
        signatureCanvas.waitUntilPresent();
        loading.waitUntilNotVisible();
        scroll_element_into_view(signatureCanvas);
        signWithDummySignature(getDriver(), signatureCanvas, ITERATION_COUNT);
    }

    public void clickSignOrderSubmitButton() {
        signOrderSubmitButton.waitUntilClickable();
        signOrderSubmitButton.click();
    }

}
