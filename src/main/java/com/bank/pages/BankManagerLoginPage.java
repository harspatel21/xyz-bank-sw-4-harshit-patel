package com.bank.pages;
// **** Created By Harshit Patel ****

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class BankManagerLoginPage extends Utility {
    By clickOnHomeButton = By.xpath("//button[contains(text(),'Home')]");
    public void setClickOnHomeButton(){
        clickOnElement(clickOnHomeButton);
    }
    By clickBankManagerLogin = By.xpath("//button[contains(text(),'Bank Manager Login')]");
    public void clickOnBankManagerLogin() {
        clickOnElement(clickBankManagerLogin);
    }

    By addCustomer = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]");
    public void clickOnAddCustomer(){
        clickOnElement(addCustomer);
    }
    By openAccount = By.xpath("//body/div[3]/div[1]");
    public void clickOnOpenAccount(){
        clickOnElement(openAccount);
    }
    By customers = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[3]");
    public void clickOnCustomers(){
        clickOnElement(customers);
    }
}
