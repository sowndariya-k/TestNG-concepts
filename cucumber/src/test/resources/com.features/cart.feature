Feature: Cart functionality in Demoblaze

  Background:
    Given User is on Demoblaze home page

  @AddToCart
  Scenario: Add a product to cart successfully
    When User selects product "Samsung galaxy s6"
    And User adds the product to cart
    Then User should see the alert product added

  @ViewCart
  Scenario: View products in cart
    When User selects product "Samsung galaxy s6"
    And User adds the product to cart
    And User navigates to cart page
    Then User should see the product in cart

  @DeleteFromCart
  Scenario: Remove product from cart
    When User selects product "Samsung galaxy s6"
    And User adds the product to cart
    And User navigates to cart page
    And User removes the product from cart
    Then Product should be removed from cart