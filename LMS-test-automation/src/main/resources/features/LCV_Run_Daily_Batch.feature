#User: Test Instructor should have valid 
@LMST-925
Feature: Run LCV Daily batch job
  
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
  And I quit the browser.
  
Scenario: Verify past event waiting list users should be removed.
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test". 
  And clicked Submit button on the login page.
  Then I clicked on more link.
  Then I waited for 2 seconds.
  #Verify past event waiting list users should be removed.
  Then I clicked on Manage Events. 
  Then I clicked on past event.
  Then I verified waiting list user removed.
  And I quit the browser.
  
Scenario: Verify certificate.
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test". 
  And clicked Submit button on the login page.
  Then I clicked on more link.
  Then I searched instructor. 
  Then I clicked user certification.
  #Then I certified user.
  And I quit the browser.
  
  

  
  
  
  