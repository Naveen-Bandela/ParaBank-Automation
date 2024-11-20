package com.parabank.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The `TestDataUtils` class provides utility methods to load and retrieve test
 * data from a properties file.
 * 
 * It loads the properties from the file `testdata.properties` located in the
 * `src/main/resources` directory. The class provides a static method to fetch
 * the test data values using a key. This class is typically used for accessing
 * test data values needed for test case execution.
 */
public class TestDataUtils {

	/**
	 * The Properties object holds key-value pairs loaded from the test data
	 * properties file.
	 */
	private static Properties properties = new Properties();

	/**
	 * Static block to load the properties file when the class is loaded. It reads
	 * the file `testdata.properties` and stores the key-value pairs in the
	 * `properties` object. If an error occurs while loading the properties file, it
	 * prints the stack trace.
	 */
	static {
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/testdata.properties");
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
     * Retrieves the test data value associated with the specified key.
     * 
     * @param key The key for which the associated test data value is to be retrieved.
     * @return The test data value associated with the provided key. If the key doesn't exist, it returns `null`.
     */
	public static String getTestData(String key) {
		return properties.getProperty(key);
	}

}
