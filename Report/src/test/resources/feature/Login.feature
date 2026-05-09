Feature: Login to HRM Application

@ValidCredentials
Scenario: Login with valid credentials

Given user is on HRMLogin Page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When user enters username and password
Then user should able to login successfully and should see dashboard


@InvalidCredentials
Scenario: Invalid Login

Given user is on HRMLogin Page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When user enters invalid username and password
Then user should see error message