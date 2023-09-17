Feature: Amazon search product feature test

  @e2e
  Scenario Outline: As a user I am able to search and open a given product
    Given I am on the Amazon.in website
    When I navigate to the All section and select Mobiles, Computers
    And I click on All Mobiles
    And I enter "<ProductName>" in the search filter
    And I click the search button
    And I select the first search result
    Then I should see all the mobile specifications on the product page

    Examples:
      | ProductName   |
      | OnePlus 11 5G |
