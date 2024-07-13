Feature: User Login
  I want to use this template to Login a user.

  Background: Homepage to loginpage
    Given User is in homepage
    And User navigates to loginpage

  @resetpassword
  Scenario: User wants to reset password
    Then User clicks on forgot password
    And User types email
    Then User clicks continue
    And Verify link sent confirmation

  @qafoxlogin
  Scenario: User successfull login
    Then User types credentials
    And Verify user redirected to my account page

  @unsuccessful-login
  Scenario Outline: User login with invalid credentials
    Then User types credentials "<email>" and "<password>"
    And User sees error message

    Examples: 
      | email        | password        |
      | invalidEmail | invalidPassword |
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
