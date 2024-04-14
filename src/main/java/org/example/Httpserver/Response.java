package org.example.Httpserver;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Response {
    private final OutputStream out;
    private int statusCode;
    private String statusMessage;
    private final Map<String, String> headers = new HashMap<>();
    private String body;

    Response(OutputStream out) {
        this.out = out;
    }


    /* A response code for the server*/
    public void setResponseCode(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public void addBody(String body) {
        headers.put("content-length", String.valueOf(body.length()));
        this.body = body;

    }

    public String addHeader(String headerKeys, String headerValue) {
        return headers.put(headerKeys, headerValue);
    }


    public void send() throws IOException {
        headers.put("connection", "close");
        out.write((STR."HTTP/1.1\{statusCode} \{statusMessage}\r\n").getBytes());
        for (String headerName : headers.keySet()) {
            out.write((STR."\{headerName}:\{headers.get(headerName)}\r\n").getBytes());
        }
        out.write("\r\n".getBytes());
        assert body != null;
        out.write(body.getBytes());

    }


}
