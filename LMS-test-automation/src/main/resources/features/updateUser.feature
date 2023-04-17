
@updateUser @LMST-695 @LMST-684
Feature: Update User
  @bringAlluserBackToNormalProfileData
  Scenario: Data bring to the original to run other test cases normally. 
  The test purpose is to bring the data to normalized so that the other scenarios will not fail due to changing its data. This scenario brings the data to the original if it was not.
		Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "auto.nava" and password "test" as a customer support.
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #normalize program 
    And I clicked on Programs in the navigation bar main menu.    
    Then I waited for 1 seconds.
    When I clicked on `x people assigned` to the "Fire Safety" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
  	And I clicked on Unselect All in the program.
  	#place 2 assign fire safety program
  	And I clicked on a place have id "place-16910" on the people assign display window.
    And clicked on the save button. 
    
    When I clicked on the x module assigned of the "Fire Safety" program.
    #module-486 is Fire Safety
   
    Then I select a module "module-486" to add in the program.
    #And I clicked on the reset checkbox. 
     And clicked on the save button.
    
      
    And I clicked on Programs in the navigation bar main menu.    
    Then I waited for 1 seconds.
    When I clicked on `x people assigned` to the "Program1" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
  	And I clicked on Unselect All in the program.
  	#place 1 assign Program1 program
  	And I clicked on a place have id "place-16904" on the people assign display window.
    And clicked on the save button.           
    
    #normalize Admin data
    When I clicked on people at the navigation bar.
    Then the user name "auto2.admin" is clicked on the people page.
    When I Edit the current user`s first name "Auto2" and last name "admin".
    When I edit the current user`s email address as "adminAddress@cmail.com".
    And click on save button in user`s profile.
    #normalize Reginal admin data
    #When I clicked on people at the navigation bar.
    Then the user name "auto2.radmin" is clicked on the people page.
    When I Edit the current user`s first name "Auto2" and last name "radmin".
    When I edit the current user`s email address as "orginal@cmail.ca". 
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "test" and confirm Password with "test".   
    And click on save button in user`s profile. 
   #normalize Driver manager data
   Then the user name "auto2.mngr" is clicked on the people page.
    When I Edit the current user`s first name "Auto2" and last name "mngr".
    When I edited the current user role to "Manager".
    And I edited the current user`s place to "Auto2Region - place1".
	 And click on save button in user`s profile. 
    #Normalisze user data 
    Then the user name "auto2.user" is clicked on the people page.
    When I Edit the current user`s first name "Auto2" and last name "user".
    When I edit the current user`s email address as "".
    And I edited the current user`s place to "Auto2Region - place1".
    And I edited the current user`s language to "English".
    And I set the current user`s manager to "Auto2 mngr".
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "test" and confirm Password with "test".     
    And click on save button in user`s profile.
    And I closed the browser.
 
 @updateUserByAdminRole
  Scenario: Update by admin role.
  I want to update my own profile and also update the profile of the driver manager, and users (drivers).
  In the scenario, I also test change my own password change and the user`s (driver) password as well. when I change the place of a manager and user,
   I also check course assigned and manager of the useras as well .
		Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
 		When I entered username "auto2.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on logged in as in the current user Link.
    Then I checked the current user`s first name "Auto2" and last name "admin".
    Then I checked the email address of the current user is "adminAddress@cmail.com".     
    #change own data
    When I Edit the current user`s first name "NewAdminFirstName" and last name "newAdminLast".
   	When I edit the current user`s email address as "editadmin@cmail.ca".
    And click on save button in user`s profile.
    And I clicked on the home the main menu.
    When I clicked on logged in as in the current user Link.
    Then I checked the current user`s first name "NewAdminFirstName" and last name "newAdminLast".
    Then I checked the email address of the current user is "editadmin@cmail.ca".    
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "admin" and confirm Password with "admin".     
    And click on save button in user`s profile.
    And Log out From the Carriers.    
    #back to orginal
    When I entered username "auto2.admin" and password "admin".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on logged in as in the current user Link.    
    When I Edit the current user`s first name "Auto2" and last name "admin".
    When I edit the current user`s email address as "adminAddress@cmail.com". 
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "test" and confirm Password with "test".   
    And click on save button in user`s profile. 
     #Change Driver Manager location
     Then the user name "auto2.user" is clicked on the people page.
     And I verified from the user profile that the assigned manager of the user is "Auto2 mngr".
     And click on save button in user`s profile.
    Then the user name "auto2.mngr" is clicked on the people page.
    And I waited for 1 seconds.
    And I clecked current user role is "Manager" and found true.
    #change data of manager  
   # When I edited the current user role to "User".
   	And I edited the current user`s place to "Auto2Region2 - place3".
    And click on save button in user`s profile. 
    Then the user name "auto2.mngr" is clicked on the people page.
    #back to original place
    And I edited the current user`s place to "Auto2Region - place1".
    When I edit the current user`s email address as "orginalmanager@cmail.ca". 
    And click on save button in user`s profile. 
    #For a user  
    Then the user name "auto2.user" is clicked on the people page.
    Then I checked the current user`s first name "Auto2" and last name "user".
    Then I checked the email address of the current user is "".
    And I verified from the user profile that the assigned manager of the user is "Auto2 mngr".
    #Then I verified that the programs/courses "CSA for Drivers" assigned as per user location.
    And I verified that the language selection of the current user is "English".   
    #change user data     
    When I Edit the current user`s first name "newFirstUser" and last name "newLastUser".
   	When I edit the current user`s email address as "user@cmail.ca".
   	And I edited the current user`s place to "Auto2Region - place2".
   	And I edited the current user`s language to "Français".
    And click on save button in user`s profile.
    Then the user name "auto2.user" is clicked on the people page.
    Then I checked the current user`s first name "newFirstUser" and last name "newLastUser".
    Then I checked the email address of the current user is "user@cmail.ca".
    And I verified that the language selection of the current user is "Français".
    Then I verified that the programs/courses "Fire Safety" assigned as per user location.
    #back to orginal
    When I Edit the current user`s first name "Auto2" and last name "user".
    When I edit the current user`s email address as "".
    And I edited the current user`s place to "Auto2Region - place1".
    And I set the current user`s manager to "Auto2 mngr".
    And I edited the current user`s language to "English".
    And click on save button in user`s profile.
     #change password of user
    Then the user name "auto2.user" is clicked on the people page.
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "driver" and confirm Password with "driver".     
    And click on save button in user`s profile.
    And Log out From the Carriers.
    #Then I waited for 2 seconds.
    When I Entered username "auto2.user" and password "driver".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #after successfully change password, reset to orginal user password "test" 
    And Log out From the Carriers.
    When I entered username "auto2.radmin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on people at the navigation bar.
    Then the user name "auto2.user" is clicked on the people page.
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "test" and confirm Password with "test".
    And click on save button in user`s profile.
    And I closed the browser.
 
 @updateUserByRadminRole
  Scenario: Update by regional admin role.
  I want to update my own profile and also update the profile of the driver manager, and users (drivers).
  In the scenario, I also test change my own password change and the user`s (driver) password as well.
   when I change the place of the user, I also check the course assigned.
  I also test, the manager of a user if the manager of the user is demoted to the driver (user) role.
		Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
 		When I entered username "auto2.radmin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on logged in as in the current user Link.
    Then I checked the current user`s first name "Auto2" and last name "radmin".
    Then I checked the email address of the current user is "orginal@cmail.ca".     
    #change own data
    When I Edit the current user`s first name "newFirst" and last name "newLast".
   	When I edit the current user`s email address as "edit@cmail.ca".
    And click on save button in user`s profile.
    And I clicked on the home the main menu.
    When I clicked on logged in as in the current user Link.
    Then I checked the current user`s first name "newFirst" and last name "newLast".
    Then I checked the email address of the current user is "edit@cmail.ca".    
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "radmin" and confirm Password with "radmin".     
    And click on save button in user`s profile.
    And Log out From the Carriers.    
    #back to orginal
    When I entered username "auto2.radmin" and password "radmin".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on logged in as in the current user Link.    
    When I Edit the current user`s first name "Auto2" and last name "radmin".
    When I edit the current user`s email address as "orginal@cmail.ca". 
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "test" and confirm Password with "test".   
    And click on save button in user`s profile. 
     #Demote Driver manager
     Then the user name "auto2.user" is clicked on the people page.
     And I verified from the user profile that the assigned manager of the user is "Auto2 mngr".
     And click on save button in user`s profile.
    Then the user name "auto2.mngr" is clicked on the people page.
    And I clecked current user role is "Manager" and found true.
    #change data of manager  
    When I edited the current user role to "User".
    And click on save button in user`s profile.
    Then the user name "auto2.mngr" is clicked on the people page.
    And I clecked current user role is "User" and found true.
    #back to original manager
    When I edited the current user role to "Manager".
    And click on save button in user`s profile. 
    #For a user  
    Then the user name "auto2.user" is clicked on the people page.
    Then I checked the current user`s first name "Auto2" and last name "user".
    Then I checked the email address of the current user is "".
    Then I verified that the programs/courses "CSA for Drivers" assigned as per user location.
    And I verified that the language selection of the current user is "English". 
    
     And I verified from the user profile that the assigned manager of the user is "None".
    #change user data     
    When I Edit the current user`s first name "newFirstUser" and last name "newLastUser".
   	When I edit the current user`s email address as "user@cmail.ca".
   	And I edited the current user`s place to "Auto2Region - place2".
   	And I edited the current user`s language to "Français".
    And click on save button in user`s profile.
    Then the user name "auto2.user" is clicked on the people page.
    Then I checked the current user`s first name "newFirstUser" and last name "newLastUser".
    Then I checked the email address of the current user is "user@cmail.ca".
    And I verified that the language selection of the current user is "Français".
    Then I verified that the programs/courses "Fire Safety" assigned as per user location.
    #back to orginal
    When I Edit the current user`s first name "Auto2" and last name "user".
    When I edit the current user`s email address as "".
    And I edited the current user`s place to "Auto2Region - place1".
    And I set the current user`s manager to "Auto2 mngr".
    And I edited the current user`s language to "English".
    And click on save button in user`s profile.
     #change password of user
    Then the user name "auto2.user" is clicked on the people page.
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "driver" and confirm Password with "driver".     
    And click on save button in user`s profile.
    And Log out From the Carriers.
    #Then I waited for 2 seconds.
    When I Entered username "auto2.user" and password "driver".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #after successfully change password, reset to orginal user password "test" 
    And Log out From the Carriers.
    When I entered username "auto2.radmin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on people at the navigation bar.
    Then the user name "auto2.user" is clicked on the people page.
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "test" and confirm Password with "test".
    And click on save button in user`s profile.
    And I closed the browser.
    
    @updateUserAsDriverManagerRole
  Scenario: Update by Driver Manager Role.
 I want to update my own profile and also update the profile of the driver manager, and users (drivers).
  In the scenario, I also test change my own password change and the user`s (driver) password as well. when I change the place of the user, I also check course assigned as location as well.
		Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
 		When I entered username "auto2.mngr" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on logged in as in the current user Link.
    Then I checked the current user`s first name "Auto2" and last name "mngr".
    Then I checked the email address of the current user is "orginalmanager@cmail.ca".     
    #change own data
    When I Edit the current user`s first name "newManagerFirst" and last name "newManagerLast".
   	When I edit the current user`s email address as "editManager@cmail.ca".
    And click on save button in user`s profile.
    And I clicked on the home the main menu.
    When I clicked on logged in as in the current user Link.
    Then I checked the current user`s first name "newManagerFirst" and last name "newManagerLast".
    Then I checked the email address of the current user is "editManager@cmail.ca".    
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "manager" and confirm Password with "manager".     
    And click on save button in user`s profile.
    And Log out From the Carriers.    
    #back to orginal
    When I entered username "auto2.mngr" and password "manager".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on logged in as in the current user Link.    
    When I Edit the current user`s first name "Auto2" and last name "mngr".
    When I edit the current user`s email address as "orginalmanager@cmail.ca". 
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "test" and confirm Password with "test".   
    And click on save button in user`s profile.  
    #For a user  
    Then the user name "auto2.user" is clicked on the people page.
    Then I checked the current user`s first name "Auto2" and last name "user".
    Then I checked the email address of the current user is "".
    Then I verified that the programs/courses "CSA for Drivers" assigned as per user location.
    And I verified that the language selection of the current user is "English".   
    #change user data     
    When I Edit the current user`s first name "newFirstUser" and last name "newLastUser".
   	When I edit the current user`s email address as "user@cmail.ca".
   	#the below step can not be done by manager since the manager is in Auto2Region - place1
   	#And I edited the current user`s place to "Auto2Region - place2".
   	And I edited the current user`s language to "Français".
    And click on save button in user`s profile.
    Then the user name "auto2.user" is clicked on the people page.
    Then I checked the current user`s first name "newFirstUser" and last name "newLastUser".
    Then I checked the email address of the current user is "user@cmail.ca".
    And I verified that the language selection of the current user is "Français".
    #back to orginal
    When I Edit the current user`s first name "Auto2" and last name "user".
    When I edit the current user`s email address as "".
    And I edited the current user`s language to "English".
    And click on save button in user`s profile.
     #change password of user
    Then the user name "auto2.user" is clicked on the people page.
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "driver" and confirm Password with "driver".     
    And click on save button in user`s profile.
    And Log out From the Carriers.
    # after changngin password, login as a user using new password.
    When I Entered username "auto2.user" and password "driver".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #after successfully change password, reset to orginal user`s password "test" 
    And Log out From the Carriers.
    When I entered username "auto2.mngr" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    When I clicked on people at the navigation bar.
    Then the user name "auto2.user" is clicked on the people page.
    And I clicked on the change password link on the profile window.
    And I fill out the new password textBox with "test" and confirm Password with "test".
    And click on save button in user`s profile.
    And I closed the browser.
    
  
  @LMST916-Monthyusagecount 
  Scenario: Monthy user count 
    This test is used for testing scenario when new users (cs/admin) are added to the system and play any cource The monthly usage count (usage this billing cycle) should be updated.
    #auto.as cs account and carrier Processautomation3
    
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    #login as cs
    When I entered username "auto.as" and password "test".
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    
    When I clicked on people at the navigation bar.
    Then I waited for 4 seconds.
    #checked the total sapce available before adding new random user
    Then I clicked on total sapce available icon.
    When I hover over on People in people page.
    Then I waited for 2 seconds.
   
    And I clicked on Add Someone icon.
    And I clicked on the multiple people add option.
    And I added 1 random users from multiple People add form.
    Then I clicked the save button on multiple people add user window.
    Then I waited for 3 seconds.
    # License check
    Then I confirmed that `the total spaces available` are greater than or equal to `currently in use`(license checked).
    And Log out From the Carriers.
    # Logged in as newly created user
    When I log in as a 1 th newly created user in the application using the password as Firstname.
    And clicked Submit button on the login page.
    Then I waited for 3 seconds.
    Then I logged in successfully.
    Then I waited for 3 seconds.
    # Play module 
    When I clicked on the course "PDF View Test1" to play on the user homepage.   
    Then I waited for 2 seconds.
    Then I changed the frame.
    And I clicked on the continue button on the content if the content is currently in progress.
    Then I waited for 1 seconds.
    When I scrolled the playing module container to the bottom.
    Then I clicked exit in the running module window.
    And I clicked Ok button on pop up.
    Then I waited for 2 seconds.
    And Log out From the Carriers.
    And I closed the browser.
   #Then I waited for 4 seconds.
   @ActivityonProgress
  Scenario: Activity report on Progress page. This scenario is to check activity report to see if records populate. 

    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    #login As admin
    When I entered username "auto.as" and password "test".
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    When I clicked on Progress in the navigation bar main menu.
    Then I waited for 2 seconds.
    When I clicked on the Activities icon on the Progress page.
    Then I waited for 6 seconds.
   # When I clicked on the certificate of the user "1" on the progress page.
   # When I clicked on the certificate.
    And I closed the browser.
   
   @Verifycountincreased
   Scenario: Usage count increased

    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    #login As CS 
    When I entered username "auto.as" and password "test".
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    When I clicked on people at the navigation bar.
  
    Then I waited for 4 seconds.
    #Then I clicked on total sapce availables icon.
    Then I clicked on total sapce available icon.
    Then I waited for 6 seconds.
    Then I checked the available billed users.
    Then I waited for 6 seconds.
    #Then I confirmed that the number that`s at `Billed user` is increased by 1.
    Then I waited for 2 seconds.
    And Log out From the Carriers.
    And I quit the browser.
    
    #Note: Sometimes if program or modules inside a program is not matched in the above scenario the test may fail
    #for this situation  comment on the line
    #Then I verified that the programs/courses "MODULES NAME" assigned as per user location.
    #The test carrier is ProcessAutomation2
    # user auto2.user is always in place 1 and his manager is auto2.mngr
    #Note: Application assume that Fire Safety is assigned to place2 
    #and Program1 is assigned to place1, user 
    #And I verified from the user profile that the assigned manager of the user is "None".
  
   