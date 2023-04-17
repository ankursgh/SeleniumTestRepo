#Author: ankur.shukla
@LMST-981
Feature: Assigning Practical Activities as customer support and carrier admin role

  Scenario Outline: Assigning Practical Activities
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username>" and password "<Password>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    Then I waited for 15 seconds.
    When I clicked on `x people assigned` to module "Automation Testing Practical" module which id is "module-9508".
    Then I waited for 6 seconds.
    And I clicked on Unselect All.
    Then I waited for 6 seconds.
    Then I clicked on the Add To Program tab in the selected module.
    And I clicked on Unselect All.
    And clicked on the save button.
    Then I waited for 6 seconds.
    And I verified that 0 people assigned to the "Automation Testing Practical" module which id is "module-9508" on the Show Modules page.
    When I hovered Over on the `x people assigned` of the module "Automation Testing Practical" module which id is "module-9508".
    When I clicked on `x people assigned` to module "Automation Testing Practical" module which id is "module-9508".
    Then I waited for 6 seconds.
    Then I clicked on the user "user-random.108" on the Assign people tab.
    And I clicked on the reset checkbox.
    And clicked on the save button.
    Then I waited for 6 seconds.
    When I clicked on people at the navigation bar.
    Then I waited for 6 seconds.
    And I clicked the username "random.108" on the people page to open the user profile.
    Then I waited for 6 seconds.
    And I verified that the modules "Automation Testing Practical" present in the user profile.
    And I clicked the Cancel button on the user profile window.
    And I verified that the status of user "random.108" on the people page is "Not Started".
    And I clicked on Programs in the navigation bar main menu.
    When I clicked on the Show Modules icon on the People page.
    And I verified that 1 people assigned to the "Automation Testing Practical" module which id is "module-9508" on the Show Modules page.
    And Log out From the Carriers.
    When I entered username "random.108" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I verified that the modules "Automation Testing Practical" present under the "Individually Assigned Modules" on the user home page.
    And Log out From the Carriers.
    Then I waited for 2 seconds.
    When I entered username "<Username>" and password "<Password>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 2 seconds.
    And I clicked on practical activity.
    Then I waited for 2 seconds.
    And I added practical activity details.
    Then I waited for 2 seconds.
    And I quit the browser.
    Then I waited for 4 seconds.

    Examples: 
      | Username | Password |
      | auto4.cs | test     |
