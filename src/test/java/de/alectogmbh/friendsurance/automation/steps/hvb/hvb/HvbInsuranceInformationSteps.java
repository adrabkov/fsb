package de.alectogmbh.friendsurance.automation.steps.hvb.hvb;

import de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbInsuranceInformationPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import static org.junit.Assert.assertEquals;

public class HvbInsuranceInformationSteps extends AbstractScenarioSteps<HvbInsuranceInformationPage> {

    private HvbInsuranceInformationPage hvbInsuranceInformationPage;

    public HvbInsuranceInformationPage getPageObject() {
        return hvbInsuranceInformationPage;
    }

    @Step
    public String get_insurance_information_headline_text() {
        return getPageObject().getInsuranceInformationHeadlineText();
    }

    @Step
    public void click_insurance_information_go_next_button() {
        getPageObject().clickInsuranceInformationGoNextButton();
    }

    @Step
    public void verify_insurance_information_page_is_loaded_and_headline_is_present(String insurance_information_headline) {
        assertEquals(insurance_information_headline, get_insurance_information_headline_text());
    }

    @StepGroup
    public void verify_second_step_insurance_information_page_and_click_on_next_button(String insurance_information_headline) {
        verify_insurance_information_page_is_loaded_and_headline_is_present(insurance_information_headline);
        click_insurance_information_go_next_button();
    }

}