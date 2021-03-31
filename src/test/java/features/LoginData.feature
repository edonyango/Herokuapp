Feature: WebApp Login

Scenario: Navigate to the login page
Given Initialize browser with "chrome"
And User navigates to the Internet landing page
When User clicks on the Form Authentication menu
Then The login page is populated
And close browser

Scenario: Valid password and username login
Given the user is on the internet login page
When the user logs in using "tomsmith" and password "SuperSecretPassword!"
Then the secure area page is populated
And login alert is "You logged into a secure area!"
And close browser

@PasswordTest
Scenario Outline: Invalid username and password test
Given the user is on the internet login page
When the user logs in with <userName> and password <passWord>
Then the login button is active
And error alert <AlertMsg>
And close browser

Examples:
|userName | passWord 	 | AlertMsg 			   |
|tomsmith |wrongPassword!|Your password is invalid!|
|wrongUser|wrongPassword!|Your username is invalid!| 


