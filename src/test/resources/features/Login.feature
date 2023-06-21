Feature: Login Functionality

Scenario Outline: Login With Valid Creditionals
Given User has navigated to login page
When Enter Valid Email Address <Username> in to the email field
And Enter Valid Password <Password> in to password field
And clicks On login button
Then User should get Successfully Logged in
Examples: 
|Username  						|Password|
|akankshak1@gmail.com |1234|
|akanksha2@gmail.com  |12345|
|akankshak@gmail.com  |123456|


Scenario: Login With inValid Creditionals
Given User has navigated to login page
When Enter inValid Email Address  in to the email field
And Enter inValid Password "1234566" in to password field
And clicks On login button
Then User should get warning message creditionals mismatch


Scenario: Login With inValid email and valid password
Given User has navigated to login page
When Enter inValid Email Address  in to the email field
And Enter Valid Password "1234566" in to password field
And clicks On login button
Then  User should get warning message creditionals mismatch


Scenario: Login With valid email  inValid password  Creditionals
Given User has navigated to login page
When Enter Valid Email Address "akankshak@gmail.com" in to the email field
And Enter inValid Password "1234566" in to password field
And clicks On login button
Then User should get warning message creditionals mismatch
        

Scenario: Login With Blank Creditionals
Given User has navigated to login page
When User Enter the blank email into email field
And User Enter Blank  Password in to password field
And clicks On login button
Then User should get warning message creditionals mismatch
