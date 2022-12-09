package com.bank.pages;
// **** Created By Harshit Patel ****

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage extends Utility {
    By clickCustomerLogin = By.xpath("//button[contains(text(),'Customer Login')]");

    public void clickOnCustomerLogin() {
        clickOnElement(clickCustomerLogin);
    }

    //  By selectName = By.xpath("//select[@id='userSelect']");
    // public void selectname(String name) {
    //     selectByVisibleTextFromDropDown(By.xpath("//select[@id='userSelect']"), name);
//    }
    public void serchName(String fName, String lName) {
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='userSelect']"), fName + " " + lName);

    }

    public String exptectedTextMessage(String expected) {
        System.out.println("Expected Text or Message is : " + expected);
        return expected;
    }

    public String actualTextToVerify(By by) {
        String actual = driver.findElement(by).getText();
        System.out.println("Actual Text or Message is : " + actual);
        return actual;
    }

    By clickOnLoginButton = By.xpath("//button[contains(text(),'Login')]");

    public void login() {
        clickOnElement(clickOnLoginButton);
    }

    public void verifyLogoutButton() {
        Boolean result = driver.findElement(By.xpath("//button[normalize-space()='Logout']")).isDisplayed();

    }

    By clickOnLogoutButton = By.xpath("//button[contains(text(),'Logout')]");

    public void logout() {
        clickOnElement(clickOnLogoutButton);
    }

    By clickOnDepositTab = By.xpath("//button[normalize-space()='Deposit']");

    public void DepositTab() {
        clickOnElement(clickOnDepositTab);
    }

    By enterAmount = By.xpath("//input[@placeholder='amount']");
    public void Amount() {
        sendTextToElement(enterAmount, "100");
    }
    By clickOnDepositButton = By.xpath("//button[@type='submit']");

    public void DepositButton() {
        clickOnElement(clickOnDepositButton);
    }
    By clickOnWithdrawlTab = By.xpath("//button[normalize-space()='Withdrawl']");

    public void WithdrawlTab() {
        clickOnElement(clickOnWithdrawlTab);
    }
    By enterAmount1 = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]");
    public void Amount1() {
        sendTextToElement(enterAmount1, "50");
    }
    By clickOnWithdrawlButton = By.xpath("//button[@type='submit']");

    public void WithdrawlButton() {
        clickOnElement(clickOnWithdrawlButton);
    }

}
