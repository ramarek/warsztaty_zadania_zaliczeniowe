Feature: Shop
  Scenario: Buy 5 products
    Given user is log in 'dapik41292@extemer.com' 'Test123!'
    When User searches for product 'Hummingbird Printed Sweater'
    Then Product page is opened 'Hummingbird Printed Sweater'
    When User sets product size 'M'

