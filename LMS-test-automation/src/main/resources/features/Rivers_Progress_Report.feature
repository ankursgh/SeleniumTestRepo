#Author: ankur.shukla

@LMST-993
Feature: Rivers Progress Report
 
  Scenario Outline: Progress report with roles 
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username>" and password "<Password>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on Progress in the navigation bar main menu.
    Then I waited for 2 seconds.
    When I clicked on the Progress icon on the Progress page.
    Then I waited for 5 seconds.
    Then I clicked on programs.
    Then I selected the program.
    Then I waited for 2 seconds.
    Then I clicked on the program.
    And I clicked on select All in the program.
    Then I waited for 5 seconds.
    And clicked on the save button.
    Then I waited for 3 seconds.
    When I clicked on the Progress icon on the Progress page.
    Then I waited for 4 seconds.
    Then I selected the people.
    Then I waited for 3 seconds.
    And clicked on the save button.
    Then I selected the other option.
    Then I waited for 3 seconds.
    Then I selected the option Include the usernames as well.
    Then I waited for 2 seconds.
    Then I selected option Show Programs that are not currently assigned.
    Then I waited for 2 seconds.
    And I quit the browser.
 Examples: 
      | Username   | Password |
      | auto.nava  | test     |