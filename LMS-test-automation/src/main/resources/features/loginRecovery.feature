#Author: navaraj@carriersedge.com

#All information for automation using ProcessAutomation2 ,and processAutomation. 
#if email notification settings change in any these 2 carriers, some test cases might fail
# The automation may fail if any of the test user is deleted from the Carrier or the carrier is deleted.
#auto.nava(this is cs account),
#nava.noemailuser  -no email
#nava.emailmanager -carriersedgemutiuserstest@gmail.com
#nava.oneemail -carriersedgemutiuserstest@gmail.com
#nava.twoemail-carriersedgemutiuserstest@gmail.com
#nava.abc -carriersedgetest@gmail.com   -This email is used by only one user
# The users as.test.user and as.test.user2 ->used "processautomationshare@gmail.com" email address in Process Automation Carrier.

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
    
   
    # from step 10
     @nonExistUser
    Scenario:  Password Recovery, that username does not exit
    As a non-existing user,
    I try to retrieve a password using the random name and other information.
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 	 	Then I negivated to the Your Contact Information page.
 	 	# I we choose write "random" in the below options, it will take random company name, full name and Email randomly.
 	 	When I filled in the contact support page; company name as "company name",full name as "fulk2k name",Email as "mymawi1l@poss.com",phone as "6744744744".
 	 	And clicked cancel on the contact support page.
 	 	#page is redirect to login page.
 	 	Then I verified that the contact support page was not submitted.
 	 	When I Clicked Get help here link on the login page.
 	 	 #I have to developed random name on each run otherwire after running 3 times, the code will fail.
 	 	When I entered my username Or Email as `Random Name` for password recovery.
 	 	And  I clicked Submit button on the password recover page.
 	 	# I we wrote "random" in the below options, it will take random company name, full name and Email randomly.
 	 	When I filled in the contact support page; company name as "random",full name as "random",Email as "random",phone as "6744744744".
 	 	And I clicked the send button on the Your Contact Information page (contact support page).
 	 	#step 12,
 	 	Then I varified that a message "The request has been successfully sent to the Support team" was displayed. 
 	 	And I closed the browser.
 	 	
 	 	#From step 13
 	 	@nonExistEmail @userExistButNotHaveEmail
 	 	Scenario:  username exist but Email does not exist.
 	 	 As a valid user,
    I try to retrieve a password , I don't have any email accociated with my username in the system.
    
 	 	Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #the user 'nava.noemailuser' does not have email address in the system.This is a valid username.
    When I entered my username Or Email as "nava.noemailuser" for password recovery.
    And  I clicked Submit button on the password recover page.
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
    And  I clicked Submit button on the password recover page.
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
    And  I clicked Submit button on the password recover page.
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
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
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
    Then I negivated to the password recover page.
    #the email "carriersedgemutiuserstest@gmail.com" used by multiple users. This email address is in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
   	# filled out the form using random username, Firstname and Lastname
  	# filled out the form using random name and the system automatically generate random names
  	When I filled in the user details  Username as "Random",First Name as "Random",Last Name as "Random".
  	And I clicked Submit Button on User Details page.
  	#automated to the message seen text and heading of the page is also verified
   	Then I saw the system was redirected to Mock_12 (user details) and showed the message "It appears that we're having some trouble finding an account for".
   	When I clicked Contact Us button on the User Details window.
  	Then I negivated to the Your Contact Information page.
  	When I filled in the contact support page; company name as "random",full name as "random",Email as "random",phone as "6744744744".
 	 	And I clicked the send button on the Your Contact Information page (contact support page).
 	 	Then I varified that a message "The request has been successfully sent to the Support team" was displayed. 
 	 	And I closed the browser.
  	
  	#From step 18
 	 	@EmailHasMultipleUsersAndUserNotIdentifiedAndRun4Times
  	Scenario: Invalid user Use more than 3 times to recover password. 
  	As a invalid user, I Try to get password recovery,
  	I uses the same email address as other valid user(Email address is in the system.),
  	 and I will try more than 3 times
  
		Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #the email "carriersedgemutiuserstest@gmail.com" used by multiple users. This email address is in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
   	# filled out the form using random username, Firstname and Lastname
  	# filled out the form using random name and the system automatically generate random names
  	When I filled in the user details  Username as "Random",First Name as "Random",Last Name as "Random".
  	And I clicked Submit Button on User Details page.
  	#automated to the message seen text and heading of the page is also verified
   	Then I saw the system was redirected to Mock_12 (user details) and showed the message "It appears that we're having some trouble finding an account for".
  	When I filled in again the user details with same above data Username as "Random",First Name as "Random",Last Name as "Random".2 times.
  	And I clicked Try Again Button on the User Details page.
  	Then I saw the system was redirected to Mock_12 (user details) and showed the message "It appears that we're having some trouble finding an account for".
  	And I filled in again the user details with same above data Username as "Random",First Name as "Random",Last Name as "Random".3 times.
  	And I clicked Try Again Button on the User Details page.
  	Then I saw a message "You have exceeded the number of allowed attempts." as MockUp_14.
   	And I closed the browser.
   
   		#From steps 4-8 and 9(step came before 8)
   		#From step 22,23
   		@oldValidRecoveryCodeBecomeInvalid   @SuccessfullyResetPasswordUsingEmail  @Case6b
		Scenario: Invalid Verification Code and Valid verification code and Successfully Reset Password Using Email address.
 		As a valid user, I use my email address (email address associated with only one user and my careers setting password is ON) to recover the password and get the verification code in my email. I am also checking for invalidation of the old verification code when a new code is generated.  
    Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #The email address is valid email and automated setup to get email snippet form the email address.
    When I entered my username Or Email as "carriersedgetest@gmail.com" for password recovery.
    Then I clicked Submit button on the password recover page.
    #The verification code is temperary saved for future use
    And I checked an email in carriersedgetest@gmail.com for six digit verification code and I found it.
    And I verified code email content look like mockup_8.
    #step 9
    When I Clicked Resend on verification page.
    #automated to the message seen text
    Then I saw a message `A new code has been generated and sent to the user email`.
    When I clicked ok butoon in verification page.
    
    And I entered the previous generated code to the verification page for the password recovery.
    And I submitted the verification code.
    Then I saw a prop up message-"Please enter a valid verification code".
    
    And I clicked Ok button on prop up.
    #New latest code is used from the email
    And I enter the new code from email to the verification page.
    And I submitted the verification code.
    # step 8,
    Then The system redirected to Reset Password page mockup_15.
    #step 22
    And I verified the user is "nava.abc".
    #since user name accociated with the email "carriersedgetest@gmail.com" is "nava.abc".
   
    #step 23
    When I entered new password and confirm new password in the password recovery page
    Then I verified that both password right icon were present.
    When I Clicked change button in the password recovery page.
    # step 25, for step 24  ?? How to check step, need information to developed......
    Then I Got an email having subject: Password reset confirmation and the Body content "Your password to the CarriersEdge account has been successfully changed! If you did not reset your password, please contact our Support team at 866-530-2430 or support@carriersedge.com".
    #step 26
    Then I saw message display about password successfully changed.
    And I clicked ok button in the password successfully change message.
    And I closed the browser.
    
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
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "samenameemail@cmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
  	#step 16
  	When I filled in the user details  Username as "",First Name as "Nameemail",Last Name as "same".
  	And I clicked Submit Button on User Details page.
  	Then I waited for 2 seconds.
  	#again seen user detail for more information ....
  	When I filled in the user details  Username as "nameemail.same",First Name as "Nameemail",Last Name as "same".
  	And I clicked Try Again Button on the User Details page.
  	#automated to the message seen text
    Then I saw a message `An email with verification code has been sent`.
    
    And I closed the browser.
    
		@oldValidRecoveryCodeBecomeInvalid   @SuccessfullyResetPasswordUsingMixedCaseEmail @displayMaskedEmail
		Scenario: Invalid and Valid verification code and Reset Password Using Mixed case Email address. The recovery email is masked formed.
 		As a valid user, I use my email address (email address associated with only one user) to recover the password and get the verification code in my email. I am also checking for invalidation of the old verification code when a new code is generated.  
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
    #After changing careers Everyone can change password is ON
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #The email address is valid email and automated setup to get email snippet form the email address.
    When I entered my username Or Email as "CarriersEdgeTest@gmaiL.com" for password recovery.
    Then I clicked Submit button on the password recover page.
    Then I saw a message `An email with verification code has been sent` and emails displayed on the forms are masked as "C**************t@g***L.com".
    #The verification code is temperary saved for future use
    And I checked an email in carriersedgetest@gmail.com for six digit verification code and I found it.
    And I verified code email content look like mockup_8.
    #step 9
    When I Clicked Resend on verification page.
    #automated to the message seen text
    Then I saw a message `A new code has been generated and sent to the user email`.
    When I clicked ok butoon in verification page.
    
    And I entered the previous generated code to the verification page for the password recovery.
    And I submitted the verification code.
    Then I saw a prop up message-"Please enter a valid verification code".
    
    And I clicked Ok button on prop up.
    #New latest code is used from the email
    And I enter the new code from email to the verification page.
    And I submitted the verification code.
    # step 8,
    Then The system redirected to Reset Password page mockup_15.
    #step 22
    And I verified the user is "nava.abc".
    #since user name accociated with the email "carriersedgetest@gmail.com" is "nava.abc".
   
    #step 23
    When I entered new password and confirm new password in the password recovery page
    Then I verified that both password right icon were present.
    When I Clicked change button in the password recovery page.
    # step 25, for step 24  ?? How to check step, need information to developed......
    Then I Got an email having subject: Password reset confirmation and the Body content "Your password to the CarriersEdge account has been successfully changed! If you did not reset your password, please contact our Support team at 866-530-2430 or support@carriersedge.com".
    #step 26
    Then I saw message display about password successfully changed.
    And I clicked ok button in the password successfully change message.
    And I closed the browser.

    #the above case use email and the case use username
    @SuccessfullyResetPasswordUsingUsername @Case8
  	Scenario: Successful password Recovery.
  	As a valid user, I am trying to reset my password. my email address is also in the system,
  	and the email address accociated with me only, and my user name is only used by me.(not sharing email address)
  	
  	  	
  	Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #The email address is valid email and automated setup to get email snippet form the email address.
    When I entered my username Or Email as "nava.abc" for password recovery.
    Then I clicked Submit button on the password recover page.
    Then I saw a message `An email with verification code has been sent` and emails displayed on the forms are masked as "c**************t@g***l.com".
    And I checked an email in carriersedgetest@gmail.com for six digit verification code and I found it.
    And I verified code email content look like mockup_8.
    #step 9
    When I Clicked Resend on verification page.
    #automated to the message seen text
    Then I saw a message `A new code has been generated and sent to the user email`.
    When I clicked ok butoon in verification page.
    And I enter the code from email to the verification page.
    And I submitted the verification code.
    # step 8,
    Then The system redirected to Reset Password page mockup_15.
    #step 22
    And I verified the user is "nava.abc".
    #since user name accociated with the email "carriersedgetest@gmail.com" is "nava.abc".
   
    #step 23
    When I entered new password and confirm new password in the password recovery page
    Then I verified that both password right icon were present.
    When I Clicked change button in the password recovery page.
    # step 25, for step 24  ?? How to check step, need information to developed......
    Then I Got an email having subject: Password reset confirmation and the Body content "Your password to the CarriersEdge account has been successfully changed! If you did not reset your password, please contact our Support team at 866-530-2430 or support@carriersedge.com".
    #step 26
    Then I saw message display about password successfully changed.
    And I clicked ok button in the password successfully change message.
    And I closed the browser.
    
    #the below case use email and username seperately.
    @CarrierSettingsNotAllowedRecoverPassword  @case7
    
  	Scenario: A password could not be recovered by the user Due to Carrier Setting.
  	As a valid user, I am trying to reset my password. my email address is also in the system,
  	and the email address associated with my user name is used by me only (not sharing email address). I am using my email and also username to recover the password.
  	(1.The user enters existing email associated only with one user account but "Everyone can change password" is OFF in carrier's settings.
  	 2.The user enters existing username but "Everyone can change password" is OFF in carrier's settings).
  	
   	Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "auto.nava" and password "test" as a customer support.
    And clicked Submit button on the login page.
     #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I uncheck Everyone change their password check Box in Settings.
    And I Saved the Settings.
    And Log out From the Carriers.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #The email address is valid email and automated setup to get email snippet form the email address.
    When I entered my username Or Email as "carriersedgetest@gmail.com" for password recovery.
    Then I clicked Submit button on the password recover page.
    Then I saw not permission to reset password message "You don't have permission to reset the password. Please contact your manager" on the password recover page.
    When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
     Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #The email address is valid email and automated setup to get email snippet form the email address.
    When I entered my username Or Email as "nava.abc" for password recovery.
    Then I clicked Submit button on the password recover page.
    Then I saw not permission to reset password message "You don't have permission to reset the password. Please contact your manager" on the password recover page.
    When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    When I entered username "auto.nava" and password "test" as a customer support.
    And clicked Submit button on the login page.
     #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I checked Everyone change their password check Box in Settings.
    Then I Saved the Settings.
    And I closed the browser. 
    #since user name accociated with the email "carriersedgetest@gmail.com" is "nava.abc".
 
     
    #Two carriers ProcessAutomation2 ,and processAutomation and processAutomation settings change password is off.
		@EmailAccociatedMultipleValidUsersOneCarrierSettingsOff @case1
		
   	Scenario: Recovery password by a user who uses a shared email address.
   	As a valid user I try to recover my password ,
    I used a shared email address. Other valid users also uses the same email address in the system, and the other carrier Password setting is Off. 
    (Multiple users with the same email but different carriers, one or more carriers have settings: `Everyone can change password` is OFF.)
    (Email associates with users of two carriers ProcessAutomation2 ,and processAutomation, and processAutomation settings change password is off. and the user is in ProcessAutomation2 and its setting is ON.)
   
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
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
    Then I saw No permission password reset message "This email account is tied to multiple accounts. Some of these accounts have company settings which prevent password changes, so password reset may not be availabl".
    When I clicked ok butoon in verification page.
   	When I filled in the user details  Username as "nava.oneemail",First Name as "Nava",Last Name as "oneemail".
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
    
    # Two carriers ProcessAutomation2 ,and processAutomation and processAutomation settings change password is off.
    @EmailAccociatedMultipleValidUsersBothSettingsON @case2
		
   	Scenario: Recovery password by a user who uses a shared email address.
   	As a valid user I try to recover my password ,
    I used a shared email address. Other valid users also uses the same email address in the system, and All settings change password are ON. 
    (Multiple users with the same email but different carriers, All carriers have settings: `Everyone can change password` is ON.)
    (Email associates with users of two carriers ProcessAutomation2 ,and processAutomation, Both settings change password are NO. and the user is in ProcessAutomation carriers.)
    
    #For carrier setting ProcessAutomation2 to ON
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
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
  	When I filled in the user details  Username as "as.test.user3",First Name as "Test",Last Name as "user3".
  	And I clicked Submit Button on User Details page.
  	#automated to the message seen text
  	Then I waited for 1 seconds.
    Then I saw a message `An email with verification code has been sent`.
    And I closed the browser.
    # Two carriers ProcessAutomation2 ,and processAutomation and Both Password settings off.
    @EmailAccociatedMultipleValidUsersBothSettingsOFF @case3
		
   	Scenario: Recovery password by a user who uses a shared email address.
   	As a valid user I try to recover my password ,
    I used a shared email address. Other valid users also uses the same email address in the system, and All settings change password are OFF. 
    (Multiple users with the same email but different carriers, All carriers have settings: `Everyone can change password` is OFF.)
    (Email associates with users of two carriers ProcessAutomation2 ,and processAutomation, Both settings change password are OFF. and the user is in ProcessAutomation carriers.)
    
    #For carrier setting ProcessAutomation2 to OFF
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
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
    Then I saw No permission password reset message "This email account is tied to multiple accounts. Some of these accounts have company settings which prevent password changes, so password reset may not be availabl".
    When I clicked ok butoon in verification page.
  	When I filled in the user details  Username as "as.test.user3",First Name as "Test",Last Name as "user3".
  	And I clicked Submit Button on User Details page.
  	#automated to the message seen text
  	Then I waited for 1 seconds.
    Then I saw not permission to reset password message "You don't have permission to reset the password. Please contact your manager" on the password recover page.
   # When I clicked ok butoon in verification page.
    #The above ok button also navigated to the login page
    When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
  	#For carrier setting ProcessAutomation2 to ON
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
    # Two carriers ProcessAutomation2 ,and processAutomation and Both Password settings off.
    @MgrSharedEmailAndAllCarriersSettingsOFF @case3b
		
   	Scenario: Recovery password by a user who uses a shared email address.
   	As a valid user and my role is manager, I try to recover my password ,
    I used a shared email address. Other valid users also uses the same email address in the system, and All settings change password are OFF. 
    (Multiple users with the same email but different carriers, All carriers have settings: `Everyone can change password` is OFF.)
    (Email associates with users of two carriers ProcessAutomation2 ,and processAutomation, Both settings change password are OFF. and the manager is in ProcessAutomation carriers.)
    
    #For carrier setting ProcessAutomation2 to OFF
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
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
    Then I saw No permission password reset message "This email account is tied to multiple accounts. Some of these accounts have company settings which prevent password changes, so password reset may not be availabl".
    When I clicked ok butoon in verification page.
  	When I filled in the user details  Username as "as.auto.mgr",First Name as "Auto",Last Name as "Mgr".
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
  	#For carrier setting ProcessAutomation2 to ON
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
    
    # Two carriers ProcessAutomation2 ,and processAutomation and processAutomation settings change password is off.
    @SameEmailsInManyCarriersOtherCarrierONUsersCarrierOFF @case4
   	Scenario: Recovery password by a user who uses a shared email address.
   	As a valid user I try to recover my password ,
    I used a shared email address. Other valid users also uses the same email address in the system, and Other carriers settings change password are ON and my Carriers setting change password is OFF. 
    (Multiple users with the same email but different carriers, All carriers have settings: `Everyone can change password` is OFF.)
    (Email associates with users of two carriers ProcessAutomation2 , and processAutomation, ProcessAutomation2 change password setting ON. and the user is in ProcessAutomation carriers, his carrier setting change password is OFF.)
    
    #For carrier setting ProcessAutomation2 to ON
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
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
    Then I saw No permission password reset message "This email account is tied to multiple accounts. Some of these accounts have company settings which prevent password changes, so password reset may not be availabl".
    When I clicked ok butoon in verification page.
  	When I filled in the user details  Username as "as.test.user3",First Name as "Test",Last Name as "user3".
  	And I clicked Submit Button on User Details page.
  	#automated to the message seen text
  	Then I waited for 1 seconds.
    Then I saw not permission to reset password message "You don't have permission to reset the password. Please contact your manager" on the password recover page.
   # When I clicked ok butoon in verification page.
    #The above ok button also navigated to the login page
    When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
  	#For carrier setting ProcessAutomation2 to ON
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
    
    @EmailAssociatedManyUsersInACarrierAndSettingON @case6
   	Scenario: Recovery password by a user who uses a shared email address.
   	As a valid user I try to recover my password ,
    I used a shared email address. Other valid users also use the same email address in the carrier. My carrier setting change password is ON. 
    (Multiple users with the same email and same carrier, the carrier has settings: `Everyone can change password` is ON.)
   
		Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I entered username "as.automation.cs" and password "test" as a customer support.
    And clicked Submit button on the login page.
     #checked for the home page
    Then I logged in successfully.
    When I click on Settings Main menu.
    And I checked Everyone change their password check Box in Settings.
    Then I Saved the Settings.
    And Log out From the Carriers.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    When I entered my username Or Email as "processautomationshare@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
  	#step 16
  	When I filled in the user details  Username as "as.test.user",First Name as "Test",Last Name as "user".
  	And I clicked Submit Button on User Details page.
  	#automated to the message seen text
    Then I saw a message `An email with verification code has been sent`.
    #And I checked an email in processautomationshare@gmail.com for six digit verification code and I found it.
    And I enter the code from processautomationshare@gmail.com to the verification page.
    And I submitted the verification code.
    When I entered new password and confirm new password in the password recovery page
    When I Clicked change button in the password recovery page.
    Then I saw message display about password successfully changed.
    And I clicked ok button in the password successfully change message.
    Then I saw the login page.
    When I entered username "as.test.user" and password "test".
    And clicked Submit button on the login page.
     #checked for the home page
    Then I logged in successfully.
    And I closed the browser.
    
		@EmailAssociatedManyUsersInACarrierAndSettingOFF  @case5
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
    Then I negivated to the password recover page.
    #the email address "processautomationshare@gmail.com" is used by multiple users in the carriers only.
    When I entered my username Or Email as "processautomationshare@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
    Then I saw No permission password reset message "This email account is tied to multiple accounts. Some of these accounts have company settings which prevent password changes, so password reset may not be availabl".
    When I clicked ok butoon in verification page.
    When I filled in the user details  Username as "as.test.user",First Name as "Test",Last Name as "user".
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
    And I quit the browser.

     