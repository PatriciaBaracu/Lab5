Feature: feature to test google search functionality

  Scenario: Validate google search is working

    Given browser is opened
    And  user is on google search page
    When user enters word computer in search box
    And  user press enter
    Then user should see the header of the search