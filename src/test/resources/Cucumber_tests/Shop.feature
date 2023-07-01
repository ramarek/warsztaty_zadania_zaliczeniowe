Feature: User Data
  Scenario Outline: Change Address
    Given user is log in 'dapik41292@extemer.com' 'Test123!'
    And Add new Address is clicked
    When New Address is added '<alias>' '<address>' '<city>' '<postalCode>' '<country>' '<phone>'
    Examples:
    | alias | address  | city  | postalCode | country       | phone |
    | aliss1| address1 | city1 | 44-222     | United Kingdom| 4444  |
