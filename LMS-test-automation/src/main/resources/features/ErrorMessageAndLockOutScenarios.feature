#Author: navaraj@carriersedge.com

#All information for automation using ABC Trucklines ,
# The automation may fail if any of the test user is deleted from the Carrier or the carrier is deleted.
 #auto.nava(this is cs account),
#nava.noemailuser  -no email
#nava.emailmanager -carriersedgemutiuserstest@gmail.com
#nava.oneemail -carriersedgemutiuserstest@gmail.com
#nava.twoemail-carriersedgemutiuserstest@gmail.com
#nava.abc -carriersedgetest@gmail.com   -This email is used by only one user

@errorMessage @LMST-651 @LMST-456
Feature: Error Message and Lock out Scenarios
  I want to test different message appear when the user enters or forget to enter in the required field.
  #steps 1,2,3,4,
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
		Then I negivated to the password recover page.
		When I clicked Submit button without entering the Username or Email on the password recover form.
		Then I saw a prop up message-"Please enter your username or email".
		And I clicked Ok button on prop up.
	 	When I enter non existing username or email "random" in password Recovery page.
   	And  I clicked Submit button on the password recover page.
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
   	@ErrorInUserDetails
   	@EmailEnteredHasMultipleAccountError
   	@Error11Mockup
   	@Error12Mockup
   	@MockupError
  	Scenario: Verification of Error in user Detail page.
  	Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #the email address "carriersedgemutiuserstest@gmail.com" is used by multiple users in the system.
    #When I entered my username Or Email as "multiemail@carriersedge.com" for password recovery.
    When I entered my username Or Email as "carriersedgemutiuserstest@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
    Then I saw the page redirectid to (user details)Mockup_eleven showing message "We've found the email address you provided, but there are several accounts associated with it so we'll need a bit more information to pick the right one.".
  	#without filled out anythig in the user details form
  	When I clicked Submit Button on User Details page.
  	Then I saw a prop up message-"Please fill out at least one field: Username, First Name, or Last Name".
  	And I clicked Ok button on prop up.
  	And I closed the browser.
  	
  	#From Step 13,14
  	@Error15Mockup
   	@Error16Mockup
   	@ErrorInPasswordSetting
   	Scenario: Verification of Error in reset password page.
   	Given open the "chrome" browser.
    When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I negivated to the password recover page.
    #The email address is valid email and automated setup to get email snippet form the email address.
    When I entered my username Or Email as "carriersedgetest@gmail.com" for password recovery.
    Then I clicked Submit button on the password recover page.
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
    #since user name of email "carriersedgetest@gmail.com" is "nava.abc".
    When I entered "pq" (less then 3 characters) in new password field of password reset page.
    When I Clicked change button in the password recovery page.
    Then I saw a prop up message-"New password must be at least 3 characters long".
    And I clicked Ok button on prop up.
    When I entered "test" in new password field of password reset page.
    And I entered "abc" in new confirm password test box field of password reset page.
    When I Clicked change button in the password recovery page.
    Then I saw a prop up message-"New password and confirm password must match".
    And I clicked Ok button on prop up.
    And I closed the browser.
    
   
    
    @Lockout @lockoutFor24hours @LMST-652 
 Scenario: The user is lockout when the user uses the wrong credential continuously for more than 3 times.
 As a user, I try to find credentials by using non-existing user email or username, 
 but first I used 3-times non-existing user email,and I lockout for 10 minutes, then Again I tried 3 times,I locked out for 10 minutes, Again tried 3 times, 
  and lockout for 10 minutes and again tried 3 times and then finally I locked out for 24 hours. The number of attempts 12 before lockout for 24 hours.
  
  	
  	Given open the "firefox" browser.
   	When I opened the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I navigated to the password recovery page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 		Then I navigated to the Your Contact Information page.
 		And I clicked cancel button on Your Contact Information page.
    #1 time fail, Counter A=1, Attepmts count=1
   	Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I navigated to the password recovery page.
    #the email carriersedgetest@gmail.com is associated with a valid user. 
    #the below steps is used for making Counter A=0
    When I entered my username Or Email as "carriersedgetest@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
   	#the above steps set Counter A=0
   	
    When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I navigated to the password recovery page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 		Then I navigated to the Your Contact Information page.
 		And I clicked cancel button on Your Contact Information page.
    #1 time fail, Counter A=1, Attepmts count=1
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 		Then I navigated to the Your Contact Information page.
 		And I clicked cancel button on Your Contact Information page.
    #2 times failed, Counter A=2, Attepmts count=2
   	Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I navigated to the password recovery page.
   	When I entered my username Or Email as "carriersedgetest@gmail.com" for password recovery.
    And  I clicked Submit button on the password recover page.
   	#the above steps set Counter A=0
   	
   	When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I navigated to the password recovery page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 		Then I navigated to the Your Contact Information page.
 		And I clicked cancel button on Your Contact Information page.
    #1 time fail, Counter A=1, Attepmts count=1
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 		Then I navigated to the Your Contact Information page.
 	 	#2 times failed, Counter A=2 , Attepmts count=2
 		And I clicked cancel button on Your Contact Information page.
 		Then I saw the login page.
    When I Clicked Get help here link on the login page.
   	When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 	 	 #3 times failed, Counter A=3, Attepmts count=3
   	Then I got an error message `You have exceeded the number of allowed attempts. Please try again in 10 minutes`.
 		When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    #if I continue after use 3 times invalid user in password recovery, I will see the below message within 10 minutes.
    Then I saw an error message `Sorry but there was an error.`
    #Counter B=1
    And I Waited For 11 minutes.
    When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I navigated to the password recovery page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 		Then I navigated to the Your Contact Information page.
 		And I clicked cancel button on Your Contact Information page.
    #1 time fail,  Attepmts count=4
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 		Then I navigated to the Your Contact Information page.
 	 	#2 times failed,   Attepmts count=5
 		And I clicked cancel button on Your Contact Information page.
 		Then I saw the login page.
    When I Clicked Get help here link on the login page.
   	When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 	 	 #3 times failed,  Attepmts count=6
   	Then I got an error message `You have exceeded the number of allowed attempts. Please try again in 10 minutes`.
 		When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    #if I continue after use 3 times invalid user in password recovery, I will see the below message within 10 minutes.
    Then I saw an error message `Sorry but there was an error.`
    #Counter B=2
    And I Waited For 11 minutes.
    When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I navigated to the password recovery page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 		Then I navigated to the Your Contact Information page.
 		And I clicked cancel button on Your Contact Information page.
    #1 time fail,  Attepmts count=7
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 		Then I navigated to the Your Contact Information page.
 	 	#2 times failed,  Attepmts count=8
 		And I clicked cancel button on Your Contact Information page.
 		Then I saw the login page.
    When I Clicked Get help here link on the login page.
   	When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 	 	 #3 times failed,  Attepmts count=9
 	 	  #Counter B=3
 	 	 Then I got an error message `You have exceeded the number of allowed attempts. Please try again in 10 minutes`.
 		When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    #if I continue after use 3 times invalid user in password recovery, I will see the below message within 10 minutes.
    Then I saw an error message `Sorry but there was an error.`
    And I Waited For 11 minutes.
    When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    Then I navigated to the password recovery page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 		Then I navigated to the Your Contact Information page.
 		And I clicked cancel button on Your Contact Information page.
    #1 time fail,  Attepmts count=10
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
 		Then I navigated to the Your Contact Information page.
 	 	#2 times failed,  Attepmts count=11
 		And I clicked cancel button on Your Contact Information page.
 		Then I saw the login page.
    When I Clicked Get help here link on the login page.
   	When I entered my username Or Email as `Random Name` for password recovery.
    And  I clicked Submit button on the password recover page.
     #3 times failed, Attepmts count=12
 	 	  #Counter B=4
 	 	
   	Then I got an error message `You have exceeded the number of allowed attempts. Please try again in 24 hours`.
 		When I navigated to the "https://test.carriersedge.com/ce_test/login.jsp" page.
    Then I saw the login page.
    When I Clicked Get help here link on the login page.
    #if I continue after use 3 times invalid user in password recovery, I will see the below message within 10 minutes.
    Then I saw an error message `Sorry but there was an error.`
     And I quit the browser.