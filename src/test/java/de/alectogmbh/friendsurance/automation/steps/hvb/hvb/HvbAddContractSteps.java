package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbAddContractPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbAddContractSteps extends AbstractScenarioSteps<HvbAddContractPage> {

    private HvbAddContractPage ruvAddContractPage;

    public HvbAddContractPage getPageObject() {
        return ruvAddContractPage;
    }

    @Step
    public String get_add_contract_page_headline() {
        return getPageObject().getAddContractPageHeadline();
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
    public void enter_insurance_policy_number(String insurancePolicyNumber) {
        getPageObject().enterInsurancePolicyNumber(insurancePolicyNumber);
    }

    @Step
    public void enter_premium_amount(String premiumAmount) {
        getPageObject().enterPremiumAmount(premiumAmount);
    }

    @Step
    public void select_payment_interval_by_text(String paymentInterval) {
        getPageObject().selectPaymentIntervalByText(paymentInterval);
    }

    @Step
    public void click_add_contract_go_next_button() {
        getPageObject().clickAddContractGoNextButton();
    }

    @Step
    public void verify_add_contract_page_is_loaded_and_headline_is_present(String add_contract_page_headline) {
        assertEquals(add_contract_page_headline, get_add_contract_page_headline());
    }

    @StepGroup
    public void verify_add_contract_page_enter_policy_details_and_go_next(String insuranceCategory, String insuranceCompany,
                                                                          String policyNumber, String premiumAmount, String paymentInterval, String add_contract_page_headline) {
        verify_add_contract_page_is_loaded_and_headline_is_present(add_contract_page_headline);
        select_insurance_category_by_text(insuranceCategory);
        select_insurance_company_by_text(insuranceCompany);
        enter_insurance_policy_number(policyNumber);
        enter_premium_amount(premiumAmount);
        select_payment_interval_by_text(paymentInterval);
        click_add_contract_go_next_button();
    }

}
