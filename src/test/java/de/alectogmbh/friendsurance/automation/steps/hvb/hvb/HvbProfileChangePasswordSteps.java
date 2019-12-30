package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbProfilePasswordChangePage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;


public class HvbProfileChangePasswordSteps extends AbstractScenarioSteps<HvbProfilePasswordChangePage> {

    private HvbProfilePasswordChangePage hvbProfilePasswordChangePage;

    public HvbProfilePasswordChangePage getPageObject() {
        return hvbProfilePasswordChangePage;
    }

    @Step
    public String get_password_change_page_headline() {
        return getPageObject().getPasswordChangePageHeadline();
    }

    @Step
    public void enter_old_password(String oldPassword) {
        getPageObject().enterOldPassword(oldPassword);
    }

    @Step
    public void enter_new_password(String newPassword) {
        getPageObject().enterNewPassword(newPassword);
    }

    @Step
    public void click_on_save_password_button() {
        getPageObject().clickOnSavePasswordButton();
    }

    @Step
    public String get_toast_banner_text() {
        return getPageObject().getToastBannerText();
    }

    @Step
    public void verify_password_change_page_is_loaded_and_headline_is_present(String expected_password_change_headline) {
        assertEquals(expected_password_change_headline, get_password_change_page_headline());
    }

    @Step
    public void verify_if_success_toast_banner_is_displayed(String expected_success_banner_text) {
        assertEquals(expected_success_banner_text, get_toast_banner_text());
    }

    @StepGroup
    public void enter_old_and_new_password_and_click_on_save_button(String oldPassword, String newPassword) {
        enter_old_password(oldPassword);
        enter_new_password(newPassword);
        click_on_save_password_button();
    }

}
