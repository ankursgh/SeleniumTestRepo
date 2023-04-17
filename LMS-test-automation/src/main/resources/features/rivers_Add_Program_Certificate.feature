#Author: ankur.shukla
@LMST-981
Feature: Adding program certificate as customer support and carrier admin role

  Scenario Outline: Adding Program certificate
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username>" and password "<Password>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    Then I waited for 2 seconds.
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 2 seconds.
    Then I hover over on the Program certificate in the Program page.
    Then I waited for 2 seconds.
    And I clicked add certificate.
    Then I waited for 4 seconds.
    Then I added certificate details.
    Then I waited for 2 seconds.
    And I quit the browser.
    Then I waited for 4 seconds.

    Examples: 
      | Username  | Password |
      | auto.nava | test     |

  Scenario Outline: Show Program certificate
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username>" and password "<Password>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    Then I waited for 2 seconds.
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 3 seconds.
    And I clicked show certificate.
    Then I waited for 4 seconds.
    Then I selected certificated and deleted.
    Then I waited for 3 seconds.
    And I quit the browser.
    Then I waited for 4 seconds.

    Examples: 
      | Username  | Password |
      | auto.nava | test     |
