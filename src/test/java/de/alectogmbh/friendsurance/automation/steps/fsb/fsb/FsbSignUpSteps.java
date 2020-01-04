package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbSignUpPage;
import de.alectogmbh.friendsurance.automation.requirements.ValidationMessages;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FsbSignUpSteps extends AbstractScenarioSteps<FsbSignUpPage> {

    private FsbSignUpPage fsbSignUpPage;

    public FsbSignUpPage getPageObject() {
        return fsbSignUpPage;
    }

    @Step
    public String get_sign_up_page_headline_text() {
        return getPageObject().getSignUpPageHeadlineText();
    }

    @Step
    public String get_validation_message_for_empty_email_field() {
        return getPageObject().textForEmailValidation();
    }

    @Step
    public String get_validation_message_for_empty_password_field() {
        return getPageObject().textForEmptyPasswordValidation();
    }

    @Step
    public String get_validation_message_for_already_existed_email() {
        return getPageObject().textMessageForAlreadyExistedEmail();
    }

    @Step
    public String get_validation_message_for_incorrect_password_field() {
        return getPageObject().textForIncorrectPasswordValidation();
    }

    @Step
    public String get_show_button_attribute() {
        return getPageObject().getShowPasswordButton().getAttribute("class");
    }


    @Step
    public void enter_user_email(String email) {
        getPageObject().enterUserEmail(email);
    }

    @Step
    public void enter_user_password(String password) {
        getPageObject().enterUserPassword(password);
    }

    @Step
    public void click_on_show_button() {
        getPageObject().clickShowPasswordButton();
    }

    @Step
    public void confirm_condition_1() {
        getPageObject().clickCondition1();
    }

    @Step
    public void confirm_condition_2() {
        getPageObject().clickCondition2();
    }

    @Step
    public void confirm_condition_3() {
        getPageObject().clickCondition3();
    }

//    @Step
//    public List<String> get_validation_message_list_for_conditions_checkbox() {
//        return getPageObject().actualConditionTextForCheckBox();
//    }

    @Step
    public void click_on_sign_up_button() {
        getPageObject().clickOnSignUpButton();
    }

    @Step
    public void verify_sign_up_page_is_loaded_and_headline_is_present(String EXPECTED_SIGN_UP_PAGE_HEADLINE) {
        assertEquals(EXPECTED_SIGN_UP_PAGE_HEADLINE, get_sign_up_page_headline_text());
    }

    @StepGroup
    public void confirm_all_conditions() {
        confirm_condition_1();
        confirm_condition_2();
        confirm_condition_3();
    }

    @StepGroup
    public void verify_second_step_and_go_to_next_step(String email, String password, String EXPECTED_SIGN_UP_PAGE_HEADLINE) {
        verify_sign_up_page_is_loaded_and_headline_is_present(EXPECTED_SIGN_UP_PAGE_HEADLINE);
        enter_user_email(email);
        enter_user_password(password);
        confirm_all_conditions();
        click_on_sign_up_button();
    }
}
