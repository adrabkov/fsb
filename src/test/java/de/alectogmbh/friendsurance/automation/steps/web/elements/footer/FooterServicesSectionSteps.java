package de.alectogmbh.friendsurance.automation.steps.web.elements.footer;

import de.alectogmbh.friendsurance.automation.pages.web.elements.footer.FooterServicesSection;
import de.alectogmbh.friendsurance.automation.pages.web.services.ReportDamagePage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FooterServicesSectionSteps extends AbstractScenarioSteps<FooterServicesSection> {

  private String headlineText;
  private String reportDamageLinkText;

  private FooterServicesSection footerServicesSection;

  public FooterServicesSectionSteps() {
  }

  public FooterServicesSectionSteps(Pages pages) {
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
  public void report_damage_link_is_present() {
    assertThat(
        "Report damage link is not present", getPageObject().isReportDamageLinkPresent(), is(true)
    );
  }

  @Step
  public void report_damage_link_is_correct() {
    assertThat(
        "Report damage link is not correct",
        getPageObject().getReportDamageLinkHref().endsWith(ReportDamagePage.DEFAULT_URL), is(true)
    );
  }

  @Step
  public void report_damage_link_text_is_correct() {
    assertThat(
        "Report damage link text is not correct", getPageObject().getReportDamageLinkText(),
        is(equalTo(reportDamageLinkText))
    );
  }

  @StepGroup
  public void footer_services_section_elements_are_present() {
    headline_is_present();
    report_damage_link_is_present();
  }

  @StepGroup
  public void footer_services_section_links_are_correct() {
    report_damage_link_is_correct();
  }

  @StepGroup
  public void footer_services_section_element_texts_are_correct() {
    headline_text_is_correct();
    report_damage_link_text_is_correct();
  }

  @Override
  protected FooterServicesSection getPageObject() {
    return footerServicesSection;
  }

}
