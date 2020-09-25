package org.anefdef.task;

import org.anefdef.backend.BackendServerEntity;
import org.anefdef.backend.IBackendServerStorage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GatewayUDPSupplier implements Runnable {

    private final String gatewayHost;
    private final int gatewayUDPPort;
    private final int sendingPeriodMillis;
    private final IBackendServerStorage storage;

    public GatewayUDPSupplier(String gatewayHost,
                              int gatewayUDPPort,
                              IBackendServerStorage storage,
                              int sendingPeriodMillis) {
        this.gatewayHost = gatewayHost;
        this.gatewayUDPPort = gatewayUDPPort;
        this.storage = storage;
        this.sendingPeriodMillis = sendingPeriodMillis;
    }

    @Override
    public void run() {

        try {

            InetAddress serverAddress = InetAddress.getByName(gatewayHost);

            DatagramSocket socket = new DatagramSocket();

            while (true) {
                try {
                    Thread.sleep(sendingPeriodMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                BackendServerEntity optimalBackend = storage.getOptimal();
                if (optimalBackend == null) {
                    continue;
                }
                byte[] dataOut = storage.getOptimal().toString().getBytes();
                DatagramPacket packetOut = new DatagramPacket(
                        dataOut,
                        dataOut.length,
                        serverAddress,
                        gatewayUDPPort
                );


                socket.send(packetOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
