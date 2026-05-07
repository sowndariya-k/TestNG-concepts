Feature: Register user in TutorialsNinja

@ValidRegister
Scenario: Register with valid user details - DataTable without header

  Given User navigates to TutorialsNinja Home page
  And User click on My Account Link
  And User click on Register button
  When User enters valid registration details
    | sowndariya | K | sowndariya@gmail.com | 9876543210 | Sow@911! | Sow@911! |
  And User selects privacy policy checkbox
  And User clicks on continue button
  Then User account should be created successfully
  
  
  @InvalidRegister
Scenario: Register with already registered email

  Given User navigates to TutorialsNinja Home page
  And User click on My Account Link
  And User click on Register button

  When User enters valid registration details
    | sowndariya | K | sowndariya@gmail.com | 9876543210 | Sow@911! | Sow@911! |

  And User selects privacy policy checkbox
  And User clicks on continue button

  Then User should see warning message "Warning: E-Mail Address is already registered!"