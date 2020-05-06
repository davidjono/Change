Feature: Money Scenarios

  These some scenarios that we can use to check Money functions

  Scenario: Create some Money and add to it

    Given I have a currency called "USD" with the following denominations and an amount in smallest units of "6777"
      | description | value |
      | $100        | 10000 |
      | $50         | 5000  |
      | $20         | 2000  |
      | $10         | 1000  |
      | $5          | 500   |
      | $2          | 200   |
      | $1          | 100   |
      | 50 Cent     | 50    |
      | Quarter     | 25    |
      | Dime        | 10    |
      | Nickel      | 5     |
      | Penny       | 1     |
    Then I add "50" to that amount and I should have "6827"
