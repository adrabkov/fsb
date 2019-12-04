package de.alectogmbh.friendsurance.automation.utils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class StringHelper {

  public static String convertToUTF8(String text) {
    return new String(text.getBytes(Charset.forName("utf-8")));
  }

  public static List<String> convertToUTF8(List<String> stringsToConvert) {
    List<String> convertedList = new ArrayList<>();
    for (String s : stringsToConvert) {
      convertedList.add(convertToUTF8(s));
    }
    return convertedList;
  }

}