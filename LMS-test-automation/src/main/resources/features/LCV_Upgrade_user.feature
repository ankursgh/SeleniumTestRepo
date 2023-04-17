#Author: Ankur.Shukla
#Sample Feature Definition Template
# Pre-Req: LCV_Change_Carrier_Membership script would be executed before this script as it is creating user "Lcv Test" user, which is being used in this script.
@LMST-926
Feature: LCV upgrade user functionality
  I want to upgrade user.
  
Scenario: Activate newly created driver user.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   #And I selected company.
   And I select user.
   Then I waited for 2 seconds.
   And I quit the browser.
 
 Scenario: Upgrade user with Rush delivery option.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "at.aks.contact1.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I selected the user.
   Then I clicked certificate print button.
   Then I waited for 4 seconds.
   Then I filled shipping and payment information.
   Then I waited for 2 seconds.
   Then I clicked changed or upgrade this individual registration status.
   Then I waited for 2 seconds.
   Then I clicked Rush Delivery New LCV Driver.
   Then I waited for 2 seconds.
   And I quit the browser.

   
  Scenario: Upgrade user with LCV contact.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "at.aks.contact1.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I selected the user.
   Then I clicked changed or upgrade this individual registration status.
   Then I waited for 2 seconds.
   Then I clicked LCV contact.
   Then I waited for 2 seconds.
   And I quit the browser.
# LCV test, upgred user and register as instructor event is not appearing, run scenario "Create user from instructor for member." from change carrier mem to generate the issue.
 Scenario: Upgrade user with Instructor Restricted.
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "at.aks.contact1.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I selected the user.
   Then I clicked changed or upgrade this individual registration status.
   Then I waited for 2 seconds.
   Then I clicked Instructor link.
   Then I waited for 2 seconds.
   Then I register instructor. 
   Then I waited for 4 seconds.
   And I quit the browser.
  
  Scenario: Delete member driver user. 
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "automation.admin.lcv" and password "test".
    And clicked Submit button on the login page.
    Then I waited for 2 seconds.
    And I searched second user.
    Then I waited for 4 seconds.
    Then I deleted second user.
    Then I waited for 4 seconds.
    And I quit the browser.

   