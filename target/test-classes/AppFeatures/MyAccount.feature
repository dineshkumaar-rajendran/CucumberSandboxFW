Feature: Account feature page 

Background: 
Given user is already logged into the application
|username|password|
|dec2020secondbatch@gmail.com|Selenium@12345|
	
Scenario: Account page title
Given user is on the accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

Scenario: Account section count
Given user is on the accounts page
Then user gets account selection 
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY WISHLISTS|
|MY PERSONAL INFORMATION|
|Home|
And Account should count be 6