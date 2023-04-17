 # Author: ankur.shukla@rsystems.com
 # TestData: 
 # Carrier: automax three
 # Contact: automax three (test9.contact9.lcv)
 # Location: Yukon
 # Admin: automation.admin.lcv
 # Instructor: ere.automax.instructor.lcv
 # Driver: automax.driver.lcv
 # Edit event data: Automation test 
 # New event: automation
 # ere.automax.instructor.lcv, should have valid license 

  @LMST-944
  Feature: Training Events
  Scenario: Edit and update training events as an instructor 
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "ere.automax.instructor.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I closed popup.
  Then I clicked on more link.
  Then I waited for 2 seconds.
  Then I clicked on All Training Events. 
  Then I waited for 2 seconds.
  And I clicked on update button.
  Then I selected complete.
  Then I verifed training is completed.
  Then I clicked on more link.
  Then I waited for 2 seconds.
  Then I clicked on All Training Events.
  Then I waited for 2 seconds.
  And I clicked on update button.
  Then I selected incomplete.
  Then I verifed training is incompleted.
  Then I clicked on more link.
  Then I waited for 2 seconds.
  Then I clicked on All Training Events.
  Then I waited for 2 seconds.
  And I clicked on update button.
  Then I selected did not attend.
  Then I verifed training is not started.
  And I quit the browser.
  
  Scenario: Create events as an instructor. 
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "ere.automax.instructor.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I closed popup.
  Then I clicked schedule training.
  Then I entered training details.
  Then I verified event is created.
  And I quit the browser.
  
  Scenario: Assign user to event with no sapce available. 
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I clicked on more link.
  Then I waited for 2 seconds.
  Then I clicked on Manage Events. 
  Then I waited for 2 seconds.
  Then I clicked on edit event.
  Then I waited for 3 seconds.
  Then I assigned users.
  Then I waited for 2 seconds.
  Then I clicked on edit event.
  Then I waited for 3 seconds.
  Then I unassigned users.
  And I quit the browser.
  
  Scenario: Delete events. 
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "ere.automax.instructor.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I closed popup.
  Then I deleted the event.
  And I quit the browser.
 