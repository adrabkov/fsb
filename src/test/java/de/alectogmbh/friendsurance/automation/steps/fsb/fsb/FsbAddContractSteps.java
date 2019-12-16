package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbAddContractPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class FsbAddContractSteps extends AbstractScenarioSteps<FsbAddContractPage> {

    private static final String EXPECTED_ADD_CONTRACT_PAGE_HEADLINE = "Ein Stück mehr Sicherheit hinzufügen.";

    private static final String insuranceCategory = "Auslandsreisekrankenversicherung";
    private static final String insuranceCompany = "ADAC-Versicherung";
    private static final String policyNumber = "Pio/28776633/HD";
    private static final String premiumAmount = "21,50";
    private static final String paymentInterval = "Vierteljährlich";

    private FsbAddContractPage fsbAddContractPage = new FsbAddContractPage();

    public FsbAddContractPage getPageObject() {
        return fsbAddContractPage;
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
    public void verify_add_contract_page_is_loaded_and_headline_is_present() {
        assertEquals(EXPECTED_ADD_CONTRACT_PAGE_HEADLINE, get_add_contract_page_headline());
    }

    @StepGroup
    public void verify_add_contract_page_enter_policy_details_and_go_next() {
        verify_add_contract_page_is_loaded_and_headline_is_present();
        select_insurance_category_by_text(insuranceCategory);
        select_insurance_company_by_text(insuranceCompany);
        enter_insurance_policy_number(policyNumber);
        enter_premium_amount(premiumAmount);
        select_payment_interval_by_text(paymentInterval);
        click_add_contract_go_next_button();
    }

}
