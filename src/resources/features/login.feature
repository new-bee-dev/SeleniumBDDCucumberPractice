@SmokeScenario
Feature: Feature to test login functionality
  @SmokeTest
  Scenario: Validate if login is successful with valid login credentials.
    Given user is on login page
    When user enters the valid username and password
    And clicks on the login button
    Then user is navigated to the home page
