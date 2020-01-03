package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import org.junit.Test;

public class HvbOverallNeedAnalysisTest extends AbstractScenarioTest {

    @Test
    public void overallNeedAnalysisQuestionnaireAfterCreatingUser() throws InterruptedException {

        clients.finishRegistrationWithBankCredentialsAndContract(dbCustomerData, messages);

        clients.getHvbOverallNeedAnalysisIntroSteps().click_ona_go_next_button();
        clients.fillingOna(dbCustomerData.getChildren());
        clients.getHvbOverallNeedAnalysisSummarySteps().verify_ona_save_summary_and_completed_pages();

    }

    @Test
    public void overallNeedAnalysisQuestionnaireAfterSkippingONA() throws InterruptedException {

        clients.finishRegistrationWithBankCredentialsAndContract(dbCustomerData, messages);

        clients.getHvbOverallNeedAnalysisIntroSteps().click_remember_later_button();

        clients.getHvbDashboardSteps().verify_dashboard_profile_remainder_is_displayed();

        clients.getHvbDashboardSteps().click_dashboard_profile_remainder();

        clients.getHvbOverallNeedAnalysisIntroSteps().click_ona_go_next_button();

        clients.fillingOna(dbCustomerData.getChildren());

        clients.getHvbOverallNeedAnalysisSummarySteps().verify_ona_save_summary_and_completed_pages();

    }

    protected AbstractScenarioSteps getSteps() {
        return null;
    }
}
