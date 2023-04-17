#Author: Ankur.Shukla
@LMST-974,LMST-975,LMST-976,LMST-977
Feature: Add modify delete past and future using diffent roles.

  Scenario Outline: Add future event using diffent roles.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username>" and password "<Password>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    Then I waited for 2 seconds.
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 2 seconds.
    #--Then I clicked show events.
    Then I hover over on the Events in the Program page.
    Then I waited for 2 seconds.
    And I clicked add event.
    Then I waited for 4 seconds.
    Then I added event details.
    Then I waited for 2 seconds.
    And I saved the event.
    And I quit the browser.
    Then I waited for 4 seconds.

    Examples: 
      | Username   | Password |
      | auto.nava  | test     |
      | admin.auto | test     |
      | auto.nava  | test     |
      | sub.admin  | test     |

  Scenario Outline: Adding past event with diffrent roles.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username1>" and password "<Password1>".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 2 seconds.
    #---Then I clicked show events.
    Then I hover over on the Events in the Program page.
    Then I waited for 2 seconds.
    And I clicked add event.
    Then I waited for 4 seconds.
    Then I clicked past events.
    Then I waited for 2 seconds.
    Then I added past event details.
    Then I waited for 2 seconds.
    And I saved the event.
    And I quit the browser.
    Then I waited for 4 seconds.

    Examples: 
      | Username1  | Password1 |
      | auto.nava  | test      |
      | admin.auto | test      |
      | auto.nava  | test      |
      | sub.admin  | test      |

  Scenario Outline: Show future event as customer support role.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username2>" and password "<Password2>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 2 seconds.
    Then I clicked show events.
    And I clicked the event.
    Then I modified event details.
    And I saved the event.
    Then I waited for 2 seconds.
    And I clicked the modified event.
    Then I assign place to event.
    And I saved the event.
    Then I waited for 2 seconds.
    And I clicked the modified event.
    And I unassign all users from event.
    And I quit the browser.
    Then I waited for 4 seconds.

    Examples: 
      | Username2  | Password2 |
      | auto.nava  | test      |
      | admin.auto | test      |
      | auto.nava  | test      |
      | sub.admin  | test      |

  Scenario Outline: Show Past event as different role.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username3>" and password "<Password3>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 2 seconds.
    Then I clicked show events.
    Then I waited for 4 seconds.
    And I clicked the past event.
    Then I modified past event details.
    Then I waited for 2 seconds.
    And I quit the browser.

    Examples: 
      | Username3  | Password3 |
      | auto.nava  | test      |
      | admin.auto | test      |
      | auto.nava  | test      |
      | sub.admin  | test      |

  Scenario Outline: Deleting events as customer support role.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username4>" and password "<Password4>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 2 seconds.
    Then I clicked show events.
    Then I searched the future event.
    Then I deleted the events.
    Then I waited for 2 seconds.
    Then I searched the past event.
    Then I deleted the events.
    And I quit the browser.

    Examples: 
      | Username4       | Password4 |
      | auto.nava       | test      |
      | admin.auto      | test      |
      | navaraj.manager | test      |
      | auto.nava       | test      |
#admin.auto -admin
#auto.nava -cs
#navaraj.manager -mgr
#r.admin -subadmin
