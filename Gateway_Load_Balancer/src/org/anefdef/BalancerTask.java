package org.anefdef;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class BalancerTask implements Runnable {

    private static final int BALANCER_PORT = 5002;
    private final BackendCoordinates backendCoordinates;

    public BalancerTask(BackendCoordinates backendCoordinates) {
        this.backendCoordinates = backendCoordinates;
    }

    @Override
    public void run() {

        try {

            DatagramSocket balancerSocket = new DatagramSocket(BALANCER_PORT);

            while (true) {

                byte[] incomingData =  new byte[8192];

                DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);

                balancerSocket.receive(incomingPacket);

                String rawData = new String(incomingData,0,incomingPacket.getLength());

                String[] addressAndPort = rawData.split(":");

                backendCoordinates.setAddress(addressAndPort[0]);
                backendCoordinates.setPort(Integer.parseInt(addressAndPort[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
