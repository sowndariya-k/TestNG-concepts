Feature: Login to Demoblaze

@InvalidUser

Scenario Outline: Login with invalid user credentials
  Given User is on Demoblaze home page
  When User clicks on login link
  When User enters username as "<username>" and passsword as "<password>"
  And User clicks on login submit
  Then User should be able to see an "<errorMessage>"

Examples:
| username   | password  | errorMessage                          |
| *sk        | Sow@911!  | User does not exist.                  |
|            |           | Please fill out Username and Password.|
| sowndariya | sownd@91  | Wrong password.                       |

@ValidUser
Scenario: Login with valid credentials - Data Table without Header
  Given User is on Demoblaze home page
  When User clicks on login link
  And User enters valid credentials
    | sowndariya | Sow@911! |
  And User clicks on login submit
  Then User should be able to login successful and new page open
  
@Multiple_InvalidCredentials
Scenario: Login with invalid credentials - Data Table with Header and Multiple
  Given User is on Demoblaze home page
  When User clicks on login link
  Then User enters multiple invalid credentials and validates error messages
    | username   | password  | errorMessage                          |
    | *sk        | Sow@911!  | User does not exist.                  |
    |            |           | Please fill out Username and Password.|
    | sowndariya | sownd@91  | Wrong password.                       |