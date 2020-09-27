package org.anefdef.task;

import org.anefdef.Backend;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BalancerUpdater implements Runnable {

    private final String BALANCER_HOST;
    private final int BALANCER_PORT;

    public BalancerUpdater(String balancer_host, int balancer_port) {
        BALANCER_HOST = balancer_host;
        BALANCER_PORT = balancer_port;
    }

    @Override
    public void run() {
        try (DatagramSocket balancerSocket = new DatagramSocket(BALANCER_PORT, InetAddress.getByName(BALANCER_HOST))) {
            while(true) {
                byte[] outgoingDataToBalancer = Backend.getLoading().toString().getBytes();
                DatagramPacket packetOut = new DatagramPacket(outgoingDataToBalancer,outgoingDataToBalancer.length);
                balancerSocket.send(packetOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
