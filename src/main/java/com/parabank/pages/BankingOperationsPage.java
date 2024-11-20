package com.parabank.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * The BankingOperationsPage class represents the page object model (POM) for
 * handling banking operations within a web application. This class extends the
 * BasePage to inherit common functionality and provides methods to interact
 * with and verify the behavior of various banking operation features, including
 * transferring funds, paying bills, requesting loans, and finding transactions.
 * 
 * Features Supported: - Transfer Funds - Bill Payment - Loan Requests -
 * Transaction Search
 * 
 * Logging is included in all methods to provide traceability and debugging
 * support.
 * 
 * Author: [Bandela Naveen]
 */
public class BankingOperationsPage extends BasePage {

	// Logger for logging information and debugging
	private static final Logger logger = Logger.getLogger(BankingOperationsPage.class.getName());

	// Web Elements for Transfer Funds
	@FindBy(xpath = "//div[@id='leftPanel']//li[3]/a")
	private WebElement lnkTransferFunds;

	@FindBy(xpath = "//div[@id='rightPanel']//h1[@class='title']")
	private WebElement headerTransferFunds;

	@FindBy(xpath = "//input[@id='amount']")
	private WebElement txtAmount;

	@FindBy(xpath = "//select[@id='fromAccountId']")
	private WebElement drpFromAccount;

	@FindBy(xpath = "//select[@id='toAccountId']")
	private WebElement drpToAccount;

	@FindBy(xpath = "//input[@class='button']")
	private WebElement btnTransfer;

	@FindBy(xpath = "//div[@id='showResult']//h1")
	private WebElement msgTransferConfirmation;

	// Web Elements for Bill Payment
	@FindBy(xpath = "//div[@id='leftPanel']//li[4]/a")
	private WebElement lnkBillPay;

	@FindBy(xpath = "//input[@name='payee.name']")
	private WebElement txtPayeeName;

	@FindBy(xpath = "//input[@name='payee.address.street']")
	private WebElement txtAddress;

	@FindBy(xpath = "//input[@name='payee.address.city']")
	private WebElement txtPayeeCity;

	@FindBy(xpath = "//input[@name='payee.address.state']")
	private WebElement txtPayeeState;

	@FindBy(xpath = "//input[@name='payee.address.zipCode']")
	private WebElement txtPayeeZipCode;

	@FindBy(xpath = "//input[@name='payee.phoneNumber']")
	private WebElement txtPayeePhoneNumber;

	@FindBy(xpath = "//input[@name='payee.accountNumber']")
	private WebElement txtPayeeAccountNumber;

	@FindBy(xpath = "//input[@name='verifyAccount']")
	private WebElement txtVerifyAccount;

	@FindBy(xpath = "//input[@name='amount']")
	private WebElement txtamount;

	@FindBy(xpath = "//select[@name='fromAccountId']")
	private WebElement drpFromaccount;

	@FindBy(xpath = "//input[@class='button']")
	private WebElement btnSendPayment;

	@FindBy(xpath = "//div[@id='billpayResult']//h1")
	private WebElement msgBillPaymentConfirmation;

	// Web Elements for Loan Request
	@FindBy(xpath = "//div[@id='leftPanel']//li[7]/a")
	private WebElement lnkRequestLoan;

	@FindBy(xpath = "//input[@id='amount']")
	private WebElement txtLoanAmount;

	@FindBy(xpath = "//input[@id='downPayment']")
	private WebElement txtDownPayment;

	@FindBy(xpath = "//input[@class='button']")
	private WebElement btnApplyNow;

	@FindBy(xpath = "(//div[@id='loanRequestApproved']//p)[1]")
	private WebElement msgLoanConfirmation;

	// Web Elements for Finding Transactions
	@FindBy(xpath = "//div[@id='leftPanel']//li[5]/a")
	private WebElement lnkFindTransactions;

	@FindBy(xpath = "//input[@id='transactionDate']")
	private WebElement txtFindByDate;

	@FindBy(xpath = "//button[@id='findByDate']")
	private WebElement btnFindTransactions1;

	@FindBy(xpath = "//div[@id='resultContainer']//h1")
	private WebElement headerTransactionResults;

	@FindBy(xpath = "//input[@id='amount']")
	private WebElement txtFindByAmount;

	@FindBy(xpath = "//button[@id='findByAmount']")
	private WebElement btnFindTransactions2;

	@FindBy(xpath = "//tbody[@id='transactionBody']//td[2]//a")
	private WebElement firstTransaction;

	@FindBy(xpath = "//div[@id='rightPanel']//h1")
	private WebElement headerTransactionDetails;

	/**
	 * Constructor for the BankingOperationsPage class.
	 * 
	 * @param driver WebDriver instance used to interact with the web page.
	 */

	public BankingOperationsPage(WebDriver driver) {
		super(driver);

		logger.info("Starting of BankingOperationsPage");
		logger.info("Ending of BankingOperationsPage");
	}

	/**
	 * Clicks on the "Transfer Funds" link in the left panel to navigate to the
	 * transfer funds page.
	 */
	public void clickOnTransferFund() {
		logger.info("Starting of clickOnTransferFund Method");

		explicitWait(lnkTransferFunds);
		clickOnWebElement(lnkTransferFunds);

		logger.info("Ending of clickOnTransferFund Method");
	}

	/**
	 * Retrieves the header text of the Transfer Funds page.
	 * 
	 * @return A string representing the header text.
	 */

	public String getTransferFundHeader() {
		logger.info("Starting of getTransferFundHeader Method");
		logger.info("Ending of getTransferFundHeader Method");
		explicitWait(headerTransferFunds);
		return headerTransferFunds.getText();

	}

	/**
	 * Enters the amount to be transferred into the amount input field.
	 * 
	 * @param amount The amount to be transferred.
	 */

	public void setAmount(String amount) {

		logger.info("Starting of setAmount Method");
		explicitWait(txtAmount);
		this.txtAmount.sendKeys(amount);

		logger.info("Ending of setAmount Method");

	}

	/**
	 * Selects the "From Account" from the dropdown list. Defaults to the first
	 * account in the dropdown.
	 */

	public void selectFromAccount() {
		logger.info("Starting of selectFromAccount Method");
		explicitWait(drpFromAccount);
		Select select = new Select(drpFromAccount);
		select.selectByIndex(0);

		logger.info("Ending of selectFromAccount Method");
	}

	/**
	 * Selects the "To Account" from the dropdown list. Defaults to the second
	 * account in the dropdown.
	 */

	public void selectToAccount() {
		logger.info("Starting of selectToAccount Method");

		explicitWait(drpToAccount);
		Select select = new Select(drpToAccount);
		select.selectByIndex(1);

		logger.info("Ending of selectToAccount Method");
	}

	/**
	 * Clicks on the "Transfer" button to initiate the funds transfer.
	 */

	public void clickOnTransfer() {
		logger.info("Starting of clickOnTransfer Method");

		explicitWait(btnTransfer);
		clickOnWebElement(btnTransfer);

		logger.info("Ending of clickOnTransfer Method");

	}

	/**
	 * Retrieves the confirmation message displayed after a successful fund
	 * transfer.
	 * 
	 * @return A string representing the confirmation message.
	 */

	public String getTransferConfirmationMessage() {
		logger.info("Starting of getTransferConfirmationMessage Method");
		logger.info("Ending of getTransferConfirmationMessage Method");

		explicitWait(msgTransferConfirmation);
		return msgTransferConfirmation.getText();
	}

	/**
	 * Clicks on the "Bill Pay" link in the left panel to navigate to the bill
	 * payment page.
	 */

	public void clickOnBillPay() {
		logger.info("Starting of clickOnBillPay Method");

		explicitWait(lnkBillPay);
		clickOnWebElement(lnkBillPay);

		logger.info("Ending of clickOnBillPay Method");

	}

	/**
	 * Retrieves the header text of the Bill Pay page.
	 * 
	 * @return A string representing the header text.
	 */

	public String getBillPayHeader() {
		logger.info("Starting of getBillPayHeader Method");
		logger.info("Ending of getBillPayHeader Method");

		explicitWait(headerTransferFunds);
		return headerTransferFunds.getText();
	}

	/**
	 * Enters the name of the payee into the corresponding input field.
	 * 
	 * @param name The name of the payee.
	 */
	public void setPayneeName(String name) {
		logger.info("Starting of setPayneeName Method");

		explicitWait(txtPayeeName);
		txtPayeeName.sendKeys(name);

		logger.info("Ending of setPayneeName Method");

	}

	/**
	 * Enters the address of the payee into the corresponding input field.
	 * 
	 * @param address The address of the payee.
	 */

	public void setAddress(String address) {
		logger.info("Starting of setAddress Method");

		explicitWait(txtAddress);
		txtAddress.sendKeys(address);

		logger.info("Ending of setAddress Method");

	}

	/**
	 * Enters the city of the payee into the corresponding input field.
	 * 
	 * @param city The city of the payee.
	 */
	public void setCity(String city) {
		logger.info("Starting of setCity Method");

		explicitWait(txtPayeeCity);
		txtPayeeCity.sendKeys(city);
		logger.info("Ending of setCity Method");

	}

	/**
	 * Enters the state of the payee into the corresponding input field.
	 * 
	 * @param state The state of the payee.
	 */

	public void setState(String state) {
		logger.info("Starting of setState Method");

		explicitWait(txtPayeeState);
		txtPayeeState.sendKeys(state);
		logger.info("Ending of setState Method");

	}

	/**
	 * Enters the ZIP code of the payee into the corresponding input field.
	 * 
	 * @param zipcode The ZIP code of the payee.
	 */
	public void setZipcode(String zipcode) {
		logger.info("Starting of setZipcode Method");

		explicitWait(txtPayeeZipCode);
		txtPayeeZipCode.sendKeys(zipcode);

		logger.info("Ending of setZipcode Method");
	}

	/**
	 * Enters the phone number of the payee into the corresponding input field.
	 * 
	 * @param phoneNumber The phone number of the payee.
	 */
	public void setPhoneNumber(String phoneNumber) {
		logger.info("Starting of setPhoneNumber Method");

		explicitWait(txtPayeePhoneNumber);
		txtPayeePhoneNumber.sendKeys(phoneNumber);

		logger.info("Ending of setPhoneNumber Method");
	}

	/**
	 * Enters the payee's account number into the corresponding input field.
	 * 
	 * @param account The account number of the payee.
	 */

	public void setAccount(String account) {
		logger.info("Starting of setAccount Method");

		explicitWait(txtPayeeAccountNumber);
		txtPayeeAccountNumber.sendKeys(account);

		logger.info("Ending of setAccount Method");
	}

	/**
	 * Enters the account number for verification purposes into the corresponding
	 * input field.
	 * 
	 * @param verifyAccount The verification account number.
	 */
	public void setVerifyAccount(String verifyAccount) {
		logger.info("Starting of setVerifyAccount Method");

		explicitWait(txtVerifyAccount);
		txtVerifyAccount.sendKeys(verifyAccount);

		logger.info("Ending of setVerifyAccount Method");
	}

	/**
	 * Enters the amount for the bill payment into the corresponding input field.
	 * 
	 * @param amount The amount for the bill payment.
	 */

	public void setBillPayAmount(String amount) {
		logger.info("Starting of setBillPayAmount Method");

		explicitWait(txtamount);
		txtamount.sendKeys(amount);

		logger.info("Ending of setBillPayAmount Method");
	}

	/**
	 * Selects the "From Account" from the dropdown list for bill payment. Defaults
	 * to the first account in the dropdown.
	 */

	public void selectBillPayFromAccount() {
		logger.info("Starting of selectBillPayFromAccount Method");

		Select selectFromAccount = new Select(drpFromaccount);
		selectFromAccount.selectByIndex(0);

		logger.info("Ending of selectBillPayFromAccount Method");

	}

	/**
	 * Clicks on the "Send Payment" button to initiate the bill payment.
	 */

	public void clickOnSendPayment() {
		logger.info("Starting of clickOnSendPayment Method");

		clickOnWebElement(btnSendPayment);

		logger.info("Ending of clickOnSendPayment Method");
	}

	/**
	 * Retrieves the confirmation message displayed after a successful bill payment.
	 * 
	 * @return A string representing the confirmation message.
	 */
	public String getPaymentConfirmationMessage() {
		logger.info("Starting of getPaymentConfirmationMessage Method");

		logger.info("Ending of getPaymentConfirmationMessage Method");

		explicitWait(msgBillPaymentConfirmation);
		return msgBillPaymentConfirmation.getText();
	}

	/**
	 * Clicks on the "Request Loan" link in the left panel to navigate to the loan
	 * request page.
	 */

	public void clickOnRequestLoan() {
		logger.info("Starting of clickOnRequestLoan Method");

		explicitWait(lnkRequestLoan);
		clickOnWebElement(lnkRequestLoan);

		logger.info("Ending of clickOnRequestLoan Method");

	}

	/**
	 * Retrieves the header text of the Request Loan page.
	 * 
	 * @return A string representing the header text.
	 */

	public String getRequestLoanHeader() {
		logger.info("Starting of getRequestLoanHeader Method");
		logger.info("Ending of getRequestLoanHeader Method");

		explicitWait(headerTransferFunds);
		return headerTransferFunds.getText();
	}

	/**
	 * Enters the loan amount into the corresponding input field.
	 * 
	 * @param loanAmount The amount of the loan to request.
	 */
	public void setLoanAmount(String loanAmount) {
		logger.info("Starting of setLoanAmount Method");

		explicitWait(txtLoanAmount);
		txtLoanAmount.sendKeys(loanAmount);

		logger.info("Ending of setLoanAmount Method");
	}

	/**
	 * Enters the down payment for the loan into the corresponding input field.
	 * 
	 * @param downPayment The down payment amount.
	 */

	public void setDownPayment(String downPayment) {
		logger.info("Starting of setDownPayment Method");

		explicitWait(txtDownPayment);
		txtDownPayment.sendKeys(downPayment);

		logger.info("Ending of setDownPayment Method");
	}

	/**
	 * Selects the "From Account" from the dropdown list for the loan request.
	 * Defaults to the first account in the dropdown.
	 */

	public void selectRequestLoanFromAccount() {
		logger.info("Starting of selectRequestLoanFromAccount Method");

		Select selectFromAccount = new Select(drpFromAccount);
		selectFromAccount.selectByIndex(0);

		logger.info("Ending of selectRequestLoanFromAccount Method");
	}

	/**
	 * Clicks on the "Apply Now" button to submit the loan application.
	 */
	public void clickOnApplyNow() {
		logger.info("Starting of clickOnApplyNow Method");

		explicitWait(btnApplyNow);
		clickOnWebElement(btnApplyNow);

		logger.info("Ending of clickOnApplyNow Method");

	}

	/**
	 * Retrieves the confirmation message displayed after a successful loan request.
	 * 
	 * @return A string representing the confirmation message.
	 */

	public String getLoanConfirmationMessage() {
		logger.info("Starting of getLoanConfirmationMessage Method");

		logger.info("Ending of getLoanConfirmationMessage Method");

		explicitWait(msgLoanConfirmation);
		return msgLoanConfirmation.getText();
	}

	/**
	 * Clicks on the "Find Transactions" link in the left panel to navigate to the
	 * transaction search page.
	 */

	public void clickOnFindTransactions() {
		logger.info("Starting of clickOnFindTransactions Method");

		explicitWait(lnkFindTransactions);
		clickOnWebElement(lnkFindTransactions);

		logger.info("Ending of clickOnFindTransactions Method");
	}

	/**
	 * Retrieves the header text of the Find Transactions page.
	 * 
	 * @return A string representing the header text.
	 */

	public String getFindTransactionsHeader() {
		logger.info("Starting of getFindTransactionsHeader Method");
		logger.info("Ending of getFindTransactionsHeader Method");

		explicitWait(headerTransferFunds);
		return headerTransferFunds.getText();
	}

	/**
	 * Searches for transactions by a specified date.
	 * 
	 * @param date The date to search for transactions (format: YYYY-MM-DD).
	 */

	public void findTransactionsByDate(String date) {
		logger.info("Starting of findTransactionsByDate Method");

		explicitWait(txtFindByDate);
		this.txtFindByDate.sendKeys(date);

		explicitWait(btnFindTransactions1);
		clickOnWebElement(btnFindTransactions1);

		logger.info("Ending of findTransactionsByDate Method");

	}

	/**
	 * Retrieves the result header text displayed after performing a transaction
	 * search.
	 * 
	 * @return A string representing the search result header.
	 */
	public String getTransactionsResultMessage() {
		logger.info("Starting of getTransactionsResultMessage Method");

		logger.info("Ending of getTransactionsResultMessage Method");

		explicitWait(headerTransactionResults);
		return headerTransactionResults.getText();

	}

	/**
	 * Clicks on the first transaction in the transaction list to view its details.
	 */

	public void clickOnFirstTransaction() {
		logger.info("Starting of clickOnFirstTransaction Method");

		explicitWait(firstTransaction);
		clickOnWebElement(firstTransaction);

		logger.info("Ending of clickOnFirstTransaction Method");

	}

	/**
	 * Retrieves the header text of the transaction details page.
	 * 
	 * @return A string representing the transaction details header.
	 */

	public String getTransactionsDetailsMessage() {
		logger.info("Starting of getTransactionsDetailsMessage Method");

		logger.info("Ending of getTransactionsDetailsMessage Method");

		explicitWait(headerTransactionDetails);
		return headerTransactionDetails.getText();

	}

	/**
	 * Searches for transactions by a specified amount.
	 * 
	 * @param amount The amount to search for transactions.
	 */

	public void findTransactionsByAmount(String amount) {
		logger.info("Starting of findTransactionsByAmount Method");

		explicitWait(txtFindByAmount);
		this.txtFindByAmount.sendKeys(amount);

		explicitWait(btnFindTransactions2);
		clickOnWebElement(btnFindTransactions2);

		logger.info("Ending of findTransactionsByAmount Method");

	}

}
