package org.anefdef;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

public class LoadBalancer {

    private static final int BACKEND_PORT = 5001;
    private static final int GATEWAY_PORT = 5002;
    private static final String GATEWAY_HOST = "localhost";
    private static final HashMap<String, Integer> loadValuesByIP = new HashMap<>();

    public static void main(String[] args) throws IOException {

        // G E T T I N G   A D D R E S S   &    S E N D I N G   A D D R E S S

        //creating udp socket to get data from backend
        DatagramSocket backendReceivingSocket = new DatagramSocket(BACKEND_PORT);
        //container for incoming data from backend
        byte[] backendData = new byte[1024];
        //creating datagram packet to receive from backend
        DatagramPacket backendIncomingPacket = new DatagramPacket(backendData, backendData.length);
        //creating udp socket to send data to the gateway
        DatagramSocket gatewaySendingSocket = new DatagramSocket(GATEWAY_PORT);

        while (true) {
            //receiving data from server
            backendReceivingSocket.receive(backendIncomingPacket);
            //get data as string
            String rawData = new String(backendData, 0, backendIncomingPacket.getLength());
            //convert string to preferable format
            String[] addressPortLoadValue = rawData.split(":");
            String addressAndPort = addressPortLoadValue[0] + ":" + addressPortLoadValue[1];
            Integer loading = Integer.parseInt(addressPortLoadValue[2]);
            //save data to the storage
            loadValuesByIP.put(addressAndPort, loading);
            //finding best server
            String dataToSend = getBestServer();
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

    /**
     * Method, witch determines possible less loaded backend connection
     * @return an address as a String <Address:PORT>
     */
    private static String getBestServer() {
        String best = null;
        for (String address: loadValuesByIP.keySet()) {
            if (loadValuesByIP.get(address) < loadValuesByIP.get(best)) {
                best = address;
            }
        }
        return best;
    }
}
