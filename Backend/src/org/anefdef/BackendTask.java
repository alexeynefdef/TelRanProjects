package org.anefdef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class BackendTask implements Runnable {

    private final Socket socket;

    public BackendTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintStream socketOut = new PrintStream(socket.getOutputStream());

            BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while ((line = socketIn.readLine() ) != null) {
                String response = String.format("Line was received: %s",line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
