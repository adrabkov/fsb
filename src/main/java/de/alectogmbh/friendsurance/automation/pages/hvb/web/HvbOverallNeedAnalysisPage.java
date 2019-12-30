package de.alectogmbh.friendsurance.automation.pages.hvb.web;

import de.alectogmbh.friendsurance.automation.pages.AbstractPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.ui.Select;

import static de.alectogmbh.friendsurance.automation.pages.hvb.web.HvbOverallNeedAnalysisPage.ONA_QUESTIONNAIRE_PAGE_URL;
import static de.alectogmbh.friendsurance.automation.utils.SeleniumWaitUtils.waitForAnimationToFinish;

@At("#HOST" + ONA_QUESTIONNAIRE_PAGE_URL)
@DefaultUrl(ONA_QUESTIONNAIRE_PAGE_URL)
public class HvbOverallNeedAnalysisPage extends AbstractPageObject {

    final static String ONA_QUESTIONNAIRE_PAGE_URL = "/home/profile/overallneedanalysis/";

    @FindBy(id = "ONA_MARITAL_STATUS_SINGLE__label")
    private WebElementFacade onaMaritalStatusSingleOption;

    @FindBy(id = "dashboard-questionnaire-step-next-save__button")
    private WebElementFacade onaSaveFamilyStatusAndGoToNextStep;

    @FindBy(id = "ONA_DEPENDENT_CHILDREN")
    private WebElementFacade numberOfChildrenDropdown;

    @FindBy(id = "dashboard-questionnaire-step-next-save__button")
    private WebElementFacade onaSaveChildrenStatusAndGoToNextStep;

    @FindBy(id = "ONA_CURRENT_JOB_EMPLOYED__label")
    private WebElementFacade onaProfessionStatus;

    @FindBy(id = "dashboard-questionnaire-step-next-save__button")
    private WebElementFacade onaSaveProfessionStatusAndGoToNextStep;

    @FindBy(id = "ONA_INSURED_LEGALLY__label")
    private WebElementFacade publicInsurance;

    @FindBy(id = "dashboard-questionnaire-step-next-save__button")
    private WebElementFacade onaSaveInsuranceStatusAndGoToNextStep;

    @FindBy(id = "ONA_PRIVATE_CAR_YES__span")
    private WebElementFacade livingConditionCar;

    @FindBy(id = "ONA_OWNER_OCCUPIED_HOME__span")
    private WebElementFacade livingConditionOwnHouse;

    @FindBy(id = "dashboard-questionnaire-step-next-save__button")
    private WebElementFacade onaSaveLivingConditionStatusAndGoToSummary;

    private static final int TIME_IN_SECONDS = 5;

    public void selectMaritalStatusSingleOption() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, onaMaritalStatusSingleOption);
        scrollToElement(onaMaritalStatusSingleOption);
        onaMaritalStatusSingleOption.waitUntilClickable();
        onaMaritalStatusSingleOption.click();
    }

    public void clickOnaSaveFamilyStatusAndGoNextButton() {
        onaSaveFamilyStatusAndGoToNextStep.waitUntilClickable();
        onaSaveFamilyStatusAndGoToNextStep.click();
    }

    public void selectNumberOfChildrenByText(String selectNumberOfChildren) {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, numberOfChildrenDropdown);
        numberOfChildrenDropdown.waitUntilPresent();
        numberOfChildrenDropdown.waitUntilClickable();
        numberOfChildrenDropdown.selectByVisibleText(selectNumberOfChildren);
    }

    public void clickOnaSaveChildrenStatusAndGoNextButton() {
        scroll_element_into_view(onaSaveChildrenStatusAndGoToNextStep);
        onaSaveChildrenStatusAndGoToNextStep.waitUntilClickable();
        onaSaveChildrenStatusAndGoToNextStep.click();
    }

    public void selectProfessionStatus() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, onaProfessionStatus);
        scrollToElement(onaProfessionStatus);
        onaProfessionStatus.waitUntilClickable();
        onaProfessionStatus.click();
    }

    public void clickOnaSaveProfessionStatusAndGoNextButton() {
        scroll_element_into_view(onaSaveProfessionStatusAndGoToNextStep);
        onaSaveProfessionStatusAndGoToNextStep.waitUntilClickable();
        onaSaveProfessionStatusAndGoToNextStep.click();
    }

    public void selectInsuranceType() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, publicInsurance);
        scrollToElement(publicInsurance);
        publicInsurance.waitUntilClickable();
        publicInsurance.click();
    }

    public void clickOnaSaveInsuranceTypeAndGoNextButton() {
        scroll_element_into_view(onaSaveInsuranceStatusAndGoToNextStep);
        onaSaveInsuranceStatusAndGoToNextStep.waitUntilClickable();
        onaSaveInsuranceStatusAndGoToNextStep.click();
    }

    public void selectLivingConditionCarCheckbox() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, livingConditionCar);
        livingConditionCar.waitUntilClickable();
        livingConditionCar.click();
    }

    public void selectLivingConditionHouseCheckbox() {
        livingConditionOwnHouse.waitUntilClickable();
        livingConditionOwnHouse.click();
    }

    public void clickOnaSaveLivingConditionsAndGoToSummaryButton() {
        scroll_element_into_view(onaSaveLivingConditionStatusAndGoToSummary);
        onaSaveLivingConditionStatusAndGoToSummary.waitUntilClickable();
        onaSaveLivingConditionStatusAndGoToSummary.click();
    }

}
