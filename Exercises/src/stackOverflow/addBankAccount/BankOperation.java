package stackOverflow.addBankAccount;

import java.util.*;

public class BankOperation {
    private Map<User, List<Account>> bankAccount = new HashMap<>();

    void addAccountToUser(String passport, Account account) {
        for (User user : bankAccount.keySet()) {
            if (user.getPassport() != null && user.getPassport().equals(passport)) {
                List<Account> accounts = bankAccount.get(user);
                if (accounts == null) {
                    accounts = new ArrayList<>();
                }
                accounts.add(account);
                bankAccount.put(user, accounts);
                break;
            }
        }
    }

    public void addUser(User user) {
        bankAccount.put(user, null);
    }

    public Map<User, List<Account>> getBankAccount() {
        return bankAccount;
    }
}
