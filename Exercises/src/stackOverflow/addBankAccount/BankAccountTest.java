package stackOverflow.addBankAccount;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;

public class BankAccountTest {

    @Test
    public void whenAddAccountThenTrue() {
        BankOperation bankOperation = new BankOperation();
        User user = new User("Sergey", "0102");
        User user1 = new User("Sergey", "0103");
        Account account = new Account("245", "23435");
        Account account1 = new Account("2455", "234356");
        bankOperation.addUser(user);
        bankOperation.addUser(user1);
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        accounts.add(account1);
        bankOperation.addAccountToUser("0102", account);
        bankOperation.addAccountToUser("0102", account1);
        bankOperation.addAccountToUser("0103", account);
        bankOperation.addAccountToUser("0103", account1);
        Map<User, List<Account>> map = new HashMap<>();
        map.put(user, accounts);
        map.put(user1, accounts);
        Assert.assertThat(bankOperation.getBankAccount(), is(map));
    }
}