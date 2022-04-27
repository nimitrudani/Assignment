@qed42_assignment
Feature: Assignment for QED42

	@scenario1
  Scenario: Scenario 1 - AG grid operations
    Given "chrome" browser is open
    And user navigates to "https://generic-ui.com/demo"
    When user selects "100" from drop-down
    Then user is able to see "100" rows in the grid table
    And get the below data from grid where project status is active
    |Project Name|
    |Project Id|
    |Progress %|
    And user close the browser

    @scenario2
    Scenario: Scenario 2 - Price Comparision b/w filpkart and amazon
    Given "chrome" browser is open
    And user navigates to "https://www.flipkart.com"
    When user search for "APPLE iPhone 13 (Starlight, 256 GB)" on "flipkart"
    Then user is  able to see price of that item on "flipkart"
    And user close the browser
    Given "chrome" browser is open
    When user navigates to "https://www.amazon.com/"
    And change the display price to INR
    And user search for "APPLE iPhone 13 (Starlight, 256 GB)" on "amazon"
    Then user is  able to see price of that item on "amazon"
    And user compares the price and print the result
    And user close the browser