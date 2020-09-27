package org.anefdef;

import org.anefdef.task.BalancerUpdater;
import org.anefdef.task.GatewayTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Backend {

    private static final int BALANCER_PORT = 5001;
    static final String BALANCER_HOST = "localhost";
    private static final int DEFAULT_BACKEND_PORT = 3000;
    private static final AtomicInteger loading = new AtomicInteger(0);

    public static AtomicInteger getLoading() {
        return loading;
    }

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        // B A L A N C E R   T A S K
        Runnable udpThread = new BalancerUpdater(BALANCER_HOST, BALANCER_PORT);
        pool.execute(udpThread);




        // G A T E W A Y   T A S K
        int serverPort = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_BACKEND_PORT;

        // the object witch reserves a certain part
        // and then listens for the new connections
        ServerSocket serverSocket = new ServerSocket(serverPort);

        while(true) {
            // the server accepts a connection
            Socket socket = serverSocket.accept();

            Runnable gatewayTask = new GatewayTask(socket);
            pool.execute(gatewayTask);
            loading.incrementAndGet();

        }


    }
}
