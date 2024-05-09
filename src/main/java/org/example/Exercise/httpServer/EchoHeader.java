package org.example.Exercise.httpServer;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
using the Header class to process the header requests, this utilises the Http request-response .
* Process the Header parameter
An immutable request Headers can be created to get the headers containing key/value pairs.
* Query the string
* send the response.
*/

public class EchoHeader implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getRequestHeaders(); // get the requested Headers of keys/value pairs.
        Set<Map.Entry<String, List<String>>> entry = headers.entrySet();
        String response = "";
        for (Map.Entry<String, List<String>> entries : entry) {
            response = STR."\{entries.toString()}\n";
        }
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

//        Runtime.getRuntime();

    }
}
