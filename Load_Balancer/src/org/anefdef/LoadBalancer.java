package org.anefdef;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

public class LoadBalancer {

    private static final int BACKEND_PORT = 3000;
    private static final int GATEWAY_PORT = 3300;
    private static final String GATEWAY_HOST = "localhost";
    private static final HashMap<InetAddress, Integer> loadValuesByIP = new HashMap<>();

    public static void main(String[] args) throws IOException {
        receiveDataFromBackend();
        sendCurrentAvailableAddressToGateway();
    }

    private static void receiveDataFromBackend() throws IOException {
        //creating udp socket to get data from backend
        DatagramSocket backendReceivingSocket = new DatagramSocket(BACKEND_PORT);
        //container for incoming data from backend
        byte[] backendData = new byte[8192];
        //creating datagram packet to receive from backend
        DatagramPacket backendIncomingPacket = new DatagramPacket(backendData, backendData.length);

        while (true) {
            //receiving data from server
            backendReceivingSocket.receive(backendIncomingPacket);
            //get data as string
            String rawData = new String(backendData, 0, backendIncomingPacket.getLength());
            //convert string to preferable format
            String[] addressPortLoadValue = rawData.split(":");
            InetAddress address = InetAddress.getByName(addressPortLoadValue[0]);
            Integer loading = Integer.parseInt(addressPortLoadValue[2]);
            //save data to the storage
            if (Integer.parseInt(addressPortLoadValue[1]) == GATEWAY_PORT) {
                loadValuesByIP.put(address, loading);
            }
        }
    }

    private static void sendCurrentAvailableAddressToGateway() throws IOException {
        //creating udp socket to send data to the gateway
        DatagramSocket gatewaySendingSocket = new DatagramSocket(GATEWAY_PORT);
        //finding best server
        InetAddress bestServer = getBestServer();
        //combining a string to send
        String dataToSend = bestServer.toString();
        while(true) {
            //creating a packet to send to the gateway
            DatagramPacket gatewaySendingPacket = new DatagramPacket(
                    dataToSend.getBytes(),
                    dataToSend.length(),
                    InetAddress.getByName(GATEWAY_HOST),
                    GATEWAY_PORT);
            //sending packet to the gateway
            gatewaySendingSocket.send(gatewaySendingPacket);
        }
    }

    private static InetAddress getBestServer() {

        InetAddress best = null;
        for (InetAddress address: loadValuesByIP.keySet()) {
            if (loadValuesByIP.get(address) < loadValuesByIP.get(best)) {
                best = address;
            }
        }
        return best;
    }
}
