package com.parabank.tests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.parabank.pages.UserRegistrationAndAuthenticationPage;
import com.parabank.utils.TestListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

/**
 * This class contains test cases for verifying user registration and
 * authentication processes, including registering a new user, logging in with
 * valid and invalid credentials, and resetting forgotten passwords.
 * 
 * It extends from the BaseTest class and uses TestNG framework for managing
 * test execution. The tests are executed with WebDriver, and the actions are
 * performed through the UserRegistrationAndAuthenticationPage object. The
 * logger is used for tracking the flow of test execution and capturing errors.
 * 
 * @Listeners(TestListener.class) - Adds a custom listener for enhanced test
 * reporting.
 */
@Listeners(TestListener.class)
public class UserRegistrationAndAuthenticationTest extends BaseTest {

	/** Stores the username used for registration or login. */
	private static String userName = "";

	/** Page object for performing user registration and authentication actions. */
	private UserRegistrationAndAuthenticationPage userRegistrationAndAuthenticationPage = null;

	/** Logger for tracking test execution and capturing error messages. */
	private static final Logger logger = Logger.getLogger(UserRegistrationAndAuthenticationTest.class.getName());

	/**
	 * This method is executed before each test method. It initializes the WebDriver
	 * and sets up the page object for user registration and authentication.
	 * 
	 * @param siteURL The URL of the site to be tested.
	 * @param browser The browser to be used for testing.
	 * @throws InterruptedException If the thread is interrupted during test setup.
	 */
	@BeforeMethod
	@Parameters({ "siteURL", "browser" })
	public void setupDriver(String siteURL, String browser) throws InterruptedException {

		logger.info("Starting of initDriver method in UserRegistrationAndAuthenticationTest");
		if (driver == null) {

			initWebDriver(siteURL, browser);
		}

		userRegistrationAndAuthenticationPage = new UserRegistrationAndAuthenticationPage(driver);

		logger.info("Ending of initDriver method in UserRegistrationAndAuthenticationTest");

	}

	/**
	 * This test case registers a new user account by filling out the registration
	 * form and submitting it.
	 * 
	 * @throws InterruptedException If the thread is interrupted during the test
	 *                              execution.
	 */
	@Test(priority = 1, description = "Register a new user account", enabled = true)
	@Description("This test registers a new user account by filling out the registration form and submitting it.")
	@Severity(SeverityLevel.BLOCKER)

	public void testverifyRegisterNewAccount() throws InterruptedException {

		logger.info("Starting of testverifyRegisterNewAccount method in UserRegistrationAndAuthenticationTest");

		try {

			// Verifying para-bank page title
			assertEquals(userRegistrationAndAuthenticationPage.getTitleOfPage(),
					expectedAssertionsProp.getProperty("page.title"));

			// Performing employee details action
			this.userRegistrationAndAuthenticationPage.clickOnRegister();
			this.userRegistrationAndAuthenticationPage.setFirstName(testDataProp.getProperty("firstName"));
			this.userRegistrationAndAuthenticationPage.setLastName(testDataProp.getProperty("lastName"));
			this.userRegistrationAndAuthenticationPage.setAdress(testDataProp.getProperty("address"));
			this.userRegistrationAndAuthenticationPage.setCity(testDataProp.getProperty("city"));
			this.userRegistrationAndAuthenticationPage.setState(testDataProp.getProperty("state"));
			this.userRegistrationAndAuthenticationPage.setZipCode(testDataProp.getProperty("zipcode"));
			this.userRegistrationAndAuthenticationPage.setPhoneNumber(testDataProp.getProperty("phoneNumber"));
			this.userRegistrationAndAuthenticationPage.setSSN(testDataProp.getProperty("SSN"));

			userName = this.userRegistrationAndAuthenticationPage.setUserName(testDataProp.getProperty("userName"));
			System.err.println(userName);
			this.userRegistrationAndAuthenticationPage.setPassword(testDataProp.getProperty("password"));
			this.userRegistrationAndAuthenticationPage.setConfirmPassword(testDataProp.getProperty("confirm.password"));
			this.userRegistrationAndAuthenticationPage.clickOnRegisterButton();

			// Verifying Success Message after created a new user
			assertEquals(userRegistrationAndAuthenticationPage.getSuccessMessage(),
					expectedAssertionsProp.get("success.message"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the UserRegistrationAndAuthenticationTest" + e.getMessage());
			logger.error("Error occured while testing the UserRegistrationAndAuthenticationTest", e);
		}

		logger.info("Ending of verifyCreateNewEmployee method in UserRegistrationAndAuthenticationTest");

	}

	/**
	 * This test case verifies the login functionality with valid credentials. It
	 * ensures that a user can successfully log in with the correct username and
	 * password.
	 * 
	 * @throws InterruptedException If the thread is interrupted during test
	 *                              execution.
	 */
	@Test(priority = 2, description = "Login with valid credentials")
	@Description("This test verifies the login functionality with valid credentials. It ensures that a user with correct username and password can successfully log in and is redirected to the appropriate dashboard or home page.")
	@Severity(SeverityLevel.BLOCKER)

	public void testverifyLoginWithValidCredentials() throws InterruptedException {

		logger.info("Stating of testverifyLoginWithValidCredentials Method in UserRegistrationAndAuthenticationTest");

		try {

			// Verifying Customer Login Header
			assertEquals(userRegistrationAndAuthenticationPage.getLoginTitle(),
					expectedAssertionsProp.getProperty("login.header"));

			// Performing Login action
			this.userRegistrationAndAuthenticationPage.setUsernameInLoginPage(testDataProp.getProperty("userName"));
			this.userRegistrationAndAuthenticationPage.setPasswordInLoginPage(testDataProp.getProperty("password"));
			this.userRegistrationAndAuthenticationPage.clickOnLogin();
			Thread.sleep(2000);

			// Verifying the Account Holder Name After Logged in
			assertEquals(userRegistrationAndAuthenticationPage.getAccountholderName(),
					expectedAssertionsProp.getProperty("account.holder.name"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the UserRegistrationAndAuthenticationTest" + e.getMessage());
			logger.error("Error occured while testing the UserRegistrationAndAuthenticationTest", e);
		}

		logger.info("Ending of testverifyLoginWithValidCredentials method in UserRegistrationAndAuthenticationTest");
	}

	/**
	 * This test case verifies that login fails with invalid credentials. It ensures
	 * that a user cannot log in with incorrect username or password.
	 * 
	 * @throws InterruptedException If the thread is interrupted during test
	 *                              execution.
	 */
	@Test(priority = 3, description = "Verify login fails with invalid credentials")
	@Description("This test verifies the login functionality with invalid credentials. It ensures that a user cannot log in with incorrect username or password and receives an appropriate error message without accessing the dashboard or home page.")
	@Severity(SeverityLevel.BLOCKER)

	public void testverifyLoginWithInValidCredentials() throws InterruptedException {

		logger.info("Stating of testverifyLoginWithInValidCredentials Method in UserRegistrationAndAuthenticationTest");

		try {

			// Verifying Customer Login Header
			assertEquals(userRegistrationAndAuthenticationPage.getLoginTitle(),
					expectedAssertionsProp.getProperty("login.header"));

			// Performing Login action
			this.userRegistrationAndAuthenticationPage
					.setUsernameInLoginPage(testDataProp.getProperty("invalid.user.name"));
			this.userRegistrationAndAuthenticationPage
					.setPasswordInLoginPage(testDataProp.getProperty("invalid.password"));
			this.userRegistrationAndAuthenticationPage.clickOnLogin();

			// Verifying the Error message after entered invalid credentials
			assertEquals(userRegistrationAndAuthenticationPage.getErrorMessage(),
					expectedAssertionsProp.getProperty("loginfailure.error"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the Login Test" + e.getMessage());
			logger.error("Error occured while testing the LoginTest", e);
		}

		logger.info("Ending of testverifyLoginWithInValidCredentials method in UserRegistrationAndAuthenticationTest");
	}

	/**
	 * This test case verifies the reset forgotten password flow. It ensures that a
	 * user can reset their forgotten password and successfully log in with the new
	 * password.
	 * 
	 * @throws InterruptedException If the thread is interrupted during test
	 *                              execution.
	 */
	@Test(priority = 4, description = "Verify Login functionality with Reset forgotten password flow", enabled = true)
	@Description("This test verifies the login functionality when a user resets their forgotten password. It ensures the reset password flow works correctly, allowing the user to set a new password and successfully log in with the updated credentials.")
	@Severity(SeverityLevel.BLOCKER)

	public void testverifyResetForgottenPasswordFlow() throws InterruptedException {

		logger.info("Stating of testverifyResetForgottenPasswordFlow Method in UserRegistrationAndAuthenticationTest");

		try {
			this.userRegistrationAndAuthenticationPage.ClickOnForgotLoginInfo();

			// Verifying Customer Forgot Password Header
			assertEquals(userRegistrationAndAuthenticationPage.getForgotLoginInfoHeader(),
					expectedAssertionsProp.getProperty("forgot.login.info.header"));

			// Performing actions to validate your account
			this.userRegistrationAndAuthenticationPage
					.setFirstNameToValidateAccount(testDataProp.getProperty("firstName"));
			this.userRegistrationAndAuthenticationPage
					.setLastNameToValidateAccount(testDataProp.getProperty("lastName"));
			this.userRegistrationAndAuthenticationPage.setAddressToValidateAccount(testDataProp.getProperty("address"));
			this.userRegistrationAndAuthenticationPage.setCityToValidateAccount(testDataProp.getProperty("city"));
			this.userRegistrationAndAuthenticationPage.setStateToValidateAccount(testDataProp.getProperty("state"));
			this.userRegistrationAndAuthenticationPage.setZipcodeToValidateAccount(testDataProp.getProperty("zipcode"));
			this.userRegistrationAndAuthenticationPage.setSSNToValidateAccount(testDataProp.getProperty("SSN"));
			this.userRegistrationAndAuthenticationPage.clickOnFindMyLoginInfo();

			// Verifying the Error message after entered invalid credentials
			assertEquals(userRegistrationAndAuthenticationPage.getCustomerLookupSucessMessage(),
					expectedAssertionsProp.getProperty("forgot.password.success"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the UserRegistrationAndAuthenticationTest" + e.getMessage());
			logger.error("Error occured while testing the UserRegistrationAndAuthenticationTest", e);
		}

		logger.info("Ending of testverifyResetForgottenPasswordFlow method in UserRegistrationAndAuthenticationTest");
	}

	/**
	 * Quits the WebDriver instance after each test method.
	 */
	@AfterMethod
	public void quitDriver() {

		logger.info("Starting of quitDriver method in UserRegistrationAndAuthenticationTest");

		quitWebDriver();

		logger.info("Ending of quitDriver method in UserRegistrationAndAuthenticationTest");
	}

}
