#Author: ankur.shukla@rsystems.com

@LMST-952
Feature: Manage certifications feature
 
Scenario: Add Certificate
 Given open the "chrome" browser.
 When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
 Then I saw the login page.
 When I Entered username "automation.admin.lcv" and password "test".
 And clicked Submit button on the login page.
 Then I clicked on more link.
 Then I clicked manage certifications link.
 Then I waited for 2 seconds.
 Then I selected training plan.
 Then I waited for 2 seconds.
 Then I clicked add certification.
 Then I waited for 2 seconds.
 Then I edited the certificate.
 Then I deleted the certificate.
 And I quit the browser.