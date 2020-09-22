package org.anefdef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    static final String GATEWAY_HOST = "localhost";
    static final int GATEWAY_PORT = 5000;

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        //creating connection with gateway
        Socket gatewaySocket = new Socket(GATEWAY_HOST,GATEWAY_PORT);
        //creating and sending messages to the gateway
        PrintStream socketOut = new PrintStream(gatewaySocket.getOutputStream());

        BufferedReader socketIn = new BufferedReader(new InputStreamReader(gatewaySocket.getInputStream()));

        String message= consoleReader.readLine();
        while (message != null && !message.equals("exit")) {
            socketOut.println("Message from client");
            String response = socketIn.readLine();
            System.out.println(response);
        }
        gatewaySocket.close();
    }
}
