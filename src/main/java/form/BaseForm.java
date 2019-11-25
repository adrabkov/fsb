package form;

import driver.DriverHolder;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseForm {
    protected static org.apache.logging.log4j.Logger log = LogManager.getLogger();

    public BaseForm() {
        PageFactory.initElements(DriverHolder.getInstance(), this);
    }
}
