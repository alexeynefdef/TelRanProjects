package org.anefdef;

import java.io.IOException;

public class Gateway {

    static final int CLIENT_PORT = 5000;
    static final int BALANCER_PORT = 5002;

    public static void main(String[] args) throws IOException {

        //current address and port storage
        BackendCoordinates backendCoordinatesStorage = new BackendCoordinates();

        // balancer part
        Runnable balancerListener = new BalancerTask(backendCoordinatesStorage,BALANCER_PORT);
        Thread balancerProcess = new Thread(balancerListener);
        // start listening balancer
        balancerProcess.start();

        // client part
        Runnable proxy = new GatewayTask(backendCoordinatesStorage,CLIENT_PORT);
        Thread proxyProcess = new Thread(proxy);
        // start listening client
        proxyProcess.start();
    }
}
