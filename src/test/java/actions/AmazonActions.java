package actions;

import pageFactory.AmazonPage;
import utilities.LogUtil;
import utilities.WrapperUtil;

public class AmazonActions extends WrapperUtil {

    // Click the hamburger menu to open all sections.
    public static void clickAllHamburgerMenu() {
        click(AmazonPage.allSectionHamMenu);
    }

    // Click on the "Mobiles & Computers" section.
    public static void clickMobilesComputers() {
        click(AmazonPage.mobilesComputers);
    }

    // Click on the "All Mobile Phones" section and ensure it's displayed.
    public static void clickAllMobilePhones() {
        isDisplayed(AmazonPage.allMobilePhones);
        clickByJavaScript(AmazonPage.allMobilePhones);
    }

    // Search for a product by entering the product name in the search filter.
    public static void searchProduct(String productName) {
        inputText(AmazonPage.searchFilter, productName);
    }

    // Click the search button to initiate the search.
    public static void clickSearchBtn() {
        click(AmazonPage.searchIcon);
    }

    // Wait for the search results to be displayed.
    public static void waitForResults() {
        isDisplayed(AmazonPage.searchResults);
    }

    // Open the very first product in the search results.
    public static void openVeryFirstProduct() {
        click(AmazonPage.firstProduct);
    }

    // Get and log the product specifications.
    public static void getProductSpecifications() {
        switchToTab(1);
        // Get product specifications and log to the console
        String brandName = getText(createDynamicLocator(AmazonPage.productSpec, "Brand"));
        LogUtil.info(AmazonActions.class, "Brand: " + brandName);

        String modelName = getText(createDynamicLocator(AmazonPage.productSpec, "Model Name"));
        LogUtil.info(AmazonActions.class, "Model Name: " + modelName);

        String networkServiceProvider = getText(createDynamicLocator(AmazonPage.productSpec, "Network Service Provider"));
        LogUtil.info(AmazonActions.class, "Network Service Provider: " + networkServiceProvider);

        String operatingSystem = getText(createDynamicLocator(AmazonPage.productSpec, "Operating System"));
        LogUtil.info(AmazonActions.class, "Operating System: " + operatingSystem);

        String cellularTechnology = getText(createDynamicLocator(AmazonPage.productSpec, "Cellular Technology"));
        LogUtil.info(AmazonActions.class, "Cellular Technology: " + cellularTechnology);
    }

}
