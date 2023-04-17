#Author: ankur.shukla
#Automation GQtcCp
#at.automation.contact.lcv
#automation.admin.lcv

@LMST-874
Feature: Admin home page view
 
 Scenario: Change primary contact from LCV contact
 Given open the "chrome" browser.
 When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
 Then I saw the login page.
 When I Entered username "automation.admin.lcv" and password "test".
 And clicked Submit button on the login page.
 Then I waited for 2 seconds.
 Then I undelete the contact.
 Then I waited for 2 seconds.
 Then I clicked LCV contact link.
 Then I waited for 2 seconds.
 Then I selected primary contact checkbox.
 Then I deleted primary contact.
 And I quit the browser. 

 Scenario: Supporting documents functions.
 Given open the "chrome" browser.
 When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
 Then I saw the login page.
 When I Entered username "automation.admin.lcv" and password "test".
 And clicked Submit button on the login page.
 Then I waited for 2 seconds.
 Then I clicked the supporting document link.
 Then I changed document status.
 Then I waited for 2 seconds.
 Then I clicked document view.
 Then I waited for 2 seconds.
 And I quit the browser.
 
  Scenario: Check online users.     
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I clicked currently online users.
  Then I logged out.
  Then I waited for 2 seconds.
  When I Entered username "at.automation.contact.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I closed popup.
  Then I waited for 2 seconds.
  Then I logged out.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I clicked currently online users.
  Then I logged out.
  And I quit the browser.
  
  # Add scenario to reassign Primary contact to "Automation Contact".