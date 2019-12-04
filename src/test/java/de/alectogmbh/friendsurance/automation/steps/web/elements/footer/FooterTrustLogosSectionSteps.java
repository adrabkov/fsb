package de.alectogmbh.friendsurance.automation.steps.web.elements.footer;

import de.alectogmbh.friendsurance.automation.pages.web.elements.footer.FooterTrustLogosSection;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FooterTrustLogosSectionSteps extends AbstractScenarioSteps<FooterTrustLogosSection> {

  private FooterTrustLogosSection footerTrustLogosSection;

  public FooterTrustLogosSectionSteps() {
  }

  public FooterTrustLogosSectionSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void master_card_image_is_present() {
    assertThat("Master card image is not present", getPageObject().isMasterCardImagePresent(),
        is(true));
  }

  @Step
  public void visa_card_image_is_present() {
    assertThat("Visa card image is not present", getPageObject().isVisaCardImagePresent(),
        is(true));
  }

  @Step
  public void norton_image_is_present() {
    assertThat("Norton image is not present", getPageObject().isNortonImagePresent(), is(true));
  }

  @Step
  public void ssl_security_image_is_present() {
    assertThat("Ssl security image is not present", getPageObject().isSslSecurityImagePresent(),
        is(true));
  }

  @Override
  protected FooterTrustLogosSection getPageObject() {
    return footerTrustLogosSection;
  }

}
