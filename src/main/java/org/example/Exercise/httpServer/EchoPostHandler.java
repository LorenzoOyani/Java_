package org.example.Exercise.httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.example.Exercise.httpServer.ParseQuery.parseQuery;

public class EchoPostHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Map<String, Object> parameters = new HashMap<>();
        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
        String query = reader.readLine();
        parseQuery(query, parameters);

        String response = "";
        for (String key : parameters.keySet()) {
            response = STR."\{key}=\{parameters.get(key)}";
        }
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
