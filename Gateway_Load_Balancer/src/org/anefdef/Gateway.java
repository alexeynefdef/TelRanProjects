package org.anefdef;

import java.io.IOException;

public class Gateway {

    public static void main(String[] args) throws IOException {

        // balancer part

        //current address and port storage
        BackendCoordinates backendCoordinates = new BackendCoordinates();

        Runnable balancerTask = new BalancerTask(backendCoordinates);
        Thread balancerProcess = new Thread(balancerTask);
        // start listening balancer
        balancerProcess.start();

        // client part

        Runnable clientTask = new GatewayTask(backendCoordinates);
        Thread clientProcess = new Thread(clientTask);
        // start listening client
        clientProcess.start();

    }
}
