#Author: ankur.shukla
#Anks user

@LMST940
Feature: Add Carrier and Primary Contact
  I want to use this template for my feature file

  Scenario: Create carrier and priamry contact for member.
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  Then I clicked on more link.
  Then I clicked LCV Contact link.
  Then I waited for 2 seconds.
  Then I entered carrier name.
  Then I entered cvor.
  Then I entered OTA acct.
  Then I entered phone.
  Then I entered Fax.
  Then I enterd website.
  Then I entered company code.
  Then I entered address1. 
  Then I entered address2
  Then I entered city.
  Then I selected provience.
  Then I entered postal.
  Then i choose registration form.
  Then I waited for 2 seconds.
  Then I entered firstname.
  Then I enterd lastname.
  Then I entered the title.
  Then I entered the email address.
  Then I waited for 2 seconds.
  Then I entered phonenumber.
  Then I entered the fax.
  Then I enterd driver license.
  Then I clicked submit.
  Then I waited for 6 seconds.
  And I quit the browser.
  
  Scenario: Delete carrier and primary contact. 
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  #Then I clicked on more link.
  Then I selected newly created user and deleted. 
  Then I waited for 2 seconds.
  And I quit the browser.
  
  Scenario: Delete carrier and location Aautomation. 
  Given open the "chrome" browser.
  When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
  Then I saw the login page.
  When I Entered username "automation.admin.lcv" and password "test".
  And clicked Submit button on the login page.
  Then I waited for 2 seconds.
  And I clicked carriers.
  Then I clicked All and verifed carrier.
  Then I waited for 2 seconds.
  Then I clicked on delete button
  Then I waited for 2 seconds.
  Then I clicked on Home.
  And I clicked Location.
  Then I clicked all and verfied location.
  Then I clicked delete location.
  And I quit the browser.
  