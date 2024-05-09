package org.example.Httpserver;

/*
An http server has a port name to connect to the client using the serverSockets
an httpServer has a port, a handle function to get the methods, paths and handlers function.

 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpServer {
    private int port = 8080;
    Map<String, Map<String, Handler>> handlers = new HashMap<>();

    HttpServer(int port) {
        this.port = port;
    }

    public void addHandler(String method, String path, Handler handler) {
       Map<String, Handler> methodHandlers = handlers.get(method);
        if (methodHandlers == null) {
            methodHandlers = new HashMap<>();
            handlers.put(method, methodHandlers );
        }
        methodHandlers.put(path, handler);
    }

    public void start() throws IOException {

        try(ServerSocket server = new ServerSocket(port)){
            System.out.println("server up and running...");
            Socket client;
            while ((client = server.accept()) != null) {
                System.out.println(STR."Receving connections from \{client.getRemoteSocketAddress().toString()}");
                SocketHandler socketHandler = new SocketHandler(client, handlers);
                Thread thread = new Thread(socketHandler);
                thread.start();
            }
        }


    }

    public static void main(String[] args) {
        HttpServer server = new HttpServer(8080);
        server.addHandler("/GET", "/hello", new Handler() {
            @Override
            public void Handle(Request request, Response response) {
                String html = STR."Requested url worked \{request.getQueryParameters("http:/www.facebook.com")}";
                response.setResponseCode(200, "ok");
                response.addHeader("content-type", "text/html");
                response.addBody(html);
            }
        });
    }




}
