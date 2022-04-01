import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest{

    private AccountHolder accountHolder;
    private SimpleBankAccountWithAtm bankAccount;


    @BeforeEach
    public void beforeEach(){
        accountHolder = new AccountHolder("Luigi","Mario",31);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder,0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testDepositWithATM() {
        bankAccount.depositWithATM(accountHolder.getId(), 100);
        assertEquals(99, bankAccount.getBalance());
    }


    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithATM() {
        bankAccount.depositWithATM(accountHolder.getId(), 100);
        bankAccount.withdrawWithATM(accountHolder.getId(), 70);
        assertEquals(28, bankAccount.getBalance());
    }

}
