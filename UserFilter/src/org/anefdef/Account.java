package org.anefdef;

public class Account {
    final String ID;
    long balance;
    boolean isLocked;

    public Account(String ID, long balance, boolean isLocked) {
        this.ID = ID;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    public String getID() {
        return ID;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
