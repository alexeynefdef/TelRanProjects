package org.anefdef.task.accounts;

import java.util.List;

public class AccountNew {
    private String uuid;
    private long balance;
    private List<Transaction> transactions;

    public AccountNew(String uuid, long balance, List<Transaction> transactions) {
        this.uuid = uuid;
        this.balance = balance;
        this.transactions = transactions;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}


