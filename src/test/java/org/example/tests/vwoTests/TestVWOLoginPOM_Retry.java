package org.example.tests.vwoTests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.listeners.RetryAnalyzer;
import org.example.pages.pageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLoginPOM_Retry extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLoginPOM_Retry.class);

    @Test(groups = "qa")
    @Owner("Palak")
    @Parameters("url") //For passing parameters from qa-env testng file
    @Description("TC1 - Verify with the invalid login, error message is displayed.")
    public void testLoginNegativeVWO(String url) {

        logger.info("Starting the Testcase");
        String key = System.getenv("Password"); //In Terminal type- export Password="admin123"

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());

        logger.info("Opening the Url");
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));

        logger.info("Verifying the error message text - " + error_msg_text);
        assertThat(error_msg_text).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg_text, PropertyReader.readKey("error_message"));

    }

    @Test(groups = {"sanity","P0"})
    @Owner("Promode")
    @Description("TC1 - Verify with the invalid login, error message is displayed.")
    public void testLoginNegativeVW2() {
        Assert.assertEquals(true,false);
    }

    @Test(groups = {"smoke","P0"})
    @Owner("Promode")
    @Description("TC1 - Verify with the invalid login, error message is displayed.")
    public void testLoginNegativeVW3() {
        Assert.assertEquals(true,false);
    }

}
