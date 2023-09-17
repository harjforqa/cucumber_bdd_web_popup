package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WrapperUtil extends DriverUtil {

    static Class<WrapperUtil> currentClassName = WrapperUtil.class;

    private static final int DEFAULT_WAIT_SECONDS = 15;

    static WebDriverWait wait; // WebDriverWait instance

//    // Initialize WebDriverWait and Actions in a static block
//    static {
//    }

    /**
     * Navigate to the specified URL.
     *
     * @param url the URL to navigate to
     */
    public static void navigateToUrl(String url) {
        getDriver().get(url);
        String PageTitle = getDriver().getTitle();
        LogUtil.info(currentClassName, "Page title: " + PageTitle);
    }


    /**
     * Find a web element using the specified locator.
     *
     * @param locator the locator to find the element
     * @return the found WebElement
     */
    public static WebElement findElement(By locator) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_WAIT_SECONDS)); // Set the timeout value as per your requirement
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); //checks for element to be present in the DOM and Visible on screen
    }

    /**
     * Click on the web element identified by the specified locator.
     *
     * @param locator the locator of the element to be clicked
     */
    public static void click(By locator) {
        WebElement element = findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Click on the web element identified by the specified locator using javascript executor.
     *
     * @param locator the locator of the element to be clicked
     */
    public static void clickByJavaScript(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", getDriver().findElement(locator));
    }

    /**
     * Create a dynamic By locator by replacing %s in the provided XPath with the given value.
     *
     * @param xpath the XPath template with %s as a placeholder
     * @param value the value to replace %s with
     * @return the dynamic By locator
     */
    public static By createDynamicLocator(String xpath, String value) {
        String dynamicXPath = String.format(xpath, value);
        return By.xpath(dynamicXPath);
    }

    /**
     * Enter the specified text into the input field identified by the specified locator.
     *
     * @param locator the locator of the input field
     * @param text    the text to be entered
     */
    public static void inputText(By locator, String text) {
        LogUtil.info(currentClassName, "inputText()=" + text);
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get the text of the web element identified by the specified locator.
     *
     * @param locator the locator of the element
     * @return the text of the element
     */
    public static String getText(By locator) {
        WebElement element = findElement(locator);
        return element.getText();
    }


    /**
     * Check if the web element identified by the specified locator is displayed.
     *
     * @param locator the locator of the element
     * @return true if the element is displayed, false otherwise
     */
    public static boolean isDisplayed(By locator) {
        WebElement element = findElement(locator);
        return element.isDisplayed();
    }

    /**
     * Switch to new tab based on its index.
     *
     * @param tabIndex the index of the tab to switch to (0-based index)
     */
    public static void switchToTab(int tabIndex) {
        java.util.List<String> tabs = new java.util.ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - tabIndex));
    }

    // Add more methods for other common Selenium actions as needed

    // No need for the main method, as methods are static
}
