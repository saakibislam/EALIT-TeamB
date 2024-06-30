
Feature: User Login
  I want to use this template to Login a user.

  @qafoxlogin
  Scenario: User login from homepage
    Given User is in homepage
    And user clicked on Login button
    When user redirected to login page
    And user types credentials
    Then verify user redirected to my account page

#Examples:
#|email|password|
#|pbotterell0@hexun.com|iW9?c,A%'Ow8p+!|

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
