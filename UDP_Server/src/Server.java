import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    private static final int INCOMING_DATAGRAM_SIZE = 1024;
    private static final int SERVER_PORT = 4000;

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(SERVER_PORT);

        byte[] dataIN = new byte[INCOMING_DATAGRAM_SIZE];

        DatagramPacket packetIN = new DatagramPacket(dataIN,dataIN.length);

        while (true) {
            socket.receive(packetIN);
            String body = new String(dataIN,0,packetIN.getLength());

            String response = InetAddress.getLocalHost().toString() + ":" + SERVER_PORT + " " + body;

            DatagramPacket packetOut = new DatagramPacket(
                    response.getBytes(),
                    response.length(),
                    packetIN.getAddress(),
                    packetIN.getPort());
            socket.send(packetOut);
        }
    }
}
