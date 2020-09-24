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

        //creating connection with gateway
        Socket gatewaySocket = new Socket(GATEWAY_HOST,GATEWAY_PORT);

        // getting line from keyboard
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String message = consoleReader.readLine();

        //creating and sending messages to the gateway
        PrintStream socketOut = new PrintStream(gatewaySocket.getOutputStream());
        //receiving data back from gateway
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(gatewaySocket.getInputStream()));

        while (message != null && !message.equals("exit")) {
            socketOut.println(message);
            String response = socketIn.readLine();
            System.out.println(response);
        }
        gatewaySocket.close();
    }
}
