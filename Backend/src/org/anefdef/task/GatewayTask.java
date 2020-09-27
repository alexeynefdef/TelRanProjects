package org.anefdef.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class GatewayTask implements Runnable {

    private final Socket gatewaySocket;

    public GatewayTask(Socket socket) {
        this.gatewaySocket = socket;
    }

    @Override
    public void run() {
        try {
            // the object sends data to client
            PrintStream socketOut = new PrintStream(gatewaySocket.getOutputStream());
            // the object receives data from client
            BufferedReader socketIn = new BufferedReader(new InputStreamReader(gatewaySocket.getInputStream()));

            String line;
            while ((line = socketIn.readLine()) != null) {
                String response = String.format("The string %s was accepted from the client and handled", line);
                socketOut.println(response);
            }
            gatewaySocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
