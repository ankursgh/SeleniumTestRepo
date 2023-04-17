#Author: ankur.shukla
@LMST-978
Feature: Adding modules and deleting modules as customer support and carrier admin role

  Scenario Outline: I want to add modules
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username>" and password "<Password>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    Then I waited for 2 seconds.
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 4 seconds.
    When I clicked on the show Modules icon on the program page.
    Then I waited for 3 seconds.
    And I clicked the add module.
    Then I waited for 2 seconds.
    Then I added the module details.
    And Log out From the Carriers.
    And I quit the browser.
    Then I waited for 4 seconds.
    
   Examples: 
      | Username   | Password |
      | auto.nava  | test     |
  	  | admin.auto | test     |
  		
  Scenario Outline: I want to delete modules
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "<Username>" and password "<Password>".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    Then I waited for 2 seconds.
    And I clicked on Programs in the navigation bar main menu.
    Then I waited for 2 seconds.
    When I clicked on the show Modules icon on the program page.
    Then I waited for 5 seconds.
    Then I search module names start with Test and delete them.
    Then I waited for 2 seconds.
    And Log out From the Carriers.
    And I quit the browser.
    Then I waited for 6 seconds.
    
   Examples: 
      | Username   | Password |
      | auto.nava  | test     |
		  | admin.auto | test     |