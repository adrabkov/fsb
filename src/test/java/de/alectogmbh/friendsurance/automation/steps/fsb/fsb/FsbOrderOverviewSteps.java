package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbOrderOverviewPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class FsbOrderOverviewSteps extends AbstractScenarioSteps<FsbOrderOverviewPage> {

//    private static final String EXPECTED_ORDER_OVERVIEW_HEADLINE = "Verträge überprüfen und hinzufügen";
    private static final int NUMBER_OF_EXTRACTED_ORDER_ITEMS = 6;
    private static final int NUMBER_OF_ORDER_ITEMS_AFTER_DELETING_INCOMPLETE_ORDER_ITEMS = 4;
    private static final int NUMBER_OF_ORDER_ITEMS_AFTER_ADDING_MANUALLY = 5;

    private FsbOrderOverviewPage fsbOrderOverviewPage;

    public FsbOrderOverviewPage getPageObject() {
        return fsbOrderOverviewPage;
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
    public void click_on_missing_order_info_item_one() {
        getPageObject().clickOnMissingInfoOrderItemFirstLink();
    }

    @Step
    public void click_on_missing_order_info_item_two() {
        getPageObject().clickOnMissingInfoOrderItemSecondLink();
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
    public void verify_order_overview_page_is_loaded_and_headline_is_present(String EXPECTED_ORDER_OVERVIEW_HEADLINE) {
        assertEquals(EXPECTED_ORDER_OVERVIEW_HEADLINE, get_order_overview_headline_text());
    }

    @Step
    public void verify_order_overview_page_is_loaded_after_user_actions(String EXPECTED_ORDER_OVERVIEW_HEADLINE) {
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

    @StepGroup
    public void verify_order_overview_page_is_loaded_and_click_on_logout_link(String EXPECTED_ORDER_OVERVIEW_HEADLINE) {
        verify_order_overview_page_is_loaded_and_headline_is_present(EXPECTED_ORDER_OVERVIEW_HEADLINE);
        click_on_header_logout_link();
    }

    @StepGroup
    public void verify_order_overview_page_is_loaded_and_click_on_profil_link(String EXPECTED_ORDER_OVERVIEW_HEADLINE) {
        verify_order_overview_page_is_loaded_and_headline_is_present(EXPECTED_ORDER_OVERVIEW_HEADLINE);
        click_on_header_profile_link();
    }

    @StepGroup
    public void verify_order_overview_page_and_click_on_missing_info_order_item_one(String EXPECTED_ORDER_OVERVIEW_HEADLINE) {
        verify_order_overview_page_is_loaded_and_headline_is_present(EXPECTED_ORDER_OVERVIEW_HEADLINE);
//        verify_extracted_order_items_from_finlytics();
        click_on_missing_order_info_item_one();
    }

    @StepGroup
    public void verify_order_items_after_deleting_one_item_and_click_on_error_order_two(String EXPECTED_ORDER_OVERVIEW_HEADLINE) {
        verify_order_overview_page_is_loaded_after_user_actions(EXPECTED_ORDER_OVERVIEW_HEADLINE);
        click_on_missing_order_info_item_two();
    }

    @StepGroup
    public void verify_order_items_after_deleting_error_items_and_click_on_add_contract_button(String EXPECTED_ORDER_OVERVIEW_HEADLINE) {
        verify_order_overview_page_is_loaded_after_user_actions(EXPECTED_ORDER_OVERVIEW_HEADLINE);
        verify_order_items_after_deleting_error_items();
        click_on_add_contract_button();
    }

    @StepGroup
    public void verify_order_items_after_adding_contract_and_click_on_overview_page_submit_button(String EXPECTED_ORDER_OVERVIEW_HEADLINE) {
        verify_order_overview_page_is_loaded_after_user_actions(EXPECTED_ORDER_OVERVIEW_HEADLINE);
        verify_order_items_after_adding_contract_manually();
        click_overview_page_submit_button();
    }

    @StepGroup
    public void verify_extracted_data_and_click_on_missing_info_order_item_one(String EXPECTED_ORDER_OVERVIEW_HEADLINE) {
        verify_order_overview_page_is_loaded_after_user_actions(EXPECTED_ORDER_OVERVIEW_HEADLINE);
        verify_extracted_order_items_from_finlytics();
        click_on_missing_order_info_item_one();
    }

    @StepGroup
    public void verify_order_overview_page_and_click_on_contracts_submit_button(String EXPECTED_ORDER_OVERVIEW_HEADLINE) {
        verify_order_overview_page_is_loaded_after_user_actions(EXPECTED_ORDER_OVERVIEW_HEADLINE);
        verify_order_items_after_deleting_error_items();
        click_overview_page_submit_button();
    }
}
