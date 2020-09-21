package org.anefdef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class GatewayTask implements Runnable {

    Socket clientSocket;
    Socket serverSocket;

    public GatewayTask(Socket clientSocket, Socket serverSocket) {
        this.clientSocket = clientSocket;
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            PrintStream socketOutput =  new PrintStream(serverSocket.getOutputStream());
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line;
            while((line = socketInput.readLine()) != null) {
                socketOutput.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
