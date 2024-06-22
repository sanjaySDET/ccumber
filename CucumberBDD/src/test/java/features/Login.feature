Feature: Login Feature

#Background is used whenever the preconditions and post conditions are same for all scenarios.
#Background:
#Given launch the browser
#When enter the url
#Then Login page should be displayed

@smokeTest
Scenario: Login to Vtiger application with invalid username and valid password.
Given I will launch the browser
And I will enter the url
When Login page is displayed I will enter invalid "manager" and valid password "admin"
And I will click on login button
Then I will validate the error message

@regTest
Scenario: Login to Vtiger application with valid username and valid password.
Given I will launch the browser
And I will enter the url
When Login page is displayed I will enter valid "admin" and valid password "admin"
And I will click on login button
Then check whether home page is displaying or not

#Parameterization
@regTest
Scenario Outline: Login to vtiger application with multiple username and password
Given I will launch the browser
And I will enter the url
When enter the username <username> and enter the password <password>
And I will click on login button
Then check whether home page is displaying or not
Examples:
|username|password|
|manager|admin|
|admin|manager|
|admin|admin|

#DataTable
@smokeTest
Scenario: Login to vtiger application with multiple username and password
Given I will launch the browser
And I will enter the url
When Login page is displaying enter username, enter password,click on orgs link, click on create org lookup img,enter the orgName,click on saveBtn
|admin|admin|TeckPyramid9|
Then check whether home page is displaying or not
Then Verify org is created or not