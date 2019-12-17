package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbEditOrderPage.EDIT_ORDER_PAGE_URL;

@At("#HOST" + EDIT_ORDER_PAGE_URL)
@DefaultUrl(EDIT_ORDER_PAGE_URL)
public class FsbEditOrderPage extends AbstractPageObject {

    final static String EDIT_ORDER_PAGE_URL = "addcontract/edit-order/";

    @FindBy(className = "addorder-addinsurance__headline_text")
    private WebElementFacade editOrderPageHeadlineText;

    @FindBy(id = "addcontract-addinsurancecontract-delete")
    private WebElementFacade deleteOrderItemLink;

    @FindBy(id = "select-category")
    private WebElementFacade inputInsuranceCategory;

    @FindBy(id = "select-company")
    private WebElementFacade inputInsuranceCompany;

    @FindBy(id = "addcontract-addinsurancecontract__input-policy")
    private WebElementFacade policyNumberInput;

    @FindBy(id = "addcontract-addinsurancecontract__next")
    private WebElementFacade saveContractDetailsButton;

    public String getEditOrderPageHeadlineText() {
        return editOrderPageHeadlineText.getText();
    }

    public void clickOnDeleteOrderItemLink() {
        deleteOrderItemLink.waitUntilVisible();
        scrollToElement(deleteOrderItemLink);
        deleteOrderItemLink.waitUntilClickable();
        deleteOrderItemLink.click();
    }

    public void selectInsuranceCategoryByText(String insuranceCategory) {
        inputInsuranceCategory.waitUntilPresent();
        scrollToElement(inputInsuranceCategory);
        inputInsuranceCategory.type(insuranceCategory);
        inputInsuranceCategory.sendKeys(Keys.RETURN);
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

    public void clickOnSaveContractDetailsButton() {
        saveContractDetailsButton.waitUntilVisible();
        scrollToElement(saveContractDetailsButton);
        saveContractDetailsButton.waitUntilClickable();
        saveContractDetailsButton.click();
    }
}
