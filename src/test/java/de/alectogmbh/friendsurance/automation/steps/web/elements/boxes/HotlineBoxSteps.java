package de.alectogmbh.friendsurance.automation.steps.web.elements.boxes;

import de.alectogmbh.friendsurance.automation.pages.web.elements.boxes.HotlineBox;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HotlineBoxSteps extends AbstractScenarioSteps<HotlineBox> {

  private String headlineText;
  private String hotlineNumberText;
  private String availabilityHoursText;

  private HotlineBox hotlineBox;

  public HotlineBoxSteps() {
  }

  public HotlineBoxSteps(Pages pages) {
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
  public void hotline_number_is_present() {
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
  public void availability_hours_is_present() {
    assertThat(
        "Availability hours is not present", getPageObject().isAvailabilityHoursTextPresent(),
        is(true)
    );
  }

  @Step
  public void availability_hours_text_is_correct() {
    assertThat(
        "Availability hours text is not correct", getPageObject().getAvailabilityHoursText(),
        is(equalTo(availabilityHoursText))
    );
  }

  @StepGroup
  public void hotline_box_elements_are_present() {
    headline_is_present();
    hotline_number_is_present();
    availability_hours_is_present();
  }

  @StepGroup
  public void hotline_box_element_texts_are_correct() {
    headline_text_is_correct();
    hotline_number_text_is_correct();
    availability_hours_text_is_correct();
  }

  @Override
  protected HotlineBox getPageObject() {
    return hotlineBox;
  }

}
