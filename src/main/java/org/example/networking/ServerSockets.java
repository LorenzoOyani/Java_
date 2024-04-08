package org.example.networking;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockets {
    private Socket socket = null;
    private DataInputStream dataInputStream = null;
    private ServerSocket serverSockets = null;

    public ServerSockets(int port) {
        try {
            serverSockets = new ServerSocket(port);
            System.out.println("server started...");

            System.out.println("waiting on client connection.");
            socket = serverSockets.accept();
            System.out.println("client connected.");

            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String line = "";
        try {
            while (!line.equals("End")) {
                line = dataInputStream.readUTF();
                System.out.println(line); // output from the server.
            }
            socket.close();
            dataInputStream.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        ServerSockets serverSockets1 = new ServerSockets(8080);
    }
}
