package org.example.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ISP -Internet service protocol-Your computer connect to the internet using DSL, dialup, or LAN
 * The computer uses an IP - address to connect to computers on the internet.
 * The IP address are usually mapped to a domain name
 * DNS -domain name server converts host-names to IP addresses.
 * IP - internet protocols is a low-level protocol to send data from one computer to another using packets.
 * TCP and UDP - two high-level protocols. the 'TRANSMISSION CONTROL PROTOCOL and the USER DATA-PROTOCOL.
 * TCP - enables two hosts to establish a connection and exchange streams of data.
 * UDP - allows an application program in one computer to send data packets toa other application program in another computer
 * TCP - can detect lost transmission and re-submit them.
 * Sockets are the logical connections between two host end-points that is used to transfer streams of data to-fro.
 * Client and servers communicates through sockets
 * To establish a server, you need to create a serverSocket and attach it to a port.
 * A port number ranges from 0 to 65536
 */

public class Sockets {

    private Socket socket = null;
    private DataInputStream dataInputStream = null;
    private DataOutputStream dataOutputStream = null;

    public Sockets(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("connected");

            dataInputStream = new DataInputStream(System.in);

            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        String line = "";

        while (!line.equals("End")) {
            try {
                dataOutputStream.writeUTF(line);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Sockets sockets = new Sockets("127.0.0.1", 8080);
    }

}


