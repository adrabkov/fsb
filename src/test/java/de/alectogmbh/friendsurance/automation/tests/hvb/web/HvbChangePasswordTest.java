package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.HvbStepCollection;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.HvbDBCustomerDataUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static de.alectogmbh.friendsurance.automation.tests.web.utils.hvb.HvbPageHeadline.*;

@RunWith(SerenityRunner.class)
public class HvbChangePasswordTest extends AbstractScenarioTest<HvbStepCollection> {

    @Steps
    private HvbStepCollection hvbStepCollection;

    protected HvbStepCollection getSteps() {
        return hvbStepCollection;
    }

//    @Rule
//    public EnvironmentExecutionRule rule = new EnvironmentExecutionRule();

    @Test
    //    @EnvironmentExecution(exclude = ALL, include = HVB)
    public void profilePasswordChange() throws InterruptedException {

        DBCustomerData dbCustomerData = HvbDBCustomerDataUtils.createDBCustomerData();

        hvbStepCollection.registerUserWithBankCredentials(dbCustomerData);

        hvbStepCollection.getHvbOrderOverviewSteps().click_on_profile_link();

        hvbStepCollection.getHvbProfileSteps().click_on_change_password_link();

        hvbStepCollection.getHvbProfileChangePasswordSteps().verify_password_change_page_is_loaded_and_headline_is_present(EXPECTED_PASSWORD_CHANGE_HEADLINE);
        hvbStepCollection.getHvbProfileChangePasswordSteps().
                enter_old_and_new_password_and_click_on_save_button(dbCustomerData.getPassword(),
                        dbCustomerData.getNewPassword());
        hvbStepCollection.getHvbProfileChangePasswordSteps().verify_if_success_toast_banner_is_displayed(EXPECTED_PASSWORD_CHANGE_SUCCESS_TEXT);

        hvbStepCollection.getHvbOrderOverviewSteps().click_on_header_logout_link();

        hvbStepCollection.userLogin(dbCustomerData.getEmail(), dbCustomerData.getNewPassword());

    }

}
