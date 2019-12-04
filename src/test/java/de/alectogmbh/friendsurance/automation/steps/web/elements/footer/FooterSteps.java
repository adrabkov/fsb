package de.alectogmbh.friendsurance.automation.steps.web.elements.footer;

import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class FooterSteps extends ScenarioSteps {

  @Steps
  FooterTariffsSectionSteps footerTariffsSectionSteps;

  @Steps
  FooterFriendsuranceSectionSteps footerFriendsuranceSectionSteps;

  @Steps
  FooterServicesSectionSteps footerServicesSectionSteps;

  @Steps
  FooterTermsOfUseSectionSteps footerTermsOfUseSectionSteps;

  @Steps
  FooterVisitUsSectionSteps footerVisitUsSectionSteps;

  public FooterSteps() {
  }

  public FooterSteps(Pages pages) {
    super(pages);
  }

  @StepGroup
  public void footer_element_links_are_correct() {
    footerTariffsSectionSteps.footer_tariffs_section_links_are_correct();
    footerFriendsuranceSectionSteps.footer_friendsurance_section_links_are_correct();
    footerServicesSectionSteps.footer_services_section_links_are_correct();
    footerTermsOfUseSectionSteps.footer_gtc_section_links_are_correct();
    footerVisitUsSectionSteps.footer_social_section_links_are_correct();
  }

}
