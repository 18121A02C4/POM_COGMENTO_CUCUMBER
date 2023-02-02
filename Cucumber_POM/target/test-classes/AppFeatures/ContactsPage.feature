Feature: Contacts Page Feature

Background:
Given user has already logged in to application
|username|password|
|psreddy0712@gmail.com|Devil@777|

Scenario: Click on contacts link
Given user is on Contacts page
Then contacts label should be displayed
Then contact with given name "mani ratnam" should be clicked.

Scenario Outline: Add new Contacts to the Contacts List
Given user is on Add Contact Page
When user enters "<FirstName>" in firstname field
And user enters "<LastName>" in lastname field
And user clicks on save button
Examples: 
	|FirstName| LastName |
	|Tharun|Pathagunta|
	|Rishi|Pasupuleti|
	|Dheeraj|Muthamchetty|
	|Shashank|Peta|