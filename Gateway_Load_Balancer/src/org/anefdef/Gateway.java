package org.anefdef;

import java.io.IOException;
import java.net.*;

public class Gateway {

    private static InetAddress currentAddress;
    private static int currentPort;


    public static void main(String[] args) throws IOException {

        // balancer part

        BackendCoordinates backendCoordinates = new BackendCoordinates();
        Runnable balancerTask = new BalancerTask(backendCoordinates);
        Thread balancerProcess = new Thread(balancerTask);
        // start listening balancer
        balancerProcess.start();

        // client part

        Runnable clientTask = new ClientTask();
        Thread clientProcess = new Thread(clientTask);
        // start listening client
        clientProcess.start();

    }
}
