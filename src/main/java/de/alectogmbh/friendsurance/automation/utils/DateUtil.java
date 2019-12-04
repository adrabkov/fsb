package de.alectogmbh.friendsurance.automation.utils;

import java.util.Calendar;

public class DateUtil {

  public static boolean isLastDayInMonth() {
    Calendar today = Calendar.getInstance();
    return today.get(Calendar.DAY_OF_MONTH) == today.getActualMaximum(Calendar.DAY_OF_MONTH);
  }
}
