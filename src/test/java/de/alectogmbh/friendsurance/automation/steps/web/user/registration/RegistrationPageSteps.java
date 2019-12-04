package de.alectogmbh.friendsurance.automation.steps.web.user.registration;

import de.alectogmbh.friendsurance.automation.pages.web.user.LoginPage;
import de.alectogmbh.friendsurance.automation.pages.web.user.RegistrationPage;
import de.alectogmbh.friendsurance.automation.steps.utils.ValidationUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

public class RegistrationPageSteps extends AbstractRegistrationSteps {

  private String headlineFBModal1;
  private String textFBModal1;
  private String headlineFBModal2;
  private String textFBModal2;
  private String headlineFBModal3;
  private String textFBModal3;
  private String headlineFBModal4;
  private String textFBModal4;

  public RegistrationPageSteps() {
  }

  public RegistrationPageSteps(Pages pages) {
    super(pages);
  }


  @Step
  public void login_link_is_correct() {
    ValidationUtils
        .checkLinkIsCorrect(LoginPage.DEFAULT_URL, getPageObject().get_login_link_href());
  }

  @Step
  public void is_agb_link_is_present() {
    getPageObject().is_agb_link_present();
  }

  @Step
  public void is_data_security_link_is_present() {
    getPageObject().is_data_security_link_present();
  }

  @Step
  public void is_more_information_link_is_present() {
    getPageObject().is_more_information_link_present();
  }

  @Step
  public void is_registration_page_loaded() {
    ValidationUtils
        .checkCorrectPageLoaded(RegistrationPage.DEFAULT_URL, getPageObject().getCurrentPageUrl());
  }

  @Step
  public void clickFBMoreInformationLink() {
    getPageObject().click_more_information_fb_button();
  }

  @Step
  public void isHeadlineFB1Visible() {
    ValidationUtils.checkElementIsDisplayed("Headline 1 FB Modal",
        getPageObject().is_headline_one_fb_modal_visible());
  }

  @Step
  public void isHeadlineFB1Correct() {
    ValidationUtils
        .checkTextIsCorrect(headlineFBModal1, getPageObject().get_headline_one_fb_modal());
  }

  @Step
  public void isTextFB1Visible() {
    ValidationUtils
        .checkElementIsDisplayed("Text 1 FB Modal", getPageObject().is_text_one_fb_modal_visible());
  }

  @Step
  public void isTextFB1Correct() {
    ValidationUtils.checkTextIsCorrect(textFBModal1, getPageObject().get_text_one_fb_modal());
  }

  @Step
  public void isHeadlineFB2Visible() {
    ValidationUtils.checkElementIsDisplayed("Headline 2 FB Modal",
        getPageObject().is_headline_two_fb_modal_visible());
  }

  @Step
  public void isHeadlineFB2Correct() {
    ValidationUtils
        .checkTextIsCorrect(headlineFBModal2, getPageObject().get_headline_two_fb_modal());
  }

  @Step
  public void isTextFB2Visible() {
    ValidationUtils
        .checkElementIsDisplayed("Text 2 FB Modal", getPageObject().is_text_two_fb_modal_visible());
  }

  @Step
  public void isTextFB2Correct() {
    ValidationUtils.checkTextIsCorrect(textFBModal2, getPageObject().get_text_two_fb_modal());
  }

  @Step
  public void isHeadlineFB3Visible() {
    ValidationUtils.checkElementIsDisplayed("Headline 3 FB Modal",
        getPageObject().is_headline_three_fb_modal_visible());
  }

  @Step
  public void isHeadlineFB3Correct() {
    ValidationUtils
        .checkTextIsCorrect(headlineFBModal3, getPageObject().get_headline_three_fb_modal());
  }

  @Step
  public void isTextFB3Visible() {
    ValidationUtils.checkElementIsDisplayed("Text 3 FB Modal",
        getPageObject().is_text_three_fb_modal_visible());
  }

  @Step
  public void isTextFB3Correct() {
    ValidationUtils.checkTextIsCorrect(textFBModal3, getPageObject().get_text_three_fb_modal());
  }

  @Step
  public void isHeadlineFB4Visible() {
    ValidationUtils.checkElementIsDisplayed("Headline 4 FB Modal",
        getPageObject().is_headline_four_fb_modal_visible());
  }

  @Step
  public void isHeadlineFB4Correct() {
    ValidationUtils
        .checkTextIsCorrect(headlineFBModal4, getPageObject().get_headline_four_fb_modal());
  }

  @Step
  public void isTextFB4Visible() {
    ValidationUtils.checkElementIsDisplayed("Text 4 FB Modal",
        getPageObject().is_text_four_fb_modal_visible());
  }

  @Step
  public void isTextFB4Correct() {
    ValidationUtils.checkTextIsCorrect(textFBModal4, getPageObject().get_text_four_fb_modal());
  }

  @StepGroup
  public void checkFBModalTexts() {
    isHeadlineFB1Visible();
    isHeadlineFB1Correct();
    isTextFB1Visible();
    isTextFB1Correct();
    isHeadlineFB2Visible();
    isHeadlineFB2Correct();
    isTextFB2Visible();
    isTextFB2Correct();
    isHeadlineFB3Visible();
    isHeadlineFB3Correct();
    isTextFB3Visible();
    isTextFB3Correct();
    isHeadlineFB4Visible();
    isHeadlineFB4Correct();
    isTextFB4Visible();
    isTextFB4Correct();
  }
}
