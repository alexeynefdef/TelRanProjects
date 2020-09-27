package org.anefdef;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class BalancerTask implements Runnable {

    private final int balancerPort;
    private final BackendCoordinatesStorage backendCoordinatesStorage;
    private static final String DELIMITER = ":";

    public BalancerTask(BackendCoordinatesStorage backendCoordinatesStorage, int BALANCER_PORT) {
        this.backendCoordinatesStorage = backendCoordinatesStorage;
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

                synchronized (backendCoordinatesStorage) {
                    backendCoordinatesStorage.setHost(addressAndPort[0]);
                    backendCoordinatesStorage.setPort(Integer.parseInt(addressAndPort[1]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
