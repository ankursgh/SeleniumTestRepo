#Author: ankur.shukla@rsystems.com
#User LV2 should have active driver certificate(Driver-422 & Driver NO TDG-522 certification should be).
@LMST-954
Feature: Renew and reprint expired certificate.

 Scenario: Expire user active certificate.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "automation.admin.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I clicked on more link.
    Then I expired the certificate.
    Then I waited for 2 seconds.
    And I quit the browser.
 

  Scenario: Run Full LCV Daily Batch
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "ankur.systemaccount" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I clicked Run batch job.
    Then I waited for 2 seconds.
    Then I clicked run button.
    Then I waited for 12 seconds.
    And I quit the browser.
# Remove above two scenarios if script fails and execute.

  Scenario: Renew user expired certificate.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "lv.contact.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I closed popup.
    Then I waited for 3 seconds.
    Then I refershed page.
    Then I waited for 2 seconds.
    Then I clicked on certification status.
    Then I waited for 2 seconds.
    Then I renew driver certificate.
    And I quit the browser.

  Scenario: Activate certificate.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "automation.admin.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    Then I verified the user.
    Then I activted the certificate.
    Then I waited for 2 seconds.
    And I quit the browser.
