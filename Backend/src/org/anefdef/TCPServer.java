package org.anefdef;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TCPServer {

    private static final int GATEWAY_PORT = 6000;
    private static final int BALANCER_PORT = 3300;
    private static final AtomicInteger loading = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        ServerSocket gatewaySocket = new ServerSocket(GATEWAY_PORT);

        while (true) {
            Socket socket = gatewaySocket.accept();
            Runnable serverTask = new TCPServerTask(socket);
            pool.execute(serverTask);
            loading.incrementAndGet();
            DatagramSocket loadBalancerSocket = new DatagramSocket(BALANCER_PORT);
            // creating string to combine data in
            String sendingDataAsString = socket.getInetAddress().toString() + ":" + socket.getLocalPort() + loading.toString();
            // creating packet to send
            DatagramPacket sendingPacket = new DatagramPacket(
                    sendingDataAsString.getBytes(),
                    sendingDataAsString.length(),
                    socket.getInetAddress(),
                    socket.getLocalPort());
            loadBalancerSocket.send(sendingPacket);
        }
    }

    public static void decrementLoading() {
        loading.decrementAndGet();
    }
}
