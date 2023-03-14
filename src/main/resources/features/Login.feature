Feature: Login User HRM

  Scenario: User valid login into web HRM
    Given User open browser and url
    When User enter valid username
    And User enter valid password
    And User click button login
    Then user go to page Dashboard


  Scenario: User invalid login into web HRM
    When User click button logout
    And User enter invalid username
    And User enter invalid password
    And User click button login
    Then User get message invalid credentials

  Scenario: User No input password into web HRM
    When User enter valid username
    And User no input password
    And  User click button login
    Then User get message Required
