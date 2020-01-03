package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbNotificationPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HvbNotificationSteps extends AbstractScenarioSteps<HvbNotificationPage> {

  private static final String EXPECTED_NOTIFICATION_PAGE_HEADLINE = "Benachrichtigungen";
  private static final String NOTIFICATION_TITLE_FOR_BIRTH = "Haben Sie Familienzuwachs?";
  private static final String NOTIFICATION_TITLE_FOR_MOVE = "Haben Sie ein neues Zuhause?";
  private static final String NOTIFICATION_TITLE_FOR_EXTRACTED_DATA = "Neuer Versicherungsvertrag erkannt";
  private static final String NOTIFICATION_TITLE_FOR_CONFIRMED_KLE = "Herzlichen Glückwunsch!";
  private static final String PROFILE_TEXT_LINK = "Profil";
  private static final String CHILDREN = "4";
  private static final String
      NEW_NOTIFICATION_TEXT_FOR_CONFIRMED_KLE =
      "Sie haben dieses neue Lebensereignis bereits bestätigt.";
  private static final String
      NEW_NOTIFICATION_TEXT_AFTER_ADDING_EXTRACTED_CONTRACTS =
      "Vielen Dank für die Überprüfung des Vertrags.";

  private HvbNotificationPage hvbNotificationPage;

  public HvbNotificationPage getPageObject() {
    return hvbNotificationPage;
  }

  @Step
  public String get_notification_page_headline() {
    return getPageObject().getNotificationsPageHeadline();
  }

  @Step
  public void verify_notification_page_is_loaded_and_headline_is_present() {
    assertEquals(EXPECTED_NOTIFICATION_PAGE_HEADLINE, get_notification_page_headline());
  }

  @Step
  public void select_number_of_children_by_text(String CHILDREN) {
    getPageObject().selectNumberOfChildrenByText(CHILDREN);
  }

  @Step
  public void click_on_save_children_button() {
    getPageObject().clickOnNotificationWithTitle(NOTIFICATION_TITLE_FOR_BIRTH);
  }

  @Step
  public void click_on_notification_with_title_kle_move() {
    getPageObject().clickOnNotificationWithTitle(NOTIFICATION_TITLE_FOR_MOVE);
  }

  @Step
  public void wait_for_move_confirmed_messenger_button_to_appear() {
    getPageObject().waitForMoveMessengerButtonToAppear();
  }

  @Step
  public void wait_for_birth_confirmed_messenger_button_to_appear() {
    getPageObject().waitForBirthMessengerButtonToAppear();
  }

  @Step
  public void verify_notification_text_for_confirmed_kle_move() {
    List<String> texts = getPageObject().getTextsInNotificationWithTitle(NOTIFICATION_TITLE_FOR_MOVE);
    assertTrue(createAssertMessageFor(NEW_NOTIFICATION_TEXT_FOR_CONFIRMED_KLE, texts),
        texts.contains(NEW_NOTIFICATION_TEXT_FOR_CONFIRMED_KLE));
  }

  @Step
  public void click_on_profile_link_inside_confirmed_kle_move() {
    getPageObject().clickOnLinkWithTextInNotificationWithTitle(PROFILE_TEXT_LINK, NOTIFICATION_TITLE_FOR_CONFIRMED_KLE);
  }

  @Step
  public void click_on_notification_with_title_kle_birth() {
    getPageObject().clickOnNotificationWithTitle(NOTIFICATION_TITLE_FOR_BIRTH);
  }

  @Step
  public void verify_notification_text_for_confirmed_kle_birth() {
    List<String> texts = getPageObject().getTextsInNotificationWithTitle(NOTIFICATION_TITLE_FOR_BIRTH);
    assertTrue(createAssertMessageFor(NEW_NOTIFICATION_TEXT_FOR_CONFIRMED_KLE, texts),
        texts.contains(NEW_NOTIFICATION_TEXT_FOR_CONFIRMED_KLE));
  }

  @Step
  public void verify_notification_text_for_added_extracted_contracts() {
    List<String> texts = getPageObject().getTextsInNotificationWithTitle(NOTIFICATION_TITLE_FOR_EXTRACTED_DATA);
    assertTrue(createAssertMessageFor(NEW_NOTIFICATION_TEXT_AFTER_ADDING_EXTRACTED_CONTRACTS, texts),
        texts.contains(NEW_NOTIFICATION_TEXT_AFTER_ADDING_EXTRACTED_CONTRACTS));
  }

  @Step
  public void click_on_notification_with_title_extracted_data() {
    getPageObject().clickOnNotificationWithTitle(NOTIFICATION_TITLE_FOR_EXTRACTED_DATA);
  }

  @StepGroup
  public void confirm_kle_move_and_inside_notification_text_click_on_profile_link() {
    verify_notification_page_is_loaded_and_headline_is_present();
    click_on_notification_with_title_kle_move();
    wait_for_move_confirmed_messenger_button_to_appear();
    verify_notification_text_for_confirmed_kle_move();
    click_on_profile_link_inside_confirmed_kle_move();
  }

  @StepGroup
  public void confirm_kle_birth_select_number_of_children_and_save() {
    click_on_notification_with_title_kle_birth();
    select_number_of_children_by_text(CHILDREN);
    click_on_save_children_button();
    wait_for_birth_confirmed_messenger_button_to_appear();
    verify_notification_text_for_confirmed_kle_birth();
  }

  @Step
  public void verify_confirmation_notification_text_for_added_extracted_contracts() {
    verify_notification_text_for_added_extracted_contracts();
  }

  private String createAssertMessageFor(String expectedText, List<String> texts) {
    return String.format("EXPECTED IN THE LIST: [%s]. LIST: %s.", expectedText, texts);
  }

}
