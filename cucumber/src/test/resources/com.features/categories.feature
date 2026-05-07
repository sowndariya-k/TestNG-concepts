Feature: Browse categories in Demoblaze

Background:
  Given User is on Demoblaze home page

@ViewPhones
Scenario: View phones category
  When User clicks on Phones category
  Then User should see list of phones

@ViewLaptops
Scenario: View laptops category
  When User clicks on Laptops category
  Then User should see list of laptops

@ViewMonitors
Scenario: View monitors category
  When User clicks on Monitors category
  Then User should see list of monitors
