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

Scenario: Valid username and invalid password login
Given the user is on the internet login page
When the user logs in using "tomsmith" and password "wrongPassword!"
Then the login button is active
And login alert is "Your password is invalid!"
And close browser

Scenario: Invalid username and invalid password login
Given the user is on the internet login page
When the user logs in using "wrongUser" and password "wrongPassword!"
Then the login button is active
And login alert is "Your username is invalid!"
And close browser