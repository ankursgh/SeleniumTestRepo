#Author: ankur.shukla@rsystems.com
#Role - Sub Admin: Programs >> Module >> Show Modules >> People Assigned/unassigned , Test-LMST-962
#Role - Regional Manager: Programs >> Module >> Show Modules >> People Assigned/unassigned , Test-LMST-963
@LMST-962
Feature: Assigning and Unassigning modules to users.

  Scenario: Assigning and Unassigning modules to users when logged in as Sub admin.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    #Step 1
    When I entered username "autom.sadmin" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    #Normalize Winter Driving module
    When I clicked on the Show Modules icon on the People page.
    When I clicked on `x people assign` to module "Lift Truck Operator Skills" module which id is "module-389".
    Then I waited for 6 seconds.
    And I clicked on Unselect All.
    Then I waited for 6 seconds.
    And clicked on the save button.
    #Step 2
    And I verified that 0 people assigned to the "Lift Truck Operator Skills" module which id is "module-389" on the Show Modules page.
    #Step 3
    When I clicked on `x people assign` to module "Lift Truck Operator Skills" module which id is "module-389".
    Then I waited for 6 seconds.
    Then I clicked on the user "user-autom.sadmin" on the Assign people tab.
    And clicked on the save button.
    Then I waited for 6 seconds.
    When I clicked on people at the navigation bar.
    #Step 4
    And I clicked the username "autom.sadmin" on the people page to open the user profile.
    Then I waited for 6 seconds.
    And I verified that the modules "Lift Truck Operator Skills" present in the user profile.
    Then I waited for 2 seconds.
    #Then I verified that the status of module "Lift Truck Operator Skills" is "Not started" on the user homepage.
    And I clicked the Cancel button on the user profile window.
    #Step 5
    Then I waited for 2 seconds.
    And I verified that the status of user "autom.sadmin" on the people page is "Not Started".
    #Step 6
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    And I verified that 1 people assigned to the "Lift Truck Operator Skills" module which id is "module-389" on the Show Modules page.
    #Step 7 , Guide text is not present.
    And Log out From the Carriers.

  Scenario: Assigning and Unassigning modules to users when logged in as manager.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    #Step 1
    When I entered username "atom.mngrs" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    #Normalize Winter Driving module
    When I clicked on the Show Modules icon on the People page.
    When I clicked on `x people assign` to module "Lift Truck Operator Skills" module which id is "module-389".
    Then I waited for 6 seconds.
    And I clicked on Unselect All.
    Then I waited for 6 seconds.
    And clicked on the save button.
    #Step 2
    And I verified that 0 people assigned to the "Lift Truck Operator Skills" module which id is "module-389" on the Show Modules page.
    #Step 3
    When I clicked on `x people assign` to module "Lift Truck Operator Skills" module which id is "module-389".
    Then I waited for 6 seconds.
    Then I clicked on the user "user-atom.mngrs" on the Assign people tab.
    And clicked on the save button.
    Then I waited for 6 seconds.
    When I clicked on people at the navigation bar.
    #Step 4
    And I clicked the username "atom.mngrs" on the people page to open the user profile.
    Then I waited for 6 seconds.
    And I verified that the modules "Lift Truck Operator Skills" present in the user profile.
    Then I waited for 2 seconds.
    #Then I verified that the status of module "Lift Truck Operator Skills" is "Not started" on the user homepage.
    And I clicked the Cancel button on the user profile window.
    #Step 5
    Then I waited for 2 seconds.
    And I verified that the status of user "atom.mngrs" on the people page is "Not Started".
    #Step 6
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    And I verified that 1 people assigned to the "Lift Truck Operator Skills" module which id is "module-389" on the Show Modules page.
    #Step 7 , Guide text is not present.
    And Log out From the Carriers.
