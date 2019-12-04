package de.alectogmbh.friendsurance.automation.steps.web.elements.footer;

import de.alectogmbh.friendsurance.automation.pages.web.elements.footer.FooterVisitUsSection;
import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.BlogPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FooterVisitUsSectionSteps extends AbstractScenarioSteps<FooterVisitUsSection> {

  private final String FACEBOOK_LINK_URL = "https://www.facebook.com/friendsurancedeutschland";
  private final String TWITTER_LINK_URL = "https://www.twitter.com/friendsurance";
  private final String GOOGLE_PLUS_LINK_URL = "https://plus.google.com/106545411456843909057/about";

  private String headlineText;

  private FooterVisitUsSection footerVisitUsSection;

  public FooterVisitUsSectionSteps() {
  }

  public FooterVisitUsSectionSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void headline_text_is_correct() {
    assertThat(
        "Headline text is not correct", getPageObject().getHeadlineText(), is(equalTo(headlineText))
    );
  }

  @Step
  public void facebook_link_is_present() {
    assertThat(
        "Facebook link is not present", getPageObject().isFacebookLinkPresent(), is(true)
    );
  }

  @Step
  public void twitter_link_is_present() {
    assertThat(
        "Twitter link is not present", getPageObject().isTwitterLinkPresent(), is(true)
    );
  }

  @Step
  public void google_plus_link_is_present() {
    assertThat(
        "Google plus link is not present", getPageObject().isGooglePlusLinkPresent(), is(true)
    );
  }

  @Step
  public void blog_link_is_present() {
    assertThat(
        "Blog link is present", getPageObject().isBlogIconPresent(), is(true)
    );
  }

  @Step
  public void facebook_link_is_correct() {
    assertThat(
        "Facebook link is not correct [" + getPageObject().getFacebookLinkHref() + "]",
        getPageObject().getFacebookLinkHref().equals(FACEBOOK_LINK_URL), is(true)
    );
  }

  @Step
  public void twitter_link_is_correct() {
    assertThat(
        "Twitter link is not correct [" + getPageObject().getTwitterLinkHref() + "]",
        getPageObject().getTwitterLinkHref().equals(TWITTER_LINK_URL), is(true)
    );
  }

  @Step
  public void google_plus_link_is_correct() {
    assertThat(
        "Google plus link is not correct [" + getPageObject().getGooglePlusLinkHref() + "]",
        getPageObject().getGooglePlusLinkHref().equals(GOOGLE_PLUS_LINK_URL), is(true)
    );
  }

  @Step
  public void blog_link_is_correct() {
    assertThat(
        "Blog link is not correct [" + getPageObject().getBlogIconHref() + "]",
        getPageObject().getBlogIconHref().endsWith(BlogPage.DEFAULT_URL), is(true)
    );
  }

  @StepGroup
  public void footer_social_section_elements_are_present() {
    facebook_link_is_present();
    twitter_link_is_present();
    google_plus_link_is_present();
    blog_link_is_present();
  }

  @StepGroup
  public void footer_social_section_links_are_correct() {
    facebook_link_is_correct();
    twitter_link_is_correct();
    google_plus_link_is_correct();
    blog_link_is_correct();
  }

  @Override
  protected FooterVisitUsSection getPageObject() {
    return footerVisitUsSection;
  }

}
