package com.bank.pages;
// **** Created By Harshit Patel ****

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class OpenAccountPage extends Utility {

    By clickBankManagerLogin = By.xpath("//button[contains(text(),'Bank Manager Login')]");

    public void clickOnBankManagerLogin() {
        clickOnElement(clickBankManagerLogin);
    }

    By openAccount = By.xpath("//button[@ng-click='openAccount()']");

    public void clickOnOpenAccount() {
        clickOnElement(openAccount);
    }


    public void serchCustomer(String fName, String lName) {
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='userSelect']"),fName+ " "+lName);

    }


    By currency = By.xpath("//select[@id='currency']");
    public void setCurrency(String currency) {
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='currency']"), currency);

    }
    By process = By.xpath("//button[contains(text(),'Process')]");
    public void setProcess(){
        clickOnElement(process);
    }

    public String getTextFromPopup(){
        return getTextFromAlert();
    }

    public void acceptPopup(){
        acceptAlert();
    }
    By clickOnHomeButton = By.xpath("//button[contains(text(),'Home')]");
    public void setClickOnHomeButton(){
        clickOnElement(clickOnHomeButton);
    }

}
