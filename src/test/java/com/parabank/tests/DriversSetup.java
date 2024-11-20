package com.parabank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * DriversSetup class provides methods to set up WebDriver instances for
 * different browsers. It uses WebDriverManager to manage browser driver
 * binaries.
 */
public class DriversSetup {

	/**
	 * Holds the WebDriver instance for browser interactions.
	 */
	private static WebDriver driver = null;

	/**
	 * Sets up and returns a Chrome WebDriver instance.
	 * 
	 * @return a {@link WebDriver} instance for Chrome browser
	 */
	public static WebDriver setupChromeDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	/**
	 * Sets up and returns a Firefox WebDriver instance.
	 * 
	 * @return a {@link WebDriver} instance for Firefox browser
	 */

	public static WebDriver setupFirefoxDriver() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		return driver;
	}

	/**
	 * Sets up and returns an Internet Explorer WebDriver instance.
	 * 
	 * @return a {@link WebDriver} instance for Internet Explorer browser
	 */
	public static WebDriver setupIEDriver() {

		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		return driver;
	}

	/**
	 * Invokes the appropriate WebDriver setup based on the specified browser type.
	 * 
	 * <p>
	 * If an unsupported browser type is provided, the default Chrome WebDriver is
	 * returned.
	 * 
	 * @param browser the type of browser to set up (e.g., "chrome", "firefox",
	 *                "ie")
	 * @return a {@link WebDriver} instance for the specified browser
	 */
	public static WebDriver invokeDrivers(String browser) {
		switch (browser.toLowerCase()) {
		case "firefox":
			return setupFirefoxDriver();
		case "chrome":
			return setupChromeDriver();

		case "ie":
			return setupIEDriver();

		default:
			return setupChromeDriver();

		}
	}

}
