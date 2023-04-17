#Author: Ankur Shukla
 @LMST-931  
Feature: User Management 
I want to manage differnt LCV users
Scenario: User Management
  Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   #AKS_SC
   And I clicked search user by company.
   And I selected company.
   Then I selected user.
   Then I verified cretificate print button.
   And I clicked user profile.
   And verified all details unique.
   Then I clicked view button on supporting document.
   Then I clicked exit button.
   And I clicked location box.
   Then I waited for 2 seconds.
   And I clicke close botton on location.
   #CanFreight Lines, Bob Johnston
   Then I search instructor.
   And I verified insturctor cretificate print button.
   Then I clicked on instructor profile.
   #And I selected different time period from the Experience Date dropdown.
   Then I waited for 2 seconds.
   Then I closed instructor profile.
   And I clicked select user by role.
   Then I waited for 4 seconds.
   #lck user
   #gjhghjg
   And I selected user and mouse hover them.
   #hjhjh
   And I selected Lock this individual in the program.
   Then I waited for 4 seconds.
   Then I verified user account is locked.
   Then I serched locked user.
   And I unlocked the user. 
   Then I waited for 2 seconds.
   Then I clicked logout button.
   When I Entered username "at.aks.contact1.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 4 seconds.
   Then I closed popup.
   Then I waited for 4 seconds.
   # And I clicked Ok button on pop up.  
   And I assigned modules to user.
   Then I waited for 2 seconds.
   And I quit the browser.
   
   Scenario: Delete and undelete user
   Given open the "chrome" browser.
   When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
   Then I saw the login page.
   When I Entered username "er.aks.driver.lcv" and password "dlxkq8l1".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   Then I closed popup.
   Then I verified module is assigned to user.
   Then I waited for 2 seconds.
   Then I clicked logout button.
   Then I waited for 2 seconds.
   When I Entered username "automation.admin.lcv" and password "test".
   And clicked Submit button on the login page.
   Then I waited for 2 seconds.
   And I clicked search user by company.
   And I selected company.
   And I delete user.
   Then I waited for 2 seconds.
   And I undeleted user.
   And I quit the browser.
  