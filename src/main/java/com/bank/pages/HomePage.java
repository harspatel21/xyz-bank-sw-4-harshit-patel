package com.bank.pages;
// **** Created By Harshit Patel ****

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By clickOnHomeButton = By.xpath("//button[contains(text(),'Home')]");
    public void setClickOnHomeButton(){
        clickOnElement(clickOnHomeButton);
    }

    By clickCustomerLogin = By.xpath("//button[contains(text(),'Customer Login')]");
    public void clickOnCustomerLogin() {
        clickOnElement(clickCustomerLogin);
    }

    By clickBankManagerLogin = By.xpath("//button[contains(text(),'Bank Manager Login')]");
    public void clickOnBankManagerLogin() {
        clickOnElement(clickBankManagerLogin);
    }
}
