#Author:ankur.shukla@rsystems.com
# Traing Plan: Automation TP
# user: AKS driver, AKS contact
@LMST951
Feature: Manage Training Plans Feature
 
 Scenario: Manage Training plan.
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I clicked on more link.
  Then I clicked manage training plans. 
  Then I added new training plan.
  Then I waited for 3 seconds.
  Then I logged out.
  Then I waited for 2 seconds.
  When I Entered username "er.aks.driver.lcv" and password "dlxkq8l1".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I verified module is assigned to the user.
  Then I waited for 2 seconds.
  And I quit the browser.
  
  Scenario: Edit Training plan.
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I clicked on more link.
  Then I clicked manage training plans.
  Then I edited training plan.
  Then I waited for 2 seconds.
  And I quit the browser.
  
  Scenario: Delete Training plan.
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I clicked on more link.
  Then I clicked manage training plans.
  Then I waited for 2 seconds.
  Then I deleted training plan.
  And I quit the browser.