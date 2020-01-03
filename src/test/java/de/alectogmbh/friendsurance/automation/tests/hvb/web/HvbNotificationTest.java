package de.alectogmbh.friendsurance.automation.tests.hvb.web;

import de.alectogmbh.friendsurance.automation.steps.AbstractScenarioSteps;
import de.alectogmbh.friendsurance.automation.tests.AbstractScenarioTest;
import org.junit.Test;

public class HvbNotificationTest extends AbstractScenarioTest {


    @Test
    public void testDataNotification() throws InterruptedException {

        clients.registerUserWithBankCredentials(dbCustomerData, messages);

        clients.getHvbOrderOverviewSteps().click_on_navigation_item_notifications_link();

        clients.getHvbNotificationSteps().confirm_kle_move_and_inside_notification_text_click_on_profile_link();

    }

    protected AbstractScenarioSteps getSteps() {
        return null;
    }
}
