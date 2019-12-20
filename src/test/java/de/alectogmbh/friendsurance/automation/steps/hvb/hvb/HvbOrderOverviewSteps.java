package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbEditOrderPage;
import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbOrderOverviewPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbOrderOverviewSteps extends AbstractScenarioSteps<HvbOrderOverviewPage> {

    private static final String EXPECTED_ORDER_OVERVIEW_HEADLINE = "Erkannte Verträge aus Ihrem Bankkonto";
    private static final String DEFAULT_NEW_COMPANY_NAME = "Bayerische Beamten Unfallversicherung";
    private static final String EXPECTED_NEW_COMPANY_NAME = "test";
    private static final int NUMBER_OF_EXTRACTED_ORDER_ITEMS = 4;
    private static final int NUMBER_OF_ORDER_ITEMS_AFTER_DELETING_INCOMPLETE_ORDER_ITEMS = 2;
    private static final int NUMBER_OF_ORDER_ITEMS_AFTER_ADDING_MANUALLY = 3;

    private HvbEditOrderPage hvbEditOrderPage = new HvbEditOrderPage();

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
    public void click_on_missing_order_info_item_one() {
        getPageObject().clickOnMissingInfoOrderItem();
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
    public void click_on_header_profile_link() {
        getPageObject().clickOnHeaderProfileLink();
    }

    @Step
    public void click_on_navigation_item_notifications_link() {
        getPageObject().clickOnNavigationItemNotificationsLink();
    }

    @Step
    public void click_on_header_logout_link() {
        getPageObject().clickOnHeaderLogoutLink();
    }

    @Step
    public void verify_order_overview_page_is_loaded_and_headline_is_present() {
        assertEquals(EXPECTED_ORDER_OVERVIEW_HEADLINE, get_order_overview_headline_text());
    }

    @Step
    public void verify_order_overview_page_is_loaded_after_user_actions() {
        assertEquals(EXPECTED_ORDER_OVERVIEW_HEADLINE, get_order_overview_headline());
    }

    @Step
    public void verify_extracted_order_items_from_finlytics() {
        assertEquals(NUMBER_OF_EXTRACTED_ORDER_ITEMS, getPageObject().getNumberOfOrderItems());
    }

    @Step
    public void verify_order_items_after_deleting_error_items() {
        assertEquals(NUMBER_OF_ORDER_ITEMS_AFTER_DELETING_INCOMPLETE_ORDER_ITEMS, getPageObject().getNumberOfOrderItems());
    }

    @Step
    public void verify_order_items_after_adding_contract_manually() {
        assertEquals(NUMBER_OF_ORDER_ITEMS_AFTER_ADDING_MANUALLY, getPageObject().getNumberOfOrderItems());
    }

    @Step
    public void check_and_delete_missing_orders_items() {
        for (int i = 0; i <= getPageObject().getNumberOfErrorItems() + 1; i++) {
            if (check_missing_order_items_is_displayed()) {
                getPageObject().clickOnMissingInfoOrderItem();
                hvbEditOrderPage.clickOnDeleteOrderItemLink();
            }
        }
//        click_overview_page_submit_button();
    }

    @Step
    public void click_order_item() {
        getPageObject().clickOnOrderItem();
    }

    @Step
    public String get_company_new_name() {
        return getPageObject().getCompanyNewName();
    }

    @Step
    public void check_company_name_item_before_edit_action() {
        assertEquals(DEFAULT_NEW_COMPANY_NAME, get_company_new_name());
    }

    @Step
    public void check_company_name_item_after_edit_action() {
        assertEquals(EXPECTED_NEW_COMPANY_NAME, get_company_new_name());
    }

    @StepGroup
    public void verify_order_overview_page_is_loaded_and_click_on_logout_link() {
        verify_order_overview_page_is_loaded_and_headline_is_present();
        click_on_header_logout_link();
    }

    @StepGroup
    public void verify_order_overview_page_and_perform_user_actions_and_click_add_button() {
        verify_order_overview_page_is_loaded_and_headline_is_present();
        check_company_name_item_after_edit_action();
        click_on_add_contract_button();
    }

    @StepGroup
    public void verify_order_items_after_adding_contract_and_click_on_overview_page_submit_button() {
        verify_order_overview_page_is_loaded_after_user_actions();
        verify_order_items_after_adding_contract_manually();
        click_overview_page_submit_button();
    }

    @StepGroup
    public void verify_company_name_before_editing_and_click_on_item() {
        check_company_name_item_before_edit_action();
        click_order_item();
    }
}
