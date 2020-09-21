package org.anefdef;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TCPServer {

    private static final int GATEWAY_PORT = 4000;
    private static final int BALANCER_PORT = 4000;
    private static final AtomicInteger loading = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {

        ExecutorService pool = Executors.newFixedThreadPool(5);

        ServerSocket gatewaySocket = new ServerSocket(GATEWAY_PORT);

        sendingLoadingDataToLoadingBalancer(gatewaySocket);

        while (true) {
            Socket socket = gatewaySocket.accept();

            Runnable serverTask = new TCPServerTask(socket);
            pool.execute(serverTask);
            loading.incrementAndGet();
        }
    }

    private static void sendingLoadingDataToLoadingBalancer(ServerSocket socket) throws IOException {
        DatagramSocket loadBalancerSocket = new DatagramSocket(BALANCER_PORT);

        while(true) {
            // creating string to combine data in
            String sendingDataAsString = socket.getInetAddress().toString() + ":" + socket.getLocalPort() + loading.toString();
            // creating packet to send
            DatagramPacket sendingPacket = new DatagramPacket(
                    sendingDataAsString.getBytes(),
                    sendingDataAsString.length());
            loadBalancerSocket.send(sendingPacket);
        }
    }

    public static void decrementLoading() {
        loading.decrementAndGet();
    }
}
