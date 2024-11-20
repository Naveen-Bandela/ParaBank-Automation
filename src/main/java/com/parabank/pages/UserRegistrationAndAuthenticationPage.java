package com.parabank.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The UserRegistrationAndAuthenticationPage class represents the page object model (POM)
 * for user registration, login, and authentication-related operations in a web application.
 * 
 * This class provides methods to perform:
 * - User registration
 * - User login
 * - Logout
 * - Error handling during login
 * - Forgotten login information lookup
 * 
 * It extends the BasePage class to inherit common functionality.
 */
public class UserRegistrationAndAuthenticationPage extends BasePage {

	// Logger for logging information and debugging
	private static final Logger logger = Logger.getLogger(UserRegistrationAndAuthenticationPage.class.getName());

	// Web Elements for Registration
	@FindBy(xpath = "//div[@id='leftPanel']//p[2]/a")
	private WebElement lnkRegister;

	@FindBy(xpath = "//div[@id='rightPanel']//h1")
	private WebElement headerRegister;

	@FindBy(xpath = "//input[@id='customer.firstName']")
	private WebElement txtFirstName1;

	@FindBy(xpath = "//input[@id='customer.lastName']")
	private WebElement txtLastName1;

	@FindBy(xpath = "//input[@id='customer.address.street']")
	private WebElement txtAddress1;

	@FindBy(xpath = "//input[@id='customer.address.city']")
	private WebElement txtCity1;

	@FindBy(xpath = "//input[@id='customer.address.state']")
	private WebElement txtState1;

	@FindBy(xpath = "//input[@id='customer.address.zipCode']")
	private WebElement txtZipCode1;

	@FindBy(xpath = "//input[@id='customer.phoneNumber']")
	private WebElement txtPhoneNumber;

	@FindBy(xpath = "//input[@id='customer.ssn']")
	private WebElement txtSSN1;

	@FindBy(xpath = "//input[@id='customer.username']")
	private WebElement txtUserName;

	@FindBy(xpath = "//input[@id='customer.password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@id='repeatedPassword']")
	private WebElement txtConfirmPassword;

	@FindBy(xpath = "//form[@id='customerForm']//input[@class='button']")
	private WebElement btnRegister;
	
	@FindBy(xpath = "//div[@id='leftPanel']//li[8]/a")
	private WebElement lnkLogout;

	@FindBy(xpath = "//div[@id='rightPanel']//child::p")
	private WebElement welcomeMessage;

	// Web Elements for Login
	@FindBy(xpath = "//h2[text()='Customer Login']")
	private WebElement headerLogin;

	@FindBy(xpath = "//input[contains(@name,'username')]")
	private WebElement txtUsername;

	@FindBy(xpath = "//input[contains(@name,'password')]")
	private WebElement txtpassword;

	@FindBy(xpath = "//input[@class='button']")
	private WebElement btnLogin;

	@FindBy(xpath = "//b[text()='Welcome']//parent::p")
	private WebElement txtWelcome;

	@FindBy(xpath = "//div[@id='rightPanel']//child::p")
	private WebElement txtError;

	// Web Elements for Forgot Login Information
	@FindBy(xpath = "//div[@id='leftPanel']//p[1]/a")
	private WebElement lnkForogotLoginInfo;

	@FindBy(xpath = "//div[@id='rightPanel']//h1")
	private WebElement headerCustomerLookup;
	
	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement txtFirstName2;
	
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement txtLastName2;
	
	@FindBy(xpath = "//input[@id='address.street']")
	private WebElement txtAddress2;
	
	@FindBy(xpath = "//input[@id='address.city']")
	private WebElement txtCity2;
	
	@FindBy(xpath = "//input[@id='address.state']")
	private WebElement txtState2;
	
	@FindBy(xpath = "//input[@id='address.zipCode']")
	private WebElement txtZipCode2;
	
	@FindBy(xpath = "//input[@id='ssn']")
	private WebElement txtSSN2;
	
	@FindBy(xpath = "//form[@id='lookupForm']//input[@class='button']")
	private WebElement btnFindMyLoginInfo;
	
	@FindBy(xpath = "//div[@id='rightPanel']//child::p")
	private WebElement infoMessage;

	/**
     * Constructor for the UserRegistrationAndAuthenticationPage class.
     * 
     * @param driver WebDriver instance used to interact with the web page.
     */
	public UserRegistrationAndAuthenticationPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of UserRegistrationAndAuthenticationPage");
		logger.info("Ending of UserRegistrationAndAuthenticationPage");

	}
	
	/**
	 * Retrieves the title of the current page.
	 * 
	 * @return A string representing the page title.
	 */
	public String getTitleOfPage() {

		logger.info("Starting of getTitleOfPage Method");
		
		String title = driver.getTitle();	
		
		logger.info("Ending of getTitleOfPage Method");
		return title;
	}
	
	/**
	 * Navigates to the user registration page by clicking the "Register" link.
	 */

	public void clickOnRegister() {
		logger.info("Starting of clickOnRegister Method");

		explicitWait(lnkRegister);
		clickOnWebElement(lnkRegister);
		
		logger.info("Ending of clickOnRegister Method");
	}
	
	/**
	 * Retrieves the header text of the registration page.
	 * 
	 * @return A string representing the registration page header.
	 */

	public String getRegisterPageTitle() {
		logger.info("Starting of getRegisterPageTitle Method");

		explicitWait(headerRegister);
		String titleRegister = headerRegister.getText();
		
		logger.info("Ending of getRegisterPageTitle Method");
		return titleRegister;
	}

	/**
	 * Fills in the first name in the registration form.
	 * 
	 * @param firstName The first name of the user.
	 */
	public void setFirstName(String firstName) {
		logger.info("Starting of setFirstName Method");

		explicitWait(txtFirstName1);
		this.txtFirstName1.sendKeys(firstName);

		logger.info("Ending of setFirstName Method");

	}

	/**
	 * Fills in the last name in the registration form.
	 * 
	 * @param lastName The last name of the user.
	 */
	public void setLastName(String lastName) {
		logger.info("Starting of setLastName Method");

		explicitWait(txtLastName1);
		this.txtLastName1.sendKeys(lastName);

		logger.info("Ending of setLastName Method");

	}
	
	/**
	 * Fills in the address in the registration form.
	 * 
	 * @param address The address of the user.
	 */

	public void setAdress(String address) {
		logger.info("Starting of setAdress Method");

		explicitWait(txtAddress1);
		this.txtAddress1.sendKeys(address);

		logger.info("Ending of setAdress Method");

	}
	
	/**
	 * Fills in the city in the registration form.
	 * 
	 * @param city The city of the user.
	 */

	public void setCity(String city) {
		logger.info("Starting of setCity Method");

		explicitWait(txtCity1);
		this.txtCity1.sendKeys(city);

		logger.info("Ending of setCity Method");

	}
	
	/**
	 * Fills in the state in the registration form.
	 * 
	 * @param state The state of the user.
	 */

	public void setState(String state) {
		logger.info("Starting of setState Method");

		explicitWait(txtState1);
		this.txtState1.sendKeys(state);

		logger.info("Ending of setState Method");

	}
	/**
	 * Fills in the ZIP code in the registration form.
	 * 
	 * @param zipcode The ZIP code of the user.
	 */

	public void setZipCode(String zipcode) {
		logger.info("Starting of setZipCode Method");

		explicitWait(txtZipCode1);
		this.txtZipCode1.sendKeys(zipcode);

		logger.info("Ending of setZipCode Method");

	}
	/**
	 * Fills in the phone number in the registration form.
	 * 
	 * @param phoneNumber The phone number of the user.
	 */

	public void setPhoneNumber(String phoneNumber) {
		logger.info("Starting of setPhoneNumber Method");

		explicitWait(txtPhoneNumber);
		this.txtPhoneNumber.sendKeys(phoneNumber);

		logger.info("Ending of setPhoneNumber Method");

	}
	/**
	 * Fills in the SSN in the registration form.
	 * 
	 * @param SSN The SSN of the user.
	 */

	public void setSSN(String SSN) {
		logger.info("Starting of setSSN Method");

		explicitWait(txtSSN1);
		this.txtSSN1.sendKeys(SSN);

		logger.info("Ending of setSSN Method");

	}

	/**
	 * Fills in the username in the registration form.
	 * 
	 * @param userName The desired username for the account.
	 */
	public String setUserName(String userName) {
		logger.info("Starting of setUserName Method");

		explicitWait(txtUserName);
		this.txtUserName.sendKeys(userName);
		
		logger.info("Ending of setUserName Method");
		return userName;

	}
	
	/**
	 * Fills in the password in the registration form.
	 * 
	 * @param password The password for the account.
	 */

	public void setPassword(String password) {
		logger.info("Starting of setPassword Method");

		explicitWait(txtPassword);
		this.txtPassword.sendKeys(password);

		logger.info("Ending of setPassword Method");

	}
	
	/**
	 * Fills in the confirm password in the registration form.
	 * 
	 * @param confirmPassword The confirmation password.
	 */

	public void setConfirmPassword(String confirmPassword) {
		logger.info("Starting of setConfirmPassword Method");

		explicitWait(txtConfirmPassword);
		this.txtConfirmPassword.sendKeys(confirmPassword);

		logger.info("Ending of setConfirmPassword Method");

	}
	
	/**
	 * Clicks on the "Register" button to submit the registration form.
	 */

	public void clickOnRegisterButton() {
		logger.info("Starting of clickOnRegisterButton Method");

		explicitWait(btnRegister);
		clickOnWebElement(btnRegister);

		logger.info("Ending of clickOnRegisterButton Method");

	}

	/**
	 * Retrieves the success message displayed after registration.
	 * 
	 * @return A string representing the success message.
	 */
	public String getSuccessMessage() {
		logger.info("Starting of getSuccessMessage Method");

		explicitWait(welcomeMessage);
		String successMessage = this.welcomeMessage.getText();

		logger.info("Ending of getSuccessMessage Method");
		return successMessage;

	}
	
	/**
	 * Clicks on the "Logout" button to authenticate the user.
	 */
	public void clickOnLogout() {
		logger.info("Starting of clickOnLogout Method");

		explicitWait(lnkLogout);
		clickOnWebElement(lnkLogout);

		logger.info("Ending of clickOnLogout Method");

		
	}
	
	/**
	 * Fills in the username on the login page.
	 * 
	 * @param username The username of the account.
	 */
	public String getLoginTitle() {
		logger.info("Starting of getLoginTitle Method");	
		explicitWait(headerLogin);
		logger.info("Ending of getLoginTitle Method");
		return headerLogin.getText();
	}

	/**
	 * Fills in the username on the login page.
	 * 
	 * @param username The username of the account.
	 */
	public void setUsernameInLoginPage(String username) {
		logger.info("Starting of setUserName Method");
		
		explicitWait(txtUsername);
		this.txtUsername.sendKeys(username);

		logger.info("Ending of setUserName Method");

	}

	/**
	 * Fills in the password on the login page.
	 * 
	 * @param password The password of the account.
	 */
	public void setPasswordInLoginPage(String password) {
		logger.info("Starting of setUserName Method");
		
		explicitWait(txtpassword);
		this.txtpassword.sendKeys(password);

		logger.info("Ending of setUserName Method");

	}

	/**
	 * Clicks on the "Login" button to authenticate the user.
	 */
	public void clickOnLogin() {
		logger.info("Starting of clickOnLogin Method");

		explicitWait(btnLogin);
		clickOnWebElement(btnLogin);

		logger.info("Ending of clickOnLogin Method");

	}

	/**
	 * Retrieves the welcome message displayed after successful login.
	 * 
	 * @return A string representing the welcome message.
	 */
	public String getAccountholderName() {

		logger.info("Starting of clickOnLogin Method");

		explicitWait(txtWelcome);
		String welcomeMessage = txtWelcome.getText();
		
		logger.info("Ending of clickOnLogin Method");
		return welcomeMessage;

	}

	/**
	 * Retrieves the error message displayed after failed login attempts.
	 * 
	 * @return A string representing the error message.
	 */
	public String getErrorMessage() {
		logger.info("Starting of getErrorMessage Method");		
		explicitWait(txtError);
		logger.info("Ending of getErrorMessage Method");
		return   txtError.getText();
	}
	
	/**
	 * Navigates to the "Forgot Login Information" page by clicking the link.
	 */
	public void ClickOnForgotLoginInfo() {
		logger.info("Starting of ClickOnForgotLoginInfo Method");
		
		explicitWait(lnkForogotLoginInfo);
		clickOnWebElement(lnkForogotLoginInfo);
		
		logger.info("Ending of ClickOnForgotLoginInfo Method");
	}

	/**
	 * Retrieves the header text of the "Forgot Login Information" page.
	 * 
	 * @return A string representing the page header.
	 */
	
	public String getForgotLoginInfoHeader() {
		logger.info("Starting of getForgotLoginInfoHeader Method");

		explicitWait(headerCustomerLookup);
		String title = headerCustomerLookup.getText();
		
		logger.info("Ending of getForgotLoginInfoHeader Method");
		return title;
	}
	
	/**
	 * Fills in the first name for account validation.
	 * 
	 * @param firstName The first name of the user.
	 */
	
	public void setFirstNameToValidateAccount(String firstName) {
		logger.info("Starting of setFirstNameToValidateAccount Method");
		
		explicitWait(txtFirstName2);
		this.txtFirstName2.sendKeys(firstName);
		
		logger.info("Ending of setFirstNameToValidateAccount Method");
		
	}
	
	/**
	 * Fills in the last name for account validation.
	 * 
	 * @param lastName The last name of the user.
	 */
	
	public void setLastNameToValidateAccount(String LastName) {
		logger.info("Starting of setLastNameToValidateAccount Method");
		
		explicitWait(txtLastName2);
		this.txtLastName2.sendKeys(LastName);
		
		logger.info("Ending of setLastNameToValidateAccount Method");
		
	}
	
	/**
	 * Fills in the address for account validation.
	 * 
	 * @param address The address of the user.
	 */
	
	public void setAddressToValidateAccount(String address) {
		logger.info("Starting of setAddressToValidateAccount Method");
		
		explicitWait(txtAddress2);
		this.txtAddress2.sendKeys(address);
		
		logger.info("Ending of setAddressToValidateAccount Method");		
	}
	
	
	/**
	 * Sets the city value in the text field used for account validation.
	 * 
	 * @param city the city name to be entered
	 */
	public void setCityToValidateAccount(String city) {
		logger.info("Starting of setCityToValidateAccount Method");
		
		explicitWait(txtCity2);
		this.txtCity2.sendKeys(city);
		
		logger.info("Ending of setCityToValidateAccount Method");		
	}
	
	/**
	 * Sets the state value in the text field used for account validation.
	 * 
	 * @param state the state name to be entered
	 */
	
	public void setStateToValidateAccount(String state) {
		logger.info("Starting of setStateToValidateAccount Method");
		
		explicitWait(txtState2);
		this.txtState2.sendKeys(state);
		
		logger.info("Ending of setStateToValidateAccount Method");		
	}
	
	/**
	 * Sets the ZIP code value in the text field used for account validation.
	 * 
	 * @param zipcode the ZIP code to be entered
	 */
	public void setZipcodeToValidateAccount(String zipcode) {
		logger.info("Starting of setZipcodeToValidateAccount Method");
		
		explicitWait(txtZipCode2);
		this.txtZipCode2.sendKeys(zipcode);
		
		logger.info("Ending of setZipcodeToValidateAccount Method");		
	}
	
	/**
	 * Sets the SSN value in the text field used for account validation.
	 * 
	 * @param SSN the Social Security Number to be entered
	 */
	
	public void setSSNToValidateAccount(String SSN) {
		logger.info("Starting of setSSNToValidateAccount Method");
		
		explicitWait(txtSSN2);
		this.txtSSN2.sendKeys(SSN);
		
		logger.info("Ending of setSSNToValidateAccount Method");		
	}
	
	/**
	 * Clicks the "Find My Login Info" button.
	 */
	public void clickOnFindMyLoginInfo() {
		
		logger.info("Starting of clickOnFindMyLoginInfo Method");
		
		explicitWait(btnFindMyLoginInfo);
		clickOnWebElement(btnFindMyLoginInfo);
		
		logger.info("Ending of clickOnFindMyLoginInfo Method");
		
	}
	
	/**
	 * Retrieves the customer lookup success message displayed on the UI.
	 * 
	 * @return a {@code String} containing the success message
	 */
	public String getCustomerLookupSucessMessage() {
		
		logger.info("Starting of getCustomerLookupSucessMessage Method");
		
		explicitWait(infoMessage);
		String successMessage = this.infoMessage.getText();
		
		logger.info("Ending of getCustomerLookupSucessMessage Method");
		return successMessage; 
	}

}
