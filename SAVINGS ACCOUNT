public class SavingsAccount extends BankAccount {

    private final double limit = 20000;



    public SavingsAccount(double initialBalance, String pin) {

        super(initialBalance, pin);

    }



    @Override

    public boolean withdraw(double amount) {

        if (getBalance() - amount >= limit) {

            return super.withdraw(amount);

        }

        return false;

    }

}
