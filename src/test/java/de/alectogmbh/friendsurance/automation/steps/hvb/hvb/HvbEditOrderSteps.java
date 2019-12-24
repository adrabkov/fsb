package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbEditOrderPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.junit.Assert.assertEquals;

public class HvbEditOrderSteps extends AbstractScenarioSteps<HvbEditOrderPage> {

    private HvbEditOrderPage hvbOrderOverviewPage;

    public HvbEditOrderPage getPageObject() {
        return hvbOrderOverviewPage;
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
    public void select_insurance_category_by_text(String insuranceCategory) {
        getPageObject().selectInsuranceCategoryByText(insuranceCategory);
    }

    @Step
    public void select_insurance_company_by_text(String insuranceCompany) {
        getPageObject().selectInsuranceCompanyByText(insuranceCompany);
    }

    @Step
    public void select_insurance_new_company(String insuranceNewCompany) {
        getPageObject().selectInsuranceNewCompany(insuranceNewCompany);
    }

    @Step
    public void enter_insurance_policy_number(String insurancePolicyNumber) {
        getPageObject().enterInsurancePolicyNumber(insurancePolicyNumber);
    }

    @Step
    public void click_on_save_contract_details_button() {
        getPageObject().clickOnSaveContractDetailsButton();
    }

    @Step
    public void verify_edit_order_page_is_loaded_and_headline_is_present(String edit_order_page_headline) {
        assertEquals(edit_order_page_headline, get_edit_order_page_headline_text());
    }

    @StepGroup
    public void verify_edit_order_page_for_item_one_and_click_on_delete_order_item_link(String edit_order_page_headline) {
        verify_edit_order_page_is_loaded_and_headline_is_present(edit_order_page_headline);
        click_on_delete_order_item_link();
    }

    @StepGroup
    public void verify_order_page_and_edit_company_name(String edit_order_page_headline, String insuranceNewCompany) {
        verify_edit_order_page_is_loaded_and_headline_is_present(edit_order_page_headline);
        select_insurance_new_company(insuranceNewCompany);
        click_on_save_contract_details_button();
    }

    @StepGroup
    public void verify_edit_order_page_for_item_two_add_missing_data_and_click_on_save_button(String edit_order_page_headline, String insuranceCategory,
                                                                                              String insuranceCompany, String policyNumber) {
        verify_edit_order_page_is_loaded_and_headline_is_present(edit_order_page_headline);
        select_insurance_category_by_text(insuranceCategory);
        select_insurance_company_by_text(insuranceCompany);
        enter_insurance_policy_number(policyNumber);
        click_on_save_contract_details_button();
    }

}
