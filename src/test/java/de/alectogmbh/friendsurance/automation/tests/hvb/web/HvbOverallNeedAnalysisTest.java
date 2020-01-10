package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.HvbStepCollection;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.HvbDBCustomerDataUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class HvbOverallNeedAnalysisTest extends AbstractScenarioTest<HvbStepCollection> {

    @Steps
    private HvbStepCollection hvbStepCollection;

    protected HvbStepCollection getSteps() {
        return hvbStepCollection;
    }

//    @Rule
//    public EnvironmentExecutionRule rule = new EnvironmentExecutionRule();

    @Test
//    @EnvironmentExecution(exclude = ALL, include = HVB)
    public void overallNeedAnalysisQuestionnaireAfterCreatingUser() throws InterruptedException {

        DBCustomerData dbCustomerData = HvbDBCustomerDataUtils.createDBCustomerData();

        hvbStepCollection.finishRegistrationWithBankCredentialsAndContract(dbCustomerData);

        hvbStepCollection.getHvbOverallNeedAnalysisIntroSteps().click_ona_go_next_button();
        hvbStepCollection.fillingOna(dbCustomerData.getChildren());
        hvbStepCollection.getHvbOverallNeedAnalysisSummarySteps().verify_ona_save_summary_and_completed_pages();

    }

    @Test
    public void overallNeedAnalysisQuestionnaireAfterSkippingONA() throws InterruptedException {

        DBCustomerData dbCustomerData = HvbDBCustomerDataUtils.createDBCustomerData();

        hvbStepCollection.finishRegistrationWithBankCredentialsAndContract(dbCustomerData);

        hvbStepCollection.getHvbOverallNeedAnalysisIntroSteps().click_remember_later_button();

        hvbStepCollection.getHvbDashboardSteps().verify_dashboard_profile_remainder_is_displayed();

        hvbStepCollection.getHvbDashboardSteps().click_dashboard_profile_remainder();

        hvbStepCollection.getHvbOverallNeedAnalysisIntroSteps().click_ona_go_next_button();

        hvbStepCollection.fillingOna(dbCustomerData.getChildren());

        hvbStepCollection.getHvbOverallNeedAnalysisSummarySteps().verify_ona_save_summary_and_completed_pages();

    }

}
