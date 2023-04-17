#Author: ankur.shukla
# at.automation.contact.lcv & Location is Test automation
# Check in LCV contacts page that automation contact should be the primary contact.
# Location Test Location
@LMST940
Feature: Add LCV contact
  I want to add LCV contact.

  Scenario: Add lcv contact from active primary lcv contact
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "at.automation.contact.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I waited for 4 seconds.
    Then I clicked register contact.
    Then I waited for 2 seconds.
    Then I entered the first name.
    Then I entered the last name.
    Then I entered the email.
    And I entered title.
    And I entered driving license.
    And I selected the location.
    And I clicked the checkbox.
    And I clicked submit button.
    Then I waited for 2 seconds.
    And I quit the browser.

  Scenario: Delete newly created lcv contact.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "at.automation.contact.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I clicked new contact and deleted.
    And I quit the browser.
