package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriverThread() {
        return driverThread.get();
    }

    public static void removeDriverThread() {
        driverThread.remove();
    }

    public void setUpDriver(String platformName) {
        switch (platformName) {
            case ("chrome") -> driverThread.set(new ChromeDriver());
            case ("firefox") -> driverThread.set(new FirefoxDriver());
        }
        driverThread.get().manage().window().maximize();
    }
}
