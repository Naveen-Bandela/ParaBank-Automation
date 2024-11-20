package com.parabank.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The `ExpectedDataUtils` class provides utility methods to load and retrieve expected data from a properties file.
 * 
 * It loads the properties from the file `expectedassertions.properties` located in the `src/main/resources` directory.
 * The class provides a static method to fetch the expected values using a key.
 * This class is useful for accessing expected values for assertions in test cases.
 */
public class ExpectedDataUtils {
	
	/** The Properties object holds key-value pairs loaded from the properties file. */
	private static Properties properties = new Properties();
	
	 /**
     * Static block to load the properties file when the class is loaded.
     * It reads the file `expectedassertions.properties` and stores the key-value pairs in the `properties` object.
     * If an error occurs while loading the properties file, it prints the stack trace.
     */
    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/expectedassertions.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the expected data value associated with the specified key.
     * 
     * @param key The key for which the associated expected value is to be retrieved.
     * @return The expected value associated with the provided key. If the key doesn't exist, it returns `null`.
     */
    public static String getExpectedData(String key) {
        return properties.getProperty(key);
    }

}
