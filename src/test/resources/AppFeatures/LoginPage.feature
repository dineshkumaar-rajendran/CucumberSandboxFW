Feature: Login Page feature

Scenario: Login Page title

Given user is on the login page 
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forget password link
Given user is on the login page
Then forget your password link should be visible 

Scenario: Login with correct credentials
Given user is on the login page
When user enters the username "dec2020secondbatch@gmail.com"
And user enters the password "Selenium@12345"
And user clicks on the login button
Then user gets the title of the page 
And page title should be "My account - My Store"