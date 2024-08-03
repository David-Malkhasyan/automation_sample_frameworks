package pageObjects;


import driverManager.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    public final WebDriverWait wait, longWait, shortWait;
    protected final Actions action;
    protected final WebDriver driver = DriverFactory.getDriverThread();
    protected final JavascriptExecutor executor;
    protected final AjaxElementLocatorFactory factory;
    public Logger logger;


    public BasePage() {
        logger = LogManager.getLogger(this);
        PageFactory.initElements(driver, this);
        factory = new AjaxElementLocatorFactory(driver, 30);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        longWait = new WebDriverWait(driver, Duration.ofSeconds(250));
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        executor = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    public void fillField(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
            logger.info("Text is written: " + text);
        } catch (Exception e) {
            logger.error("SendKeys isn't performed. Exception message: " + e.getMessage());
            logger.error("Exception - " + e);
            throw (e);
        }
    }

    public void clearField(WebElement element, String logInfo) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            logger.info(logInfo);
        } catch (Exception e) {
            logger.error("clear isn't performed. Exception message: " + e.getMessage());
            logger.error("Exception - " + e);
            throw (e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            logger.info("Clicked on" + element);
        } catch (StaleElementReferenceException staleElementReferenceException) {
            longWait.until(ExpectedConditions.stalenessOf(element));
            element.click();
            logger.error("Exception - " + staleElementReferenceException);
        } catch (Exception e) {
            logger.error("Click on isn't performed.  Exception message: " + e.getMessage());
            logger.error("Exception - " + e);
            throw (e);
        }
    }

    public void clickOnElementByText(List<WebElement> elements, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
            elements.stream().filter(e -> e.getText().contains(text)).findFirst().get().click();
            logger.info("Clicked on " + text + " element");
        } catch (Exception e) {
            logger.error("Click on isn't performed.  Exception message: " + e.getMessage());
            logger.error("Exception - " + e);
            throw (e);
        }
    }

    public boolean isElementAvailableByText(List<WebElement> elements, String text) {
        try {
            for (WebElement element : elements)
                if (element.getText().contains(text)) {
                    logger.info("Element with " + text + " text is found");
                    return true;
                }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Element was not found.  Exception message: " + e.getMessage());
            logger.error("Exception - " + e);
            throw e;
        }
        return false;
    }

    public String getElementText(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            String text = element.getText();
            logger.info(text + "\ttext is returned");
            return text;
        } catch (Exception e) {
            logger.error("getElementText isn't performed.  Exception message: " + e.getMessage());
            logger.error("Exception - " + e);
            throw e;
        }
    }

    public List<String> getTextsListFromElements(List<WebElement> elements) {
        List<String> text = new ArrayList<>();
        for (WebElement element : elements) {
            text.add(element.getText());
        }
        return text;
    }

    public Boolean isElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info(element.toString() + " Element is visible");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(element.toString() + " Element is not visible");
            return false;
        }
    }

    public String alertGetText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        return alertText;
    }

    public void alertAccept() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void selectOption(WebElement selectElement, String value) {
        logger.info("Selecting option the " + value);
        Select select = new Select(selectElement);
        select.selectByVisibleText(value);
    }

    public Boolean isOptionSelected(WebElement selectElement, String value) {
        logger.info("Checking the " + value + " option is selected");
        Select select = new Select(selectElement);
        List<WebElement> selectedOptionList = select.getAllSelectedOptions();
        return selectedOptionList.stream().anyMatch(webElement -> getElementText(webElement).equals(value));
    }

    public List<String> getSelectedOptionList(WebElement selectElement) {
        logger.info("Get selected options");
        Select select = new Select(selectElement);
        List<WebElement> selectedOptionList = select.getAllSelectedOptions();
        return selectedOptionList.stream().map(WebElement::getText).toList();
    }

    public String getFirstSelectedOption(WebElement selectElement) {
        logger.info("Get selected option");
        return getSelectedOptionList(selectElement).get(0);
    }

    public String getTextFromInput(WebElement element) {
        return element.getAttribute("value");
    }
}
