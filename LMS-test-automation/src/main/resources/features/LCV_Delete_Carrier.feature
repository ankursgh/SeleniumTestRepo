#Author: Ankur Shukla

# automation.cs.lcv
# automation.admin.lcv
# Remove Location from AKS automation carrier
# Carrier created: AKS_automation
# Location created: Aib_Automation
# Location aic_automation should not assigned to any carrier.

@LMST-924 
  Feature: Delete Carriers
  I want to delete carrier and location
  @tag1
  Scenario: Simple ad carrier and delete carrier after creating new carrier and location
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   And I clicked carriers.
   And I clicked add subcompany.
   When I Entered subcompany details.
   And I clicked All.
   Then I waited for 2 seconds.
   Then I clicked on delete button
   #   Then I waited for 2 seconds.
   Then I clicked on Home.
   And search for subcompany. 
   And I clicked Location.
   And I clicked all on location.
   When I clicked Edit button.     
   Then I saw subcompay field is empty.    
   And I clicked add location.    
   Then I added new location.
   #   Then I waited for 2 seconds.
   And I click All on location.    
   Then I clicked delete location.   
   And I search deleted location. 
   And I quit the browser.
   

   
   
   
   
   
   
   
   
   
    