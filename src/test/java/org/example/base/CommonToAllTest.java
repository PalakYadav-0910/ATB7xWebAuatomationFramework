package org.example.base;

import org.example.driver.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CommonToAllTest {

    @BeforeTest
    public void setUp() {
        DriverManager.init();
    }

    @AfterTest
    public void tearDown() {
        DriverManager.down();
    }

}
