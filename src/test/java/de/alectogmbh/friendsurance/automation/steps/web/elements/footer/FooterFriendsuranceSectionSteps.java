package de.alectogmbh.friendsurance.automation.steps.web.elements.footer;

import de.alectogmbh.friendsurance.automation.pages.web.elements.footer.FooterFriendsuranceSection;
import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.*;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FooterFriendsuranceSectionSteps
    extends AbstractScenarioSteps<FooterFriendsuranceSection> {

  private String headlineText;
  private String schaboLinkText;
  private String howItWorksLinkText;
  private String aboutUsLinkText;
  private String faqLinkText;
  private String blogLinkText;
  private String contactLinkText;
  private String pressLinkText;
  private String jobsLinkText;

  private FooterFriendsuranceSection footerFriendsuranceSection;

  public FooterFriendsuranceSectionSteps() {
  }

  public FooterFriendsuranceSectionSteps(Pages pages) {
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
  public void schabo_link_is_present() {
    assertThat(
        "Schabo link is not present", getPageObject().isSchaboLinkPresent(), is(true)
    );
  }

  @Step
  public void schabo_link_is_correct() {
    assertThat(
        "Schabo link is not correct",
        getPageObject().getSchaboLinkHref().endsWith(SchaboPage.DEFAULT_URL), is(true)
    );
  }

  @Step
  public void schabo_link_text_is_correct() {
    assertThat(
        "Schabo link text is not correct", getPageObject().getSchaboLinkText(),
        is(equalTo(schaboLinkText))
    );
  }

  @Step
  public void how_it_works_link_is_present() {
    assertThat(
        "How it works link is not present", getPageObject().isHowItWorksLinkPresent(), is(true)
    );
  }

  @Step
  public void how_it_works_link_is_correct() {
    assertThat(
        "How it works link is not correct",
        getPageObject().getHowItWorksLinkHref().endsWith(HowItWorksPage.DEFAULT_URL), is(true)
    );
  }

  @Step
  public void how_it_works_link_text_is_correct() {
    assertThat(
        "How it works link text is not correct", getPageObject().getHowItWorksLinkText(),
        is(equalTo(howItWorksLinkText))
    );
  }

  @Step
  public void about_us_link_is_present() {
    assertThat(
        "About us link is not present", getPageObject().isAboutUsLinkPresent(), is(true)
    );
  }

  @Step
  public void about_us_link_is_correct() {
    assertThat(
        "About us link is not correct",
        getPageObject().getAboutUsLinkHref().endsWith(AboutUsPage.DEFAULT_URL),
        is(true)
    );
  }

  @Step
  public void about_us_link_text_is_correct() {
    assertThat(
        "About us link text is not correct", getPageObject().getAboutUsLinkText(), is(
            equalTo(aboutUsLinkText)
        )
    );
  }

  @Step
  public void faq_link_is_present() {
    assertThat(
        "Faq link is not present", getPageObject().isFaqLinkPresent(), is(true)
    );
  }

  @Step
  public void faq_link_is_correct() {
    assertThat(
        "Faq link is not correct", getPageObject().getFaqLinkHref().endsWith(FaqPage.DEFAULT_URL),
        is(true)
    );
  }

  @Step
  public void faq_link_text_is_correct() {
    assertThat(
        "Faq link text is not correct", getPageObject().getFaqLinkText(), is(equalTo(faqLinkText))
    );
  }

  @Step
  public void blog_link_is_present() {
    assertThat(
        "Blog link is not present", getPageObject().isBlogLinkPresent(), is(true)
    );
  }

  @Step
  public void blog_link_is_correct() {
    assertThat(
        "Blog link is not correct",
        getPageObject().getBlogLinkHref().endsWith(BlogPage.DEFAULT_URL), is(true)
    );
  }

  @Step
  public void blog_link_text_is_correct() {
    assertThat(
        "Blog link text is not correct", getPageObject().getBlogLinkText(),
        is(equalTo(blogLinkText))
    );
  }

  @Step
  public void contact_link_is_present() {
    assertThat(
        "Contact insurance link is not present", getPageObject().isContactLinkPresent(), is(true)
    );
  }

  @Step
  public void contact_link_is_correct() {
    assertThat(
        "Contact link is not correct",
        getPageObject().getContactLinkHref().endsWith(ContactPage.DEFAULT_URL),
        is(true)
    );
  }

  @Step
  public void contact_link_text_is_correct() {
    assertThat(
        "Contact link text is not correct", getPageObject().getContactLinkText(),
        is(equalTo(contactLinkText))
    );
  }

  @Step
  public void press_link_is_present() {
    assertThat(
        "Press link is not present", getPageObject().isPressLinkPresent(), is(true)
    );
  }

  @Step
  public void press_link_is_correct() {
    assertThat(
        "Press link is not correct", getPageObject().getPressLinkHref().endsWith("/presse"),
        is(true)
    );
  }

  @Step
  public void press_link_text_is_correct() {
    assertThat(
        "Press link text is not correct", getPageObject().getPressLinkText(),
        is(equalTo(pressLinkText))
    );
  }

  @Step
  public void jobs_link_is_present() {
    assertThat(
        "Jobs link is not present", getPageObject().isJobsLinkPresent(), is(true)
    );
  }

  @Step
  public void jobs_link_is_correct() {
    assertThat(
        "Jobs link is not correct",
        getPageObject().getJobsLinkHref().endsWith(JobsPage.DEFAULT_URL), is(true)
    );
  }

  @Step
  public void jobs_link_text_is_correct() {
    assertThat(
        "Jobs link text is not correct", getPageObject().getJobsLinkText(),
        is(equalTo(jobsLinkText))
    );
  }

  @StepGroup
  public void footer_friendsurance_section_elements_are_present() {
    headline_is_present();
    schabo_link_is_present();
    how_it_works_link_is_present();
    about_us_link_is_present();
    faq_link_is_present();
    blog_link_is_present();
    contact_link_is_present();
    press_link_is_present();
    jobs_link_is_present();
  }

  @StepGroup
  public void footer_friendsurance_section_links_are_correct() {
    how_it_works_link_is_correct();
    schabo_link_is_correct();
    about_us_link_is_correct();
    faq_link_is_correct();
    blog_link_is_correct();
    contact_link_is_correct();
    press_link_is_correct();
    jobs_link_is_correct();
  }

  @StepGroup
  public void footer_friendsurance_section_element_texts_are_correct() {
    headline_text_is_correct();
    schabo_link_text_is_correct();
    how_it_works_link_text_is_correct();
    about_us_link_text_is_correct();
    faq_link_text_is_correct();
    blog_link_text_is_correct();
    contact_link_text_is_correct();
    press_link_text_is_correct();
    jobs_link_text_is_correct();
  }

  @Override
  protected FooterFriendsuranceSection getPageObject() {
    return footerFriendsuranceSection;
  }

}
