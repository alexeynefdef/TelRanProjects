package org.anefdef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TCPProxyTask implements Runnable {

    private final Socket clientSocket;
    private final BackendCoordinatesStorage storage;

    public TCPProxyTask(BackendCoordinatesStorage storage, Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.storage = storage;
    }

    @Override
    public void run() {

        try (Socket serverSocket = new Socket(storage.getHost(),storage.getPort())) {

            BufferedReader dataFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintStream dataToClient = new PrintStream(clientSocket.getOutputStream());

            BufferedReader dataFromBackend = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintStream dataToBackend = new PrintStream(serverSocket.getOutputStream());

            String line;
            while ((line = dataFromClient.readLine()) != null) {
                dataToBackend.println(line);

                String responseFromBackend = dataFromBackend.readLine();
                dataToClient.println(responseFromBackend);
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
