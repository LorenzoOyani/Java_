package org.example.chart.client;

import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClientHandler implements Runnable {
    private static final CopyOnWriteArrayList<ClientHandler> clientLists = new CopyOnWriteArrayList<>();
    private final Commands[] commands = Commands.values();
    private BufferedReader reader;
    private PrintWriter writer;
    private Socket socket;
    private String userName;

    ClientHandler(Socket socket) {

//        HttpServer server = HttpServer.create()
        try {
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream());
            this.userName = reader.readLine();
            clientLists.add(this);


            broadCastMessage(STR."SERVER: \{userName}has joined the chat");

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void broadCastMessage(String message) {
        for (ClientHandler client : clientLists) {
            if (client.userName.equals(userName)) {
                writer.println(message);
            }
        }
    }


    @Override
    public void run() {

        String messageClient;

        while (socket.isConnected()) {
            try {
                messageClient = reader.readLine();
                if (messageClient == null) {
                    closeEverything();
                    break;
                }
                if (!executeCommand(messageClient)) {
                    broadCastMessage(messageClient);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public boolean executeCommand(String messageClient) throws IOException {
        if (messageClient.equalsIgnoreCase(STR."\{userName}: /quit")) {
            closeEverything();
            return false;
        }
        if (messageClient.equalsIgnoreCase(STR."\{userName}: /list")) {
            executeListCommand();
            return true;
        }
        if (messageClient.contains(STR."\{userName}: /whisper")) {
            executeWhisperCommand(messageClient);
            return true;
        }
        if (messageClient.contains(STR."\{userName}:/name")) {
            executeNameCommand(messageClient);
            return true;
        }
        if (messageClient.equalsIgnoreCase(STR."\{userName} /help")) {
            executeHelpCommand();
            return true;
        }
        return false;
    }

    public void executeListCommand() throws IOException {
        System.out.println(STR."\{userName}asked for the list commands");
        writer.println(clientLists);
    }

    public void executeWhisperCommand(String messageClient) throws IOException {
        String newUserName = messageClient.split("\\s")[2];
        System.out.println(STR."\{userName} wants to send message to \{newUserName}");

        int aux = messageClient.indexOf(newUserName);
        String whisper = messageClient.substring(aux + newUserName.length() + 1);

        for (ClientHandler client : clientLists) {
            if (client.userName.equals(newUserName)) {
                client.writer.println(whisper);
            }
        }


    }

    public void executeNameCommand(String messageClient) {
        String newUsername = messageClient.split(" ")[2];
        System.out.println(STR."\{userName}has changed his name to \{newUsername}");
        broadCastMessage(STR."\{userName} has changed his name to \{newUsername}");
        setUserName(newUsername);
    }

    public void executeHelpCommand() throws IOException {
        System.out.println(STR."\{userName}asked for help");

        for (Commands commands1 : commands) {
            writer.println(STR."\{commands1}:\{commands1.getDescription()}");
        }
    }

    public void removeClient() {
        clientLists.remove(this);
        broadCastMessage(STR."SERVER: \{userName} removed from chat!");
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void closeEverything() {
        removeClient();
        try {
            if (reader != null) reader.close();
            if (socket != null) socket.close();
            if (writer != null) writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
