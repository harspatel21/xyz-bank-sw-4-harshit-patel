package com.bank.testsuite;
// **** Created By Harshit Patel ****

import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {

    HomePage homePage = new HomePage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    AddCustomerPage addCustomerPage = new AddCustomerPage();
    OpenAccountPage openAccountPage = new OpenAccountPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();
    String fName = "James";
    String lName = "Bond";
    String pCode = "HA88BQ";

    @Test
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLogin();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.enterFirstName(fName);
        addCustomerPage.enterLastName(lName);
        addCustomerPage.enterPostCode(pCode);
        addCustomerPage.clickOnAddCustomerButton();
        Assert.assertEquals(addCustomerPage.getTextFromPopup().substring(0, 27), "Customer added successfully", "Message not displayed");
        addCustomerPage.acceptPopup();
        homePage.setClickOnHomeButton();
        BankTest bankTest = new BankTest();
        bankTest.bankManagerShouldOpenAccountSuccessfully();
        bankTest.customerShouldLoginAndLogoutSuceessfully();
        bankTest.customerShouldDepositMoneySuccessfully();
        bankTest.customerShouldWithdrawMoneySuccessfully();

    }

    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnBankManagerLogin();
        openAccountPage.clickOnOpenAccount();
        openAccountPage.serchCustomer(fName, lName);
        openAccountPage.setCurrency("Pound");
        openAccountPage.setProcess();
        Assert.assertEquals(addCustomerPage.getTextFromPopup().substring(0, 28), "Account created successfully", "Not match");
        openAccountPage.acceptPopup();
        openAccountPage.setClickOnHomeButton();
    }

    public void customerShouldLoginAndLogoutSuceessfully() {
        customerLoginPage.clickOnCustomerLogin();
        customerLoginPage.serchName(fName, lName);
        customerLoginPage.login();
        customerLoginPage.verifyLogoutButton();
        customerLoginPage.logout();
        assertAssert("Logout Is Not Successful", customerLoginPage.exptectedTextMessage("Your Name"), customerLoginPage.actualTextToVerify(By.xpath("//label[contains(text(),'Your Name :')]")).substring(0, 9));
        openAccountPage.setClickOnHomeButton();
    }

    public void customerShouldDepositMoneySuccessfully() {
        customerLoginPage.clickOnCustomerLogin();
        customerLoginPage.serchName(fName, lName);
        customerLoginPage.login();
        customerLoginPage.DepositTab();
        customerLoginPage.Amount();
        customerLoginPage.DepositButton();
        assertAssert("Deposit Is Not Successful", customerLoginPage.exptectedTextMessage("Deposit Successful"), customerLoginPage.actualTextToVerify(By.xpath("//span[contains(text(),'Deposit Successful')]")));
        openAccountPage.setClickOnHomeButton();
    }

    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        customerLoginPage.clickOnCustomerLogin();
        customerLoginPage.serchName(fName, lName);
        customerLoginPage.login();
        customerLoginPage.DepositTab();
        customerLoginPage.Amount();
        customerLoginPage.DepositButton();
        customerLoginPage.WithdrawlTab();
        Thread.sleep(3000);
        customerLoginPage.Amount1();
        customerLoginPage.WithdrawlButton();
        assertAssert("Transaction Is Not Successful", customerLoginPage.exptectedTextMessage("Transaction successful"), customerLoginPage.actualTextToVerify(By.xpath("//span[contains(text(),'Transaction successful')]")));
    }

}
