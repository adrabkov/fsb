package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbProfilePage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;

public class HvbProfileSteps extends AbstractScenarioSteps<HvbProfilePage> {

    private HvbProfilePage hvbProfilePage;

    public HvbProfilePage getPageObject() {
        return hvbProfilePage;
    }

    @Step
    public void click_ona_personal_details_link() {
        getPageObject().clickOnaPersonalDetailsLink();
    }

    @Step
    public void click_on_change_password_link() {
        getPageObject().clickOnChangePasswordLink();
    }

    @Step
    public void click_on_delete_account_link() {
        getPageObject().clickOnDeleteAccountLink();
    }

}
