package com.bankingproject.testCases;

import com.bankingproject.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends Base_Class {


    @Test
    public void loginTest() throws IOException {


        logger.info("Url is open");

        LoginPage lp = new LoginPage(driver);
        lp.setUsername(username);
        logger.info("Login is Entered");

        lp.setPassword(password);
        logger.info("Password is Entered");

        lp.clickSubmit();







        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

            Assert.assertTrue(true);
            logger.info("Test Case Passed");



        } else {

            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("Test Case Failed");

        }

        logger.info("Test Case Executed");


    }


}
