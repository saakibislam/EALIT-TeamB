
Feature: Working on YourStore Search and Add to cart button
 
  @Search 
  Scenario: Users Searching and adding product to cart.
    Given User is logged in 
    And User Clicks on Search bar
    When User types product on search bar
    And User click search button
    Then User clicks on add to cart
    Then Successfull message verification
    
  
  