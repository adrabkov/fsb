package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import java.util.List;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbOrderOverviewPage.ORDER_OVERVIEW_PAGE;
import static java.util.concurrent.TimeUnit.SECONDS;

@At("#HOST" + ORDER_OVERVIEW_PAGE)
@DefaultUrl(ORDER_OVERVIEW_PAGE)
public class FsbOrderOverviewPage extends AbstractPageObject {

    final static String ORDER_OVERVIEW_PAGE = "/addcontract/order-overview/";

    private static final int SPINNER_TIMEOUT = 90;

    @FindBy(id = "overview-page-spinner")
    private WebElementFacade loading;

    @FindBy(className = "overview-page__content")
    private WebElementFacade orderOverviewPageContent;

    @FindBy(className = "overview-insurance-order__headline_text")
    private WebElementFacade orderOverviewHeadlineText;

    @FindBy(id = "order-item-card-policynumber-error")
    private WebElementFacade errorOrderItemOne;

    @FindBy(id = "order-item-card-policynumber-error")
    private WebElementFacade errorOrderItemTwo;

    @FindBy(id = "overview-page__button-empty-data")
    private WebElementFacade addContractButton;

    @FindBy(className = "order-item-card__container")
    private List<WebElementFacade> orderItems;

    @FindBy(id = "order-item-card-policynumber-error")
    private List<WebElementFacade> errorOrderItems;

    @FindBy(id = "overview-page-next-empty-data")
    private WebElementFacade overviewPageSubmitButton;

    @FindBy(id = "header-profile-link")
    private WebElementFacade headerProfileLink;

    @FindBy(id = "header__logout")
    private WebElementFacade headerLogoutLink;

    @FindBy(id = "header-navigation__link-notifications")
    private WebElementFacade navigationItemNotificationsLink;

    public String getOrderOverviewHeadlineText() {
        return orderOverviewHeadlineText.getText();
    }

    public String getOrderOverviewHeadline() {
        return orderOverviewHeadlineText.getText();
    }

    public void clickOnMissingInfoOrderItemFirstLink() {
        errorOrderItemOne.click();
    }

    public void clickOnMissingInfoOrderItemSecondLink() {
        errorOrderItemTwo.click();
    }

    public void clickOnAddContractButton() {
        addContractButton.click();
    }

    public int getNumberOfOrderItems() {
        return orderItems.size();
    }

    public int getNumberOfErrorOrderItems(){
        return errorOrderItems.size();
    }

    public void clickOverviewPageSubmitButton() {
        overviewPageSubmitButton.waitUntilClickable();
        overviewPageSubmitButton.click();
    }

    public void clickOnHeaderProfileLink() {
        headerProfileLink.waitUntilVisible();
//        scrollToElement(headerProfileLink);
        headerProfileLink.waitUntilClickable();
        headerProfileLink.click();
    }

    public void clickOnNavigationItemNotificationsLink() {
        navigationItemNotificationsLink.waitUntilVisible();
//        scrollToElement(navigationItemNotificationsLink);
        navigationItemNotificationsLink.waitUntilClickable();
        navigationItemNotificationsLink.click();
    }

    public void clickOnHeaderLogoutLink() {
        headerLogoutLink.waitUntilVisible();
//        scrollToElement(headerLogoutLink);
        headerLogoutLink.waitUntilClickable();
        headerLogoutLink.click();
    }

}
