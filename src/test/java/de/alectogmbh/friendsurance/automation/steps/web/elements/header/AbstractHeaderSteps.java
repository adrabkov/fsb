package de.alectogmbh.friendsurance.automation.steps.web.elements.header;

import de.alectogmbh.friendsurance.automation.pages.web.elements.header.AbstractHeader;
import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.*;
import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.home.HomePage;
import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.press.AboutFriendsurancePage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

public abstract class AbstractHeaderSteps<T extends AbstractHeader>
    extends AbstractScenarioSteps<T> {

  private T abstractHeader;

  public AbstractHeaderSteps() {
  }

  public AbstractHeaderSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void friendsurance_link_is_present() {
    ValidationUtils.checkElementIsDisplayed("Friendsurance Link",
        getPageObject().isFriendsuranceLinkPresent());
  }

  @Step
  public void friendsurance_link_is_correct() {
    ValidationUtils
        .checkLinkIsCorrect(HomePage.DEFAULT_URL, getPageObject().getFriendsuranceLinkHref());
  }

  @Step
  public void friendsurance_logo_is_present() {
    ValidationUtils.checkElementIsDisplayed("Friendsurance Logo",
        getPageObject().isFriendsuranceLogoPresent());
  }

  @Step
  public void friendsurance_principle_menu_item_is_correct() {
    ValidationUtils.checkLinkIsCorrect(HowItWorksPage.DEFAULT_URL,
        getPageObject().getHowItWorksMenu().getFriendsurancePrincipleMenuItemHref()
    );
  }

  @Step
  public void faq_menu_item_is_correct() {
    ValidationUtils
        .checkLinkIsCorrect(FaqPage.DEFAULT_URL,
            getPageObject().getHowItWorksMenu().getFaqMenuItemHref());
  }

  @Step
  public void team_menu_item_is_correct() {
    ValidationUtils
        .checkLinkIsCorrect(AboutUsPage.DEFAULT_URL,
            getPageObject().getAboutUsMenu().getTeamMenuItemHref());
  }

  @Step
  public void press_menu_item_is_correct() {
    ValidationUtils.checkLinkIsCorrect(AboutFriendsurancePage.DEFAULT_URL_2,
        getPageObject().getAboutUsMenu().getPressMenuItemHref()
    );
  }

  @Step
  public void blog_menu_item_is_correct() {
    ValidationUtils
        .checkLinkIsCorrect(BlogPage.DEFAULT_URL,
            getPageObject().getAboutUsMenu().getBlogMenuItemHref());
  }

  @Step
  public void qualityMenuItemIsCorrect() {
    ValidationUtils.checkLinkIsCorrect(QualityPage.DEFAULT_URL,
        getPageObject().getAboutUsMenu().get_quality_menu_item_href()
    );
  }

  @Step
  public void is_phone_headline_correct() {
    ValidationUtils.checkTextIsCorrect("Beratung ohne Zusatzkosten\n0800-087 088 0",
        getPageObject().getCustomerSupportHeadline()
    );
  }

  @StepGroup
  public void friendsurance_link_is_present_and_correct() {
    friendsurance_link_is_present();
    friendsurance_link_is_correct();
  }

  @StepGroup
  public void how_it_works_menu_links_are_correct() {
    friendsurance_principle_menu_item_is_correct();
    faq_menu_item_is_correct();
  }

  @StepGroup
  public void about_us_menu_links_are_correct() {
    press_menu_item_is_correct();
    blog_menu_item_is_correct();
    qualityMenuItemIsCorrect();
    team_menu_item_is_correct();
  }

  @Override
  protected T getPageObject() {
    return abstractHeader;
  }
}
