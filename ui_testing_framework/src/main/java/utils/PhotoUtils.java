package utils;

import driverManager.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PhotoUtils {
    private static final WebDriver driver = DriverFactory.getDriverThread();
    private static final Path path = Path.of("target/screenshots");

    public static ByteArrayInputStream takeScreenshot(String fileName) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            Files.createDirectories(path);
            Files.write(Path.of("target/screenshots/" + fileName + ".png"), screenshot);
        } catch (IOException ignored) {
        }
        return new ByteArrayInputStream(screenshot);
    }
}
