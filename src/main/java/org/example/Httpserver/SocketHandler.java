package org.example.Httpserver;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketHandler implements Runnable {

    private final Socket socket;
    private Handler defualtHandler;
    private Map<String, Map<String, Handler>> handlers = new HashMap<>();

    SocketHandler(Socket socket, Map<String, Map<String, Handler>> handlers) {
        this.socket = socket;
        this.handlers = handlers;

    }

    public void respond(int statusCode, String statusMessage, OutputStream out) throws IOException {
        out.write((STR."HTTP/1.1\{statusCode} \{statusMessage}\r\n").getBytes());
        out.write("\r\n".getBytes());

    }


    @Override
    public void run() {
        BufferedReader in = null;
        OutputStream out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedOutputStream(socket.getOutputStream());

            Request request = new Request(in);
            if (!request.parse()) {
                respond(500, "unable to parse the request", out);
                return;
            }
            Response response = new Response(out);
            Map<String, Handler> methodHandlers = handlers.get(request.getMethod());
            if (methodHandlers == null) {
                respond(405, "method specified not allowed", out);
                return;
            }
            boolean foundPath = false;
            for (String handlePath : methodHandlers.keySet()) {
                if (handlePath.equals(request.getPath())) {
                    methodHandlers.get(request.getPath()).Handle(request, response);
                    response.send();
                    foundPath = true;
                    break;

                }

            }
            if (!foundPath) {
                if (methodHandlers.get("/*") != null) {
                    methodHandlers.get("/*").Handle(request, response);
                    response.send();

                } else {
                    respond(404, "server cant find request path", out);
                }
            }

        } catch (IOException e) {
            try {
                if (socket != null) socket.close();
                respond(500, "internal server error", out);
            } catch (IOException e1) {
                try {
                    e1.printStackTrace();
                    if (socket != null) socket.close();
                    if (out != null) out.close();
                    if (in != null) in.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
