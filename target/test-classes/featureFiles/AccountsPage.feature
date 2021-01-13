Feature: Accounts Page Feature

Background:
Given user must login to the application
|username|password|
|pola@sharklasers.com|Shambo12345|

Scenario: Accounts Page Title
Given user is on accounts page
When user gets the title of the accounts page
Then accounts page title should be "My Account - My Store"
 
Scenario: Accounts Section Count
Given user is on accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts section count should be 6
