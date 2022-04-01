package lab01.example.model;

public class BankAccountATM implements BankAccount{

    private double balance;
    private final AccountHolder holder;

    public BankAccountATM(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return holder;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }

    /* public void depositWithATM(final int userID, final double amount) {

        this.deposit(userID,amount-ATM_FEE);
    }
    */

    /*
    public void withdrawWithATM(final int userID, final double amount) {
        this.withdraw(userID,amount+ATM_FEE);
    }
    */

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
