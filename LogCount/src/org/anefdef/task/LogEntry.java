package org.anefdef.task;

public class LogEntry {
    private final String userName;
    private final String url;

    public LogEntry(String userName, String url) {
        this.userName = userName;
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public String getUrl() {
        return url;
    }
}
