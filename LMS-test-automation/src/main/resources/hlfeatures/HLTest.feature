#Author: Ankur.shukla
# This automation is used to check wether the website is working fine. 
Feature: Checking Company website is working fine.
 
  @TicketNumber
  Scenario: Checking links are accessible.
    Given open the "chrome" browser.
    When I opened the "https://hl.com" page.
    Then I waited for 3 seconds.
    Then I hide cookies disclaimer.
    Then I waited for 2 seconds.
    Then I clicked on services link.
    Then I waited for 2 seconds.
    And I verified the services page appeared.
    Then I clicked on industry coverage group link.
    Then I waited for 2 seconds.
    And I verified the industry coverage group page appeared.
    And I quit the browser. 

  Scenario: Checking Pages are accessible.
    Given open the "chrome" browser.
    When I opened the "https://hl.com" page.
    Then I waited for 3 seconds.
    Then I hide cookies disclaimer.
    Then I waited for 2 seconds.
    And I quit the browser. 
    
  Scenario: Checking Another pages are accessible.
    Given open the "chrome" browser.
    When I opened the "https://hl.com" page.
    Then I waited for 3 seconds.
    Then I hide cookies disclaimer.
    Then I waited for 2 seconds.
    And I quit the browser. 
