Feature: Login to TutorialsNinja

@InvalidLogin

Scenario Outline: Login with invalid credentials

  Given User is on TutorialsNinja Login page
  When User enters email as "<email>" and password as "<password>"
  And User clicks on Login button
  Then User should see login warning message "<warningMessage>"

Examples:
| email                  | password | warningMessage                                        |
| priya@gmail.com        | sow@123  | Warning: No match for E-Mail Address and/or Password. |
|                        |          | Warning: No match for E-Mail Address and/or Password. |
| priya123@gmail.com     | sow@911  | Warning: No match for E-Mail Address and/or Password. |


@ValidLogin

Scenario Outline: Login with valid credentials

  Given User is on TutorialsNinja Login page
  When User enters email as "<email>" and password as "<password>"
  And User clicks on Login button
  Then User should login successfully

Examples:
| email              | password  |
| sowndariya@gmail.com | Sow@911!  |