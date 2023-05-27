public abstract class BankAccount {

    private double balance;

    private String pin;



    public BankAccount(double initialBalance, String pin) {

        balance = initialBalance;

        this.pin = pin;

    }



    public double getBalance() {

        return balance;

    }



    public void deposit(double amount) {

        balance += amount;

    }



    public boolean withdraw(double amount) {

        if (balance >= amount) {

            balance -= amount;

            return true;

        }

        return false;

    }



    public boolean validatePIN(String enteredPin) {

        return pin.equals(enteredPin);

    }

}
