package org.example.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketCmd {
    private static Socket socket = null; // server-side socket connection.
    private static PrintWriter out = null;
    private static ServerSocket serverSocket = null;

//    private final DataOutputStream dataOutputStream = null;

    private static BufferedReader bufferedReader = null;
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("usage: Client to server connection. ");
            System.exit(1);
        }
        int port = Integer.parseInt(args[1]);

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server running...");

            System.out.println("waiting on client connection...");
            socket = serverSocket.accept(); // accept to establish connection.
            System.out.println("connected");

            out = new PrintWriter(socket.getOutputStream(), true); // Flush the remaining bytes from the OutPutStream.
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));



        } catch (IOException e) {
            System.out.println(STR." \{e.getMessage()}");
        }

        String line, outputLine;
        while ((line = bufferedReader.readLine()) != null) {
            out.println(line);
            if (line.equals("end")) {
                break;
            }
        }

    }
}
