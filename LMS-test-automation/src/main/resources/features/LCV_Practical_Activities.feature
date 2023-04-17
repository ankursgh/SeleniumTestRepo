#Author: ankur.shukla@rsystems.com
@LMST-951
Feature: Scheduling new practical activities and updating existing ones in the LCV environment.

  #LCVEventspage.stepdefinition
  #LCVEventspage.java
  #Event- Practical Test
  #Admin - automation.admin.lcv
  #Instructor- renew.instructor.lcv
  #Contact - lv.contact.lcv/test
  Scenario: I want to register driver from contact.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "lv.contact.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I waited for 2 seconds.
    Then I added the driver.
    Then I waited for 2 seconds.
    And I quit the browser.

  Scenario: I want to unlock newly created driver.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "automation.admin.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I unlocked driver user.
    Then I waited for 2 seconds.
    And I quit the browser.

  Scenario: I want to active DIT certificate.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "automation.admin.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I clicked on more link.
    Then I waited for 2 seconds.
    Then I activated DIT certificate.
    And I quit the browser.

  Scenario: I want to update practical activity from instructor.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "renew.instructor.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I waited for 2 seconds.
    Then I update the practical activity.
    And I quit the browser.

  Scenario: Delete driver user.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "renew.instructor.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I deleted the new driver.
    And I quit the browser.
