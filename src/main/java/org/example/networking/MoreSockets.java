package org.example.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * This example, reads an Object from the server and show to the client. a request/ response sequence.
 */
public class MoreSockets implements Runnable {

    private static BufferedReader bufferedReader = null;
    private static Socket socket = null;
    private static final DataOutputStream dataOutputStream = null;
    private static PrintWriter output = null;

    public static void main(String[] args) {
        new MoreSockets().start();
    }

    void start() {
        Thread thread = new Thread(new MoreSockets());
        thread.start();

        Scanner input = new Scanner(in);

        System.out.println("press the Enter key to connect to the server: ");

        input.nextLine();

        try {
            socket = new Socket("LocalHost", 8080);
            System.out.println("waiting on client connection...");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true); // always flush your socket for output streams
            output.println(new Date()); // send date data to the server.
        } catch (IOException e) {
            System.out.println(STR."Error connecting to server: \{e.getMessage()}");
        } finally {
            catchAllErrors();
        }
        try {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Reading from the server...");
                dataOutputStream.writeBytes(line);
                if (line.equals("end")) {
                    System.out.println("viola!");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            catchAllErrors();
        }


    }

    public void catchAllErrors() {
        try {
            if (bufferedReader != null) bufferedReader.close();
            if (dataOutputStream != null) dataOutputStream.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                System.out.println("waiting on client connection...");
                socket = serverSocket.accept();
                System.out.println("connected!");

                output = new PrintWriter(socket.getOutputStream(), true);
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.equals("getDate")) {
                        System.out.println("writing to client...");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeObject(new Date());
                    } else {
                        if (line.equals("end")) {
                            System.out.println("client-side connection ended");
                            break;
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                catchAllErrors();
            }


        }


    }
}