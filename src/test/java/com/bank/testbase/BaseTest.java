package com.bank.testbase;
// **** Created By Harshit Patel ****


import com.bank.propertyreader.PropertyReader;
import com.bank.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp() {
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
/*
    //test to check framework has set up accurately
    @Test
    public void test(){
        System.out.println("Congratulation.... Your Framework has been set up accurately...");
    }
 */
}
