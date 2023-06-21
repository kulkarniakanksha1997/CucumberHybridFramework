Feature: Signup Functionality

Scenario: User Signup Using Required field
Given  User Navigate on Signup Page
When User Enter the below  field
|firstname |Akanksha             |
|lastrname |Kulkarni						 |
|email     |akanksha8@gmail.com |
|telephone |1234567892           |
|password  |123456               |
And User check the Privacy Policy check box
And  User clicks on Contiune button
Then  User Should get Message Your Account has been created

Scenario: User Signup Using All Field
Given  User Navigate on Signup Page
When User Enter the below  field
|firstname |Akanksha                |
|lastrname |Kulkarni						    |
|email     |akanksha2@gmail.com   |
|telephone |1234567892              |
|password  |123456                  |
And  User select yes for newsletter
And  User check the Privacy Policy check box
And User clicks on Contiune button
Then User Should get Message Your Account has been created
 
Scenario:  User Signup using all blank field
Given  User Navigate on Signup Page
When  User dont enter any field
And 	User clicks on Contiune button
Then  User should get warning message on required fields









