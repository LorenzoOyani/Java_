package org.example.Exercise.httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

//import static org.example.Exercise.httpServer.Server.port;

/*
You send a response header from the Http request - response
*/

public class RootHandler implements HttpHandler {
    private static final int port = 8080;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "<h1>Server started, if you see this message</h1>" + "server started at " + "<h1>" + port + "</h1>";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();


    }
}
