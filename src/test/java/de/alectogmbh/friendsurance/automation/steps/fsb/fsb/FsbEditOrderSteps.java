package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbEditOrderPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.junit.Assert.assertEquals;

public class FsbEditOrderSteps {

    private static final String EXPECTED_EDIT_ORDER_PAGE_HEADLINE = "Da müssen Sie noch einmal kurz ran";

    private FsbEditOrderPage fsbEditOrderPage = new FsbEditOrderPage();

    public FsbEditOrderPage getPageObject() {
        return fsbEditOrderPage;
    }

    @Step
    public String get_edit_order_page_headline_text() {
        return getPageObject().getEditOrderPageHeadlineText().replaceAll(LF, SPACE);
    }

    @Step
    public void click_on_delete_order_item_link() {
        getPageObject().clickOnDeleteOrderItemLink();
    }

    @Step
    public void click_on_save_contract_details_button() {
        getPageObject().clickOnSaveContractDetailsButton();
    }

    @Step
    public void verify_edit_order_page_is_loaded_and_headline_is_present() {
        assertEquals(EXPECTED_EDIT_ORDER_PAGE_HEADLINE, get_edit_order_page_headline_text());
    }

    @StepGroup
    public void verify_edit_order_page_for_item_one_and_click_on_delete_order_item_link() {
        verify_edit_order_page_is_loaded_and_headline_is_present();
        click_on_delete_order_item_link();
    }

    @StepGroup
    public void verify_edit_order_page_for_item_two_and_click_on_delete_order_item_link() {
        verify_edit_order_page_is_loaded_and_headline_is_present();
        click_on_delete_order_item_link();
    }






}
