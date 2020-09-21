package org.anefdef;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    static final String GATEWAY_HOST = "localhost";
    static final int GATEWAY_PORT = 4000;

    public static void main(String[] args) throws IOException {
        //creating connection with gateway
        Socket gatewaySocket = new Socket(GATEWAY_HOST,GATEWAY_PORT);
        //creating and sending messages to the gateway
        PrintStream socketOut = new PrintStream(gatewaySocket.getOutputStream());
        for (int i = 0; i < 5; i++) {
            socketOut.println("Message n°: "+i);
        }
        gatewaySocket.close();
    }
}
