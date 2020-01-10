package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbAddEditOrderPage;
import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbOrderOverviewPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbOrderOverviewSteps extends AbstractScenarioSteps<HvbOrderOverviewPage> {

    private HvbAddEditOrderPage hvbAddEditOrderPage;

    private HvbOrderOverviewPage hvbOrderOverviewPage;

    public HvbOrderOverviewPage getPageObject() {
        return hvbOrderOverviewPage;
    }

    @Step
    public String get_order_overview_headline_text() {
        return getPageObject().getOrderOverviewHeadlineText();
    }

    @Step
    public String get_order_overview_headline() {
        return getPageObject().getOrderOverviewHeadline();
    }

    @Step
    public Boolean check_missing_order_items_is_displayed() {
        return getPageObject().checkErrorOrderIsDisplayed();
    }

    @Step
    public void click_on_add_contract_button() {
        getPageObject().clickOnAddContractButton();
    }

    @Step
    public void click_overview_page_submit_button() {
        getPageObject().clickOverviewPageSubmitButton();
    }

    @Step
    public void click_on_header_logout_link() {
        getPageObject().clickOnHeaderLogoutLink();
    }

    @Step
    public void click_on_profile_link() {
        getPageObject().clickOnHeaderProfileLink();
    }

    @Step
    public void click_on_navigation_item_notifications_link() {
        getPageObject().clickOnNavigationItemNotificationsLink();
    }

    @Step
    public void verify_order_overview_page_is_loaded_and_headline_is_present(String order_overview_headline) {
        assertEquals(order_overview_headline, get_order_overview_headline_text());
    }

    @Step
    public void verify_order_overview_page_is_loaded_after_user_actions(String order_overview_headline) {
        assertEquals(order_overview_headline, get_order_overview_headline());
    }

    @Step
    public void delete_missing_orders_items() {
        for (int i = 0; i <= getPageObject().getNumberOfErrorItems() + 1; i++) {
            if (check_missing_order_items_is_displayed()) {
                getPageObject().clickOnMissingInfoOrderItem();
                hvbAddEditOrderPage.clickOnDeleteOrderItemLink();
            }
        }
    }

    @Step
    public void verify_order_items_after_deleting_error_items() {
        assertEquals(getPageObject().getNumberOfOrderItems() - getPageObject().getNumberOfErrorItems(), getPageObject().getNumberOfOrderItems());
    }

    @Step
    public void click_order_on_any_item() {
        getPageObject().clickOnOrderItem();
    }

    @Step
    public String get_company_new_name() {
        return getPageObject().getCompanyNewName();
    }

    @Step
    public void check_company_name_item_after_edit_action(String expected_new_company_name) {
        assertEquals(expected_new_company_name, get_company_new_name());
    }

    @StepGroup
    public void verify_order_overview_page_is_loaded_and_click_on_logout_link(String order_overview_headline) {
        verify_order_overview_page_is_loaded_and_headline_is_present(order_overview_headline);
        click_on_header_logout_link();
    }

    @StepGroup
    public void verify_order_overview_page_and_perform_user_actions_and_click_add_button(String order_overview_headline, String expected_new_company_name) {
        verify_order_overview_page_is_loaded_and_headline_is_present(order_overview_headline);
        check_company_name_item_after_edit_action(expected_new_company_name);
        click_on_add_contract_button();
    }

}
