package org.example.chart.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.in;

/**
 * Implementing a multi-Threaded program that sends and receive messages to and from the server.
 */

public class Client {
    private static BufferedReader bufferedReader = null;
    private static PrintWriter printWriter = null;
    private Socket socket = null;
    private String userName;
    private Scanner keyboardScanner;

    Client(String serverHost, int port, String userName) {
        try {
            socket = new Socket(serverHost, port);
            System.out.println("waiting on server connection...");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.userName = userName;
    }

    public static void main(String[] args) {
        Scanner keyBoardScanner = new Scanner(in);
        System.out.println("Enter users name: ");
        String userName = keyBoardScanner.nextLine();
        Client client = new Client("localHost", 8080, userName);
        client.sendMessages();
        client.readMessages();

    }

    public void sendMessages() {
        createRunnableThreads(() -> { // expressing instances of a single functional interface using lambda expression.
            printWriter.println(userName);
            String clientMessage;
            while (socket.isConnected()) {
                clientMessage = keyboardScanner.nextLine();
                printWriter.println(clientMessage);

                switch (clientMessage) {
                    case "/name": {
                        String newUserName = clientMessage.split("\\s")[1];
                        setUsername(newUserName);
                    }
                    case "/quit": {
                        closeEverything();
                    }
                    default:
                        break;
                }
            }
        });
    }
    public void readMessages() {
        createRunnableThreads(() -> {
            try {
                String groupChartMessage;
                while ((groupChartMessage = bufferedReader.readLine()) != null) {
                    System.out.println(groupChartMessage);
                }
            } catch (IOException e) {
                System.out.println(STR."Error reading from group: \{e.getMessage()}");

            } finally {
                closeEverything();
            }

        });
    }

    public void closeEverything() {
        try {
            if (bufferedReader != null) bufferedReader.close();
            if (socket != null) socket.close();
            if (printWriter != null) printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public void createRunnableThreads(Runnable runnable) {
        new Thread(runnable).start();

    }

}
