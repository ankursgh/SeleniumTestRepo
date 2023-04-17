#Author: navaraj@carriersedge.com
#All information for automation using ABC Trucklines ,and processAutomation.
#if email notification settings change in any these 2 carriers, some test cases might fail
# The automation may fail if any of the test user is deleted from the Carrier or the carrier is deleted.
#auto.nava(this is cs account),
#nava.noemailuser  -no email
#nava.emailmanager -carriersedgemutiuserstest@gmail.com ---Processautomation2
#nava.oneemail -carriersedgemutiuserstest@gmail.com---Processautomation2
#nava.twoemail-carriersedgemutiuserstest@gmail.com---Processautomation2
#nava.abc -carriersedgetest@gmail.com   -This email is used by only one user
# The users as.test.user1 and as.test.user21 ->used "processautomationshare@gmail.com" email address in Process Automation Carrier.
@LMST-650 @LMST-455 @passwordRecover
Feature: Self-Served Login / Password Recovery
  
  I want to use this test for testing whether 
  Self-Served Login / Password Recovery is properly working or not.
  in this feature, I am testing different scenarios of password recovery functionality.

  #not Worked when I use email
  @validUserlogin @TEST_LMST-616
  Scenario: Simple Login Scenario
    Login check when the valid user use email address as a username and correct password.
    The email address used by the user is accociated with only one user in the system.

    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Entered username "as.single.user" and password "test".
    And clicked Submit button on the login page.
    Then I logged in successfully.
    And I closed the browser.

  
  @nonExistEmail @userExistButNotHaveEmail
  Scenario: username exist but Email does not exist.
    As a valid user,
    I try to retrieve a password , I do not have any email accociated with my username in the system.

    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #the user 'nava.noemailuser' does not have email address in the system.This is a valid username.
    When I entered my username Or Email as "nava.noemailuser" for password recovery.
    And I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (contact supppot)mockup_six showing message "We've found your account, but there's no email address associated with it, so we can't mail you the login details. However, our Support team will be happy to contact you and resolve the issue.".
    And I closed the browser.

  #From step 14
  @nonExistEmail @userNotExistAndEmailNotExist
  Scenario: Email does not exist in the system.
    As a user,
    I try to retrieve a password using my email, that email address is not the system.

    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    When I entered my username Or Email as `Random Email` for password recovery.
    And I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (contact supppot)mockup_ten showing message "It appears that we're having some trouble finding an account for".
    And I closed the browser.

  #From step 15
  @EmailHasMultipleValidUser @multipleEmailValidUser
  Scenario: Recovery password by a user who uses a shared email address.
    As a valid user I try to recover my password ,
    I used a shared email address. Other valid users also uses the same email address in the system. 
    (Multiple users with the same email but different carriers, all the carriers have settings: `Everyone can change password` is ON.)

    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
    #step 16
    When I filled in the user details  Username as "nava.oneemail",First Name as "Nava",Last Name as "oneemail".
    And I clicked Submit Button on User Details page.
    #automated to the message seen text
    Then I saw a message `An email with verification code has been sent`.
    And I checked an email in carriersedgemutiuserstest@gmail.com for six digit verification code and I found it.
    And I enter the code from carriersedgemutiuserstest@gmail.com to the verification page.
    And I submitted the verification code.
    When I entered new password and confirm new password in the password recovery page
    When I Clicked change button in the password recovery page.
    Then I saw message display about password successfully changed.
    And I clicked ok button in the password successfully change message.
    And I closed the browser.

  @sameNameButDifferentEmail
  Scenario: Recovery password by a user who uses a shared email address and someone else name matched  in the carrier.
    As a valid user I try to recover my password ,
    I used a shared email address. Other valid users also use the same email address in the system. My name also matched with another person in my carriers, but he has a different email address in the system.
    (Multiple users with the same email but different carriers, all the carriers have settings: `Everyone can change password` is ON.)
    (There are two users having same name "Nava twoemail", but both have different email address in the system.)

    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I waited for 4 seconds.
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
    #step 16
    When I filled in the user details  Username as "",First Name as "Nava",Last Name as "twoemail".
    And I clicked Submit Button on User Details page.
    #automated to the message seen text
    Then I saw a message `An email with verification code has been sent`.
    And I checked an email in carriersedgemutiuserstest@gmail.com for six digit verification code and I found it.
    And I enter the code from carriersedgemutiuserstest@gmail.com to the verification page.
    And I submitted the verification code.
    When I entered new password and confirm new password in the password recovery page
    When I Clicked change button in the password recovery page.
    Then I saw message display about password successfully changed.
    And I clicked ok button in the password successfully change message.
    And I closed the browser.

  #From step 17/20
  Scenario: Invalid user uses existing email addresss in the system.
    As a invalid user I	Try to get password recovery I used valid email address (Email address is in the system.)
    as same as others valid. Filled out the support form and sent to support.

    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I waited for 4 seconds.
    Then I negivated to the password recover page.
    #the email "carriersedgemutiuserstest@gmail.com" used by multiple users. This email address is in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
    # filled out the form using random username, Firstname and Lastname
    # filled out the form using random name and the system automatically generate random names
    When I filled in the user details  Username as "Random",First Name as "Random",Last Name as "Random".
    And I clicked Submit Button on User Details page.
    #automated to the message seen text and heading of the page is also verified
    Then I saw the system was redirected to Mock_12 (user details) and showed the message "It appears that we're having some trouble finding an account for".
    When I clicked Contact Us button on the User Details window.
    Then I negivated to the Your Contact Information page.
    #####Changes
    When I filled in the contact support page; company name as "random",full name as "random",Email as "crrieredge@gmail.com",phone as "6744744744".
    And I clicked the send button on the Your Contact Information page (contact support page).
    Then I varified that a message "The request has been successfully sent to the Support team" was displayed.
    And I closed the browser.

  
  # Created two users with same name and email id Nava twoemail and email samenameemail@cmail.com for fixing this scenario
  @SameEmailAndSameName
  Scenario: Recovery password by a user who uses a shared email address and name matched someone in the carrier.
    As a valid user I try to recover my password,Just want to see whether the system send verification code or not.
    I used a shared email address. Other valid users whose name is the same as mine also use the same email address in the system.
    (Multiple users with the same email but different carriers, all the carriers have settings: `Everyone can change password` is ON.)
    (There are two users having same name "Nava twoemail", but both have same email address in the system.)

    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I waited for 4 seconds.
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "samenameemail@cmail.com" for password recovery.
    And I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
    #step 16
    #When I filled in the user details  Username as "",First Name as "Nava",Last Name as "twoemail".
    #And I clicked Submit Button on User Details page.
    #Then I waited for 2 seconds.
    #again seen user detail for more information ....
    When I filled in the user details  Username as "nava.twoemail55",First Name as "Nava",Last Name as "twoemail".
    And I clicked Submit Button on User Details page.
    #And I clicked Try Again Button on the User Details page.
    #automated to the message seen text
    Then I saw a message `An email with verification code has been sent`.
    And I closed the browser.

  # Two carriers ABC Trucklines ,and processAutomation and processAutomation settings change password is off.
  @EmailAccociatedMultipleValidUsersOneCarrierSettingsOff @case1
  Scenario: Recovery password by a user who uses a shared email address.
    As a valid user I try to recover my password ,
    I used a shared email address. Other valid users also uses the same email address in the system, and the other carrier Password setting is Off. 
    (Multiple users with the same email but different carriers, one or more carriers have settings: `Everyone can change password` is OFF.)
    (Email associates with users of two carriers ABC Trucklines ,and processAutomation, and processAutomation settings change password is off. and the user is in ABC Trucklines and its setting is ON.)

    #This scenario Requires nava.oneemail.abctl1 user in ABCTrucline Carrier
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "as.automation.cs" and password "test" as a customer support.
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    Then I waited for 4 seconds.
    And I uncheck Everyone change their password check Box in Settings.
    Then I waited for 6 seconds.
    And I Saved the Settings.
    And Log out From the Carriers.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I waited for 4 seconds.
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And I clicked Submit button on the password recover page.
    Then I saw No permission password reset message "This email account is tied to multiple accounts. Some of these accounts have company settings which prevent password changes, so password reset may not be available".
    When I clicked ok butoon in verification page.
    When I filled in the user details  Username as "nava.oneemail.abctl1",First Name as "Nava",Last Name as "oneemail".
    And I clicked Submit Button on User Details page.
    Then I waited for 1 seconds.
    Then I saw a message `An email with verification code has been sent`.
    When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    When I entered username "as.automation.cs" and password "test" as a customer support.
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I checked Everyone change their password check Box in Settings.
    Then I Saved the Settings.
    And I closed the browser.

  # Two carriers ABC Trucklines ,and processAutomation and processAutomation settings change password is off.
  @EmailAccociatedMultipleValidUsersBothSettingsON @case2
  Scenario: Recovery password by a user who uses a shared email address.
    As a valid user I try to recover my password ,
    I used a shared email address. Other valid users also uses the same email address in the system, and All settings change password are ON. 
    (Multiple users with the same email but different carriers, All carriers have settings: `Everyone can change password` is ON.)
    (Email associates with users of two carriers ABC Trucklines ,and processAutomation, Both settings change password are NO. and the user is in ProcessAutomation carriers.)

    # Test.user31 is created for fixing this issue
    #For carrier setting ABC Trucklines to ON
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "auto.nava" and password "test" as a customer support.
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I checked Everyone change their password check Box in Settings.
    Then I Saved the Settings.
    And Log out From the Carriers.
    ##For carrier setting ProcessAutomation to ON
    Then I saw the login page.
    When I entered username "as.automation.cs" and password "test" as a customer support.
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I checked Everyone change their password check Box in Settings.
    And I Saved the Settings.
    And Log out From the Carriers.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I waited for 4 seconds.
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
    When I filled in the user details  Username as "test.user31",First Name as "Test",Last Name as "user3".
    And I clicked Submit Button on User Details page.
    #automated to the message seen text
    Then I waited for 1 seconds.
    Then I saw a message `An email with verification code has been sent`.
    And I closed the browser.

  #Two carriers ABC Trucklines ,and processAutomation and Both Password settings off.
  @MgrSharedEmailAndAllCarriersSettingsOFF @case3b
  Scenario: Recovery password by a user who uses a shared email address.
    As a valid user and my role is manager, I try to recover my password ,
    I used a shared email address. Other valid users also uses the same email address in the system, and All settings change password are OFF. 
    (Multiple users with the same email but different carriers, All carriers have settings: `Everyone can change password` is OFF.)
    (Email associates with users of two carriers ABC Trucklines ,and processAutomation, Both settings change password are OFF. and the manager is in ProcessAutomation carriers.)

    # User Username as "auto.mgr1",First Name as "Auto",Last Name as "Mgr" created with role manager in Process automation carrier
    #For carrier setting ABC Trucklines to OFF
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "auto.nava" and password "test" as a customer support.
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I uncheck Everyone change their password check Box in Settings.
    Then I Saved the Settings.
    And Log out From the Carriers.
    ##For carrier setting ProcessAutomation to OFF
    Then I saw the login page.
    When I entered username "as.automation.cs" and password "test" as a customer support.
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I uncheck Everyone change their password check Box in Settings.
    And I Saved the Settings.
    And Log out From the Carriers.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I waited for 4 seconds.
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And I clicked Submit button on the password recover page.
    Then I saw No permission password reset message "This email account is tied to multiple accounts. Some of these accounts have company settings which prevent password changes, so password reset may not be availabl".
    When I clicked ok butoon in verification page.
    When I filled in the user details  Username as "auto.mgr1",First Name as "Auto",Last Name as "Mgr".
    And I clicked Submit Button on User Details page.
    #automated to the message seen text
    Then I waited for 1 seconds.
    Then I saw a message `An email with verification code has been sent`.
    And I checked an email in carriersedgemutiuserstest@gmail.com for six digit verification code and I found it.
    And I enter the code from carriersedgemutiuserstest@gmail.com to the verification page.
    And I submitted the verification code.
    When I entered new password and confirm new password in the password recovery page
    When I Clicked change button in the password recovery page.
    Then I saw message display about password successfully changed.
    And I clicked ok button in the password successfully change message.
    # When I clicked ok butoon in verification page.
    When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    #For carrier setting ABC Trucklines to ON
    Then I saw the login page.
    When I entered username "auto.nava" and password "test" as a customer support.
    And clicked Submit button on the login page.
    #check for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I checked Everyone change their password check Box in Settings.
    Then I Saved the Settings.
    And Log out From the Carriers.
    ##For carrier setting ProcessAutomation to ON
    Then I saw the login page.
    When I entered username "as.automation.cs" and password "test" as a customer support.
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I checked Everyone change their password check Box in Settings.
    And I Saved the Settings.
    And Log out From the Carriers.
    And I closed the browser.

  #******
  @EmailAssociatedManyUsersInACarrierAndSettingOFF @case5
  Scenario: Recovery password by a user who uses a shared email address in a carrier.
    As a valid user I try to recover my password ,
    I used a shared email address. Other valid users also uses the same email address in the same carriers (not other carriers), my carriers Password setting is Off. 
    (Multiple users with the same email and same carrier, the carrier has settings: `Everyone can change password` is OFF)
    (Email associates with users of processAutomation, and processAutomation settings change password is off.)

    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "as.automation.cs" and password "test" as a customer support.
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I uncheck Everyone change their password check Box in Settings.
    And I Saved the Settings.
    And Log out From the Carriers.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I waited for 4 seconds.
    Then I negivated to the password recover page.
    #the email address "processautomationshare@gmail.com" is used by multiple users in the carriers only.
    When I entered my username Or Email as "processautomationshare@gmail.com" for password recovery.
    And I clicked Submit button on the password recover page.
    Then I saw No permission password reset message "This email account is tied to multiple accounts. Some of these accounts have company settings which prevent password changes, so password reset may not be availabl".
    When I clicked ok butoon in verification page.
    When I filled in the user details  Username as "as.test.user1",First Name as "Test",Last Name as "user".
    And I clicked Submit Button on User Details page.
    Then I waited for 1 seconds.
    Then I saw not permission to reset password message "You don't have permission to reset the password. Please contact your manager" on the password recover page.
    # When I clicked ok butoon in verification page.
    #The above ok button also navigated to the login page
    When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    When I entered username "as.automation.cs" and password "test" as a customer support.
    And clicked Submit button on the login page.
    #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I checked Everyone change their password check Box in Settings.
    Then I Saved the Settings.
    And I closed the browser.
  
  @MockupError
  Scenario: Verification of Error in login and password recovery page.
    Given open the "chrome" browser.
    When I opened the Rivers login page "https://test.carriersedge.com/ce_test/login.jsp".
    Then I saw the login page.
    When clicked Submit button on the login page.
    Then I saw a propUp message-"Please enter your username" in login page.
    And I clicked Ok button on prop up.
    And I entered "random" in username field on login page
    When clicked Submit button on the login page.
    Then I saw a propUp message-"Please enter your password" in login page.
    And I clicked Ok button on prop up.
    When I Clicked Get help here link on the login page.
    Then I waited for 8 seconds.
    Then I negivated to the password recover page.
    When I clicked Submit button without entering the Username or Email on the password recover form.
    Then I saw a prop up message-"Please enter your username or email".
    And I clicked Ok button on prop up.
    When I enter non existing username or email "random" in password Recovery page.
    And I clicked Submit button on the password recover page.
    Then I negivated to the Your Contact Information page.
    When Clicked on Send button on the `Your Contact Information page`.
    Then I saw a prop up message "Please enter your company name" in Your Contact Information page.
    And I clicked Ok button on prop up.
    When I enter company name "abc company" on the `Your Contact Information page`.
    And Clicked on Send button on the `Your Contact Information page`.
    Then I saw a prop up message "Please enter your full name" in Your Contact Information page.
    And I clicked Ok button on prop up.
    When I also entered full name "full Name" on the `Your Contact Information page`.
    And Clicked on Send button on the `Your Contact Information page`.
    Then I saw a prop up message "Please enter a valid email address" in Your Contact Information page.
    And I clicked Ok button on prop up.
    When I entered email address  "abc" on the `Your Contact Information page`.
    And Clicked on Send button on the `Your Contact Information page`.
    Then I saw a prop up message "Please enter a valid email address" in Your Contact Information page.
    And I clicked Ok button on prop up.
    When I entered email address  "abc@cdf.com" on the `Your Contact Information page`.
    And Clicked on Send button on the `Your Contact Information page`.
    Then I saw a prop up message "Please enter your contact phone number" in Your Contact Information page.
    And I clicked Ok button on prop up.
    And I closed the browser.
 
  # till 11
  #From Step 12
  @ErrorInUserDetails @EmailEnteredHasMultipleAccountError @Error11Mockup @Error12Mockup @MockupError
  Scenario: Verification of Error in user Detail page.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I waited for 8 seconds.
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    #When I entered my username Or Email as "multiemail@carriersedge.com" for password recovery.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
    #without filled out anythig in the user details form
    When I clicked Submit Button on User Details page.
    Then I saw a prop up message-"Please fill out at least one field: Username, First Name, or Last Name".
    And I clicked Ok button on prop up.
    And I quit the browser.
