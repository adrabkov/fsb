package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbProfilePage.PROFILE_PAGE_URL;

@At("#HOST" + PROFILE_PAGE_URL)
@DefaultUrl(PROFILE_PAGE_URL)
public class HvbProfilePage extends AbstractPageObject {

  public static final String PROFILE_PAGE_URL = "/home/profile/";

  @FindBy(id = "profile-ona-link")
  private WebElementFacade onaPersonalDetailsLink;

  @FindBy(id = "profile-changepassword-link")
  private WebElementFacade changePassword;

  @FindBy(id = "profile-delete-account-link")
  private WebElementFacade deleteAccountLink;

  public void clickOnaPersonalDetailsLink() {
    onaPersonalDetailsLink.waitUntilClickable();
    onaPersonalDetailsLink.click();
  }

  public void clickOnChangePasswordLink() {
    changePassword.waitUntilClickable();
    changePassword.click();
  }

  public void clickOnDeleteAccountLink() {
    deleteAccountLink.waitUntilClickable();
    deleteAccountLink.click();
  }

}
