Feature: Feature to test google search functionality
  @GoogleSearch
  Scenario: Validate if google search is working
    Given google homepage is open in the web browser
    When user enters the search string in the textbox
    And hits the search button
    Then search results should be displayed
