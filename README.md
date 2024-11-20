# ParaBank Web Application Automation Framework
* Project to run UI automation tests for the ParaBank web application using the POM TestNG framework.

## Introduction:
* Welcome to the documentation for the ParaBank-Automation framework, a robust and flexible solution for automating the testing of the ParaBank web application (https://parabank.parasoft.com/). This guide will help you get started with the TestNG framework, understand its core concepts, and leverage its features to test ParaBank effectively.

## Project Overview:
- Total Testcases: 10
- Introduction to ParaBank App
- ParaBank is a sample banking application, widely used for testing and automation practices. It offers functionalities such as user registration, login, account management, and transaction capabilities, making it a great tool for practicing and testing web automation.

## Tool and Language Selection:
- Language Used: Java (JDK v17.0 and above)
- Tool Used: Selenium WebDriver (v4.12 and above)
- Test Framework: TestNG

## Framework Selection:
- POM TestNG framework is used to separate the page object model (locators) from the test logic. All the locators are stored in the Page classes, and the executable test scripts are in the Test classes.

## Framework Creation:
- Create a simple Maven project.
- Add necessary dependencies for Selenium WebDriver, TestNG, Allure, Webdriver Manager, and other tools like Log4j
- Save and update the Maven project to ensure all dependencies are included.

## Folder Structure:
- Base Package: Contains class files to select the browser, and initialize WebDriver.
- pages: Contains class file that are stored the xpath and methods to perform certain actions on web elements.
- Tests: Contains class file that are performing actions by using page class to perform operation on the web pages
- Listeners: Contains class files to manage reporting (e.g., Allure Report).
- Utils Package: Contains utility class files with reusable methods for test scripts.

## Framework Details:
- Property Files: To store the testdata and expectedresult data. (e.g., src/main/resources/properties )
- Screenshots: Screenshots are captured at the end of each test case execution. (Saved in TestReports/screenshots)
- Allure Reports: The framework uses Allure reports for test reporting. (Report stored in allure-results folder 📂)

## Test Script Design:
- Page Object Model (POM): Locators are stored in Page classes using the By class with variable names.
- Test Methods: Test scripts are designed using @Test annotations for each test case.
- @BeforeMethod and @AfterMethod: Used to define pre-requisite and post-requisite steps for each test.

## Test Data Management:
- Test data is managed via properties file from there to utils package. Ensure the necessary data is available in the application before running the test scripts.

## Test Execution Plan:
- Individual Test Execution: Tests can be executed individually by module.
- Headed Mode: Test scripts can be executed in headed mode
- Reporting:
Allure Reports: The primary reporting tool in this framework is AllureReports. Access the report from the TestReports/TestExecutionReport.html file.
To see the allure result. Please download the project and navigate to the allure-reports folder and open command prompt on windows
Please Enter this command: **allure serve allure-results**
- The report includes details such as AccountManagementPage, UserRegistrationAndAuthenticationPage, and BankingOperationsPage.
- It captures screenshots for each test case (both pass and fail) and provides failure reasons.

## Automation Scripts:
- Repository: Automation scripts are stored in a GitHub repository.
- Web App Automation Scripts: GitHub Repository Link
- Test Execution: Test scripts can be executed using the TestNG execution XML (testng.xml).

## Test Maintenance:
- Page Files: Page object model files should be updated if there are any changes in the locator values or application UI structure.

## Risks and Mitigations:
- Test Data Validation: Verify the availability of test data in the application before executing the test scripts.
- Test Failures: Test failures are usually due to changes in the application behavior or attribute changes. Ensure proper maintenance of the locators and test data.
