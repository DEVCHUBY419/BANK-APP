import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class BankAppGUI extends JFrame {

    private BankAccount selectedAccount;

    private String enteredPin;



    private JLabel balanceLabel;



    public BankAppGUI() {

        // Set up the main frame

        setTitle("Bank App");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 2));



        // Create a login page

        createLoginPage();



        // Create labels for displaying balance

        balanceLabel = new JLabel("Balance: $" + selectedAccount.getBalance());



        // Create buttons for actions

        JButton depositButton = new JButton("Deposit");

        JButton withdrawButton = new JButton("Withdraw");



        // Add action listeners to buttons

        depositButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to deposit:"));

                selectedAccount.deposit(amount);

                updateBalanceLabel();

            }

        });



        withdrawButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to withdraw:"));

                boolean withdrawn = selectedAccount.withdraw(amount);

                if (withdrawn) {

                    JOptionPane.showMessageDialog(null, "Withdrawal successful!");

                } else {

                    JOptionPane.showMessageDialog(null, "Insufficient funds!");

                }

                updateBalanceLabel();

            }

        });



        // Add components to the frame

        add(new JLabel("Account Type: " + getAccountTypeName(selectedAccount)));

        add(balanceLabel);

        add(new JLabel("Select Action:"));

        add(new JLabel(""));

        add(depositButton);

        add(withdrawButton);



        // Set frame properties

        pack();

        setLocationRelativeTo(null);

        setVisible(true);

    }



    private void createLoginPage() {

        JTextField pinField = new JPasswordField(10);

        JOptionPane.showOptionDialog(null, pinField, "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);

        enteredPin = pinField.getText();



        String[] accountTypes = {"Savings Account", "Current Account"};

        String selectedType = (String) JOptionPane.showInputDialog(null, "Select Account Type:", "Account Type", JOptionPane.QUESTION_MESSAGE, null, accountTypes, accountTypes[0]);



        if (selectedType.equals("Savings Account")) {

            selectedAccount = new SavingsAccount(100000, enteredPin);

        } else {

            selectedAccount = new CurrentAccount(0, enteredPin);

        }



        if (!selectedAccount.validatePIN(enteredPin)) {

            JOptionPane.showMessageDialog(null, "Invalid PIN! Exiting...");

            System.exit(0);

        }

    }



    private void updateBalanceLabel() {

        balanceLabel.setText("Balance: $" + selectedAccount.getBalance());

    }



    private String getAccountTypeName(BankAccount account) {

        if (account instanceof SavingsAccount) {

            return "Savings Account";

        } else if (account instanceof CurrentAccount) {

            return "Current Account";

        }

        return "Unknown";

    }

}
