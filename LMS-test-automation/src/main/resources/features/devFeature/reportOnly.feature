Feature: check
   Scenario: check 		
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
    And I clicked on Programs in the navigation bar main menu.    
    Then I waited for 1 seconds.
    When I clicked on `x people assigned` to the "Program1" program.
    And I clicked on Unselect All in the program.
    And I selected the Assign Places tab on the program assigned display window.
  	And I clicked on Unselect All in the program.
  	#place 1 assign Program1 program
  	And I clicked on a place have id "place-16904" on the people assign display window.
    And clicked on the save button.           
      And I closed the browser.