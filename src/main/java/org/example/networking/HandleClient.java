package org.example.networking;

import java.io.*;
import java.net.Socket;

/**
 * Sending and receiving primitive data from
 * */

public class HandleClient implements Runnable{
    private Socket socket = null; // Object type.


    HandleClient(Socket sockets) {
        this.socket = sockets;
    }
    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            while (true) {
                double radius = dataInputStream.readDouble();

                double area = radius * radius * Math.PI;

                dataOutputStream.writeDouble(area);
                System.out.println("The radius recieved from client "+ radius +"\n");
                System.out.println("Area found "+ area + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
