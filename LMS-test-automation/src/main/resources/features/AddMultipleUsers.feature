
@LMST-637 @LMST-675
Feature: Add Multiple Users 

  @addMultipleUsers
		Scenario: Add Multiple users 
		This test is used for testing different scenarios when multiple users are added to the system. From this test, we can create multiple users but for the testing purpose, I created only 2 users.
		Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    #login As admin
 		When I entered username "thirdcarriers.automation" and password "test".
    And clicked Submit button on the login page.
     #checked for the home page
    Then I logged in successfully.
    When I clicked on people at the navigation bar.
    #check for people page contaning elements like People, Show org chart, Places
    When I hover over on People in people page.
    And I clicked on Add Someone icon.
    And I clicked on the multiple people add option.
    Then I clicked the save button on multiple people add user window.
    Then I saw a prop up message-"Please enter a first name".
		And I clicked Ok button on prop up.
    And I added 2 th user first name "Many Tow only" only.
    Then I clicked the save button on multiple people add user window.
    Then I saw a prop up message-"Please enter a first name".    
    And I clicked Ok button on prop up.
    And I added 1 th user first name "Many one only" only.
    Then I clicked the save button on multiple people add user window.
    Then I saw a prop up message-"Please enter a last name".
    And I clicked Ok button on prop up.
   And I added 2 random users from multiple People add form.
   Then I clicked the save button on multiple people add user window.  
    Then I waited for 3 seconds.
   #Then I clicked the cancel button on multiple people add user window.
   Then I confirmed that `the total spaces available` are greater than or equal to `currently in use`(license checked).    
    #And I clicked the 1 th newly created user in people page.
    #And I confirmed that the 1 th newly created user location is the same as the requestor location "ProcessAutomation3".
    And Log out From the Carriers.   
    #When I log in as a 1 th newly created user in the application using the password as Firstname.
    # And clicked Submit button on the login page.
     #checked for the home page
    #Then I logged in successfully.
    #When I clicked on user profile link.
    #Then I verified that the programs/courses "CSA for Drivers" assigned as per user location.
    #And I verified that the status is active.
    And I quit the browser.
    
    #hint password is not implemented
    # the admin "thirdcarriers.automation" is in place "ProcessAutomation3" when the module "CAS for Drivers",
  #Future work: I have to create a function which delete the last run created users.
		