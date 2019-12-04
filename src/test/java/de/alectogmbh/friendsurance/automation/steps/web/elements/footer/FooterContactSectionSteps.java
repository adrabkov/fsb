package de.alectogmbh.friendsurance.automation.steps.web.elements.footer;

import de.alectogmbh.friendsurance.automation.pages.web.elements.footer.FooterContactSection;
import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.ContactPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FooterContactSectionSteps extends AbstractScenarioSteps<FooterContactSection> {

  private String headlineContactLinkText;
  private String hotlineNumberText;
  private String hotlineAvailabilityHoursText;
  private String mailToSupportLink;
  private String mailToSupportLinkText;

  private FooterContactSection footerContactSection;

  public FooterContactSectionSteps() {
  }

  public FooterContactSectionSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void headline_link_is_present() {
    assertThat(
        "Headline link is not present", getPageObject().isContactLinkPresent(), is(true)
    );
  }

  @Step
  public void headline_link_is_correct() {
    assertThat(
        "Headline link is not correct",
        getPageObject().getContactLinkHref().endsWith(ContactPage.DEFAULT_URL),
        is(true)
    );
  }

  @Step
  public void headline_link_text_is_correct() {
    assertThat(
        "Headline text is not correct", getPageObject().getContactLinkText(),
        is(equalTo(headlineContactLinkText))
    );
  }

  @Step
  public void hotline_number_text_is_present() {
    assertThat(
        "Hotline number is not present", getPageObject().isHotlineNumberTextPresent(), is(true)
    );
  }

  @Step
  public void hotline_number_text_is_correct() {
    assertThat(
        "Hotline number text is not correct", getPageObject().getHotlineNumberText(),
        is(equalTo(hotlineNumberText))
    );
  }

  @Step
  public void hotline_availability_hours_text_is_present() {
    assertThat(
        "Hotline availability hours number is not present",
        getPageObject().isHotlineAvailabilityHoursTextPresent(), is(true)
    );
  }

  @Step
  public void hotline_availability_hours_text_is_correct() {
    assertThat(
        "Availability hours text is not correct", getPageObject().getHotlineAvailabilityHoursText(),
        is(equalTo(hotlineAvailabilityHoursText))
    );
  }

  @Step
  public void mail_to_support_link_is_present() {
    assertThat(
        "Mail to support link is not present", getPageObject().isMailToSupportLinkPresent(),
        is(true)
    );
  }

  @Step
  public void mail_to_support_link_is_correct() {
    assertThat(
        "Mail to support link is not correct", getPageObject().getMailToSupportLinkHref().endsWith(
            mailToSupportLink
        ), is(true)
    );
  }

  @Step
  public void mail_to_support_link_text_is_correct() {
    assertThat(
        "Mail to support text is not correct", getPageObject().getMailToSupportLinkText(),
        is(equalTo(mailToSupportLinkText))
    );
  }

  @StepGroup
  public void footer_contact_section_elements_are_present() {
    headline_link_is_present();
    hotline_number_text_is_present();
    hotline_availability_hours_text_is_present();
    mail_to_support_link_is_present();
  }

  @StepGroup
  public void footer_contact_section_links_are_correct() {
    headline_link_is_correct();
    mail_to_support_link_is_correct();
  }

  @StepGroup
  public void footer_contact_section_element_texts_are_correct() {
    headline_link_text_is_correct();
    hotline_number_text_is_correct();
    hotline_availability_hours_text_is_correct();
    mail_to_support_link_text_is_correct();
  }

  @Override
  protected FooterContactSection getPageObject() {
    return footerContactSection;
  }

}
