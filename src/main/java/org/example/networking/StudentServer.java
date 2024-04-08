package org.example.networking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {
    private Socket socket = null;
    private ObjectInputStream objectInputStream = null;
    private ObjectOutputStream objectOutputStream = null;

    StudentServer() throws IOException, ClassNotFoundException {

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.txt", true));
            ServerSocket serverSockets = new ServerSocket(8080);
            while (true) {
                socket = serverSockets.accept();
                System.out.println("connected to client socket successfully");

            }

        }finally {
            assert objectOutputStream !=null;
            objectOutputStream.close();
        }
    }
}
