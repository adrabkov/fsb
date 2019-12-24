package de.alectogmbh.friendsurance.automation.tests;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.steps.hvb.hvb.*;
import lombok.Getter;
import net.thucydides.core.annotations.Steps;

@Getter
public class Clients extends AbstractScenarioSteps {

    @Steps
    private HvbBankSelectionSteps hvbBankSelectionSteps;

    @Steps
    private HvbInsuranceInformationSteps hvbInsuranceInformationSteps;

    @Steps
    private HvbTermsConditionsSteps hvbTermsConditionsSteps;

    @Steps
    private HvbFinApiWebFormSteps hvbFinApiWebFormSteps;

    @Steps
    private HvbPersonalDetailsSteps hvbPersonalDetailsSteps;

    @Steps
    private HvbSignUpSteps hvbSignUpSteps;

    @Steps
    private HvbOrderOverviewSteps hvbOrderOverviewSteps;

    @Steps
    private HvbLandingSteps hvbLandingSteps;

    @Steps
    private HvbEmailLoginSteps hvbEmailLoginSteps;

    @Steps
    private HvbDashboardSteps hvbDashboardSteps;

    @Steps
    private HvbEditOrderSteps hvbEditOrderSteps;

    @Steps
    private HvbAddContractSteps hvbAddContractSteps;

    @Steps
    private HvbSignOrderSteps hvbSignOrderSteps;

    @Steps
    private HvbOverallNeedAnalysisIntroSteps hvbOverallNeedAnalysisIntroSteps;

    protected AbstractPageObject getPageObject() {
        return null;
    }
}
