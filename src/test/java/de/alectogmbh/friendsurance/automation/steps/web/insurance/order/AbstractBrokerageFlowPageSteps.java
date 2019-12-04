package de.alectogmbh.friendsurance.automation.steps.web.insurance.order;

import de.alectogmbh.friendsurance.automation.pages.web.insurance.order.AbstractOrderFlowPage;
import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public abstract class AbstractBrokerageFlowPageSteps<T extends AbstractOrderFlowPage>
    extends AbstractScenarioSteps<T> {

  private String headlineText;
  private String headlineSubText;
  private String step1LinkText;
  private String step2LinkText;
  private String step3LinkText;

  protected AbstractBrokerageFlowPageSteps() {
  }

  protected AbstractBrokerageFlowPageSteps(Pages pages) {
    super(pages);
  }

  @Step
  public void headline_is_present() {
    assertThat("Headline is not present", getPageObject().isHeadlineTextPresent(), is(true));
  }

  @Step
  public void headline_text_is_correct() {
    assertThat("Headline text is not correct", getPageObject().getHeadlineText(),
        is(equalTo(headlineText)));
  }

  @Step
  public void sub_headline_is_present() {
    assertThat("Sub headline is not present", getPageObject().isHeadlineSubTextPresent(), is(true));
  }

  @Step
  public void headline_sub_text_is_correct() {
    String actual = getPageObject().getHeadlineSubText().replaceAll("\n", "");
    assertThat("Headline sub text is not correct", actual, is(equalTo(headlineSubText)));
  }

  @Step
  public void step1_link_is_present() {
    assertThat("Step1 link is not present", getPageObject().isStep1LinkPresent(), is(true));
  }

  @Step
  public void step1_link_text_is_correct() {
    String actual = getPageObject().getStep1LinkText().replaceAll("\n", "");
    assertThat("Step1 link text is not correct", actual, is(equalTo(step1LinkText)));
  }

  @Step
  public void step1_link_is_correct() {
    assertThat("Step1 link is not correct", getPageObject().getStep1LinkHref().endsWith("#/"),
        is(true));
  }

  @Step
  public void step2_link_is_present() {
    assertThat("Step2 link is not present", getPageObject().isStep2LinkPresent(), is(true));
  }

  @Step
  public void step2_link_text_is_correct() {
    String actual = getPageObject().getStep2LinkText().replaceAll("\n", "");
    assertThat("Step2 link text is not correct", actual, is(equalTo(step2LinkText)));
  }

  @Step
  public void step2_link_is_correct() {
    assertThat("Step2 link is not correct",
        getPageObject().getStep2LinkHref().endsWith("#/contact"), is(true));
  }

  @Step
  public void step3_link_is_present() {
    assertThat("Step3 link is not present", getPageObject().isStep3LinkPresent(), is(true));
  }

  @Step
  public void step3_link_text_is_correct() {
    String actual = getPageObject().getStep3LinkText().replaceAll("\n", "");
    assertThat("Step3 link text is not correct", actual, is(equalTo(step3LinkText)));
  }

  @Step
  public void step3_link_is_correct() {
    assertThat("Step3 link is not correct",
        getPageObject().getStep3LinkHref().endsWith("#/checkout"), is(true));
  }

  @StepGroup
  public void texts_are_present() {
    headline_is_present();
    sub_headline_is_present();
  }

  @StepGroup
  public void texts_are_correct() {
    headline_text_is_correct();
    headline_sub_text_is_correct();
  }

  @StepGroup
  public void navigation_links_are_present() {
    step1_link_is_present();
    step2_link_is_present();
    step3_link_is_present();
  }

  @StepGroup
  public void navigation_links_are_correct() {
    step1_link_is_correct();
    step2_link_is_correct();
    step3_link_is_correct();
  }

  @StepGroup
  public void navigation_link_texts_are_correct() {
    step1_link_text_is_correct();
    step2_link_text_is_correct();
    step3_link_text_is_correct();
  }

}
