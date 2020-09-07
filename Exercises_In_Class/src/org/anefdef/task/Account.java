package org.anefdef.task;

public class Account {

    private String ID;
    private long sum;
    private boolean isBlocked;

    public Account(String ID, long sum) {
        this.ID = ID;
        this.sum = sum;
        this.isBlocked = false;
    }

    public long getSum() {
        return sum;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void block() {
        this.isBlocked = true;
    }
}
