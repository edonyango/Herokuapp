Feature: Add-Remove Buttons

@AddRemoveTest
Scenario: Add Button
Given the user is on the Internet home page
And the user clicks on AddRemove elements menu
When the user clicks on the Add button
Then a new button is added on the page
And close browser 

@AddRemoveTest
Scenario: Remove Button
Given the user is on the Internet home page
And the user clicks on AddRemove elements menu
When the user clicks on the Add button
And then clicks on Remove button
Then the new button is removed from the page
And close browser