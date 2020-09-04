package org.anefdef;

public class Account {
    private final String ID;
    private final long balance;
    private final boolean isLocked;

    public Account(String ID, long balance, boolean isLocked) {
        this.ID = ID;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
