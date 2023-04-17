#Author: Ankur Shukla


@LMST-930
Feature: License validation
  I want verify license validity
#Valid license: 441234300622, Instructor, Automax three
#Invalid license: 3454906356, AKS SC, AKS_SC
#Outside Search Report
  @tag1
  Scenario: Check for invalid license
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/ui/lcvForm/validator.jsp" page.
   Then I entered angency name "AKS_SC".
   Then I entered badge number "56756".
   Then I entered name "SC".
   And I entered certificate number "3454906356".
   And I clicked on search button.
   Then I waited for 4 seconds.
   Then I verified invalid licence.
   And I quit the browser.
   
Scenario: Check for valid license
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/ui/lcvForm/validator.jsp" page.
   Then I entered angency name "sd".
   Then I entered badge number "sd".
   Then I entered name "sd".
   And I entered certificate number "440454503622".
   And I clicked on search button.
   Then I waited for 4 seconds.
  # Then I verified valid licence.
   And I quit the browser.
    
Scenario: Report verification 
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I clicked on outside search link.
   Then I clicked boxdate.
   Then I waited for 2 seconds.
   Then I clicked pastweek.
   Then I waited for 2 seconds.
   Then I clicked on report.
   Then I clicked reset filter.
   Then I waited for 2 seconds.
   And I clicked select all dates.
   Then I clicked on report.
     
   
   
   
   
    
   
