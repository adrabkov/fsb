package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbAddEditOrderPage.ADD_ORDER_PAGE_URL;

@At("#HOST" + ADD_ORDER_PAGE_URL)
@DefaultUrl(ADD_ORDER_PAGE_URL)
public class HvbAddEditOrderPage extends AbstractPageObject {

    final static String ADD_ORDER_PAGE_URL = "/addcontract/add-order/";
    final static String EDIT_ORDER_PAGE_URL = "addcontract/edit-order/";

    @FindBy(id = "addcontract-addinsurancecontract-headline")
    private WebElementFacade addContractPageHeadline;

    @FindBy(id = "addcontract-addinsurancecontract-headline")
    private WebElementFacade editOrderPageHeadlineText;

    @FindBy(id = "add-order-category")
    private WebElementFacade inputInsuranceCategory;

    @FindBy(id = "add-order-company")
    private WebElementFacade inputInsuranceCompany;

    @FindBy(id = "addcontract-addinsurancecontract-newcompany__input")
    private WebElementFacade inputInsuranceNewCompany;

    @FindBy(id = "addcontract-addinsurancecontract__input-policy")
    private WebElementFacade policyNumberInput;

    @FindBy(id = "addcontract-addinsurancecontract__input-price")
    private WebElementFacade priceInput;

    @FindBy(id = "input-addcontract-addinsurancecontract__select")
    private WebElementFacade inputPaymentInterval;

    @FindBy(id = "add-order-save")
    private WebElementFacade addOrderSaveButton;

    @FindBy(id = "addcontract-addinsurancecontract-delete__link")
    private WebElementFacade deleteOrderItemLink;

    @FindBy(id = "close-category")
    private WebElementFacade closeCategoryDropDownIcon;

    public String getAddContractPageHeadline() {
        addContractPageHeadline.waitUntilVisible();
        return addContractPageHeadline.getText();
    }

    public void selectInsuranceCategoryByText(String insuranceCategory) {
        inputInsuranceCategory.waitUntilPresent();
        inputInsuranceCategory.isEnabled();
        scrollToElement(inputInsuranceCategory);
        inputInsuranceCategory.type(insuranceCategory);
        inputInsuranceCategory.sendKeys(Keys.RETURN);
    }

    public boolean isSelectInsuranceCompanyComponentDisabled() {
        inputInsuranceCompany.waitUntilPresent();
        return !inputInsuranceCompany.isEnabled();
    }

    public void selectInsuranceCompanyByText(String insuranceCompany) {
        inputInsuranceCompany.waitUntilPresent();
        scrollToElement(inputInsuranceCompany);
        inputInsuranceCompany.type(insuranceCompany);
        inputInsuranceCompany.sendKeys(Keys.RETURN);
    }

    public void enterInsurancePolicyNumber(String policyNumber) {
        policyNumberInput.clear();
        policyNumberInput.type(policyNumber);
    }

    public void enterPriceAmount(String price) {
        priceInput.clear();
        priceInput.type(price);
    }

    public void selectPaymentIntervalByText(String paymentInterval) {
        inputPaymentInterval.sendKeys(paymentInterval);
        inputPaymentInterval.sendKeys(Keys.RETURN);
    }

    public void clickAddContractGoNextButton() {
        scrollToElement(addOrderSaveButton);
        addOrderSaveButton.waitUntilClickable();
        addOrderSaveButton.click();
    }

    public String getEditOrderPageHeadlineText() {
        editOrderPageHeadlineText.waitUntilVisible();
        return editOrderPageHeadlineText.getText();
    }

    public void clickOnDeleteOrderItemLink() {
        deleteOrderItemLink.waitUntilVisible();
        scrollToElement(deleteOrderItemLink);
        deleteOrderItemLink.waitUntilClickable();
        deleteOrderItemLink.click();
    }

    public String getInsuranceCategoryName() {
        return inputInsuranceCategory.getAttribute("value");
    }

    public void setInsuranceCategoryName(String insuranceCategory) {
        inputInsuranceCategory.waitUntilVisible();
        closeCategoryDropDownIcon.click();
        inputInsuranceCategory.type(insuranceCategory);
        inputInsuranceCategory.sendKeys(Keys.RETURN);
    }

    public String getInsuranceCompanyName() {
        return inputInsuranceCompany.getAttribute("value");
    }

    public void setInsuranceCompanyName(String insuranceCompany) {
        inputInsuranceCompany.waitUntilVisible();
        inputInsuranceCompany.type(insuranceCompany);
        inputInsuranceCompany.sendKeys(Keys.RETURN);
    }

    public void selectInsuranceNewCompany(String insuranceNewCompany) {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(inputInsuranceNewCompany);
        scrollToElement(inputInsuranceNewCompany);
        inputInsuranceNewCompany.clear();
        inputInsuranceNewCompany.sendKeys(insuranceNewCompany);
        inputInsuranceNewCompany.sendKeys(Keys.RETURN);
    }

    public String getInsurancePolicyNumber() {
        return policyNumberInput.getAttribute("value");
    }

    public void setInsurancePolicyNumber(String policyNumber) {
        policyNumberInput.waitUntilVisible();
        policyNumberInput.clear();
        policyNumberInput.type(policyNumber);
    }

    public String getPriceAmount() {
        return priceInput.getAttribute("value");
    }

    public void setPriceAmount(String premiumAmount) {
        priceInput.waitUntilVisible();
        priceInput.click();
        priceInput.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
        priceInput.sendKeys(Keys.DELETE);
        priceInput.type(premiumAmount);
    }

    public String getPaymentInterval() {
        return inputPaymentInterval.getAttribute("value");
    }

    public void setPaymentInterval(String paymentInterval) {
        inputPaymentInterval.waitUntilVisible();
        inputPaymentInterval.click();
        inputPaymentInterval.type(paymentInterval);
        inputPaymentInterval.sendKeys(Keys.RETURN);
    }
}
