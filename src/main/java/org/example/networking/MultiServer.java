package org.example.networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiServer {
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private final PrintWriter output = null;


    public void ServerConnection() {
        AtomicInteger clientNo = new AtomicInteger();
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(8080);
                System.out.println("waiting on client...");
                while (true) {
                    clientNo.getAndIncrement();
                    socket = serverSocket.accept();
                    System.out.println("starting thread for client " + clientNo + "at" + new Date() + "\n");

                    InetAddress inetAddress = socket.getInetAddress();
                    System.out.println("client " + clientNo + inetAddress.getHostName());
                    System.out.println("client IP address" + clientNo + inetAddress.getHostAddress());
                }

            } catch (IOException e) {
                System.out.println("cant connect to socket with port  number");
            }
        }).start();
        new Thread(new HandleClient(socket)).start();

    }

}


