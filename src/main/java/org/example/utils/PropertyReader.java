package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    //Read the browser = Chrome -> DriverManager

    public PropertyReader() {
    }

    public static String readKey(String key) {

        FileInputStream fileInputStream = null;
        Properties properties = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/resources/data.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String value = properties.getProperty(key);
        return value;

    }

}
