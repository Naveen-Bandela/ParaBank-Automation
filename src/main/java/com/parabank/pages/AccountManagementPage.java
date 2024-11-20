package com.parabank.pages;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * AccountManagementPage class handles interactions with the account management
 * features of the application. It extends the BasePage class and provides
 * methods to perform actions like opening a new account, viewing account
 * overview, and managing account details.
 */
public class AccountManagementPage extends BasePage {

	// Logger instance for logging debug and info messages.
	private static final Logger logger = Logger.getLogger(AccountManagementPage.class.getName());

	// Web elements defined using @FindBy annotation for easy access and
	// maintenance.
	@FindBy(xpath = "//div[@id='leftPanel']//li[1]/a")
	private WebElement lnkOpenNewAccount;

	@FindBy(xpath = "//div[@id='openAccountForm']//h1")
	private WebElement headerOpenNewAccount;

	@FindBy(xpath = "//select[@id='type']")
	private WebElement drpAccountType;

	@FindBy(xpath = "//select[@id='fromAccountId']")
	private WebElement drpExistingAccount;

	@FindBy(xpath = "//div[@id='rightPanel']//input[@class='button']")
	private WebElement btnOpenNewAccount;

	@FindBy(xpath = "//div[@id='openAccountResult']//p")
	private WebElement msgCongratulations;

	@FindBy(xpath = "//table[@id='accountTable']//tbody//tr//td")
	private WebElement tdAccountNumber;

	@FindBy(xpath = "//div[@id='leftPanel']//li[2]/a")
	private WebElement lnkAccountOverview;

	@FindBy(xpath = "//div[@id='rightPanel']//h1")
	private WebElement headerAccountOverview;

	@FindBy(xpath = "//table[@id='accountTable']//td[2]")
	private WebElement accountBalance;

	@FindBy(xpath = "//table[@id='accountTable']//td[1]/a")
	private WebElement firstAccountLink;

	/**
	 * Constructor to initialize the WebDriver and web elements of the Account
	 * Management page.
	 * 
	 * @param driver The WebDriver instance passed from the test class.
	 */
	public AccountManagementPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of AccountManagementPage");
		logger.info("Ending of AccountManagementPage");
	}

	/**
	 * Opens the "Open New Account" page by clicking the corresponding link.
	 */
	public void openOpenNewAccount() {
		logger.info("Starting of openOpenNewAccount method");
		explicitWait(lnkOpenNewAccount);
		clickOnWebElement(lnkOpenNewAccount);
		logger.info("Ending of openOpenNewAccount method");
	}

	/**
	 * Retrieves the title of the "Open New Account" page.
	 * 
	 * @return The title text of the page.
	 */
	public String getOpenNewAccountTitle() {
		logger.info("Starting of getOpenNewAccountTitle method");
		explicitWait(headerOpenNewAccount);
		String title = this.headerOpenNewAccount.getText();
		logger.info("Ending of getOpenNewAccountTitle method");
		return title;
	}

	/**
	 * Selects an account type from the dropdown menu.
	 */
	public void selectTypeOfAccount() {
		logger.info("Starting of selectTypeOfAccount method");
		explicitWait(drpAccountType);
		Select selectAccountType = new Select(drpAccountType);
		selectAccountType.selectByIndex(1); // Hardcoded to select the second option.
		logger.info("Ending of selectTypeOfAccount method");
	}

	/**
	 * Selects an existing account from the dropdown menu.
	 */
	public void selectExistingAccount() {
		logger.info("Starting of selectExistingAccount method");
		explicitWait(drpExistingAccount);
		Select selectAccountType = new Select(drpExistingAccount);
		selectAccountType.selectByIndex(0); // Hardcoded to select the first option.
		logger.info("Ending of selectExistingAccount method");
	}

	/**
	 * Clicks the "Open New Account" button to submit the form.
	 */
	public void clickOnOpenNewAccount() {
		logger.info("Starting of clickOnOpenNewAccount method");
		explicitWait(btnOpenNewAccount);
		clickOnWebElement(btnOpenNewAccount);
		logger.info("Ending of clickOnOpenNewAccount method");
	}

	/**
	 * Retrieves the congratulations message displayed after successfully opening a
	 * new account.
	 * 
	 * @return The congratulations message text.
	 */
	public String getCongratulationsMessage() {
		logger.info("Starting of getCongratulationsMessage method");
		explicitWait(msgCongratulations);
		String message = this.msgCongratulations.getText();
		logger.info("Ending of getCongratulationsMessage method");
		return message;
	}

	/**
	 * Opens the "Accounts Overview" page by clicking the corresponding link.
	 */
	public void openAccountsOverview() {
		logger.info("Starting of openAccountsOverview method");
		explicitWait(lnkAccountOverview);
		clickOnWebElement(lnkAccountOverview);
		logger.info("Ending of openAccountsOverview method");
	}

	/**
	 * Retrieves the header text of the "Accounts Overview" page.
	 * 
	 * @return The header text of the page.
	 */
	public String getAccountOverviewHeader() {
		logger.info("Starting of getAccountOverviewHeader method");
		explicitWait(headerAccountOverview);
		String header = headerAccountOverview.getText();
		logger.info("Ending of getAccountOverviewHeader method");
		return header;
	}

	/**
	 * Retrieves the account balance displayed in the account table.
	 * 
	 * @return The account balance text.
	 */
	public String getAccountBalance() {
		logger.info("Starting of getAccountBalance method");
		explicitWait(accountBalance);
		String balance = accountBalance.getText();
		logger.info("Ending of getAccountBalance method");
		return balance;
	}

	/**
	 * Retrieves the account details header.
	 * 
	 * @return The account details text.
	 */

	public String getAccountDetailHeader() {
		logger.info("Starting of getAccountDetailHeader Method ");
		logger.info("Ending of getAccountDetailHeader Method ");
		explicitWait(headerAccountOverview);
		return headerAccountOverview.getText();

	}

	/**
	 * Views the transaction history of the first account in the account table.
	 */
	public void viewTransactionHistory() {
		logger.info("Starting of viewTransactionHistory Method ");

		explicitWait(firstAccountLink);
		clickOnWebElement(firstAccountLink);

		logger.info("Ending of viewTransactionHistory Method ");
	}

}
