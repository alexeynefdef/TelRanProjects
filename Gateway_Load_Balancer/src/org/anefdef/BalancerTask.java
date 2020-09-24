package org.anefdef;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class BalancerTask implements Runnable {

    private final int balancerPort;
    private final BackendCoordinates backendCoordinates;
    private static final String DELIMITER = ":";

    public BalancerTask(BackendCoordinates backendCoordinates, int BALANCER_PORT) {
        this.backendCoordinates = backendCoordinates;
        this.balancerPort = BALANCER_PORT;
    }

    @Override
    public void run() {

        try {

            DatagramSocket balancerSocket = new DatagramSocket(balancerPort);

            byte[] incomingData = new byte[1024];

            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);

            while (true) {

                balancerSocket.receive(incomingPacket);

                String rawData = new String(incomingData, 0, incomingPacket.getLength());

                String[] addressAndPort = rawData.split(DELIMITER);

                synchronized (backendCoordinates) {
                    backendCoordinates.setHost(addressAndPort[0]);
                    backendCoordinates.setPort(Integer.parseInt(addressAndPort[1]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
