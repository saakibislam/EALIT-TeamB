Feature: Working on YourStore Search and Add to cart button


  @Search_SingleProduct
  Scenario: Users Searching and adding product to cart.
    Given User is logged in 
    And User Clicks on Search bar
    When User types product on search bar
    And User click search button
    Then User click on add to cart
    Then Successfully message verification
  
  @Search_Multipleproduct
  Scenario Outline: User Searching multiple product
    Given User is logged in
    And User Clicks on Search bar
    When the user searches for "<Product Name>"
    And User click search button
    And User click on add to cart
     And the Total number of results are <Id>
    #Then the user should see a success message "Item has been added to your cart"
   Then Successfully message verification
   
     
     Examples:
      | Product Name | Id |
      | Phone        | 1      |
      | Macbook Pro  | 1      |
      | iMac         |1      |
