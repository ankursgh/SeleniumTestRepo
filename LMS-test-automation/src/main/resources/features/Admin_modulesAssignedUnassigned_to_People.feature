#Author: Ankur.shukla
#Role - Admin: Programs >> Module >> Show Modules >> People Assigned/unassigned , Test-LMST-956

Feature: Assigning and Unassigning modules to users. The application does not check few bugs knowingly.These steps are 8 and 9,
	@LMST-717
  Scenario: Assigning and Unassigning modules to users when logged in as Customer Support.
  	Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    #Step 1
 		When I entered username "autom.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.    
    And I clicked on Programs in the navigation bar main menu.
    #Normalize Winter Driving module
	 	When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
	 	Then I waited for 6 seconds.
	 	And I clicked on Unselect All.
	 	Then I waited for 6 seconds.
	 	Then I clicked on the Add To Program tab in the selected module. 
	 	And I clicked on Unselect All.
	 	And clicked on the save button.
	  Then I waited for 6 seconds.
	 	#Step 2
	 	And I verified that 0 people assigned to the "Winter Driving" module which id is "module-250" on the Show Modules page.	 	 	
	 	When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
	 	#Step 3
	 	When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
	 	#**********Here
	 	Then I waited for 6 seconds.
	 	Then I clicked on the user "user-random.102" on the Assign people tab.
	 	And I clicked on the reset checkbox.
    And clicked on the save button.		
    Then I waited for 6 seconds.
		When I clicked on people at the navigation bar.
		#Step 4		
		And I clicked the username "random.102" on the people page to open the user profile.
		Then I waited for 6 seconds.
		And I verified that the modules "Winter Driving" present in the user profile.
		Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
		And I clicked the Cancel button on the user profile window.
		#Step 5
		And I verified that the status of user "random.102" on the people page is "Not Started".
		#Step 6
		And I clicked on Programs in the navigation bar main menu.
	 	When I clicked on the Show Modules icon on the People page.
		And I verified that 1 people assigned to the "Winter Driving" module which id is "module-250" on the Show Modules page.	
		#Step 7 , Guide text is not present.
		And Log out From the Carriers.
   	When I entered username "random.102" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.    	    
		And I verified that the modules "Winter Driving" present under the "Individually Assigned Modules" on the user home page.
		And Log out From the Carriers.
   	When I entered username "autom.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
	 	When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
	 	And I clicked on Unselect All.
	  And I clicked on select All in the program.   
	  	#**********Here
	 	Then I waited for 6 seconds. 
    And I clicked on the reset checkbox.
    And I checked on the `Notify People They have been Assigned to a Program`.
    And clicked on the save button.
     	#**********Here
	 	Then I waited for 59 seconds.
     #***********Commented below for admin role
      And I checked a user`s email and verified that the user got a notification that contains "Random, Winter Driving" about the course or login.
      #Till here
     #And I verified that 706 people assigned to the "Winter Driving" module which id is "module-250" on the Show Modules page.
      #Step 13
    When I clicked on people at the navigation bar.
    Then the user name "random.100" is clicked on the people page.
    #Then I waited for 5 seconds.
    And I clicked on the Email icon on the user profile.
    And I saw a pop up message-"The email has been sent successfully".
    And I clicked Ok button on pop up.
    And I clicked the Cancel button on the user profile window.
    Then I waited for 4 seconds.
    And I clicked on Programs in the navigation bar main menu.
     #step 10
    Then I waited for 4 seconds.
	 	When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
	 	#***************Here
	 	Then I waited for 9 seconds.
    Then I clicked on the user "user-random.1" on the Assign people tab.
    Then I clicked on the user "user-random.10" on the Assign people tab.
    Then I clicked on the user "user-random.100" on the Assign people tab.
    And clicked on the save button.
    Then I waited for 6 seconds.
     
     #Step 11  notify done in above step 8 or 9 and only verify below
     When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
     Then I waited for 6 seconds.
     And I clicked on Unselect All.
     Then I waited for 6 seconds.
     Then I clicked on the user "user-random.1" on the Assign people tab.
     And I clicked on the reset checkbox.
     And I checked on the `Notify People They have been Assigned to a Program`.
    #And I checked on the `Include login details in the notification`.
     Then I waited for 2 seconds.
     And clicked on the save button.
     And I checked a user`s email and verified that the user got a notification that contains "Random, Winter Driving" about the course or login.
      #Step 12
     When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
     	#***************Here
	 	 Then I waited for 6 seconds.
     Then I clicked on the user "user-random.100" on the Assign people tab.
     And I clicked on the reset checkbox.
     And I checked on the `Notify People They have been Assigned to a Program`.
     And I checked on the `Include login details in the notification`.
     Then I waited for 2 seconds.
     And clicked on the save button.
     And I checked a user`s email and verified that the user got a notification that contains "Random, Winter Driving, Username: random.100, Password hint:" about the course or login.
     When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    #Then I waited for 2 seconds.
     And clicked on the save button.
     Then I waited for 1 seconds.
     And I verified that 2 people assigned to the "Winter Driving" module which id is "module-250" on the Show Modules page.	
    
     When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
     Then I waited for 1 seconds.
     Then I verified that the guide text presents "Random 1, Random 100" when I hovered over on x people assigned on a module in the shows module page.
     
     # Steps 20
     When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    	#***************Here
	 	 Then I waited for 6 seconds.
     Then I clicked on the user "user-random.1" on the Assign people tab.
     And clicked on the save button.
     Then I waited for 1 seconds.
     When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
     Then I verified that the guide text not presents "Random 1" when I hovered over on x people assigned on a module in the shows module page.
      # Steps 21	
      When I clicked on people at the navigation bar. 	
      And I clicked the username "random.102" on the people page to open the user profile.
		#And I verified that the modules "Winter Driving" present in the user profile.
		 And I verified that the modules "Winter Driving" not present in the user profile.
		 And I clicked the Cancel button on the user profile window.		
		
     # Steps 22
		And I verified that the status of user "random.102" on the people page is "No Assignments".
    # Steps 23
    And I clicked on Programs in the navigation bar main menu.
	 	When I clicked on the Show Modules icon on the People page.
    And I verified that 1 people assigned to the "Winter Driving" module which id is "module-250" on the Show Modules page.
     # Steps 24
     
      And Log out From the Carriers.
   	When I entered username "random.102" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully. 
   	    
		And I verified that the modules "Winter Driving" is not present on the user homepage.
		 And Log out From the Carriers.
   	When I entered username "autom.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    
    And I clicked on Programs in the navigation bar main menu.
	 	When I clicked on the Show Modules icon on the People page.
    	Then I waited for 12 seconds.
    # Steps 25
    	When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
	 	And I clicked on Unselect All.
	 	And clicked on the save button.
	 		#***************Here
	 	Then I waited for 8 seconds.
	 	And I verified that 0 people assigned to the "Winter Driving" module which id is "module-250" on the Show Modules page.
	 	# Steps 26
	 	When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
	 	And I clicked on Unselect All.
	 
	 	Then I clicked on the user "user-random.10" on the Assign people tab.
	 	Then I clicked on the user "user-random.110" on the Assign people tab.
	 	And clicked on the save button.
	 		Then I waited for 4 seconds.
	 	And I verified that 2 people assigned to the "Winter Driving" module which id is "module-250" on the Show Modules page.
	 	  When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
     Then I waited for 1 seconds.
     Then I verified that the guide text presents "Random 10, Random 110" when I hovered over on x people assigned on a module in the shows module page.
	 	 # Steps 27
	 	 When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
	 	 And clicked on the save button.
	 	 	And I verified that 2 people assigned to the "Winter Driving" module which id is "module-250" on the Show Modules page.
	 	 # Back to Normal Winter Driving module
	 	 Then I waited for 1 seconds.
	 	 When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
	 	And I clicked on Unselect All.
	 	And clicked on the save button.
	 	#Then I waited for 1 seconds.
	  And I quit the browser.
	  
	  #Note: This automation used module "Winter Driving" to assign an uassign users and check different properties while assigning and unassigning.