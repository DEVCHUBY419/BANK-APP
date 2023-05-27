# BANK-APP
We used inheritance to create a BankAccount base class and derive SavingsAccount and CurrentAccount from it, the BankAccount class is the base class that defines the common functionality of a bank account, while the SavingsAccount and CurrentAccount classes inherit from it and provide specific implementation details.

The MainPage class accepts a BankAccount instance in its constructor, allowing you to create instances of MainPage for different account types (SavingsAccount and CurrentAccount in this case).

When you run the MainPage class, it will prompt you to enter the PIN, and based on the PIN provided, you can access the account details and perform deposit and withdrawal operations for the respective account type.
