package org.anefdef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientTask implements Runnable {

    static final int CLIENT_PORT = 5000;
    private final Socket clientSocket;

    public ClientTask() throws IOException {
        ServerSocket socket = new ServerSocket(CLIENT_PORT);
        this.clientSocket = socket.accept();
    }

    @Override
    public void run() {
        try {
            BufferedReader incomingData = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintStream outgoingData = new PrintStream(clientSocket.getOutputStream());
            String line;
            while((line = incomingData.readLine()) != null) {
                String response = String.format("The line %s was accepted from client and handled", line);
                outgoingData.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
