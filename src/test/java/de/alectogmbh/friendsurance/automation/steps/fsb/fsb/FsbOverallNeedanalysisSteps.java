package de.alectogmbh.friendsurance.automation.steps.fsb.fsb;

import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbOverallNeedAnalysisIntroPage;
import de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbOverallNeedAnalysisPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class FsbOverallNeedanalysisSteps extends AbstractScenarioSteps<FsbOverallNeedAnalysisPage> {

    private static final String CHILDREN = "2";

    private FsbOverallNeedAnalysisPage fsbOverallNeedAnalysisPage;

    protected FsbOverallNeedAnalysisPage getPageObject() {
        return fsbOverallNeedAnalysisPage;
    }

    @Step
    public void select_marital_status_single_option() {
        getPageObject().selectMaritalStatusSingleOption();
    }

    @Step
    public void click_ona_save_family_status_and_go_next_button() {
        getPageObject().clickOnaSaveFamilyStatusAndGoNextButton();
    }

    @Step
    public void select_number_of_children_by_text(String CHILDREN) {
        getPageObject().selectNumberOfChildrenByText(CHILDREN);
    }

    @Step
    public void click_ona_save_children_status_and_go_next_button() {
        getPageObject().clickOnaSaveChildrenStatusAndGoNextButton();
    }

    @Step
    public void select_profession_status() {
        getPageObject().selectProfessionStatus();
    }

    @Step
    public void click_ona_save_profession_status_and_go_next_button() {
        getPageObject().clickOnaSaveProfessionStatusAndGoNextButton();
    }

    @Step
    public void select_insurance_type() {
        getPageObject().selectInsuranceType();
    }

    @Step
    public void click_ona_save_insurance_type_and_go_next_button() {
        getPageObject().clickOnaSaveInsuranceTypeAndGoNextButton();
    }

    @Step
    public void select_living_condition_car_checkbox() {
        getPageObject().selectLivingConditionCarCheckbox();
    }

    @Step
    public void select_living_condition_house_checkbox() {
        getPageObject().selectLivingConditionHouseCheckbox();
    }

    @Step
    public void click_ona_save_living_conditions_and_go_to_summary_button() {
        getPageObject().clickOnaSaveLivingConditionsAndGoToSummaryButton();
    }

    @StepGroup
    public void complete_ona_questionnaire() {
        select_marital_status_single_option();
        click_ona_save_family_status_and_go_next_button();
        select_number_of_children_by_text(CHILDREN);
        click_ona_save_children_status_and_go_next_button();
        select_profession_status();
        click_ona_save_profession_status_and_go_next_button();
        select_insurance_type();
        click_ona_save_insurance_type_and_go_next_button();
        select_living_condition_car_checkbox();
        select_living_condition_house_checkbox();
        click_ona_save_living_conditions_and_go_to_summary_button();
    }


}
