package org.anefdef;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GatewayTask implements Runnable {

    private final int clientPort;
    private BackendCoordinates storage;

    public GatewayTask(BackendCoordinates backendCoordinates,int clientPort) throws IOException {
        this.storage = backendCoordinates;
        this.clientPort = clientPort;

    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(clientPort);

            while (true) {

                Socket clientSocket = serverSocket.accept();

                TCPProxyTask proxyTask = new TCPProxyTask(storage,clientSocket);
                Thread TCPProxyProcess = new Thread(proxyTask);
                TCPProxyProcess.start();
            }
            /**
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
            }**/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
