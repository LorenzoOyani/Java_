package org.example.networking;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class InetAdders {
    public static void main(String[] args) {
//        Socket socket = new Socket();
//
//            java.net.InetAddress address = socket.getInetAddress();
//        System.out.println(address.getHostAddress());
//        if(args.length != 1)
        for (int i = 0; i < args.length; i++) {
            try {
                InetAddress address = InetAddress.getByName(args[i]);
                System.out.println(STR."Host name \{address.getHostName()}");
                System.out.println(STR."IP address \{address.getHostAddress()}");
            } catch (UnknownHostException e) {
                System.out.println(STR."unknown Ip Address \{args[i]}");
                System.out.println(e.getMessage());
            }
        }
    }
}
