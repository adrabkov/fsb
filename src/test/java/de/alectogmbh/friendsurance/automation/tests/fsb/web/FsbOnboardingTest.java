package de.alectogmbh.friendsurance.automation.tests.fsb.web;

import static de.alectogmbh.friendsurance.rules.Environment.ALL;
import static de.alectogmbh.friendsurance.rules.Environment.RUV;

import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbBankSelectionSteps;
import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbPersonalDetailsSteps;
import de.alectogmbh.friendsurance.automation.steps.fsb.fsb.FsbSignUpsteps;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerDataUtils;
import de.alectogmbh.friendsurance.rules.EnvironmentExecutionRule;
import net.serenitybdd.junit.runners.SerenityRunner;
import de.alectogmbh.friendsurance.rules.EnvironmentExecution;
import net.thucydides.core.annotations.Steps;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FsbOnboardingTest extends AbstractScenarioTest<FsbBankSelectionSteps> {

    @Steps
    private FsbBankSelectionSteps fsbBankSelectionSteps;
    @Steps
    private FsbPersonalDetailsSteps fsbPersonalDetailsSteps;
    @Steps
    private FsbSignUpsteps fsbSignUpsteps;


    protected FsbBankSelectionSteps getSteps() {
        return fsbBankSelectionSteps;
    }

    @Rule
    public EnvironmentExecutionRule rule = new EnvironmentExecutionRule();

    @Test
    @EnvironmentExecution(exclude = ALL, include = RUV)
    public void userRegistrationWithBankCredentials() {
        DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

        fsbPersonalDetailsSteps.verify_first_step_and_set_onboarding_personal_details(dbCustomerData.isGender(), dbCustomerData.getBirthDay(),
                dbCustomerData.getStreetName(), dbCustomerData.getHouseNumber(), dbCustomerData.getPostalCode(),
                dbCustomerData.getPlace(), dbCustomerData.getPhoneNum());
        fsbSignUpsteps.verify_second_step_and_finish_sign_up(dbCustomerData.getEmail(), dbCustomerData.getPassword());

    }

}
