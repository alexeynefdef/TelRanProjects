package org.anefdef;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GatewayTask implements Runnable {

    private final int clientPort;
    private final BackendCoordinatesStorage storage;

    public GatewayTask(BackendCoordinatesStorage storage, int clientPort) {
        this.storage = storage;
        this.clientPort = clientPort;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(clientPort);
            while (true) {
                // the server accepts a connection
                Socket clientSocket = serverSocket.accept();

                TCPProxyTask proxyTask = new TCPProxyTask(storage,clientSocket);
                Thread TCPProxyProcess = new Thread(proxyTask);
                TCPProxyProcess.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
