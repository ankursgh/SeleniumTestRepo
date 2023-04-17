#Author: Ankur.shukla
#Carrier: Automax one
#Location: Location auto
#Contact: Auto contact
#User: at.aoto.contact.lcv/test
#LCVAddPrimaryConatact.stepdefinition, LCVAddCarrierPrimaryContact.Java
@LMST-939
Feature: Add secondry instructor
  I want to add secondry instractor

  Scenario: Adding secondry instructor
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "at.aoto.contact.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I clicked register instructor.
    Then I register the instructor.
    And I quit the browser.

  Scenario: Delete newly created instructor.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "at.aoto.contact.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I clicked the new contact and deleted.
    And I quit the browser.

  Scenario: Adding an instructor who s certification is not yet valid.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "at.aoto.contact.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I clicked register instructor.
    Then I register the insturctor for another carrier.

  Scenario: Delete newly instructor.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "at.aoto.contact.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I clicked new contact and deleted.
    And I quit the browser.
