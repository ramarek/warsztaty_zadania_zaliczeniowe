Feature: Shop
  Scenario: Buy 5 products
    Given User is log in 'dapik41292@extemer.com' 'Test123!'
    When User searches for product 'Hummingbird Printed Sweater'
    Then Product page is opened 'Hummingbird Printed Sweater'
    When User sets product size 'M'
    And User sets product quantity '5'
    And User clicks add to cart
    And User clicks Proceed to checkout
    And User clicks Confirm Address
    And User selects shipping method 'Pick up in-store'
    And User clicks continue
    And User selects payment method 'Pay by Check'
    And User checks conditions to approve
    And User clicks place order button
    Then Take Screenshot "order_confirmation.png"