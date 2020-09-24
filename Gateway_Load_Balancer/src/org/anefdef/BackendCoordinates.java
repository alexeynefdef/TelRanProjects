package org.anefdef;

public class BackendCoordinates {

    private String address;
    private int port;

    public void setHost(String address) {
        this.address = address;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return address;
    }

    public int getPort() {
        return port;
    }
}
