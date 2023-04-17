#Author: joshinavraj@gmail.com
# The CS user is: as.automation.cs
#test location:Head Office;
#carrier: ProcessAutomation 
 @regression @LMST-836AsWell
Feature: Add A Single User
  In this test, I am adding a single user. The test includes different scenarios, like to add a single user when I am indifferent roles like Customer support, Admin, Reginal manager, manager.
   @addSingleUserByCS
  Scenario: User Creation and Checking different fields by Customer Service role.
 	In this test, I want to add a user using a customer service account,
  I will also check different activities on user creation like default options (Role, location, Carriers), selecting different roles, locations, enter a name, password, auto-creating username, update the number of currently in use, or deleted people while adding or deleting people, and also checking the correct prop-up message to corresponding errors while filling the form and finally, the created user is deleted from the people page.
   
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "as.automation.cs" and password "test" as a customer support.
    And clicked Submit button on the login page.
     #checked for the home page
    Then I logged in successfully.
    #Normailsed code, uncomment below lines only if the program "Driver Testing" don't have assign place Automation station 2 
    #And I clicked on Programs in the navigation bar main menu.
    #When I clicked on `x people assigned` to the "Driver Testing" program.
    #And I selected the Assign Places tab on the program assigned display window.
    #Then I selected "Automation Station 2" if it is not already selected which id is "place-16874" from the page.    
    #Then I waited for 2 seconds.
    #And clicked on the save button.    
    #Then I waited for 2 seconds.
    #And I clicked on the x module assigned of the "Driver Testing" program.
    #Then I selected "CSA for Drivers" if it is not already selected which id is "module-312" from the page.
    #Then I waited for 2 seconds.
    #And clicked on the save button.
   # When I clicked on people at the navigation bar and must remove the line .
    #normalised code til here
    
    
    When I clicked on people at the navigation bar.
    When I hover over on People in people page.
    And I clicked on Add Someone icon.
    When I entered first name "nitin" in user`s profile window.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please enter a username that's 3 or more characters long".
    And I clicked Ok button on prop up.
    When I entered first name "Auto" in people page.
    And I entered last name "mation" in user`s profile window.
    #And I entered last name "mation" in people page.
    #Then username is auto generated when the username is not specified.
    Then I verified that the username is auto-generated when the username is not specified.
    And I Verified that the requestor’s carrier is defaulted in the Add user page.
    And I Verified that the user role is default set to Driver. 
     When I entered first name "Single" and last name "user", which is already exist in system.
    Then I waited for 2 seconds.
     #Check for error in the test LMST-836 scenario.or automation ticket LMS-1565

     Then I saw errorMessage "The username matches an existing, active person in your company. Click here to automatically create a new username or click on Customize to manually adjust." in People page.
    When I click on the `Click here` on the error message.
    Then I verified that the error message disappears.
    When I clicked on people at the navigation bar.
    When I hover over on People in people page.
     And I clicked on Add Someone icon.
      When I entered first name "Single" in people page.
     
    When I entered last name "newLname" in people page.
    When click on save button in user`s profile window.
    Then I saw a prop up message-"Please enter a password".
    Then I waited for 2 seconds.
    And I clicked Ok button on prop up.
    #*************************
    When I entered first name "NavaAuto" and last name "1", password "test" and Password Hint "test" in Add someone form.
    #//The email account is exist in the gmail 
    And I clicked on Email Notification and write email address "carriersedgemutiuserstest@gmail.com".
    When I selected the user role level is "Manager".
    And location is not specified.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please select a place.".
    And I clicked Ok button on prop up.
    #Repeat the steps for all role
    When I selected the user role level is "Regional Admin".
    And location is not specified.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please select a place.".
    And I clicked Ok button on prop up.
    
    When I selected the user role level is "Admin".
    And location is not specified.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please select a place.".
    And I clicked Ok button on prop up.
    
    When I selected the user role level is "Customer Support".
    And location is not specified.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please select a place.".
    And I clicked Ok button on prop up.
    
    When I choose the location "Head Office".
    And I selected the user role level is "User".
		And click on save button in user`s profile window.
		Then I waited for 5 seconds.
		#Then the user is notified by email with user credentials.
		
		Then I saw a notification about a new user created on the user`s email address at `carriersedgemutiuserstest@gmail.com`.
		    
		And the user is seen in the people page.
		
		When I hover over on last created user on the people page.
 		And I deleted the hovered user from the people page.
		And I confirmed that the number that`s at `Currently in Use` is decreased and deleted people increase by 1.
		And I closed the browser.
 
@addSingleUserByAdmin  @passwordIndependentOfLetterCase
  Scenario: User Creation and Checking different fields by Admin.
  I will also check different activities on user creation like default options (Role, location, Carriers),
   selecting different roles, locations, enter a name, auto-creating username, 
   license check, password independent of the letter case,update the number of currently in use,
    or deleted people while adding or deleting people, and also checking the correct prop-up message to corresponding errors while filling the form and finally,
     the created user is deleted from the people page.
   
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
   	#When I entered username "as.automation.cs" and password "test" as a customer support.
 		When I entered username "as.automation.admin" and password "test".
   And clicked Submit button on the login page.
     #checked for the home page
    Then I logged in successfully.
    Then I waited for 5 seconds.
    When I clicked on people at the navigation bar.
    #check for people page contaning elements like People, Show org chart, Places
   # Then I saw people page.
    When I hover over on People in people page.
    And I clicked on Add Someone icon.
    When I entered first name "nitin" in user`s profile window.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please enter a username that's 3 or more characters long".
    And I clicked Ok button on prop up.
    When I entered first name "Auto" in people page.
    And I entered last name "mation" in user`s profile window.
    #Then username is auto generated when the username is not specified.
    Then I verified that the username is auto-generated when the username is not specified.
    And I Verified that the requestor’s carrier is defaulted in the Add user page.
    And I Verified that the user role is default set to Driver. 
    When I entered first name "Single" and last name "user", which is already exist in system.
    Then I waited for 2 seconds.
   
   #Check for error in the test LMST-836 scenario.or automation ticket LMS-1565

     Then I saw errorMessage "The username matches an existing, active person in your company. Click here to automatically create a new username or click on Customize to manually adjust." in People page.
    When I click on the `Click here` on the error message.
    Then I verified that the error message disappears.
    When I clicked on people at the navigation bar.
    When I hover over on People in people page.
     And I clicked on Add Someone icon.
      When I entered first name "Single" in people page.
   
    When I entered last name "newLname" in people page.
    When click on save button in user`s profile window.
    Then I saw a prop up message-"Please enter a password".
    Then I waited for 2 seconds.
    And I clicked Ok button on prop up.
    When I entered first name "NavaAuto" and last name "1", password "tEsT" and Password Hint "test" in Add someone form.
    #//The email account is accessible by the automation.
    #uncomment the below steps with step 74. 
    And I clicked on Email Notification and write email address "carriersedgemutiuserstest@gmail.com".
    When I selected the user role level is "Manager".
    And location is not specified.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please select a place.".
    And I clicked Ok button on prop up.
    #Repeat the steps for all role
    When I selected the user role level is "Regional Admin".
    And location is not specified.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please select a place.".
    And I clicked Ok button on prop up.
    
    When I selected the user role level is "Admin".
    And location is not specified.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please select a place.".
    And I clicked Ok button on prop up.
    
    #When I selected the user role level is "Customer Support".
    When I checked for the user role "Customer Support" option is not present in the dropdown.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please select a place.".
    And I clicked Ok button on prop up.
    
    When I choose the location "Head Office".
    And I selected the user role level is "User".
    When I choose the location "Automation Region 2 - Automation Station 2".
		And click on save button in user`s profile window.
		#uncomment any of 2 below steps with step 43.
		#Then the user is notified by email with user credentials.
		Then I waited for 5 seconds.
		Then I saw a notification about a new user created on the user`s email address at `carriersedgemutiuserstest@gmail.com`.
		Then I confirmed that `the total spaces available` are greater than or equal to `currently in use`(license checked).        
		And I confirmed that the number that`s at `Currently in Use` is increased by 1.
		And the user is seen in the people page.
		When I clicked the newly created user in people page. 
		Then I verified that the programs/courses "CSA for Drivers" assigned as per user location.
		#For verifying Password is independent of letter case
		And Log out From the Carriers.
		When I enter as a newly created username and password "TeSt".
		 And clicked Submit button on the login page.
    Then I logged in successfully which proved that the password is independent of the letter case.
    And Log out From the Carriers.
    
		When I entered username "as.automation.admin" and password "test" as a customer support.
		And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on people at the navigation bar.

		When I hover over on last created user on the people page.
 		And I deleted the hovered user from the people page.
		And I confirmed that the number that`s at `Currently in Use` is decreased and deleted people increase by 1.
		And I closed the browser.
		
			@addSingleUserByReginalAdmin
  Scenario: User Creation and Checking different fields by Reginal Admin.
  In this test, I want to add a user using Reginal Admin account,
  I also check different activities on user creation like default options (Role, location, Carriers), 
  selecting different roles, location, enter a name, password, auto-creating username, absence of license check,could not create Customer care, Admin role user,
   and also checking the correct prop-up message to corresponding errors while filling the form and finally, the created user is deleted from the people page.
   
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
   	#When I entered username "as.automation.cs" and password "test" as a customer support.
 		When I entered username "as.automation.radmin" and password "test".
   And clicked Submit button on the login page.
     #checked for the home page
    Then I logged in successfully.
    When I clicked on people at the navigation bar.
    #check for people page contaning elements like People, Show org chart, Places
   # Then I saw people page.
    When I hover over on People in people page.
    And I clicked on Add Someone icon.
    When I entered first name "nitin" in user`s profile window.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please enter a username that's 3 or more characters long".
    And I clicked Ok button on prop up.
    When I entered first name "Auto" in people page.
    And I entered last name "mation" in user`s profile window.
    #Then username is auto generated when the username is not specified.
    Then I verified that the username is auto-generated when the username is not specified.
    And I Verified that the requestor’s carrier is defaulted in the Add user page.
    And I Verified that the user role is default set to Driver. 
    When I entered first name "Single" and last name "user", which is already exist in system.
    Then I waited for 2 seconds.
   
   #Check for error in the test LMST-836 scenario.or automation ticket LMS-1565

     Then I saw errorMessage "The username matches an existing, active person in your company. Click here to automatically create a new username or click on Customize to manually adjust." in People page.
    When I click on the `Click here` on the error message.
    Then I verified that the error message disappears.
    When I clicked on people at the navigation bar.
    When I hover over on People in people page.
     And I clicked on Add Someone icon.
      When I entered first name "Single" in people page.
   
    When I entered last name "newLname" in people page.
    When click on save button in user`s profile window.
    Then I saw a prop up message-"Please enter a password".
    Then I waited for 2 seconds.
    And I clicked Ok button on prop up.
    When I entered first name "NavaAuto" and last name "1", password "test" and Password Hint "test" in Add someone form.
    #//The email account is accessible by the automation.
    #uncomment the below steps with step 74. 
    And I clicked on Email Notification and write email address "carriersedgemutiuserstest@gmail.com".
    When I selected the user role level is "Manager".
    And location is not specified.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please select a place.".
    And I clicked Ok button on prop up.
    #Repeat the steps for all role
    When I selected the user role level is "Regional Admin".
    And location is not specified.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please select a place.".
    And I clicked Ok button on prop up.
   
    Then I checked for the user role "Customer Support" option is not present in the dropdown.
    And I checked for the user role "Admin" option is not present in the dropdown.

    And I selected the user role level is "User".
    When I choose the location "Automation Region 2 - Automation Station 2".
		And click on save button in user`s profile window.
		#uncomment any of 2 below steps with step 43.
		#Then the user is notified by email with user credentials.
		Then I waited for 5 seconds.
		Then I saw a notification about a new user created on the user`s email address at `carriersedgemutiuserstest@gmail.com`.
		#The below steps can not check for Reginal Admin because Total Avaliable user is not present 
		#Then I confirmed that `the total spaces available` are greater than or equal to `currently in use`(license checked).        
		And I confirmed that the number that`s at `Currently in Use` is increased by 1.
		And the user is seen in the people page.
		When I clicked the newly created user in people page. 
		Then I verified that the programs/courses "CSA for Drivers" assigned as per user location.
		Then I clicked the Cancel button on the user profile window.
		
		When I hover over on last created user on the people page.
 		And I deleted the hovered user from the people page.
		And I confirmed that the number that`s at `Currently in Use` is decreased and deleted people increase by 1.
		And I closed the browser.
		
		@addSingleUserByDriverManager
  Scenario: User Creation and Checking different fields by Driver Manager.
  In this test, I want to add a user using the Driver manager role, 
    I also check different activities on user creation like   location,
     enter a name, password, auto-creating a username, absence of license check,
      correct default course presence, correct Manager name
   and checking the correct prop-up message to corresponding errors while filling the form.
   
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
   	#When I entered username "as.automation.cs" and password "test" as a customer support.
 		When I entered username "as.auto.mgr" and password "test".
   	And clicked Submit button on the login page.
     #checked for the home page
    Then I logged in successfully.
    When I clicked on people at the navigation bar.
    #check for people page contaning elements like People, Show org chart, Places
   # Then I saw people page.
    When I hover over on People in people page.
    And I clicked on Add Someone icon.
    When I entered first name "nitin" in user`s profile window.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please enter a username that's 3 or more characters long".
    And I clicked Ok button on prop up.
    When I entered first name "Auto" in people page.
    And I entered last name "mation" in user`s profile window.
    #Then username is auto generated when the username is not specified.
    Then I verified that the username is auto-generated when the username is not specified.        
    When I entered first name "Single" and last name "user", which is already exist in system.
    Then I waited for 2 seconds.
   
   #Check for error in the test LMST-836 scenario.or automation ticket LMS-1565

     Then I saw errorMessage "The username matches an existing, active person in your company. Click here to automatically create a new username or contact your admin to create and customize the username." in People page.
    When I click on the `Click here` on the error message.
    Then I verified that the error message disappears.
    When I clicked on people at the navigation bar.
    When I hover over on People in people page.
     And I clicked on Add Someone icon.
      When I entered first name "Single" in people page.
   
    When I entered last name "newLname" in people page.
    When click on save button in user`s profile window.
    Then I saw a prop up message-"Please enter a password".
    Then I waited for 2 seconds.
    And I clicked Ok button on prop up.
    When I entered first name "NavaAuto" and last name "1", password "test" and Password Hint "test" in Add someone form.
    #//The email account is accessible by the automation.
    And I clicked on Email Notification and write email address "carriersedgemutiuserstest@gmail.com".
    And location is not specified.
    And click on save button in user`s profile window.
    Then I saw a prop up message-"Please select a place.".
    And I clicked Ok button on prop up.
    When I choose the location "Automation Region 2 - Automation Station 2".
      
		And click on save button in user`s profile window.
		Then I waited for 5 seconds.
		Then I saw a notification about a new user created on the user`s email address at `carriersedgemutiuserstest@gmail.com`.
		
		And I confirmed that the number that`s at `Currently in Use` is increased by 1.
		And the user is seen in the people page.
		When I clicked the newly created user in people page. 
		Then I verified that the programs/courses "CSA for Drivers" assigned as per user location.
		And Log out From the Carriers.
		#only for checking manager , Since From Driver manager account, The manager can not be seen.
		When I entered username "as.automation.cs" and password "test" as a customer support.
		And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on people at the navigation bar.
		When I clicked the newly created user in people page. 
		Then I verified that the programs/courses "CSA for Drivers" assigned as per user location.
		Then I verified from the user profile that the assigned manager of the user is "Auto mgr".
		 Then I clicked the Cancel button on the user profile window.
		When I hover over on last created user on the people page.
 		And I deleted the hovered user from the people page.
		And I confirmed that the number that`s at `Currently in Use` is decreased and deleted people increase by 1.
		And I quit the browser.
    
    
    
   #Note: Carrier Process Automation have program"Driving Testing" which must contatin 1 Module "CAS for Driver" must assigned to place "Automation Region 2 - Automation Station 2"
     #The test carrier is ProcessAutomation
     # as.automation.admin, as.automation.radmin, and as.auto.mgr must be in same place "Automation Region 2 - Automation Station 2" since the only place the program "CAS for Driver Assigned".
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     

  