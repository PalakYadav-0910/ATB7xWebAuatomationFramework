package org.example.tests.vwoTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.pages.pageFactory.LoginPage_PF;
import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLoginPF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLoginPF.class);

    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Testcases Page Factory");
        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertyReader.readKey("url"));
        LoginPage_PF loginPage_PF = new LoginPage_PF(driver);
        String error_msg = loginPage_PF.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg, PropertyReader.readKey("error_message"));
    }

}
