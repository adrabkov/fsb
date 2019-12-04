package de.alectogmbh.friendsurance.automation.steps.web.elements.footer;

import de.alectogmbh.friendsurance.automation.pages.web.elements.footer.FooterTariffsSection;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.electronics.*;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.household.HouseholdInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.kfz.CarInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.legal.LegalInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.pages.web.insurance.category.liability.LiabilityInsuranceCategoryPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FooterTariffsSectionSteps extends AbstractScenarioSteps<FooterTariffsSection> {

  private String headlineText;
  private String mobileInsuranceLinkText;
  private String iPhoneInsuranceLinkText;
  private String ipadInsuranceLinkText;
  private String tabletInsuranceLinkText;
  private String laptopInsuranceLinkText;
  private String householdInsuranceLinkText;
  private String liabilityInsuranceLinkText;
  private String legalInsuranceLinkText;
  private String carInsuranceLinkText;

  private FooterTariffsSection footerTariffsSection;

  public FooterTariffsSectionSteps() {
  }

  public FooterTariffsSectionSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void headline_is_present() {
    assertThat(
        "Headline is not present", getPageObject().isHeadlineTextPresent(), is(true)
    );
  }

  @Step
  public void headline_text_is_correct() {
    assertThat(
        "Headline text is not correct", getPageObject().getHeadlineText(), is(equalTo(headlineText))
    );
  }

  @Step
  public void mobile_phone_insurance_link_is_present() {
    assertThat(
        "Mobile phone insurance link is not present",
        getPageObject().isMobilePhoneInsuranceLinkPresent(),
        is(true)
    );
  }

  @Step
  public void mobile_phone_insurance_link_is_correct() {
    assertThat(
        "Mobile phone insurance link is not correct",
        getPageObject().getMobilePhoneInsuranceLinkHref().endsWith(
            MobilePhoneInsuranceCategoryPage.DEFAULT_URL
        ), is(true)
    );
  }

  @Step
  public void mobile_phone_insurance_link_text_is_correct() {
    assertThat(
        "Mobile phone insurance link text is not correct",
        getPageObject().getMobilePhoneInsuranceLinkText(),
        is(equalTo(mobileInsuranceLinkText))
    );
  }

  @Step
  public void iphone_insurance_link_is_present() {
    assertThat(
        "IPhone insurance link is not present", getPageObject().isIPhoneInsuranceLinkPresent(),
        is(true)
    );
  }

  @Step
  public void iphone_insurance_link_is_correct() {
    assertThat(
        "Iphone insurance link is not correct",
        getPageObject().getIphoneInsuranceLinkHref()
            .endsWith(IphoneInsuranceCategoryPage.DEFAULT_URL), is(true)
    );
  }

  @Step
  public void iphone_insurance_link_text_is_correct() {
    assertThat(
        "Iphone insurance link text is not correct", getPageObject().getIphoneInsuranceLinkText(),
        is(
            equalTo(iPhoneInsuranceLinkText)
        )
    );
  }

  @Step
  public void ipad_insurance_link_is_present() {
    assertThat("IPad insurance link is not present", getPageObject().isIPadInsuranceLinkPresent(),
        is(true));
  }

  @Step
  public void ipad_insurance_link_is_correct() {
    assertThat(
        "Ipad insurance link is not correct",
        getPageObject().getIpadInsuranceLinkHref().endsWith(IpadInsuranceCategoryPage.DEFAULT_URL),
        is(true)
    );
  }

  @Step
  public void ipad_insurance_link_text_is_correct() {
    assertThat(
        "Ipad insurance link is not correct", getPageObject().getIpadInsuranceLinkText(),
        is(equalTo(ipadInsuranceLinkText))
    );
  }

  @Step
  public void tablet_insurance_link_is_present() {
    assertThat(
        "Tablet insurance link is not present", getPageObject().isTabletInsuranceLinkPresent(),
        is(true)
    );
  }

  @Step
  public void tablet_insurance_link_is_correct() {
    assertThat(
        "Tablet insurance link is not correct",
        getPageObject().getTabletInsuranceLinkHref()
            .endsWith(TabletInsuranceCategoryPage.DEFAULT_URL), is(true)
    );
  }

  @Step
  public void tablet_insurance_link_text_is_correct() {
    assertThat(
        "Tablet insurance link text is not correct", getPageObject().getTabletInsuranceLinkText(),
        is(equalTo(tabletInsuranceLinkText))
    );
  }

  @Step
  public void laptop_insurance_link_is_present() {
    assertThat(
        "Laptop insurance link is not present", getPageObject().isLaptopInsuranceLinkPresent(),
        is(true)
    );
  }

  @Step
  public void laptop_insurance_link_is_correct() {
    assertThat(
        "Laptop insurance link is not correct",
        getPageObject().getLaptopInsuranceLinkHref()
            .endsWith(LaptopInsuranceCategoryPage.DEFAULT_URL), is(true)
    );
  }

  @Step
  public void laptop_insurance_link_text_is_correct() {
    assertThat(
        "Laptop insurance link text is not correct", getPageObject().getLaptopInsuranceLinkText(),
        is(equalTo(laptopInsuranceLinkText))
    );
  }

  @Step
  public void household_insurance_link_is_present() {
    assertThat(
        "Household insurance link is not present",
        getPageObject().isHouseholdInsuranceLinkPresent(), is(true)
    );
  }

  @Step
  public void household_insurance_link_is_correct() {
    assertThat(
        "Household insurance link is not correct",
        getPageObject().getHouseholdInsuranceLinkHref()
            .endsWith(HouseholdInsuranceCategoryPage.DEFAULT_URL),
        is(true)
    );
  }

  @Step
  public void household_insurance_link_text_is_correct() {
    assertThat(
        "Household insurance link text is not correct",
        getPageObject().getHouseholdInsuranceLinkText(),
        is(equalTo(householdInsuranceLinkText))
    );
  }

  @Step
  public void liability_insurance_link_is_present() {
    assertThat(
        "Liability insurance link is not present",
        getPageObject().isLiabilityInsuranceLinkPresent(), is(true)
    );
  }

  @Step
  public void liability_insurance_link_is_correct() {
    assertThat(
        "Liability insurance link is not correct",
        getPageObject().getLiabilityInsuranceLinkHref()
            .endsWith(LiabilityInsuranceCategoryPage.DEFAULT_URL),
        is(true)
    );
  }

  @Step
  public void liability_insurance_link_text_is_correct() {
    assertThat(
        "Liability insurance link text is not correct",
        getPageObject().getLiabilityInsuranceLinkText(),
        is(equalTo(liabilityInsuranceLinkText))
    );
  }

  @Step
  public void legal_insurance_link_is_present() {
    assertThat("Legal insurance link is not present", getPageObject().isLegalInsuranceLinkPresent(),
        is(true));
  }


  @Step
  public void legal_insurance_link_is_correct() {
    assertThat(
        "Legal insurance link is not correct",
        getPageObject().getLegalInsuranceLinkHref()
            .endsWith(LegalInsuranceCategoryPage.DEFAULT_URL), is(true)
    );
  }

  @Step
  public void legal_insurance_link_text_is_correct() {
    assertThat(
        "Legal insurance link text is not correct", getPageObject().getLegalInsuranceLinkText(),
        is(equalTo(legalInsuranceLinkText))
    );
  }

  @Step
  public void car_insurance_link_is_present() {
    assertThat("Car insurance link is not present", getPageObject().isCarInsuranceLinkPresent(),
        is(true));
  }

  @Step
  public void car_insurance_link_is_correct() {
    assertThat(
        "Car insurance link is not correct",
        getPageObject().getCarInsuranceLinkHref().endsWith(CarInsuranceCategoryPage.DEFAULT_URL),
        is(true)
    );
  }

  @Step
  public void car_insurance_link_text_is_correct() {
    assertThat(
        "Car insurance link text is not correct", getPageObject().getCarInsuranceLinkText(),
        is(equalTo(carInsuranceLinkText))
    );
  }

  @StepGroup
  public void footer_tariffs_section_elements_are_present() {
    headline_is_present();
    mobile_phone_insurance_link_is_present();
    iphone_insurance_link_is_present();
    ipad_insurance_link_is_present();
    tablet_insurance_link_is_present();
    laptop_insurance_link_is_present();
    household_insurance_link_is_present();
    liability_insurance_link_is_present();
    legal_insurance_link_is_present();
    car_insurance_link_is_present();
  }

  @StepGroup
  public void footer_tariffs_section_links_are_correct() {
    mobile_phone_insurance_link_is_correct();
    iphone_insurance_link_is_correct();
    ipad_insurance_link_is_correct();
    tablet_insurance_link_is_correct();
    laptop_insurance_link_is_correct();
    household_insurance_link_is_correct();
    liability_insurance_link_is_correct();
    legal_insurance_link_is_correct();
    car_insurance_link_is_correct();
  }

  @StepGroup
  public void footer_tariffs_section_element_texts_are_correct() {
    headline_text_is_correct();
    mobile_phone_insurance_link_text_is_correct();
    iphone_insurance_link_text_is_correct();
    ipad_insurance_link_text_is_correct();
    tablet_insurance_link_text_is_correct();
    laptop_insurance_link_text_is_correct();
    household_insurance_link_text_is_correct();
    liability_insurance_link_text_is_correct();
    legal_insurance_link_text_is_correct();
    car_insurance_link_text_is_correct();
  }

  @Override
  protected FooterTariffsSection getPageObject() {
    return footerTariffsSection;
  }

}