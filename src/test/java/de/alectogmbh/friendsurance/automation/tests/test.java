package de.alectogmbh.friendsurance.automation.tests;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import org.junit.Test;

public class test extends AbstractScenarioTest {

    @Test
    public void main(String[] args) {
        System.out.println(messages.getOrderOverviewHeadline());

    }

    protected AbstractScenarioSteps getSteps() {
        return null;
    }
}
