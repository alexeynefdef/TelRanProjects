package org.anefdef.task;

import java.util.List;

public class AccountsTool {

    public void blockTheOligarch(List<Account> accounts, int limit) {
        accounts.stream()
                .filter(account -> account.getSum() > limit)
                .forEach(Account::block);
    }

    public long getSumOfBlocked(List<Account> accounts) {
        return accounts
                .stream()
                .filter(Account::isBlocked)
                .mapToLong(Account::getSum)
                .sum();
    }
}
