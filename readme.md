## Coin Challenge

Assume you are working on a large Java enterprise application. Your requirement is to build a feature to
take in a balance and convert it into denominations (bills/coins). The intent is to convert the input
balance into the least number of bills/coins. The balance is expressed as the lowest unit of currency (e.g.
pennies for USD).

####Examples:
Given the balance 87, the function will return 3 Quarters, 1 Dime, 2 Pennies.
Given the balance 287, the function will return 2 Dollars, 3 Quarters, 1 Dime, 2 Pennies.
Please make use of Object Oriented analysis and design techniques in your implementation so that
enhancements to the feature can be easily accommodated in the future.


####Example of a feature enhancement:
Distribute currency from different countries that use different denominations:
e.g. for Indian Rupee (INR): Given the balance 287, the function will return 1 two rupee coin, 1 fifty paise
coin, 1 twenty five paise coin, 1 ten paise coin and 2 one paise coins

e.g. for Euro (EURO): Given the balance 287, the function will return 1 two euro coin, 1 50c coin, 1 20c
coin, 1 10c coin, 1 5c coin, and 2 1c coins

## Proposed Solution
At present, there is no base class of Money in Java. However, JSR 354 is proposing a Money and Currency API.

For this solution I am proposing a basic Money class that is Denomination aware. 

Please see test scenarios

`mvn test `


