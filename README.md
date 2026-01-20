# Banking Application

This system simulates real-world banking features such as account creation, deposit, withdrawal, balance inquiry, and fund transfer.

## Class Sructure Overview

### Account (Base Class)

The Account class represents the base for all account types, encapsulating common properties and behaviors such as:

- accountNumber
The unique identifier for each account.

- accountHolder
The name of the person holding the account.

- balance
The current balance of the account.

Key methods:
- deposit(double amount)
Adds the specified amount to the balance.

- withdraw(double amount)
Subtracts the specified amount from the balance if sufficient funds are available.

- checkBalance()
Displays the current balance.

### SavingsAccount (Subclass)

The SavingsAccount class inherits from Account and introduces a new property:

- interestRate
The interest rate associated with the savings account.

Additional methods:

- addInterest()
Adds interest to the balance based on the interest rate.

### CurrentAccount (Subclass)

The CurrentAccount class also inherits from Account but includes an additional feature:

- overdraftLimit
Allows withdrawals even if the balance goes below zero, but only up to the overdraft limit.

Overridden methods:

- withdraw(double amount)
Customizes the withdrawal logic to allow overdraft usage.

### Bank (Manager Class)

The Bank class manages a collection of Account objects. It provides methods to add accounts, find accounts, and transfer funds between them. This class demonstrates the power of polymorphism, as it works with both SavingsAccount and CurrentAccount objects through their shared Account interface.

### Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.