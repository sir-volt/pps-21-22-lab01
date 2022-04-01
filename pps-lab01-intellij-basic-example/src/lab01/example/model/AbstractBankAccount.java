package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount {

    protected final AccountHolder holder;
    protected double balance;

    public AbstractBankAccount(final AccountHolder holder, final double balance){
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
            this.balance += amount - getATMFee();
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount + getATMFee();
        }
    }

    protected abstract int getATMFee();

    private boolean isWithdrawAllowed(final double amount) {
        return this.balance >= amount;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
