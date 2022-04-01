package lab01.example.model;

import lab01.example.model.BankAccount;

public class SimpleBankAccountWithAtm extends SimpleBankAccount{

    private static final int ATM_FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(holder,balance);
    }

    public void depositWithATM(final int userID, final double amount) {
        super.deposit(userID,amount-ATM_FEE);
    }

    public void withdrawWithATM(final int userID, final double amount) {
        super.withdraw(userID,amount+ATM_FEE);
    }

}
