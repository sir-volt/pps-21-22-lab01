import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest {

    @Override
    @BeforeEach
    public void beforeEach(){
        accountHolder = new AccountHolder("Luigi","Mario",31);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder,0);
    }

    @Test
    void testDepositWithATM() {
        bankAccount.depositWithATM(accountHolder.getId(), 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithATM() {
        bankAccount.depositWithATM(accountHolder.getId(), 100);
        bankAccount.withdrawWithATM(accountHolder.getId(), 70);
        assertEquals(28, bankAccount.getBalance());
    }
}
