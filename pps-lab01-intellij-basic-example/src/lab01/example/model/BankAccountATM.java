package lab01.example.model;

public class BankAccountATM extends AbstractBankAccount {

    public BankAccountATM(final AccountHolder holder, final double balance) {
        super(holder,balance);
    }

    @Override
    protected int getATMFee() {
        return 1;
    }

}
