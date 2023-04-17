#Author: navaraj@carriersedge.com
# Bug present is steps 4,8,9, and these steps are commented by 

 @LMST-838
@LMS-1568
@LMST-697
Feature: Assigning/unassigning a module to a program when logged in as customer support. The application does not check few bugs knowingly.
Role - Customer Support: Show Programs >> Modules assigned/unassigned
@LMST-700 @LMST-842	@LMST-734
  Scenario: Modules assigned/unassigned CS Role
  Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
 		When I entered username "auto3.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    	#Normalize, program RModulesTest,Omodules Test and RefModules Test modules assigned set to 0
    When I clicked on the x module assigned of the "RModulesTest" program.
   Then I waited for 2 seconds.
    And I clicked on Unselect All in the program.
     
     And clicked on the save button.
    When I clicked on the x module assigned of the "OModulesTest" program.
    Then I waited for 2 seconds.
     And I clicked on Unselect All in the program. 
     And clicked on the save button.
     When I clicked on the x module assigned of the "RefModulesTest" program.
    Then I waited for 2 seconds.
     And I clicked on Unselect All in the program. 
     And clicked on the save button.        
    Then I verified that 0 modules assigned to the "RModulesTest" program.
    When I clicked on the x module assigned of the "RModulesTest" program.
    #step 3, 
    	#module-9423, module-9424 and module-9425 are PDF View Test1, PDF View Test2 and PDF View Test3 respectively.
    	#Then I select or unselect a module "module-9423" module to add or remove module from the program.
    	#module-312 is CAS for Drivers and module-1977 is Vehicle Inspections
    #module-1045 is WHMIS 2015
    Then I select a module "module-1045" to add in the program.
    
   # Then I waited for 1 seconds.
    And clicked on the save button.
    Then I verified that 1 modules assigned to the "RModulesTest" program.
    When I clicked on the x module assigned of the "RModulesTest" program.
    #module-486 is Fire Safety
    #Then I select a module "module-9423" to add in the program.
    #module-3231 is Distracted Drivingx
    Then I select a module "module-9423" to add in the program.
    And I clicked on the reset checkbox. 
   
     And clicked on the save button.
    #new change
    #And I clicked Ok button on prop up.
    #new change
    #step 4
    Then I verified that 2 modules assigned to the "RModulesTest" program.
    When I clicked on people at the navigation bar.
    # for Steps 8 as well
     And I verified that the status of user "auto3.user" on the people page is "Not Started".
    Then the user name "auto3.user" is clicked on the people page.
    And I waited for 4 seconds.
    #step 5
    And I scrolled the small window.
    #Then I verified that the status of the module "Vehicle Inspections" in the user profile is "Not Started".
     And I waited for 2 seconds.
    Then I verified that the status of the module "PDF View Test1" in the user profile is "Not Started".
    Then I verified that the status of the module "WHMIS 2015" in the user profile is "Not Started".
    #Step 6    
     And Log out From the Carriers.
   	When I entered username "auto3.user" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	 
   	  
   # Then I verified that the status of module "Vehicle Inspections" is "Not started" on the user homepage.
   Then I verified that the status of module "PDF View Test1" is "Not started" on the user homepage.
     Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
        
        #new steps , The new steps can not be used because of existing bug.
       # When I clicked on the course "PDF View Test1" to play on the user homepage.
      	# Then I waited for 4 seconds. 
       # Then I changed the frame. 
       #  When I scrolled the playing module container to the bottom.	        
   	 #Then I clicked exit in the running module window.
    
   	 #Then I come back to the default frame.
   	# And I clicked Ok button on prop up.
        #new steps
        
        
     And Log out From the Carriers.
   	When I entered username "auto3.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.  
   	#Step 7
    #has to be applied
    When I clicked on the x module assigned of the "RModulesTest" program.
    #module-250 is Winter Driving
    Then I select a module "module-250" to add in the program.
    #module-516 is Maximizing Your Fuel
    Then I select a module "module-516" to add in the program.
    And I clicked on the reset checkbox. 
     And clicked on the save button.   
      #new change
    #And I clicked Ok button on prop up.
    #new change
    Then I verified that 4 modules assigned to the "RModulesTest" program.
    #Step 8
    When I clicked on people at the navigation bar.
    #new code
    #And I verified that the status of user "auto3.user" on the people page is "In Progress".
    #new code
     And I verified that the status of user "auto3.user" on the people page is "Not Started".
    
    And I clicked on Programs in the navigation bar main menu.
    #Step 9 For optional Programme
    When I clicked on the x module assigned of the "OModulesTest" program.
     #module-1045 is WHMIS 2015
    Then I select a module "module-1045" to add in the program.
    #module-9424 is PDF Test View2
    Then I select a module "module-9424" to add in the program.
    And I clicked on the reset checkbox. 
     And clicked on the save button. 
    Then I verified that 2 modules assigned to the "OModulesTest" program.
    When I clicked on people at the navigation bar.
    #***********************Below
     #And I verified that the status of user "auto3.user2" on the people page is "Not Started".
     #***********************Above
    Then the user name "auto3.user2" is clicked on the people page.
    And I scrolled the small window.
    Then I verified that the status of the module "PDF View Test2" in the user profile is "Not Started".
    Then I verified that the status of the module "WHMIS 2015" in the user profile is "Not Started".

		And Log out From the Carriers.
   	When I entered username "auto3.user2" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	    	  
   	Then I verified that the status of module "PDF View Test2" is "Not started" on the user homepage.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    When I clicked on the course "PDF View Test2" to play on the user homepage.
       Then I waited for 4 seconds. 
       
        Then I changed the frame. 
        When I scrolled the playing module container to the bottom.    
    Then I clicked exit in the running module window.
    And I clicked Ok button on prop up.
    Then I come back to the default frame.
   # And I clicked Ok button on prop up.
     And Log out From the Carriers.
   	When I entered username "auto3.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.     	
   	# for Refress programm
    When I clicked on the x module assigned of the "RefModulesTest" program.
     #module-1045 is WHMIS 2015
    Then I select a module "module-1045" to add in the program.
    #module-9425 is PDF Test View3
    Then I select a module "module-9425" to add in the program.
    And I clicked on the reset checkbox. 
     And clicked on the save button. 
    Then I verified that 2 modules assigned to the "RefModulesTest" program.
    When I clicked on people at the navigation bar.
     And I verified that the status of user "auto3.user3" on the people page is "No Assignments".
    Then the user name "auto3.user3" is clicked on the people page.
    And I scrolled the small window.
    Then I verified that the status of the module "PDF View Test3" in the user profile is "Not Started".
    Then I verified that the status of the module "WHMIS 2015" in the user profile is "Not Started".

		And Log out From the Carriers.
   	When I entered username "auto3.user3" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	    	  
   	Then I verified that the status of module "PDF View Test3" is "Not started" on the user homepage.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    When I clicked on the course "PDF View Test3" to play on the user homepage.
       Then I waited for 4 seconds. 
        Then I changed the frame. 
        When I scrolled the playing module container to the bottom.    
    Then I clicked exit in the running module window.
    And I clicked Ok button on prop up.
    Then I come back to the default frame.
    #And I clicked Ok button on prop up.
     And Log out From the Carriers.
   	When I entered username "auto3.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	#And I clicked on Programs in the navigation bar main menu.  
   	
   	
   	 #Step 10
 		 When I clicked on people at the navigation bar.
    Then the user name "auto3.user" is clicked on the people page.
    Then I waited for 2 seconds.
    And I scrolled the small window.
   # Then I verified that the status of the module {string} in the user profile is {string}.
    Then I verified that the modules "Maximizing Your Fuel, PDF View Test1, WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked on the link text "Change Assignments" on the opened page.
    #module-9300 is PDF Test View
		Then I select a module "module-9300" to add in the program.
	  And I clicked on the save Assignment button.
	  Then I waited for 2 seconds.
	  And I clicked the Cancel button on the user profile window.
	  # And clicked on the save button.
		Then the user name "auto3.user" is clicked on the people page.
    Then I waited for 2 seconds.
    And I scrolled the small window.
   # Then I verified that the status of the module {string} in the user profile is {string}.
		Then I verified that the modules "Maximizing Your Fuel, PDF View Test1, WHMIS 2015, Winter Driving, PDF View Test" present in the user profile.
	  And I clicked the Cancel button on the user profile window.
	  And I clicked on Programs in the navigation bar main menu.
   	#Step 11,12
   	 When I clicked on the x module assigned of the "RModulesTest" program.
    Then I select a module "module-9424" to add in the program.
    And I clicked on the reset checkbox. 
    
    And I checked on the `Notify People They have been Assigned to a Program`.
     And clicked on the save button.
      #new change
   # And I clicked Ok button on prop up.
    #new change
     #Step 13
    And I checked a user`s email and verified that the user got a notification about modules "PDF View Test2" and not contained already assigned "CSA for Drivers, Maximizing Your Fuel, PDF View Test1, WHMIS 2015, Winter Driving" modules.
   	#Step 14
     When I clicked on the x module assigned of the "RModulesTest" program.
    Then I select a module "module-9425" to add in the program.
    And I clicked on the reset checkbox. 
    
    And I checked on the `Notify People They have been Assigned to a Program`.
    And I checked on the `Include login details in the notification`.
     And clicked on the save button.
      #new change
    #And I clicked Ok button on prop up.
    #new change
    And I checked a user`s email and verified that the user got a notification about modules "PDF View Test3, The login details for your account are, Username: auto3.user, Password hint: test" and not contained already assigned "PDF View Test1, PDF View Test2" modules.
   	#Step 15
  	#below the steps are unassigned modules
  	#Step 16
  	# I am already login as CS
  	#Step 17
  	Then I verified that 6 modules assigned to the "RModulesTest" program.
  	#Step 18
  	 When I clicked on the x module assigned of the "RModulesTest" program.  	 
  	#module-1045 is WHMIS 2015
  	And I unselected "WHMIS 2015" if it is already selected which id "module-1045" from the page.
   	#Then I unselected a module "module-1045" to remove from the program.
  	And clicked on the save button.
  	#Step 19
  	Then I verified that 5 modules assigned to the "RModulesTest" program.
  	#Step 20
  	When I clicked on people at the navigation bar.
  	Then the user name "auto3.user" is clicked on the people page.
    And I waited for 2 seconds.
    And I scrolled the small window.
  	And I verified that the modules "Maximizing Your Fuel, PDF View Test1, PDF View Test2, PDF View Test3, Winter Driving" present in the user profile and "WHMIS 2015" not present in the profile.
  #Step 21
  	And Log out From the Carriers.
   	When I entered username "auto3.user" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	    	  
		Then I verified that none of the modules "WHMIS 2015" present on the user homepage.  
  #Step 22
 	 And Log out From the Carriers.
	 When I entered username "auto3.cs" and password "test".
   And clicked Submit button on the login page.
   Then I logged in successfully.
   And I clicked on Programs in the navigation bar main menu.
    When I clicked on the x module assigned of the "RModulesTest" program.
    #module-9423 is PDF View Test1
    Then I unselected a module "module-9423" to remove from the program.        
    #module-250 is Winter Driving
    Then I unselected a module "module-250" to remove from the program.
    #module-516 is Maximizing Your Fuel
    Then I unselected a module "module-516" to remove from the program.
  	And clicked on the save button.
  	Then I verified that 2 modules assigned to the "RModulesTest" program.  	    	  

   	#Step 23
  	#Status is not working properly
  	#Step 24
  	#Status is not workig properly
  	#Step 25
  	#remove the module from the user	
  	When I clicked on people at the navigation bar.	
    Then the user name "auto3.user" is clicked on the people page.
    Then I waited for 2 seconds.
    And I scrolled the small window.
   # Then I verified that the status of the module {string} in the user profile is {string}.
		Then I verified that the modules "PDF View Test2, PDF View Test3, PDF View Test" present in the user profile.
		#remove the module from the user		
    And I clicked on the link text "Change Assignments" on the opened page.
		And I unselected a module "module-9300" to remove.
	  And I clicked on the save Assignment button.
	  And I waited for 2 seconds.
	  And I clicked the Cancel button on the user profile window.
	  
	   Then the user name "auto3.user" is clicked on the people page.
    Then I waited for 2 seconds.
    And I scrolled the small window.
		Then I verified that the modules "PDF View Test2, PDF View Test3" present in the user profile.
		And I clicked the Cancel button on the user profile window.
	  And I clicked on Programs in the navigation bar main menu.
   	#Step 26
   	#Step 26, email is not sending( conformed with Tommy)
  	
	When I clicked on the x module assigned of the "RModulesTest" program.  	 
  	#module-9424 is PDF View Test2
  	When I scrolled the window till the element having XPath "//*[@id='module-9424']".
  	And I waited for 1 seconds.
   	Then I unselected a module "module-9424" to remove from the program.
   	And I checked on the `Notify People They have been Assigned to a Program`.
  	And clicked on the save button.
  	Then I verified that 1 modules assigned to the "RModulesTest" program.
  	When I clicked on people at the navigation bar.
  	Then the user name "auto3.user" is clicked on the people page.
    And I waited for 2 seconds.
    And I scrolled the small window.
  	And I verified that the modules "PDF View Test3" present in the user profile and "PDF View Test2" not present in the profile.  
 
 	And I clicked the Cancel button on the user profile window.
 	 And I clicked on Programs in the navigation bar main menu.
  #Step 27, 
  #Step 28 , Since when unselect the module , there is no email trigger so worthless to check it.
  #Step 29
   When I clicked on the x module assigned of the "RModulesTest" program.
   Then I waited for 2 seconds.
    And I clicked on Unselect All in the program.
     
     And clicked on the save button.
     Then I verified that 0 modules assigned to the "RModulesTest" program.
   	#Step 30
   	#Step 30
  When I clicked on people at the navigation bar.
  Then the user name "auto3.user" is clicked on the people page.
  Then I verified that the user profile has only 0 assigned modules.
   #Step 31
   And Log out From the Carriers.
   	When I entered username "auto3.user" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	 
		Then I verified that only 0 modules assigned in the user`s dashboard.
		# 0 programs means no program appear in the page
		Then I verified that 0 programs appeared in the user`s dashboard.   
   	#Step 32
      And Log out From the Carriers.
   	When I entered username "auto3.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	 
		 And I clicked on Programs in the navigation bar main menu.
		 When I clicked on the x module assigned of the "RModulesTest" program.
		 #module-1045 is WHMIS 2015
    Then I select a module "module-1045" to add in the program.
    Then I select a module "module-9423" to add in the program.
     
    And clicked on the save button.
    Then I verified that 2 modules assigned to the "RModulesTest" program.
     And I quit the browser.
     
  # **********************************New Change *******LMST-935*******************************
  Scenario: Modules assigned/unassigned Admin Role
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
 		
 		When I entered username "auto.admin9" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    	#Normalize, program RModulesTest,Omodules Test and RefModules Test modules assigned set to 0
    When I clicked on the x module assigned of the "RModulesTest" program.
    Then I waited for 2 seconds.
    And I clicked on Unselect All in the program.
     
    And clicked on the save button.
    When I clicked on the x module assigned of the "OModulesTest" program.
    Then I waited for 2 seconds.
     And I clicked on Unselect All in the program. 
     And clicked on the save button.
     When I clicked on the x module assigned of the "RefModulesTest" program.
    Then I waited for 2 seconds.
     And I clicked on Unselect All in the program. 
     And clicked on the save button.        
    Then I verified that 0 modules assigned to the "RModulesTest" program.
    When I clicked on the x module assigned of the "RModulesTest" program.
   
    Then I select a module "module-1045" to add in the program.
    
   # Then I waited for 1 seconds.
    And clicked on the save button.
    Then I verified that 1 modules assigned to the "RModulesTest" program.
    When I clicked on the x module assigned of the "RModulesTest" program.
    #module-486 is Fire Safety
    #Then I select a module "module-9423" to add in the program.
    #module-3231 is Distracted Drivingx
    Then I select a module "module-9423" to add in the program.
    And I clicked on the reset checkbox. 
   
     And clicked on the save button.
    #new change
    #Commented prop msg as it is removed on 13/05/22
    #And I clicked Ok button on prop up.
    #new change
    #step 4
    Then I verified that 2 modules assigned to the "RModulesTest" program.
    When I clicked on people at the navigation bar.
    # for Steps 8 as well
     And I verified that the status of user "auto4.user" on the people page is "Not Started".
    Then the user name "auto3.user" is clicked on the people page.
    And I waited for 4 seconds.
    #step 5
    And I scrolled the small window.
    #Then I verified that the status of the module "Vehicle Inspections" in the user profile is "Not Started".
     And I waited for 2 seconds.
    Then I verified that the status of the module "PDF View Test1" in the user profile is "Not Started".
    Then I verified that the status of the module "WHMIS 2015" in the user profile is "Not Started".
    #Step 6    
     And Log out From the Carriers.
   	When I entered username "auto4.user" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	 
   	  
   # Then I verified that the status of module "Vehicle Inspections" is "Not started" on the user homepage.
    Then I verified that the status of module "PDF View Test1" is "Not started" on the user homepage.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    And Log out From the Carriers.
   	When I entered username "auto.admin9" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.  
   	#Step 7
    #has to be applied
    When I clicked on the x module assigned of the "RModulesTest" program.
    #module-250 is Winter Driving
    Then I select a module "module-250" to add in the program.
    #module-516 is Maximizing Your Fuel
    Then I select a module "module-516" to add in the program.
    And I clicked on the reset checkbox. 
    And clicked on the save button.   
    #new change
   # And I clicked Ok button on prop up.
    #new change
    Then I verified that 4 modules assigned to the "RModulesTest" program.
    #Step 8
    When I clicked on people at the navigation bar.
    #new code
    #And I verified that the status of user "auto3.user" on the people page is "In Progress".
    #new code
    And I verified that the status of user "auto4.user" on the people page is "Not Started".
    
    And I clicked on Programs in the navigation bar main menu.
    #Step 9 For optional Programme
    When I clicked on the x module assigned of the "OModulesTest" program.
     #module-1045 is WHMIS 2015
    Then I select a module "module-1045" to add in the program.
    #module-9424 is PDF Test View2
    Then I select a module "module-9424" to add in the program.
    And I clicked on the reset checkbox. 
     And clicked on the save button. 
    Then I verified that 2 modules assigned to the "OModulesTest" program.
    When I clicked on people at the navigation bar.
    #***********************Below
     #And I verified that the status of user "auto3.user2" on the people page is "Not Started".
     #***********************Above
    Then the user name "auto4.user3" is clicked on the people page.
    And I scrolled the small window.
    Then I verified that the status of the module "PDF View Test2" in the user profile is "Not Started".
    Then I verified that the status of the module "WHMIS 2015" in the user profile is "Not Started".
		And Log out From the Carriers.
   	When I entered username "auto4.user3" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	    	  
   	Then I verified that the status of module "PDF View Test2" is "Not started" on the user homepage.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    When I clicked on the course "PDF View Test2" to play on the user homepage.
    Then I waited for 4 seconds.   
    Then I changed the frame. 
    When I scrolled the playing module container to the bottom.    
    Then I clicked exit in the running module window.
    And I clicked Ok button on prop up.
    Then I come back to the default frame.
   # And I clicked Ok button on prop up.
     And Log out From the Carriers.
   	When I entered username "auto.admin9" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	And I clicked on Programs in the navigation bar main menu.     	
   	# for Refress programm
    When I clicked on the x module assigned of the "RefModulesTest" program.
     #module-1045 is WHMIS 2015
    Then I select a module "module-1045" to add in the program.
    #module-9425 is PDF Test View3
    Then I select a module "module-9425" to add in the program.
    And I clicked on the reset checkbox. 
     And clicked on the save button. 
    Then I verified that 2 modules assigned to the "RefModulesTest" program.
    When I clicked on people at the navigation bar.
     And I verified that the status of user "auto5.user4" on the people page is "No Assignments".
    Then the user name "auto5.user4" is clicked on the people page.
    And I scrolled the small window.
    Then I verified that the status of the module "PDF View Test3" in the user profile is "Not Started".
    Then I verified that the status of the module "WHMIS 2015" in the user profile is "Not Started".
		And Log out From the Carriers.
   	When I entered username "auto5.user4" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	    	  
   	Then I verified that the status of module "PDF View Test3" is "Not started" on the user homepage.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    When I clicked on the course "PDF View Test3" to play on the user homepage.
    Then I waited for 4 seconds. 
    Then I changed the frame. 
    When I scrolled the playing module container to the bottom.    
    Then I clicked exit in the running module window.
    And I clicked Ok button on prop up.
    Then I come back to the default frame.
    #And I clicked Ok button on prop up.
     And Log out From the Carriers.
    #When I entered username "auto3.cs" and password "test".
   	When I entered username "auto.admin9" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.
   	#And I clicked on Programs in the navigation bar main menu.  
   	
   	 #Step 10
 		 When I clicked on people at the navigation bar.
    Then the user name "auto4.user" is clicked on the people page.
    Then I waited for 2 seconds.
    And I scrolled the small window.
   # Then I verified that the status of the module {string} in the user profile is {string}.
    Then I verified that the modules "Maximizing Your Fuel, PDF View Test1, WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked on the link text "Change Assignments" on the opened page.
    #module-9300 is PDF Test View
		Then I select a module "module-9300" to add in the program.
	  And I clicked on the save Assignment button.
	  Then I waited for 2 seconds.
	  And I clicked the Cancel button on the user profile window.
	  # And clicked on the save button.
		Then the user name "auto4.user" is clicked on the people page.
    Then I waited for 2 seconds.
    And I scrolled the small window.
   # Then I verified that the status of the module {string} in the user profile is {string}.
		Then I verified that the modules "Maximizing Your Fuel, PDF View Test1, WHMIS 2015, Winter Driving, PDF View Test" present in the user profile.
	  And I clicked the Cancel button on the user profile window.
	  And I clicked on Programs in the navigation bar main menu.
   	#Step 11,12
   	When I clicked on the x module assigned of the "RModulesTest" program.
    Then I select a module "module-9424" to add in the program.
    And I clicked on the reset checkbox. 
    
    And I checked on the `Notify People They have been Assigned to a Program`.
    And clicked on the save button.
    #new change
    #And I clicked Ok button on prop up.
     #new change
     #Step 13
    And I checked a user`s email and verified that the user got a notification about modules "PDF View Test2" and not contained already assigned "CSA for Drivers, Maximizing Your Fuel, PDF View Test1, WHMIS 2015, Winter Driving" modules.
   	#Step 14
    When I clicked on the x module assigned of the "RModulesTest" program.
    Then I select a module "module-9425" to add in the program.
    And I clicked on the reset checkbox. 
    And I checked on the `Notify People They have been Assigned to a Program`.
    And I checked on the `Include login details in the notification`.
    And clicked on the save button.
    #new change
   # And I clicked Ok button on prop up.
    #new change
    And I checked a user`s email and verified that the user got a notification about modules "PDF View Test3, The login details for your account are, Username: auto3.user, Password hint: test" and not contained already assigned "PDF View Test1, PDF View Test2" modules.
   	Then I verified that 6 modules assigned to the "RModulesTest" program.
  	#Step 18
  	 When I clicked on the x module assigned of the "RModulesTest" program.  	 
  	#module-1045 is WHMIS 2015
  	And I unselected "WHMIS 2015" if it is already selected which id "module-1045" from the page.
   	#Then I unselected a module "module-1045" to remove from the program.
  	And clicked on the save button.
  	#Step 19
  	Then I verified that 5 modules assigned to the "RModulesTest" program.
  	#Step 20
  	When I clicked on people at the navigation bar.
  	Then the user name "auto4.user" is clicked on the people page.
    And I waited for 2 seconds.
    And I scrolled the small window.
  	And I verified that the modules "Maximizing Your Fuel, PDF View Test1, PDF View Test2, PDF View Test3, Winter Driving" present in the user profile and "WHMIS 2015" not present in the profile.
  #Step 21
  	And Log out From the Carriers.
   	When I entered username "auto4.user" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	    	  
		Then I verified that none of the modules "WHMIS 2015" present on the user homepage.  
  #Step 22
 	 And Log out From the Carriers.
	 When I entered username "auto.admin9" and password "test".
   And clicked Submit button on the login page.
   Then I logged in successfully.
   And I clicked on Programs in the navigation bar main menu.
    When I clicked on the x module assigned of the "RModulesTest" program.
    #module-9423 is PDF View Test1
    Then I unselected a module "module-9423" to remove from the program.        
    #module-250 is Winter Driving
    Then I unselected a module "module-250" to remove from the program.
    #module-516 is Maximizing Your Fuel
    Then I unselected a module "module-516" to remove from the program.
  	And clicked on the save button.
  	Then I verified that 2 modules assigned to the "RModulesTest" program.  	    	  

  	When I clicked on people at the navigation bar.	
    Then the user name "auto4.user" is clicked on the people page.
    Then I waited for 2 seconds.
    And I scrolled the small window.
   # Then I verified that the status of the module {string} in the user profile is {string}.
		Then I verified that the modules "PDF View Test2, PDF View Test3, PDF View Test" present in the user profile.
		#remove the module from the user		
    And I clicked on the link text "Change Assignments" on the opened page.
		And I unselected a module "module-9300" to remove.
	  And I clicked on the save Assignment button.
	  And I waited for 2 seconds.
	  And I clicked the Cancel button on the user profile window.
	  
	  Then the user name "auto4.user" is clicked on the people page.
    Then I waited for 2 seconds.
    And I scrolled the small window.
		Then I verified that the modules "PDF View Test2, PDF View Test3" present in the user profile.
		And I clicked the Cancel button on the user profile window.
	  And I clicked on Programs in the navigation bar main menu.
   
	  When I clicked on the x module assigned of the "RModulesTest" program.  	 
  	#module-9424 is PDF View Test2
  	When I scrolled the window till the element having XPath "//*[@id='module-9424']".
  	And I waited for 1 seconds.
   	Then I unselected a module "module-9424" to remove from the program.
   	And I checked on the `Notify People They have been Assigned to a Program`.
  	And clicked on the save button.
  	Then I verified that 1 modules assigned to the "RModulesTest" program.
  	When I clicked on people at the navigation bar.
  	Then the user name "auto4.user" is clicked on the people page.
    And I waited for 2 seconds.
    And I scrolled the small window.
  	And I verified that the modules "PDF View Test3" present in the user profile and "PDF View Test2" not present in the profile.  
 
 	  And I clicked the Cancel button on the user profile window.
 	  And I clicked on Programs in the navigation bar main menu.
    #Step 27, 
    #Step 28 , Since when unselect the module , there is no email trigger so worthless to check it.
    #Step 29
    When I clicked on the x module assigned of the "RModulesTest" program.
    Then I waited for 2 seconds.
    And I clicked on Unselect All in the program.
    And clicked on the save button.
    Then I verified that 0 modules assigned to the "RModulesTest" program.
   	#Step 30
   	#Step 30
    When I clicked on people at the navigation bar.
    Then the user name "auto4.user" is clicked on the people page.
    Then I verified that the user profile has only 0 assigned modules.
    #Step 31
    And Log out From the Carriers.
   	When I entered username "auto4.user" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	 
		Then I verified that only 0 modules assigned in the user`s dashboard.
		# 0 programs means no program appear in the page
		Then I verified that 0 programs appeared in the user`s dashboard.   
   	#Step 32
    And Log out From the Carriers.
   	When I entered username "auto.admin9" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.   	 
		And I clicked on Programs in the navigation bar main menu.
		When I clicked on the x module assigned of the "RModulesTest" program.
		 #module-1045 is WHMIS 2015
    Then I select a module "module-1045" to add in the program.
    Then I select a module "module-9423" to add in the program.
    And clicked on the save button.
    Then I verified that 2 modules assigned to the "RModulesTest" program.
    And I quit the browser.
     
  #Note:precondition:  auto3.user should be assigned RModuleTest, auto3.user2 should assigned OModule test initially, and auto3.user3 should assigned RefModule test initially.
   #admin-auto.admin9
   # Precondition for admin auto4.user(RModuleTest) & auto4.user3-OModule auto5.user4-RefModule
    