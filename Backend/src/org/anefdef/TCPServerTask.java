package org.anefdef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TCPServerTask implements Runnable {

    private final Socket socket;

    public TCPServerTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintStream socketOutput =  new PrintStream(socket.getOutputStream());
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while((line = socketInput.readLine()) != null) {
                String response = String.format("Received on SERVER: %s", line);
                socketOutput.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                TCPServer.decrementLoading();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
