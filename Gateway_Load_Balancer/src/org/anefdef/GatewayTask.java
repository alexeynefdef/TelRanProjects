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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
