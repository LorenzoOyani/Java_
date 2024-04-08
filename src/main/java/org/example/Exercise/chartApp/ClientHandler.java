package org.example.Exercise.chartApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClientHandler implements Runnable {
    private final CopyOnWriteArrayList<ClientHandler> clientLists = new CopyOnWriteArrayList<>();
    private BufferedReader reader = null;
    private PrintWriter writer = null;
    private String username;
    private Socket socket;


    ClientHandler(Socket socket) {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            this.username = reader.readLine();
            clientLists.add(this);

            broadCastMessage(STR."This client with username: \{username} joined the chat!");

        } catch (IOException e) {
            closeEverything();
        }

    }

    public void broadCastMessage(String message) {
        for (ClientHandler client : clientLists) {
            if (client.username.equals(username)) {
                client.writer.println(message);
            }
        }

    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        String clientMessages;

        while (socket.isConnected()) {
            try {
                clientMessages = reader.readLine();
                if (clientMessages == null) {
                    closeEverything();
                    break;
                }
                if (!executeCommand(clientMessages)) {
                    broadCastMessage(clientMessages);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public boolean executeCommand(String clientMessage) {
        return switch (clientMessage) {
            case "/quit" -> {
                closeEverything();
                yield false;
            }
            case "/list" -> {
                executeListCommand();
                yield true;
            }
            case "/whisper" -> {
                executeWhisperCommand(clientMessage);
                yield true;
            }
            case "/name" -> {
                executeNameCommand(clientMessage);
                yield true;
            }
            default -> true;
        };
    }

    public void executeListCommand() {
        System.out.println(STR."This user with \{username}as for the list");
        writer.println(clientLists);
    }

    public void executeWhisperCommand(String clientMessage) {
        String newUser = clientMessage.split("\\s")[2];
        System.out.println(STR."\{username} wants to send a messsage to \{newUser}");
        int auxUser = clientMessage.indexOf(newUser);
        String whisper = clientMessage.substring(auxUser, newUser.length() + 1);
        for (ClientHandler client : clientLists) {
            if (client.username.equals(newUser)) {
                client.writer.println(whisper);
            }
        }
    }

    public void executeNameCommand(String clientMessage) {
        String newUser = clientMessage.split("\\s")[2];
        System.out.println(STR."\{username} is changed to \{newUser}");
        broadCastMessage(STR."\{username} is changed to \{newUser}");
        setUsername(newUser);
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
}
