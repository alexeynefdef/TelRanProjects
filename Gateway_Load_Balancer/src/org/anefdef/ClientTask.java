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
    private final Socket backendSocket;

    public ClientTask(BackendCoordinates backendCoordinates) throws IOException {
        ServerSocket socketC = new ServerSocket(CLIENT_PORT);
        this.clientSocket = socketC.accept();
        this.backendSocket = new Socket(backendCoordinates.getAddress(),backendCoordinates.getPort());
    }

    @Override
    public void run() {
        try {
            // receiving data from client
            BufferedReader incomingDatFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // sending data to backend
            PrintStream outgoingDataToBackend = new PrintStream(backendSocket.getOutputStream());
            // receiving data back from backend
            BufferedReader incomingBackDataFromBackend = new BufferedReader(new InputStreamReader(backendSocket.getInputStream()));
            // sending data back to client
            PrintStream outgoingDataToClient = new PrintStream(clientSocket.getOutputStream());

            String line;
            while((line = incomingDatFromClient.readLine()) != null) {
                //creating line to send to backend
                String response = String.format("The line < %s > was accepted from client and handled on GATEWAY", line);
                //sending line to backend
                outgoingDataToBackend.println(response);
                //receiving data back from backend
                String comingBackDataFromBackend = incomingBackDataFromBackend.readLine();
                //sending data back to client
                outgoingDataToClient.println(comingBackDataFromBackend);
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
