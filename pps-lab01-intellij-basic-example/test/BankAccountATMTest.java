import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.BankAccountATM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountATMTest extends AbstractBankAccountTest {

    private static final int ATM_FEE = 1;

    @Override
    @BeforeEach
    public void beforeEach(){
        accountHolder = new AccountHolder("Luigi","Mario",31);
        bankAccount = new BankAccountATM(accountHolder,0);
    }

    @Override
    @Test
    public void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100 - ATM_FEE, bankAccount.getBalance());
    }

    @Override
    @Test
    public void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        Assertions.assertEquals(100 - ATM_FEE, bankAccount.getBalance());
    }

    @Override
    @Test
    public void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(28, bankAccount.getBalance());
    }

    @Override
    @Test
    public void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        Assertions.assertEquals(100 - ATM_FEE, bankAccount.getBalance());
    }


}
