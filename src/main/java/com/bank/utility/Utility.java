package com.bank.utility;
// **** Created By Harshit Patel ****


import com.bank.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Utility extends ManageBrowser {

    /**
     * This Method will click on any find element
     */

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    /**
     * This Method will send text find element
     */
    public void sendTextToElement(By by, String text) {
        WebElement emailField = driver.findElement(by);
        //type email to email field.
        emailField.sendKeys(text);
    }

    /**
     * This Method will get text from element
     */
    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    //This method will switch to Alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

 /*   public String getTextFromAlert(String text) {
        driver.switchTo().alert().getText();
        return text;
    } */
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys("text");
    }


    // ************* Select Class Methods ***********************


    /**
     * This method will select options by visible text from dropdown menu
     */

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        // Creating an object of Select class which is parameterised so pass dropDown
        Select select = new Select(dropDown);
        //Select by Visible Text
        select.selectByVisibleText(text); // this will select value from country field.
    }

    /**
     * This method will select options by value from dropdown menu
     */

    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        // Creating an object of Select class which is parameterised so pass dropDown
        Select select = new Select(dropDown);
        //Select by Value
        select.selectByValue(text); // this will select value from country field.
    }

    /**
     * This method will select options by Index from dropdown menu
     */

    public void selectByIndexFromDropDown(By by, int ind) {
        WebElement dropDown = driver.findElement(by);
        // Creating an object of Select class which is parameterised so pass dropDown
        Select select = new Select(dropDown);
        //Select by Index
        select.selectByIndex(ind); // this will select value from country field.
    }

    /**
     * This method will select options by contain text from dropdown menu
     */

    public void selectByContainsTextFromDropDown(By by) {
        WebElement dropDown = driver.findElement(by);
        // Creating an object of Select class which is parameterised so pass dropDown
        Select select = new Select(dropDown);
        //Select by Contain Text
        List<WebElement> list = select.getOptions(); // this will select value from country field.
    }

    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    // This method hoover on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).build().perform();
    }

    // This method hoover on element and click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).click().build().perform();
    }

    //*************************** Window Handle Methods ***************************************//

    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }

    //************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }
    // ***************************************** Assert Method *****************************************
    //this is Assert method which compares two text
    public void assertAssert(String message, String expected, String actual) {
        Assert.assertEquals(actual, expected, message);
    }

    public static String getAlphaNumericString(int n) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

}
