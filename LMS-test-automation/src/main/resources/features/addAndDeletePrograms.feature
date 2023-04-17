#Author: navaraj@carriersedge.com
Feature: Adding and Delete program.
  This automation test 4 regression tests.LMST-699,LMST-700, LMST-714 and LMST-734.
  The application does not check few bugs knowingly.Over all status of a user is not checking.
 Scenario: Adding and Delete program when logged in as the Carrier Admin role.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    #Step 1
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #Step 2
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 2 seconds.
    Then I search programs` names start with Temp and delete them.
    #New added above 2 lines for deleting any Temp programs if exist due to provious fail.
    #Step 3
    When I hover over on the Programs in the Program page.
    When I clicked on the Add Programs icon.
    Then I typed "TempRequired program" as the new program name.
    #Step 4
    When I clicked on Add French Name.
    Then I typed "TempRequired program french" as the new program french name.
    #Step 5
    Then I selected the program type as "Required".
    #Step 6
    When I selected the program available immediately option.
    #Step 7
    When I set the program needs to completed with no specific deadline.
    Then I waited for 1 seconds.
    And I scrolled the small window.
    #Step 8, full courses and refreshers for the full course are not added to the same program
    # module-250 is for Wrinter Driving, module-486 for Fire Safety
    Then I selected a module "module-250" module to add in the program.
    #module-1045 for WHMIS 2015
    Then I selected a module "module-1045" module to add in the program.
    #Step 9
    And I selected a user "user-as.test.user" for the assigned in the program.
    #Step 10
    And I selected the Assign Places tab on the program assigned display window.
    #place-16895 is Place1 and place-19581 is TestPlace2 in ProcessAutomation
    And I selected a place "place-22037" for the assigned in the program.
    #Step 11
    And I clicked on the reset checkbox.
    #Step 12
    And I checked on the `Notify People They have been Assigned to a Program`.
    And I checked on the `Include login details in the notification`.
    And clicked on the save button.
    #step 13
    When I clicked on `x people assigned` to the "TempRequired program" program.
    And I waited for 1 seconds.
    Then I verified that the users "Test user" are selected to the program.
    And I clicked on the Cancel button.
    #Step 14
    #Verify french name
    When I clicked on the language option on the top right corner of the page.
    Then I selected the language "FR" from the language options.
    And I clicked on Programs in the navigation bar main menu.
    Then I verified that the program "TempRequired program french" present on the program page.
    When I clicked on the language option on the top right corner of the page.
    Then I selected the language "EN" from the language options.
    And I clicked on Programs in the navigation bar main menu.
    #Step 15
    When I clicked on the x module assigned of the "TempRequired program" program.
    And I waited for 1 seconds.
    Then I verified that the modules "WHMIS 2015, Winter Driving" are selected to the program.
    And I clicked on the Cancel button.
    And I clicked on people at the navigation bar.
    #Step 16
    And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I verified that the programs "TempRequired program" are assigned to the user profile.
    #Step 17
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    #Step 18
    And I verified that the status of user "as.test.user" on the people page is "Not Started".
    #Step 22 since it is similar to step 16,17,18 for other user in TestPlace2 and also 19,20 and 21
    And I clicked the username "as.test.user2" on the people page to open the user profile.
    Then I verified that the programs "TempRequired program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "as.test.user2" on the people page is "Not Started".
    #Step 19
    And Log out From the Carriers.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempRequired program" appeared in the user`s dashboard.
    #Step 20
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    #step 21,
    Then I verified that the email `processautomationshare@gmail.com` got a notification that contains "the following training modules to you, WHMIS 2015, Winter Driving" about the new training.
    #Step 22
    And Log out From the Carriers.
    When I entered username "as.test.user2" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempRequired program" appeared in the user`s dashboard.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    #Step 23
    And Log out From the Carriers.
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on `x people assigned` to the "TempRequired program" program.
    Then I verified that the people "Test user2, Test user3" assigned through places not appeared under the `Assign People` section under the `People Assigned` link.
    And I clicked on the Cancel button.
    #Delete Required Program added from here
    #Delete Step  2
    And I verified that the program "TempRequired program" found in the "Required Programs" section.
    #Delete Step  3
    Then I verified that 2 modules assigned to the "TempRequired program" program.
    And I verified that 3 people assigned to the "TempRequired program" program.
    When I clicked on `x people assigned` to the "TempRequired program" program.
    Then I verified that the people "Test user2, Test user3" are assigned through the place.
    And I verified that the users "Test user" are selected to the program.
    And I clicked on the Cancel button.
    #Delete Step  4
    When I hovered over on the "TempRequired program" program and verified that 2 buttons `delete and program order` present.
    #Delete Step  5
    Then I clicked on the delete button of the program "TempRequired program" on the programs page.
    #Delete Step  6
    And I clicked on the Cancel button on the delete program conform window.
    #Delete Step  7
    When I hovered over on the "TempRequired program" program and verified that 2 buttons `delete and program order` present.
    Then I clicked on the delete button of the program "TempRequired program" on the programs page.
    And I clicked on the delete button on the delete program conform window.
    #Delete Step  8
    Then I confirmed that the program "TempRequired program" is not present on the Show Programs page.
    #Delete Step  9
    When I clicked on the Show Modules icon on the People page.
    Then I verified that the modules "Fire Safety, WHMIS 2015" that were in the program have not been deleted.
    #Delete Step  10
    And I clicked on people at the navigation bar.
    And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I verified that the program "TempRequired program" is not present on the user profile.
    And I clicked the Cancel button on the user profile window.
    #Delete Step  11
    #No Assignments, Not Started
    And I verified that the status of user "as.test.user" on the people page is "Not Started".
    #Delete Step  12
    And Log out From the Carriers.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    Then I verified that programs "TempRequired program" not present on the user`s dashboard.
    And Log out From the Carriers.
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    #Then I deleted the program "TempRequired program" from the carrier.
    #Step 24
    #Repeat For Optional program
    When I hover over on the Programs in the Program page.
    And I clicked on the Add Programs icon.
    Then I typed "TempOptional program" as the new program name.
    When I clicked on Add French Name.
    Then I typed "TempOptional program french" as the new program french name.
    Then I selected the program type as "Optional".
    When I selected the program available immediately option.
    # When I set the program needs to completed with no specific deadline.# since this option is not for optional program
    Then I waited for 1 seconds.
    And I scrolled the small window.
    # module-250 is for Winter Driving, module-486 for Fire Safety
    Then I selected a module "module-486" module to add in the program.
    #module-1045 for WHMIS 2015
    Then I selected a module "module-1045" module to add in the program.
    And I selected a user "user-as.test.user" for the assigned in the program.
    And I selected the Assign Places tab on the program assigned display window.
    #place-16895 is Place1 and place-19581 is TestPlace2 in ProcessAutomation
    And I selected a place "place-22037" for the assigned in the program.
    And I clicked on the reset checkbox.
    And I checked on the `Notify People They have been Assigned to a Program`.
    And I checked on the `Include login details in the notification`.
    And clicked on the save button.
    When I clicked on `x people assigned` to the "TempOptional program" program.
    And I waited for 1 seconds.
    Then I verified that the users "Test user" are selected to the program.
    And I clicked on the Cancel button.
    #Verify french name
    When I clicked on the language option on the top right corner of the page.
    Then I selected the language "FR" from the language options.
    And I clicked on Programs in the navigation bar main menu.
    Then I verified that the program "TempOptional program french" present on the program page.
    When I clicked on the language option on the top right corner of the page.
    Then I selected the language "EN" from the language options.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the x module assigned of the "TempOptional program" program.
    And I waited for 1 seconds.
    Then I verified that the modules "WHMIS 2015, Fire Safety" are selected to the program.
    And I clicked on the Cancel button.
    And I clicked on people at the navigation bar.
    And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I verified that the programs "TempOptional program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Fire Safety" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "as.test.user" on the people page is "Not Started".
    And I clicked the username "as.test.user2" on the people page to open the user profile.
    Then I verified that the programs "TempOptional program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Fire Safety" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "as.test.user2" on the people page is "Not Started".
    And Log out From the Carriers.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempOptional program" appeared in the user`s dashboard.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Fire Safety" is "Not started" on the user homepage.
    Then I verified that the email `processautomationshare@gmail.com` got a notification that contains "the following training modules to you, WHMIS 2015, Fire Safety" about the new training.
    And Log out From the Carriers.
    When I entered username "as.test.user2" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempOptional program" appeared in the user`s dashboard.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Fire Safety" is "Not started" on the user homepage.
    And Log out From the Carriers.
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on `x people assigned` to the "TempOptional program" program.
    Then I verified that the people "Test user2, Test user3" assigned through places not appeared under the `Assign People` section under the `People Assigned` link.
    And I clicked on the Cancel button.
    #Delete Optional program
    #Delete Step  2
    And I verified that the program "TempOptional program" found in the "Optional Programs" section.
    #Delete Step  3
    Then I verified that 2 modules assigned to the "TempOptional program" program.
    And I verified that 3 people assigned to the "TempOptional program" program.
    When I clicked on `x people assigned` to the "TempOptional program" program.
    Then I verified that the people "Test user2, Test user3" are assigned through the place.
    And I verified that the users "Test user" are selected to the program.
    And I clicked on the Cancel button.
    #Delete Step  4
    When I hovered over on the "TempOptional program" program and verified that 2 buttons `delete and program order` present.
    #Delete Step  5
    Then I clicked on the delete button of the program "TempOptional program" on the programs page.
    #Delete Step  6
    And I clicked on the Cancel button on the delete program conform window.
    #Delete Step  7
    When I hovered over on the "TempOptional program" program and verified that 2 buttons `delete and program order` present.
    Then I clicked on the delete button of the program "TempOptional program" on the programs page.
    And I clicked on the delete button on the delete program conform window.
    #Delete Step  8
    Then I confirmed that the program "TempOptional program" is not present on the Show Programs page.
    #Delete Step  9
    When I clicked on the Show Modules icon on the People page.
    Then I verified that the modules "Fire Safety, WHMIS 2015" that were in the program have not been deleted.
    #Delete Step  10
    And I clicked on people at the navigation bar.
    And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I verified that the program "TempOptional program" is not present on the user profile.
    And I clicked the Cancel button on the user profile window.
    #Delete Step  11
    #No Assignments, Not Started
    And I verified that the status of user "as.test.user" on the people page is "Not started".
    #Delete Step  12
    And Log out From the Carriers.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    Then I verified that programs "TempOptional program" not present on the user`s dashboard.
    And Log out From the Carriers.
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    #Then I deleted the program "TempOptional program" from the carrier.
    #Step 25
    #Repeat for Reference program
    When I hover over on the Programs in the Program page.
    And I clicked on the Add Programs icon.
    Then I typed "TempReference program" as the new program name.
    When I clicked on Add French Name.
    Then I typed "TempReference program french" as the new program french name.
    Then I selected the program type as "Reference".
    When I selected the program available immediately option.
    # When I set the program needs to completed with no specific deadline.# since this option is not for Reference program
    Then I waited for 1 seconds.
    And I scrolled the small window.
    # module-250 is for Wrinter Driving, module-486 for Fire Safety
    Then I selected a module "module-250" module to add in the program.
    #module-1045 for WHMIS 2015
    Then I selected a module "module-1045" module to add in the program.
    And I selected a user "user-as.test.user" for the assigned in the program.
    And I selected the Assign Places tab on the program assigned display window.
    #place-16895 is Place1 and place-19581 is TestPlace2 in ProcessAutomation
    And I selected a place "place-22037" for the assigned in the program.
    And I clicked on the reset checkbox.
    And I checked on the `Notify People They have been Assigned to a Program`.
    And I checked on the `Include login details in the notification`.
    And clicked on the save button.
    When I clicked on `x people assigned` to the "TempReference program" program.
    And I waited for 1 seconds.
    Then I verified that the users "Test user" are selected to the program.
    And I clicked on the Cancel button.
    #How to verify french name
    #Verify french name
    When I clicked on the language option on the top right corner of the page.
    Then I selected the language "FR" from the language options.
    And I clicked on Programs in the navigation bar main menu.
    Then I verified that the program "TempReference program french" present on the program page.
    When I clicked on the language option on the top right corner of the page.
    Then I selected the language "EN" from the language options.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the x module assigned of the "TempReference program" program.
    And I waited for 1 seconds.
    Then I verified that the modules "WHMIS 2015, Winter Driving" are selected to the program.
    And I clicked on the Cancel button.
    And I clicked on people at the navigation bar.
    And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I verified that the programs "TempReference program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    #status of the person does not effect by reference program so not Checked or below replace status check "No Assignments"
    #And I verified that the status of user "as.test.user" on the people page is "No Assignments".
    And I clicked the username "as.test.user2" on the people page to open the user profile.
    Then I verified that the programs "TempReference program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    #status of the person does not effect by reference program so not Checked or below replace status check "No Assignments"
    #And I verified that the status of user "as.test.user2" on the people page is "No Assignments".
    And Log out From the Carriers.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempReference program" appeared in the user`s dashboard.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    Then I verified that the email `processautomationshare@gmail.com` got a notification that contains "the following training modules to you, WHMIS 2015, Winter Driving" about the new training.
    And Log out From the Carriers.
    When I entered username "as.test.user2" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempReference program" appeared in the user`s dashboard.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on `x people assigned` to the "TempReference program" program.
    Then I verified that the people "Test user2, Test user3" assigned through places not appeared under the `Assign People` section under the `People Assigned` link.
    And I clicked on the Cancel button.
    #Delete program for Reference
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
    And I clicked on the delete button on the delete program conform window.
    #Delete Step  8
    Then I confirmed that the program "TempReference program" is not present on the Show Programs page.
    #Delete Step  9
    When I clicked on the Show Modules icon on the People page.
    Then I verified that the modules "Fire Safety, WHMIS 2015" that were in the program have not been deleted.
    #Delete Step  10
    And I clicked on people at the navigation bar.
    And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I verified that the program "TempReference program" is not present on the user profile.
    And I clicked the Cancel button on the user profile window.
    #Delete Step  11
    #No Assignments, Not Started
    And I verified that the status of user "as.test.user" on the people page is "Not started".
    #Delete Step  12
    And Log out From the Carriers.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    Then I verified that programs "TempReference program" not present on the user`s dashboard.
    And Log out From the Carriers.
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    #Then I deleted the program "TempReference program" from the carrier.
    #Step 26,27,28
    # For this step I use today date and program can be seen in user profile and homepage,
    #if choose as of tomrrow then there will no such program in user profile and home page.we need to change for checking no such program if tommrow date is taken.
    When I hover over on the Programs in the Program page.
    When I clicked on the Add Programs icon.
    Then I typed "TempRequired2 program" as the new program name.
    When I clicked on Add French Name.
    Then I typed "TempRequired2 program french" as the new program french name.
    Then I selected the program type as "Required".
    #When I selected the program available immediately option.
    When I selected the program available as of the "today date" option.
    #The below step is only for clicking anyware in the small window to disapear date window.
    And I selected the Assign People tab in a small window.
    #Then I click on the program detail heading for the date window to disappear.
    When I set the program needs to completed with no specific deadline.
    Then I waited for 1 seconds.
    And I scrolled the small window.
    #Step 8, full courses and refreshers for the full course are not added to the same program
    # module-250 is for Wrinter Driving, module-486 for Fire Safety
    Then I selected a module "module-250" module to add in the program.
    #module-1045 for WHMIS 2015
    Then I selected a module "module-1045" module to add in the program.
    And I selected a user "user-as.test.user" for the assigned in the program.
    And I selected the Assign Places tab on the program assigned display window.
    #place-16895 is Place1 and place-19581 is TestPlace2 in ProcessAutomation
    And I selected a place "place-22037" for the assigned in the program.
    And I clicked on the reset checkbox.
    And I checked on the `Notify People They have been Assigned to a Program`.
    And I checked on the `Include login details in the notification`.
    And clicked on the save button.
    When I clicked on `x people assigned` to the "TempRequired2 program" program.
    And I waited for 1 seconds.
    Then I verified that the users "Test user" are selected to the program.
    And I clicked on the Cancel button.
    #How to verify french name
    When I clicked on the x module assigned of the "TempRequired2 program" program.
    And I waited for 1 seconds.
    Then I verified that the modules "WHMIS 2015, Winter Driving" are selected to the program.
    And I clicked on the Cancel button.
    And I clicked on people at the navigation bar.
    And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I verified that the programs "TempRequired2 program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "as.test.user" on the people page is "Not Started".
    And I clicked the username "as.test.user2" on the people page to open the user profile.
    Then I verified that the programs "TempRequired2 program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "as.test.user2" on the people page is "Not Started".
    And Log out From the Carriers.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempRequired2 program" appeared in the user`s dashboard.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    #step 21, has to implemented later
    #And I checked a user`s email and verified that the user got a notification that contains "CSA for Drivers, Random" about the course or login.
    And Log out From the Carriers.
    When I entered username "as.test.user2" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempRequired2 program" appeared in the user`s dashboard.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on `x people assigned` to the "TempRequired2 program" program.
    Then I verified that the people "Test user2, Test user3" assigned through places not appeared under the `Assign People` section under the `People Assigned` link.
    And I clicked on the Cancel button.
    Then I waited for 1 seconds.
    Then I deleted the program "TempRequired2 program" from the carrier.
    #Step 29,30,31
    #Step 29,30,31 part 1, when the program available in 1 days. that means program available tomorrow, not present now.
    When I hover over on the Programs in the Program page.
    Then I waited for 6 seconds.
    When I clicked on the Add Programs icon.
    Then I waited for 4 seconds.
    Then I typed "TempRequired2 program" as the new program name.
    When I clicked on Add French Name.
    Then I typed "TempRequired2 program french" as the new program french name.
    Then I selected the program type as "Required".
    #When I selected the program available immediately option.
    # When I selected the program available as of the "today date" option.
    When I selected the program available "1" days after the assignment.
    When I set the program needs to completed with no specific deadline.
    Then I waited for 1 seconds.
    And I scrolled the small window.
    # module-250 is for Wrinter Driving, module-486 for Fire Safety
    Then I selected a module "module-250" module to add in the program.
    #module-1045 for WHMIS 2015
    Then I selected a module "module-1045" module to add in the program.
    And I selected a user "user-as.test.user" for the assigned in the program.
    And I selected the Assign Places tab on the program assigned display window.
    #place-16895 is Place1 and place-19581 is TestPlace2 in ProcessAutomation
    And I selected a place "place-22037" for the assigned in the program.
    And I clicked on the reset checkbox.
    And I checked on the `Notify People They have been Assigned to a Program`.
    And I checked on the `Include login details in the notification`.
    And clicked on the save button.
    When I clicked on `x people assigned` to the "TempRequired2 program" program.
    And I waited for 1 seconds.
    Then I verified that the users "Test user" are selected to the program.
    And I clicked on the Cancel button.
    #How to verify french name
    When I clicked on the x module assigned of the "TempRequired2 program" program.
    And I waited for 1 seconds.
    Then I verified that the modules "WHMIS 2015, Winter Driving" are selected to the program.
    And I clicked on the Cancel button.
    And I clicked on people at the navigation bar.
    And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I checked the user`s profile and verified that the module "WHMIS 2015" is not present.
    Then I checked the user`s profile and verified that the module "Winter Driving" is not present.
    And I clicked the Cancel button on the user profile window.
    #Since the program will assign the user after one day, so the over all status is "Not Started" for future program.
    And I verified that the status of user "as.test.user" on the people page is "Not Started".
    And I clicked the username "as.test.user2" on the people page to open the user profile.
    Then I checked the user`s profile and verified that the module "WHMIS 2015" is not present.
    Then I checked the user`s profile and verified that the module "Winter Driving" is not present.
    And I clicked the Cancel button on the user profile window.
    #Since the program will assign the user after one day, so the over all status is "Not Started" for future program.
    And I verified that the status of user "as.test.user2" on the people page is "Not Started".
    And Log out From the Carriers.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that none of the modules "WHMIS 2015, Winter Driving" present on the user homepage.
    And Log out From the Carriers.
    When I entered username "as.test.user2" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #And I verified that programs "TempRequired2 program" appeared in the user`s dashboard.
    And I verified that none of the modules "WHMIS 2015, Winter Driving" present on the user homepage.
    And Log out From the Carriers.
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on `x people assigned` to the "TempRequired2 program" program.
    Then I verified that the people "Test user2, Test user3" assigned through places not appeared under the `Assign People` section under the `People Assigned` link.
    And I clicked on the Cancel button.
    Then I deleted the program "TempRequired2 program" from the carrier.
    #Step 29,30,31 part 2, when the program available in 0 days. that means program available
    When I hover over on the Programs in the Program page.
    When I clicked on the Add Programs icon.
    Then I typed "TempRequired2 program" as the new program name.
    When I clicked on Add French Name.
    Then I typed "TempRequired2 program french" as the new program french name.
    Then I selected the program type as "Required".
    When I selected the program available "0" days after the assignment.
    When I set the program needs to completed with no specific deadline.
    Then I waited for 1 seconds.
    And I scrolled the small window.
    # module-250 is for Wrinter Driving, module-486 for Fire Safety
    Then I selected a module "module-250" module to add in the program.
    #module-1045 for WHMIS 2015
    Then I selected a module "module-1045" module to add in the program.
    And I selected a user "user-as.test.user" for the assigned in the program.
    And I selected the Assign Places tab on the program assigned display window.
    #place-16895 is Place1 and place-19581 is TestPlace2 in ProcessAutomation
    And I selected a place "place-22037" for the assigned in the program.
    And I clicked on the reset checkbox.
    And I checked on the `Notify People They have been Assigned to a Program`.
    And I checked on the `Include login details in the notification`.
    And clicked on the save button.
    When I clicked on `x people assigned` to the "TempRequired2 program" program.
    And I waited for 1 seconds.
    Then I verified that the users "Test user" are selected to the program.
    And I clicked on the Cancel button.
    #How to verify french name
    When I clicked on the x module assigned of the "TempRequired2 program" program.
    And I waited for 1 seconds.
    Then I verified that the modules "WHMIS 2015, Winter Driving" are selected to the program.
    And I clicked on the Cancel button.
    And I clicked on people at the navigation bar.
    And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I verified that the programs "TempRequired2 program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "as.test.user" on the people page is "Not Started".
    And I clicked the username "as.test.user2" on the people page to open the user profile.
    Then I verified that the programs "TempRequired2 program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "as.test.user2" on the people page is "Not Started".
    And Log out From the Carriers.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempRequired2 program" appeared in the user`s dashboard.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    #And I checked a user`s email and verified that the user got a notification that contains "CSA for Drivers, Random" about the course or login.
    And Log out From the Carriers.
    When I entered username "as.test.user2" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempRequired2 program" appeared in the user`s dashboard.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on `x people assigned` to the "TempRequired2 program" program.
    Then I verified that the people "Test user2, Test user3" assigned through places not appeared under the `Assign People` section under the `People Assigned` link.
    And I clicked on the Cancel button.
    Then I deleted the program "TempRequired2 program" from the carrier.
    #Step 32
    When I hover over on the Programs in the Program page.
    When I clicked on the Add Programs icon.
    Then I typed "TempRequired program" as the new program name.
    When I clicked on Add French Name.
    Then I typed "TempRequired program french" as the new program french name.
    Then I selected the program type as "Required".
    When I selected the program available immediately option.
    #Step 7
    #When I set the program needs to completed with no specific deadline.
    When I chose the program needs to completed within 2 days.
    Then I waited for 1 seconds.
    And I scrolled the small window.
    # module-250 is for Wrinter Driving, module-486 for Fire Safety
    Then I selected a module "module-250" module to add in the program.
    #module-1045 for WHMIS 2015
    Then I selected a module "module-1045" module to add in the program.
    And I selected a user "user-as.test.user" for the assigned in the program.
    And I selected the Assign Places tab on the program assigned display window.
    #place-16895 is Place1 and place-19581 is TestPlace2 in ProcessAutomation
    And I selected a place "place-22037" for the assigned in the program.
    And I clicked on the reset checkbox.
    And I checked on the `Notify People They have been Assigned to a Program`.
    And I checked on the `Include login details in the notification`.
    And clicked on the save button.
    When I clicked on `x people assigned` to the "TempRequired program" program.
    And I waited for 1 seconds.
    Then I verified that the users "Test user" are selected to the program.
    And I clicked on the Cancel button.
    When I clicked on the x module assigned of the "TempRequired program" program.
    And I waited for 1 seconds.
    Then I verified that the modules "WHMIS 2015, Winter Driving" are selected to the program.
    And I clicked on the Cancel button.
    And I clicked on people at the navigation bar.
    And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I verified that the programs "TempRequired program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "as.test.user" on the people page is "Not Started".
    And I clicked the username "as.test.user2" on the people page to open the user profile.
    Then I verified that the programs "TempRequired program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "as.test.user2" on the people page is "Not Started".
    And Log out From the Carriers.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempRequired program" appeared in the user`s dashboard.
    #Step 34, 35 for one user
    When I hovered over the mouse on the program "TempRequired program" on the user homepage.
    Then I verified that Guide text warn the user "The deadline for this program is " dated 2 days from today.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    Then I verified that the email `processautomationshare@gmail.com` got a notification that contains "the following training modules to you, WHMIS 2015, Winter Driving" about the new training.
    And Log out From the Carriers.
    When I entered username "as.test.user2" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempRequired program" appeared in the user`s dashboard.
    #Step 34, 35 for user in a place
    When I hovered over the mouse on the program "TempRequired program" on the user homepage.
    Then I verified that Guide text warn the user "The deadline for this program is " dated 2 days from today.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on `x people assigned` to the "TempRequired program" program.
    Then I verified that the people "Test user2, Test user3" assigned through places not appeared under the `Assign People` section under the `People Assigned` link.
    And I clicked on the Cancel button.
    #Step 33
    Then I verified that when hovered over the mouse on the deadline link of the "TempRequired program" the display message warns users with the message `The deadline for this program is 2 days.'
    Then I deleted the program "TempRequired program" from the carrier.
    #Step 36
    When I hover over on the Programs in the Program page.
    When I clicked on the Add Programs icon.
    Then I typed "TempRequired program" as the new program name.
    When I clicked on Add French Name.
    Then I typed "TempRequired program french" as the new program french name.
    Then I selected the program type as "Required".
    When I selected the program available immediately option.
    #When I set the program needs to completed with no specific deadline.
    When I set the program needs to completed by the end of "tomorrow date".
    Then I waited for 1 seconds.
    And I scrolled the small window.
    # module-250 is for Wrinter Driving, module-486 for Fire Safety
    Then I selected a module "module-250" module to add in the program.
    #module-1045 for WHMIS 2015
    Then I selected a module "module-1045" module to add in the program.
    And I selected a user "user-as.test.user" for the assigned in the program.
    And I selected the Assign Places tab on the program assigned display window.
    #place-16895 is Place1 and place-19581 is TestPlace2 in ProcessAutomation
    And I selected a place "place-22037" for the assigned in the program.
    And I clicked on the reset checkbox.
    And I checked on the `Notify People They have been Assigned to a Program`.
    And I checked on the `Include login details in the notification`.
    And clicked on the save button.
    When I clicked on `x people assigned` to the "TempRequired program" program.
    And I waited for 1 seconds.
    Then I verified that the users "Test user" are selected to the program.
    And I clicked on the Cancel button.
    When I clicked on the x module assigned of the "TempRequired program" program.
    And I waited for 1 seconds.
    Then I verified that the modules "WHMIS 2015, Winter Driving" are selected to the program.
    And I clicked on the Cancel button.
    And I clicked on people at the navigation bar.
    And I clicked the username "as.test.user" on the people page to open the user profile.
    Then I verified that the programs "TempRequired program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "as.test.user" on the people page is "Not Started".
    And I clicked the username "as.test.user2" on the people page to open the user profile.
    Then I verified that the programs "TempRequired program" are assigned to the user profile.
    And I verified that the modules "WHMIS 2015, Winter Driving" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "as.test.user2" on the people page is "Not Started".
    And Log out From the Carriers.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempRequired program" appeared in the user`s dashboard.
    #Step 37, Repeat->Step 34, 35 for one user
    When I hovered over the mouse on the program "TempRequired program" on the user homepage.
    Then I verified that Guide text warn the user "The deadline for this program is " dated 1 days from today.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    Then I verified that the email `processautomationshare@gmail.com` got a notification that contains "the following training modules to you, WHMIS 2015, Winter Driving" about the new training.
    And Log out From the Carriers.
    When I entered username "as.test.user2" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that programs "TempRequired program" appeared in the user`s dashboard.
    #Step 37->Repeat Step 34, 35 for user in a place
    When I hovered over the mouse on the program "TempRequired program" on the user homepage.
    Then I verified that Guide text warn the user "The deadline for this program is " dated 1 days from today.
    Then I verified that the status of module "WHMIS 2015" is "Not started" on the user homepage.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    When I entered username "as.automation.admin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on `x people assigned` to the "TempRequired program" program.
    Then I verified that the people "Test user2, Test user3" assigned through places not appeared under the `Assign People` section under the `People Assigned` link.
    And I clicked on the Cancel button.
    #display guide verify which was not in test case
    #Then I verified that the display guide of the "TempRequired program" program showed "tomorrow date" days.
    Then I verified that the display guide of the "TempRequired program" program showed "1" days after today`s date.
    Then I deleted the program "TempRequired program" from the carrier.
    And I quit the browser.






#sddddddddddddddddddddddddddddd
 
 
#Note:environment-ProcessAutomation , Already two program exists-AccidientSceneProgram and Driving Testing,No any modules selected for any places
# Driver Testing program contain "CAS for Drivers" modules for add user test and Automation Station2 place assigne the place.  
#TestPlace2 place must be at least one user "as.test.user2" since I check that user 
#
