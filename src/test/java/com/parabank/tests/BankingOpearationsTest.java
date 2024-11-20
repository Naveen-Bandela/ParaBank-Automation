package com.parabank.tests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.parabank.pages.BankingOperationsPage;
import com.parabank.utils.TestListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

/**
 * BankingOpearationsTest class contains test cases for verifying banking
 * operations such as transferring funds, making bill payments, requesting
 * loans, and finding transactions.
 * 
 * <p>
 * It extends the BaseTest class and uses the TestListener for enhanced
 * reporting. The tests cover critical functionalities in banking operations,
 * ensuring seamless execution of various financial transactions and processes.
 */
@Listeners(TestListener.class)
public class BankingOpearationsTest extends BaseTest {

	/** Page object for banking operations-related actions. */
	BankingOperationsPage bankingOpearationsPage = null;

	/** Logger instance for logging test execution details. */
	private static final Logger logger = Logger.getLogger(BankingOpearationsTest.class.getName());

	/**
	 * Sets up the WebDriver and logs in to the application before each test method.
	 * 
	 * @param siteURL the URL of the application
	 * @param browser the browser to use (e.g., Chrome, Firefox)
	 * @throws InterruptedException if interrupted during execution
	 */
	@BeforeMethod
	@Parameters({ "siteURL", "browser" })
	public void setupDriver(String siteURL, String browser) throws InterruptedException {

		logger.info("Starting initWebDriver in BankingOpearationsTest");

		if (driver == null) {
			initWebDriver(siteURL, browser);
		}
		performLogin();
		bankingOpearationsPage = new BankingOperationsPage(driver);
		logger.info("Ending initWebDriver in BankingOpearationsTest");
	}

	/**
	 * Verifies the transfer of funds between accounts.
	 * 
	 * <p>
	 * This test ensures that a transaction is processed successfully, the correct
	 * amount is deducted from the source account, and the same amount is credited
	 * to the destination account.
	 * 
	 * @throws InterruptedException if interrupted during execution
	 */
	@Test(priority = 1, description = "Verify Transfer funds between accounts")
	@Description("This test verifies the transfer of funds between two accounts. It ensures that the transaction is successfully processed, the correct amount is deducted from the source account, and the same amount is credited to the destination account.")
	@Severity(SeverityLevel.CRITICAL)
	public void testVerifyTransferFunds() throws InterruptedException {

		logger.info("Starting of testVerifyTransferFunds Method ");
		try {

			this.bankingOpearationsPage.clickOnTransferFund();

			// Verifying the Transfers Fund Header
			assertEquals(this.bankingOpearationsPage.getTransferFundHeader(),
					expectedAssertionsProp.getProperty("tansferfund.header"));

			// Performing actions to transfer the fund between two account
			this.bankingOpearationsPage.setAmount(testDataProp.getProperty("amount"));
			this.bankingOpearationsPage.selectFromAccount();
			this.bankingOpearationsPage.selectToAccount();
			this.bankingOpearationsPage.clickOnTransfer();

			// Verifying whether the funds are transferred or not.

			assertEquals(this.bankingOpearationsPage.getTransferConfirmationMessage(),
					expectedAssertionsProp.getProperty("transfer.complete"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the BankingOpearationsTest" + e.getMessage());
			logger.error("Error occured while testing the BankingOpearationsTest", e);
		}

		logger.info("Ending of testVerifyTransferFunds Method ");
	}

	/**
	 * Verifies the bill payment functionality.
	 * 
	 * <p>
	 * This test ensures that users can make payments successfully by providing
	 * valid payee details, account information, and payment amount. It validates
	 * the payment confirmation message.
	 * 
	 * @throws InterruptedException if interrupted during execution
	 */
	@Test(priority = 2, description = "Verify Bill payment functionality")
	@Description("This test verifies the bill payment functionality. It ensures that users can successfully make payments by providing valid payee details, account information, and payment amount, and that the payment confirmation is displayed correctly.")
	@Severity(SeverityLevel.CRITICAL)
	public void testVerifyBillPayment() throws InterruptedException {

		logger.info("Starting of testVerifyBillPayment Method ");
		try {

			this.bankingOpearationsPage.clickOnBillPay();

			// Verifying the Bill-Payment Header
			assertEquals(this.bankingOpearationsPage.getBillPayHeader(),
					expectedAssertionsProp.getProperty("billpayment.header"));

			// Performing actions to Bill payment from an account
			this.bankingOpearationsPage.setPayneeName(testDataProp.getProperty("payee.name"));
			this.bankingOpearationsPage.setAddress(testDataProp.getProperty("payee.address"));
			this.bankingOpearationsPage.setCity(testDataProp.getProperty("payee.city"));
			this.bankingOpearationsPage.setState(testDataProp.getProperty("payee.state"));
			this.bankingOpearationsPage.setZipcode(testDataProp.getProperty("payee.zipcode"));
			this.bankingOpearationsPage.setPhoneNumber(testDataProp.getProperty("payee.phoneNumber"));
			this.bankingOpearationsPage.setAccount(testDataProp.getProperty("payee.account"));
			this.bankingOpearationsPage.setVerifyAccount(testDataProp.getProperty("payee.verifyAccount"));
			this.bankingOpearationsPage.selectBillPayFromAccount();
			this.bankingOpearationsPage.setBillPayAmount(testDataProp.getProperty("payee.amount"));
			this.bankingOpearationsPage.clickOnSendPayment();

			// Verifying whether the Bill-Payment success or not.

			assertEquals(this.bankingOpearationsPage.getPaymentConfirmationMessage(),
					expectedAssertionsProp.getProperty("billpayment.complete"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the BankingOpearationsTest" + e.getMessage());
			logger.error("Error occured while testing the BankingOpearationsTest", e);
		}

		logger.info("Ending of testVerifyBillPayment Method ");
	}

	/**
	 * Verifies the functionality of requesting a loan.
	 * 
	 * <p>
	 * This test ensures that users can submit a loan request with valid details,
	 * and the system processes the request, providing appropriate responses.
	 * 
	 * @throws InterruptedException if interrupted during execution
	 */
	@Test(priority = 3, description = "Verify Request loan functionality")
	@Description("This test verifies the functionality of requesting a loan. It ensures that the user can successfully submit a loan request with valid details, and the system processes the request, providing an approval or rejection response as expected.")
	@Severity(SeverityLevel.CRITICAL)
	public void testVerifyRequestLoan() throws InterruptedException {

		logger.info("Starting of testVerifyRequestLoan Method ");
		try {

			this.bankingOpearationsPage.clickOnRequestLoan();
			;

			// Verifying the Request Loan Header
			assertEquals(this.bankingOpearationsPage.getBillPayHeader(),
					expectedAssertionsProp.getProperty("request.header"));

			// Performing actions to request loan from the account
			this.bankingOpearationsPage.setLoanAmount(testDataProp.getProperty("loan.amount"));
			this.bankingOpearationsPage.setDownPayment(testDataProp.getProperty("downpayment"));
			this.bankingOpearationsPage.selectRequestLoanFromAccount();
			this.bankingOpearationsPage.clickOnApplyNow();

			// Verifying whether the Request loan is approved or not.
			assertEquals(this.bankingOpearationsPage.getLoanConfirmationMessage(),
					expectedAssertionsProp.getProperty("loan.success"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the BankingOpearationsTest" + e.getMessage());
			logger.error("Error occured while testing the BankingOpearationsTest", e);
		}

		logger.info("Ending of testVerifyRequestLoan Method ");
	}

	/**
	 * Verifies the functionality of filtering transactions by amount, date, or
	 * type.
	 * 
	 * <p>
	 * This test ensures that users can search and retrieve transactions based on
	 * specified filters and validates the correctness of the transaction history.
	 * 
	 * @throws InterruptedException if interrupted during execution
	 */
	@Test(priority = 4, description = "Verify Find transactions by amount/date/type")
	@Description("This test verifies the functionality of the 'Find Transactions' feature."
			+ "It ensures that users can search and retrieve transaction details based on specified criteria such as amount, date, and type."
			+ "The test validates that the results displayed in the transaction history match the given filters.")
	@Severity(SeverityLevel.CRITICAL)
	public void testVerifyTransactionsFilteredByAmountDateOrType() throws InterruptedException {

		logger.info("Starting of testVerifyTransactionsFilteredByAmountDateOrType Method ");
		try {

			this.bankingOpearationsPage.clickOnFindTransactions();

			// Verifying the Find Transactions Header
			assertEquals(this.bankingOpearationsPage.getFindTransactionsHeader(),
					expectedAssertionsProp.getProperty("findTransactions.header"));

			// Performing actions to see the Transactions by date
			this.bankingOpearationsPage.findTransactionsByDate(testDataProp.getProperty("findby.date"));

			// Verifying whether the Transactions result shown or not.
			assertEquals(this.bankingOpearationsPage.getTransactionsResultMessage(),expectedAssertionsProp.getProperty("transaction.success"));

			this.bankingOpearationsPage.clickOnFirstTransaction();

			// Verifying whether the Transactions detail shown or not.
			assertEquals(this.bankingOpearationsPage.getTransactionsDetailsMessage(),expectedAssertionsProp.getProperty("transaction.details"));

			this.bankingOpearationsPage.clickOnFindTransactions();

			// Performing actions to see the Transactions by Amount
			this.bankingOpearationsPage.findTransactionsByAmount(testDataProp.getProperty("findby.amount"));

			// Verifying whether the Transactions result shown or not.
			assertEquals(this.bankingOpearationsPage.getTransactionsResultMessage(),expectedAssertionsProp.getProperty("transaction.success"));

			this.bankingOpearationsPage.clickOnFirstTransaction();

			// Verifying whether the Transactions detail shown or not.
			assertEquals(this.bankingOpearationsPage.getTransactionsDetailsMessage(),expectedAssertionsProp.getProperty("transaction.details"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the BankingOpearationsTest" + e.getMessage());
			logger.error("Error occured while testing the BankingOpearationsTest", e);
		}

		logger.info("Ending of testVerifyTransactionsFilteredByAmountDateOrType Method ");
	}

	/**
	 * Quits the WebDriver instance after each test method.
	 */
	@AfterMethod
	public void quitDriver() {

		logger.info("Starting of quitDriver method in BankingOpearationsTest");

		quitWebDriver();

		logger.info("Ending of quitDriver method in BankingOpearationsTest");
	}

}
