package org.anefdef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    private static final int SERVER_PORT = 4000;
    private static final String SERVER_HOST = "localhost";

    public static void main(String[] args) throws IOException {

        InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);

        BufferedReader consoleIN = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket socket = new DatagramSocket();

        byte[] dataIn = new byte[1024];
        DatagramPacket packetIn = new DatagramPacket(
                dataIn,
                dataIn.length);

        String line;
        while ((line = consoleIN.readLine()) != null && !line.equals("exit")) {
            byte[] dataOut = line.getBytes();
            DatagramPacket packetOut = new DatagramPacket(
                    dataOut,
                    dataOut.length,
                    serverAddress,
                    SERVER_PORT);
            socket.send(packetOut);

            socket.receive(packetIn);
            String response = new String(dataIn,0,packetIn.getLength());
            System.out.println("SERVER: " + response);
        }
    }
}
