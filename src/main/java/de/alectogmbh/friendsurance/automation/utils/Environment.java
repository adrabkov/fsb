package de.alectogmbh.friendsurance.automation.utils;

public enum Environment {
  UNDEFINED("undefined"),
  TEST1("test1"),
  TEST2("test2"),
  TEST3("test3"),
  TEST4("test4"),
  TEST5("test5"),
  TEST6("test6"),
  DB1("db-de-test"),
  DB2("db-de-test2"),
  DB3("db-de-test3"),
  DB4("db-de-test4"),
  DB5("db-de-test5"),
  RUV1("ruv-de-test1"),
  RUV2("ruv-de-test2"),
  RUV3("ruv-de-test3"),
  RUV4("ruv-de-test4"),
  RUV5("ruv-de-test5"),
  RUVEXT("ruv-de-test-ext");

  private final String envName;

  Environment(String envName) {
      this.envName = envName;
  }

  public static Environment fromSystemEnv() {
    final String serverName = System.getProperty("serverName");

    for(Environment environment: Environment.values()) {
      if(environment.envName.equals(serverName))
        return environment;
    }

    return UNDEFINED;

  }

}