package com.qa.seleniumproject.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    private static String currentDirectory = System.getProperty("user.dir");

    // System.out.println(currentDirectory);
    // make the file path dynamic instead of static path.
    private static String configFilePath = currentDirectory
            + "/src/test/java/com/qa/seleniumproject/resourses/browserConfig.properties";

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(configFilePath);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch(IOException exception) {
            System.out.println("Error Loading the properties file: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    // Method to get property value by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Overloaded method to provide default value if key is not found
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
