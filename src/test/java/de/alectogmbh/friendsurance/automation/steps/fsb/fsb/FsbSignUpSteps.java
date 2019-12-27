//package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;
//
//import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbSignUpPage;
//import de.alectogmbh.friendsurance.automation.requirements.ValidationMessages;
//import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
//import net.thucydides.core.annotations.Step;
//import net.thucydides.core.annotations.StepGroup;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class FsbSignUpSteps extends AbstractScenarioSteps <FsbSignUpPage>{
//
////    private static ValidationMessages validationMessages = new ValidationMessages();
////    private static final String EXPECTED_SIGN_UP_PAGE_HEADLINE = validationMessages.getText_for_sign_up_page_headline();
////    private static final String EXPECTED_TEXT_FOR_EMPTY_OR_INCORRECT_EMAIL = validationMessages.getValidation_text_for_empty_or_incorrect_email();
////    private static final String EXPECTED_TEXT_FOR_INCORRECT_PASSWORD = validationMessages.getValidation_text_for_incorrect_password();
////    private static final String EXPECTED_TEXT_FOR_EMPTY_PASSWORD = validationMessages.getValidation_text_for_empty_password();
////    private static final String EXPECTED_TEXT_FOR_ALREADY_EXISTED_EMAIL = validationMessages.getValidation_text_for_already_existed_email();
////    private static final List<String> EXPECTED_CONDITION_TEXT = validationMessages.getConditionText();
////    private static final String EXPECTED_ATTRIBUTE = "active";
//
//    private FsbSignUpPage fsbSignUpPage;
//
//    public FsbSignUpPage getPageObject() {
//        return fsbSignUpPage;
//    }
//
//    @Step
//    public String get_sign_up_page_headline_text() {
//        return getPageObject().getSignUpPageHeadlineText();
//    }
//
//    @Step
//    public String get_validation_message_for_empty_email_field() {
//        return getPageObject().textForEmailValidation();
//    }
//
//    @Step
//    public String get_validation_message_for_empty_password_field() {
//        return getPageObject().textForEmptyPasswordValidation();
//    }
//
//    @Step
//    public String get_validation_message_for_already_existed_email() {
//        return getPageObject().textMessageForAlreadyExistedEmail();
//    }
//
//    @Step
//    public String get_validation_message_for_incorrect_password_field() {
//        return getPageObject().textForIncorrectPasswordValidation();
//    }
//
//    @Step
//    public String get_show_button_attribute() {
//        return getPageObject().getShowPasswordButton().getAttribute("class");
//    }
//
//
//    @Step
//    public void enter_user_email(String email) {
//        getPageObject().enterUserEmail(email);
//    }
//
//    @Step
//    public void enter_user_password(String password) {
//        getPageObject().enterUserPassword(password);
//    }
//
//    @Step
//    public void click_on_show_button() {
//        getPageObject().clickShowPasswordButton();
//    }
//
//    @Step
//    public void confirm_condition_1() {
//        getPageObject().clickCondition1();
//    }
//
//    @Step
//    public void confirm_condition_2() {
//        getPageObject().clickCondition2();
//    }
//
//    @Step
//    public void confirm_condition_3() {
//        getPageObject().clickCondition3();
//    }
//
////    @Step
////    public List<String> get_validation_message_list_for_conditions_checkbox() {
////        return getPageObject().actualConditionTextForCheckBox();
////    }
//
//    @Step
//    public void click_on_sign_up_button() {
//        getPageObject().clickOnSignUpButton();
//    }
//
//    @Step
//    public void verify_sign_up_page_is_loaded_and_headline_is_present() {
//        assertEquals(EXPECTED_SIGN_UP_PAGE_HEADLINE, get_sign_up_page_headline_text());
//    }
//
//    @StepGroup
//    public void confirm_all_conditions() {
//        confirm_condition_1();
//        confirm_condition_2();
//        confirm_condition_3();
//    }
//
//    @StepGroup
//    public void verify_second_step_and_go_to_next_step(String email, String password) {
//        verify_sign_up_page_is_loaded_and_headline_is_present();
//        enter_user_email(email);
//        enter_user_password(password);
//        confirm_all_conditions();
//        click_on_sign_up_button();
//    }
//
//    @StepGroup
//    public void verify_validation_message_for_empty_email_field(String password) {
//        verify_sign_up_page_is_loaded_and_headline_is_present();
//        enter_user_password(password);
//        confirm_all_conditions();
//        click_on_sign_up_button();
//        assertEquals(EXPECTED_TEXT_FOR_EMPTY_OR_INCORRECT_EMAIL, get_validation_message_for_empty_email_field());
//    }
//
//    @StepGroup
//    public void verify_validation_message_for_empty_password_field(String email) {
//        verify_sign_up_page_is_loaded_and_headline_is_present();
//        enter_user_email(email);
//        confirm_all_conditions();
//        assertEquals(EXPECTED_TEXT_FOR_EMPTY_PASSWORD, get_validation_message_for_empty_password_field());
//    }
//
//    @StepGroup
//    public void verify_validation_message_for_already_existed_email(String email, String password) {
//        verify_second_step_and_go_to_next_step(email, password);
//        assertEquals(EXPECTED_TEXT_FOR_ALREADY_EXISTED_EMAIL, get_validation_message_for_already_existed_email());
//    }
//
//    @StepGroup
//    public void verify_validation_message_for_incorrect_password(String email, String password) {
//        verify_second_step_and_go_to_next_step(email, password);
//        assertEquals(EXPECTED_TEXT_FOR_INCORRECT_PASSWORD, get_validation_message_for_incorrect_password_field());
//    }
//
//    @StepGroup
//    public void verify_show_password_button(String password) {
//        enter_user_password(password);
//        click_on_show_button();
//        assertEquals(EXPECTED_ATTRIBUTE, get_show_button_attribute());
//    }
//
////    @StepGroup
////    public void verify_validation_messages_for_conditions_checkbox(String email, String password) {
////        enter_user_email(email);
////        enter_user_password(password);
////        click_on_sign_up_button();
////        assertEquals(EXPECTED_CONDITION_TEXT, get_validation_message_list_for_conditions_checkbox());
////        confirm_all_conditions();
////        click_on_sign_up_button();
////    }
//
//}
