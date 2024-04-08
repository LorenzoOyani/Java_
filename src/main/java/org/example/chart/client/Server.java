package org.example.chart.client;

import org.example.networking.ServerSockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int port;
    private static Socket socket = null;
    private static ServerSocket serverSocket = null;
    private static ClientHandler clientHandler = null;

    Server(int port) {
        this.port = port;

    }

    public static void init() {
        try {

            while (true) {
//                assert socket != null;
                assert false;
                if (!socket.isConnected()) break;
                serverSocket = new ServerSocket(port);
                socket = serverSocket.accept();


                clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();

            }

        } catch (IOException e) {
            closeSocket();
        }
    }

    public static void closeSocket() {
        try {
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
      Server server = new Server(8080);
//      server

    }
}
