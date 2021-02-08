package com.TopSecret.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtils {

    /**
     * Performs a pause
     * @param Seconds
     */
    public static void waitFor(double Seconds) {
        try {
            Thread.sleep((long) (Seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Moves the cursor to given element
     * @param element on which to hover
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }
}
