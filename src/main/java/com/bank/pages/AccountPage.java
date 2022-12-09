package com.bank.pages;
// **** Created By Harshit Patel ****

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class AccountPage extends Utility {

    By openAccount = By.xpath("//body/div[3]/div[1]");
    public void clickOnOpenAccount(){
        clickOnElement(openAccount);
    }
    By customer = By.xpath("//select[@id='userSelect']");
    public void setCustomer(String name){
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='userSelect']"),name);
    }
    By currency = By.xpath("//select[@id='currency']");
    public void setCurrency(String currency){
        selectByContainsTextFromDropDown(By.xpath("//select[@id='currency']"),currency);
    }
    By process = By.xpath("//button[contains(text(),'Process')]");
    public void setProcess(){
        clickOnElement(process);
    }

}
