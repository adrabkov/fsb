package de.alectogmbh.friendsurance.automation.steps.web.elements.footer;

import de.alectogmbh.friendsurance.automation.pages.web.elements.footer.FooterTermsOfUseSection;
import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.gtc.AgbPage;
import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.gtc.ImprintPage;
import de.alectogmbh.friendsurance.automation.pages.web.friendsurance.gtc.PrivacyPolicyPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FooterTermsOfUseSectionSteps extends AbstractScenarioSteps<FooterTermsOfUseSection> {

  private String headlineText;
  private String privacyPolicyLinkText;
  private String agbLinkText;
  private String imprintLinkText;

  private FooterTermsOfUseSection footerTermsOfUseSection;

  public FooterTermsOfUseSectionSteps() {
  }

  public FooterTermsOfUseSectionSteps(Pages pages) {
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
  public void privacy_policy_link_is_present() {
    assertThat("Privacy policy link is not present", getPageObject().isPrivacyPolicyLinkPresent(),
        is(true));
  }

  @Step
  public void privacy_policy_link_is_correct() {
    assertThat(
        "Privacy policy link is not correct",
        getPageObject().getPrivacyPolicyLinkHref().endsWith(PrivacyPolicyPage.DEFAULT_URL), is(true)
    );
  }

  @Step
  public void privacy_policy_link_text_is_correct() {
    assertThat(
        "Privacy policy link text is not correct", getPageObject().getPrivacyPolicyLinkText(),
        is(equalTo(privacyPolicyLinkText))
    );
  }

  @Step
  public void agb_link_is_present() {
    assertThat("AGB link is not present", getPageObject().isAgbLinkPresent(), is(true));
  }

  @Step
  public void agb_link_is_correct() {
    assertThat(
        "Agb link is not correct", getPageObject().getAgbLinkHref().endsWith(AgbPage.DEFAULT_URL),
        is(true)
    );
  }

  @Step
  public void agb_link_text_is_correct() {
    assertThat(
        "Agb link text is not correct", getPageObject().getAgbLinkText(), is(equalTo(agbLinkText))
    );
  }

  @Step
  public void imprint_link_is_present() {
    assertThat("Imprint link is not present", getPageObject().isImprintLinkPresent(), is(true));
  }

  @Step
  public void imprint_link_is_correct() {
    assertThat(
        "Imprint link is not correct",
        getPageObject().getImprintLinkHref().endsWith(ImprintPage.DEFAULT_URL),
        is(true)
    );
  }

  @Step
  public void imprint_link_text_is_correct() {
    assertThat(
        "Imprint link text is not correct", getPageObject().getImprintLinkText(),
        is(equalTo(imprintLinkText))
    );
  }

  @StepGroup
  public void footer_gtc_section_elements_are_present() {
    headline_is_present();
    privacy_policy_link_is_present();
    agb_link_is_present();
    imprint_link_is_present();
  }

  @StepGroup
  public void footer_gtc_section_links_are_correct() {
    privacy_policy_link_is_correct();
    agb_link_is_correct();
    imprint_link_is_correct();
  }

  @StepGroup
  public void footer_gtc_section_element_texts_are_correct() {
    headline_text_is_correct();
    privacy_policy_link_text_is_correct();
    agb_link_text_is_correct();
    imprint_link_text_is_correct();
  }

  @Override
  protected FooterTermsOfUseSection getPageObject() {
    return footerTermsOfUseSection;
  }

}