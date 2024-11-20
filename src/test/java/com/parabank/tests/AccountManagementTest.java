package com.parabank.tests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.parabank.pages.AccountManagementPage;
import com.parabank.utils.TestListener;

import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;

/**
 * AccountManagementTest class contains test cases related to account management
 * functionalities.
 * 
 * <p>
 * It extends the BaseTest class and uses the TestListener for enhanced test
 * result reporting. This class tests features such as opening a new account and
 * verifying account overview details.
 */
@Listeners(TestListener.class)
public class AccountManagementTest extends BaseTest {

	/** Page object for account management-related actions. */
	AccountManagementPage accountManagementPage = null;

	/** Logger instance for logging test execution details. */
	private static final Logger logger = Logger.getLogger(AccountManagementTest.class.getName());

	/**
	 * Sets up the WebDriver and logs in to the application before each test method.
	 * 
	 * @param siteURL the URL of the application
	 * @param browser the type of browser to use (e.g., Chrome, Firefox)
	 * @throws InterruptedException if interrupted during execution
	 */
	@BeforeMethod
	@Parameters({ "siteURL", "browser" })
	public void setupDriver(String siteURL, String browser) throws InterruptedException {

		logger.info("Starting initWebDriver in AccountManagementTest");

		if (driver == null) {
			initWebDriver(siteURL, browser);
		}
		performLogin();
		accountManagementPage = new AccountManagementPage(driver);
		logger.info("Ending initWebDriver in AccountManagementTest");
	}

	/**
	 * Validates the functionality of opening a new account.
	 * 
	 * <p>
	 * This test ensures that a user can successfully open a new account by
	 * selecting the account type and funding source, and verifies the success
	 * message or newly created account details.
	 * 
	 * @throws InterruptedException if interrupted during execution
	 */
	@Test(priority = 1, description = "Verify Open a new account")
	@Description("This test validates the functionality of opening a new account. It ensures that a user can successfully open a new account by selecting the account type and funding source, and verifies the success message or newly created account details.")
	@Severity(SeverityLevel.BLOCKER)
	public void testVerifyOpenNewAccount() throws InterruptedException {

		logger.info("Starting of testVerifyOpenNewAccount Method ");
		try {

			this.accountManagementPage.openOpenNewAccount();

			// Verifying the Open new account title
			assertEquals(this.accountManagementPage.getOpenNewAccountTitle(),expectedAssertionsProp.getProperty("openNewAccount.header"));

			// Performing actions to create new SAVINGS account
			this.accountManagementPage.selectTypeOfAccount();
			this.accountManagementPage.selectExistingAccount();
			this.accountManagementPage.clickOnOpenNewAccount();

			// Verifying whether the account has been created or not.
			assertEquals(this.accountManagementPage.getCongratulationsMessage(),expectedAssertionsProp.getProperty("message.congratulations"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the AccountManagementTest" + e.getMessage());
			logger.error("Error occured while testing the AccountManagementTest", e);
		}

		logger.info("Ending of testVerifyOpenNewAccount Method ");
	}

	/**
	 * Validates the 'Account Overview' functionality.
	 * 
	 * <p>
	 * This test ensures that after logging in, the user can successfully navigate
	 * to the 'Account Overview' section and view accurate account details, such as
	 * balances and recent transactions.
	 * 
	 * @throws InterruptedException if interrupted during execution
	 */
	@Test(priority = 2, description = "Verify Account Overview, Balance and Transaction History")
	@Description("This test validates the 'Account Overview' functionality. It ensures that after logging in, the user can successfully navigate to the 'Account Overview' section and view accurate account details, such as balances and recent transactions.")
	@Severity(SeverityLevel.CRITICAL)
	public void testVerifyAccountOverview() throws InterruptedException {

		logger.info("Starting of testVerifyAccountOverview Method ");
		try {

			// Performing action to see the Accounts Overview
			this.accountManagementPage.openAccountsOverview();

			// Verifying the Account Overview Title
			assertEquals(this.accountManagementPage.getAccountOverviewHeader(),
					expectedAssertionsProp.getProperty("overview.header"));

			// Performing actions to see the Account balance and Transactions details

			this.accountManagementPage.viewTransactionHistory();

			assertEquals(this.accountManagementPage.getAccountDetailHeader(),
					expectedAssertionsProp.getProperty("accountDetail.header"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the AccountManagementTest" + e.getMessage());
			logger.error("Error occured while testing the AccountManagementTest", e);
		}

		logger.info("Ending of testVerifyAccountOverview Method ");
	}

	/**
	 * Quits the WebDriver instance after each test method.
	 */
	@AfterMethod
	public void quitDriver() {

		logger.info("Starting of quitDriver method in AccountManagementTest");

		quitWebDriver();

		logger.info("Ending of quitDriver method in AccountManagementTest");
	}

}
