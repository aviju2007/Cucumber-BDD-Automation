Feature: As a football I should be able to signin in theFa.com with valid credentials.Navigate to Squad Page by clicking on Men Senior Page.
         After that Logout from the theFA.com.          
         
@FA
 Scenario Outline: Login into the application with valid credentials
  	Given I am on the Home Page for FA "<url>"
    Then I click on sign in link and wait for sign in page
    Then I should see FA Sign In Page
    When I enter username in FA as "<username>" 
    And I enter password in FA as "<password>"
    And click on Sign in button
    Then I am logged in to FA
    
    Examples:
	 | username |password| url |
	 | ********* | ********|https://www.thefa.com/|
	 
	
@WLC
Scenario Outline: Browse and validate sample flow in womens football
  	Given I am on the Home Page for "<url>"
    Then I click on For Girls section
    Then I should be able to see Get Inspire Section
    When I click on one of article in the carousel 
    Then I can see the corresponding label
    
    Examples:
	 | url |
	 | https://womenscompetitions.thefa.com/|
	 