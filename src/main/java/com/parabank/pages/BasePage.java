package com.parabank.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage class provides utility methods to interact with web elements using Selenium.
 * It serves as a parent class for other page classes in the automation framework.
 * 
 * This class includes methods for explicit waits, element interactions, scrolling, 
 * and dropdown selections. Logging is integrated using Apache Log4j for better traceability.
 */
public class BasePage {

    // Instance of WebDriver to perform actions on the browser.
    WebDriver driver = null;

    // Logger instance to log messages for debugging and tracking.
    private static final Logger logger = Logger.getLogger(BasePage.class.getName());

    /**
     * Constructor to initialize the WebDriver and PageFactory elements.
     * 
     * @param driver The WebDriver instance passed from the test or parent class.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits until a specified web element is visible on the page.
     * 
     * @param element The WebElement to wait for.
     */
    public void explicitWait(WebElement element) {
        logger.info("Starting of explicitWait method in BasePage");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("Ending of explicitWait method in BasePage");
    }

    /**
     * Waits until all specified web elements are visible on the page.
     * 
     * @param categoryOptions A list of WebElements to wait for.
     */
    public void explicitWaitList(List<WebElement> categoryOptions) {
        logger.info("Starting of explicitWait method");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElements(categoryOptions));
        logger.info("Ending of explicitWait method");
    }

    /**
     * Clicks on the specified web element.
     * 
     * @param element The WebElement to be clicked.
     */
    public void clickOnWebElement(WebElement element) {
        logger.info("Starting of clickOnWebElement method in BasePage");
        element.click();
        logger.info("Ending of clickOnWebElement method in BasePage");
    }

    /**
     * Scrolls the browser window vertically by a specified pixel value.
     * 
     * @param scroll The number of pixels to scroll down (positive value) or up (negative value).
     */
    public void scrollDown(int scroll) {
        logger.info("Starting of scrollDown method");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + scroll + ")");
        logger.info("Ending of scrollDown method");
    }

    /**
     * Selects an option from a dropdown menu by its index.
     * 
     * @param element The dropdown WebElement.
     * @param value The value to select (not used currently; only selects by index 1).
     */
    public void selectOptions(WebElement element, String value) {
        logger.info("Starting of selectOptions method");
        Select select = new Select(element);
        select.selectByIndex(1); // Hardcoded to select index 1; modify if needed for dynamic selection.
        logger.info("Ending of selectOptions method");
    }
}