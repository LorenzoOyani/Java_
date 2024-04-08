package org.example.Exercise.chartApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.in;

public class Client {
    private BufferedReader reader = null;
    private PrintWriter writer = null;
    private Socket socket = null;
    private String username;
    private final Scanner keyBoardScanner = null;

    Client(String serverHost, int port, String username) {
        try {
            socket = new Socket(serverHost, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.username = username;
    }

    public void currentRunnableThread(Runnable runnable) {
        new Thread(runnable);

    }

    public void sendMessages() {
        currentRunnableThread(()->{
            String clientMessage = null;
            writer.println(username);
            while (socket.isConnected()) {
                clientMessage = keyBoardScanner.nextLine();
                writer.println(clientMessage);
            }
            assert clientMessage != null;
            switch (clientMessage) {
                case "/name": {
                    String newUsername = clientMessage.split("")[1];
                    setUsername(newUsername);
                }
                case "/exit": {
                    closeEverything();
                }
                default:
                    break;
            }


        });
    }

    public void readMessages() {
        currentRunnableThread(() -> {
            try {
                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println(STR."client messages\n: \{clientMessage}");
                }

            } catch (IOException e) {
                System.out.println(STR."cant get message from client \{e.toString()}");
            } finally {
                closeEverything();
            }
        });
    }

    public void closeEverything() {
        try {
            if (reader != null) reader.close();
            if (socket != null) socket.close();
            if (writer != null) writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }
    void main() {
        Scanner sc = new Scanner(in);
        String username = sc.nextLine();
        Client client = new Client("LocalHost", 8080, username);
        client.sendMessages();
        client.readMessages();



    }
}