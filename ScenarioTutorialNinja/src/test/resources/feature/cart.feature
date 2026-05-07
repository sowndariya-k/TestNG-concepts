Feature: Add multiple products to cart in TutorialsNinja

@MultipleProductsCart
Scenario: Add multiple products to cart using DataTable

  Given User is on TutorialsNinja Home page

  When User adds multiple products to cart
    | productName |
    | iPhone      |
    | MacBook     |
    | Samsung SyncMaster 941BW |

  Then Products should be added successfully to cart