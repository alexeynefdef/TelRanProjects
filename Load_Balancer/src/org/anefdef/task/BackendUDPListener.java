package org.anefdef.task;

import org.anefdef.backend.BackendServerEntity;
import org.anefdef.backend.IBackendServerStorage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BackendUDPListener implements Runnable {

    private final IBackendServerStorage storage;
    private final int udpPort;

    public BackendUDPListener(IBackendServerStorage storage, int udpPort) {
        this.storage = storage;
        this.udpPort = udpPort;
    }

    @Override
    public void run() {

        try {

            DatagramSocket socket = new DatagramSocket(udpPort);

            byte[] dataIN = new byte[1024];

            DatagramPacket packetIN = new DatagramPacket(dataIN,dataIN.length);

            while (true) {
                socket.receive(packetIN);
                String body = new String(dataIN,0,packetIN.getLength());
                BackendServerEntity backend = mapDataToBackend(body);
                storage.update(backend);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BackendServerEntity mapDataToBackend(String body) {
        String[] serverDataAndLoad =  body.split("#");
        String[] hostAndPort = serverDataAndLoad[0].split(":");
        BackendServerEntity res = new BackendServerEntity(Integer.parseInt(hostAndPort[1]), hostAndPort[0]);
        res.setLoad(Integer.parseInt(serverDataAndLoad[0]));
        return res;
    }
}
