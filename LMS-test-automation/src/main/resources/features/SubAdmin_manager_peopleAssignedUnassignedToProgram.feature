#Author: ankur.shukla@rsystems.com

@LMST-960
Feature: Role - Sub Admin: - Programs >> Show Programs >> People Assigned/unassigned by Sub Admin
  As a Sub Admin, Assigning/unassigning programs to one or more users.   
  Assigning/unassigning programs to one or more users when logged in as Sub Admin.
 
  Scenario: People Assigned by Subadmin.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   #auto.admis
   #Auto.admin1
   #Auto.mgrs
 	 When I entered username "auto.admis" and password "test".
   And clicked Submit button on the login page.
   Then I logged in successfully.
   And I clicked on Programs in the navigation bar main menu.
   #Normalize for the next test if it is not normalized.
   Then I waited for 1 seconds.
   When I clicked on `x people assigned` to the "Auto4Required" program.
   And I clicked on Unselect All in the program.
   #And I selected the Assign Places tab on the program assigned display window.
   And clicked on the save button.  
   Then I waited for 2 seconds.
   #initial data is place 3 which has id places-20530
   When I clicked on `x people assigned` to the "Auto4Required" program.
   #And I clicked on Unselect All in the program.
   And I selected the Assign Places tab on the program assigned display window.
   And I clicked on Unselect All in the program.
   #And clicked on the save button.  
   And I clicked on a place have id "place-20530" on the people assign display window.
   Then I waited for 2 seconds.
   And clicked on the save button.  
   Then I waited for 2 seconds.
   And I verified 4 people assigned to the "Auto4Required" program.
   Then I waited for 2 seconds.
   When I clicked on `x people assigned` to the "Auto4Required" program.
   And I selected the Assign Places tab on the program assigned display window.
   And I clicked on Unselect All in the program.
   And clicked on the save button.  
   Then I waited for 3 seconds.
   #Check status on people page
   #check program assigned by login as user.
   #Assignining second type of program "Mobile Optional"
   
   When I clicked on `x people assigned` to the "Auto4Optional" program.
   And I clicked on Unselect All in the program.
   #And I selected the Assign Places tab on the program assigned display window.
   And clicked on the save button. 
   Then I waited for 3 seconds.
   #initial data is place 3 which has id places-20530
   When I clicked on `x people assigned` to the "Auto4Optional" program.
   And I selected the Assign Places tab on the program assigned display window.
   And I clicked on Unselect All in the program.
   And I clicked on a place have id "place-20530" on the people assign display window.
   Then I waited for 2 seconds.
   And clicked on the save button.  
   Then I waited for 6 seconds.
   And I verified 4 people assigned to the "Auto4Optional" program.
   Then I waited for 2 seconds.
   When I clicked on `x people assigned` to the "Auto4Optional" program.
   And I selected the Assign Places tab on the program assigned display window.
   And I clicked on Unselect All in the program.
   And clicked on the save button.  
   Then I waited for 2 seconds.
   And I quit the browser.
   # Assignining second type of program "Mobile - Reference"
   
   Scenario: People Assigned by Subadmin.
   As a Sub admin, Assigning/unassigning programs to one or more users. The test is about assigning program to only single user or few users.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   #auto.admis
   #Auto.admin1
   #Auto.mgr
 	 When I entered username "auto.mgrs" and password "test".
   And clicked Submit button on the login page.
   Then I logged in successfully.
   And I clicked on Programs in the navigation bar main menu.
   #Normalize for the next test if it is not normalized.
   Then I waited for 1 seconds.
   When I clicked on `x people assigned` to the "Auto4Required" program.
   And I clicked on Unselect All in the program.
   Then I waited for 1 seconds.
   Then I clicked on the user "user-auto.mgrs" on the Assign people tab.
   And clicked on the save button. 
   Then I waited for 1 seconds.
   And I quit the browser.
   # unassignment "user-auto.mgrs" is reamining. 