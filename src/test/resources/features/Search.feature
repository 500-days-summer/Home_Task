Feature: Google Search using search button

  Background: user opens Google Page
    Given the user navigated to Google search page

  Scenario: Positive Scenario: user uses the Google Search Button
    When the user inputs "ducks" in the search box
    And the user clicks on Google Search button
    Then the user should see "ducks" on the title page
    And every search result should be relevant and should contain the word "duck"
    And the search input box should display the searched word "ducks"

  Scenario: Positive Scenario: user uses ENTER key to search
    When the user inputs "ducks" in the search box and the user presses ENTER on the keyboard
    Then the user should see "ducks" on the title page
    And every search result should be relevant and should contain the word "duck"
    And the search input box should display the searched word "ducks"


  Scenario: Positive Scenario: user uses suggestions drop down list
    When the user inputs "ducks" in the search box
    And the user picks "ducks" from the suggested search results
    Then the user should see "ducks" on the title page
    And every search result should be relevant and should contain the word "duck"
    And the search input box should display the searched word "ducks"


  Scenario: Negative Scenario: user uses the Google Search Button
    When the user inputs "d ucks" in the search box
    And the user clicks on Google Search button
    Then the user should see "d ucks" on the title page
    Then verify "Showing results for" "ducks" is displayed
    And every search result should be relevant and should contain the word "duck"


  Scenario: Negative Scenario: user uses ENTER key to search
    When the user inputs "d ucks" in the search box and the user presses ENTER on the keyboard
    Then the user should see "d ucks" on the title page
    Then verify "Showing results for" "ducks" is displayed
    And every search result should be relevant and should contain the word "duck"


  Scenario: Negative Scenario: user uses suggestions drop down list
    When the user inputs "d ucks" in the search box
    And the user picks "ducks" from the suggested search results
    Then the user should see "ducks" on the title page
    And every search result should be relevant and should contain the word "duck"
    And the search input box should display the searched word "ducks"


