package de.alectogmbh.friendsurance.automation.steps.web.elements.boxes;

import de.alectogmbh.friendsurance.automation.pages.web.elements.boxes.UpgradeBookletBox;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UpgradeBookletBoxSteps extends AbstractScenarioSteps<UpgradeBookletBox> {

  private static final String
      UPGRADE_BROCHURE_LINK_URL =
      "https://www.friendsurance.de/documents/Informations-Broschuere-Schadensfrei-Bonus_20151029.pdf";

  private String downloadBookletLinkText;

  private UpgradeBookletBox upgradeBookletBox;

  public UpgradeBookletBoxSteps() {
  }

  public UpgradeBookletBoxSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void download_booklet_link_is_correct() {
    assertThat(
        "Download booklet link is not correct", getPageObject().getDownloadPdfLinkHref(),
        is(equalTo(UPGRADE_BROCHURE_LINK_URL))
    );
  }

  @Step
  public void download_booklet_link_text_is_correct() {
    assertThat(
        "Download booklet link text is not correct", getPageObject().getDownloadPdfLinkText(),
        is(downloadBookletLinkText)
    );
  }

  @StepGroup
  public void upgrade_booklet_box_links_are_correct() {
    download_booklet_link_is_correct();
  }

  @StepGroup
  public void upgrade_booklet_box_element_texts_are_correct() {
    download_booklet_link_text_is_correct();
  }

  @Override
  protected UpgradeBookletBox getPageObject() {
    return upgradeBookletBox;
  }

}
