package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbAddContractPage.ADD_CONTRACT_PAGE_URL;

@At("#HOST" + ADD_CONTRACT_PAGE_URL)
@DefaultUrl(ADD_CONTRACT_PAGE_URL)
public class FsbAddContractPage extends AbstractPageObject {

    final static String ADD_CONTRACT_PAGE_URL = "/addcontract/add-order/";

    @FindBy(id = "addorder-addinsurance__headline_text")
    private WebElementFacade addContractPageHeadLine;

    @FindBy(id = "select-category")
    private WebElementFacade inputInsuranceCategory;

    @FindBy(id = "select-company")
    private WebElementFacade inputInsuranceCompany;

    @FindBy(id = "addcontract-addinsurancecontract__input-policy")
    private WebElementFacade policyNumberInput;

    @FindBy(id = "addcontract-addinsurancecontract__input-price")
    private WebElementFacade premiumAmountInput;

    @FindBy(id = "addcontract-addinsurancecontract__select")
    private WebElementFacade inputPaymentInterval;

    @FindBy(id = "addcontract-addinsurancecontract__next")
    private WebElementFacade addContractNextButton;

    @FindBy(id = "addorder-addinsurance-backnav_link")
    private WebElementFacade backNavigationLink;

    public String getAddContractPageHeadline() {
        return addContractPageHeadLine.getText();
    }

    public void selectInsuranceCategoryByText(String insuranceCategory) {
//        inputInsuranceCategory.waitUntilPresent();
//        scrollToElement(inputInsuranceCategory);
        inputInsuranceCategory.sendKeys(insuranceCategory);
        inputInsuranceCategory.sendKeys(Keys.RETURN);
    }

    public void selectInsuranceCompanyByText(String insuranceCompany) {
        inputInsuranceCompany.waitUntilPresent();
//        scrollToElement(inputInsuranceCompany);
        inputInsuranceCompany.sendKeys(insuranceCompany);
        inputInsuranceCompany.sendKeys(Keys.RETURN);
    }

    public void enterInsurancePolicyNumber(String policyNumber) {
        policyNumberInput.clear();
        policyNumberInput.sendKeys(policyNumber);
    }

    public void enterPremiumAmount(String premiumAmount) {
        premiumAmountInput.clear();
        premiumAmountInput.sendKeys(premiumAmount);
    }

    public void selectPaymentIntervalByText(String paymentInterval) {
//        inputPaymentInterval.waitUntilPresent();
//        scrollToElement(inputPaymentInterval);
        inputPaymentInterval.sendKeys(paymentInterval);
        inputPaymentInterval.sendKeys(Keys.RETURN);
    }

    public void clickAddContractGoNextButton() {
//        scrollToElement(addContractNextButton);
//        addContractNextButton.waitUntilClickable();
        addContractNextButton.click();
    }

    public void clickBackNavigationClick() {
        backNavigationLink.click();
    }
}
