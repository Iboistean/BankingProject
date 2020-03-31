package com.bankingproject.testCases;

import com.bankingproject.pageObjects.AddCustomerPage;
import com.bankingproject.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

public class TC_AddCustomerTest_003 extends Base_Class {

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {


        LoginPage lp = new LoginPage(driver);
        lp.setUsername(username);
        logger.info("User Name is Provided");
        lp.setPassword(password);
        logger.info("Password Name is Provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addcust = new AddCustomerPage(driver);

        addcust.clickAddNewCustomer();
        logger.info("Providind Customer Details.....");

        addcust.custName("Bob");
        addcust.custgender("male");
        addcust.custdob("10", "12", "1990");
        Thread.sleep(3000);
        addcust.custaddress("2121 Kings Highway");
        addcust.custcity("NYC");
        addcust.custstate("NY");
        addcust.custpinno("123331");
        addcust.custtelephoneno("432424342");

        String email = randomestring() + "@gmail.com";
        addcust.custemailid(email);

        addcust.custpassword("asdasdad");
        addcust.custsubmit();
        Thread.sleep(4000);

        logger.info("Validation Started.....");

        boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

        if(res==true){

            Assert.assertTrue(true);
            logger.info("Test Cases Passed");

        } else {

            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);
            logger.info("Test Case Failed");

        }
    }





}
