#Author: Ankur.shukla
# Adminname: automation_random
@LMST-938
Feature: LCV Add admin
  I want to add admin user

  Scenario: Add an admin member
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I waited for 2 seconds.
   Then I clicked on admin.
   Then I waited for 2 seconds.
   Then I entered first name.
   Then I entered last name.
   Then I entered email.
   Then I entered password.
   And I entered password hint.
   And I checked the username.
  #Then I select role admin.
   Then I clicked save button.
   Then I waited for 2 seconds.
   And I quit the browser.
   
  Scenario: Verify admin member created.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I select newly created user. 
   Then I waited for 2 seconds.
   And I quit the browser.
   #LCVadmin step def
   #LCVadmin page
  
