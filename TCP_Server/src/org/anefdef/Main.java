package org.anefdef;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static final int SERVER_PORT = 3000;

    public static void main(String[] args) throws IOException {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        // the object witch reserves a certain part
        // and then listens for the new connections
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        while(true) {
            // the server accepts a connection
            Socket socket = serverSocket.accept();

            Runnable serverTask = new ServerTask(socket);
            pool.execute(serverTask);
        }
    }
}
