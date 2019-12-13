package de.alectogmbh.friendsurance.automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.Set;

public class SeleniumWaitUtils {

    private static final double DELTA = 0.01d;

    public static void waitForNumberOfWindowsToEqual(final int numberOfWindows, WebDriver driver,
                                                     int timeout) {
        new WebDriverWait(driver, timeout) {
        }.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                synchronized (handles) {
                    return (handles.size() == numberOfWindows);
                }
            }
        });
    }

    public static void waitForAnimationToFinish(WebDriver driver, int timeout,
                                                final WebElement element) {
        new WebDriverWait(driver, timeout) {
        }.until(new ExpectedCondition<Boolean>() {

            private Point location = new Point(0, 0);

            @Override
            public Boolean apply(WebDriver driver) {
                Point location = element.getLocation();
                synchronized (location) {
                    boolean isSteady = isWithinDelta(location.x, this.location.x) && isWithinDelta(location.y, this.location.y);
                    this.location = location;
                    return isSteady;
                }
            }
        });
    }

    public static void waitUntilAutoScrollStops(WebDriver driver, int timeout) {
        new WebDriverWait(driver, timeout) {
        }.until(new ExpectedCondition<Boolean>() {

            private double yOffset = 0d;

            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                Double currentYOffset = Double.parseDouble(executor.executeScript("return window.pageYOffset;").toString());
                synchronized (currentYOffset) {
                    boolean isSteady = isWithinDelta(currentYOffset, yOffset);
                    yOffset = currentYOffset;
                    return isSteady;
                }
            }
        });
    }

    public static void executeActionWithElementById(WebDriver webDriver, final String id, final Action action) {
        new WebDriverWait(webDriver, 10)
                .ignoring(StaleElementReferenceException.class)
                .until(new ExpectedCondition<Boolean>() {
                    @Nullable
                    @Override
                    public Boolean apply(@Nullable WebDriver webDriver) {
                        action.execute(webDriver.findElement(By.id(id)));
                        return true;
                    }
                });
    }

    private static boolean isWithinDelta(double lowerBound, double higherBound, double delta) {
        return Math.abs(lowerBound - higherBound) <= delta;
    }

    private static boolean isWithinDelta(double lowerBound, double higherBound) {
        return isWithinDelta(lowerBound, higherBound, DELTA);
    }

    public interface Action {
        void execute(WebElement webElement);
    }
}
