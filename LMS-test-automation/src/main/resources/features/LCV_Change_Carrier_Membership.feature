#Author: Ankur Shukla

@LMST-929
Feature: Change carrier membership
  I want to change carrier membership and register driver user.

  @LMST-929.
Scenario: Change member to non member.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "automation.admin.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    And I clicked carriers.
    Then I waited for 4 seconds.
    And I selected carrier.
    And I clicked on status.
    Then I selected non member. 
    Then I clicked on save. 
    And I quit the browser.
  
 Scenario: Register driver user from instructor for Non member carrier.
    # User: Test Lcv
     Given open the "chrome" browser.
     When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
     Then I saw the login page.
     When I Entered username "er.ank.auto.lcv" and password "4qe9ldd1".
     And clicked Submit button on the login page.
     Then I waited for 2 seconds.
     Then I closed popup.
     Then I waited for 4 seconds.
     Then I clicked register driver.
     Then I clicked checkbox.
     Then I waited for 2 seconds.
     Then I created driver user.
     Then I waited for 4 seconds.
     And I quit the browser.
    # Then I created driver user.
    @LMST-929
 Scenario: Delete newly created driver user for non member user. 
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "automation.admin.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    And I searched user.
    Then I waited for 4 seconds.
    Then I deleted user.
    Then I waited for 4 seconds.
    And I quit the browser.
    
     @LMST-929
 Scenario: Change non member carrier to member.
     Given open the "chrome" browser.
     When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
     Then I saw the login page.
     When I Entered username "automation.admin.lcv" and password "test".
     And clicked Submit button on the login page.
     Then I waited for 2 seconds.
     And I clicked carriers.
     Then I waited for 4 seconds.
     And I selected carrier.
     And I clicked on status.
     Then I selected member. 
     Then I clicked on save button. 
     And I quit the browser.
     
 Scenario: Create user from instructor for member.
     #User: Lcv Test
     Given open the "chrome" browser.
     When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
     Then I saw the login page.
     When I Entered username "er.ank.auto.lcv" and password "4qe9ldd1".
     And clicked Submit button on the login page.
     Then I waited for 2 seconds.
     Then I closed popup.
     Then I waited for 4 seconds.
     Then I clicked register driver.
     Then I clicked accept checkbox.
     Then I waited for 2 seconds.
     Then I created second driver user.
     Then I waited for 6 seconds.
     And I quit the browser.
     #back to orginal
     
#Scenario: Delete member driver user is moved to upgrade user test automation.
 
    
    
     