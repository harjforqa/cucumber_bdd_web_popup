package pageFactory;

import org.openqa.selenium.By;

public class AmazonPage {

    public static By allSectionHamMenu = By.id("nav-hamburger-menu");
    public static By mobilesComputers = By.xpath("//div[@id='hmenu-content']//div[text()='Mobiles, Computers']");
    public static By allMobilePhones = By.xpath("//div[@id='hmenu-content']//a[text()='All Mobile Phones']");
    public static By searchFilter = By.id("twotabsearchtextbox");
    public static By searchIcon = By.id("nav-search-submit-button");
    public static By searchResults = By.xpath("//span[text()='Results']");
    public static By firstProduct = By.xpath("(//div[@class='a-section'])[2]/div/div");
    public static String productSpec = "//div[@id='productOverview_feature_div']//span[text()='%s']/../following-sibling::td/span";
}
