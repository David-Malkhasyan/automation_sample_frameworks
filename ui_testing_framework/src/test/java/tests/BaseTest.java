package tests;


import driverManager.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testData.expectedResultsData.MainTestDataExpected;
import testData.inputData.MainTestData;
import utils.Configurations;
import utils.FileHelper;
import utils.JsonParser;

import static driverManager.DriverFactory.removeDriverThread;
import static utils.Configurations.BASE_URL;
import static utils.PhotoUtils.takeScreenshot;


public class BaseTest {
    public static MainTestData mainTestData;
    public static MainTestDataExpected mainTestDataExpected;
    protected WebDriver driver = DriverFactory.getDriverThread();
    protected HomePage homePage;
    protected Logger logger;
    protected LoginPage loginPage;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        logger = LogManager.getLogger(this);
        logger.info("WebDriver for creation" + Configurations.BROWSER + "browser started");
        new DriverFactory().setUpDriver(Configurations.BROWSER);
        logger.info("WebDriver for creation" + Configurations.BROWSER + "browser created");
        driver = DriverFactory.getDriverThread();
        softAssert = new SoftAssert();
        driver.get(BASE_URL);
        logger.info("Test data deserialization");
        generateTestData();
        logger.info("Test data is deserialized");
        pageInit();
    }

    @AfterMethod
    public void quitDriver(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Allure.addAttachment(result.getName(), takeScreenshot(result.getName()));
        }
        FileHelper.addLogsToAllure();
        logger.info("Closing App");
        logger.info("Quitting Driver");
        driver.quit();
        logger.info("Removing Driver Thread");
        removeDriverThread();
    }

    protected void sleep(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//----------------------------------------------------------------------
//----------------------------Helper------------------------------------
//----------------------------------------------------------------------

    public void pageInit() {
        logger.info("Pages initialization started");
        homePage = new HomePage();
        loginPage = new LoginPage();
        logger.info("Pages initialization finished");
    }

    public void generateTestData() {
        mainTestData = JsonParser.deserializeJsonFile(MainTestData.mainTestDataJsonPath, MainTestData.class);
        mainTestDataExpected = JsonParser.deserializeJsonFile(MainTestDataExpected.mainTestDataJsonPath, MainTestDataExpected.class);
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public void generateEndedScreenshot(String testName) {
        Allure.attachment(testName + System.currentTimeMillis(), takeScreenshot(testName + System.currentTimeMillis()));
    }
}
