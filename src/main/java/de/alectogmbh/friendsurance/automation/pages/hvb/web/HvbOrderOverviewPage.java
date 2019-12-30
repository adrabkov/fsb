package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbOrderOverviewPage.ORDER_OVERVIEW_PAGE;
import static java.util.concurrent.TimeUnit.SECONDS;

@At("#HOST" + ORDER_OVERVIEW_PAGE)
@DefaultUrl(ORDER_OVERVIEW_PAGE)
public class HvbOrderOverviewPage extends AbstractPageObject {

    public static final String ORDER_OVERVIEW_PAGE = "/addcontract/order-overview/";

    private static final int SPINNER_TIMEOUT = 90;

    @FindBy(id = "overview-page-spinner")
    private WebElementFacade loading;

    @FindBy(className = "overview-page-container")
    private WebElementFacade orderOverviewPageContent;

    @FindBy(id = "overview-page__headline-empty-data")
    private WebElementFacade orderOverviewHeadlineText;

    @FindBy(id = "order-item-policynumber-error")
    private WebElementFacade errorOrderItemOne;

    @FindBy(className = "overview-page__button")
    private WebElementFacade addContractButton;

    @FindBy(className = "order-item__container")
    private List<WebElementFacade> orderItemsList;

    @FindBy(id = "order-item-policynumber-error")
    private List<WebElementFacade> errorOrderItemsList;

    @FindBy(className = "order-item__headline")
    private WebElementFacade orderItem;

    @FindBy(id = "overview-page-next-empty-data")
    private WebElementFacade overviewPageSubmitButton;

    @FindBy(id = "header-profile-link")
    private WebElementFacade headerProfileLink;

    @FindBy(id = "header_logout")
    private WebElementFacade headerLogoutLink;

    @FindBy(id = "header_notifications_link")
    private WebElementFacade navigationItemNotificationsLink;

    public String getOrderOverviewHeadlineText() {
        loading.withTimeoutOf(SPINNER_TIMEOUT, SECONDS).waitUntilNotVisible();
        orderOverviewPageContent.waitUntilVisible();
        orderOverviewHeadlineText.waitUntilPresent();
        return orderOverviewHeadlineText.getText();
    }

    public String getOrderOverviewHeadline() {
        orderOverviewPageContent.waitUntilVisible();
        orderOverviewHeadlineText.waitUntilVisible();
        return orderOverviewHeadlineText.getText();
    }

    public Boolean checkErrorOrderIsDisplayed() {
//        errorOrderItemOne.withTimeoutOf(SPINNER_TIMEOUT, SECONDS).waitUntilVisible();
        errorOrderItemOne.waitUntilPresent();
        return errorOrderItemOne.isDisplayed();
    }

    public void clickOnMissingInfoOrderItem() {
        errorOrderItemOne.click();
    }

    public void clickOnOrderItem() {
        orderItem.click();
    }

    public void clickOnAddContractButton() {
        scroll_element_into_view(addContractButton);
        addContractButton.waitUntilClickable();
        addContractButton.click();
    }

    public int getNumberOfOrderItems() {
        return orderItemsList.size();
    }

    public int getNumberOfErrorItems() {
        return errorOrderItemsList.size();
    }

    public String getCompanyNewName() {
        return orderItem.getText();
    }

    public void clickOverviewPageSubmitButton() {
        overviewPageSubmitButton.waitUntilClickable();
        overviewPageSubmitButton.click();
    }

    public void clickOnHeaderProfileLink() {
        headerProfileLink.waitUntilVisible();
        scrollToElement(headerProfileLink);
        headerProfileLink.waitUntilClickable();
        headerProfileLink.click();
    }

    public void clickOnNavigationItemNotificationsLink() {
        navigationItemNotificationsLink.waitUntilVisible();
        scrollToElement(navigationItemNotificationsLink);
        navigationItemNotificationsLink.waitUntilClickable();
        navigationItemNotificationsLink.click();
    }

    public void clickOnHeaderLogoutLink() {
        headerLogoutLink.waitUntilVisible();
        scrollToElement(headerLogoutLink);
        headerLogoutLink.click();
    }

}
