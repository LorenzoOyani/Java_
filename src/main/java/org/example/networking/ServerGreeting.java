package org.example.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerGreeting {
    private Socket socket = null;
    private static PrintWriter out = null;
    private static BufferedReader bufferedReaderIn = null;

    public void startConnection(String address, int port) throws IOException {
        socket = new Socket(address, port);
        System.out.println("connected");
        out = new PrintWriter(socket.getOutputStream(), true);
        bufferedReaderIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public static String sendMessage(String msg) throws IOException {
        out.println(msg);
        return bufferedReaderIn.readLine();
    }

    public void stop() throws IOException {
        out.close();
        bufferedReaderIn.close();
        socket.close();

    }
}
