#Author: ankur.shukla

@LMST-992
Feature: Rivers Program Certificate Report

  Scenario Outline: Program Certificate with roles 
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username>" and password "<Password>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on Progress in the navigation bar main menu.
    Then I waited for 4 seconds.
    When I clicked on the Program certificate icon on the Progress page.
    Then I waited for 5 seconds.
    Then I clicked on Program certificate.
    Then I selected certificate and generated report.
    Then I waited for 2 seconds.
    Then I selected people.
    Then I generated the report.
    Then I clicked on period.
    Then I select the period Week.
    Then I select the period Month.
    Then I waited for 2 seconds. 
    Then I select the period Quarter.
    Then I select the period Year.
    Then I waited for 2 seconds.
   # Then I selected other option.
    Then I selected include deleted people option.
    Then I waited for 2 seconds.
    Then I selected Show expired program certificates.
    Then I waited for 2 seconds.
    Then I selected Show deleted program certificates.
    Then I waited for 2 seconds.
    Then I selected Show users in progress.
    Then I selected Show Region.
    And I quit the browser. 
    
  Examples: 
    | Username   | Password |
    | auto.nava  | test     |