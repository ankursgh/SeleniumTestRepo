#Author: navaraj@carriersedge.com
@LMST-698 @LMST-779
Feature: Setting a program start date and expiry date as the customer support role.
Show Programs >> Expiry Set/Data Change

  Scenario: Using Customer Support account
  Given open the "chrome" browser.
   	When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
 		When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.
   	#Normalize before start the program
   #	Then I waited for 5 seconds.
   When I clicked on the x module assigned of the "PDF2" program.
   Then I waited for 2 seconds.
   #And I scrolled the small window.
    And I clicked on Unselect All in the program.
    #module-9412 is PDF View Test2
   #Then I select or unselect a module "module-9412" module to add or remove module from the program.
   And I selected "PDF View Test2" if it is not already selected which id is "module-9412" from the page.
    And clicked on the save button. 
    When I clicked on the x module assigned of the "PDF12" program.
    Then I waited for 2 seconds.
    #And I scrolled the small window.
    And I clicked on Unselect All in the program.
    #module-9411 is PDF View Test1
   Then I select or unselect a module "module-9411" module to add or remove module from the program.
   Then I select or unselect a module "module-9412" module to add or remove module from the program.  
    And clicked on the save button.
     Then I waited for 3 seconds.     	
   	When I clicked on `x people assigned` to the "PDF2" program.
    And I clicked on Unselect All in the program.
    And clicked on the save button. 
    Then I waited for 1 seconds. 
     When I clicked on `x people assigned` to the "PDF12" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
  	And I clicked on Unselect All in the program.
    And clicked on the save button. 
    Then I waited for 1 seconds.     	
         	
   # 1 this is test for remove this program when is's is complete
   	When I clicked on the deadline link of the "PDF2" program.
   	When I selected the program available immediately option.
   	#for checking step 43 as well
   	When I set the program needs to completed with no specific deadline.
   	And I selected the option `remove this program when it`s complete`.
   	And clicked on the save button.
   #	Then I waited for 5 seconds. 
   #the Guide text is for Customer Support only, 	#for checking step 44 as well
   Then I verified that the display guide of the "PDF2" program showed "No deadline set" days.   	   	      
   	When I clicked on `x people assigned` to the "PDF2" program. 
   	And I clicked on user "user-random.100" at available to assign on Assign people.
   	And I clicked on the reset checkbox.
   	Then I waited for 10 seconds.  
   	And clicked on the save button.
   Then I waited for 6 seconds.  
   #step 6
    And I verified that 1 people assigned to the "PDF2" program.    
    #check to the user2.user home page
   	And Log out From the Carriers.
   	When I entered username "random.100" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    When I verified that the courses "PDF View Test2" present on the user homepage.
    And I waited for 2 seconds.  
    When I hovered over the mouse on the program "PDF2" on the user homepage.
    #step 4
    Then I saw a display message "This program will automatically remove itself from your profile once you complete it" on the user homepage. 
   #for step 45 check 
    Then I verified that the Guide text warns does not contain "The deadline for this program is" text.
		When I clicked on the course "PDF View Test2" to play on the user homepage.
		#New Code
		Then I waited for 2 seconds.        
     Then I changed the frame.
     Then I waited for 1 seconds.
    And I clicked on the continue button on the content if the content is currently in progress.  
     Then I waited for 1 seconds.
     When I scrolled the playing module container to the bottom.    
    Then I clicked exit in the running module window.
    And I clicked Ok button on pop up.    
    Then I come back to the default frame. 
    Then I waited for 1 seconds.   
		#New Code replace below line
    #When I played the module and then I exited from the module. 
    #And I clicked Ok button on pop up.
    Then I verified that the courses "PDF View Test2" is not present on the user homepage.
    #Step 7
    And Log out From the Carriers.
   	When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.  
   	When I clicked on the deadline link of the "PDF12" program.
   	When I selected the program available immediately option.   		
   	And I selected the option `remove this program when it`s complete`. 
   	And clicked on the save button.     	
   	When I clicked on `x people assigned` to the "PDF12" program.
    And I clicked on Unselect All in the program.
    And I clicked on user "user-random.100" at available to assign on Assign people.
    And I selected the Assign Places tab on the program assigned display window.
    And I clicked on Unselect All in the program.
   	And I clicked on the reset checkbox.
   	And clicked on the save button.
   	#Then I waited for 1 seconds.
    And I verified that 1 people assigned to the "PDF12" program.    
   	And Log out From the Carriers.
   	When I entered username "random.100" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    When I verified that the courses "PDF View Test1" present on the user homepage.
    When I verified that the courses "PDF View Test2" present on the user homepage.
    When I hovered over the mouse on the program "PDF12" on the user homepage.
    Then I saw a display message "This program will automatically remove itself from your profile once you complete it" on the user homepage. 
  	#Check of step 45
   #Course1 present check
    When I clicked on the course "PDF View Test1" to play on the user homepage.
    #New Code
		Then I waited for 2 seconds.        
     Then I changed the frame.
     And I clicked on the continue button on the content if the content is currently in progress.  
     Then I waited for 1 seconds. 
     When I scrolled the playing module container to the bottom.    
    Then I clicked exit in the running module window.
    And I clicked Ok button on pop up.    
    Then I come back to the default frame.        
		#New Code replace below line
   # When I played the module and then I exited from the module. 
   # And I clicked Ok button on pop up.
    Then I waited for 3 seconds.
    #Course2 present check
    When I clicked on the course "PDF View Test2" to play on the user homepage.
    #New Code
		Then I waited for 2 seconds.        
     Then I changed the frame.
     And I clicked on the continue button on the content if the content is currently in progress.  
     Then I waited for 1 seconds. 
     When I scrolled the playing module container to the bottom.    
    Then I clicked exit in the running module window.
    And I clicked Ok button on pop up.    
    Then I come back to the default frame.
    Then I waited for 1 seconds.
		#New Code replace below line
   # When I played the module and then I exited from the module. 
    #And I clicked Ok button on pop up.
    Then I verified that the courses "PDF View Test1" is not present on the user homepage.
    Then I verified that the courses "PDF View Test2" is not present on the user homepage.
    #Step 8 Changing the program availability
     And Log out From the Carriers.
   	When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	
   	And I clicked on Programs in the navigation bar main menu.   	
   	When I clicked on the deadline link of the "PDF2" program.   
   	When I selected the program available immediately option.
   	#step 9 default select in above steps.
   	#step 10,11,12 already tested in programs.feature file or 
   	#step 13
   	#as of "tomorrow date" will automaticall take tommrow date and if date taken it should be in yyyy-MM-dd formet.
  # When I selected the program available as of the "2021-02-17" option.
   When I selected the program available as of the "tomorrow date" option.
   	And clicked on the save button.
   When I clicked on `x people assigned` to the "PDF2" program.
    And I clicked on Unselect All in the program.
    #if not save than there is a bug and Talked to Tommy, He said that , he will escalate the problem to Mark and let me know
    And clicked on the save button.
    When I clicked on `x people assigned` to the "PDF2" program.
    And I clicked on user "user-random.10" at available to assign on Assign people.
   	And I clicked on the reset checkbox.
   	And clicked on the save button.
    And I verified that 1 people assigned to the "PDF2" program. 
    When I clicked on people at the navigation bar.
    Then the user name "random.10" is clicked on the people page.
    #Then I verified that the programs/courses "PDF View Test2" assigned as per user location.
    Then I checked the user`s profile and verified that the programs/courses "PDF View Test2" is not assigned to the user.
    Then I clicked the Cancel button on the user profile window.
    And I clicked on Programs in the navigation bar main menu.
   	When I clicked on the deadline link of the "PDF2" program.   
   	When I selected the program available immediately option.
   	When I selected the program available as of the "2021-02-16" option.
   	And clicked on the save button.
   	 Then I waited for 1 seconds.
   	 When I clicked on people at the navigation bar.
    Then the user name "random.10" is clicked on the people page.
    Then I verified that the programs/courses "PDF View Test2" assigned as per user location.    
  #till step 15, step 16 has to modify, Talked to Tommy and if it will modify than the step is already tested in programs.feature
  #step 17 is already tested by step 34 and above step when the date change from future to past the program can be seen in user profile
  #step 18
  And Log out From the Carriers.
   	When I entered username "random.10" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    When I verified that the courses "PDF View Test2" present on the user homepage.
    
     And Log out From the Carriers.
   	When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.  
  #step 19
 # Then I waited for 1 seconds.
  When I clicked on the deadline link of the "PDF2" program. 
  #Then I waited for 2 seconds.
 	When I selected the program available "1" days after the assignment. 	
 		And clicked on the save button.
 		Then I waited for 1 seconds.
 		 When I clicked on people at the navigation bar.
    Then the user name "random.10" is clicked on the people page.
    #Then I verified that the programs/courses "PDF View Test2" assigned as per user location.
     Then I checked the user`s profile and verified that the programs/courses "PDF View Test2" is not assigned to the user.
 		#And I clicked on the Cancel button.
 		And I clicked the Cancel button on the user profile window.
 		And I clicked on Programs in the navigation bar main menu.  
 
  When I clicked on the deadline link of the "PDF2" program. 
 	When I selected the program available "0" days after the assignment.
 		And clicked on the save button.
 		Then I waited for 1 seconds.
 		 When I clicked on people at the navigation bar.
    Then the user name "random.10" is clicked on the people page.
    Then I verified that the programs/courses "PDF View Test2" assigned as per user location.
   #till step 20
   #step 21
   #And I clicked on the Cancel button.
   And I clicked the Cancel button on the user profile window.
 		And I clicked on Programs in the navigation bar main menu. 
 	When I clicked on the deadline link of the "PDF2" program.   
   	When I selected the program available immediately option.
   	And clicked on the save button.
    When I clicked on `x people assigned` to the "PDF2" program.
    #And I clicked on user "user-random.20" at available to assign on Assign people.
    And I clicked on user-id "user-random.20" to select the user if not already selected.
   	And I clicked on the reset checkbox.
   	And clicked on the save button.
   	Then I waited for 3 seconds.
   	 When I clicked on people at the navigation bar.
    Then the user name "random.20" is clicked on the people page.
    Then I verified that the programs/courses "PDF View Test2" assigned as per user location.
    #And I clicked on the Cancel button.
    And I clicked the Cancel button on the user profile window.
    
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the deadline link of the "PDF2" program. 
 	When I selected the program available "1" days after the assignment.
 		And clicked on the save button.
 		Then I waited for 1 seconds.
 		 When I clicked on people at the navigation bar.
    Then the user name "random.20" is clicked on the people page.
    Then I checked the user`s profile and verified that the programs/courses "PDF View Test2" is not assigned to the user.
    And I clicked the Cancel button on the user profile window.
    #step 22
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the deadline link of the "PDF2" program. 
 		When I selected the program available "0" days after the assignment.
 		And clicked on the save button.
    And Log out From the Carriers.
   	When I entered username "random.20" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    When I verified that the courses "PDF View Test2" present on the user homepage.
    And Log out From the Carriers.
   	When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.  
        #step 23
        #What to check in 23 , confuse
        #step 24
 #step 25
    When I clicked on the deadline link of the "PDF2" program.
		When I chose the program needs to completed within 2 days.
		And clicked on the save button.
		And I waited for 2 seconds.	
		Then I verified that the display guide of the "PDF2" program showed 2 days.
		Then I verified that when hovered over the mouse on the deadline link of the "PDF2" the display message warns users with the message `The deadline for this program is 2 days.' 
		  #step 26
		  And Log out From the Carriers.
   	When I entered username "random.20" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    When I hovered over the mouse on the program "PDF2" on the user homepage.
    #Then I saw a display message "This program will automatically remove itself from your profile once you complete it" on the user homepage. 
    Then I verified that Guide text warn the user "The deadline for this program is " dated 2 days from today.
    And Log out From the Carriers.
   	When I entered username "autom.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.    
       #step 27 
       #And I waited for 2 seconds.	
    When I clicked on the x module assigned of the "PDF2" program.
    
    #PDF View Test3
    Then I select or unselect a module "module-9413" module to add or remove module from the program. 
    And clicked on the save button.
    And I waited for 1 seconds.
    Then I verified that the display guide of the "PDF2" program showed 2 days.
    #Removing module and bring back to original no of module
    # When I clicked on the x module assigned of the "PDF2" program.
    #Then I select or unselect a module "module-9413" module to add or remove module from the program. 
    # And clicked on the save button.
     And I waited for 1 seconds.
     #step 28
    When I clicked on the deadline link of the "PDF2" program.
		When I set the program needs to completed within 4 days.
		And clicked on the save button.
		Then I verified that the display guide of the "PDF2" program showed 4 days.
    #step 29    
    And Log out From the Carriers.
   	When I entered username "random.20" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    When I hovered over the mouse on the program "PDF2" on the user homepage.
    #Then I saw a display message "This program will automatically remove itself from your profile once you complete it" on the user homepage. 
    Then I verified that Guide text warn the user "The deadline for this program is " dated 4 days from today.
    And Log out From the Carriers.
   	When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.
    #step 30 Deadline link, by the end of date
    
    When I clicked on the deadline link of the "PDF2" program.
		When I set the program needs to completed by the end of "tomorrow date".
		#When I set the program needs to completed within 4 days.
     And clicked on the save button.    
     Then I verified that the display guide of the "PDF2" program showed "tomorrow date" days.     
     And Log out From the Carriers.
   	When I entered username "random.20" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    When I hovered over the mouse on the program "PDF2" on the user homepage.
    #Then I saw a display message "This program will automatically remove itself from your profile once you complete it" on the user homepage. 
     #step 31
    Then I verified that Guide text warn the user "The deadline for this program is " dated 1 days from today.    
     And Log out From the Carriers.
   	When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	
   	And I clicked on Programs in the navigation bar main menu.
		#step 32 , 33  	
   	 When I clicked on the deadline link of the "PDF2" program.
   	When I selected Remove this program when the deadline passes checkbox.
   	And clicked on the save button.
   	
   	And Log out From the Carriers.
   	When I entered username "random.20" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    When I hovered over the mouse on the program "PDF2" on the user homepage.
    Then I saw a display message "It will automatically remove itself from your profile when the deadline passes." on the user homepage. 
    #step 34 , program did not remove from user dashboard once compleated the program.# Christopher modified it later, I have to add
    #step 35, module did not remove from user dashboard once compleated the program.
    #step 36, look like redundent, check in below step
    Then I verified that Guide text warn the user "The deadline for this program is " dated 1 days from today.
    #step 37
    
     And Log out From the Carriers.
   	When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	
   	And I clicked on Programs in the navigation bar main menu.
     
     When I clicked on the x module assigned of the "PDF2" program.
    
    #this is # step 27 redundancy, using in this case , removing program no effect on deadline guide text. the below module is selected before
    Then I select or unselect a module "module-9413" module to add or remove module from the program. 
    And clicked on the save button.
    Then I verified that the display guide of the "PDF2" program showed "tomorrow date" days.
    #step 38, redundent of  #step 28
    When I clicked on the deadline link of the "PDF2" program.
    #When I set the program needs to completed by the end of "tomorrow date".
    #bring back to original data, to unselect deadline passes
    When I selected Remove this program when the deadline passes checkbox.
    When I set the program needs to be completed by the end of after "2" days from today`s date.
    And clicked on the save button.
    Then I verified that the display guide of the "PDF2" program showed "2" days after today`s date. 
     #step 39
     
     	And Log out From the Carriers.
   	When I entered username "random.20" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    When I hovered over the mouse on the program "PDF2" on the user homepage.
    #Then I saw a display message "It will automatically remove itself from your profile when the deadline passes." on the user homepage.
    Then I verified that Guide text warn the user "The deadline for this program is " dated 2 days from today. 
  
    #step 40, This is previously tested, in step 32,36 , remove the program when deadline passes and previously option of deadline date.   
    
    And Log out From the Carriers.
   	When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	
   	And I clicked on Programs in the navigation bar main menu.
     
    When I clicked on the deadline link of the "PDF2" program.
    
     When I set the program needs to be completed by the end of after "2" days from today`s date.
    When I selected Remove this program when the deadline passes checkbox.
    And clicked on the save button.
    
    And Log out From the Carriers.
   	When I entered username "random.20" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    When I hovered over the mouse on the program "PDF2" on the user homepage.
    #check deadline and deadline passes in user guide text
    Then I verified that Guide text warn the user "The deadline for this program is " dated 2 days from today. 
    Then I saw a display message "It will automatically remove itself from your profile when the deadline passes." on the user homepage. 
    #step 41,42-> module individually did not but 41 and 42 are same
    
    And Log out From the Carriers.
   	When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	
   	And I clicked on Programs in the navigation bar main menu.
     
    When I clicked on the deadline link of the "PDF2" program.
    And I selected the option `remove this program when it`s complete`.
    And clicked on the save button.
    And Log out From the Carriers.
   	When I entered username "random.20" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    When I hovered over the mouse on the program "PDF2" on the user homepage.
    Then I saw a display message "This program will automatically remove itself from your profile once you complete it" on the user homepage.    	    
    #step 45, compleated in privious step       
     And Log out From the Carriers.
   	When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	
   	And I clicked on Programs in the navigation bar main menu.
   	 #step 46-> Below are the step for program reset and program sort.
    #step 47
    #step 47
  	
   	When I clicked on `x people assigned` to the "PDF12" program. 
   	And I clicked on user "user-random.101" at available to assign on Assign people.
   	And I clicked on the reset checkbox.
   	And clicked on the save button.
   	Then I waited for 2 seconds.
   	 When I clicked on people at the navigation bar.
   	 Then I waited for 1 seconds.
   	 When I clicked on people at the navigation bar.
    Then the user name "random.101" is clicked on the people page.
    #step 48
    Then I waited for 2 seconds.
    Then I verified that the status of the module "PDF View Test1" in the user profile is "Not Started".
    Then I verified that the status of the module "PDF View Test2" in the user profile is "Not Started".
     Then I clicked the Cancel button on the user profile window.
    #step 49 login the user account and test
    
    And Log out From the Carriers.
   	When I entered username "random.101" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
    Then I verified that the status of module "PDF View Test1" is "Not started" on the user homepage.
     Then I verified that the status of module "PDF View Test2" is "Not started" on the user homepage.
    
     And Log out From the Carriers.
   	When I entered username "auto4.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.  
    
    #Step 50
   		And I clicked on Programs in the navigation bar main menu. 
   		When I clicked on `x people assigned` to the "PDF12" program.
   	#	And I clicked on Unselect All in the program.   	
   	And I selected the Assign Places tab on the program assigned display window.
  	And I clicked on Unselect All in the program.
  	#place-16946 is "test place" in ProcessAutomation4
  	And I clicked on a place have id "place-16946" on the people assign display window.
  	And I clicked on the reset checkbox.
   	And clicked on the save button.
   	Then I waited for 4 seconds.
   	 When I clicked on people at the navigation bar.
    Then the user name "random.102" is clicked on the people page.
    
    Then I verified that the status of the module "PDF View Test1" in the user profile is "Not Started".
    Then I verified that the status of the module "PDF View Test2" in the user profile is "Not Started".
    Then I clicked the Cancel button on the user profile window.   
     And I clicked on Programs in the navigation bar main menu.   	
     #step 51
     When I clicked on the x module assigned of the "PDF12" program.
     Then I waited for 2 seconds.
     Then I clicked on the `Shot Short Order or Show Modules`.
     #commented due to bug   
     #Then I verified that the modules "PDF View Test1, PDF View Test2" are sorted in order.
    # And I scrolled the small window.
    # And I clicked on the Cancel button.
    #And I clicked on the save button.
    And clicked on the save button. 
    And I waited for 2 seconds.
     #step 52
    When I clicked on people at the navigation bar.
    Then the user name "random.102" is clicked on the people page.
    And I waited for 2 seconds. 
    And I scrolled the small window. 
    #commented due to bug   
    #And I verified that modules of the program "PDF12" are correctly sorted in the user profile in the order like "PDF View Test1, PDF View Test2".
   #Then I waited for 2 seconds.  
    And I clicked the Cancel button on the user profile window.
    #Then I waited for 2 seconds.  
    #step 53
     And Log out From the Carriers.
   	When I entered username "random.102" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	  #commented due to bug   
   #And I verified that modules of the program "PDF12" are correctly sorted in the user dashboard in the order like "PDF View Test1, PDF View Test2".
   	And I quit the browser.
    
     
   #Note: Before running the test make sure initially the Program PDF2 contain 1 module "PDF View Test2" and the program PDF12 contain 2 modules "PDF View Test1 and PDF View Test2"
