package org.example.Exercise.httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class EchoGetHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Map<String, Object> parameters = new HashMap<>();
        URI requestUri = exchange.getRequestURI();
        String query = requestUri.getRawQuery();
        ParseQuery.parseQuery(query, parameters);

        String response = "";
        for (String key : parameters.keySet()) {
            response = key + "=" + parameters.get(key) + "\n";
        }
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();


    }
}
