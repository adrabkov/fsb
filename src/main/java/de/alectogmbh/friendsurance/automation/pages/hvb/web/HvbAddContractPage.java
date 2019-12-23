package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbAddContractPage.ADD_CONTRACT_PAGE_URL;

@At("#HOST" + ADD_CONTRACT_PAGE_URL)
@DefaultUrl(ADD_CONTRACT_PAGE_URL)
public class HvbAddContractPage extends AbstractPageObject {

  final static String ADD_CONTRACT_PAGE_URL = "/addcontract/add-order/";

  @FindBy(id = "addcontract-addinsurancecontract-headline")
  private WebElementFacade addContractPageheadline;

  @FindBy(id = "add-order-category")
  private WebElementFacade inputInsuranceCategory;

  @FindBy(id = "add-order-company")
  private WebElementFacade inputInsuranceCompany;

  @FindBy(id = "addcontract-addinsurancecontract__input-policy")
  private WebElementFacade policyNumberInput;

  @FindBy(id = "addcontract-addinsurancecontract__input-price")
  private WebElementFacade premiumAmountInput;

  @FindBy(id = "dropdown-addcontract-addinsurancecontract__select")
  private WebElementFacade paymentIntervalDropdown;

  @FindBy(id = "addcontract-addinsurancecontract__select")
  private WebElementFacade inputPaymentInterval;

  @FindBy(id = "add-order-save")
  private WebElementFacade addContractNextButton;

  public String getAddContractPageHeadline() {
    addContractPageheadline.waitUntilVisible();
    return addContractPageheadline.getText();
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

  public void enterPremiumAmount(String premiumAmount) {
    premiumAmountInput.clear();
    premiumAmountInput.type(premiumAmount);
  }

  public void selectPaymentIntervalByText(String paymentInterval) throws InterruptedException {
    Thread.sleep(5000);
    scrollToElement(inputPaymentInterval);

    inputPaymentInterval.type(paymentInterval);
  }

  public void clickAddContractGoNextButton() {
    scrollToElement(addContractNextButton);
    addContractNextButton.waitUntilClickable();
    addContractNextButton.click();
  }

}
