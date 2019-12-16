package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbEditOrderPage.EDIT_ORDER_PAGE_URL;

@At("#HOST" + EDIT_ORDER_PAGE_URL)
@DefaultUrl(EDIT_ORDER_PAGE_URL)
public class FsbEditOrderPage extends BaseForm {

    final static String EDIT_ORDER_PAGE_URL = "addcontract/edit-order/";

    @FindBy(id = "addorder-addinsurance__headline_text")
    private WebElement editOrderPageHeadlineText;

    @FindBy(id = "addcontract-addinsurancecontract-delete")
    private WebElement deleteOrderItemLink;

    @FindBy(id = "select-category")
    private WebElement inputInsuranceCategory;

    @FindBy(id = "select-company")
    private WebElement inputInsuranceCompany;

    @FindBy(id = "addcontract-addinsurancecontract__input-policy")
    private WebElement policyNumberInput;

    @FindBy(id = "addcontract-addinsurancecontract__next")
    private WebElement saveContractDetailsButton;

    public String getEditOrderPageHeadlineText(){
//        editOrderPageHeadlineText.waitUntilVisible();
        return editOrderPageHeadlineText.getText();
    }

    public void clickOnDeleteOrderItemLink(){
//        deleteOrderItemLink.waitUntilVisible();
//        scrollToElement(deleteOrderItemLink);
//        deleteOrderItemLink.waitUntilClickable();
        deleteOrderItemLink.click();
    }

    public void selectInsuranceCategoryByText(String insuranceCategory){
//        inputInsuranceCategory.waitUntilPresent();
//        scrollToElement(inputInsuranceCategory);
        inputInsuranceCategory.sendKeys(insuranceCategory);
        inputInsuranceCategory.sendKeys(Keys.RETURN);
    }

    public void selectInsuranceCompanyByText(String insuranceCompany){
//        inputInsuranceCompany.waitUntilPresent();
//        scrollToElement(inputInsuranceCompany);
        inputInsuranceCompany.sendKeys(insuranceCompany);
        inputInsuranceCompany.sendKeys(Keys.RETURN);
    }

    public void enterInsurancePolicyNumber(String policyNumber) {
        policyNumberInput.clear();
        policyNumberInput.sendKeys(policyNumber);
    }

    public void clickOnSaveContractDetailsButton(){
//        saveContractDetailsButton.waitUntilVisible();
//        scrollToElement(saveContractDetailsButton);
//        saveContractDetailsButton.waitUntilClickable();
        saveContractDetailsButton.click();
    }



}
