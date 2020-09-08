package org.anefdef.task.accounts;


public class Transaction {
    private final String uuid;
    private TransactionState state;
    private long sum;
    private final long createdTime;

    public Transaction(String uuid, TransactionState state, long sum) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
        this.createdTime = System.currentTimeMillis();
    }

    public TransactionState getState() {
        return state;
    }

    public long getSum() {
        return sum;
    }
}
