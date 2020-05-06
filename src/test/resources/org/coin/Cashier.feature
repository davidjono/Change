Feature: Cashier Scenarios

  These some scenarios that we can use to check that we get the smallest amount of bills for different currencies and amounts

  Scenario: To ensure we receive the smallest amount of bills for USD denominations

    Given I have a currency called "USD" with the following denominations and an amount in smallest units of "3"
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
    And I request smallest number of bills and coins
    Then I should have the following change
      | description | value |
      | Penny       | 1     |
      | Penny       | 1     |
      | Penny       | 1     |

  Scenario: To ensure we receive the smallest amount of bills for USD denominations

    Given I have a currency called "USD" with the following denominations and an amount in smallest units of "5"
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
    And I request smallest number of bills and coins
    Then I should have the following change
      | description | value |
      | Nickel      | 5     |

  Scenario: To ensure we receive the smallest amount of bills for USD denominations

    Given I have a currency called "USD" with the following denominations and an amount in smallest units of "1"
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
    And I request smallest number of bills and coins
    Then I should have the following change
      | description | value |
      | Penny       | 1     |


  Scenario: To ensure we receive the smallest amount of bills for USD denominations. In this scenario we have provided denominations not in a sorted order

    Given I have a currency called "USD" with the following denominations and an amount in smallest units of "80003"
      | description | value |
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
      | $100        | 10000 |
    And I request smallest number of bills and coins
    Then I should have the following change
      | description | value |
      | $100        | 10000 |
      | $100        | 10000 |
      | $100        | 10000 |
      | $100        | 10000 |
      | $100        | 10000 |
      | $100        | 10000 |
      | $100        | 10000 |
      | $100        | 10000 |
      | Penny       | 1     |
      | Penny       | 1     |
      | Penny       | 1     |


  Scenario: To ensure we receive the smallest amount of bills for EUR denominations

    Given I have a currency called "EUR" with the following denominations and an amount in smallest units of "53600"
      | description | value |
      | EUR500      | 50000 |
      | EUR200      | 20000 |
      | EUR100      | 10000 |
      | EUR50       | 5000  |
      | EUR20       | 2000  |
      | EUR10       | 1000  |
      | EUR5        | 500   |
      | Two Euro    | 200   |
      | One Euro    | 100   |
      | 50 Cent     | 50    |
      | 20 Cent     | 20    |
      | 10 Cent     | 10    |
      | 5 Cent      | 5     |
      | 2 Cent      | 2     |
      | 1 Cent      | 1     |
    And I request smallest number of bills and coins
    Then I should have the following change
      | description | value |
      | EUR500      | 50000 |
      | EUR20       | 2000  |
      | EUR10       | 1000  |
      | EUR5        | 500   |
      | One Euro    | 100   |

