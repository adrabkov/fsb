package de.alectogmbh.friendsurance.rules;

import static de.alectogmbh.friendsurance.rules.Environment.ALL;

import org.junit.Assume;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import java.util.Arrays;

public class EnvironmentExecutionRule implements MethodRule {

  private static final String PROPERTY_ENVIRONMENT = "serverName";

  @Override
  public Statement apply(Statement statement, FrameworkMethod method, Object target) {
    EnvironmentExecution annotation = method.getAnnotation(EnvironmentExecution.class);
    return annotation == null || shouldExecute(annotation) ? statement : getIgnoreStatement(annotation);
  }

  private Statement getIgnoreStatement(EnvironmentExecution annotation) {
    final String message = String.format("Ignored by %s. Include: %s. Exclude: %s. Environment: %s.",
        EnvironmentExecutionRule.class.getSimpleName(), Arrays.toString(annotation.include()), Arrays.toString(annotation.exclude()),
        System.getProperty(PROPERTY_ENVIRONMENT));
    return new Statement() {
      @Override
      public void evaluate() {
        Assume.assumeTrue(message, false);
      }
    };
  }

  private boolean shouldExecute(EnvironmentExecution annotation) {
    String environment = System.getProperty(PROPERTY_ENVIRONMENT);
    boolean includeAll = Arrays.asList(annotation.include()).contains(ALL);
    boolean excludeAll = Arrays.asList(annotation.exclude()).contains(ALL);
    if (includeAll && excludeAll) {
      return false;
    }
    if (includeAll) {
      return !contains(environment, annotation.exclude());
    }
    if (excludeAll) {
      return contains(environment, annotation.include());
    }
    return contains(environment, annotation.include()) && !contains(environment, annotation.exclude());
  }

  private boolean contains(String value, Environment[] environments) {
    for (Environment environment : environments) {
      if (value != null && value.toLowerCase().contains(environment.name().toLowerCase())) {
        return true;
      }
    }
    return false;
  }

}
