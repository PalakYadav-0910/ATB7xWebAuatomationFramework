package org.example.tests.vwoTests;

import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.pages.pageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLoginPOM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLoginPOM.class);

    @Test
    public void testLoginNegativeVWO() {

        logger.info("Starting the Testcase");
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());

        logger.info("Opening the Url");
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));

        logger.info("Verifying the error message text - " + error_msg_text);
        assertThat(error_msg_text).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg_text, PropertyReader.readKey("error_message"));

    }

}
