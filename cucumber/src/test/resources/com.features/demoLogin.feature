Feature: Login to Demoblaze

Background:
  Given User is on Demoblaze home page
  When User clicks on login link

@ValidLogin
Scenario: Login with valid credentials
  And User enters username as "sowndariya"
  And User enters password as "Sow@911!"
  And User clicks on login submit
  Then User should see welcome username

@InvalidUser
Scenario: Login with invalid user credentials
  And User enters username as "*sk"
  And User enters password as "Sow@911!"
  And User clicks on login submit
  Then User should see alert user does not exist
  
@InvalidPassword
Scenario: Login with invalid password credentials
  And User enters username as "sowndariya"
  And User enters password as "Sow@911"
  And User clicks on login submit
  Then User should see alert wrong password 

@EmptyLogin
Scenario: Login with empty credentials
  And User clicks on login submit
  Then User should see alert Please fill out Username and Password