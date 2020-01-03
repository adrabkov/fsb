package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbNotificationPage.NOTIFICATION_PAGE_URL;

@At("#HOST" + NOTIFICATION_PAGE_URL)
@DefaultUrl(NOTIFICATION_PAGE_URL)
public class HvbNotificationPage extends AbstractPageObject {

    final static String NOTIFICATION_PAGE_URL = "/notifications/";

    private static final By BY_NOTIFICATION_ITEM_BUTTON = By.className("notification-item__button-container");

    private static final By BY_NOTIFICATION_ITEM_TEXT = By.className("notification-item-row");

    private static final By BY_NOTIFICATION_ITEM_TITLE = By.className("notification-item-title");

    @FindBy(id = "undefined_headline")
    private WebElementFacade notificationsPageHeadline;

    @FindBy(id = "ONA_DEPENDENT_CHILDREN")
    private WebElementFacade numberOfChildrenDropdown;

    @FindBy(className = "notification-item")
    private List<WebElementFacade> notificationItems;

    @FindBy(className = "notification-item__button-container")
    private WebElementFacade notificationItemsButton;

    @FindBy(id = "notification-item__button-confirmed_move-undefined-buttonOk")
    private WebElementFacade confirmedMoveMessengerButton;

    @FindBy(id = "notification-item__button-confirmed_birth-undefined-buttonOk")
    private WebElementFacade confirmedBirthMessengerButton;

    public String getNotificationsPageHeadline() {
        notificationsPageHeadline.waitUntilVisible();
        return notificationsPageHeadline.getText();
    }

    public void selectNumberOfChildrenByText(String selectNumberOfChildren) {
        numberOfChildrenDropdown.waitUntilPresent();
        numberOfChildrenDropdown.waitUntilClickable();
        numberOfChildrenDropdown.selectByVisibleText(selectNumberOfChildren);
    }

    public void clickOnNotificationWithTitle(String title) {
        WebElementFacade notification = getNotificationWithTitle(title);
        notification.find(BY_NOTIFICATION_ITEM_BUTTON).click();
    }

    public void waitForMoveMessengerButtonToAppear() {
        confirmedMoveMessengerButton.waitUntilVisible();
    }

    public void waitForBirthMessengerButtonToAppear() {
        confirmedBirthMessengerButton.waitUntilVisible();
    }

    public List<String> getTextsInNotificationWithTitle(String title) {
        List<String> texts = new ArrayList<>();
        for (WebElementFacade textElement : getTextElementsInNotificationWithTitle(title)) {
            texts.add(textElement.getAttribute("innerText").trim());
        }
        return texts;
    }

    public void clickOnLinkWithTextInNotificationWithTitle(String textLink, String title) {
        for (WebElementFacade textElement : getTextElementsInNotificationWithTitle(title)) {
            if (textElement.containsElements(By.linkText(textLink))) {
                textElement.find(By.linkText(textLink)).click();
            }
        }
    }

    private WebElementFacade getNotificationWithTitle(String title) {
        for (WebElementFacade element : notificationItems) {
            if (element.find(BY_NOTIFICATION_ITEM_TITLE).getText().equals(title)) {
                return element;
            }
        }
        throw new NoSuchElementException(String.format("Notification with title '%s' not found.", title));
    }

    private List<WebElementFacade> getTextElementsInNotificationWithTitle(String title) {
        return getNotificationWithTitle(title).thenFindAll(BY_NOTIFICATION_ITEM_TEXT);
    }

}