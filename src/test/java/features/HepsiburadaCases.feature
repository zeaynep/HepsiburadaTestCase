Feature: Login Feature
  Scenario: Scenario1: Correct Login Test
    Given I have opened "https://giris.hepsiburada.com/"
    When I fill the username field with "username", "password"
    Then I have seen the home page


  Scenario: Scenario2: Add To Chart Test
    Given Search
    When Select first product
    And Add To Chart
    And Add To Chart From Another Seller
    Then I have seen all products were added to basket
    