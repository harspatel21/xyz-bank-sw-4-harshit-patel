package com.bank.pages;
// **** Created By Harshit Patel ****

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class AddCustomerPage extends Utility {

    By firstName = By.xpath("//input[@placeholder='First Name']");

    //Enter "First Name"
    public void enterFirstName(String name) {
        sendTextToElement(firstName,name);
    }

    //Enter Last Name
    By lastName = By.xpath("//input[@placeholder='Last Name']");

    public void enterLastName(String surnamename) {
        sendTextToElement(lastName, surnamename);
    }

    //enter PostCode
    By postCode = By.xpath("//input[@placeholder='Post Code']");

    public void enterPostCode( String pin ) {
        sendTextToElement(postCode,pin );

    }
    //click On "Add Customer" Button
    By clickAddCust = By.xpath("//button[@type='submit']");

    public void clickOnAddCustomerButton(){
        clickOnElement(clickAddCust);
    }

    public String getTextFromPopup(){
        return getTextFromAlert();
    }
    public void acceptPopup(){
        acceptAlert();
    }

}
