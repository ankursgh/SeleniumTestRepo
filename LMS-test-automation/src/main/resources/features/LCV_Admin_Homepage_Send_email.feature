#Author: ankur.shukla

@LMST-953
Feature: Sending emails using "Send email" feature.
  
  Scenario: Send email
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I clicked on more link.
  Then I clicked send email link.
  Then I waited for 2 seconds.
  Then I entered email subject.
  Then I entered email body.
  Then I waited for 2 seconds. 
  Then I selected user and send the eamil.
  Then I waited for 4 seconds. 
  And I quit the browser.