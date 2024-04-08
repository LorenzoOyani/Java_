package org.example.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketCmdClient {
    private static Socket socket = null;
    private static BufferedReader bufferedReader = null;
    private static PrintWriter output = null;

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("");
            System.exit(1);
        }

        String address = args[0];
        int port = Integer.parseInt(args[1]);

        try {
//            port = Integer.parseInt(args[1]);
            if (port < 0 || port > 65535) {
                System.out.println("invalid port number, port number should be between 0 to 65535");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.out.println("invalid port number, port number must be an Integer");
            System.out.println(e.getMessage());
        }
        try {
            socket = new Socket(address, port);
            System.out.println("connected");

            output = new PrintWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            System.out.println(STR."cant connect to the server with \{port} number");
        }
        String line;
        while ((line = bufferedReader.readLine() )!= null) {
            output.println(line);
            if (line.equals("end")) {
                break;
            }
        }
        try {
            socket.close();
            bufferedReader.close();
            ;
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
