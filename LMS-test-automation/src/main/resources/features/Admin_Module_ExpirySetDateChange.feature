#Author: ankur.shukla@rsystems.com
#Test Case - Role - Admin: Programs >> Module >> Show Modules >>  Expiry Set/Data Change @LMST-959
@LMST-959

Feature: Click first link under various module types and make changes to module limits, expiry, etc.
Since the test is very big and difficult to mantain and check so it is divided in to verious scenarios.
As a Customer support, Click first link under various module types and make changes to module limits, expiry, etc.
	
	#Step 1 to 33 of @LMST-959
	
	Scenario:Click first link under full course module types and make changes to module limits, expiry, etc.
 	Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    #Step 1
 		When I entered username "autom.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.    
    And I clicked on Programs in the navigation bar main menu.
   #Normalizarion  Automation Testing Full Course    
    When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Automation Testing Full Course" module which id is "module-9497".
	 	And I clicked on Unselect All in the program.
	 	And clicked on the save button.
	 	Then I waited for 2 seconds.
	 	 When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Automation Testing Full Course" module which id is "module-9497".
	 	And I clicked on user-id "user-random.115" to select the user if not already selected.
	 	Then I waited for 4 seconds.
	 	And I clicked on the reset checkbox.
   	And I selected the Assign Places tab on the program assigned display window. 
   	And I clicked on Unselect All in the program. 
   	And clicked on the save button.
   	Then I waited for 2 seconds.
	 	When I clicked on the deadline link of the "Automation Testing Full Course" module.
	 	 Then I waited for 1 seconds.
	 	 And I selected the option, This module doesn`t need to be retaken after a set period of time.
	 	 And I selected the option, This module can be taken an unlimited number of times.
	 	 And I selected the option, The test in this module must be completed in the default amount of time Three hrs.
	 	 And I unselected the option, Prevent users from advancing until all required links are clicked and sound is finished.
	 	 And I unselected the option, Prevent users from advancing until all checkpoint questions are answered correctly.
	 	 And I selected the option, This module has no associated compensation rate.
	 	 And I selected the option, This module can be assigned by Admins, Regional Admins, and Managers.	 	
	 	 And clicked on the save button. 
	 	 Then I waited for 2 seconds.	 	
	 	#Normalize Fire Safety
	 		 	
	 	When I clicked on the Show Modules icon on the People page.
	 	#When I scrolled down the entire window by 200 px.
	 	When I clicked on `x people assigned` to module "Fire Safety" module which id is "module-516".
	 	And I clicked on Unselect All in the program.
	 	And I clicked on user-id "user-random.22" to select the user if not already selected.
   	And I selected the Assign Places tab on the program assigned display window. 
   	And I clicked on Unselect All in the program. 
   	And clicked on the save button.
   	Then I waited for 2 seconds.	
   
   	
   	When I clicked on the deadline link of the "Fire Safety" module.
	 	 Then I waited for 2 seconds.
	 	 And I selected the option, This module doesn`t need to be retaken after a set period of time.
	 	 And I selected the option, This module can be taken an unlimited number of times.
	 	 And I selected the option, The test in this module must be completed in the default amount of time Three hrs.
	 	 And I unselected the option, Prevent users from advancing until all required links are clicked and sound is finished.
	 	 And I unselected the option, Prevent users from advancing until all checkpoint questions are answered correctly.
	 	 And I selected the option, This module has no associated compensation rate.
	 	 And I selected the option, This module can be assigned by Admins, Regional Admins, and Managers.	 	
	 	 And clicked on the save button. 
	 	 Then I waited for 2 seconds.	 	
   
 	#did not work if the wait time is less than 4 second
	 	Then I waited for 4 seconds.	 	 
	 	 #Step 2
	 	 Then I verified that the display guide of the "Automation Testing Full Course" module showed "No expiry set" (days).
	 	 	 	 	 
	 	# Then I verified that when hovered over the mouse on the deadline link of the "Automation Testing Full Course" the display message warns "This module doesn't need to be retaken after a set period of time.".
	 #	 And I verified that when hovered over the mouse on the deadline link of the "Automation Testing Full Course" the display message warns "This module can be taken an unlimited number of times.".
	 	 #Step 3	 	 	 	 
	 	 When I clicked on the deadline link of the "Automation Testing Full Course" module.
	 	 Then I waited for 2 seconds.
	 	 And I selected the option, This module doesn`t need to be retaken after a set period of time.
	 	 #Step 4
	 	 And I selected the option, This module can be taken an unlimited number of times.
	 	 #Step 5
	 	 And I selected the option, The test in this module must be completed in the default amount of time Three hrs.
	 	 
	 	 #Step 6
	 	 #And I clicked the option, Prevent users from advancing until all required links are clicked and sound is finished.
	 	 And I unselected the option, Prevent users from advancing until all required links are clicked and sound is finished.
	 	 #And I clicked the option, Prevent users from advancing until all checkpoint questions are answered correctly.
	 	 And I unselected the option, Prevent users from advancing until all checkpoint questions are answered correctly.
	 	#Step 7
	 	 And I selected the option, This module has no associated compensation rate.
	 	 #Step 8
	 	 And I selected the option, This module can be assigned by Admins, Regional Admins, and Managers.
	 	 #Step 9
	 	 And clicked on the save button. 
	 	 Then I waited for 2 seconds.	 	 
	 	 #Step 10
	 	 Then I verified that the display guide of the "Automation Testing Full Course" module showed "No expiry set" (days). 
	 	
	 	 #Step 11
	 	  When I clicked on the deadline link of the "Automation Testing Full Course" module.
	 	   Then I waited for 2 seconds.	
	 	  And clicked on the save button. 
	 	  Then I waited for 2 seconds.
	 	  
	 	  
	 	  # other non change is verify later.
	 	  #Step 12
	 	  # Step 12 will take long time to write running the test and need more research, will talk to tommy and decide later.
	 	And Log out From the Carriers.
	 	When I entered username "random.115" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    
     #Play the module    
    When I clicked on the module "Automation Testing Full Course" to play on the user homepage.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the continue button on the content if the content is currently in progress.
    #Then I waited for 1 seconds.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the blue button to continue on the page.
    And I clicked on the right arrow until right arrow seen on the content.
    And I clicked on the final test button on the page.
		
		 Then I waited for 4 seconds.
    And I selected "1st question`s options" if it is not already selected which id is "answer_188768" from the page.
    And I selected "2nd question`s options" if it is not already selected which id is "answer_188771" from the page.
    And I selected "3rd question`s options" if it is not already selected which id is "answer_188774" from the page.
    #This verified that the module can be taken. 
    Then I verified that I saw submit button on the test.
    And I clicked on the submit button.
    And I clicked on the close button.
    
     #Play test 2nd times
    And I come back to the default frame. 
    #Test Again
    Then I waited for 4 seconds.
    #***************************
   
   	And Log out From the Carriers.
	 	 #Step 13
	 	 When I entered username "autom.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.    
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
	 	 	 
	 	 Then I verified that the display guide of the "Fire Safety" module showed "No expiry set" (days). 	 	 
	 	 Then I verified that when hovered over the mouse on the deadline link of the "Fire Safety" the display message warns "This module doesn't need to be retaken after a set period of time.".
	 	 And I verified that when hovered over the mouse on the deadline link of the "Fire Safety" the display message warns "This module can be taken an unlimited number of times.".	 	 	 	 	 
	 	 When I clicked on the deadline link of the "Fire Safety" module.
	 	 Then I verified that expiry options "Module Expiry / Retraining Interval, Module Limits / Locks, Test Time Limit, Module Lockdown, Module Pay Rate, Assignment Controls" are displayed on the module.
	 		 	
	 	#Step 14
	 	And I selected the option, This module needs to be retaken every 15 "days". Notify people 30 days before this module expires.
	 	And clicked on the save button. 
	 	  Then I waited for 2 seconds.
	 	 #Step 15
	 	 Then I verified that when hovered over the mouse on the deadline link of the "Fire Safety" the display message warns "This module needs to be retaken every 15 days.".
	 	 #Step 16
	 	 #This step can not be tested by automation because, the expected condition has to check in future.
	 	 # For this I have to wait running application till the future date.
	 	 #Step 17
	 	 And Log out From the Carriers.
   	When I entered username "random.22" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
     And I verified that the status of module "Fire Safety" is "Not started" on the user homepage.
    And Log out From the Carriers.
   	When I entered username "autom.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.
   	 When I clicked on the Show Modules icon on the People page.
   	 
   #Step 18	 	 	 	  
	 	  
	 	 When I clicked on the deadline link of the "Automation Testing Full Course" module.
	 	 Then I verified that expiry options "Module Expiry / Retraining Interval, Module Limits / Locks, Test Time Limit, Module Lockdown, Module Pay Rate, Assignment Controls" are displayed on the module.
		
		 #Step 19
		 And I selected the option, The test in this module must be completed in 2 minutes.
		 And clicked on the save button.
		
	 	 When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Automation Testing Full Course" module which id is "module-9497".
	 	And I clicked on Unselect All in the program.
	 	And clicked on the save button.
	 	Then I waited for 2 seconds.
	 	 When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Automation Testing Full Course" module which id is "module-9497".
	 	And I clicked on user-id "user-random.116" to select the user if not already selected.
	 	Then I waited for 4 seconds.
	 	And I clicked on the reset checkbox.
   	And I selected the Assign Places tab on the program assigned display window. 
   	And I clicked on Unselect All in the program. 
   	And clicked on the save button.
   	Then I waited for 2 seconds.
	 	
		 #Step 20
		 And Log out From the Carriers.
	 	When I entered username "random.116" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I verified that the courses "Automation Testing Full Course" present on the user homepage.
    
      #Play the module    
    When I clicked on the module "Automation Testing Full Course" to play on the user homepage.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the continue button on the content if the content is currently in progress.
    #Then I waited for 1 seconds.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the blue button to continue on the page.
    And I clicked on the right arrow until right arrow seen on the content.
    And I clicked on the final test button on the page.
		
		 Then I waited for 62 seconds.
		 And I saw a pop up message-"You have 1 minute left to complete this test".
		 And I clicked Ok button on pop up.
		 And I waited for 63 seconds.
		 And I saw a pop up message-"Your time has expired in this test. You will be redirected to your CarriersEdge homepage. You may retry the test again if you like. No results have been submitted.".
		 And I clicked Ok button on pop up.
    
    And I selected "1st question`s options" if it is not already selected which id is "answer_188768" from the page.
    And I selected "2nd question`s options" if it is not already selected which id is "answer_188771" from the page.
    And I selected "3rd question`s options" if it is not already selected which id is "answer_188774" from the page.
    #This verified that the module can be taken. 
    Then I verified that I saw submit button on the test.
    
    And I clicked on the submit button.
    And I clicked on the close button.
    # Above has not compleately implemented, what happen if the user not submitted test in time?
    # Already talked to divya, if it would not come to home page, then it is a bug.
    
    
	 	 #Step 21 and Step 22
	 	 #login as CS account
	 	And Log out From the Carriers.
	 	When I entered username "autom.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.    
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
	 	 
	 	 
	 	When I clicked on the deadline link of the "Automation Testing Full Course" module.
	 	Then I waited for 1 seconds.
	 	And I selected the option, The test in this module must be completed in the default amount of time Three hrs.
	 	#Step 22
	 	And I clicked the option, Prevent users from advancing until all required links are clicked and sound is finished.
	 	 And I clicked the option, Prevent users from advancing until all checkpoint questions are answered correctly.
	 	 And clicked on the save button.
	 	 #Step 23
	 	 
	 	 #When need, copy from Get Snipped1.feature file and continue working using expected result.
	 
	 	 
	 	 #Step 24	
	 	 Then I waited for 2 seconds.
		 When I clicked on the deadline link of the "Automation Testing Full Course" module.		 	
	 	And I unselected the option, Prevent users from advancing until all required links are clicked and sound is finished.
	  And I unselected the option, Prevent users from advancing until all checkpoint questions are answered correctly.	 	
		 #Step 25
		And I selected the option, This module has an associated compensation rate of $ 5.
	 	  And clicked on the save button.
	 	 
	 	 # Add a user 118 for testing it.
	 	  When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Automation Testing Full Course" module which id is "module-9497".
	 	And I clicked on Unselect All in the program.
	 	And clicked on the save button.
	 	Then I waited for 2 seconds.
	 	 When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Automation Testing Full Course" module which id is "module-9497".
	 	And I clicked on user-id "user-random.118" to select the user if not already selected.
	 	Then I waited for 4 seconds.
	 	And I clicked on the reset checkbox.
   	And I selected the Assign Places tab on the program assigned display window. 
   	And I clicked on Unselect All in the program. 
   	And clicked on the save button.
   	Then I waited for 2 seconds.
	 	 # user added
	 	   #Step 26
	 	  #Admin acts as an account manager
	 	 And Log out From the Carriers.
    When I entered username "auto4.admin" and password "test".
    
    And clicked Submit button on the login page.
    Then I logged in successfully.
     #Step 27
		When I clicked on the billing icon.
		Then I noted the Account Balance.
		#Step 28
		#Login as a user and compleate the module
		
		And Log out From the Carriers.
	 	When I entered username "random.118" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I verified that the courses "Automation Testing Full Course" present on the user homepage.
    
      #Play the module    
    When I clicked on the module "Automation Testing Full Course" to play on the user homepage.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the continue button on the content if the content is currently in progress.
    #Then I waited for 1 seconds.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the blue button to continue on the page.
    And I clicked on the right arrow until right arrow seen on the content.
    And I clicked on the final test button on the page.	
   Then I waited for 1 seconds. 		    
    And I selected "1st question`s options" if it is not already selected which id is "answer_188768" from the page.
    And I selected "2nd question`s options" if it is not already selected which id is "answer_188771" from the page.
    And I selected "3rd question`s options" if it is not already selected which id is "answer_188774" from the page.
    #This verified that the module can be taken. 
    Then I verified that I saw submit button on the test.    
    And I clicked on the submit button.
    And I clicked on the close button.
	
	 	 #Step 29
	 	 #login as a account manager and check the additional charge added in the balance.
	 	And Log out From the Carriers. 
    When I entered username "auto4.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
		When I clicked on the billing icon.
	 	
		Then I noted the Account Balance.
		#The below function not implemented properly, have to uncommented in assertTrue function.
		Then I verified that the additional charge of $5 added to the balance.
		#For exisiting $ window
		When I clicked on the billing icon.
		
		 #Step 30
				
	 	And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    When I clicked on the deadline link of the "Automation Testing Full Course" module.
     Then I verified that expiry options "Module Expiry / Retraining Interval, Module Limits / Locks, Test Time Limit, Module Lockdown, Module Pay Rate, Assignment Controls" are displayed on the module.
     #Step 31
     And I selected the option, This module has no associated compensation rate.
     And I selected the option, This module can only be assigned by Admins.
     And clicked on the save button.
      
      #Step 32
    And Log out From the Carriers.
    When I entered username "auto4.radmin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully. 
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    Then I verified that the module "Automation Testing Full Course" not present on the Show Module Page.   
    
    #Step 33
    And Log out From the Carriers.
    When I entered username "auto4.mgr" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully. 
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    Then I verified that the module "Automation Testing Full Course" not present on the Show Module Page.
    And Log out From the Carriers.
    And I closed the browser.
    
    #Step 34
    Scenario:Click first link under Refresher course module types and make changes to module limits, expiry, etc.
  	Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "autom.cs" and password "test".
   And clicked Submit button on the login page.
    Then I logged in successfully. 
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
	 	
	 	#Repeat Step 2
	 	Then I waited for 2 seconds.
	 	And I scrolled down the entire window by 150 px.
	 		Then I waited for 6 seconds.
	 	When I clicked on `x people assigned` to module "Automation Testing Refresher" module which id is "module-9498".
	 	Then I waited for 4 seconds.
	 	And I clicked on user-id "user-random.115" to select the user if not already selected.
	 	#Error On jenkins
	 	Then I waited for 4 seconds.
	 	And I clicked on the reset checkbox.
	 	
   	And I selected the Assign Places tab on the program assigned display window. 
   	And I clicked on Unselect All in the program. 
   	And clicked on the save button.
   	Then I waited for 4 seconds.
   	And I scrolled down the entire window by 250 px.
	 	 Then I verified that the display guide of the "Automation Testing Refresher" module showed "No expiry set" (days).
	 	 	 	 	 
	 	 Then I verified that when hovered over the mouse on the deadline link of the "Automation Testing Refresher" the display message warns "This module doesn't need to be retaken after a set period of time.".
	 	 And I verified that when hovered over the mouse on the deadline link of the "Automation Testing Refresher" the display message warns "This module can be taken an unlimited number of times.".
	 	#Repeat Step 3	 	 	 	 
	 	 When I clicked on the deadline link of the "Automation Testing Refresher" module.
	 	 Then I waited for 2 seconds.
	 	 And I selected the option, This module doesn`t need to be retaken after a set period of time.
	 	#Repeat Step 4
	 	 And I selected the option, This module can be taken an unlimited number of times.
	 	#Repeat Step 5
	 	 And I selected the option, The test in this module must be completed in the default amount of time Three hrs.
	 	#Repeat Step 6
	 	 #And I clicked the option, Prevent users from advancing until all required links are clicked and sound is finished.
	 	 And I unselected the option, Prevent users from advancing until all required links are clicked and sound is finished.
	 	 #And I clicked the option, Prevent users from advancing until all checkpoint questions are answered correctly.
	 	 And I unselected the option, Prevent users from advancing until all checkpoint questions are answered correctly.
	 	#Step 7
	 	 And I selected the option, This module has no associated compensation rate.
	 	#Repeat Step 8
	 	 And I selected the option, This module can be assigned by Admins, Regional Admins, and Managers.
	 	#Repeat Step 9
	 	 And clicked on the save button. 
	 	 Then I waited for 2 seconds.	 	 
	 	#Repeat Step 10
	 		And I scrolled down the entire window by 250 px.
	 	 Then I verified that the display guide of the "Automation Testing Refresher" module showed "No expiry set" (days). 
	 	
	 	#Repeat Step 11
	 	  When I clicked on the deadline link of the "Automation Testing Refresher" module.
	 	   Then I waited for 2 seconds.	
	 	  And clicked on the save button. 
	 	  Then I waited for 2 seconds.	  
	 	  
	 	  # other non change is verify later.
	 	 #Repeat Step 12
	 	  # Step 12 will take long time to write running the test and need more research, will talk to tommy and decide later.
	 	And Log out From the Carriers.
	 	When I entered username "random.115" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    
     #Play the module    
    When I clicked on the module "Automation Testing Refresher" to play on the user homepage.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the continue button on the content if the content is currently in progress.
    #Then I waited for 1 seconds.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the blue button to continue on the page.
    And I clicked on the right arrow until right arrow seen on the content.
    And I clicked on the final test button on the page.
		
		 Then I waited for 2 seconds.
    And I selected "1st question`s options" if it is not already selected which id is "answer_188777" from the page.
    And I selected "2nd question`s options" if it is not already selected which id is "answer_188780" from the page.
    And I selected "3rd question`s options" if it is not already selected which id is "answer_188783" from the page.
    #This verified that the module can be taken. 
    Then I verified that I saw submit button on the test.
    And I clicked on the submit button.
    And I clicked on the close button.
    
     #Play test 2nd times
    And I come back to the default frame. 
   
   	And Log out From the Carriers.
	 	#Repeat Step 13
	 	 When I entered username "autom.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.    
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    Then I waited for 2 seconds.
	 	 	And I scrolled down the entire window by 250 px.	 
	 	 Then I verified that the display guide of the "Automation Testing Refresher" module showed "No expiry set" (days). 	 	 
	 	 Then I verified that when hovered over the mouse on the deadline link of the "Automation Testing Refresher" the display message warns "This module doesn't need to be retaken after a set period of time.".
	 	 And I verified that when hovered over the mouse on the deadline link of the "Automation Testing Refresher" the display message warns "This module can be taken an unlimited number of times.".	 	 	 	 	 
	 	 When I clicked on the deadline link of the "Automation Testing Refresher" module.
	 	 Then I verified that expiry options "Module Expiry / Retraining Interval, Module Limits / Locks, Test Time Limit, Module Lockdown, Module Pay Rate, Assignment Controls" are displayed on the module.
	 		 	
	 	#Step 14
	 	And I selected the option, This module needs to be retaken every 15 "days". Notify people 30 days before this module expires.
	 	And clicked on the save button. 
	 	  Then I waited for 2 seconds.
	 	
	 	#Repeat Step 15
	 	 Then I verified that when hovered over the mouse on the deadline link of the "Automation Testing Refresher" the display message warns "This module needs to be retaken every 15 days.".
	 	 
	 	 	When I clicked on `x people assigned` to module "Automation Testing Refresher" module which id is "module-9498".
	 	And I clicked on Unselect All in the program.
	 	And clicked on the save button.
	 	Then I waited for 2 seconds.
	 	 When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Automation Testing Refresher" module which id is "module-9498".
	 	And I clicked on user-id "user-random.115" to select the user if not already selected.
	 	Then I waited for 4 seconds.
	 	And I clicked on the reset checkbox.
   	And I selected the Assign Places tab on the program assigned display window. 
   	And I clicked on Unselect All in the program. 
   	And clicked on the save button.
   	Then I waited for 2 seconds.
	 	#Repeat Step 16
	 	 #This step can not be tested by automation because, the expected condition has to check in future.
	 	 # For this I have to wait running application till the future date.
	 	#Repeat Step 17
	 	 And Log out From the Carriers.
   	When I entered username "random.115" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
     And I verified that the status of module "Automation Testing Refresher" is "Not started" on the user homepage.
    And Log out From the Carriers.
   	When I entered username "autom.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.
   	 When I clicked on the Show Modules icon on the People page.
   	 
  #Repeat Step 18	 	 	 	  
	 	  
	 	 When I clicked on the deadline link of the "Automation Testing Refresher" module.
	 	 Then I verified that expiry options "Module Expiry / Retraining Interval, Module Limits / Locks, Test Time Limit, Module Lockdown, Module Pay Rate, Assignment Controls" are displayed on the module.
		
		#Repeat Step 19
		And I selected the option, This module doesn`t need to be retaken after a set period of time.
		And I selected the option, The test in this module must be completed in 2 minutes.
		And clicked on the save button.
		
	 	When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Automation Testing Refresher" module which id is "module-9498".
	 	And I clicked on Unselect All in the program.
	 	And clicked on the save button.
	 	Then I waited for 2 seconds.
	 	When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Automation Testing Refresher" module which id is "module-9498".
	 	And I clicked on user-id "user-random.116" to select the user if not already selected.
	 	Then I waited for 4 seconds.
	 	And I clicked on the reset checkbox.
   	And I selected the Assign Places tab on the program assigned display window. 
   	And I clicked on Unselect All in the program. 
   	And clicked on the save button.
   	Then I waited for 2 seconds.
	 	
		#Repeat Step 20
		 And Log out From the Carriers.
	 	When I entered username "random.116" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I verified that the courses "Automation Testing Refresher" present on the user homepage.
    
      #Play the module    
    When I clicked on the module "Automation Testing Refresher" to play on the user homepage.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the continue button on the content if the content is currently in progress.
    #Then I waited for 1 seconds.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the blue button to continue on the page.
    And I clicked on the right arrow until right arrow seen on the content.
    And I clicked on the final test button on the page.
		
		 Then I waited for 62 seconds.
		 And I saw a pop up message-"You have 1 minute left to complete this test".
		 And I clicked Ok button on pop up.
		 And I waited for 63 seconds.
		 And I saw a pop up message-"Your time has expired in this test. You will be redirected to your CarriersEdge homepage. You may retry the test again if you like. No results have been submitted.".
		 And I clicked Ok button on pop up.
    
    And I selected "1st question`s options" if it is not already selected which id is "answer_188777" from the page.
    And I selected "2nd question`s options" if it is not already selected which id is "answer_188780" from the page.
    And I selected "3rd question`s options" if it is not already selected which id is "answer_188783" from the page.
    #This verified that the module can be taken. 
    Then I verified that I saw submit button on the test.
    
    And I clicked on the submit button.
    And I clicked on the close button.
    # Above has not compleately implemented, what happen if the user not submitted test in time?
    # Already talked to divya, if it would not come to home page, then it is a bug.
    
    
	 	#Repeat Step 21 and Step 22
	 	 #login as CS account
	 	 	And Log out From the Carriers.
	 	 When I entered username "autom.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.    
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
	 	 
	 	 
	 	When I clicked on the deadline link of the "Automation Testing Refresher" module.
	 	Then I waited for 1 seconds.
	 	And I selected the option, The test in this module must be completed in the default amount of time Three hrs.
	 	#Step 22
	 	And I clicked the option, Prevent users from advancing until all required links are clicked and sound is finished.
	 	 And I clicked the option, Prevent users from advancing until all checkpoint questions are answered correctly.
	 	 And clicked on the save button.
	 	#Repeat Step 23
	 	 
	 	 #When need, copy from Get Snipped1.feature file and continue working using expected result.
	 	 
	 	#Repeat Step 24	
	 	 Then I waited for 2 seconds.
		 When I clicked on the deadline link of the "Automation Testing Refresher" module.		 	
	 	And I unselected the option, Prevent users from advancing until all required links are clicked and sound is finished.
	  And I unselected the option, Prevent users from advancing until all checkpoint questions are answered correctly.	 	
		#Repeat Step 25
		And I selected the option, This module has an associated compensation rate of $ 5.
	 	  And clicked on the save button.
	 	 
	 	 # Add a user 118 for testing it.
	 	  When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Automation Testing Refresher" module which id is "module-9498".
	 	And I clicked on Unselect All in the program.
	 	And clicked on the save button.
	 	Then I waited for 2 seconds.
	 	 When I clicked on the Show Modules icon on the People page.
	 	When I clicked on `x people assigned` to module "Automation Testing Refresher" module which id is "module-9498".
	 	And I clicked on user-id "user-random.118" to select the user if not already selected.
	 	Then I waited for 4 seconds.
	 	And I clicked on the reset checkbox.
   	And I selected the Assign Places tab on the program assigned display window. 
   	And I clicked on Unselect All in the program. 
   	And clicked on the save button.
   	Then I waited for 2 seconds.
	 	 # user added
	 	  #Repeat Step 26
	 	  #Admin acts as an account manager
	 	 And Log out From the Carriers.
    When I entered username "auto4.admin" and password "test".
    
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #Repeat Step 27
		When I clicked on the billing icon.
		Then I noted the Account Balance.
		#Step 28
		#Login as a user and compleate the module
		
		And Log out From the Carriers.
	 	When I entered username "random.118" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I verified that the courses "Automation Testing Refresher" present on the user homepage.
    
      #Play the module    
    When I clicked on the module "Automation Testing Refresher" to play on the user homepage.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the continue button on the content if the content is currently in progress.
    #Then I waited for 1 seconds.
    #And I waited until the new frame seen.
    And I changed the frame.
    And I clicked on the blue button to continue on the page.
    And I clicked on the right arrow until right arrow seen on the content.
    And I clicked on the final test button on the page.	
   Then I waited for 1 seconds. 		    
    And I selected "1st question`s options" if it is not already selected which id is "answer_188777" from the page.
    And I selected "2nd question`s options" if it is not already selected which id is "answer_188780" from the page.
    And I selected "3rd question`s options" if it is not already selected which id is "answer_188783" from the page.
    #This verified that the module can be taken. 
    Then I verified that I saw submit button on the test.    
    And I clicked on the submit button.
    And I clicked on the close button.
	 	 
	 	#Repeat Step 29
	 	 #login as a account manager and check the additional charge added in the balance.
	 	And Log out From the Carriers. 
    When I entered username "auto4.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
		When I clicked on the billing icon.
	 	
		Then I noted the Account Balance.
		#The below function not implemented properly, have to uncommented in assertTrue function.
		Then I verified that the additional charge of $5 added to the balance.
		#For exisiting $ window
		When I clicked on the billing icon.
		
		#Repeat Step 30
				
	 	And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    When I clicked on the deadline link of the "Automation Testing Refresher" module.
    Then I verified that expiry options "Module Expiry / Retraining Interval, Module Limits / Locks, Test Time Limit, Module Lockdown, Module Pay Rate, Assignment Controls" are displayed on the module.
    #Repeat Step 31
     And I selected the option, This module has no associated compensation rate.
     And I selected the option, This module can only be assigned by Admins.
     And clicked on the save button.
      
    #Repeat Step 32
     And Log out From the Carriers.
     When I entered username "auto4.radmin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully. 
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    Then I verified that the module "Automation Testing Refresher" not present on the Show Module Page.   
    
   #Repeat Step 33
      	And Log out From the Carriers.
      	 When I entered username "auto4.mgr" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully. 
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    Then I verified that the module "Automation Testing Refresher" not present on the Show Module Page.  
    And Log out From the Carriers. 
   	And I closed the browser.
    #Step 34 finished 
     #Step 35 
     
    
   