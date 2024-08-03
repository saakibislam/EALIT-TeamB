

Feature: Title of your feature
  I want to use this template for my feature file

  @qaf_checkout
  Scenario: Checkout 
    Given the product is added to the cart
    And user clicks on cart button
   Then user clicks on checkout link
   Then user click on Estimate Shipping & Taxes dropdown button
   Then user fills up shipphing form
   Then user click on get quote button
   Then user select Flat Shipping Rate and click on Apply Shipping
   Then user click on checkout button
   
   
   

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
