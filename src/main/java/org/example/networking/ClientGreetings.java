package org.example.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientGreetings {
    private ServerSocket serverSocket = null;
    private PrintWriter printWriter = null;
    private Socket socket = null;
    private BufferedReader bufferedReaderIn = null;



    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("server up and running...");

        System.out.println("waiting on client connection.");
        socket = serverSocket.accept();
        System.out.println("connected");
        printWriter = new PrintWriter(socket.getOutputStream());

        bufferedReaderIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String greetings = bufferedReaderIn.readLine();

        if ("Hello server".equals(greetings)) {
            System.out.println("Hello client");
        } else {
            System.out.println("Greetings no allowed here");
        }


    }

    public void stop() {
        try {
            printWriter.close();
            socket.close();
            bufferedReaderIn.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}