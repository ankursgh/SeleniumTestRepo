#Author: ankur.shukla
# carrier automax two, loc-zenloc, contact-Aoto1, contact, ere.instruct1.test.lcv/test
# admin- automation.admin.lcv
# contact - at.aoto.contact.lcv
# Instructor - ere.instruct1.test.lcv
@LMST942
Feature: Add new instructor & driver user.

  Scenario: I want to add previously certified instructor.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "at.aoto.contact.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I waited for 2 seconds.
    Then I registered previously certified instructor.
    Then I waited for 4 seconds.
    #Then I refershed page.
    And I quit the browser.

  Scenario: I want to verify instructor created.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "automation.admin.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I clicked supporting document link.
    And I accepted the supporting documents.
    Then I waited for 2 seconds.
    Then I clicked recent registrations.
    Then I waited for 3 seconds.
    And I verified the new registration.
    Then I waited for 3 seconds.
    Then I clicked on locked user.
    Then I waited for 2 seconds.
    #And I unlocked the instructor.
    Then I clicked certify user link.
    And I quit the browser.

  #And I certified the new user.
  Scenario: I want to delete previously certified instructor.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "at.aoto.contact.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I waited for 2 seconds.
    Then I deleted first instructor.
    And I quit the browser.

  Scenario: Register new instructor.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "at.aoto.contact.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I waited for 2 seconds.
    Then I register the new instructor.
    Then I waited for 4 seconds.
    Then I refershed page.
    Then I waited for 2 seconds.
    Then I deleted second insturctor.
    And I quit the browser.

  Scenario: I want to register driver.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "ere.instruct1.test.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I waited for 2 seconds.
    Then I added a new driver.
    Then I waited for 2 seconds.
    And I quit the browser.

  Scenario: Delete driver user.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "ere.instruct1.test.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I deleted new driver.
    And I quit the browser.
