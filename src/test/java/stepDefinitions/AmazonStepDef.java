package stepDefinitions;

import actions.AmazonActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AmazonStepDef {

    @And("I navigate to the All section and select Mobiles, Computers")
    public void iNavigateToTheAllSectionAndSelectMobilesComputers() {
        AmazonActions.clickAllHamburgerMenu();
        AmazonActions.clickMobilesComputers();
    }

    @And("I click on All Mobiles")
    public void iClickOnAllMobiles() {
        AmazonActions.clickAllMobilePhones();
    }

    @And("I enter {string} in the search filter")
    public void iEnterInTheSearchFilter(String productName) {
        AmazonActions.searchProduct(productName);
    }

    @And("I click the search button")
    public void iClickTheSearchButton() {
        AmazonActions.clickSearchBtn();
    }

    @And("I select the first search result")
    public void iSelectTheFirstSearchResult() {
        AmazonActions.waitForResults();
        AmazonActions.openVeryFirstProduct();
    }

    @Then("I should see all the mobile specifications on the product page")
    public void iShouldSeeAllTheMobileSpecificationsOnTheProductPage() {
        AmazonActions.getProductSpecifications();
    }


}
