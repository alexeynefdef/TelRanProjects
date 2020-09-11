package org.anefdef.transaction;

public class Transaction {
    private final String accountID;
    private final long sum;

    public Transaction(String accountID, long sum) {
        this.accountID = accountID;
        this.sum = sum;
    }

    public String getAccountID() {
        return accountID;
    }

    public long getSum() {
        return sum;
    }
}

















