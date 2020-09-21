package org.anefdef;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Gateway {

    static final int CLIENT_PORT = 4000;
    static final int SERVER_PORT = 5000;
    static final int BALANCER_PORT = 3300;
    private static InetAddress currentAddress;

    public static void main(String[] args) throws IOException {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        ServerSocket clientSocket = new ServerSocket(CLIENT_PORT);

        while (true) {
            balancerProcess();
            Socket socketIN = clientSocket.accept();
            Socket socketOUT = new Socket(currentAddress,SERVER_PORT);

            Runnable gatewayTask = new GatewayTask(socketIN, socketOUT);
            pool.execute(gatewayTask);
        }
    }

    private static void balancerProcess() throws IOException {

        DatagramSocket balancerSocket = new DatagramSocket(BALANCER_PORT);
        byte[] incomingData = new byte[8192];
        DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
        balancerSocket.receive(incomingPacket);
        String rawData = new String(incomingData, 0, incomingPacket.getLength());
        setCurrentAddress(InetAddress.getByName(rawData));

    }

    public static void setCurrentAddress(InetAddress currentAddress) {
        Gateway.currentAddress = currentAddress;
    }

    public InetAddress getCurrentAddress() {
        return currentAddress;
    }
}
