package de.alectogmbh.friendsurance.automation.steps.web.elements.header;

import de.alectogmbh.friendsurance.automation.pages.web.elements.header.HeaderGuestArea;
import de.alectogmbh.friendsurance.automation.pages.web.user.LoginPage;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public abstract class AbstractHeaderGuestAreaSteps<T extends HeaderGuestArea>
    extends AbstractHeaderSteps<T> {

  private T headerGuestArea;

  public AbstractHeaderGuestAreaSteps() {
  }

  public AbstractHeaderGuestAreaSteps(Pages pages) {
    super(pages);
  }


  public void click_login() {
    getPageObject().clickLoginLink();
  }

  @Step
  public void click_report_claim_link() {
    getPageObject().clickReportClaimLink();
  }

  @Step
  public void report_claim_page_for_guests_is_loaded() {
    ValidationUtils.checkCorrectPageLoaded(LoginPage.DEFAULT_URL + "#%2Fschaden-melden",
        getPageObject().getCurrentPageUrl()
    );
  }

  @Step
  public void login_page_for_guests_is_loaded() {
    ValidationUtils
        .checkCorrectPageLoaded(LoginPage.DEFAULT_URL, getPageObject().getCurrentPageUrl());
  }

  @Override
  protected T getPageObject() {
    return headerGuestArea;
  }
}
