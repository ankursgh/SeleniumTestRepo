#Author: ankur.shukla@rsystems.com

@LMST947
Feature: All features listed under the 'Print...' section of the LCV Admin homepage.
 
 Scenario: Print wallet functionality
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I clicked wallet link.
  Then I waited for 2 seconds.
  Then I clicked show next six month button.
  Then I waited for 4 seconds.
  And I quit the browser.
  
  Scenario: Print DIT functionality
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I clicked Dit link.
  Then I waited for 4 seconds.
  Then I clicked preview button.
  Then I waited for 4 seconds.
  And I quit the browser.

  
