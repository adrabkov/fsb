package de.alectogmbh.friendsurance.automation.steps.web.elements.header;

import de.alectogmbh.friendsurance.automation.pages.web.elements.header.HeaderMemberArea;
import de.alectogmbh.friendsurance.automation.pages.web.elements.header.menu.MyFriendsuranceMenu;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public abstract class AbstractHeaderMemberAreaSteps<T extends HeaderMemberArea>
    extends AbstractHeaderSteps<T> {

  private T headerMemberArea;

  public AbstractHeaderMemberAreaSteps() {
  }

  public AbstractHeaderMemberAreaSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void myFriendsuranceMenuIsPresent() {
    ValidationUtils.checkElementIsDisplayed("My friendsurance menu is present",
        getPageObject().getMyFriendsuranceMenu().isMyFriendsuranceMenuPresent()
    );
  }

  @Step
  public void overviewMenuItemIsPresent() {
    ValidationUtils
        .checkElementIsDisplayed("Overview menu item", getPageObject().getMyFriendsuranceMenu().
            isOverviewMenuItemPresent());
  }

  @Step
  public void myInsuranceMenuItemIsPresent() {
    ValidationUtils
        .checkElementIsDisplayed("My Insurance Menu Item", getPageObject().getMyFriendsuranceMenu().
            isMyInsuranceMenuItemPresent());
  }

  @Step
  public void myCashbacksMenuItemIsPresent() {
    ValidationUtils
        .checkElementIsDisplayed("My cashbacks menu item", getPageObject().getMyFriendsuranceMenu().
            isMyCashbacksMenuItemPresent());
  }

  @Step
  public void myConnectionsMenuItemIsPresent() {
    ValidationUtils.checkElementIsDisplayed("My connections menu item",
        getPageObject().getMyFriendsuranceMenu().
            isMyConnectionsMenuItemPresent());
  }

  @Step
  public void myInviteMenuItemIsPresent() {
    ValidationUtils
        .checkElementIsDisplayed("My invite menu item", getPageObject().getMyFriendsuranceMenu().
            isInviteMenuItemPresent());
  }

  @Step
  public void myRequestsMenuItemIsPresent() {
    ValidationUtils
        .checkElementIsDisplayed("My requests menu item", getPageObject().getMyFriendsuranceMenu().
            isMyRequestsMenuItemPresent());
  }

  @Step
  public void claimReportMenuItemIsPresent() {
    ValidationUtils
        .checkElementIsDisplayed("Claim report menu item", getPageObject().getMyFriendsuranceMenu().
            isClaimReportMenuItemPresent());
  }

  @Step
  public void settingsMenuItemIsPresent() {
    ValidationUtils
        .checkElementIsDisplayed("Settings menu item", getPageObject().getMyFriendsuranceMenu().
            isSettingsMenuItemPresent());
  }

  @Step
  public void logoutMenuItemIsPresent() {
    ValidationUtils
        .checkElementIsDisplayed("Logout menu item", getPageObject().getMyFriendsuranceMenu().
            isLogoutMenuItemPresent());
  }

  @Step
  public void myProfileMenuItemIsCorrect() {
    ValidationUtils
        .checkLinkIsCorrect(MyFriendsuranceMenu.MY_PROFILE_HREF, getPageObject().getProfileMenu().
            getProfileMenuHref());
  }

  @Step
  public void overviewMenuItemIsCorrect() {
    ValidationUtils.checkLinkIsCorrect(MyFriendsuranceMenu.OVERVIEW_HREF,
        getPageObject().getMyFriendsuranceMenu().
            getOverviewMenuItemHref());
  }

  @Step
  public void myInsuranceMenuItemIsCorrect() {
    ValidationUtils
        .checkLinkIsCorrect(MyFriendsuranceMenu.MY_INSURANCE_HREF,
            getPageObject().getMyFriendsuranceMenu().
                getMyInsuranceMenuItemHref());
  }

  @Step
  public void myCashbacksMenuItemIsCorrect() {
    ValidationUtils
        .checkLinkIsCorrect(MyFriendsuranceMenu.MY_CASHBACKS_HREF,
            getPageObject().getMyFriendsuranceMenu().
                getMyCashbacksMenuItemHref());
  }

  @Step
  public void myConnectionsMenuItemIsCorrect() {
    ValidationUtils
        .checkLinkIsCorrect(MyFriendsuranceMenu.MY_CONNECTIONS_HREF,
            getPageObject().getMyFriendsuranceMenu().
                getMyConnectionsMenuItemHref());
  }

  @Step
  public void myInviteMenuItemIsCorrect() {
    ValidationUtils.checkLinkIsCorrect(MyFriendsuranceMenu.INVITE_HREF,
        getPageObject().getMyFriendsuranceMenu().
            getInviteMenuItemHref());
  }

  @Step
  public void myRequestsMenuItemIsCorrect() {
    ValidationUtils
        .checkLinkIsCorrect(MyFriendsuranceMenu.MY_REQUESTS_HREF,
            getPageObject().getMyFriendsuranceMenu().
                getMyRequestsMenuItemHref());
  }

  @Step
  public void claimReportMenuItemIsCorrect() {
    ValidationUtils
        .checkLinkIsCorrect(MyFriendsuranceMenu.CLAIM_REPORT_HREF,
            getPageObject().getMyFriendsuranceMenu().
                getClaimReportMenuItemHref());
  }

  @Step
  public void settingsMenuItemIsCorrect() {
    ValidationUtils.checkLinkIsCorrect(MyFriendsuranceMenu.SETTINGS_HREF,
        getPageObject().getMyFriendsuranceMenu().
            getSettingsMenuItemHref());
  }

  @Step
  public void logoutMenuItemIsCorrect() {
    ValidationUtils.checkLinkIsCorrect(MyFriendsuranceMenu.LOGOUT_HREF,
        getPageObject().getMyFriendsuranceMenu().
            getLogoutMenuItemHref());
  }

  @Override
  protected T getPageObject() {
    return headerMemberArea;
  }
}
