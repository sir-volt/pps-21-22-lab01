import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class BankAccountTest {
    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;

    @BeforeEach
    public abstract void beforeEach();

    @Test
    public void testInitialBalance() {
        Assertions.assertEquals(0, bankAccount.getBalance());
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        Assertions.assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        Assertions.assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        Assertions.assertEquals(30, bankAccount.getBalance());
    }

    @Test
    public void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        Assertions.assertEquals(100, bankAccount.getBalance());
    }
}
