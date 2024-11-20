package com.parabank.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.parabank.tests.BaseTest;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;


/**
 * The `TestListener` class is a custom implementation of TestNG's `ITestListener` interface.
 * It listens to the lifecycle of the test execution and performs actions such as logging, capturing screenshots,
 * and saving attachments (text and HTML) in Allure reports.
 * This class is used for enhancing test reporting and capturing useful information during test execution.
 */
public class TestListener extends TestListenerAdapter {

	 /** Logger instance to log test events. */
	private static final Logger logger = Logger.getLogger(TestListener.class.getName());

	/**
     * Retrieves the name of the test method from the ITestResult.
     * 
     * @param iTestResult The ITestResult object which contains the details of the test method.
     * @return The name of the test method.
     */
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	/**
     * Captures a screenshot and attaches it to the Allure report.
     * 
     * @param screenshotType The type or name of the screenshot for identification in the report.
     * @param driver The WebDriver instance used to capture the screenshot.
     */
	public void saveScreenshotPNG(String screenshotType, WebDriver driver) {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Allure.getLifecycle().addAttachment(screenshotType + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")), "image/png", "png", screenshot);
	}

	// Text attachments for Allure reports

    /**
     * Attaches a text message to the Allure report.
     * 
     * @param message The text message to be attached to the report.
     * @return The text message.
     */
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	
	// HTML attachments for Allure reports

    /**
     * Attaches an HTML content to the Allure report.
     * 
     * @param html The HTML content to be attached.
     * @return The HTML content.
     */
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		logger.info("In onStart method " + iTestContext.getName());
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		logger.info(getTestMethodName(iTestResult) + " test is starting.");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		logger.info(getTestMethodName(iTestResult) + " test is succeed.");
	}

	@Override
	
	  public void onTestFailure(ITestResult iTestResult) {
	  logger.info(getTestMethodName(iTestResult) + " test is failed.");
	  
	  // Get driver from BaseTest and assign to local webdriver
	  Object testClass = iTestResult.getInstance(); 
	  WebDriver driver = ((BaseTest) testClass).getDriver();
	  
	  // Allure ScreenShotRobot and SaveTestLog if (driver != null) {
	  logger.info("Screenshot captured for test case:" +
	  getTestMethodName(iTestResult));
	  saveScreenshotPNG("Test_Failure_Screenshot_", driver);
	  
	  }
	  
	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		logger.info(getTestMethodName(iTestResult) + " test is skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		logger.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

	public void onTestFailedWithTimeout(ITestResult iTestResult) {
		logger.info(getTestMethodName(iTestResult) + " test is failed with Timeout.");
		onTestFailure(iTestResult);
	}
}