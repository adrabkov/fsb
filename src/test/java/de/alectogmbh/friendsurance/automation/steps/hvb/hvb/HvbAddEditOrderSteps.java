package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbAddEditOrderPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HvbAddEditOrderSteps extends AbstractScenarioSteps<HvbAddEditOrderPage> {

    private HvbAddEditOrderPage hvbAddEditOrderPage;

    public HvbAddEditOrderPage getPageObject() {
        return hvbAddEditOrderPage;
    }

    @Step
    public String get_add_contract_page_headline() {
        return getPageObject().getAddContractPageHeadline();
    }

    @Step
    public void verify_add_contract_page_is_loaded_and_headline_is_present(String headline) {
        assertEquals(headline, get_add_contract_page_headline());
    }

    @Step
    public String get_edit_order_page_headline_text() {
        return getPageObject().getEditOrderPageHeadlineText();
    }

    @Step
    public void verify_edit_order_page_is_loaded_and_headline_is_present(String headline) {
        assertEquals(headline, get_edit_order_page_headline_text());
    }

    @Step
    public void select_insurance_category_by_text(String insuranceCategory) {
        getPageObject().selectInsuranceCategoryByText(insuranceCategory);
    }

    @Step
    public void is_select_insurance_company_component_is_disabled() {
        assertTrue("The Company name input field is disabled",
                getPageObject().isSelectInsuranceCompanyComponentDisabled());
    }

    @Step
    public void select_insurance_company_by_text(String insuranceCompany) {
        getPageObject().selectInsuranceCompanyByText(insuranceCompany);
    }

    @Step
    public void select_insurance_new_company_by_text(String editCompany){
        getPageObject().selectInsuranceNewCompany(editCompany);
    }

    @Step
    public void enter_insurance_policy_number(String insurancePolicyNumber) {
        getPageObject().enterInsurancePolicyNumber(insurancePolicyNumber);
    }

    @Step
    public void enter_price_amount(String priceAmount) {
        getPageObject().enterPriceAmount(priceAmount);
    }

    @Step
    public void select_payment_interval_by_text(String paymentInterval) {
        getPageObject().selectPaymentIntervalByText(paymentInterval);
    }

    @Step
    public void click_add_contract_go_next_button() {
        getPageObject().clickAddContractGoNextButton();
    }

    @StepGroup
    public void verify_add_contract_page_add_existing_contract_details_and_click_on_save(String headline, String insuranceCategory, String insuranceCompany,
                                                                                         String policyNumber, String priceAmount, String paymentInterval) {
        verify_add_contract_page_is_loaded_and_headline_is_present(headline);
        is_select_insurance_company_component_is_disabled();
        select_insurance_category_by_text(insuranceCategory);
        select_insurance_company_by_text(insuranceCompany);
        enter_insurance_policy_number(policyNumber);
        enter_price_amount(priceAmount);
        select_payment_interval_by_text(paymentInterval);
        click_add_contract_go_next_button();
    }

    @Step
    public void click_on_delete_order_item_link() {
        getPageObject().clickOnDeleteOrderItemLink();
    }

    @Step
    public String get_insurance_category_name() {
        return getPageObject().getInsuranceCategoryName();
    }

    @Step
    public String get_insurance_company_name() {
        return getPageObject().getInsuranceCompanyName();
    }

    @Step
    public String get_insurance_policy_number() {
        return getPageObject().getInsurancePolicyNumber();
    }

    @Step
    public String get_price_amount() {
        return getPageObject().getPriceAmount();
    }

    @Step
    public String get_payment_interval() {
        return getPageObject().getPaymentInterval();
    }

    @Step
    public void set_insurance_category_by_text(String insuranceCategory) {
        getPageObject().setInsuranceCategoryName(insuranceCategory);
    }

    @Step
    public void set_insurance_company_by_text(String insuranceCompany) {
        getPageObject().setInsuranceCompanyName(insuranceCompany);
    }

    @Step
    public void set_insurance_policy_number(String insurancePolicyNumber) {
        getPageObject().setInsurancePolicyNumber(insurancePolicyNumber);
    }

    @Step
    public void set_price_amount(String premiumAmount) {
        getPageObject().setPriceAmount(premiumAmount);
    }

    @Step
    public void set_payment_interval(String paymentInterval) {
        getPageObject().setPaymentInterval(paymentInterval);
    }

    @Step
    public void click_on_save_contract_details_button() {
        getPageObject().clickAddContractGoNextButton();
    }

    @StepGroup
    public void verify_edit_order_page_and_order_details(String headline, String insuranceCategory, String insuranceCompany,
                                                         String policyNumber, String price, String paymentInterval) {
        verify_edit_order_page_is_loaded_and_headline_is_present(headline);
        assertEquals(insuranceCategory, get_insurance_category_name());
        assertEquals(insuranceCompany, get_insurance_company_name());
        assertEquals(policyNumber, get_insurance_policy_number());
        assertEquals(price, get_price_amount());
        assertEquals(paymentInterval, get_payment_interval());
    }

    @StepGroup
    public void modify_policy_details_and_click_on_save(String insuranceCategory, String insuranceCompany,
                                                        String policyNumber, String price, String paymentInterval) {
        set_insurance_category_by_text(insuranceCategory);
        set_insurance_company_by_text(insuranceCompany);
        set_insurance_policy_number(policyNumber);
        set_price_amount(price);
        set_payment_interval(paymentInterval);
        click_on_save_contract_details_button();
    }

    @StepGroup
    public void verify_order_page_and_edit_company_name(String edit_order_page_headline, String editInsuranceNewCompany){
        verify_edit_order_page_is_loaded_and_headline_is_present(edit_order_page_headline);
        select_insurance_new_company_by_text(editInsuranceNewCompany);
        click_on_save_contract_details_button();
    }

    @StepGroup
    public void verify_edit_order_page_modify_policy_details_and_click_on_Save(String headline, String insuranceCategory, String insuranceCompany,
                                                                               String policyNumber, String price, String paymentInterval,
                                                                               String editedInsuranceCategory, String editedInsuranceCompany,
                                                                               String editedPolicyNumber, String editedPrice, String editedPaymentInterval) {
        verify_edit_order_page_and_order_details(headline, insuranceCategory, insuranceCompany, policyNumber, price, paymentInterval);
        modify_policy_details_and_click_on_save(editedInsuranceCategory, editedInsuranceCompany, editedPolicyNumber, editedPrice, editedPaymentInterval);
    }

}
