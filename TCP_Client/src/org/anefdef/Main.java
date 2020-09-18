package org.anefdef;

import java.io.*;
import java.net.Socket;

public class Main {

    static final String SERVER_HOST = "localhost";
    static final int SERVER_PORT = 3000;

    public static void main(String[] args) throws IOException {
        //InetAddress[] address = InetAddress.getAllByName(SERVER_HOST);
        Socket socket = new Socket(SERVER_HOST,SERVER_PORT);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        // sends data to server
        PrintStream socketOutput =  new PrintStream(socket.getOutputStream());
        // receives data from server
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        // read lines from console
        while ((line = consoleReader.readLine()) != null && !line.equals("exit")) {
            // send line to the server
            socketOutput.println(line);
            // waiting for response from the server
            String response = socketInput.readLine();
            System.out.println(response);
        }
        socket.close();
    }
}
