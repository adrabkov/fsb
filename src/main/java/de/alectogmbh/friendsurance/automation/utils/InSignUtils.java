package de.alectogmbh.friendsurance.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InSignUtils {

    public static void signWithDummySignature(WebDriver driver, WebElement signatureCanvas,
                                              int iterationCount) {

        final int X1 = 100;
        final int Y1 = 100;
        final int X2 = 400;
        final int OFFSET = 10;
        final int Y2 = 200;

        Actions actions = new Actions(driver);
        for (int i = 0; i < iterationCount; i++) {
            actions.moveToElement(signatureCanvas, X1, Y1).clickAndHold()
                    .moveByOffset(X2 + (i * OFFSET), Y1 + (i * OFFSET))
                    .release(signatureCanvas).moveToElement(signatureCanvas, X2, Y1).clickAndHold()
                    .moveByOffset(X2 + (i * OFFSET), Y2 + (i * OFFSET)).release(signatureCanvas).perform();
        }
    }
}
