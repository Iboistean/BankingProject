package com.bankingproject.testCases;

import com.bankingproject.pageObjects.LoginPage;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetbanking.utilities.XLUtils;

import java.io.IOException;

public class TC_LoginDDT_002 extends Base_Class {

    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) throws InterruptedException {

        LoginPage lp = new LoginPage(driver);
        lp.setUsername(user);
        logger.info("user name provided");
        lp.setPassword(pwd);
        logger.info("password provided");
        lp.clickSubmit();
        Thread.sleep(3000);

        if(isAlertPresent()==true){
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.info("Login Failed");

        } else {

            Assert.assertTrue(true);
            logger.info("Login Passed");
            lp.clickLogout();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();


        }


    }


    public boolean isAlertPresent() // Check if alert is present or not
    {

        try {
            driver.switchTo().alert();
            return true;

        } catch (NoAlertPresentException e) {
            return false;
        }


    }


    @DataProvider(name = "LoginData")
    Object[][] getData() throws IOException {

        String path = System.getProperty("user.dir") + "/src/test/java/com/bankingproject/testData/LoginData.xlsx";

        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int cocount = XLUtils.getCellCount(path, "Sheet1", 1);

        String logindata[][] = new String[rownum][cocount];

        for (int i = 1; i < rownum; i++) {

            for (int j = 0; j < cocount; j++) {


                logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j); // i-1 is because in Exel File we need to start from index 1 because of the header.

            }

        }

        return logindata;
    }

}

