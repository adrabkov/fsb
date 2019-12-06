package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbFinApiWebFormPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class FsbFinApiWebFormSteps {

    private FsbFinApiWebFormPage fsbFinApiWebFormPage = new FsbFinApiWebFormPage();

    private FsbFinApiWebFormPage getPageObject() {
        return fsbFinApiWebFormPage;
    }

    @Step
    public void enter_online_banking_input_user_id(String userID) {
        getPageObject().enterOnlineBankingInputUserId(userID);
    }

    @Step
    public void enter_online_banking_input_pin(String pin) {
        getPageObject().enterOnlineBankingInputPin(pin);
    }

    @Step
    public void check_save_pin_checkbox() {
        getPageObject().checkSavePinCheckbox();
    }

    @Step
    public void click_on_bank_data_retrieve_button() {
        getPageObject().clickOnBankDataRetrieveButton();
    }

    @StepGroup
    public void enter_bank_login_credential_on_fin_api_web_form_and_retrieve_data(String userID, String pin) {
        enter_online_banking_input_user_id(userID);
        enter_online_banking_input_pin(pin);
        check_save_pin_checkbox();
        click_on_bank_data_retrieve_button();
    }



}
