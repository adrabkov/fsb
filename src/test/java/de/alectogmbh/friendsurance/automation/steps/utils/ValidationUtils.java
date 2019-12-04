package de.alectogmbh.friendsurance.automation.steps.utils;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class ValidationUtils {

  public static void checkValidationErrorMessage(String expected, String actual) {
    assertThat("Validation error message hasn't been displayed", actual, is(notNullValue()));
    assertThat("Wrong validation error message  [" + actual + "]", actual, is(expected));
  }

  public static void checkCorrectPageLoaded(String expected, String actual) {
    assertThat("Wrong Page loaded [" + actual + "]", actual, containsString(expected));
  }

  public static void checkElementIsDisplayed(String expected, Boolean actual) {
    assertThat("Element " + expected + " is not Displayed.", actual, is(true));
  }

  public static void checkElementIsNotDisplayed(String expected, Boolean actual) {
    assertThat("Element " + expected + " is Displayed.", actual, is(false));
  }

  public static void checkTextIsCorrect(String expected, String actual) {
    assertThat("The Text: " + expected + " is not matching: ", actual, equalTo(expected));
  }

  public static void checkTextLike(String expected, String actual) {
    assertThat("The Text: " + expected + " is not like: ", actual, containsString(expected));
  }

  public static void checkLinkIsCorrect(String expected, String actual) {
    assertThat("Link: " + expected + " is not Matching.", actual, containsString(expected));
  }

  public static void checkBoxIsChecked(Boolean expected, Boolean actual) {
    assertThat("Box checked: " + expected + " is expected.", actual, is(expected));
  }

}