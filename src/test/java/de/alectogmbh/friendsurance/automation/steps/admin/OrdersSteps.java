package de.alectogmbh.friendsurance.automation.steps.admin;

import de.alectogmbh.friendsurance.automation.pages.admin.OrdersPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import org.openqa.selenium.WebElement;

public class OrdersSteps extends AbstractScenarioSteps<OrdersPage> {

  private OrdersPage ordersPage;

  public void enterSearchTerm(String search) {
    getPageObject().enter_search_term(search);
  }

  public void submitSearchForm() {
    getPageObject().submit_search_form();
  }

  public void checkOrdersPageLoaded() {
    ValidationUtils
        .checkCorrectPageLoaded(OrdersPage.DEFAULT_URL, getPageObject().getCurrentPageUrl());
  }

  public WebElement get_element_for_row_and_column(int row, int column) {
    return getPageObject().getElementForRowAndColumn(row, column);
  }

  protected OrdersPage getPageObject() {
    return ordersPage;
  }
}
