@Smoke
Feature: Feature to test login functionality

  Background: user is on login page
    Given user is on login page


  Scenario Outline: Check if login is successful with valid credentials
    When user enters the valid <username> and <password>
    And clicks on the login button
    Then user is navigated to the home page
    Examples:
      | username | password    |
      | student  | Password123 |

  Scenario Outline: check if logout button is displayed
    When user enters the valid <username> and <password>
    And clicks on the login button
    Then logout button should be displayed
    Examples:
      | username | password    |
      | student  | Password123 |
