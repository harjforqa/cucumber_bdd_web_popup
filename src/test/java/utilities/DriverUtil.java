package utilities;


import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class DriverUtil {

    static Class<DriverUtil> currentClassName = DriverUtil.class;

    public static WebDriver driver = null;

    //setter method for WebDriver
    public static void invokeDriver() throws IOException {

        switch (GetArgumentUtil.getBrowser().toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("incognito", "--start-maximized", "--disable-gpu", "--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--window-size=1920,1080"); //"-headless"
                driver = new FirefoxDriver();
                break;
            default:
                LogUtil.error(currentClassName, "Invalid browser name");
                assert false;
        }
    }

    //getter method for WebDriver
    public static WebDriver getDriver() {
        return driver;
    }

    //quit driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        } else {
            LogUtil.info(currentClassName, "driver is already closed");
        }
    }

    //capture screenshot
    public static void takeScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) DriverUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }

}
