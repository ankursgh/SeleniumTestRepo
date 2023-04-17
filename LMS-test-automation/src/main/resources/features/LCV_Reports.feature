#Author: Ankur.Shukla

@LMST-928
Feature: LCV report functionality
  I want to verify the report functionality.
 @tag1
 
 Scenario: User activity Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   And I select user activity.
   Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   Then I waited for 4 seconds.
   Then I clicked date box.  
   And I select date range with past week.
   Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   And I select date range with past month.
   #Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past quater.
   #Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past year.
   #Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   Then I select users under report filter.
   Then I waited for 4 seconds.
   Then I selected subcompany bubble and selected subcompany.
   Then I select generate report button.
   Then I waited for 2 seconds.
   Then I return to home page and reset filter.
   Then I selected location.
   Then I select generate report button.
   Then I waited for 2 seconds.
   Then I return to home page and reset filter.
   Then I selected individual user.
   Then I select generate report button.
   Then I waited for 2 seconds.
   Then I return to home page and reset filter.
   Then I selected roles.
   Then I select generate report button.
   Then I waited for 2 seconds.
   Then I return to home page and reset filter.
   And I quit the browser.
   
Scenario: Test Result Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I clicked Test Result.
   Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 2 seconds.
   #Then I clicked details on report.
   Then I return to home page and reset filter.
   Then I selected modules under Report Filters.
   Then I selected Training Plans bubble icon and generated report.
   Then I select generate report button.
   Then I return to home page and reset filter.
   Then I selected individual modules.
   Then I select generate report button.
   And I quit the browser.
   
Scenario: User Transcripts Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I clicked User Transcripts.
   Then I waited for 2 seconds.
   Then I select generate report button and clicked Print Certificate.
   Then I waited for 4 seconds.
   #Then I clicked on Print Wallet card.
   #Then I return to homepage and reset filters.  
   And I quit the browser.
   
Scenario: User Compliance Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I clicked User Compliance.
   Then I select generate report button.
   Then I return to home page and reset filter.
   Then I select generate report button.
   And I quit the browser.
 
 Scenario: Manager Compliance Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I clicked Manager compliance.
   Then I select generate report button.
   Then I return to home page and reset filter.
   Then I select generate report button.
   And I quit the browser.

Scenario: Events Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I clicked Events.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   Then I waited for 4 seconds.
   Then I clicked date box.  
   And I select date range with past week.
   Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   And I select date range with past month.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past quater.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past year.
   Then I select generate report button.
   And I quit the browser.
   
Scenario: Events Registration Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I clicked Event Registration.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   Then I waited for 4 seconds.
   Then I clicked date box.  
   And I select date range with past week.
   Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   And I select date range with past month.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past quater.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past year.
   Then I select generate report button.
   And I quit the browser.

Scenario: Certifications Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I clicked certifications.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   Then I waited for 4 seconds.
   Then I clicked date box.  
   And I select date range with past week.
   Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   And I select date range with past month.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past quater.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past year.
   Then I select generate report button.
   And I quit the browser.
   
Scenario: Transaction History Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   And I clicked Transaction History.
   Then I select generate report button.
   Then I waited for 8 seconds.
   Then I return to home page and reset filter.
   Then I waited for 4 seconds.
   Then I clicked date box.  
   And I select date range with past week.
   Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   And I select date range with past month.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past quater.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past year.
   Then I select generate report button.
   And I quit the browser.

Scenario: Cert Numbers Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I clicked cert numbers.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   Then I waited for 4 seconds.
   Then I clicked date box.  
   And I select date range with past week.
   Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   And I select date range with past month.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past quater.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past year.
   Then I select generate report button.
   And I quit the browser.

Scenario: User File Activity Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I clicked User File Activity.
   Then I waited for 4 seconds.
  Then I clicked date box.  
   And I select date range with past week.
   Then I waited for 2 seconds.
   Then I select generate report button.
   Then I waited for 4 seconds.
   Then I return to home page and reset filter.
   And I select date range with past month.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past quater.
   Then I select generate report button.
   Then I waited for 5 seconds.
   Then I return to home page and reset filter.
   And I select date range with past year.
   Then I select generate report button.
   Then I quit the browser.
   
Scenario: LCV Instructor Workshop Report.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I clicked on more link.
   Then I clicked LCV Instructor Workshop.
   Then I select generate report button.   
   Then I waited for 2 seconds.
   Then I quit the browser.   
   # User activity Report. Below steps commented as report is taking time to load.
	   #Then I selected all checkboxes and genrated report.
	   #Then I select generate report button.
	   #Then I waited for 12 seconds.
	   #Then I return to home page and reset filter.
	   #Then I selected all checkboxes and genrated report.
	   
