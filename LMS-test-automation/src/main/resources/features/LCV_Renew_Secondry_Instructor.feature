#Author: ankur.shukla@rsystem.com

@LMST-956
Feature: Renew instructors expired certificate. 
  
 Scenario: Expire instructor active certificate.
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test". 
  And clicked Submit button on the login page.
  Then I clicked on more link.
  # Instructor renew instructor should have active certificate 
  Then I expired the active certificate.
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
  
  Scenario: Renew user expired certificate.
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "lv.contact.lcv" and password "test". 
  And clicked Submit button on the login page.
  Then I waited for 3 seconds.
  Then I closed popup.
  Then I waited for 3 seconds.
  Then I refershed page.
  Then I waited for 2 seconds.
  Then I clicked on certification status.
  Then I waited for 2 seconds.
  Then I renew instructor certificate.
  And I quit the browser.
 
Scenario: Activate instructor certificate.
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test". 
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I verified the instructor.
  Then I activted the instructor certificate.
  Then I waited for 2 seconds.
  And I quit the browser. 