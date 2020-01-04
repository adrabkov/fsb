package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbAccountPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class FsbAccountStep extends AbstractScenarioSteps<FsbAccountPage> {

    private FsbAccountPage fsbAccountPage;

    public FsbAccountPage getPageObject() {
        return fsbAccountPage;
    }

    @Step
    public void choose_Phone_Number_Checkbox() {
        getPageObject().choosePhoneNumberCheckbox();
    }

    @Step
    public void click_on_bank_account_next_button() {
        getPageObject().clickBankAccountNextButton();
    }

    @StepGroup
    public void choose_Phone_Number_Checkbox_and_click_next_button() {
        choose_Phone_Number_Checkbox();
        click_on_bank_account_next_button();
    }
}
