#Author: ankur.shukla
@LMST-989
Feature: Rivers Progress Acitivity Report

  Scenario Outline: Activity report from CS role
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username>" and password "<Password>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on Progress in the navigation bar main menu.
    Then I waited for 2 seconds.
    When I clicked on the Activities icon on the Progress page.
    Then I waited for 5 seconds.
    Then I clicked on period.
    When I clicked on the certificate of the user "navaauto.476" on the progress page.
    Then I waited for 4 seconds.
    Then I clicked on wallet card.
    Then I clicked on edit card.
    Then I select the period Week.
    Then I select the period Month.
    Then I waited for 2 seconds. 
    Then I select the period Quarter.
    Then I select the period Year.
    Then I selected the option Include usernames as well.
    Then I selected the option Include personal information.
    Then I waited for 2 seconds. 
    Then I selected the option Include people with no data.
    Then I selected the option Include deleted people.
    Then I waited for 2 seconds. 
    Then I selected the option Show Programs that are not currently assigned.
    Then I selected the option Show the individual language variations for each module.
    Then I selected the option Show detailed results.
    Then I waited for 2 seconds. 
    Then I selected the option Show only the latest results in the module for each person. 
    Then I selected the option Show all results for each person. 
    Then I waited for 2 seconds. 
    Then I selected the option Show only the results that include tests. 
    Then I selected the option Show only the modules that have been completed.
    And I closed the browser.

    Examples: 
      | Username  | Password |
      | auto.nava | test     |
