package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbOrderOverviewPage.ORDER_OVERVIEW_PAGE;

@At("#HOST" + ORDER_OVERVIEW_PAGE)
@DefaultUrl(ORDER_OVERVIEW_PAGE)
public class FsbOrderOverviewPage extends BaseForm {

    final static String ORDER_OVERVIEW_PAGE = "/addcontract/order-overview/";

    private static final int SPINNER_TIMEOUT = 90;

    @FindBy(className = "overview-insurance-order__headline_text")
    private WebElement orderOverviewHeadlineText;

    @FindBy(id = "overview-page__button-empty-data")
    private WebElement addContractButton;

    @FindBy(id = "overview-page-next-empty-data")
    private WebElement overviewPageSubmitButton;

    @FindBy(id = "header-profile-link")
    private WebElement headerProfileLink;

    @FindBy(id = "header__logout")
    private WebElement headerLogoutLink;

    @FindBy(id = "order-item-card-policynumber-error")
    private WebElement errorOrderItemOne;

    @FindBy(id = "order-item-card-policynumber-error")
    private WebElement errorOrderItemTwo;

    @FindBy(className = "order-item-card__container")
    private List<WebElement> orderItems;

    @FindBy(className = "order-item-card-policynumber-error")
    private List<WebElement>orderItemsWithError;


    public String getOrderOverviewHeadlineText() {
//        orderOverviewHeadlineText.waitUntilVisible();
        return orderOverviewHeadlineText.getText();
    }

    public void clickOnMissingInfoOrderItemFirstLink() {
        errorOrderItemOne.click();
    }

    public void clickOnMissingInfoOrderItemSecondLink() {
//        errorOrderItemTwo.waitUntilClickable();
        errorOrderItemTwo.click();
    }

    public void clickOnAddContractButton() {
//        scroll_element_into_view(addContractButton);
//        addContractButton.waitUntilClickable();
        addContractButton.click();
    }

    public int getNumberOfOrderItems() {
        return orderItems.size();
    }

    public int getNumberOfErrorOrderItemTwo(){
        return orderItemsWithError.size();
    }

    public void clickOverviewPageSubmitButton() {
//        scrollToElement(overviewPageSubmitButton);
//        overviewPageSubmitButton.waitUntilClickable();
        overviewPageSubmitButton.click();
    }

    public void clickOnHeaderProfileLink() {
//        headerProfileLink.waitUntilVisible();
//        scrollToElement(headerProfileLink);
//        headerProfileLink.waitUntilClickable();
        headerProfileLink.click();
    }

    public void clickOnHeaderLogoutLink() {
//        headerLogoutLink.waitUntilVisible();
//        headerLogoutLink.waitUntilClickable();
        headerLogoutLink.click();
    }

}
