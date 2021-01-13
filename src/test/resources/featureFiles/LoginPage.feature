Feature: Login Page Feature

Scenario: Login Page Title
Given user is on login page
When  user gets the title of the login page
Then  login page title should be "Login - My Store"

Scenario: Forgot Password Link
Given user is on login page
Then  forgot your password link should be displayed

Scenario: Login with correct credentials
Given	user is on login page
When  user enters username "shambo.choudhuri9@gmail.com"
And   user enters password "Password@123"
And   user clicks on SignIn button
When  user gets the title of the accounts page
Then  accounts page title should be "My Account - My Store"

