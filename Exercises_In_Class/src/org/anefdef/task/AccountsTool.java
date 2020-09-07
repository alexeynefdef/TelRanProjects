package org.anefdef.task;

import java.util.List;

public class AccountsTool {

    public void blockTheOligarch(List<Account> accounts, int limit) {
        accounts.stream().
                filter(account -> account.getSum() > limit).
                forEach(Account::block);
    }
}
