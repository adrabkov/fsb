package de.alectogmbh.friendsurance.automation.steps.admin;

import de.alectogmbh.friendsurance.automation.pages.admin.AdminOrderDetailsPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;

import java.util.Map;

public class AdminOrderDetailsSteps extends AbstractScenarioSteps<AdminOrderDetailsPage> {

  private AdminOrderDetailsPage page;
  private final static int FIRST_TABLE_INDEX = 0;

  @Step
  public void openPageForOrderId(String orderId) {
    page.openPage(orderId);
  }

  @Step
  public void verify_company_name(Map<String, String> categoryAndCompany) {
    String actualCompanyName = page.getTableValueByLabel(FIRST_TABLE_INDEX, "Versicherung");
    String actualCategoryName = page.getTableValueByLabel(FIRST_TABLE_INDEX, "Kategorie");
    ValidationUtils
        .checkTextIsCorrect(actualCompanyName, categoryAndCompany.get(actualCategoryName));
  }

  @Override
  public AdminOrderDetailsPage getPageObject() {
    return page;
  }
}