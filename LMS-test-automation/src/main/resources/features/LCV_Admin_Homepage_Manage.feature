#Author: ankur.shukla

@LMST948
Feature: Features listed under manage section of admin homepage.
 
 Scenario: Manage carriers
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   And I clicked carriers.
   Then I searched company by alphabet.
   Then I waited for 2 seconds.
   Then I clicked all button.
   Then I waited for 2 seconds.
   Then I searched deleted company.
   Then I waited for 3 seconds.
   And I quit the browser.
   
  Scenario: Manage Location
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   And I clicked Location.
   Then I searched location by alphabet.
   Then I waited for 2 seconds.
   Then I clicked all button.
   Then I waited for 2 seconds.
   Then I searched deleted location.
   Then I waited for 3 seconds.
   And I quit the browser.
 
   Scenario: Manage Org Structure
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   And I clicked org structure.
   Then I selected the user and clicked.
   Then I clicked the users assigned.
   Then I moved user to new admin.
   And I quit the browser.
   
   #**********************Recheck this script as Auto.admin or Auto admin dummy moved to Automax three and reverse*************8