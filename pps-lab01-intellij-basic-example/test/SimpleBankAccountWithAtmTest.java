import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest {

    private static final int ATM_FEE = 1;

    @Override
    @BeforeEach
    public void beforeEach(){
        accountHolder = new AccountHolder("Luigi","Mario",31);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder,0);
    }

    @Test
    void testDepositWithATM() {
        bankAccount.deposit(accountHolder.getId(), 100 - ATM_FEE);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithATM() {
        bankAccount.deposit(accountHolder.getId(), 100 - ATM_FEE);
        bankAccount.withdraw(accountHolder.getId(), 70 + ATM_FEE);
        assertEquals(28, bankAccount.getBalance());
    }
}
