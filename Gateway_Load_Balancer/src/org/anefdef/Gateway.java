package org.anefdef;

import java.io.IOException;

public class Gateway {

    static final int CLIENT_PORT = 5000;
    static final int BALANCER_PORT = 5002;

    public static void main(String[] args) throws IOException {

        //current address and port storage
        BackendCoordinatesStorage backendCoordinatesStorage = new BackendCoordinatesStorage();

        // balancer part
        System.out.println("Load balancer listener run on port " + BALANCER_PORT);
        Runnable balancerListener = new BalancerTask(backendCoordinatesStorage,BALANCER_PORT);
        Thread balancerProcess = new Thread(balancerListener);
        balancerProcess.start();

        // client part
        System.out.println("Tcp proxy run on port " + CLIENT_PORT);
        Runnable proxy = new GatewayTask(backendCoordinatesStorage,CLIENT_PORT);
        Thread proxyProcess = new Thread(proxy);
        proxyProcess.start();
    }
}
