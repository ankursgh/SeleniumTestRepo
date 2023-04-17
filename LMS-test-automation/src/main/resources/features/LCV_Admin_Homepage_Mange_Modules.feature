#Author: ankur.shukla
#Not able to find "Add System Module" hyperlink hence Scenario: Create System module is not automated.
# Sysadmin account: ankur.systemaccount/test
@LMST-950
Feature: Admin home page Manage module
  
  Scenario: Create new module.
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I clicked on more link.
  Then I clicked manage module link.
  Then I clicked add module.
  Then I added new module.
  And I quit the browser.
  
  Scenario: Delete new module.
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I clicked on more link.
  Then I clicked manage module link.
  Then I deleted newly created module.
  
  #Scenario: Create System module. 
  #Given open the "chrome" browser.
  #When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  #Then I saw the login page.
  #When I Entered username "ankur.systemaccount" and password "test".
  #And clicked Submit button on the login page.
  #Then I waited for 2 seconds.