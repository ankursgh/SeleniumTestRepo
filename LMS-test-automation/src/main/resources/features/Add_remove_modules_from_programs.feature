#Author: navaraj@carriersedge.com
#Role - Customer Support: Programs >> Module >> Show Modules >> Programs Add/Remove, LMST-720, And LMST-721
# The bug affects developing step 6. step 7.
Feature: Adding and removing modules from programs

  @LMST-720
  Scenario: Adding and removing modules from programs when logged in as the Customer Support role.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    #Step 1
    When I entered username "auto4.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    #Normalize Auto4Required program
    #Then I waited for 3 seconds.
    #When I clicked on the x module assigned of the "Auto4Required" program.
    #And I unselected "Winter Driving" if it is already selected which id "module-250" from the page.
    #And clicked on the save button.
    When I clicked on `x people assigned` to the "Auto4Required" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
    And I clicked on Unselect All in the program.
    And clicked on the save button.
    Then I waited for 3 seconds.
    When I clicked on the x module assigned of the "Auto4Required" program.
    Then I waited for 3 seconds.
    And I clicked on Unselect All in the program.
    Then I selected "CSA for Drivers" if it is not already selected which id is "module-312" from the page.
    And clicked on the save button.
    When I clicked on `x people assigned` to the "PDF12" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
    And I clicked on Unselect All in the program.
    And clicked on the save button.
    Then I waited for 5 seconds.
    When I clicked on `x people assigned` to the "TestRequired" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
    And I clicked on Unselect All in the program.
    And clicked on the save button.
    Then I waited for 5 seconds.
    #Normalize all programs
    When I clicked on `x people assigned` to the "Auto4Optional" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
    And I clicked on Unselect All in the program.
    And clicked on the save button.
    Then I waited for 5 seconds.
    When I clicked on `x people assigned` to the "TestOptional" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
    And I clicked on Unselect All in the program.
    And clicked on the save button.
    Then I waited for 5 seconds.
    And I scrolled down the entire window.
    When I clicked on `x people assigned` to the "Auto4Reference" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
    And I clicked on Unselect All in the program.
    And clicked on the save button.
    Then I waited for 5 seconds.
    And I scrolled down the entire window.
    When I clicked on `x people assigned` to the "TestReference" program.
    And I clicked on Unselect All in the program.
    And clicked on the save button.
    Then I waited for 5 seconds.
    #Normalize Winter Driving module, Number of user change to 0.
    When I clicked on the Show Modules icon on the People page.
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    And I clicked on Unselect All.
    Then I clicked on the Add To Program tab in the selected module.
    And I clicked on Unselect All.
    And clicked on the save button.
    Then I waited for 5 seconds.
    When I scrolled down the entire window by 250 px.
    #Step 2
    And I verified that 0 people assigned to the "Winter Driving" module which id is "module-250" on the Show Modules page.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    #Step 3
    #Then I clicked on the user "user-random.101" on the Assign people tab.
    Then I clicked on the Add To Program tab in the selected module.
    And I verified that programs should be separated into 3 categories on the Add To Program tab.
    #Step 4
    And I selected the program "Auto4Required" which id "program-7064" from the Add To Program tab.
    And I clicked on the reset checkbox.
    And clicked on the save button.
    Then I waited for 8 seconds.
    #Step 5
    And I clicked on Show Programs on the Programs page.
    Then I waited for 5 seconds.
    #And I clicked on Show Programs on the Programs page.
    #Then I waited for 3 seconds.
    #And I clicked on Show Programs on the Programs page.
    When I clicked on the x module assigned of the "Auto4Required" program.
    And I waited for 6 seconds.
    Then I verified that the modules "Winter Driving" are selected to the program.
    And I clicked on the Cancel button.
    #And I clicked on people at the navigation bar.
    #Step 6
    When I clicked on `x people assigned` to the "Auto4Required" program.
    And I clicked on user-id "user-random.1" to select the user if not already selected.
    #Then I clicked on the user "user-random.1" on the Assign people tab.-0
    And clicked on the save button.
    And I waited for 3 seconds.
    And I clicked on people at the navigation bar.
    And I waited for 4 seconds.
    And I verified that the status of user "random.1" on the people page is "Not started".
    #Step 7 and 6 repeated.
    #Step 8
    #Not clear , ask to Tommy for clearify
    # Talked to Tommy and Now the step is deleted in the test case. The below steps is less the 1 step below the line.
    #Step 8
    And I clicked on people at the navigation bar.
    And I clicked the username "random.1" on the people page to open the user profile.
    And I verified that the modules "Winter Driving" present in the user profile.
    And I verified that the status of the module "Winter Driving" in the user profile is "Not Started".
    And I clicked the Cancel button on the user profile window.
    #Step 9
    And Log out From the Carriers.
    When I entered username "random.1" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that the modules "Winter Driving" present under the program "Auto4Required" on the user home page.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    When I entered username "auto4.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    #Step 10
    When I clicked on the Show Modules icon on the People page.
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    #temp below commented for not removing program............................................................................................
    #And I clicked on Unselect All.
    And I selected the program "PDF12" which id "program-7031" from the Add To Program tab.
    And I selected the program "TestRequired" which id "program-15825" from the Add To Program tab.
    And clicked on the save button.
    Then I waited for 7 seconds.
    And I clicked on Show Programs on the Programs page.
    Then I waited for 5 seconds.
    #And I clicked on Show Programs on the Programs page.
    When I clicked on `x people assigned` to the "PDF12" program.
    And I clicked on user-id "user-random.101" to select the user if not already selected.
    And I clicked on the reset checkbox.
    #And I clicked on the Cancel button.
    #Then I clicked on the user "user-random.1" on the Assign people tab.
    And clicked on the save button.
    Then I waited for 3 seconds.
    And I clicked on Show Programs on the Programs page.
    When I clicked on `x people assigned` to the "TestRequired" program.
    And I clicked on user-id "user-random.105" to select the user if not already selected.
    And I clicked on the reset checkbox.
    And clicked on the save button.
    Then I waited for 5 seconds.
    And Log out From the Carriers.
    When I entered username "random.101" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that the modules "Winter Driving" present under the program "PDF12" on the user home page.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    When I entered username "random.105" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that the modules "Winter Driving" present under the program "TestRequired" on the user home page.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    #Step 11
    When I entered username "auto4.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    #Step Optional 3
    When I clicked on the Show Modules icon on the People page.
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    And I verified that programs should be separated into 3 categories on the Add To Program tab.
    #Step Optional 4
    And I selected the program "Auto4Optional" which id "program-15169" from the Add To Program tab.
    And I clicked on the reset checkbox.
    And clicked on the save button.
    Then I waited for 8 seconds.
    #Step Optional 5
    #there is a clicking problem in the below steps. so I clicked Show Programs 2 times
    And I clicked on Show Programs on the Programs page.
    Then I waited for 5 seconds.
    #And I clicked on Show Programs on the Programs page.
    #Then I waited for 5 seconds.
    When I scrolled down the entire window by 250 px.
    When I clicked on the x module assigned of the "Auto4Optional" program.
    And I waited for 6 seconds.
    Then I verified that the modules "Winter Driving" are selected to the program.
    And I clicked on the Cancel button.
    #And I clicked on people at the navigation bar.
    #Step Optional 6
    When I clicked on `x people assigned` to the "Auto4Optional" program.
    And I waited for 1 seconds.
    And I clicked on user-id "user-random.102" to select the user if not already selected.
    #Then I clicked on the user "user-random.102" on the Assign people tab.
    When I scrolled down the entire window by 250 px.
    And I waited for 13 seconds.
    And clicked on the save button.
    And I waited for 5 seconds.
    And I clicked on people at the navigation bar.
    And I waited for 3 seconds.
    And I verified that the status of user "random.102" on the people page is "Not started".
    #Step Optional 7 and 6 repeated.
    #Step Optional 8
    #Step Optional 9
    #And I clicked on people at the navigation bar.
    And I clicked the username "random.102" on the people page to open the user profile.
    And I verified that the modules "Winter Driving" present in the user profile.
    And I verified that the status of the module "Winter Driving" in the user profile is "Not Started".
    And I clicked the Cancel button on the user profile window.
    #Step Optional 10
    And Log out From the Carriers.
    When I entered username "random.102" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that the modules "Winter Driving" present under the program "Auto4Optional" on the user home page.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    When I entered username "auto4.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    #Step Optional 11
    When I clicked on the Show Modules icon on the People page.
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    #temp below commented for not removing program............................................................................................
    And I selected the program "TestOptional" which id "program-15826" from the Add To Program tab.
    And clicked on the save button.
    Then I waited for 7 seconds.
    And I clicked on Show Programs on the Programs page.
    Then I waited for 5 seconds.
    #	And I clicked on Show Programs on the Programs page.
    When I clicked on `x people assigned` to the "TestOptional" program.
    And I clicked on user-id "user-random.106" to select the user if not already selected.
    And I clicked on the reset checkbox.
    And clicked on the save button.
    Then I waited for 3 seconds.
    And Log out From the Carriers.
    When I entered username "random.106" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that the modules "Winter Driving" present under the program "TestOptional" on the user home page.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    #Step 12
    When I entered username "auto4.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    #Step Reference 3
    When I clicked on the Show Modules icon on the People page.
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    And I verified that programs should be separated into 3 categories on the Add To Program tab.
    #Step Reference 4
    And I selected the program "Auto4Refernece" which id "program-7016" from the Add To Program tab.
    And I clicked on the reset checkbox.
    And clicked on the save button.
    Then I waited for 9 seconds.
    #Step Reference 5
    And I clicked on Show Programs on the Programs page.
    Then I waited for 3 seconds.
    #And I clicked on Show Programs on the Programs page.
    #And I waited for 4 seconds.
    And I scrolled down the entire window.
    And I waited for 1 seconds.
    When I clicked on the x module assigned of the "Auto4Reference" program.
    And I waited for 6 seconds.
    Then I verified that the modules "Winter Driving" are selected to the program.
    And I clicked on the Cancel button.
    #And I clicked on people at the navigation bar.
    #Step Reference 6
    When I clicked on `x people assigned` to the "Auto4Reference" program.
    And I clicked on user-id "user-random.103" to select the user if not already selected.
    #Then I clicked on the user "user-random.103" on the Assign people tab.
    And clicked on the save button.
    And I waited for 4 seconds.
    And I clicked on people at the navigation bar.
    And I verified that the status of user "random.103" on the people page is "No Assignments".
    #Step Reference 7 and 6 repeated.
    #Step Reference 8
    #Not clear , ask to Tommy for clearify
    #Step Reference 9
    And I clicked on people at the navigation bar.
    And I clicked the username "random.103" on the people page to open the user profile.
    And I verified that the modules "Winter Driving" present in the user profile.
    And I verified that the status of the module "Winter Driving" in the user profile is "Not Started".
    And I clicked the Cancel button on the user profile window.
    #Step Reference 10
    And Log out From the Carriers.
    When I entered username "random.103" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that the modules "Winter Driving" present under the program "Auto4Reference" on the user home page.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    When I entered username "auto4.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    #Step Reference 11
    When I clicked on the Show Modules icon on the People page.
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    #temp below commented for not removing program............................................................................................
    #And I clicked on Unselect All.
    And I selected the program "TestReference" which id "program-15827" from the Add To Program tab.
    And clicked on the save button.
    Then I waited for 7 seconds.
    And I clicked on Show Programs on the Programs page.
    Then I waited for 4 seconds.
    And I scrolled down the entire window.
    When I clicked on `x people assigned` to the "TestReference" program.
    And I clicked on user-id "user-random.107" to select the user if not already selected.
    And I clicked on the reset checkbox.
    And clicked on the save button.
    Then I waited for 4 seconds.
    And Log out From the Carriers.
    When I entered username "random.107" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that the modules "Winter Driving" present under the program "TestReference" on the user home page.
    Then I verified that the status of module "Winter Driving" is "Not started" on the user homepage.
    And Log out From the Carriers.
    #Step 13
    When I entered username "auto4.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    And clicked on the save button.
    Then I waited for 4 seconds.
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    Then I verified that only 7 elements were selected.
    And I clicked on the Cancel button.
    #Step 14
    #Below are the steps for removing a module from one or more program.
    #Step 15 and
    #Step 16
    When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
    Then I verified that the guide text presents "Auto4Required, PDF12, TestRequired, Auto4Optional, TestOptional, Auto4Reference, TestReference" when I hovered over on x people assigned on the shows module page.
    #Step 17
    When I clicked on the Show Modules icon on the People page.
    Then I waited for 4 seconds.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    And I verified that programs should be separated into 3 categories on the Add To Program tab.
    #And I clicked on the Cancel button.
    #Step 18
    #Below step for Deselecting the program the module is assigned to
    And I selected the program "Auto4Required" which id "program-7064" from the Add To Program tab.
    And clicked on the save button.
    Then I waited for 4 seconds.
    When I scrolled down the entire window by 250 px.
    When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
    Then I verified that the guide text presents "PDF12, TestRequired, Auto4Optional, TestOptional, Auto4Reference, TestReference" when I hovered over on x people assigned on the shows module page.
    #Step 19
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    Then I verified that only 6 elements were selected.
    When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
    Then I verified that the guide text not presents "Auto4Required" when I hovered over on x people assigned on a module in the shows module page.
    #Step 20
    And I clicked on people at the navigation bar.
    And I waited for 4 seconds.
    And I verified that the status of user "random.1" on the people page is "Not started".
    And I clicked the username "random.1" on the people page to open the user profile.
    Then I waited for 3 seconds.
    And I scrolled the small window.
    #Step 21
    #Other modules present in the profile remain the same, that verified by the below steps.
    Then I verified that the modules "CSA for Drivers" present in the user profile.
    #Step 22
    And I verified that the modules "Winter Driving" not present in the user profile.
    And I verified that the module "Winter Driving" not present under the program "Auto4Required" in the user profile.
    #And I clicked the Cancel button on the user profile window.
    #Step 23
    And Log out From the Carriers.
    When I entered username "random.1" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #And I verified that the modules "Winter Driving" is not present on the user homepage.
    And I verified that the modules "Winter Driving" not present under the program "Auto4Required" on the user home page.
    And Log out From the Carriers.
    When I entered username "auto4.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    #Step 24
    #Below step for Deselecting the program the module is assigned to
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    And I selected the program "PDF12" which id "program-7031" from the Add To Program tab.
    And I selected the program "TestRequired" which id "program-15825" from the Add To Program tab.
    And clicked on the save button.
    Then I waited for 3 seconds.
    And I scrolled down the entire window by 250 px.
    When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
    Then I verified that the guide text presents "Auto4Optional, TestOptional, Auto4Reference, TestReference" when I hovered over on x people assigned on the shows module page.
    #RStep 19 for Step 24
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    Then I verified that only 4 elements were selected.
    When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
    Then I verified that the guide text not presents "PDF12" when I hovered over on x people assigned on a module in the shows module page.
    Then I verified that the guide text not presents "TestRequired" when I hovered over on x people assigned on a module in the shows module page.
    #RStep 20 for Step 24
    And I clicked on people at the navigation bar.
    And I waited for 3 seconds.
    And I verified that the status of user "random.101" on the people page is "Not started".
    And I clicked the username "random.101" on the people page to open the user profile.
    Then I waited for 3 seconds.
    And I scrolled the small window.
    #RStep 21 for Step 24
    #Other modules present in the profile remain the same, that verified by the below steps.
    #Then I verified that the modules "CSA for Drivers" present in the user profile.
    #RStep 22 for Step 24
    And I verified that the modules "Winter Driving" not present in the user profile.
    And I verified that the module "Winter Driving" not present under the program "PDF12" in the user profile.
    #And I clicked the Cancel button on the user profile window.
    #RStep 23 for Step 24
    And Log out From the Carriers.
    When I entered username "random.101" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #And I verified that the modules "Winter Driving" is not present on the user homepage.
    And I verified that the modules "Winter Driving" not present under the program "PDF12" on the user home page.
    And Log out From the Carriers.
    When I entered username "auto4.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    #Step 25
    #Below step for Deselecting the program the module is assigned to
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    #And I selected the program "TestOptional" which id "program-15826" from the Add To Program tab.
    And I unselected "TestOptional" if it is already selected which id "program-15826" from the page.
    #And I selected the program "Auto4Optional" which id "program-15169" from the Add To Program tab.
    And I unselected "Auto4Optional" if it is already selected which id "program-15169" from the page.
    And clicked on the save button.
    Then I waited for 4 seconds.
    When I scrolled down the entire window by 250 px.
    When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
    Then I verified that the guide text presents "Auto4Reference, TestReference" when I hovered over on x people assigned on the shows module page.
    #RStep 19 for Step 25
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    Then I verified that only 2 elements were selected.
    When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
    Then I verified that the guide text not presents "Auto4Optional" when I hovered over on x people assigned on a module in the shows module page.
    Then I verified that the guide text not presents "TestOptional" when I hovered over on x people assigned on a module in the shows module page.
    #RStep 20 for Step 25
    And I clicked on people at the navigation bar.
    And I waited for 1 seconds.
    And I verified that the status of user "random.102" on the people page is "No Assignments".
    And I clicked the username "random.102" on the people page to open the user profile.
    Then I waited for 3 seconds.
    And I scrolled the small window.
    #RStep 21 for Step 25
    #Other modules present in the profile remain the same, that verified by the below steps.
    #Then I verified that the modules "CSA for Drivers" present in the user profile.
    #RStep 22 for Step 25
    And I verified that the modules "Winter Driving" not present in the user profile.
    And I verified that the module "Winter Driving" not present under the program "TestOptional" in the user profile.
    And I verified that the module "Winter Driving" not present under the program "Auto4Optional" in the user profile.
    #And I clicked the Cancel button on the user profile window.
    #RStep 23 for Step 25
    And Log out From the Carriers.
    When I entered username "random.102" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #And I verified that the modules "Winter Driving" is not present on the user homepage.
    And I verified that the modules "Winter Driving" not present under the program "Auto4Optional" on the user home page.
    And Log out From the Carriers.
    When I entered username "auto4.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    #Step 26
    #Below step for Deselecting the program the module is assigned to
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    And I selected the program "TestReference" which id "program-15827" from the Add To Program tab.
    And I selected the program "Auto4Refernece" which id "program-7016" from the Add To Program tab.
    And clicked on the save button.
    Then I waited for 3 seconds.
    When I scrolled down the entire window by 250 px.
    When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
    #Then I verified that the guide text presents "Auto4Reference, TestReference" when I hovered over on x people assigned on the shows module page.
    #RStep 19 for Step 26
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    Then I verified that only 0 elements were selected.
    When I hovered Over on the `x people assigned` of the module "Winter Driving" module which id is "module-250".
    Then I verified that the guide text not presents "Auto4Refernece" when I hovered over on x people assigned on a module in the shows module page.
    Then I verified that the guide text not presents "TestReference" when I hovered over on x people assigned on a module in the shows module page.
    #RStep 20 for Step 26
    And I clicked on people at the navigation bar.
    And I waited for 3 seconds.
    And I verified that the status of user "random.103" on the people page is "No Assignments".
    And I clicked the username "random.103" on the people page to open the user profile.
    Then I waited for 3 seconds.
    And I scrolled the small window.
    #RStep 21 for Step 26
    #Other modules present in the profile remain the same, that verified by the below steps.
    #Then I verified that the modules "CSA for Drivers" present in the user profile.
    #RStep 22 for Step 26
    And I verified that the modules "Winter Driving" not present in the user profile.
    And I verified that the module "Winter Driving" not present under the program "TestReference" in the user profile.
    And I verified that the module "Winter Driving" not present under the program "Auto4Refernece" in the user profile.
    #And I clicked the Cancel button on the user profile window.
    #RStep 23 for Step 26
    And Log out From the Carriers.
    When I entered username "random.103" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    #And I verified that the modules "Winter Driving" is not present on the user homepage.
    And I verified that the modules "Winter Driving" not present under the program "Auto4Refernece" on the user home page.
    And Log out From the Carriers.
    When I entered username "auto4.cs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    # Step 27
    When I clicked on the Show Modules icon on the People page.
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    And clicked on the save button.
    Then I waited for 4 seconds.
    When I scrolled down the entire window by 250 px.
    When I clicked on `x people assigned` to module "Winter Driving" module which id is "module-250".
    Then I clicked on the Add To Program tab in the selected module.
    Then I verified that only 0 elements were selected.
    And I clicked on the Cancel button.
    And I closed the browser.

 