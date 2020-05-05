Feature: Cashier Scenarios

  These some scenarios

  Scenario: To generate change

    Given I have a currency called "USD" with the following denominations
      | description | value |
      | $100        | 10000 |
      | $50         | 5000  |
      | $20         | 2000  |
      | $10         | 1000  |
      | $5          | 500   |
      | $2          | 200   |
      | $1          | 100   |
      | 50 cent     | 50    |
      | Quarter     | 25    |
      | Dime        | 10    |
      | Nickel      | 5     |
      | Penny       | 1     |
    And I request smallest number of bills and coins for 287

