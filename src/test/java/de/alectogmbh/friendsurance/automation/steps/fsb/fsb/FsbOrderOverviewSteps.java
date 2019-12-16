package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbEditOrderPage;
import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbOrderOverviewPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class FsbOrderOverviewSteps {

    private static final String EXPECTED_ORDER_OVERVIEW_HEADLINE = "Verträge überprüfen und hinzufügen";

    private FsbOrderOverviewPage fsbOrderOverviewPage = new FsbOrderOverviewPage();

    public FsbOrderOverviewPage getPageObject() {
        return fsbOrderOverviewPage;
    }

    @Step
    public String get_order_overview_headline_text() {
        return getPageObject().getOrderOverviewHeadlineText();
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
    public void click_on_header_logout_link() {
        getPageObject().clickOnHeaderLogoutLink();
    }

    @Step
    public void verify_order_overview_page_is_loaded_and_headline_is_present() {
        assertEquals(EXPECTED_ORDER_OVERVIEW_HEADLINE, get_order_overview_headline_text());
    }

    @Step
    public void verify_order_items_after_deleting_error_items() {
        assertEquals(expected_count_orders_after_deleting_missing_orders(), getPageObject().getNumberOfOrderItems());
    }

    @StepGroup
    public void verify_order_overview_page_is_loaded_and_click_on_logout_link() {
        verify_order_overview_page_is_loaded_and_headline_is_present();
        click_on_header_logout_link();
    }

    @StepGroup
    public void verify_order_overview_page_is_loaded_and_click_on_profil_link() {
        verify_order_overview_page_is_loaded_and_headline_is_present();
        click_on_header_profile_link();
    }

    @StepGroup
    public void verify_order_overview_page_and_click_on_contracts_submit_button() {
        verify_order_overview_page_is_loaded_and_headline_is_present();
        click_overview_page_submit_button();
    }

    @StepGroup
    public void verify_order_overview_page_and_click_on_missing_info_order_item_one() {
        verify_order_overview_page_is_loaded_and_headline_is_present();
        click_on_missing_order_info_item_one();
    }

    @StepGroup
    public void verify_order_items_after_deleting_one_item_and_click_on_error_order_two() {
        click_on_missing_order_info_item_two();
    }

    @StepGroup
    public void verify_order_items_after_adding_contract_and_click_on_overview_page_submit_button() {
        verify_order_items_after_deleting_error_items();
        click_overview_page_submit_button();
    }

    private int expected_count_orders_after_deleting_missing_orders() {
        return getPageObject().getNumberOfOrderItems() - getPageObject().getNumberOfErrorOrderItemTwo();
    }


}
