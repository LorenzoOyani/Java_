package org.example.Exercise.httpServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {

    private static int port = 8080;
    public static void httpServer() throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(port), 0);
        server.createContext("/", new RootHandler());
        server.createContext("/echoHeader", new EchoHeader());
        server.createContext("/echoGet", new EchoGetHandler());
        server.createContext("/echoPost", new EchoPostHandler());
    }
}
