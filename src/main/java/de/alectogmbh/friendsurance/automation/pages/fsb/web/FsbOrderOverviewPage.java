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
    private WebElement errorOrderItemCard;

    @FindBy(className = "order-item-card__container")
    private List<WebElement> orderItems;


    public String getOrderOverviewHeadlineText() {
        return orderOverviewHeadlineText.getText();
    }

    public void clickOnMissingInfoOrderItemFirstLink() {
        errorOrderItemCard.click();
    }

    public void clickOnAddContractButton() {
        addContractButton.click();
    }

    public int getNumberOfOrderItems() {
        return orderItems.size();
    }

    public void clickOverviewPageSubmitButton() {
        overviewPageSubmitButton.click();
    }

    public void clickOnHeaderProfileLink() {
        headerProfileLink.click();
    }

    public void clickOnHeaderLogoutLink() {
        headerLogoutLink.click();
    }

}
