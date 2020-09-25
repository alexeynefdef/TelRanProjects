package org.anefdef;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TCPServer {

    private static final int DEFAULT_BACKEND_PORT = 3000;
    private static int GATEWAY_PORT = 4000;
    private static final int BALANCER_PORT = 5002;
    private static final AtomicInteger loading = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {

       int serverPort = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_BACKEND_PORT;

        ExecutorService pool = Executors.newFixedThreadPool(10);

        ServerSocket gatewaySocket = new ServerSocket(GATEWAY_PORT++);

        while (true) {
            Socket socket = gatewaySocket.accept();
            Runnable serverTask = new BackendTask(socket);
            pool.execute(serverTask);

        }
    }
}
