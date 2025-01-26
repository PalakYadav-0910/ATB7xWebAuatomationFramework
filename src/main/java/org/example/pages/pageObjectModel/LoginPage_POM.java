package org.example.pages.pageObjectModel;

import com.google.j2objc.annotations.Property;
import org.example.base.CommonToAllPage;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage_POM extends CommonToAllPage {

    WebDriver driver;

    public LoginPage_POM(WebDriver driver){
        this.driver = driver;
    }

    //Page Locators

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");

    //Page Actions

    public String loginToVWOInvalidCreds(String user, String pwd){
        driver.get(PropertyReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text = error_msg.getText();
        String error_msg_attribute_dataqa = error_msg.getAttribute("data-qa");
        return error_msg_text;

    }

}
