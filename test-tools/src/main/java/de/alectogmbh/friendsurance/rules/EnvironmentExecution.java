package de.alectogmbh.friendsurance.rules;

import static de.alectogmbh.friendsurance.rules.Environment.ALL;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EnvironmentExecution {

  Environment[] include() default { ALL };

  Environment[] exclude() default {};

}
