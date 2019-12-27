package de.alectogmbh.friendsurance.automation.tests;

import de.alectogmbh.friendsurance.automation.tests.web.utils.HvbMessages;
import de.alectogmbh.friendsurance.automation.tests.web.utils.JsonParser;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerData;
import de.alectogmbh.friendsurance.automation.tests.web.utils.db.DBCustomerDataUtils;
import net.thucydides.core.annotations.Steps;

public class TestClass {

    private final static String FILE_PATH_JSON = "src/test/resources/expectedMessages.json";
    protected HvbMessages messages = new JsonParser().mapToObject(FILE_PATH_JSON, HvbMessages.class);
    protected DBCustomerData dbCustomerData = DBCustomerDataUtils.createDBCustomerData();

    @Steps
    protected Clients clients = new Clients();

}
