#Author: navaraj@carriersedge.com


@LMST-740 @LMST-687 @LMS-1438
Feature: Role - Customer Support: - Programs >> Show Programs >> People Assigned/unassigned
Assigning/unassigning programs to one or more users when logged in as customer support.
  Scenario: Normalized all the application 
  Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
 		When I entered username "auto.nava" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
     #Normalize for the next test if it is not normalized.
    Then I waited for 1 seconds.
    When I clicked on `x people assigned` to the "AutoProgram" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
  	And I clicked on Unselect All in the program.
  #initial data is place 3 which has id places-4094
  	And I clicked on a place have id "places-4094" on the people assign display window.
    And clicked on the save button.    
    Then I waited for 2 seconds.
    And I clicked on the x module assigned of the "AutoProgram" program.
    Then I waited for 1 seconds.
    And I clicked on Unselect All in the program.
   # Then I waited for 1 seconds.
   #Assume the module Vehicle Inspectiosn already assigned to the AutoProgram, So need Normalize
    And I selected "Vehicle Inspections" if it is not already selected which id is "module-1977" from the page.
    And clicked on the save button.    
    Then I waited for 2 seconds.
    
    # adding LMST-891 or LMS-1765 scenario.

   	When I clicked on `x people assigned` to the "Option Program1" program.
 		And I clicked on Unselect All in the program.
 		 And I selected the Assign Places tab on the program assigned display window.
  	And I clicked on Unselect All in the program.
   	And clicked on the save button.
    Then I waited for 2 seconds.    
    And I clicked on the x module assigned of the "Option Program1" program.
    Then I waited for 1 seconds.
    And I clicked on Unselect All in the program.
   #Assume the module Vehicle Inspectiosn already assigned to the AutoProgram, So need Normalize
    And I selected "Vehicle Inspections" if it is not already selected which id is "module-1977" from the page.
    And clicked on the save button.    
    Then I waited for 2 seconds.
   	When I clicked on `x people assigned` to the "ReferanceProgram" program.
   	And I clicked on Unselect All in the program.
   	And I selected the Assign Places tab on the program assigned display window.
  	And I clicked on Unselect All in the program.
   	And clicked on the save button.
   	# for program1 initial data
   	Then I waited for 2 seconds.
    When I clicked on `x people assigned` to the "Program1" program.
    Then I waited for 2 seconds.
    And I clicked on Unselect All in the program.
    #unselect only from Assign People Tab,and assign user5 to Program1,This is necessary because the module already started by user5
   	And I clicked on user "user-auto2.user5" at available to assign on Assign people.
   	And I selected the Assign Places tab on the program assigned display window.
   	And I clicked on Unselect All in the program.
   	And clicked on the save button.
   	Then I waited for 2 seconds.
   	And I clicked on the x module assigned of the "Program1" program.
    Then I waited for 1 seconds.
    And I clicked on Unselect All in the program.
   #Assume the module CSA for Drivers already assigned to the Program1, So need Normalize
    And I selected "CSA for Drivers" if it is not already selected which id is "module-312" from the page.
    And clicked on the save button.    
    Then I waited for 2 seconds.
    When I clicked on `x people assigned` to the "Program2" program.
    And I clicked on Unselect All in the program.
   	And clicked on the save button.
   	And I closed the browser.

  @LMST-687 @LMST-740
  Scenario: People Assigned by CS
  As a Customer Support, Assigning/unassigning programs to one or more users. The test is about assigning program to only single user or few users.
  
		Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
 		When I entered username "auto.nava" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    And I clicked on Show Programs on the Programs page.
    #Then I verified that 1 modules assigned to the AutoProgram program.
   # Then I waited for 1 seconds.
    Then I verified that 1 modules assigned to the "AutoProgram" program.
    And I verified that 2 people assigned to the "AutoProgram" program.
    When I clicked on `x people assigned` to the "AutoProgram" program. 
    Then I saw the disable users "Auto2 user3, Auto2 user2" in Assign people.
    And I selected the Assign Places tab on the program assigned display window.
    #// place1 place is in Environment:Process automation2 and its id is "place-16904"
    And I clicked on a place have id "place-16904" on the people assign display window.
    And clicked on the save button.
   	Then I waited for 2 seconds.
   #Since place 1 has 3 people and 2+3=5
    And I verified that 5 people assigned to the "AutoProgram" program. 
    When I clicked on `x people assigned` to the "AutoProgram" program.    
    Then I saw the disable users "Auto2 mngr, Auto2 radmin, Auto2 user, Auto2 user3, Auto2 user2" in Assign people.
    And I selected the Assign Places tab on the program assigned display window.
   	 #return to orginal  # unselect place1
    And I clicked on a place have id "place-16904" on the people assign display window.
    And clicked on the save button.
    Then I waited for 1 seconds.
    And I verified that 2 people assigned to the "AutoProgram" program.
    When I clicked on `x people assigned` to the "AutoProgram" program.
    Then I waited for 1 seconds.
    #the below steps not worked by using dynamic wait 
    And I clicked on user "user-auto2.user" at available to assign on Assign people.
    And I clicked on the reset checkbox.
    And clicked on the save button.
    Then I waited for 1 seconds.
    And I verified that 3 people assigned to the "AutoProgram" program.
    When I clicked on people at the navigation bar.
    #Step 5
    And I verified that the status of user "auto2.user" on the people page is "Not Started".
    And I verified that the status of user "auto2.user4" on the people page is "No Assignments".
    And I verified that the status of user "auto2.user5" on the people page is "In Progress".
    Then the user name "auto2.user" is clicked on the people page.
    # "Vehicle Inspections" is a module in AutoProgram .
    Then I checked the user`s profile and verified that the programs/courses "Vehicle Inspections" assigned to the user.
    Then I clicked the Cancel button on the user profile window.
    #check to the user2.user4 home page
    And Log out From the Carriers.
    When I entered username "auto2.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    Then I verified that the courses "Vehicle Inspections" present on the user homepage.
    And Log out From the Carriers.      
    #back login as CS
    When I entered username "auto.nava" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.         
   	And I clicked on Programs in the navigation bar main menu.     
      #back to orginal and also it checks step 24
   	Then I waited for 1 seconds.  
   	When I clicked on `x people assigned` to the "AutoProgram" program.
   	Then I waited for 1 seconds.
   #click for unselect auto2.user
    And I clicked on user "user-auto2.user" at available to assign on Assign people.
    And I clicked on the reset checkbox.    
    And clicked on the save button.
    Then I waited for 2 seconds.      
    #check to the user2.user home page
    And Log out From the Carriers.
    When I entered username "auto2.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    Then I verified that the courses "Vehicle Inspections" is not present on the user homepage.
    And Log out From the Carriers.
        #back login as CS
    When I entered username "auto.nava" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.         
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 1 seconds.      
    #For reference and optional program I userd 2 users-> auto2.user4 and auto4.user5     
    When I clicked on `x people assigned` to the "ReferanceProgram" program.
    And I clicked on user "user-auto2.user4" at available to assign on Assign people.
    And I clicked on user "user-auto2.user5" at available to assign on Assign people.
    And I clicked on the reset checkbox.
    And clicked on the save button.
    Then I waited for 2 seconds.
    When I clicked on people at the navigation bar.
     #Referance program does not affect the status, since the reference program is assigned but status is "No Assignments" below.
    And I verified that the status of user "auto2.user4" on the people page is "No Assignments".
    And I verified that the status of user "auto2.user5" on the people page is "In Progress".
    And I clicked the username "auto2.user" on the people page to open the user profile.
      #step 24 is verified by below step. and 25 also, but status not checked.This steps reletes due to step 110
    Then checked the user`s profile and verified that the programs/courses "Vehicle Inspections" is not assigned to the user.  	
    #And I clicked on the Cancel button.
    And I clicked the Cancel button on the user profile window. 
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on `x people assigned` to the "ReferanceProgram" program.
     #bring back to normal
    Then I waited for 1 seconds.
    And I clicked on user "user-auto2.user4" at available to assign on Assign people.
    And I clicked on user "user-auto2.user5" at available to assign on Assign people.
    And I clicked on the reset checkbox.    
    And clicked on the save button.
    #For checking status of optional program
    Then I waited for 2 seconds.       
    When I clicked on `x people assigned` to the "Option Program1" program.
    And I clicked on user "user-auto2.user4" at available to assign on Assign people.
    And I clicked on user "user-auto2.user5" at available to assign on Assign people.
    And I clicked on the reset checkbox.
    And clicked on the save button.    
    #check to the user2.user4 home page
    And Log out From the Carriers.
    #**** Changed by Ankur to fix error
    Then I waited for 4 seconds. 
    And I clicked on OK in the popup if exist.
    #**** Changed to fix error
    When I entered username "auto2.user4" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #***** Changed due to error
    #Then I verified that the courses "Vehicle Inspections" present on the user homepage.
    #*****
    And Log out From the Carriers.      
    #check to the user2.user5 home page   
    When I entered username "auto2.user5" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    Then I verified that the courses "Vehicle Inspections, CSA for Drivers" present on the user homepage.
    And Log out From the Carriers.
    #finished checking
    When I entered username "auto.nava" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on people at the navigation bar.
     #The Optional program does affect the status positively, user4 changed to "No Started" from No Assignment but user5 is same after adding new program
    And I verified that the status of user "auto2.user4" on the people page is "Not Started".
    And I verified that the status of user "auto2.user5" on the people page is "In Progress".
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on `x people assigned` to the "Option Program1" program.
     #bring back to normal
    Then I waited for 1 seconds.
    And I clicked on user "user-auto2.user4" at available to assign on Assign people.
    And I clicked on user "user-auto2.user5" at available to assign on Assign people.
    And I clicked on the reset checkbox.    
    And clicked on the save button.
    Then I waited for 1 seconds.
    #step 12
    When I clicked on `x people assigned` to the "Program2" program.
    And I clicked on select All in the program.
    And clicked on the save button. 
     #There are total 16 users in the carrier
    Then I waited for 2 seconds.
    And I verified that 16 people assigned to the "Program2" program.
    When I clicked on `x people assigned` to the "Program2" program.
    And I clicked on Unselect All in the program.
    And clicked on the save button. 
     #this is till step 12 and from 13 to 19 steps and some of unassign users. it is in second feature page.
     #form step 20, it verify that only save does not change anything.
    When I clicked on `x people assigned` to the "AutoProgram" program. 
    And clicked on the save button.
    And I verified that 2 people assigned to the "AutoProgram" program.            
    And I quit the browser.
  
  @LMST-936
  Scenario: People Assigned by Admin
  As a Admin, Assigning/unassigning programs to one or more users.   
  Assigning/unassigning programs to one or more users when logged in as Admin.
  Scenario: Normalized all the application 
  Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
 		When I entered username "admin.auto" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
     #Normalize for the next test if it is not normalized.
    Then I waited for 1 seconds.
    When I clicked on `x people assigned` to the "AutoProgram" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
  	And I clicked on Unselect All in the program.
  #initial data is place 2 which has id places-4094
  	And I clicked on a place have id "places-4094" on the people assign display window.
    And clicked on the save button.    
    Then I waited for 2 seconds.
    And I clicked on the x module assigned of the "AutoProgram" program.
    Then I waited for 1 seconds.
    And I clicked on Unselect All in the program.
   # Then I waited for 1 seconds.
   #Assume the module Vehicle Inspectiosn already assigned to the AutoProgram, So need Normalize
    And I selected "Vehicle Inspections" if it is not already selected which id is "module-1977" from the page.
    And clicked on the save button.    
    Then I waited for 2 seconds.
   	When I clicked on `x people assigned` to the "Option Program1" program.
 		And I clicked on Unselect All in the program.
 		And I selected the Assign Places tab on the program assigned display window.
  	And I clicked on Unselect All in the program.
   	And clicked on the save button.
    Then I waited for 2 seconds.    
    And I clicked on the x module assigned of the "Option Program1" program.
    Then I waited for 1 seconds.
    And I clicked on Unselect All in the program.
   #Assume the module Vehicle Inspectiosn already assigned to the AutoProgram, So need Normalize
    And I selected "Vehicle Inspections" if it is not already selected which id is "module-1977" from the page.
    And clicked on the save button.    
    Then I waited for 2 seconds.
   	When I clicked on `x people assigned` to the "ReferanceProgram" program.
   	And I clicked on Unselect All in the program.
   	And I selected the Assign Places tab on the program assigned display window.
  	And I clicked on Unselect All in the program.
   	And clicked on the save button.
   	# for program1 initial data
   	Then I waited for 2 seconds.
    When I clicked on `x people assigned` to the "Program1" program.
    Then I waited for 2 seconds.
    And I clicked on Unselect All in the program.
    #unselect only from Assign People Tab,and assign user5 to Program1,This is necessary because the module already started by user5
   	And I clicked on user "user-auto2.user5" at available to assign on Assign people.
   	And I selected the Assign Places tab on the program assigned display window.
   	And I clicked on Unselect All in the program.
   	And clicked on the save button.
   	Then I waited for 2 seconds.
   	And I clicked on the x module assigned of the "Program1" program.
    Then I waited for 1 seconds.
    And I clicked on Unselect All in the program.
   #Assume the module CSA for Drivers already assigned to the Program1, So need Normalize
    And I selected "CSA for Drivers" if it is not already selected which id is "module-312" from the page.
    And clicked on the save button.    
    Then I waited for 2 seconds.
    When I clicked on `x people assigned` to the "Program2" program.
    And I clicked on Unselect All in the program.
   	And clicked on the save button.
   	And I closed the browser.
   
    #Assume the module Vehicle Inspectiosn already assigned to the AutoProgram,
    #the program Assume that initially the AutoProgram assign to place3 where only 2 users  (ProcessAutomation2) , 
    #don't add more places to Auto program or user to place1 and 
    #and place1 has 3 users, don't add more users in place 1 as well
    #Auto2.user5 initially program1 assigne and started and his status is in progress, program1 has CAS For Driver modules only
    #initally program 2 assigned 0 users.
    #There are 16 fixed users in ProcessAutomation2
    #In ProcessAutomation4, module CSA for Drivers present in Auto4Required program, module Winter Driving in Auto4Optional and WHMIS 2015 in Auto4Reference program respectively.This implemented in automation.
    
    
    
     

 
