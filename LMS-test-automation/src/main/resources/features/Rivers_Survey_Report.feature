#Author: Ankur Shukla

@LMST-992
Feature: Rivers Survey Report
 
  Scenario Outline: Survey report with roles 
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username>" and password "<Password>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on Progress in the navigation bar main menu.
    Then I waited for 2 seconds.
    When I clicked on the Survey icon on the Progress page.
    Then I waited for 5 seconds.
    Then I clicked on Surveys.
    Then I selected the survey.
    Then I waited for 2 seconds.
    Then I selected the people.
    Then I waited for 3 seconds.
    And clicked on the save button.
    Then I clicked on period.
    Then I select the period Week.
    Then I select the period Month.
    Then I waited for 2 seconds. 
    Then I select the period Quarter.
    Then I select the period Year.
    Then I waited for 2 seconds.
    Then I selected the option Include usernames as well.
    And I quit the browser.
    
  Examples: 
    | Username   | Password |
    | auto.nava  | test     |