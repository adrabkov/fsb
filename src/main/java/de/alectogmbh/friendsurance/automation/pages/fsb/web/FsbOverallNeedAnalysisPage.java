package de.alectogmbh.friendsurance.automation.pages.fsb.web;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static de.alectogmbh.friendsurance.automation.pages.fsb.web.FsbOverallNeedAnalysisPage.ONA_QUESTIONNAIRE_PAGE_URL;
import static de.alectogmbh.friendsurance.automation.utils.SeleniumWaitUtils.waitForAnimationToFinish;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@At("#HOST" + ONA_QUESTIONNAIRE_PAGE_URL)
@DefaultUrl(ONA_QUESTIONNAIRE_PAGE_URL)
public class FsbOverallNeedAnalysisPage extends BaseForm {

    final static String ONA_QUESTIONNAIRE_PAGE_URL = "/overallneedanalysis/";

    @FindBy (id = "ONA_MARITAL_STATUS_SINGLE__label")
    private WebElement onaMaritalStatusSingleOption;

    @FindBy(id = "dashboard-questionnaire-step-next-save__button")
    private WebElement onaSaveFamilyStatusAndGoToNextStep;

    @FindBy(id = "ONA_DEPENDENT_CHILDREN")
    private WebElement numberOfChildrenDropdown;

    @FindBy(id = "dashboard-questionnaire-step-next-save__button")
    private WebElement onaSaveChildrenStatusAndGoToNextStep;

    @FindBy(id = "ONA_CURRENT_JOB_EMPLOYED__label")
    private WebElement onaProfessionStatus;

    @FindBy(id = "dashboard-questionnaire-step-next-save__button")
    private WebElement onaSaveProfessionStatusAndGoToNextStep;

    @FindBy(id = "ONA_INSURED_LEGALLY__label")
    private WebElement publicInsurance;

    @FindBy(id = "dashboard-questionnaire-step-next-save__button")
    private WebElement onaSaveInsuranceStatusAndGoToNextStep;

    @FindBy(id = "ONA_PRIVATE_CAR_YES__span")
    private WebElement livingConditionCar;

    @FindBy(id = "ONA_OWNER_OCCUPIED_HOME__span")
    private WebElement livingConditionOwnHouse;

    @FindBy(id = "dashboard-questionnaire-step-next-save__button")
    private WebElement onaSaveLivingConditionStatusAndGoToSummary;

    private static final int TIME_IN_SECONDS = 5;

    public void selectMaritalStatusSingleOption() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, onaMaritalStatusSingleOption);
        scrollToElement(onaMaritalStatusSingleOption);
//        onaMaritalStatusSingleOption.waitUntilClickable();
        onaMaritalStatusSingleOption.click();
    }

    public void clickOnaSaveFamilyStatusAndGoNextButton() {
//        onaSaveFamilyStatusAndGoToNextStep.waitUntilClickable();
        onaSaveFamilyStatusAndGoToNextStep.click();
    }

    public void selectNumberOfChildrenByText(String selectNumberOfChildren) {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, numberOfChildrenDropdown);
//        numberOfChildrenDropdown.waitUntilPresent();
//        numberOfChildrenDropdown.waitUntilClickable();
        numberOfChildrenDropdown.sendKeys(selectNumberOfChildren);
    }

    public void clickOnaSaveChildrenStatusAndGoNextButton() {
        scroll_element_into_view(onaSaveChildrenStatusAndGoToNextStep);
//        onaSaveChildrenStatusAndGoToNextStep.waitUntilClickable();
        onaSaveChildrenStatusAndGoToNextStep.click();
    }

    public void selectProfessionStatus() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, onaProfessionStatus);
        scrollToElement(onaProfessionStatus);
//        onaProfessionStatus.waitUntilClickable();
        onaProfessionStatus.click();
    }

    public void clickOnaSaveProfessionStatusAndGoNextButton() {
        scroll_element_into_view(onaSaveProfessionStatusAndGoToNextStep);
//        onaSaveProfessionStatusAndGoToNextStep.waitUntilClickable();
        onaSaveProfessionStatusAndGoToNextStep.click();
    }

    public void selectInsuranceType() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, publicInsurance);
        scrollToElement(publicInsurance);
//        publicInsurance.waitUntilClickable();
        publicInsurance.click();
    }

    public void clickOnaSaveInsuranceTypeAndGoNextButton() {
        scroll_element_into_view(onaSaveInsuranceStatusAndGoToNextStep);
//        onaSaveInsuranceStatusAndGoToNextStep.waitUntilClickable();
        onaSaveInsuranceStatusAndGoToNextStep.click();
    }

    public void selectLivingConditionCarCheckbox() {
        waitForAnimationToFinish(getDriver(), TIME_IN_SECONDS, livingConditionCar);
//        livingConditionCar.waitUntilClickable();
        livingConditionCar.click();
    }

    public void selectLivingConditionHouseCheckbox() {
//        livingConditionOwnHouse.waitUntilClickable();
        livingConditionOwnHouse.click();
    }

    public void clickOnaSaveLivingConditionsAndGoToSummaryButton() {
        scroll_element_into_view(onaSaveLivingConditionStatusAndGoToSummary);
//        onaSaveLivingConditionStatusAndGoToSummary.waitUntilClickable();
        onaSaveLivingConditionStatusAndGoToSummary.click();
    }




}
