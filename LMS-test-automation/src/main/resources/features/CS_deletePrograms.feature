#Author: navaraj@carriersedge.com

#This automation is used in addAndDeletePrograms.feature file , 
#better to run addAndDeleteProgram in state of this feature file. 
#To delete a Program we need to create the program, So the combination is necessary.
@LMST-699 @LMST-841
Feature: Deleting  programs when logged in as the Customer Support role.
  Scenario: Deleting  programs when logged
  
  Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
 		When I entered username "as.automation.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
  
    #Delete Step  2
    And I verified that the program "TempReference program" found in the "Reference Programs" section.
    #Delete Step  3
    Then I verified that 2 modules assigned to the "TempReference program" program.
    And I verified that 3 people assigned to the "TempReference program" program.
    When I clicked on `x people assigned` to the "TempReference program" program.  
    Then I verified that the people "Test user2, Test user3" are assigned through the place.
    And I verified that the users "Test user" are selected to the program.
    And I clicked on the Cancel button.
    #Delete Step  4
    When I hovered over on the "TempReference program" program and verified that 2 buttons `delete and program order` present.
    #Delete Step  5
    Then I clicked on the delete button of the program "TempReference program" on the programs page.
     #Delete Step  6
    And I clicked on the Cancel button on the delete program conform window.
     #Delete Step  7
     When I hovered over on the "TempReference program" program and verified that 2 buttons `delete and program order` present.
     Then I clicked on the delete button of the program "TempReference program" on the programs page.
    #And I clicked on the delete button on the delete program conform window.
    #Delete Step  8
    Then I confirmed that the program "TempReference program" is not present on the Show Programs page.
    #Delete Step  9
    When I clicked on the Show Modules icon on the People page.
    Then I verified that the modules "Fire Safety, WHMIS 2015" that were in the program have not been deleted.
     #Delete Step  10
     And I clicked on people at the navigation bar.
     And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I verified that the program "TempReference program" is not present on the user profile.
    #Then I verified that the program "TempReference program" is not present on the user profile.
    And I clicked the Cancel button on the user profile window.
    #Delete Step  11
    #No Assignments, Not Started 
    And I verified that the status of user "as.test.user" on the people page is "No Assignments".
    #Delete Step  12
    And Log out From the Carriers.
   	When I entered username "as.test.user" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.  
   	Then I verified that programs "TempReference program" not present on the user`s dashboard.
   	
   	And Log out From the Carriers.
   	When I entered username "as.automation.cs" and password "test".
   	And clicked Submit button on the login page.
   	Then I logged in successfully.  
   	And I clicked on Programs in the navigation bar main menu.
   	 And I quit the browser.
   	#Delete Step  13
   	#Repeat same steps from 1 to 12 for Optional program.
   	#Delete Step  14
   	#Repeat same steps from 1 to 12 for Optional program.

#Note:To run the program, the program which has to be deleted in the carrier ProcessAutomation must present before running,
#Therefore this automation always run with add program. 