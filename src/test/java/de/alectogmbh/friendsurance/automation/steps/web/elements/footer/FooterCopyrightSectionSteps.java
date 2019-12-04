package de.alectogmbh.friendsurance.automation.steps.web.elements.footer;

import de.alectogmbh.friendsurance.automation.pages.web.elements.footer.FooterCopyrightSection;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FooterCopyrightSectionSteps extends AbstractScenarioSteps<FooterCopyrightSection> {

  private String copyrightText;

  private FooterCopyrightSection footerCopyrightSection;

  public FooterCopyrightSectionSteps() {
  }

  public FooterCopyrightSectionSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void copyright_text_is_present() {
    assertThat(
        "Copyright text is not present", getPageObject().isCopyrightTextPresent(), is(true)
    );
  }

  @Step
  public void copyright_text_is_correct() {
    assertThat(
        "Copyright text is not correct", getPageObject().getCopyrightText(),
        is(equalTo(String.format("© 2011-%s Friendsurance", Calendar.getInstance().get(Calendar.YEAR))))
    );
  }

  @Override
  protected FooterCopyrightSection getPageObject() {
    return footerCopyrightSection;
  }

}
